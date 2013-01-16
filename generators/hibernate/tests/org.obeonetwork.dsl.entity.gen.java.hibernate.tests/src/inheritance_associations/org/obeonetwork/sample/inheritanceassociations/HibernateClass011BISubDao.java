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
import org.obeonetwork.sample.inheritanceassociations.Class011BISub;
import org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao;

// End of user code

/**
 * Implementation of DAO interface IClass011BISubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao
 */
public class HibernateClass011BISubDao implements IClass011BISubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass011BISubDao.class);

	/**
	 * Create a new element
	 * @param class_01_1_BI_Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.createClass_01_1_BI_Sub
     */
	public void createClass011BISub(final Class011BISub class011BISub) throws DaoException {
		LOG.debug("Create a new Class011BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.updateClass_01_1_BI_Sub
     */
	public void updateClass011BISub(Class011BISub class011BISub) throws DaoException {
		LOG.debug("Update the entity Class_01_1_BI_Sub with id =" + class011BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_1_BI_Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.deleteClass_01_1_BI_Sub
   	 */
	public void deleteClass011BISub(Class011BISub class011BISub) throws DaoException {
		LOG.debug("Delete the entity Class_01_1_BI_Sub with id =" + class011BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.findAllClass_01_1_BI_Subs
     */
	public Collection<Class011BISub> findAllClass011BISubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_1_BI_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BISub.class);
			Collection<Class011BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_1_BI_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.findClass_01_1_BI_SubById
     */
	public Class011BISub findClass011BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_1_BI_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BISub.class)
				.add(Restrictions.eq("id", id));
			Class011BISub result = (Class011BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

