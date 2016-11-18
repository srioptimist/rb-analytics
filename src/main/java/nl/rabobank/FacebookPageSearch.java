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
import com.restfb.types.Page;
import com.restfb.types.Post;

/**
 * Created by Jagan on 07/11/2016.
 * 
 * 
 */
public class FacebookPageSearch {

    private static final String[] SEARCH_TERM = { "rabo", "abn amro", "ING bank" };
    
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
                Parameter.with("type", "page"));

        int noOfPagesSearched = 0;
        for (List<Page> pages : pageResults) {
            for (Page page : pages) {

                System.out.println("fb.com/" + page.getId());

                int noOfPosts = 0;
                Connection<Post> postFeed = fbClient.fetchConnection(page.getId() + "/feed", Post.class);
                for (List<Post> posts : postFeed) {
                    // System.out.println(posts.size());
                    if (noOfPosts > 15) {
                        break;
                    }
                    int noOfPost = 0;
                    for (Post post : posts) {
                        if (noOfPost > 15) {
                            break;
                        }
                        // TODO : Check post.getName() gives correct person name, check if we can get email id of the
                        // person,post.getPlace() gives correct place name of the person
                        if (post != null && post.getMessage() != null && post.getMessage().contains(searchText))
                        {
                            feeds.add(new Feeds(post.getCreatedTime().toString(), post.getName(), post.getMessage(),
                                    post.getId(), "", post.getPlace().getLocationAsString()));
                            System.out.println(post.getCreatedTime() + " " + page.getName() + " " + post.getMessage());
                            noOfPost++;
                        }

                    }
                    noOfPosts++;
                }

                noOfPagesSearched++;

                if (noOfPagesSearched > 2) {
                    break;
                }
            }
        }
        System.out.println(noOfPagesSearched + " pages searched");
        return feeds;

    }

}
