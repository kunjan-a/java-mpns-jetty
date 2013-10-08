import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import java.nio.file.FileSystems;

/**
 * Created with IntelliJ IDEA.
 * User: sandeep
 * Date: 07/08/13
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */


public class Client {

    private static HttpClient _httpClient;


    public static HttpClient getInstance() {
        if (_httpClient == null) {
            // Instantiate and configure the SslContextFactory
            SslContextFactory sslContextFactory = new SslContextFactory(true);
            String separator = FileSystems.getDefault().getSeparator();

            sslContextFactory.setKeyStorePath("certificate"+separator+"PushCertificates"+separator+"talk.to_ca_root.p12"); //Contains client's private and public key pair
            sslContextFactory.setKeyStorePassword("directi");
            sslContextFactory.setKeyStoreType("PKCS12");
//            sslContextFactory.setTrustStorePath(""); // Contains client's public key

            _httpClient = new HttpClient(sslContextFactory);
            //_httpClient = new HttpClient();
            _httpClient.setMaxConnectionsPerDestination(25);
            try {
                _httpClient.start();
            } catch (Exception e) {
                System.out.println("Couldn't start jetty httpclient due to "+ e.toString());
            }
        }
        return _httpClient;
    }

/*
    private static KeyStore getKeyStore() {
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream keystoreStream = HttpClientHelper.class.getClassLoader().getResourceAsStream(KEYSTORE_NAME); // note, not getSYSTEMResourceAsStream
        keystore.load(keystoreStream, DEFAULT_JAVA_KEYSTORE_PW.toCharArray());
    }
*/
}
