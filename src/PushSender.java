import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;
import org.eclipse.jetty.client.util.BytesContentProvider;
import org.eclipse.jetty.http.HttpFields;

import java.util.HashMap;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 10/08/13
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */

public class PushSender {


    public static void sendPush(String pushuri, String payload, HashMap<String, String> headers, final CancellableCallback cancellableCallback) {
        System.out.println("Inside sendPush");

        Request request = Client.getInstance().POST(pushuri);


        Set<String> headerKeys = headers.keySet();
        for (String key : headerKeys) {
            request.header(key, headers.get(key));
        }

        request.content(new BytesContentProvider(payload.getBytes()), "text/xml")
                .send(new BufferingResponseListener() {
                    @Override
                    public void onComplete(Result result) {
                        if (!cancellableCallback.isCancelled()) {
                            System.out.println("Status code: "+result.getResponse().getStatus());
                            if (result.isFailed()) {
                                System.out.println("result has isFailed set");
                                cancellableCallback.onFailure(result);
                            } else {
                                if (result.getResponse().getStatus() == 200) {
                                    HttpFields httpFields = result.getResponse().getHeaders();
                                    System.out.println(DeviceConnectionStatus.X_DEVICE_CONNECTION_STATUS+""+httpFields.get(DeviceConnectionStatus.X_DEVICE_CONNECTION_STATUS));

                                    System.out.println(NotificationStatus.X_NOTIFICATION_STATUS+""+ httpFields.get(NotificationStatus.X_NOTIFICATION_STATUS));

                                    System.out.println(SubscriptionStatus.X_SUBSCRIPTION_STATUS+""+ httpFields.get(SubscriptionStatus.X_SUBSCRIPTION_STATUS));
                                    cancellableCallback.onSuccess(result);
                                } else {
                                    cancellableCallback.onFailure(result);
                                }
                            }
                        }
                    }
                });
    }
}