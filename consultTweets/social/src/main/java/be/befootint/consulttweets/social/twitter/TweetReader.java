/**
 * 
 */
package be.befootint.consulttweets.social.twitter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.UserList;

import be.befootint.consulttweets.social.twitter.mock.MockedTweets;

/**
 * @author cazamundo The class that connects to Twitter and searches for tweets
 * 
 */
public class TweetReader {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(TweetReader.class);

	private long tweetListId = 0;
	private TweetConnector tweetConnector;
	private Twitter twitter;
	private boolean onlineModus;

	public TweetReader(TweetConnector tweetConnector) {
		this.tweetConnector = tweetConnector;
		connectTwitterApi(tweetConnector);
	}

	private void connectTwitterApi(TweetConnector tweetConnector) {
		try {
			this.twitter = tweetConnector.connectTwitterAppOnly();
			LOGGER.info("ONLINE MODUS");
			setOnlineModus(true);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			LOGGER.info("OFFLINE MODUS");
			setOnlineModus(false);
		}
	}

	public List<Tweet> recentBeFootTweets() {
		if(!isOnlineModus()){
			connectTwitterApi(tweetConnector);
			if(!isOnlineModus()){
				LOGGER.info("RETURN MOCKED DATA");
				MockedTweets tweets = new MockedTweets();
				return tweets.recentBeFootTweets();
			}
		}
		if (isConnected()) {
			if (getTweetListId() == 0) {
				LOGGER.info("no tweet id");
				UserList userList = twitter.listOperations().getList(
						"BeFootInt", "BeFootInt");
				setTweetListId(userList.getId());
				LOGGER.info("tweet id retrieved");
			}
			LOGGER.info("getting listStatus");
			List<Tweet> tweets = twitter.listOperations().getListStatuses(
					getTweetListId());
			LOGGER.info("received listStatus");
			return tweets;
		} else {
			// TODO create error
			return null;
		}
	}

	private boolean isConnected() {
		for (int i = 1; i < 4; i++) {
			if (twitter != null) {
				LOGGER.info("still connected");
				return true;
			} else {
				LOGGER.info("connection fails");
				twitter = tweetConnector.connectTwitterAppOnly();
			}
		}
		LOGGER.info("connection not succeeding");
		// TODO generate error
		return false;
	}

	public long getTweetListId() {
		return tweetListId;
	}

	public void setTweetListId(long tweetListId) {
		this.tweetListId = tweetListId;
	}

	public boolean isOnlineModus() {
		return onlineModus;
	}

	public void setOnlineModus(boolean onlineModus) {
		this.onlineModus = onlineModus;
	}

}
