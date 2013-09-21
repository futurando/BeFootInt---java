/**
 * 
 */
package be.befootint.consulttweets.social.twitter;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cazamundo
 *
 */
public class TwitterTests {
	
	ClassPathXmlApplicationContext context;
	TweetConnector tweetConnector;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String springConfig = "classpath:spring/social/social-config.xml";
		try{
			context = new ClassPathXmlApplicationContext(springConfig);
			tweetConnector = (TweetConnector) context.getBean("tweetConnector");
		} finally{
			if (context != null){
				context.close();
			}
		}
	}

	@Test
	public void test() {
		assertTrue(tweetConnector.isConnected()); 
	}

}
