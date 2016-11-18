package nl.rabobank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Path("/rbAnalytics")
public class RbAnalyticsRestService extends Main{

    @GET
    @Path("/{searchText}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResults(@PathParam("searchText") final String searchText) throws IOException {

       // Twitter twitter = new TwitterFactory().getInstance();

       // AccessToken accessToken = new AccessToken("176128095-AClNXpy2Gm6RNsGaecXnswstFz4jJ8HMaAHq1KeM",
          //      "Mtmw3cfwqJE5JtsBmV91evFGwiz3JaCmnHk4wReQ92q5f");
      ////  twitter.setOAuthConsumer("mqUyUcGBTDx5SDml3bdKgn1xO", "NFGcENE985DQMUcfUuTVoGE60xcAWtGBfizDaKHzL7wFQFUULr");
      //  twitter.setOAuthAccessToken(accessToken);
      //  List<String> tweets = new ArrayList<String>();
        final List<Tweet> tweets = getTweets(searchText);
        return Response.status(Response.Status.OK).entity(tweets).build();

        /* try {
           
          Query query = new Query(searchText);
            QueryResult result;
            result = twitter.search(query);
            for (Status tweet : result.getTweets()) {
                if(!tweets.contains(tweet.getText())){
                    tweets.add(tweet.getText());
                }
                //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }
           

        } catch (TwitterException te) {
            te.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
           // System.out.println("Failed to search tweets: " + te.getMessage());
           // System.exit(-1);
        }*/
       
    }

}
