/**
 * 
 */
package be.befootint.consulttweets.application.dao;

import java.util.List;

import be.befootint.consulttweets.model.application.TinyTweet;

/**
 * @author cazamundo
 *
 */
public interface TwitterRepository {
	
	/**
	 * Load TinyTweets by its listId
	 * @param listId
	 * @return
	 */
	public List<TinyTweet> findByListId(String listId);

}
