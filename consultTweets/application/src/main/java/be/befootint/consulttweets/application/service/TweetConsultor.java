/**
 * 
 */
package be.befootint.consulttweets.application.service;

import java.util.List;

import org.springframework.social.twitter.api.Tweet;

import be.befootint.consulttweets.model.web.ListsDTO;
import be.befootint.consulttweets.model.web.TweetPageDTO;

/**
 * Consults a saved list of Tweets linked to a certain TwitterProfile
 * 
 * This service has been created because Twitter doesn't
 * allow unregistered users to consult Tweets of a public list.
 * 
 * The service is the entry-point to the webservice.
 * It always returns a list of Tweets
 * 
 * @author cazamundo
 */
public interface TweetConsultor {
	
	/**
	 * Consult all the tweets from a list
	 * @param listId
	 * @return List<TinyTweet>
	 */
	public TweetPageDTO consultAllTweets(String listId);
	
	/**
	 * Consult the most recent Tweets from a list
	 * @param listId
	 * @param totalNrOfTweets
	 * @return
	 */
	public List<Tweet> consultRecentTweets(String listId, int totalNrOfTweets);
	
	/**
	 * Refresh the list of Tweets, return all new tweets. All tweets that are more recent than tweetId.
	 * @param listId
	 * @param tweetId
	 * @return
	 */
	public List<Tweet> consultNewerTweets(String listId, String tweetId);
	
	
	/**
	 * Consult an older list of Tweets starting from the tweet older than tweetId
	 * @param listId
	 * @param tweetId
	 * @param totalNrOfTweets
	 * @return
	 */
	public List<Tweet> consultOlderTweets(String listId, String tweetId, int totalNrOfTweets);
	
	/**
	 * Consult all lists
	 * @return
	 */
	public List<ListsDTO> consultLists();

}
