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
import org.obeonetwork.sample.inheritanceassociations.Class0101BI;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao;

// End of user code

/**
 * Implementation of DAO interface IClass0101BIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao
 */
public class HibernateClass0101BIDao implements IClass0101BIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass0101BIDao.class);

	/**
	 * Create a new element
	 * @param class_01_01_BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.createClass_01_01_BI
     */
	public void createClass0101BI(final Class0101BI class0101BI) throws DaoException {
		LOG.debug("Create a new Class0101BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.updateClass_01_01_BI
     */
	public void updateClass0101BI(Class0101BI class0101BI) throws DaoException {
		LOG.debug("Update the entity Class_01_01_BI with id =" + class0101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.deleteClass_01_01_BI
   	 */
	public void deleteClass0101BI(Class0101BI class0101BI) throws DaoException {
		LOG.debug("Delete the entity Class_01_01_BI with id =" + class0101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.findAllClass_01_01_BIs
     */
	public Collection<Class0101BI> findAllClass0101BIs() throws DaoException {
		LOG.debug("Find all instance of Class_01_01_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BI.class);
			Collection<Class0101BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_01_BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.findClass_01_01_BIById
     */
	public Class0101BI findClass0101BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_01_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BI.class)
				.add(Restrictions.eq("id", id));
			Class0101BI result = (Class0101BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

