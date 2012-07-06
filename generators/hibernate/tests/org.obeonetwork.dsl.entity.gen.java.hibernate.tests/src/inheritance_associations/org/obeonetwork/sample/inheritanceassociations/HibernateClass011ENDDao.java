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
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass011ENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao
 */
public class HibernateClass011ENDDao implements IClass011ENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass011ENDDao.class);

	/**
	 * Create a new element
	 * @param class_01_1_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.createClass_01_1_END
     */
	public void createClass011END(final Class011END class011END) throws DaoException {
		LOG.debug("Create a new Class011END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.updateClass_01_1_END
     */
	public void updateClass011END(Class011END class011END) throws DaoException {
		LOG.debug("Update the entity Class_01_1_END with id =" + class011END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_1_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.deleteClass_01_1_END
   	 */
	public void deleteClass011END(Class011END class011END) throws DaoException {
		LOG.debug("Delete the entity Class_01_1_END with id =" + class011END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.findAllClass_01_1_ENDs
     */
	public Collection<Class011END> findAllClass011ENDs() throws DaoException {
		LOG.debug("Find all instance of Class_01_1_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011END.class);
			Collection<Class011END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_1_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.findClass_01_1_ENDById
     */
	public Class011END findClass011ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_1_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011END.class)
				.add(Restrictions.eq("id", id));
			Class011END result = (Class011END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

