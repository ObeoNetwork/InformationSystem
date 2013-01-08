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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEnd;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassManyManyEndDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao
 */
public class HibernateClassManyManyEndDao implements IClassManyManyEndDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyEndDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_End Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.createClass_Many_Many_End
     */
	public void createClassManyManyEnd(final ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Create a new ClassManyManyEnd entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_End
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.updateClass_Many_Many_End
     */
	public void updateClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_End with id =" + classManyManyEnd.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_End Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.deleteClass_Many_Many_End
   	 */
	public void deleteClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_End with id =" + classManyManyEnd.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.findAllClass_Many_Many_Ends
     */
	public Collection<ClassManyManyEnd> findAllClassManyManyEnds() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_End entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEnd.class);
			Collection<ClassManyManyEnd> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_End entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.findClass_Many_Many_EndById
     */
	public ClassManyManyEnd findClassManyManyEndById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_End entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEnd.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyEnd result = (ClassManyManyEnd)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

