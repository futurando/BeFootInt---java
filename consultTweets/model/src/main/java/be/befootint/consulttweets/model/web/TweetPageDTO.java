/**
 * 
 */
package be.befootint.consulttweets.model.web;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author cazamundo
 * 
 */
public class TweetPageDTO extends ListsDTO {

	private Set<TinyTweetDTO> tweets = new LinkedHashSet<TinyTweetDTO>();

	/**
	 * @return the tweets
	 */
	public Set<TinyTweetDTO> getTweets() {
		return tweets;
	}

	/**
	 * @param tweets the tweets to set
	 */
	public void setTweets(Set<TinyTweetDTO> tweets) {
		this.tweets = tweets;
	}

	
	

}
