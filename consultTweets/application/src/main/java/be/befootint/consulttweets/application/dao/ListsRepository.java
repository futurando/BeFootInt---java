/**
 * 
 */
package be.befootint.consulttweets.application.dao;

import java.util.List;

import be.befootint.consulttweets.model.application.Lists;

/**
 * @author cazamundo
 *
 */
public interface ListsRepository {
	/**
	 * Load all lists
	 */
	public List<Lists> findAllLists();
	
	public Lists findByListId(String listId);

}
