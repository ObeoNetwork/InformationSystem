package org.obeonetwork.sample.inheritanceassociations;

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
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.IClass101BIDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass101BIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao
 */
public class HibernateClass101BIDao implements IClass101BIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass101BIDao.class);

	/**
	 * Create a new element
	 * @param class_1_01_BI Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.createClass_1_01_BI
     */
	public void createClass101BI(final Class101BI class101BI) throws DaoException {
		LOG.debug("Create a new Class101BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.updateClass_1_01_BI
     */
	public void updateClass101BI(Class101BI class101BI) throws DaoException {
		LOG.debug("Update the entity Class_1_01_BI with id =" + class101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_01_BI Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.deleteClass_1_01_BI
   	 */
	public void deleteClass101BI(Class101BI class101BI) throws DaoException {
		LOG.debug("Delete the entity Class_1_01_BI with id =" + class101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.findAllClass_1_01_BIs
     */
	public Collection<Class101BI> findAllClass101BIs() throws DaoException {
		LOG.debug("Find all instance of Class_1_01_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BI.class);
			Collection<Class101BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_01_BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.findClass_1_01_BIById
     */
	public Class101BI findClass101BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_01_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BI.class)
				.add(Restrictions.eq("id", id));
			Class101BI result = (Class101BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

