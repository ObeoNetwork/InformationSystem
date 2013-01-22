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
import org.obeonetwork.sample.inheritanceassociations.ClassMany01;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao;

// End of user code

/**
 * Implementation of DAO interface IClassMany01Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao
 */
public class HibernateClassMany01Dao implements IClassMany01Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01Dao.class);

	/**
	 * Create a new element
	 * @param class_Many_01 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.createClass_Many_01
     */
	public void createClassMany01(final ClassMany01 classMany01) throws DaoException {
		LOG.debug("Create a new ClassMany01 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.updateClass_Many_01
     */
	public void updateClassMany01(ClassMany01 classMany01) throws DaoException {
		LOG.debug("Update the entity Class_Many_01 with id =" + classMany01.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.deleteClass_Many_01
   	 */
	public void deleteClassMany01(ClassMany01 classMany01) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01 with id =" + classMany01.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.findAllClass_Many_01s
     */
	public Collection<ClassMany01> findAllClassMany01s() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01.class);
			Collection<ClassMany01> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.findClass_Many_01ById
     */
	public ClassMany01 findClassMany01ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01.class)
				.add(Restrictions.eq("id", id));
			ClassMany01 result = (ClassMany01)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

