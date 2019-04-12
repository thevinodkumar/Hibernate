package com.nt.domain;
// Generated Apr 12, 2019 11:23:56 AM by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class UserTable.
 * @see com.nt.domain.UserTable
 * @author Hibernate Tools
 */
@Stateless
public class UserTableHome {

	private static final Log log = LogFactory.getLog(UserTableHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UserTable transientInstance) {
		log.debug("persisting UserTable instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserTable persistentInstance) {
		log.debug("removing UserTable instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserTable merge(UserTable detachedInstance) {
		log.debug("merging UserTable instance");
		try {
			UserTable result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserTable findById(long id) {
		log.debug("getting UserTable instance with id: " + id);
		try {
			UserTable instance = entityManager.find(UserTable.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
