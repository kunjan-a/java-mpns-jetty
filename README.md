java-mpns-jetty
===============
cd into certificate/PushCertificates

Copy talk.to.key inside certificate/PushCertificates

Use openssl to create the key file in PKCS12 style:
 openssl pkcs12 -inkey talk.to.key -in talk.to.crt -export -out talk.to_ca.p12 -certfile ca.crt


 But despite this I am not able to complete the SSl handshake
