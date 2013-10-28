/**
 * 
 */
package be.befootint.consulttweets.social.twitter.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.social.twitter.api.Tweet;

/**
 * @author cazamundo
 *
 */
public class MockedTweets {
	
	public List<Tweet> recentBeFootTweets() {
		return exampleTweets();
	}
	
	/**
	 * Mock data
	 * @return
	 */
	private static final List<Tweet> exampleTweets(){
		
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		for (int i=0;i<10;i++){
			
			Tweet tweet = new Tweet(i, "This is the tweetText, tweet number " + i, new Date(), "Lukaku", "url", new Date().getTime(), new Date().getTime(), "EN", null);
			tweets.add(tweet);
		}
		return tweets;
	}

}
