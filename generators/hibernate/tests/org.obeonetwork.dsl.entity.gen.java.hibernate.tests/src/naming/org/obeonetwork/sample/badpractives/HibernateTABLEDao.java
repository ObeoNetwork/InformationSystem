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
import org.obeonetwork.sample.badpractives.TABLE;
import org.obeonetwork.sample.badpractives.ITABLEDao;

// End of user code

/**
 * Implementation of DAO interface ITABLEDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.ITABLEDao
 */
public class HibernateTABLEDao implements ITABLEDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateTABLEDao.class);

	/**
	 * Create a new element
	 * @param tABLE Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.createTABLE
     */
	public void createTABLE(final TABLE tABLE) throws DaoException {
		LOG.debug("Create a new TABLE entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(tABLE);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param tABLE
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.updateTABLE
     */
	public void updateTABLE(TABLE tABLE) throws DaoException {
		LOG.debug("Update the entity TABLE with id =" + tABLE.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(tABLE);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param tABLE Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.deleteTABLE
   	 */
	public void deleteTABLE(TABLE tABLE) throws DaoException {
		LOG.debug("Delete the entity TABLE with id =" + tABLE.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(tABLE);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.findAllTABLEs
     */
	public Collection<TABLE> findAllTABLEs() throws DaoException {
		LOG.debug("Find all instance of TABLE entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(TABLE.class);
			Collection<TABLE> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of TABLE entity");
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
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.findTABLEById
     */
	public TABLE findTABLEById(String id) throws DaoException {
		LOG.debug("Find one instance of TABLE entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(TABLE.class)
				.add(Restrictions.eq("id", id));
			TABLE result = (TABLE)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

