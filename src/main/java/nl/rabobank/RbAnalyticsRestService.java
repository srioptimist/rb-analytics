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

@Path("/rbAnalytics")
public class RbAnalyticsRestService {

    @GET
    @Path("/{searchText}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResults(@PathParam("searchText") final String searchText) throws IOException {
        final List<Feeds> feeds = new ArrayList<Feeds>();
        feeds.addAll(TwitterSearch.getTweets(searchText));
        feeds.addAll(FacebookPageSearch.getFeeds(searchText));
        WriteToFile.write(feeds, searchText);
        return Response.status(Response.Status.OK).entity(feeds).build();
    }

}
