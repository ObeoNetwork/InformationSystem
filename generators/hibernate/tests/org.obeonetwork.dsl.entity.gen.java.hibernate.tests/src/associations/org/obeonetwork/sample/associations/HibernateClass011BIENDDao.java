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
import org.obeonetwork.sample.associations.Class011BIEND;
import org.obeonetwork.sample.associations.IClass011BIENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass011BIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass011BIENDDao
 */
public class HibernateClass011BIENDDao implements IClass011BIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass011BIENDDao.class);

	/**
	 * Create a new element
	 * @param class_01_1_BI_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.createClass_01_1_BI_END
     */
	public void createClass011BIEND(final Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Create a new Class011BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.updateClass_01_1_BI_END
     */
	public void updateClass011BIEND(Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Update the entity Class_01_1_BI_END with id =" + class011BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_1_BI_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.deleteClass_01_1_BI_END
   	 */
	public void deleteClass011BIEND(Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Delete the entity Class_01_1_BI_END with id =" + class011BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.findAllClass_01_1_BI_ENDs
     */
	public Collection<Class011BIEND> findAllClass011BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_01_1_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BIEND.class);
			Collection<Class011BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_1_BI_END entity");
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
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.findClass_01_1_BI_ENDById
     */
	public Class011BIEND findClass011BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_1_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BIEND.class)
				.add(Restrictions.eq("id", id));
			Class011BIEND result = (Class011BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

