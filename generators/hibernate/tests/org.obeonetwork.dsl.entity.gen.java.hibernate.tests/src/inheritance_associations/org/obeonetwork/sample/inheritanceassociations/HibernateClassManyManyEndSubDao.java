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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEndSub;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassManyManyEndSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao
 */
public class HibernateClassManyManyEndSubDao implements IClassManyManyEndSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyEndSubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_End_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.createClass_Many_Many_End_Sub
     */
	public void createClassManyManyEndSub(final ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Create a new ClassManyManyEndSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_End_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.updateClass_Many_Many_End_Sub
     */
	public void updateClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_End_Sub with id =" + classManyManyEndSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_End_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.deleteClass_Many_Many_End_Sub
   	 */
	public void deleteClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_End_Sub with id =" + classManyManyEndSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.findAllClass_Many_Many_End_Subs
     */
	public Collection<ClassManyManyEndSub> findAllClassManyManyEndSubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_End_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEndSub.class);
			Collection<ClassManyManyEndSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_End_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.findClass_Many_Many_End_SubById
     */
	public ClassManyManyEndSub findClassManyManyEndSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_End_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEndSub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyEndSub result = (ClassManyManyEndSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

