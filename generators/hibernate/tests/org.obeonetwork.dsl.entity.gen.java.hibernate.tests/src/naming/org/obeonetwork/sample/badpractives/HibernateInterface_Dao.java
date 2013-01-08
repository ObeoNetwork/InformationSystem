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
import org.obeonetwork.sample.badpractives.Interface_;
import org.obeonetwork.sample.badpractives.IInterface_Dao;

// End of user code for import

/**
 * Implementation of DAO interface IInterface_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IInterface_Dao
 */
public class HibernateInterface_Dao implements IInterface_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateInterface_Dao.class);

	/**
	 * Create a new element
	 * @param interface Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.createInterface
     */
	public void createInterface_(final Interface_ interface_) throws DaoException {
		LOG.debug("Create a new Interface_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param interface
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.updateInterface
     */
	public void updateInterface_(Interface_ interface_) throws DaoException {
		LOG.debug("Update the entity Interface with id =" + interface_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param interface Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.deleteInterface
   	 */
	public void deleteInterface_(Interface_ interface_) throws DaoException {
		LOG.debug("Delete the entity Interface with id =" + interface_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.findAllInterfaces
     */
	public Collection<Interface_> findAllInterface_s() throws DaoException {
		LOG.debug("Find all instance of Interface entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Interface_.class);
			Collection<Interface_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Interface entity");
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
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.findInterfaceById
     */
	public Interface_ findInterface_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Interface entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Interface_.class)
				.add(Restrictions.eq("id", id));
			Interface_ result = (Interface_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

