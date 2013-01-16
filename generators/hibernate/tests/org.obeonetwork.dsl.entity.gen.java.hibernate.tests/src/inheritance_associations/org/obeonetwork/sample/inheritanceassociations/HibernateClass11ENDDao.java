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
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao;

// End of user code

/**
 * Implementation of DAO interface IClass11ENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao
 */
public class HibernateClass11ENDDao implements IClass11ENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11ENDDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.createClass_1_1_END
     */
	public void createClass11END(final Class11END class11END) throws DaoException {
		LOG.debug("Create a new Class11END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.updateClass_1_1_END
     */
	public void updateClass11END(Class11END class11END) throws DaoException {
		LOG.debug("Update the entity Class_1_1_END with id =" + class11END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.deleteClass_1_1_END
   	 */
	public void deleteClass11END(Class11END class11END) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_END with id =" + class11END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.findAllClass_1_1_ENDs
     */
	public Collection<Class11END> findAllClass11ENDs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11END.class);
			Collection<Class11END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.findClass_1_1_ENDById
     */
	public Class11END findClass11ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11END.class)
				.add(Restrictions.eq("id", id));
			Class11END result = (Class11END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

