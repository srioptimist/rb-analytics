package nl.rabobank;


public class Tweet {
    
    private String tweetDate;
    private String tweetBy;
    private String tweet;
    private long tweetId;
    private String screenName;
    private String email;
    private String location;
    
    

    public Tweet(String tweetDate, String tweetBy, String tweet, long tweetId, String screenName, String email,
            String location)
    {
        this.tweetDate = tweetDate;
        this.tweetBy = tweetBy;
        this.tweet = tweet;
        this.tweetId = tweetId;
        this.screenName = screenName;
        this.email = email;
        this.location = location;
    }

    public String getTweetDate() {
        return tweetDate;
    }

    public String getTweetBy() {
        return tweetBy;
    }

    public String getTweet() {
        return tweet;
    }

    public long getTweetId() {
        return tweetId;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }
    
    

}
