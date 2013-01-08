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
import org.obeonetwork.sample.associations.Class01ManyBI;
import org.obeonetwork.sample.associations.IClass01ManyBIDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass01ManyBIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass01ManyBIDao
 */
public class HibernateClass01ManyBIDao implements IClass01ManyBIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyBIDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_BI Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.createClass_01_Many_BI
     */
	public void createClass01ManyBI(final Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Create a new Class01ManyBI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.updateClass_01_Many_BI
     */
	public void updateClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_BI with id =" + class01ManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.deleteClass_01_Many_BI
   	 */
	public void deleteClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_BI with id =" + class01ManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.findAllClass_01_Many_BIs
     */
	public Collection<Class01ManyBI> findAllClass01ManyBIs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBI.class);
			Collection<Class01ManyBI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_BI entity");
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.findClass_01_Many_BIById
     */
	public Class01ManyBI findClass01ManyBIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBI.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBI result = (Class01ManyBI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

