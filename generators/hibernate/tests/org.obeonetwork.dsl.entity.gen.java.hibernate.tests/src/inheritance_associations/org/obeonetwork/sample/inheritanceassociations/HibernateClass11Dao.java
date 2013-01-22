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
import org.obeonetwork.sample.inheritanceassociations.Class11;
import org.obeonetwork.sample.inheritanceassociations.IClass11Dao;

// End of user code

/**
 * Implementation of DAO interface IClass11Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao
 */
public class HibernateClass11Dao implements IClass11Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11Dao.class);

	/**
	 * Create a new element
	 * @param class_1_1 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.createClass_1_1
     */
	public void createClass11(final Class11 class11) throws DaoException {
		LOG.debug("Create a new Class11 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.updateClass_1_1
     */
	public void updateClass11(Class11 class11) throws DaoException {
		LOG.debug("Update the entity Class_1_1 with id =" + class11.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.deleteClass_1_1
   	 */
	public void deleteClass11(Class11 class11) throws DaoException {
		LOG.debug("Delete the entity Class_1_1 with id =" + class11.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.findAllClass_1_1s
     */
	public Collection<Class11> findAllClass11s() throws DaoException {
		LOG.debug("Find all instance of Class_1_1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11.class);
			Collection<Class11> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.findClass_1_1ById
     */
	public Class11 findClass11ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11.class)
				.add(Restrictions.eq("id", id));
			Class11 result = (Class11)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

