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
import org.obeonetwork.sample.associations.Class101;
import org.obeonetwork.sample.associations.IClass101Dao;

// End of user code for import

/**
 * Implementation of DAO interface IClass101Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass101Dao
 */
public class HibernateClass101Dao implements IClass101Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass101Dao.class);

	/**
	 * Create a new element
	 * @param class_1_01 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101Dao.createClass_1_01
     */
	public void createClass101(final Class101 class101) throws DaoException {
		LOG.debug("Create a new Class101 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101Dao.updateClass_1_01
     */
	public void updateClass101(Class101 class101) throws DaoException {
		LOG.debug("Update the entity Class_1_01 with id =" + class101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_01 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101Dao.deleteClass_1_01
   	 */
	public void deleteClass101(Class101 class101) throws DaoException {
		LOG.debug("Delete the entity Class_1_01 with id =" + class101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101Dao.findAllClass_1_01s
     */
	public Collection<Class101> findAllClass101s() throws DaoException {
		LOG.debug("Find all instance of Class_1_01 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101.class);
			Collection<Class101> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_01 entity");
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
     * @see org.obeonetwork.sample.associations.IClass101Dao.findClass_1_01ById
     */
	public Class101 findClass101ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_01 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101.class)
				.add(Restrictions.eq("id", id));
			Class101 result = (Class101)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

