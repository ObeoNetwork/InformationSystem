package org.obeonetwork.sample.inheritance;

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
import org.obeonetwork.sample.inheritance.Sub1;
import org.obeonetwork.sample.inheritance.ISub1Dao;

// End of user code for import

/**
 * Implementation of DAO interface ISub1Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.ISub1Dao
 */
public class HibernateSub1Dao implements ISub1Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateSub1Dao.class);

	/**
	 * Create a new element
	 * @param sub1 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.createSub1
     */
	public void createSub1(final Sub1 sub1) throws DaoException {
		LOG.debug("Create a new Sub1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(sub1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param sub1
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.updateSub1
     */
	public void updateSub1(Sub1 sub1) throws DaoException {
		LOG.debug("Update the entity Sub1 with id =" + sub1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(sub1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param sub1 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.deleteSub1
   	 */
	public void deleteSub1(Sub1 sub1) throws DaoException {
		LOG.debug("Delete the entity Sub1 with id =" + sub1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(sub1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.findAllSub1s
     */
	public Collection<Sub1> findAllSub1s() throws DaoException {
		LOG.debug("Find all instance of Sub1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub1.class);
			Collection<Sub1> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Sub1 entity");
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
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.findSub1ById
     */
	public Sub1 findSub1ById(String id) throws DaoException {
		LOG.debug("Find one instance of Sub1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub1.class)
				.add(Restrictions.eq("id", id));
			Sub1 result = (Sub1)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

