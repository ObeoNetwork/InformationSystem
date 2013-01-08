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
import org.obeonetwork.sample.associations.Class01ManyEND;
import org.obeonetwork.sample.associations.IClass01ManyENDDao;

// End of user code

/**
 * Implementation of DAO interface IClass01ManyENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClass01ManyENDDao
 */
public class HibernateClass01ManyENDDao implements IClass01ManyENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyENDDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.createClass_01_Many_END
     */
	public void createClass01ManyEND(final Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Create a new Class01ManyEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.updateClass_01_Many_END
     */
	public void updateClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_END with id =" + class01ManyEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.deleteClass_01_Many_END
   	 */
	public void deleteClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_END with id =" + class01ManyEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.findAllClass_01_Many_ENDs
     */
	public Collection<Class01ManyEND> findAllClass01ManyENDs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyEND.class);
			Collection<Class01ManyEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_END entity");
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
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.findClass_01_Many_ENDById
     */
	public Class01ManyEND findClass01ManyENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyEND.class)
				.add(Restrictions.eq("id", id));
			Class01ManyEND result = (Class01ManyEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

