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
import org.obeonetwork.sample.inheritanceassociations.ClassManyMany;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassManyManyDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao
 */
public class HibernateClassManyManyDao implements IClassManyManyDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.createClass_Many_Many
     */
	public void createClassManyMany(final ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Create a new ClassManyMany entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.updateClass_Many_Many
     */
	public void updateClassManyMany(ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many with id =" + classManyMany.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.deleteClass_Many_Many
   	 */
	public void deleteClassManyMany(ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many with id =" + classManyMany.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.findAllClass_Many_Manys
     */
	public Collection<ClassManyMany> findAllClassManyManys() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyMany.class);
			Collection<ClassManyMany> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.findClass_Many_ManyById
     */
	public ClassManyMany findClassManyManyById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyMany.class)
				.add(Restrictions.eq("id", id));
			ClassManyMany result = (ClassManyMany)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

