/**
 * 
 */
package be.befootint.consulttweets.model.application;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author cazamundo
 * 
 */
@Entity
@Table(name = "T_LISTS")
public class Lists {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATED_AT")
	private Date createdAt;

	@OrderBy("createdAt desc")
	// this is about createdAt from TinyTweet, not from Lists
	@OneToMany
	@JoinColumn(name = "LIST_ID")
	private Set<TinyTweet> tweets = new LinkedHashSet<TinyTweet>();

	@SuppressWarnings("unused")
	private Lists() {
		// Required by JPA
	}

	/**
	 * Create a new list
	 * 
	 * @param id
	 * @param name
	 * @param createdAt
	 */
	public Lists(String id, String name, Date createdAt) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the created_At
	 */
	public Date getCreated_At() {
		return createdAt;
	}

	/**
	 * @param created_At
	 *            the created_At to set
	 */
	public void setCreated_At(Date created_At) {
		this.createdAt = created_At;
	}

	/**
	 * @return the tweets
	 */
	public Set<TinyTweet> getTweets() {
		return tweets;
	}

	/**
	 * @param tweets
	 *            the tweets to set
	 */
	public void setTweets(Set<TinyTweet> tweets) {
		this.tweets = tweets;
	}

}
