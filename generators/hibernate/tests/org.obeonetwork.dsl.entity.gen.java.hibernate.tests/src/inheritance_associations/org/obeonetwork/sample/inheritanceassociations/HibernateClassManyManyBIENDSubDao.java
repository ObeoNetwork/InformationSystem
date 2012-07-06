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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassManyManyBIENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao
 */
public class HibernateClassManyManyBIENDSubDao implements IClassManyManyBIENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyBIENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_BI_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.createClass_Many_Many_BI_END_Sub
     */
	public void createClassManyManyBIENDSub(final ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Create a new ClassManyManyBIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.updateClass_Many_Many_BI_END_Sub
     */
	public void updateClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_BI_END_Sub with id =" + classManyManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.deleteClass_Many_Many_BI_END_Sub
   	 */
	public void deleteClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_BI_END_Sub with id =" + classManyManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.findAllClass_Many_Many_BI_END_Subs
     */
	public Collection<ClassManyManyBIENDSub> findAllClassManyManyBIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_BI_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIENDSub.class);
			Collection<ClassManyManyBIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_BI_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.findClass_Many_Many_BI_END_SubById
     */
	public ClassManyManyBIENDSub findClassManyManyBIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_BI_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIENDSub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBIENDSub result = (ClassManyManyBIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

