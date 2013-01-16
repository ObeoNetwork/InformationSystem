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
import org.obeonetwork.sample.badpractives.Private_;
import org.obeonetwork.sample.badpractives.IPrivate_Dao;

// End of user code

/**
 * Implementation of DAO interface IPrivate_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IPrivate_Dao
 */
public class HibernatePrivate_Dao implements IPrivate_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernatePrivate_Dao.class);

	/**
	 * Create a new element
	 * @param private Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.createprivate
     */
	public void createprivate_(final Private_ private_) throws DaoException {
		LOG.debug("Create a new private_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param private
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.updateprivate
     */
	public void updateprivate_(Private_ private_) throws DaoException {
		LOG.debug("Update the entity private with id =" + private_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param private Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.deleteprivate
   	 */
	public void deleteprivate_(Private_ private_) throws DaoException {
		LOG.debug("Delete the entity private with id =" + private_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.findAllprivates
     */
	public Collection<Private_> findAllprivate_s() throws DaoException {
		LOG.debug("Find all instance of private entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Private_.class);
			Collection<Private_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of private entity");
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
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.findprivateById
     */
	public Private_ findprivate_ById(String id) throws DaoException {
		LOG.debug("Find one instance of private entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Private_.class)
				.add(Restrictions.eq("id", id));
			Private_ result = (Private_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

