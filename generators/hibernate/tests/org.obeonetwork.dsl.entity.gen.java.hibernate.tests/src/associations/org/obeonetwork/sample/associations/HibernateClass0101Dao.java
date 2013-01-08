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
import org.obeonetwork.sample.associations.Class0101;
import org.obeonetwork.sample.associations.IClass0101Dao;

// End of user code

/**
 * Implementation of DAO interface IClass0101Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass0101Dao
 */
public class HibernateClass0101Dao implements IClass0101Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass0101Dao.class);

	/**
	 * Create a new element
	 * @param class_01_01 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.createClass_01_01
     */
	public void createClass0101(final Class0101 class0101) throws DaoException {
		LOG.debug("Create a new Class0101 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.updateClass_01_01
     */
	public void updateClass0101(Class0101 class0101) throws DaoException {
		LOG.debug("Update the entity Class_01_01 with id =" + class0101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_01 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.deleteClass_01_01
   	 */
	public void deleteClass0101(Class0101 class0101) throws DaoException {
		LOG.debug("Delete the entity Class_01_01 with id =" + class0101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.findAllClass_01_01s
     */
	public Collection<Class0101> findAllClass0101s() throws DaoException {
		LOG.debug("Find all instance of Class_01_01 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101.class);
			Collection<Class0101> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_01 entity");
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
     * @see org.obeonetwork.sample.associations.IClass0101Dao.findClass_01_01ById
     */
	public Class0101 findClass0101ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_01 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101.class)
				.add(Restrictions.eq("id", id));
			Class0101 result = (Class0101)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

