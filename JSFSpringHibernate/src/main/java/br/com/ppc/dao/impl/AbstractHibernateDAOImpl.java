package br.com.ppc.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 * @param <E>
 * @param <K>
 */
@Repository
public abstract class AbstractHibernateDAOImpl<E extends Serializable, K extends Serializable> {

	protected Class<E> domainClass = getDomainClass();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method to return the class of the domain object
	 */
	protected abstract Class<E> getDomainClass();

	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public K create(final E entity) {
		return (K)currentSession().save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(final E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(final E entity) {
		currentSession().delete(entity);
	}

	public E find(final K key) {
		return (E) currentSession().get(domainClass, key);
	}

	public List<E> list() {
		return currentSession().createCriteria(domainClass).list();
	}

}


