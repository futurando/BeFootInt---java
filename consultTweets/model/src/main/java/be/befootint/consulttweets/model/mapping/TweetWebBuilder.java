package be.befootint.consulttweets.model.mapping;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import be.befootint.consulttweets.model.application.Lists;
import be.befootint.consulttweets.model.application.TinyTweet;
import be.befootint.consulttweets.model.web.ListsDTO;
import be.befootint.consulttweets.model.web.TinyTweetDTO;
import be.befootint.consulttweets.model.web.TweetPageDTO;

public class TweetWebBuilder implements TweetBuilder {
	
	public ListsDTO mapToListsDTO(Lists lists) {
		ListsDTO listDTO = new ListsDTO();
		listDTO.setId(lists.getId());
		listDTO.setName(lists.getName());
		listDTO.setCreatedAt(lists.getCreated_At());
		return listDTO;
	}

	public TweetPageDTO mapToTweetPageDTO(Lists lists) {
		TweetPageDTO tweetPage = new TweetPageDTO();
		tweetPage.setId(lists.getId());
		tweetPage.setName(lists.getName());
		tweetPage.setCreatedAt(lists.getCreated_At());
		tweetPage.setTweets(mapToTinyTweetDTOs(lists.getTweets()));
		return tweetPage;
	}

	/* (non-Javadoc)
	 * @see consult.internal.TweetBuilder#mapToListsDTO(java.util.List)
	 */
	public List<ListsDTO> mapToListsDTO(List<Lists> lists) {
		List<ListsDTO> listsDTO = new ArrayList<ListsDTO>();
		for (Lists l:lists){
			listsDTO.add(mapToListsDTO(l));	
		}
		return listsDTO;
	}
	
	/* (non-Javadoc)
	 * @see consult.internal.TweetBuilder#mapToTinyTweetDTO(consult.internal.model.TinyTweet)
	 */
	public TinyTweetDTO mapToTinyTweetDTO(TinyTweet tweet) {
		TinyTweetDTO tinyTweetDTO = new TinyTweetDTO();
		tinyTweetDTO.setId(tweet.getId());
		tinyTweetDTO.setFromUser(tweet.getFromUser());
		tinyTweetDTO.setText(tweet.getText());
		tinyTweetDTO.setCreatedAt(tweet.getCreatedAt());
		tinyTweetDTO.setTwitterId(tweet.getTwitterId());
		return tinyTweetDTO;
	}
	
	/**
	 * @param tweets
	 * @return
	 */
	public Set<TinyTweetDTO> mapToTinyTweetDTOs(Set<TinyTweet> tweets) {
		Set<TinyTweetDTO> tinyTweetSet = new LinkedHashSet<TinyTweetDTO>();
		for (TinyTweet t:tweets){
			tinyTweetSet.add(mapToTinyTweetDTO(t));
		}
		return tinyTweetSet;
	}
}
