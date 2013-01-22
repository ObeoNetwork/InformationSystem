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
import org.obeonetwork.sample.badpractives.Null_;
import org.obeonetwork.sample.badpractives.INull_Dao;

// End of user code

/**
 * Implementation of DAO interface INull_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.INull_Dao
 */
public class HibernateNull_Dao implements INull_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateNull_Dao.class);

	/**
	 * Create a new element
	 * @param null Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.createnull
     */
	public void createnull_(final Null_ null_) throws DaoException {
		LOG.debug("Create a new null_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param null
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.updatenull
     */
	public void updatenull_(Null_ null_) throws DaoException {
		LOG.debug("Update the entity null with id =" + null_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param null Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.deletenull
   	 */
	public void deletenull_(Null_ null_) throws DaoException {
		LOG.debug("Delete the entity null with id =" + null_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.findAllnulls
     */
	public Collection<Null_> findAllnull_s() throws DaoException {
		LOG.debug("Find all instance of null entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Null_.class);
			Collection<Null_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of null entity");
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
     * @see org.obeonetwork.sample.badpractives.INull_Dao.findnullById
     */
	public Null_ findnull_ById(String id) throws DaoException {
		LOG.debug("Find one instance of null entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Null_.class)
				.add(Restrictions.eq("id", id));
			Null_ result = (Null_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

