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
import org.obeonetwork.sample.associations.Class011;
import org.obeonetwork.sample.associations.IClass011Dao;

// End of user code for import

/**
 * Implementation of DAO interface IClass011Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass011Dao
 */
public class HibernateClass011Dao implements IClass011Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass011Dao.class);

	/**
	 * Create a new element
	 * @param class_01_1 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011Dao.createClass_01_1
     */
	public void createClass011(final Class011 class011) throws DaoException {
		LOG.debug("Create a new Class011 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011Dao.updateClass_01_1
     */
	public void updateClass011(Class011 class011) throws DaoException {
		LOG.debug("Update the entity Class_01_1 with id =" + class011.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_1 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011Dao.deleteClass_01_1
   	 */
	public void deleteClass011(Class011 class011) throws DaoException {
		LOG.debug("Delete the entity Class_01_1 with id =" + class011.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011Dao.findAllClass_01_1s
     */
	public Collection<Class011> findAllClass011s() throws DaoException {
		LOG.debug("Find all instance of Class_01_1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011.class);
			Collection<Class011> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_1 entity");
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
     * @see org.obeonetwork.sample.associations.IClass011Dao.findClass_01_1ById
     */
	public Class011 findClass011ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011.class)
				.add(Restrictions.eq("id", id));
			Class011 result = (Class011)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

