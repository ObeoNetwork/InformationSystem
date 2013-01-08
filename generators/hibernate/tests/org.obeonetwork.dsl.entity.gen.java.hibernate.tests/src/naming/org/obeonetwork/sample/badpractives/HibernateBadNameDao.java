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
import org.obeonetwork.sample.badpractives.BadName;
import org.obeonetwork.sample.badpractives.IBadNameDao;

// End of user code for import

/**
 * Implementation of DAO interface IBadNameDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IBadNameDao
 */
public class HibernateBadNameDao implements IBadNameDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateBadNameDao.class);

	/**
	 * Create a new element
	 * @param bad name Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.createBad name
     */
	public void createBadName(final BadName badName) throws DaoException {
		LOG.debug("Create a new BadName entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param bad name
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.updateBad name
     */
	public void updateBadName(BadName badName) throws DaoException {
		LOG.debug("Update the entity Bad name with id =" + badName.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param bad name Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.deleteBad name
   	 */
	public void deleteBadName(BadName badName) throws DaoException {
		LOG.debug("Delete the entity Bad name with id =" + badName.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.findAllBad names
     */
	public Collection<BadName> findAllBadNames() throws DaoException {
		LOG.debug("Find all instance of Bad name entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BadName.class);
			Collection<BadName> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Bad name entity");
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
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.findBad nameById
     */
	public BadName findBadNameById(String id) throws DaoException {
		LOG.debug("Find one instance of Bad name entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BadName.class)
				.add(Restrictions.eq("id", id));
			BadName result = (BadName)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

