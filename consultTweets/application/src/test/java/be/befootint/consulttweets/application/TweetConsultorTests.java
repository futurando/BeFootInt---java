/**
 * 
 */
package be.befootint.consulttweets.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.befootint.consulttweets.application.service.TweetConsultor;
import be.befootint.consulttweets.model.web.ListsDTO;
import be.befootint.consulttweets.model.web.TweetPageDTO;

/**
 * @author cazamundo
 * A system test that verifies the components of the TweetConsult application work together to find all necessary tweets
 * successfully. Uses Spring to bootstrap the application for use in a test environment.
 */
@ContextConfiguration(locations = {"classpath:/be/befootint/consulttweets/application/system-test-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TweetConsultorTests {
	
	/**
	 * The object being tested.
	 */
	@Autowired
	private TweetConsultor tweetConsultor;
	
	@Test
	@Transactional
	public void consultAllTweets(){
		// test data
		String listId = "222222";
		TweetPageDTO tinyTweets = tweetConsultor.consultAllTweets(listId);
		
		assertNotNull("no tweets in the list",tinyTweets.getTweets());
		assertEquals("Total amount of tweets not correct",11,tinyTweets.getTweets().size());
	}
	
	@Test
	public void consultLists(){
		List<ListsDTO> lists = tweetConsultor.consultLists();
		
		assertNotNull(lists);
		assertNotNull(lists.get(0));
//		assertNull("Tweets included in this one!",lists.get(0).getTweets());
	}
	
//	@Test
//	public void testConsultRecentTweets() {
//		
//		// test data
//		int totalNrOfTweets = 5;
//		
//		List<Tweet> tweets = null;
//		
//		for (Lists lists:tweetConsultor.consultLists()){
//			tweets = tweetConsultor.consultRecentTweets(lists.getId(), totalNrOfTweets);
//			assertNotNull(tweets);
//			assertNotNull(tweets.get(0));
//			tweets.clear();
//		}
//		
//		
//		// test data
//		String listId = "111111";
//		
//
//		// call the 'tweetConsultor' to test its consultRecentTweets() method
//		tweets = tweetConsultor.consultRecentTweets(listId,
//				totalNrOfTweets);
//
//		// assert the expected reward confirmation results
//		assertNotNull(tweets);
//		assertNotNull(tweets.get(0));
//
//		// assert the list contains equal or less than @param totalNrOfTweets
//		assertTrue(tweets.size() <= totalNrOfTweets);
//
//		// assert a tweet contains data
//		Tweet tweet = tweets.get(0);
//		assertNotNull(tweet.getId());
//		assertNotNull(tweet.getCreatedAt());
//		assertNotNull(tweet.getFromUser());
//		assertNotNull(tweet.getProfileImageUrl());
//		assertNotNull(tweet.getText());
//	}
//
//	@Test
//	public void consultNewerTweets() {
//		// test data
//		String listId = "111111";
//		String tweetId = "00004";
//
//		// call the 'tweetConsultor' to test its consultNewerTweets() method
//		List<Tweet> tweets = tweetConsultor.consultNewerTweets(listId, tweetId);
//
//		// assert the expected reward confirmation results
//		assertNotNull(tweets);
//		assertNotNull(tweets.get(0));
//
//		// assert the tweets are newer
//		assertTrue(Integer.valueOf(tweetId) > Integer.valueOf(String.valueOf(tweets.get(0).getId())));
//
//		// assert a tweet contains data
//		Tweet tweet = tweets.get(0);
//		assertNotNull(tweet.getId());
//		assertNotNull(tweet.getCreatedAt());
//		assertNotNull(tweet.getFromUser());
//		assertNotNull(tweet.getProfileImageUrl());
//		assertNotNull(tweet.getText());
//	}
//
//	@Test
//	public void consultOlderTweets() {
//		// test data
//		String listId = "222222";
//		String tweetId = "00014";
//		int totalNrOfTweets = 5;
//
//		// call the 'tweetConsultor' to test its consultNewerTweets() method
//		List<Tweet> tweets = tweetConsultor.consultOlderTweets(listId, tweetId,
//				totalNrOfTweets);
//
//		// assert the list contains equal or less objects than @param totalNrOfTweets
//		assertTrue(tweets.size() <= totalNrOfTweets);
//		
//		// assert the expected reward confirmation results
//		assertNotNull(tweets);
//		assertNotNull(tweets.get(0));
//
//		// assert the tweets are older
//		assertTrue(Integer.valueOf(tweetId) < Integer.valueOf(String.valueOf(tweets.get(0).getId())));
//
//		// assert a tweet contains data
//		Tweet tweet = tweets.get(0);
//		assertNotNull(tweet.getId());
//		assertNotNull(tweet.getCreatedAt());
//		assertNotNull(tweet.getFromUser());
//		assertNotNull(tweet.getProfileImageUrl());
//		assertNotNull(tweet.getText());
//	}
	
}
