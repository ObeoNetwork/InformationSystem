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
import org.obeonetwork.sample.badpractives.Class_;
import org.obeonetwork.sample.badpractives.IClass_Dao;

// End of user code for import

/**
 * Implementation of DAO interface IClass_Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IClass_Dao
 */
public class HibernateClass_Dao implements IClass_Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass_Dao.class);

	/**
	 * Create a new element
	 * @param class Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.createClass
     */
	public void createClass_(final Class_ class_) throws DaoException {
		LOG.debug("Create a new Class_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.updateClass
     */
	public void updateClass_(Class_ class_) throws DaoException {
		LOG.debug("Update the entity Class with id =" + class_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.deleteClass
   	 */
	public void deleteClass_(Class_ class_) throws DaoException {
		LOG.debug("Delete the entity Class with id =" + class_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.findAllClasss
     */
	public Collection<Class_> findAllClass_s() throws DaoException {
		LOG.debug("Find all instance of Class entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class_.class);
			Collection<Class_> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class entity");
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
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.findClassById
     */
	public Class_ findClass_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class_.class)
				.add(Restrictions.eq("id", id));
			Class_ result = (Class_)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

