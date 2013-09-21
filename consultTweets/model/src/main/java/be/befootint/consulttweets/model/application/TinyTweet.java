/**
 * 
 */
package be.befootint.consulttweets.model.application;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A TinyTweet is a simplified format with less data extracted from spring social Tweet object
 * TinyTweets are saved in the local database
 * @author cazamundo
 *
 */

@Entity
@Table(name = "T_TWITTER")
public class TinyTweet {
	
	@Id
	@Column(name = "ID")
	private String id;
		
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "FROM_USER")
	private String fromUser;
	
	@Column(name = "PROFILE_IMAGE_URL")
	private String profileImageUrl;
	
	@Column(name = "TWITTER_ID")
	private String twitterId;
	
	@SuppressWarnings("unused")
	private TinyTweet(){
		//required by JPA
	}
	
	/**
	 * @param id
	 * @param text
	 * @param createdAt
	 * @param fromUser
	 * @param profileImageUrl
	 */
	public TinyTweet(String id, String text, Date createdAt, String fromUser, String twitterId,
			String profileImageUrl) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
		this.fromUser = fromUser;
		this.twitterId = twitterId;
		this.profileImageUrl = profileImageUrl;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the fromUser
	 */
	public String getFromUser() {
		return fromUser;
	}

	/**
	 * @param fromUser the fromUser to set
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	/**
	 * @return the twitterId
	 */
	public String getTwitterId() {
		return twitterId;
	}

	/**
	 * @param twitterId the twitterId to set
	 */
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	/**
	 * @return the profileImageUrl
	 */
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	/**
	 * @param profileImageUrl the profileImageUrl to set
	 */
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
}
