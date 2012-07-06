package org.obeonetwork.sample.associations;

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
import org.obeonetwork.sample.associations.Class11BI;
import org.obeonetwork.sample.associations.IClass11BIDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass11BIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass11BIDao
 */
public class HibernateClass11BIDao implements IClass11BIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11BIDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_BI Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIDao.createClass_1_1_BI
     */
	public void createClass11BI(final Class11BI class11BI) throws DaoException {
		LOG.debug("Create a new Class11BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIDao.updateClass_1_1_BI
     */
	public void updateClass11BI(Class11BI class11BI) throws DaoException {
		LOG.debug("Update the entity Class_1_1_BI with id =" + class11BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIDao.deleteClass_1_1_BI
   	 */
	public void deleteClass11BI(Class11BI class11BI) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_BI with id =" + class11BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIDao.findAllClass_1_1_BIs
     */
	public Collection<Class11BI> findAllClass11BIs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BI.class);
			Collection<Class11BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_BI entity");
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
     * @see org.obeonetwork.sample.associations.IClass11BIDao.findClass_1_1_BIById
     */
	public Class11BI findClass11BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BI.class)
				.add(Restrictions.eq("id", id));
			Class11BI result = (Class11BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

