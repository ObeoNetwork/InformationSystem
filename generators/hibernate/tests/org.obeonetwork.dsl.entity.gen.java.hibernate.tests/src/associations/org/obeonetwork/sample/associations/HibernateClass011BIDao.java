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
import org.obeonetwork.sample.associations.Class011BI;
import org.obeonetwork.sample.associations.IClass011BIDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass011BIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass011BIDao
 */
public class HibernateClass011BIDao implements IClass011BIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass011BIDao.class);

	/**
	 * Create a new element
	 * @param class_01_1_BI Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIDao.createClass_01_1_BI
     */
	public void createClass011BI(final Class011BI class011BI) throws DaoException {
		LOG.debug("Create a new Class011BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIDao.updateClass_01_1_BI
     */
	public void updateClass011BI(Class011BI class011BI) throws DaoException {
		LOG.debug("Update the entity Class_01_1_BI with id =" + class011BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_1_BI Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIDao.deleteClass_01_1_BI
   	 */
	public void deleteClass011BI(Class011BI class011BI) throws DaoException {
		LOG.debug("Delete the entity Class_01_1_BI with id =" + class011BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIDao.findAllClass_01_1_BIs
     */
	public Collection<Class011BI> findAllClass011BIs() throws DaoException {
		LOG.debug("Find all instance of Class_01_1_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BI.class);
			Collection<Class011BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_1_BI entity");
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
     * @see org.obeonetwork.sample.associations.IClass011BIDao.findClass_01_1_BIById
     */
	public Class011BI findClass011BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_1_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BI.class)
				.add(Restrictions.eq("id", id));
			Class011BI result = (Class011BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

