/**
 * 
 */
package be.befootint.consulttweets.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import be.befootint.consulttweets.social.twitter.TweetReader;
import be.befootint.consulttweets.social.twitter.mock.MockedTweets;

/**
 * @author cazamundo
 * The api that returns the BeFootInt Tweets
 */
@Controller
public class TweetController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TweetController.class);
	TweetReader tweetReader;

	
	@Autowired
	public TweetController(TweetReader tweetReader){
		LOGGER.info("TweetController STARTED");
		this.tweetReader = tweetReader;
	}
	
	/**
	 * Provide the initial list of tweets
	 * 
	 * @return
	 */
	@RequestMapping(value="/tweets", method=RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@Timed(millis = 1800)
	public List<Tweet> initialTweetSummary(){
		LOGGER.info("api request: /tweets");
		
		return tweetReader.recentBeFootTweets();
	}
}
