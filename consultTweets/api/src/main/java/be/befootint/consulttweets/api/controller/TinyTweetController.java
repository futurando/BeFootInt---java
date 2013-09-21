/**
 * 
 */
package be.befootint.consulttweets.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import be.befootint.consulttweets.application.service.TweetConsultor;
import be.befootint.consulttweets.model.web.ListsDTO;
import be.befootint.consulttweets.model.web.TweetPageDTO;

/**
 * A Spring MVC @Controller controller handling requests for both the
 * lists summary and the tweet pages per list. 
 * @author cazamundo
 */
@Controller
public class TinyTweetController {
	
	private TweetConsultor tweetConsultor;
	
	/**
	 * Creates a new TinyTweetController with a given tweetConsultor
	 * @param tweetConsultor
	 */
	@Autowired
	public TinyTweetController(TweetConsultor tweetConsultor){
		this.tweetConsultor = tweetConsultor;
	}
	
	/**
	 * Provide a list of all tweetLists
	 * 
	 * @return
	 */
	@RequestMapping(value="/tweetLists", method=RequestMethod.GET)
	public @ResponseBody List<ListsDTO> tweetListSummary(){
		return tweetConsultor.consultLists();
	}
	
	/**
	 * Provide all tweets of a given listId
	 * @param listId
	 * @return
	 */
	@RequestMapping(value="/tweets/{listId}", method=RequestMethod.GET)
	public @ResponseBody TweetPageDTO tweetsSummary(@PathVariable("listId") String listId){
		return retrieveAllTweets(listId);
	}

	/**
	 * Search all tweets of a given listId, throwing an IllegalArgumentException if there is no such Account
	 */
	private TweetPageDTO retrieveAllTweets(String listId) {
		TweetPageDTO tweetPage = tweetConsultor.consultAllTweets(listId);
		if (tweetPage == null){
			throw new IllegalArgumentException("No list with id" + listId);
		}
		return tweetPage;
	}

}
