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
import org.obeonetwork.sample.inheritance.ClassA1;
import org.obeonetwork.sample.inheritance.IClassA1Dao;

// End of user code for import

/**
 * Implementation of DAO interface IClassA1Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IClassA1Dao
 */
public class HibernateClassA1Dao implements IClassA1Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassA1Dao.class);

	/**
	 * Create a new element
	 * @param classA1 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.createClassA1
     */
	public void createClassA1(final ClassA1 classA1) throws DaoException {
		LOG.debug("Create a new ClassA1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classA1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classA1
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.updateClassA1
     */
	public void updateClassA1(ClassA1 classA1) throws DaoException {
		LOG.debug("Update the entity ClassA1 with id =" + classA1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classA1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classA1 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.deleteClassA1
   	 */
	public void deleteClassA1(ClassA1 classA1) throws DaoException {
		LOG.debug("Delete the entity ClassA1 with id =" + classA1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classA1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.findAllClassA1s
     */
	public Collection<ClassA1> findAllClassA1s() throws DaoException {
		LOG.debug("Find all instance of ClassA1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA1.class);
			Collection<ClassA1> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassA1 entity");
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
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.findClassA1ById
     */
	public ClassA1 findClassA1ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassA1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA1.class)
				.add(Restrictions.eq("id", id));
			ClassA1 result = (ClassA1)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

