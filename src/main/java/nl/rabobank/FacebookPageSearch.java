package nl.rabobank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Comment;
import com.restfb.types.Comments;
import com.restfb.types.Page;
import com.restfb.types.Post;

/**
 * Created by Jagan on 07/11/2016.
 * 
 * 
 */
public class FacebookPageSearch {

    private static final String[] SEARCH_TERM = {"rabobank", "abn amro", "ING Nederland" };
    public static final int PAGE_LIMIT = 20;
    public static final int POST_LIMIT = 50;

    // private static final String[] SEARCH_TERM =
    // {"Kaart","pinpas","bankpas","Mobiel","mobiel bankieren","internet bankieren","internet banking","sparen","spaarrekening"};


    public static void main(String[] args) throws IOException {
        for (String s : SEARCH_TERM) {
            List<Feeds> tweets = new ArrayList<Feeds>();
            tweets = getFeeds(s);
            WriteToFile.write(tweets, s);
        }
    }

    public static List<Feeds> getFeeds(String searchText) {
        FacebookClient.AccessToken accessToken = new DefaultFacebookClient(Version.VERSION_2_2).obtainAppAccessToken(
                "1119322921489035", "7899dd52c9bf14de8d15bedb44c3a8ac");


        FacebookClient fbClient = new DefaultFacebookClient(accessToken.getAccessToken());
        List<Feeds> feeds = Lists.newArrayList();

        /** Search Page **/
        Connection<Page> pageResults = fbClient.fetchConnection("search", Page.class, Parameter.with("q", searchText),
                Parameter.with("type", "page"),   Parameter.with("limit", PAGE_LIMIT));
        System.out.println( pageResults.getData().size() + " pages searched for " + searchText);
        for (Page page : pageResults.getData()) {
            Connection<Post> postFeed = fbClient.fetchConnection(page.getId() + "/feed", Post.class, Parameter.with("limit", POST_LIMIT));
            System.out.println("No of Posts in " + page.getName() + " is " + postFeed.getData().size() + " and url is fb.com/" + page.getId());
            /** Search Post **/
            for (Post post : postFeed.getData()) {
                if (post != null && post.getMessage() != null) {

                        String mess = post.getMessage().replaceAll("\n", " ").replaceAll("\r", " ");
////                         if(filterFeedsBasedOnKeywords(comment)) {
                        feeds.add(new Feeds("Facebook", post.getCreatedTime().toString(), post.getName(), mess,
                                post.getId(), "", post.getPlace() != null ? post.getPlace().getLocationAsString() : null));
//                      //   }
//                    }
                }
            }
        }
        System.out.println("Search completed for facebook!");
        return feeds;

    }

    private static boolean filterFeedsBasedOnKeywords(Comment comment) {
        return comment.getMessage().contains("Kaart") || comment.getMessage().contains("bankpas") ||  comment.getMessage().contains("internet") ||  comment.getMessage().contains("mobiel bankieren")
              || comment.getMessage().contains("pinpas")  ||  comment.getMessage().contains("sparen") || comment.getMessage().contains("spaarrekening") || comment.getMessage().contains("mobiel");
    }

}
