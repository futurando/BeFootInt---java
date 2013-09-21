/**
 * 
 */
package be.befootint.consulttweets.application.service;

import java.util.List;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.transaction.annotation.Transactional;

import be.befootint.consulttweets.application.dao.ListsRepository;
import be.befootint.consulttweets.application.dao.TwitterRepository;
import be.befootint.consulttweets.model.mapping.TweetBuilder;
import be.befootint.consulttweets.model.mapping.TweetWebBuilder;
import be.befootint.consulttweets.model.web.ListsDTO;
import be.befootint.consulttweets.model.web.TweetPageDTO;

/**
 * Consults a saved list of Tweets
 * Retrieve the saved list from the TwitterRepository
 * @author cazamundo
 *
 */
public class TweetConsultorImpl implements TweetConsultor {
	
	private TwitterRepository twitterRepository;
	private ListsRepository listsRepository;
	
	private TweetBuilder tweetBuilder = new TweetWebBuilder();
	
	public TweetConsultorImpl(TwitterRepository twitterRepository, ListsRepository listsRepository){
		this.twitterRepository = twitterRepository;
		this.listsRepository = listsRepository;
	}
	
	/* (non-Javadoc)
	 * @see consult.TweetConsultor#consultAllTweets(java.lang.String)
	 */
	@Transactional
	public TweetPageDTO consultAllTweets(String listId) {
		return tweetBuilder.mapToTweetPageDTO(listsRepository.findByListId(listId));
	}
	
	/* (non-Javadoc)
	 * @see consult.TweetConsultor#consultRecentTweets(java.lang.String, int)
	 */
	@Transactional
	public List<Tweet> consultRecentTweets(String listId, int totalNrOfTweets) {
//		List<TinyTweet> tinyTweets = twitterRepository.findByListId(listId);
//		tinyTweets = tweetBuilder.filterTweets(TweetBuilder.TWEETBUILDER_NEW, tinyTweets, totalNrOfTweets, "");
//		tweets = tweetBuilder.mapTinyTweets(tinyTweets);
//		
//		return tweets;
		return null;
	}

	/* (non-Javadoc)
	 * @see consult.TweetConsultor#consultNewerTweets(java.lang.String, java.lang.String)
	 */
	@Transactional
	public List<Tweet> consultNewerTweets(String listId, String tweetId) {
//		List<TinyTweet> tinyTweets = twitterRepository.findByListId(listId);
//		tinyTweets = tweetBuilder.filterTweets(TweetBuilder.TWEETBUILDER_NEW, tinyTweets, Integer.MAX_VALUE, tweetId);
//		return tweetBuilder.mapTinyTweets(tinyTweets);
		return null;
	}

	/* (non-Javadoc)
	 * @see consult.TweetConsultor#consultOlderTweets(java.lang.String, java.lang.String, int)
	 */
	@Transactional
	public List<Tweet> consultOlderTweets(String listId, String tweetId,
			int totalNrOfTweets) {
//		List<TinyTweet> tinyTweets = twitterRepository.findByListId(listId);
//		tinyTweets = tweetBuilder.filterTweets(TweetBuilder.TWEETBUILDER_OLD, tinyTweets, totalNrOfTweets, tweetId);
//		return tweetBuilder.mapTinyTweets(tinyTweets);
		return null;
	}
	
	@Transactional
	public List<ListsDTO> consultLists(){
		return tweetBuilder.mapToListsDTO(listsRepository.findAllLists());
	}
}
