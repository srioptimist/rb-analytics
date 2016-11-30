# rb-analytics
# Use full commands regarding key-tool

#checking the list of certificates installed in jdk

keytool -list -keystore C:/"Program Files"/Java/jdk1.8.0_111/jre/lib/security/cacerts

#installing new certificate in jdk
keytool -import -alias new-fb-feed -keystore C:/"Program Files"/Java/jdk1.8.0_111/jre/lib/security/cacerts -file C:/Tools/new-fb-feed.cer

#deleting existing keytool
keytool -delete -alias feed-cert -keystore C:/"Program Files"/Java/jdk1.8.0_111/jre/lib/security/cacerts -file C:/Tools/feed-cert.cer
