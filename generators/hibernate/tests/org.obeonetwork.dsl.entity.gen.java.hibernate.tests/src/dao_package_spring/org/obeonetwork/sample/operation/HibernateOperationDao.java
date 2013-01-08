package org.obeonetwork.sample.operation;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.operation.Operations;
import org.obeonetwork.sample.operation.Finders;
import org.obeonetwork.sample.operation.IOperationDao;

// End of user code for import

/**
 * Implementation of DAO interface IOperationDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.operation.IOperationDao
 */
public class HibernateOperationDao extends HibernateDaoSupport implements IOperationDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateOperationDao.class);

	/**
	 * Create a new element
	 * @param operations Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IOperationsDao.createOperations
     */
    public void createOperations(Operations operations) throws DaoException {
		LOG.debug("Create a new Operations entity");
		try {
			getHibernateTemplate().save(operations);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param operations
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IOperationsDao.updateOperations
     */
	public void updateOperations(Operations operations) throws DaoException {
		LOG.debug("Update the entity Operations with id =" + operations.getId());
		try {
			getHibernateTemplate().update(operations);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param operations Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IOperationsDao.deleteOperations
   	 */
	public void deleteOperations(Operations operations) throws DaoException {
		LOG.debug("Delete the entity Operations with id =" + operations.getId());
		try {
			getHibernateTemplate().delete(operations);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IOperationsDao.findAllOperationss
     */
	public Collection<Operations> findAllOperationss() throws DaoException {
		LOG.debug("Find all instance of Operations entity");
		try {
			Collection<Operations> resultList = getHibernateTemplate().loadAll(Operations.class);

			LOG.debug("Found " + resultList.size() + " instances of Operations entity");
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
     * @see org.obeonetwork.sample.operation.IOperationsDao.findOperationsById
     */
	public Operations findOperationsById(String id) throws DaoException {
		LOG.debug("Find one instance of Operations entity by id : " + id);
		try {
			return (Operations) getHibernateTemplate().load(Operations.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param finders Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IFindersDao.createFinders
     */
    public void createFinders(Finders finders) throws DaoException {
		LOG.debug("Create a new Finders entity");
		try {
			getHibernateTemplate().save(finders);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param finders
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IFindersDao.updateFinders
     */
	public void updateFinders(Finders finders) throws DaoException {
		LOG.debug("Update the entity Finders with id =" + finders.getId());
		try {
			getHibernateTemplate().update(finders);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param finders Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IFindersDao.deleteFinders
   	 */
	public void deleteFinders(Finders finders) throws DaoException {
		LOG.debug("Delete the entity Finders with id =" + finders.getId());
		try {
			getHibernateTemplate().delete(finders);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.operation.IFindersDao.findAllFinderss
     */
	public Collection<Finders> findAllFinderss() throws DaoException {
		LOG.debug("Find all instance of Finders entity");
		try {
			Collection<Finders> resultList = getHibernateTemplate().loadAll(Finders.class);

			LOG.debug("Found " + resultList.size() + " instances of Finders entity");
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
     * @see org.obeonetwork.sample.operation.IFindersDao.findFindersById
     */
	public Finders findFindersById(String id) throws DaoException {
		LOG.debug("Find one instance of Finders entity by id : " + id);
		try {
			return (Finders) getHibernateTemplate().load(Finders.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Find all entities by the attributes 
	 * @return A collection with all matching entities.
	 */
	public Collection<Finders> finder() throws DaoException {		
		LOG.debug("Call finder :  on Finders entity");		
		try {
			Collection<Finders> resultList;
			// Start of user code for finder :  finder
			Criteria criteria = getSession().createCriteria(Finders.class);

			resultList = criteria.list();
			// End of user code for finder :  finder
			LOG.debug("Find " + resultList.size() + " instances of finder :  entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	
	//Start of user code
	//End of user code
}
