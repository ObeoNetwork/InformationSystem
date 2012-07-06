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
import org.obeonetwork.sample.inheritanceassociations.Class11BISub;
import org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass11BISubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao
 */
public class HibernateClass11BISubDao implements IClass11BISubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11BISubDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_BI_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.createClass_1_1_BI_Sub
     */
	public void createClass11BISub(final Class11BISub class11BISub) throws DaoException {
		LOG.debug("Create a new Class11BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.updateClass_1_1_BI_Sub
     */
	public void updateClass11BISub(Class11BISub class11BISub) throws DaoException {
		LOG.debug("Update the entity Class_1_1_BI_Sub with id =" + class11BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.deleteClass_1_1_BI_Sub
   	 */
	public void deleteClass11BISub(Class11BISub class11BISub) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_BI_Sub with id =" + class11BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.findAllClass_1_1_BI_Subs
     */
	public Collection<Class11BISub> findAllClass11BISubs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_BI_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BISub.class);
			Collection<Class11BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_BI_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.findClass_1_1_BI_SubById
     */
	public Class11BISub findClass11BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_BI_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BISub.class)
				.add(Restrictions.eq("id", id));
			Class11BISub result = (Class11BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

