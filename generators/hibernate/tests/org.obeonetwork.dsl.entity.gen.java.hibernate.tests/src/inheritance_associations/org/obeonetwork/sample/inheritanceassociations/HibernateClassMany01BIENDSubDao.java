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
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassMany01BIENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao
 */
public class HibernateClassMany01BIENDSubDao implements IClassMany01BIENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01BIENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_BI_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.createClass_Many_01_BI_END_Sub
     */
	public void createClassMany01BIENDSub(final ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Create a new ClassMany01BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.updateClass_Many_01_BI_END_Sub
     */
	public void updateClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_BI_END_Sub with id =" + classMany01BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.deleteClass_Many_01_BI_END_Sub
   	 */
	public void deleteClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_BI_END_Sub with id =" + classMany01BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.findAllClass_Many_01_BI_END_Subs
     */
	public Collection<ClassMany01BIENDSub> findAllClassMany01BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_BI_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIENDSub.class);
			Collection<ClassMany01BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_BI_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.findClass_Many_01_BI_END_SubById
     */
	public ClassMany01BIENDSub findClassMany01BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_BI_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIENDSub.class)
				.add(Restrictions.eq("id", id));
			ClassMany01BIENDSub result = (ClassMany01BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

