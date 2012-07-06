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
import org.obeonetwork.sample.inheritanceassociations.Class11Sub;
import org.obeonetwork.sample.inheritanceassociations.IClass11SubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass11SubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao
 */
public class HibernateClass11SubDao implements IClass11SubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11SubDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.createClass_1_1_Sub
     */
	public void createClass11Sub(final Class11Sub class11Sub) throws DaoException {
		LOG.debug("Create a new Class11Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.updateClass_1_1_Sub
     */
	public void updateClass11Sub(Class11Sub class11Sub) throws DaoException {
		LOG.debug("Update the entity Class_1_1_Sub with id =" + class11Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.deleteClass_1_1_Sub
   	 */
	public void deleteClass11Sub(Class11Sub class11Sub) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_Sub with id =" + class11Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.findAllClass_1_1_Subs
     */
	public Collection<Class11Sub> findAllClass11Subs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11Sub.class);
			Collection<Class11Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.findClass_1_1_SubById
     */
	public Class11Sub findClass11SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11Sub.class)
				.add(Restrictions.eq("id", id));
			Class11Sub result = (Class11Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

