/**
 * 
 */
package be.befootint.consulttweets.application.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import be.befootint.consulttweets.application.dao.TwitterRepository;
import be.befootint.consulttweets.model.application.TinyTweet;

/**
 * @author cazamundo
 *
 */
public class HibernateTwitterRepository implements TwitterRepository {
	
	private SessionFactory sessionFactory;

	/**
	 * Creates an new hibernate-based account repository.
	 * 
	 * @param sessionFactory
	 *            the Hibernate session factory required to obtain sessions
	 */
	public HibernateTwitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	/* (non-Javadoc)
	 * @see consult.internal.twitter.TwitterRepository#findByListId(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<TinyTweet> findByListId(String listId) {
		
		Query query = getCurrentSession().createQuery(
				"select a from T_TWITTER a where a.LIST_ID = ?");
		query.setString(0, listId);
		
		return (List<TinyTweet>) query.list();
	}

	/**
	 * Returns the session associated with the ongoing reward transaction.
	 * 
	 * @return the transactional session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
