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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBI;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao;

// End of user code

/**
 * Implementation of DAO interface IClassManyManyBIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao
 */
public class HibernateClassManyManyBIDao implements IClassManyManyBIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyBIDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.createClass_Many_Many_BI
     */
	public void createClassManyManyBI(final ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Create a new ClassManyManyBI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.updateClass_Many_Many_BI
     */
	public void updateClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_BI with id =" + classManyManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.deleteClass_Many_Many_BI
   	 */
	public void deleteClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_BI with id =" + classManyManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.findAllClass_Many_Many_BIs
     */
	public Collection<ClassManyManyBI> findAllClassManyManyBIs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBI.class);
			Collection<ClassManyManyBI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.findClass_Many_Many_BIById
     */
	public ClassManyManyBI findClassManyManyBIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBI.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBI result = (ClassManyManyBI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

