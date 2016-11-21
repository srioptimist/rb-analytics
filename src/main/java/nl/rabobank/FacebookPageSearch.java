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
    //            System.out.println("DAta from post feeds=====" + postFeed.getData());
//                for (List<Post> posts : postFeed) {
//                    System.out.println(postFeed.getData());
//                    if (noOfPosts > 15) {
//                        break;
//                    }
                    int noOfPost = 0;
                    for (Post post : postFeed.getData()) {
                        if (noOfPost > 15) {
                            break;
                        }
                        // TODO : Check post.getName() gives correct person name, check if we can get email id of the
                        // person,post.getPlace() gives correct place name of the person
                        if (post != null && post.getMessage() != null)
                        {

                            Connection<Comment> comments = fbClient.fetchConnection(post.getId() + "/comments",
                                    Comment.class, Parameter.with("limit", 50000));

                            for(Comment comment : comments.getData()){

                                if(comment.getMessage().contains("Kaart") || comment.getMessage().contains("bankpas") ||  comment.getMessage().contains("internet bankieren") ||  comment.getMessage().contains("mobiel bankieren")
                               || comment.getMessage().contains("pinpas")  ||  comment.getMessage().contains("sparen") || comment.getMessage().contains("spaarrekening") || comment.getMessage().contains("Mobiel")) {
                                    String mess = comment.getMessage().replaceAll("\n", " ").replaceAll("\r", " ");
                                    System.out.println(mess);
                                        feeds.add(new Feeds(comment.getCreatedTime().toString(),comment.getFrom().getName(), mess,
                                            comment.getId(), "", post.getPlace() !=null ? post.getPlace().getLocationAsString() : null));
                                }
                            }


                          //  feeds.add(new Feeds(post.getCreatedTime().toString(), post.getName(), post.getMessage(),
                              //      post.getId(), "", post.getPlace() !=null ? post.getPlace().getLocationAsString() : null));
                          //  System.out.println(post.getCreatedTime() + " " + page.getName() + " " + post.getMessage());
                            noOfPost++;
                        }

                    }
                    noOfPosts++;
                //}

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
