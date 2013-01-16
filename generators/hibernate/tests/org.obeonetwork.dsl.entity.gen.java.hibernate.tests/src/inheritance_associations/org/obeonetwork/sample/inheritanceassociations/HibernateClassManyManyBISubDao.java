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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBISub;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao;

// End of user code

/**
 * Implementation of DAO interface IClassManyManyBISubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao
 */
public class HibernateClassManyManyBISubDao implements IClassManyManyBISubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyBISubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_BI_Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.createClass_Many_Many_BI_Sub
     */
	public void createClassManyManyBISub(final ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Create a new ClassManyManyBISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.updateClass_Many_Many_BI_Sub
     */
	public void updateClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_BI_Sub with id =" + classManyManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI_Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.deleteClass_Many_Many_BI_Sub
   	 */
	public void deleteClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_BI_Sub with id =" + classManyManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.findAllClass_Many_Many_BI_Subs
     */
	public Collection<ClassManyManyBISub> findAllClassManyManyBISubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_BI_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBISub.class);
			Collection<ClassManyManyBISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_BI_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.findClass_Many_Many_BI_SubById
     */
	public ClassManyManyBISub findClassManyManyBISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_BI_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBISub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBISub result = (ClassManyManyBISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

