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
import org.obeonetwork.sample.inheritance.Basic;
import org.obeonetwork.sample.inheritance.IBasicDao;

// End of user code for import

/**
 * Implementation of DAO interface IBasicDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IBasicDao
 */
public class HibernateBasicDao implements IBasicDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateBasicDao.class);

	/**
	 * Create a new element
	 * @param basic Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.createBasic
     */
	public void createBasic(final Basic basic) throws DaoException {
		LOG.debug("Create a new Basic entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(basic);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param basic
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.updateBasic
     */
	public void updateBasic(Basic basic) throws DaoException {
		LOG.debug("Update the entity Basic with id =" + basic.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(basic);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param basic Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.deleteBasic
   	 */
	public void deleteBasic(Basic basic) throws DaoException {
		LOG.debug("Delete the entity Basic with id =" + basic.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(basic);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.findAllBasics
     */
	public Collection<Basic> findAllBasics() throws DaoException {
		LOG.debug("Find all instance of Basic entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Basic.class);
			Collection<Basic> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Basic entity");
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
     * @see org.obeonetwork.sample.inheritance.IBasicDao.findBasicById
     */
	public Basic findBasicById(String id) throws DaoException {
		LOG.debug("Find one instance of Basic entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Basic.class)
				.add(Restrictions.eq("id", id));
			Basic result = (Basic)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

