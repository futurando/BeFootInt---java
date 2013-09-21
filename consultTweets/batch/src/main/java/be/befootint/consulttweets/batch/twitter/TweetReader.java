/**
 * 
 */
package be.befootint.consulttweets.batch.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * @author cazamundo
 * 
 */
public class TweetReader {
	
    private final static Logger LOGGER = LoggerFactory.getLogger(TweetReader.class);

	// The application's consumer key
	private String consumerKey;

	// The application's consumer secret
	private String consumerSecret;

	// The access token granted after OAuth authorization
	private String accessToken;

	// The access token secret granted after OAuth authorization
	private String accessTokenSecret;

	private Twitter twitter;
	
	private boolean isConnected = false;

	TweetReader(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	TweetReader(String consumerKey, String consumerSecret, String accessToken,
			String accessTokenSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.setAccessToken(accessToken);
		this.setAccessTokenSecret(accessTokenSecret);

		setTwitter(new TwitterTemplate(consumerKey, consumerSecret, accessToken,
				accessTokenSecret));
		if(getTwitter().isAuthorized()){
			LOGGER.info("connected to twitter");
			setConnected(true);
		}
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

	public Twitter getTwitter() {
		return twitter;
	}
	
	public void setTwitter(Twitter twitter){
		this.twitter = twitter;
	}

	public void setTwitter(String accessToken, String accessTokenSecret) {
		setAccessToken(accessToken);
		setAccessTokenSecret(accessTokenSecret);
		this.twitter = new TwitterTemplate(consumerKey, consumerSecret, getAccessToken(), getAccessTokenSecret());
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	

}
