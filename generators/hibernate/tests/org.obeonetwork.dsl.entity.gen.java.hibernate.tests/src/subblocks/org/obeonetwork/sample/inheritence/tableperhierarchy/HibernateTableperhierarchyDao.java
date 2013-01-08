package org.obeonetwork.sample.inheritence.tableperhierarchy;

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
import org.obeonetwork.sample.inheritence.tableperhierarchy.Root;
import org.obeonetwork.sample.inheritence.tableperhierarchy.C1;
import org.obeonetwork.sample.inheritence.tableperhierarchy.C2;
import org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao;

// End of user code for import

/**
 * Implementation of DAO interface ITableperhierarchyDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao
 */
public class HibernateTableperhierarchyDao implements ITableperhierarchyDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateTableperhierarchyDao.class);

	/**
	 * Create a new element
	 * @param root Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IRootDao.createRoot
     */
	public void createRoot(Root root) throws DaoException {
		LOG.debug("Create a new Root entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(root);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param root
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IRootDao.updateRoot
     */
	public void updateRoot(Root root) throws DaoException {
		LOG.debug("Update the entity Root with id =" + root.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(root);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param root Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IRootDao.deleteRoot
   	 */
	public void deleteRoot(Root root) throws DaoException {
		LOG.debug("Delete the entity Root with id =" + root.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(root);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IRootDao.findAllRoots
     */
	public Collection<Root> findAllRoots() throws DaoException {
		LOG.debug("Find all instance of Root entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Root.class);
			Collection<Root> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Root entity");
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
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IRootDao.findRootById
     */
	public Root findRootById(String id) throws DaoException {
		LOG.debug("Find one instance of Root entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Root.class)
				.add(Restrictions.eq("id", id));
			Root result = (Root)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param c1 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC1Dao.createC1
     */
	public void createC1(C1 c1) throws DaoException {
		LOG.debug("Create a new C1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(c1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param c1
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC1Dao.updateC1
     */
	public void updateC1(C1 c1) throws DaoException {
		LOG.debug("Update the entity C1 with id =" + c1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(c1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param c1 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC1Dao.deleteC1
   	 */
	public void deleteC1(C1 c1) throws DaoException {
		LOG.debug("Delete the entity C1 with id =" + c1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(c1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC1Dao.findAllC1s
     */
	public Collection<C1> findAllC1s() throws DaoException {
		LOG.debug("Find all instance of C1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(C1.class);
			Collection<C1> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of C1 entity");
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
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC1Dao.findC1ById
     */
	public C1 findC1ById(String id) throws DaoException {
		LOG.debug("Find one instance of C1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(C1.class)
				.add(Restrictions.eq("id", id));
			C1 result = (C1)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param c2 Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC2Dao.createC2
     */
	public void createC2(C2 c2) throws DaoException {
		LOG.debug("Create a new C2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(c2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param c2
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC2Dao.updateC2
     */
	public void updateC2(C2 c2) throws DaoException {
		LOG.debug("Update the entity C2 with id =" + c2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(c2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param c2 Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC2Dao.deleteC2
   	 */
	public void deleteC2(C2 c2) throws DaoException {
		LOG.debug("Delete the entity C2 with id =" + c2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(c2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC2Dao.findAllC2s
     */
	public Collection<C2> findAllC2s() throws DaoException {
		LOG.debug("Find all instance of C2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(C2.class);
			Collection<C2> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of C2 entity");
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
     * @see org.obeonetwork.sample.inheritence.tableperhierarchy.IC2Dao.findC2ById
     */
	public C2 findC2ById(String id) throws DaoException {
		LOG.debug("Find one instance of C2 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(C2.class)
				.add(Restrictions.eq("id", id));
			C2 result = (C2)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
