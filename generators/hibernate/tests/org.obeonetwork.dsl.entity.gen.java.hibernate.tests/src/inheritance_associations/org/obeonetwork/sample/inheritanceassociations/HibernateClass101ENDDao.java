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
import org.obeonetwork.sample.inheritanceassociations.Class101END;
import org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass101ENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao
 */
public class HibernateClass101ENDDao implements IClass101ENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass101ENDDao.class);

	/**
	 * Create a new element
	 * @param class_1_01_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.createClass_1_01_END
     */
	public void createClass101END(final Class101END class101END) throws DaoException {
		LOG.debug("Create a new Class101END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.updateClass_1_01_END
     */
	public void updateClass101END(Class101END class101END) throws DaoException {
		LOG.debug("Update the entity Class_1_01_END with id =" + class101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_01_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.deleteClass_1_01_END
   	 */
	public void deleteClass101END(Class101END class101END) throws DaoException {
		LOG.debug("Delete the entity Class_1_01_END with id =" + class101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.findAllClass_1_01_ENDs
     */
	public Collection<Class101END> findAllClass101ENDs() throws DaoException {
		LOG.debug("Find all instance of Class_1_01_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101END.class);
			Collection<Class101END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_01_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.findClass_1_01_ENDById
     */
	public Class101END findClass101ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_01_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101END.class)
				.add(Restrictions.eq("id", id));
			Class101END result = (Class101END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

