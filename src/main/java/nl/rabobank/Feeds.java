package nl.rabobank;

public class Feeds {

    private String source;
    private String feedDate;
    private String feedBy;
    private String feed;
    private String feedId;
    private String email;
    private String location;

    public Feeds(String source, String feedDate, String feedBy, String feed, String feedId, String email, String location) {
        this.source = source;
        this.feedDate = feedDate;
        this.feedBy = feedBy;
        this.feed = feed;
        this.feedId = feedId;
        this.email = email;
        this.location = location;
    }

    public String getSource() {
        return source;
    }

    public String getFeedDate() {
        return feedDate;
    }

    public String getFeedBy() {
        return feedBy;
    }

    public String getFeed() {
        return feed;
    }

    public String getFeedId() {
        return feedId;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

}
