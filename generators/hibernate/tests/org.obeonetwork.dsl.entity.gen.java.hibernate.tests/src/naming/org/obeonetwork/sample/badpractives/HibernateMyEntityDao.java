package org.obeonetwork.sample.badpractives;

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
import org.obeonetwork.sample.badpractives.MyEntity;
import org.obeonetwork.sample.badpractives.IMyEntityDao;

// End of user code for import

/**
 * Implementation of DAO interface IMyEntityDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IMyEntityDao
 */
public class HibernateMyEntityDao implements IMyEntityDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateMyEntityDao.class);

	/**
	 * Create a new element
	 * @param myEntity Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.createmyEntity
     */
	public void createmyEntity(final MyEntity myEntity) throws DaoException {
		LOG.debug("Create a new myEntity entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(myEntity);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param myEntity
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.updatemyEntity
     */
	public void updatemyEntity(MyEntity myEntity) throws DaoException {
		LOG.debug("Update the entity myEntity with id =" + myEntity.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(myEntity);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param myEntity Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.deletemyEntity
   	 */
	public void deletemyEntity(MyEntity myEntity) throws DaoException {
		LOG.debug("Delete the entity myEntity with id =" + myEntity.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(myEntity);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.findAllmyEntitys
     */
	public Collection<MyEntity> findAllmyEntitys() throws DaoException {
		LOG.debug("Find all instance of myEntity entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(MyEntity.class);
			Collection<MyEntity> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of myEntity entity");
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
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.findmyEntityById
     */
	public MyEntity findmyEntityById(String id) throws DaoException {
		LOG.debug("Find one instance of myEntity entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(MyEntity.class)
				.add(Restrictions.eq("id", id));
			MyEntity result = (MyEntity)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

