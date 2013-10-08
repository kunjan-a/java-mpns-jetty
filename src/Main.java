import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: kunjan
 * Date: 8/10/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        String pushuri="https://am3.notify.live.net/unthrottledthirdparty/01.00/AQH-O-JEL4gMSJFVsV8U1AaBAgAAAAADXw8DAAQUZm52OkYxRkFDRDhBQkFBNUI3RjcFBkxFR0FDWQ";
        //String pushuri="https://172.16.42.25:9999";
        String payload = "<?xml version=\"1.0\" encoding=\"utf-8\"?><wp:Notification xmlns:wp=\"WPNotification\"><wp:Toast><wp:Text1>Title</wp:Text1><wp:Text2>Test message</wp:Text2><wp:Param>/InermediatePage.xaml</wp:Param></wp:Toast></wp:Notification>";
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("x-windowsphone-target","2");
        headers.put("x-notificationclass","2");
        PushSender.sendPush(pushuri,payload,headers,new CancellableCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(Object result) {
                System.out.println("Failure");
            }
        });
    }
}
