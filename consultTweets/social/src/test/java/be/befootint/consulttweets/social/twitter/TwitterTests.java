/**
 * 
 */
package be.befootint.consulttweets.social.twitter;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.social.twitter.api.Tweet;

/**
 * @author cazamundo
 *
 */
public class TwitterTests {
	
	ClassPathXmlApplicationContext context;
	TweetConnector tweetConnector;
	TweetReader tweetReader;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String springConfig = "classpath:spring/social/social-config.xml";
		try{
			context = new ClassPathXmlApplicationContext(springConfig);
			tweetConnector = (TweetConnector) context.getBean("tweetConnector");
			tweetReader = (TweetReader) context.getBean("tweetReader");
		} finally{
			if (context != null){
				context.close();
			}
		}
	}

	@Test
	public void test() {
		tweetConnector.connectTwitterAppOnly();
		assertFalse(tweetConnector.isConnected());
		
		List<Tweet> tweets = tweetReader.recentBeFootTweets();
		for(Tweet tweet:tweets){
			System.out.println(tweet.getText());
		}
	}

}
