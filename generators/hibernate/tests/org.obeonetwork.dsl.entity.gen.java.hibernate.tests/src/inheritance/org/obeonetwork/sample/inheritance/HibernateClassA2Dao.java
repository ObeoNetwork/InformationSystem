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
import org.obeonetwork.sample.inheritance.ClassA2;
import org.obeonetwork.sample.inheritance.IClassA2Dao;

// End of user code

/**
 * Implementation of DAO interface IClassA2Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IClassA2Dao
 */
public class HibernateClassA2Dao implements IClassA2Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassA2Dao.class);

	/**
	 * Create a new element
	 * @param classA2 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.createClassA2
     */
	public void createClassA2(final ClassA2 classA2) throws DaoException {
		LOG.debug("Create a new ClassA2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classA2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classA2
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.updateClassA2
     */
	public void updateClassA2(ClassA2 classA2) throws DaoException {
		LOG.debug("Update the entity ClassA2 with id =" + classA2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classA2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classA2 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.deleteClassA2
   	 */
	public void deleteClassA2(ClassA2 classA2) throws DaoException {
		LOG.debug("Delete the entity ClassA2 with id =" + classA2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classA2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.findAllClassA2s
     */
	public Collection<ClassA2> findAllClassA2s() throws DaoException {
		LOG.debug("Find all instance of ClassA2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA2.class);
			Collection<ClassA2> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassA2 entity");
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
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.findClassA2ById
     */
	public ClassA2 findClassA2ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassA2 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA2.class)
				.add(Restrictions.eq("id", id));
			ClassA2 result = (ClassA2)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

