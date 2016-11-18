package nl.rabobank;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Search {

    public void search(final String key) {

        Twitter twitter = new TwitterFactory().getInstance();

        AccessToken accessToken = new AccessToken("176128095-AClNXpy2Gm6RNsGaecXnswstFz4jJ8HMaAHq1KeM",
                "Mtmw3cfwqJE5JtsBmV91evFGwiz3JaCmnHk4wReQ92q5f");
        twitter.setOAuthConsumer("mqUyUcGBTDx5SDml3bdKgn1xO", "NFGcENE985DQMUcfUuTVoGE60xcAWtGBfizDaKHzL7wFQFUULr");
        twitter.setOAuthAccessToken(accessToken);

        try {
            Query query = new Query(key);
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
    
    
   

}
