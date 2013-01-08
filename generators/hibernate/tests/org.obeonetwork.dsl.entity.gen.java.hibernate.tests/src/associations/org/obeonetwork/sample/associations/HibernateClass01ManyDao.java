package org.obeonetwork.sample.associations;

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
import org.obeonetwork.sample.associations.Class01Many;
import org.obeonetwork.sample.associations.IClass01ManyDao;

// End of user code

/**
 * Implementation of DAO interface IClass01ManyDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass01ManyDao
 */
public class HibernateClass01ManyDao implements IClass01ManyDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.createClass_01_Many
     */
	public void createClass01Many(final Class01Many class01Many) throws DaoException {
		LOG.debug("Create a new Class01Many entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.updateClass_01_Many
     */
	public void updateClass01Many(Class01Many class01Many) throws DaoException {
		LOG.debug("Update the entity Class_01_Many with id =" + class01Many.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.deleteClass_01_Many
   	 */
	public void deleteClass01Many(Class01Many class01Many) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many with id =" + class01Many.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.findAllClass_01_Manys
     */
	public Collection<Class01Many> findAllClass01Manys() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01Many.class);
			Collection<Class01Many> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many entity");
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
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.findClass_01_ManyById
     */
	public Class01Many findClass01ManyById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01Many.class)
				.add(Restrictions.eq("id", id));
			Class01Many result = (Class01Many)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

