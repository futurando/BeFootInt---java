/**
 * 
 */
package be.befootint.consulttweets.application.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import be.befootint.consulttweets.application.dao.ListsRepository;
import be.befootint.consulttweets.model.application.Lists;

/**
 * @author cazamundo
 *
 */
public class HibernateListsRepository implements ListsRepository {
	
	private SessionFactory sessionFactory;

	/**
	 * Creates an new hibernate-based account repository.
	 * 
	 * @param sessionFactory
	 *            the Hibernate session factory required to obtain sessions
	 */
	public HibernateListsRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see consult.internal.lists.ListsRepository#findAllLists()
	 */
	@SuppressWarnings("unchecked")
	public List<Lists> findAllLists() {
		Query query = getCurrentSession().createQuery("select l from Lists l");
		return query.list();
	}

	/* (non-Javadoc)
	 * @see consult.internal.lists.ListsRepository#findByListId(java.lang.String)
	 */
	public Lists findByListId(String listId) {
		Query query = getCurrentSession().createQuery("select l from Lists l join l.tweets t where l.id = ?");
		query.setString(0, listId);
		return (Lists) query.uniqueResult();
	}	
	
	/**
	 * @return
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
