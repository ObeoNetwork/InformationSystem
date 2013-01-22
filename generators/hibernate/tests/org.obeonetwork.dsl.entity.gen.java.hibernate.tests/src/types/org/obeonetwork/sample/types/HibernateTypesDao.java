package org.obeonetwork.sample.types;

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
import org.obeonetwork.sample.types.Types;
import org.obeonetwork.sample.types.ITypesDao;

// End of user code

/**
 * Implementation of DAO interface ITypesDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.types.ITypesDao
 */
public class HibernateTypesDao implements ITypesDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateTypesDao.class);

	/**
	 * Create a new element
	 * @param types Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.types.ITypesDao.createTypes
     */
	public void createTypes(final Types types) throws DaoException {
		LOG.debug("Create a new Types entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(types);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param types
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.types.ITypesDao.updateTypes
     */
	public void updateTypes(Types types) throws DaoException {
		LOG.debug("Update the entity Types with id =" + types.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(types);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param types Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.types.ITypesDao.deleteTypes
   	 */
	public void deleteTypes(Types types) throws DaoException {
		LOG.debug("Delete the entity Types with id =" + types.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(types);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.types.ITypesDao.findAllTypess
     */
	public Collection<Types> findAllTypess() throws DaoException {
		LOG.debug("Find all instance of Types entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Types.class);
			Collection<Types> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Types entity");
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
     * @see org.obeonetwork.sample.types.ITypesDao.findTypesById
     */
	public Types findTypesById(String id) throws DaoException {
		LOG.debug("Find one instance of Types entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Types.class)
				.add(Restrictions.eq("id", id));
			Types result = (Types)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

