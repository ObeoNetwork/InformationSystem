package org.obeonetwork.sample.badpractives;

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
import org.obeonetwork.sample.badpractives.Protected_;
import org.obeonetwork.sample.badpractives.IProtected_Dao;

// End of user code

/**
 * Implementation of DAO interface IProtected_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IProtected_Dao
 */
public class HibernateProtected_Dao implements IProtected_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateProtected_Dao.class);

	/**
	 * Create a new element
	 * @param protected Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.createprotected
     */
	public void createprotected_(final Protected_ protected_) throws DaoException {
		LOG.debug("Create a new protected_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param protected
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.updateprotected
     */
	public void updateprotected_(Protected_ protected_) throws DaoException {
		LOG.debug("Update the entity protected with id =" + protected_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param protected Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.deleteprotected
   	 */
	public void deleteprotected_(Protected_ protected_) throws DaoException {
		LOG.debug("Delete the entity protected with id =" + protected_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.findAllprotecteds
     */
	public Collection<Protected_> findAllprotected_s() throws DaoException {
		LOG.debug("Find all instance of protected entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Protected_.class);
			Collection<Protected_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of protected entity");
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
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.findprotectedById
     */
	public Protected_ findprotected_ById(String id) throws DaoException {
		LOG.debug("Find one instance of protected entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Protected_.class)
				.add(Restrictions.eq("id", id));
			Protected_ result = (Protected_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

