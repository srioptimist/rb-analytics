# rb-analytics
How to run this application ?

1. Download and install maven https://maven.apache.org/install.html
2. Run mvn clean install tomcat7:run
3. Invoke the url (http://)

# Facebook certificate installtion
If you get "unable to find valid certification path to requested target", then try to download the certificate from https://www.facebook.com
and install the certificate using keytool. The key tool command is given below.

## Keytool command

keytool -import -alias fb -keystore JDK_PATH/lib/security/cacerts -file PATH_OF_CERTIFICATE
