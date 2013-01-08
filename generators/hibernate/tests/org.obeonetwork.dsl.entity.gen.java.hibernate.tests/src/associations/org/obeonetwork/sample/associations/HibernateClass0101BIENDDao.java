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
import org.obeonetwork.sample.associations.Class0101BIEND;
import org.obeonetwork.sample.associations.IClass0101BIENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass0101BIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass0101BIENDDao
 */
public class HibernateClass0101BIENDDao implements IClass0101BIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass0101BIENDDao.class);

	/**
	 * Create a new element
	 * @param class_01_01_BI_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.createClass_01_01_BI_END
     */
	public void createClass0101BIEND(final Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Create a new Class0101BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.updateClass_01_01_BI_END
     */
	public void updateClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Update the entity Class_01_01_BI_END with id =" + class0101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.deleteClass_01_01_BI_END
   	 */
	public void deleteClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Delete the entity Class_01_01_BI_END with id =" + class0101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.findAllClass_01_01_BI_ENDs
     */
	public Collection<Class0101BIEND> findAllClass0101BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_01_01_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIEND.class);
			Collection<Class0101BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_01_BI_END entity");
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
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.findClass_01_01_BI_ENDById
     */
	public Class0101BIEND findClass0101BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_01_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIEND.class)
				.add(Restrictions.eq("id", id));
			Class0101BIEND result = (Class0101BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

