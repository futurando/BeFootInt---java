/**
 * 
 */
package be.befootint.consulttweets.social.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * @author cazamundo
 * 
 */
public class TweetConnector {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(TweetConnector.class);
	private final static String baseUrl = "https://api.twitter.com/";

	// The application's consumer key
	private String consumerKey;

	// The application's consumer secret
	private String consumerSecret;

	// The access token granted after OAuth authorization
	private String accessToken;

	// The access token secret granted after OAuth authorization
	private String accessTokenSecret;

	private Twitter twitter;

	TweetConnector(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}

	public String getAccessToken() {
		if (accessToken == null) {
			OAuth2Operations operations = new OAuth2Template(consumerKey,
					consumerSecret, "", null, baseUrl + "oauth2/token");
			AccessGrant accessGrant = operations.authenticateClient();
			setAccessToken(accessGrant.getAccessToken());
		}
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

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public Twitter connectTwitterAppOnly() {
		if (this.twitter == null) {
			setTwitter(new TwitterTemplate(getAccessToken()));
		}
		return this.twitter;
	}
	
	/**
	 * method to check if the connection is done on behalf of a certain user
	 * @return
	 */
	public boolean isConnected() {
		if (getTwitter() != null) {
			if (getTwitter().isAuthorized()) {
				LOGGER.info("user connection");
				return true;
			}else{
				LOGGER.info("application connection");
				return false;
			}
		};
		LOGGER.info("no connection");
		return false;
	}
}
