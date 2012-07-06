package org.obeonetwork.sample.badpractives.package_;

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
import org.obeonetwork.sample.badpractives.package_.Return_;
import org.obeonetwork.sample.badpractives.package_.IReturn_Dao;

// End of user code for import

/**
 * Implementation of DAO interface IReturn_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao
 */
public class HibernateReturn_Dao implements IReturn_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateReturn_Dao.class);

	/**
	 * Create a new element
	 * @param return Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.createreturn
     */
	public void createreturn_(final Return_ return_) throws DaoException {
		LOG.debug("Create a new return_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(return_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param return
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.updatereturn
     */
	public void updatereturn_(Return_ return_) throws DaoException {
		LOG.debug("Update the entity return with id =" + return_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(return_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param return Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.deletereturn
   	 */
	public void deletereturn_(Return_ return_) throws DaoException {
		LOG.debug("Delete the entity return with id =" + return_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(return_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.findAllreturns
     */
	public Collection<Return_> findAllreturn_s() throws DaoException {
		LOG.debug("Find all instance of return entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Return_.class);
			Collection<Return_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of return entity");
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
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.findreturnById
     */
	public Return_ findreturn_ById(String id) throws DaoException {
		LOG.debug("Find one instance of return entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Return_.class)
				.add(Restrictions.eq("id", id));
			Return_ result = (Return_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

