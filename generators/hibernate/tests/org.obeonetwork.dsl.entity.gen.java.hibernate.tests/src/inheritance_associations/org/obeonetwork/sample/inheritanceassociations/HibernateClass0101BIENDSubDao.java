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
import org.obeonetwork.sample.inheritanceassociations.Class0101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao;

// End of user code

/**
 * Implementation of DAO interface IClass0101BIENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao
 */
public class HibernateClass0101BIENDSubDao implements IClass0101BIENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass0101BIENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_01_01_BI_END_Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.createClass_01_01_BI_END_Sub
     */
	public void createClass0101BIENDSub(final Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Create a new Class0101BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.updateClass_01_01_BI_END_Sub
     */
	public void updateClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class_01_01_BI_END_Sub with id =" + class0101BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI_END_Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.deleteClass_01_01_BI_END_Sub
   	 */
	public void deleteClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_01_01_BI_END_Sub with id =" + class0101BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.findAllClass_01_01_BI_END_Subs
     */
	public Collection<Class0101BIENDSub> findAllClass0101BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_01_BI_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIENDSub.class);
			Collection<Class0101BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_01_BI_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.findClass_01_01_BI_END_SubById
     */
	public Class0101BIENDSub findClass0101BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_01_BI_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class0101BIENDSub result = (Class0101BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

