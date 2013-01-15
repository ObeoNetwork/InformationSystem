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
import org.obeonetwork.sample.inheritance.Sub2;
import org.obeonetwork.sample.inheritance.ISub2Dao;

// End of user code

/**
 * Implementation of DAO interface ISub2Dao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.ISub2Dao
 */
public class HibernateSub2Dao implements ISub2Dao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateSub2Dao.class);

	/**
	 * Create a new element
	 * @param sub2 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.createSub2
     */
	public void createSub2(final Sub2 sub2) throws DaoException {
		LOG.debug("Create a new Sub2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(sub2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param sub2
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.updateSub2
     */
	public void updateSub2(Sub2 sub2) throws DaoException {
		LOG.debug("Update the entity Sub2 with id =" + sub2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(sub2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param sub2 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.deleteSub2
   	 */
	public void deleteSub2(Sub2 sub2) throws DaoException {
		LOG.debug("Delete the entity Sub2 with id =" + sub2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(sub2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.findAllSub2s
     */
	public Collection<Sub2> findAllSub2s() throws DaoException {
		LOG.debug("Find all instance of Sub2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub2.class);
			Collection<Sub2> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Sub2 entity");
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
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.findSub2ById
     */
	public Sub2 findSub2ById(String id) throws DaoException {
		LOG.debug("Find one instance of Sub2 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub2.class)
				.add(Restrictions.eq("id", id));
			Sub2 result = (Sub2)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

