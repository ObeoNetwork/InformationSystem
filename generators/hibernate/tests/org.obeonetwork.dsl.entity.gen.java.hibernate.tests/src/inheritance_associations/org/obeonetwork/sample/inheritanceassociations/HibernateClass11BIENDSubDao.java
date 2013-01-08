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
import org.obeonetwork.sample.inheritanceassociations.Class11BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass11BIENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao
 */
public class HibernateClass11BIENDSubDao implements IClass11BIENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11BIENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_BI_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.createClass_1_1_BI_END_Sub
     */
	public void createClass11BIENDSub(final Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Create a new Class11BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.updateClass_1_1_BI_END_Sub
     */
	public void updateClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class_1_1_BI_END_Sub with id =" + class11BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.deleteClass_1_1_BI_END_Sub
   	 */
	public void deleteClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_BI_END_Sub with id =" + class11BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.findAllClass_1_1_BI_END_Subs
     */
	public Collection<Class11BIENDSub> findAllClass11BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_BI_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIENDSub.class);
			Collection<Class11BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_BI_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.findClass_1_1_BI_END_SubById
     */
	public Class11BIENDSub findClass11BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_BI_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class11BIENDSub result = (Class11BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

