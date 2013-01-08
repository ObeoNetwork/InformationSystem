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
import org.obeonetwork.sample.associations.Class101BIEND;
import org.obeonetwork.sample.associations.IClass101BIENDDao;

// End of user code

/**
 * Implementation of DAO interface IClass101BIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass101BIENDDao
 */
public class HibernateClass101BIENDDao implements IClass101BIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass101BIENDDao.class);

	/**
	 * Create a new element
	 * @param class_1_01_BI_END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.createClass_1_01_BI_END
     */
	public void createClass101BIEND(final Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Create a new Class101BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_BI_END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.updateClass_1_01_BI_END
     */
	public void updateClass101BIEND(Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Update the entity Class_1_01_BI_END with id =" + class101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_01_BI_END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.deleteClass_1_01_BI_END
   	 */
	public void deleteClass101BIEND(Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Delete the entity Class_1_01_BI_END with id =" + class101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.findAllClass_1_01_BI_ENDs
     */
	public Collection<Class101BIEND> findAllClass101BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_1_01_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BIEND.class);
			Collection<Class101BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_01_BI_END entity");
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
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.findClass_1_01_BI_ENDById
     */
	public Class101BIEND findClass101BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_01_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BIEND.class)
				.add(Restrictions.eq("id", id));
			Class101BIEND result = (Class101BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

