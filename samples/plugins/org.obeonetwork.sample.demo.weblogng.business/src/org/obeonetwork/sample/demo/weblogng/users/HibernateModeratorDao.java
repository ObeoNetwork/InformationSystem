package org.obeonetwork.sample.demo.weblogng.users;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.users.Moderator;
import org.obeonetwork.sample.demo.weblogng.users.IModeratorDao;

// End of user code

/**
 * Implementation of DAO interface IModeratorDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.demo.weblogng.users.IModeratorDao
 */
public class HibernateModeratorDao extends AbstractHibernateDAO<Moderator> implements IModeratorDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateModeratorDao.class);

	/**
	 * Create a new element
	 * @param moderator Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IModeratorDao.createModerator
     */
	public void createModerator(final Moderator moderator) throws DaoException {
		LOG.debug("Create a new Moderator entity");
		try {
			getHibernateTemplate().save(moderator);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param moderator
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IModeratorDao.updateModerator
     */
	public void updateModerator(Moderator moderator) throws DaoException {
		LOG.debug("Update the entity Moderator with id =" + moderator.getId());
		try {
			getHibernateTemplate().update(moderator);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param moderator Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IModeratorDao.deleteModerator
   	 */
	public void deleteModerator(Moderator moderator) throws DaoException {
		LOG.debug("Delete the entity Moderator with id =" + moderator.getId());
		try {
			getHibernateTemplate().delete(moderator);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IModeratorDao.findAllModerators
     */
	public Collection<Moderator> findAllModerators() throws DaoException {
		LOG.debug("Find all instance of Moderator entity");
		try {
			Collection<Moderator> resultList = getHibernateTemplate().loadAll(Moderator.class);
			LOG.debug("Found " + resultList.size() + " instances of Moderator entity");
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
     * @see org.obeonetwork.sample.demo.weblogng.users.IModeratorDao.findModeratorById
     */
	public Moderator findModeratorById(String id) throws DaoException {
		LOG.debug("Find one instance of Moderator entity by id : " + id);
		try {
			return (Moderator) getHibernateTemplate().load(Moderator.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code  
	//End of user code
}

