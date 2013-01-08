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
import org.obeonetwork.sample.inheritanceassociations.Class101Sub;
import org.obeonetwork.sample.inheritanceassociations.IClass101SubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass101SubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao
 */
public class HibernateClass101SubDao implements IClass101SubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass101SubDao.class);

	/**
	 * Create a new element
	 * @param class_1_01_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.createClass_1_01_Sub
     */
	public void createClass101Sub(final Class101Sub class101Sub) throws DaoException {
		LOG.debug("Create a new Class101Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.updateClass_1_01_Sub
     */
	public void updateClass101Sub(Class101Sub class101Sub) throws DaoException {
		LOG.debug("Update the entity Class_1_01_Sub with id =" + class101Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_01_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.deleteClass_1_01_Sub
   	 */
	public void deleteClass101Sub(Class101Sub class101Sub) throws DaoException {
		LOG.debug("Delete the entity Class_1_01_Sub with id =" + class101Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.findAllClass_1_01_Subs
     */
	public Collection<Class101Sub> findAllClass101Subs() throws DaoException {
		LOG.debug("Find all instance of Class_1_01_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101Sub.class);
			Collection<Class101Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_01_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.findClass_1_01_SubById
     */
	public Class101Sub findClass101SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_01_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101Sub.class)
				.add(Restrictions.eq("id", id));
			Class101Sub result = (Class101Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

