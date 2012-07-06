package org.obeonetwork.sample.badpractives.package_;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.package_.Return_;
import org.obeonetwork.sample.badpractives.package_.IPackage_Dao;

// End of user code for import

/**
 * Implementation of DAO interface IPackage_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.package_.IPackage_Dao
 */
public class HibernatePackage_Dao extends HibernateDaoSupport implements IPackage_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernatePackage_Dao.class);

	/**
	 * Create a new element
	 * @param return_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.createreturn_
     */
    public void createreturn_(Return_ return_) throws DaoException {
		LOG.debug("Create a new Return_ entity");
		try {
			getHibernateTemplate().save(return_);
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
		LOG.debug("Update the entity Return_ with id =" + return_.getId());
		try {
			getHibernateTemplate().update(return_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param return_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.deletereturn_
   	 */
	public void deletereturn_(Return_ return_) throws DaoException {
		LOG.debug("Delete the entity Return_ with id =" + return_.getId());
		try {
			getHibernateTemplate().delete(return_);
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
		LOG.debug("Find all instance of Return_ entity");
		try {
			Collection<Return_> resultList = getHibernateTemplate().loadAll(Return_.class);

			LOG.debug("Found " + resultList.size() + " instances of Return_ entity");
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
     * @see org.obeonetwork.sample.badpractives.package_.IReturn_Dao.findreturn_ById
     */
	public Return_ findreturn_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Return_ entity by id : " + id);
		try {
			return (Return_) getHibernateTemplate().load(Return_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
