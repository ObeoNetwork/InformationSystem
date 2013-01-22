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
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao;

// End of user code

/**
 * Implementation of DAO interface IClass11BIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao
 */
public class HibernateClass11BIENDDao implements IClass11BIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11BIENDDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_BI_END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.createClass_1_1_BI_END
     */
	public void createClass11BIEND(final Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Create a new Class11BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI_END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.updateClass_1_1_BI_END
     */
	public void updateClass11BIEND(Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Update the entity Class_1_1_BI_END with id =" + class11BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI_END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.deleteClass_1_1_BI_END
   	 */
	public void deleteClass11BIEND(Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_BI_END with id =" + class11BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.findAllClass_1_1_BI_ENDs
     */
	public Collection<Class11BIEND> findAllClass11BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIEND.class);
			Collection<Class11BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_BI_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.findClass_1_1_BI_ENDById
     */
	public Class11BIEND findClass11BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIEND.class)
				.add(Restrictions.eq("id", id));
			Class11BIEND result = (Class11BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

