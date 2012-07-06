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
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBISub;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass01ManyBISubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao
 */
public class HibernateClass01ManyBISubDao implements IClass01ManyBISubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyBISubDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_BI_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.createClass_01_Many_BI_Sub
     */
	public void createClass01ManyBISub(final Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Create a new Class01ManyBISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.updateClass_01_Many_BI_Sub
     */
	public void updateClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_BI_Sub with id =" + class01ManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.deleteClass_01_Many_BI_Sub
   	 */
	public void deleteClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_BI_Sub with id =" + class01ManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.findAllClass_01_Many_BI_Subs
     */
	public Collection<Class01ManyBISub> findAllClass01ManyBISubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_BI_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBISub.class);
			Collection<Class01ManyBISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_BI_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.findClass_01_Many_BI_SubById
     */
	public Class01ManyBISub findClass01ManyBISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_BI_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBISub.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBISub result = (Class01ManyBISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

