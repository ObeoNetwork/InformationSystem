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
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass01ManyBIENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao
 */
public class HibernateClass01ManyBIENDSubDao implements IClass01ManyBIENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyBIENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_BI_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.createClass_01_Many_BI_END_Sub
     */
	public void createClass01ManyBIENDSub(final Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Create a new Class01ManyBIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.updateClass_01_Many_BI_END_Sub
     */
	public void updateClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_BI_END_Sub with id =" + class01ManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.deleteClass_01_Many_BI_END_Sub
   	 */
	public void deleteClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_BI_END_Sub with id =" + class01ManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.findAllClass_01_Many_BI_END_Subs
     */
	public Collection<Class01ManyBIENDSub> findAllClass01ManyBIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_BI_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIENDSub.class);
			Collection<Class01ManyBIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_BI_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.findClass_01_Many_BI_END_SubById
     */
	public Class01ManyBIENDSub findClass01ManyBIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_BI_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBIENDSub result = (Class01ManyBIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

