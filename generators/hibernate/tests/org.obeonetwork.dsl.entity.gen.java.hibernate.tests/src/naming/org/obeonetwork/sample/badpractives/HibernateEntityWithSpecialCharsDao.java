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
import org.obeonetwork.sample.badpractives.EntityWithSpecialChars;
import org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao;

// End of user code

/**
 * Implementation of DAO interface IEntityWithSpecialCharsDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao
 */
public class HibernateEntityWithSpecialCharsDao implements IEntityWithSpecialCharsDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateEntityWithSpecialCharsDao.class);

	/**
	 * Create a new element
	 * @param entityWithSpécialChars Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.createentityWithSpécialChars
     */
	public void createentityWithSpecialChars(final EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Create a new entityWithSpecialChars entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param entityWithSpécialChars
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.updateentityWithSpécialChars
     */
	public void updateentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Update the entity entityWithSpécialChars with id =" + entityWithSpecialChars.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param entityWithSpécialChars Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.deleteentityWithSpécialChars
   	 */
	public void deleteentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Delete the entity entityWithSpécialChars with id =" + entityWithSpecialChars.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.findAllentityWithSpécialCharss
     */
	public Collection<EntityWithSpecialChars> findAllentityWithSpecialCharss() throws DaoException {
		LOG.debug("Find all instance of entityWithSpécialChars entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(EntityWithSpecialChars.class);
			Collection<EntityWithSpecialChars> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of entityWithSpécialChars entity");
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
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.findentityWithSpécialCharsById
     */
	public EntityWithSpecialChars findentityWithSpecialCharsById(String id) throws DaoException {
		LOG.debug("Find one instance of entityWithSpécialChars entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(EntityWithSpecialChars.class)
				.add(Restrictions.eq("id", id));
			EntityWithSpecialChars result = (EntityWithSpecialChars)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

