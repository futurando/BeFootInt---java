/**
 * 
 */
package be.befootint.consulttweets.model.mapping;

import java.util.List;
import java.util.Set;

import be.befootint.consulttweets.model.application.Lists;
import be.befootint.consulttweets.model.application.TinyTweet;
import be.befootint.consulttweets.model.web.ListsDTO;
import be.befootint.consulttweets.model.web.TinyTweetDTO;
import be.befootint.consulttweets.model.web.TweetPageDTO;

/**
 * @author cazamundo
 * This interface is meant to map all elements from the model to there specific implementation class
 */
public interface TweetBuilder {

	ListsDTO mapToListsDTO(Lists lists);
	
	List<ListsDTO> mapToListsDTO(List<Lists> lists);
	
	TweetPageDTO mapToTweetPageDTO(Lists lists);
	
	TinyTweetDTO mapToTinyTweetDTO(TinyTweet tweet);
	
	Set<TinyTweetDTO> mapToTinyTweetDTOs(Set<TinyTweet> tweets);

}
