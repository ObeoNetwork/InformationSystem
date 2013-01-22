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
import org.obeonetwork.sample.badpractives.Anothername;
import org.obeonetwork.sample.badpractives.IAnothernameDao;

// End of user code

/**
 * Implementation of DAO interface IAnothernameDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IAnothernameDao
 */
public class HibernateAnothernameDao implements IAnothernameDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateAnothernameDao.class);

	/**
	 * Create a new element
	 * @param another.name Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.createAnother.name
     */
	public void createAnothername(final Anothername anothername) throws DaoException {
		LOG.debug("Create a new Anothername entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param another.name
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.updateAnother.name
     */
	public void updateAnothername(Anothername anothername) throws DaoException {
		LOG.debug("Update the entity Another.name with id =" + anothername.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param another.name Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.deleteAnother.name
   	 */
	public void deleteAnothername(Anothername anothername) throws DaoException {
		LOG.debug("Delete the entity Another.name with id =" + anothername.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.findAllAnother.names
     */
	public Collection<Anothername> findAllAnothernames() throws DaoException {
		LOG.debug("Find all instance of Another.name entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Anothername.class);
			Collection<Anothername> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Another.name entity");
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
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.findAnother.nameById
     */
	public Anothername findAnothernameById(String id) throws DaoException {
		LOG.debug("Find one instance of Another.name entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Anothername.class)
				.add(Restrictions.eq("id", id));
			Anothername result = (Anothername)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

