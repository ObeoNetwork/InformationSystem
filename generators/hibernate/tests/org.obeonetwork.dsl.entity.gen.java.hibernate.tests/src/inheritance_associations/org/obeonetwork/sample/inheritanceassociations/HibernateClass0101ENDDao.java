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
import org.obeonetwork.sample.inheritanceassociations.Class0101END;
import org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass0101ENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao
 */
public class HibernateClass0101ENDDao implements IClass0101ENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass0101ENDDao.class);

	/**
	 * Create a new element
	 * @param class_01_01_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.createClass_01_01_END
     */
	public void createClass0101END(final Class0101END class0101END) throws DaoException {
		LOG.debug("Create a new Class0101END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.updateClass_01_01_END
     */
	public void updateClass0101END(Class0101END class0101END) throws DaoException {
		LOG.debug("Update the entity Class_01_01_END with id =" + class0101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_01_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.deleteClass_01_01_END
   	 */
	public void deleteClass0101END(Class0101END class0101END) throws DaoException {
		LOG.debug("Delete the entity Class_01_01_END with id =" + class0101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.findAllClass_01_01_ENDs
     */
	public Collection<Class0101END> findAllClass0101ENDs() throws DaoException {
		LOG.debug("Find all instance of Class_01_01_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101END.class);
			Collection<Class0101END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_01_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.findClass_01_01_ENDById
     */
	public Class0101END findClass0101ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_01_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101END.class)
				.add(Restrictions.eq("id", id));
			Class0101END result = (Class0101END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

