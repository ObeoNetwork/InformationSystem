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
import org.obeonetwork.sample.inheritance.BasicWithoutAttr;
import org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao;

// End of user code for import

/**
 * Implementation of DAO interface IBasicWithoutAttrDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao
 */
public class HibernateBasicWithoutAttrDao implements IBasicWithoutAttrDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateBasicWithoutAttrDao.class);

	/**
	 * Create a new element
	 * @param basicWithoutAttr Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.createBasicWithoutAttr
     */
	public void createBasicWithoutAttr(final BasicWithoutAttr basicWithoutAttr) throws DaoException {
		LOG.debug("Create a new BasicWithoutAttr entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(basicWithoutAttr);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param basicWithoutAttr
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.updateBasicWithoutAttr
     */
	public void updateBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException {
		LOG.debug("Update the entity BasicWithoutAttr with id =" + basicWithoutAttr.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(basicWithoutAttr);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param basicWithoutAttr Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.deleteBasicWithoutAttr
   	 */
	public void deleteBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException {
		LOG.debug("Delete the entity BasicWithoutAttr with id =" + basicWithoutAttr.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(basicWithoutAttr);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.findAllBasicWithoutAttrs
     */
	public Collection<BasicWithoutAttr> findAllBasicWithoutAttrs() throws DaoException {
		LOG.debug("Find all instance of BasicWithoutAttr entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BasicWithoutAttr.class);
			Collection<BasicWithoutAttr> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of BasicWithoutAttr entity");
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
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.findBasicWithoutAttrById
     */
	public BasicWithoutAttr findBasicWithoutAttrById(String id) throws DaoException {
		LOG.debug("Find one instance of BasicWithoutAttr entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BasicWithoutAttr.class)
				.add(Restrictions.eq("id", id));
			BasicWithoutAttr result = (BasicWithoutAttr)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

