package org.obeonetwork.sample.kindofdao;

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
import org.obeonetwork.sample.kindofdao.ExempleDirect;
import org.obeonetwork.sample.kindofdao.IKindOfDaoDao;

// End of user code

/**
 * Implementation of DAO interface IKindOfDaoDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.kindofdao.IKindOfDaoDao
 */
public class HibernateKindOfDaoDao implements IKindOfDaoDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateKindOfDaoDao.class);

	/**
	 * Create a new element
	 * @param exempleDirect Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.kindofdao.IExempleDirectDao.createExempleDirect
     */
	public void createExempleDirect(ExempleDirect exempleDirect) throws DaoException {
		LOG.debug("Create a new ExempleDirect entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(exempleDirect);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param exempleDirect
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.kindofdao.IExempleDirectDao.updateExempleDirect
     */
	public void updateExempleDirect(ExempleDirect exempleDirect) throws DaoException {
		LOG.debug("Update the entity ExempleDirect with id =" + exempleDirect.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(exempleDirect);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param exempleDirect Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.kindofdao.IExempleDirectDao.deleteExempleDirect
   	 */
	public void deleteExempleDirect(ExempleDirect exempleDirect) throws DaoException {
		LOG.debug("Delete the entity ExempleDirect with id =" + exempleDirect.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(exempleDirect);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.kindofdao.IExempleDirectDao.findAllExempleDirects
     */
	public Collection<ExempleDirect> findAllExempleDirects() throws DaoException {
		LOG.debug("Find all instance of ExempleDirect entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ExempleDirect.class);
			Collection<ExempleDirect> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ExempleDirect entity");
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
     * @see org.obeonetwork.sample.kindofdao.IExempleDirectDao.findExempleDirectById
     */
	public ExempleDirect findExempleDirectById(String id) throws DaoException {
		LOG.debug("Find one instance of ExempleDirect entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ExempleDirect.class)
				.add(Restrictions.eq("id", id));
			ExempleDirect result = (ExempleDirect)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

