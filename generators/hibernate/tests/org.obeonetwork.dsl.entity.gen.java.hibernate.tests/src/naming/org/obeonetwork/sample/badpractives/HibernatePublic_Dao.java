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
import org.obeonetwork.sample.badpractives.Public_;
import org.obeonetwork.sample.badpractives.IPublic_Dao;

// End of user code

/**
 * Implementation of DAO interface IPublic_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IPublic_Dao
 */
public class HibernatePublic_Dao implements IPublic_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernatePublic_Dao.class);

	/**
	 * Create a new element
	 * @param public Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.createpublic
     */
	public void createpublic_(final Public_ public_) throws DaoException {
		LOG.debug("Create a new public_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param public
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.updatepublic
     */
	public void updatepublic_(Public_ public_) throws DaoException {
		LOG.debug("Update the entity public with id =" + public_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param public Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.deletepublic
   	 */
	public void deletepublic_(Public_ public_) throws DaoException {
		LOG.debug("Delete the entity public with id =" + public_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.findAllpublics
     */
	public Collection<Public_> findAllpublic_s() throws DaoException {
		LOG.debug("Find all instance of public entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Public_.class);
			Collection<Public_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of public entity");
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
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.findpublicById
     */
	public Public_ findpublic_ById(String id) throws DaoException {
		LOG.debug("Find one instance of public entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Public_.class)
				.add(Restrictions.eq("id", id));
			Public_ result = (Public_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

