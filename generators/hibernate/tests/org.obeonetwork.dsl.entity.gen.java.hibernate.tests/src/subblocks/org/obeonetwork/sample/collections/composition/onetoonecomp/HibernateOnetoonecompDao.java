package org.obeonetwork.sample.collections.composition.onetoonecomp;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.collections.composition.onetoonecomp.A;
import org.obeonetwork.sample.collections.composition.onetoonecomp.B;
import org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao;

// End of user code for import

/**
 * Implementation of DAO interface IOnetoonecompDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao
 */
public class HibernateOnetoonecompDao implements IOnetoonecompDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateOnetoonecompDao.class);

	/**
	 * Create a new element
	 * @param a Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IADao.createA
     */
	public void createA(A a) throws DaoException {
		LOG.debug("Create a new A entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(a);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param a
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IADao.updateA
     */
	public void updateA(A a) throws DaoException {
		LOG.debug("Update the entity A with id =" + a.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(a);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param a Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IADao.deleteA
   	 */
	public void deleteA(A a) throws DaoException {
		LOG.debug("Delete the entity A with id =" + a.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(a);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IADao.findAllAs
     */
	public Collection<A> findAllAs() throws DaoException {
		LOG.debug("Find all instance of A entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(A.class);
			Collection<A> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of A entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IADao.findAById
     */
	public A findAById(String id) throws DaoException {
		LOG.debug("Find one instance of A entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(A.class)
				.add(Restrictions.eq("id", id));
			A result = (A)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param b Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IBDao.createB
     */
	public void createB(B b) throws DaoException {
		LOG.debug("Create a new B entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(b);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param b
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IBDao.updateB
     */
	public void updateB(B b) throws DaoException {
		LOG.debug("Update the entity B with id =" + b.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(b);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param b Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IBDao.deleteB
   	 */
	public void deleteB(B b) throws DaoException {
		LOG.debug("Delete the entity B with id =" + b.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(b);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IBDao.findAllBs
     */
	public Collection<B> findAllBs() throws DaoException {
		LOG.debug("Find all instance of B entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(B.class);
			Collection<B> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of B entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.collections.composition.onetoonecomp.IBDao.findBById
     */
	public B findBById(String id) throws DaoException {
		LOG.debug("Find one instance of B entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(B.class)
				.add(Restrictions.eq("id", id));
			B result = (B)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
