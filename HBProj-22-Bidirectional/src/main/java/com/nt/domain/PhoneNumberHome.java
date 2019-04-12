package com.nt.domain;
// Generated Apr 12, 2019 11:23:56 AM by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PhoneNumber.
 * @see com.nt.domain.PhoneNumber
 * @author Hibernate Tools
 */
@Stateless
public class PhoneNumberHome {

	private static final Log log = LogFactory.getLog(PhoneNumberHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PhoneNumber transientInstance) {
		log.debug("persisting PhoneNumber instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PhoneNumber persistentInstance) {
		log.debug("removing PhoneNumber instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PhoneNumber merge(PhoneNumber detachedInstance) {
		log.debug("merging PhoneNumber instance");
		try {
			PhoneNumber result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PhoneNumber findById(long id) {
		log.debug("getting PhoneNumber instance with id: " + id);
		try {
			PhoneNumber instance = entityManager.find(PhoneNumber.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
