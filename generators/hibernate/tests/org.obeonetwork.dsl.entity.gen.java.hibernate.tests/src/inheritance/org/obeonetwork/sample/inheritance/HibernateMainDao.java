package org.obeonetwork.sample.inheritance;

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
import org.obeonetwork.sample.inheritance.Main;
import org.obeonetwork.sample.inheritance.IMainDao;

// End of user code for import

/**
 * Implementation of DAO interface IMainDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IMainDao
 */
public class HibernateMainDao implements IMainDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateMainDao.class);

	/**
	 * Create a new element
	 * @param main Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.createMain
     */
	public void createMain(final Main main) throws DaoException {
		LOG.debug("Create a new Main entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(main);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param main
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.updateMain
     */
	public void updateMain(Main main) throws DaoException {
		LOG.debug("Update the entity Main with id =" + main.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(main);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param main Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.deleteMain
   	 */
	public void deleteMain(Main main) throws DaoException {
		LOG.debug("Delete the entity Main with id =" + main.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(main);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.findAllMains
     */
	public Collection<Main> findAllMains() throws DaoException {
		LOG.debug("Find all instance of Main entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Main.class);
			Collection<Main> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Main entity");
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
     * @see org.obeonetwork.sample.inheritance.IMainDao.findMainById
     */
	public Main findMainById(String id) throws DaoException {
		LOG.debug("Find one instance of Main entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Main.class)
				.add(Restrictions.eq("id", id));
			Main result = (Main)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

