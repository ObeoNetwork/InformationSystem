package org.obeonetwork.sample.inheritance;

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
import org.obeonetwork.sample.inheritance.ClassA3;
import org.obeonetwork.sample.inheritance.IClassA3Dao;

// End of user code for import

/**
 * Implementation of DAO interface IClassA3Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IClassA3Dao
 */
public class HibernateClassA3Dao implements IClassA3Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassA3Dao.class);

	/**
	 * Create a new element
	 * @param classA3 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.createClassA3
     */
	public void createClassA3(final ClassA3 classA3) throws DaoException {
		LOG.debug("Create a new ClassA3 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classA3);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classA3
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.updateClassA3
     */
	public void updateClassA3(ClassA3 classA3) throws DaoException {
		LOG.debug("Update the entity ClassA3 with id =" + classA3.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classA3);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classA3 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.deleteClassA3
   	 */
	public void deleteClassA3(ClassA3 classA3) throws DaoException {
		LOG.debug("Delete the entity ClassA3 with id =" + classA3.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classA3);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.findAllClassA3s
     */
	public Collection<ClassA3> findAllClassA3s() throws DaoException {
		LOG.debug("Find all instance of ClassA3 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA3.class);
			Collection<ClassA3> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassA3 entity");
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
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.findClassA3ById
     */
	public ClassA3 findClassA3ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassA3 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA3.class)
				.add(Restrictions.eq("id", id));
			ClassA3 result = (ClassA3)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

