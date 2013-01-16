package org.obeonetwork.sample.inheritanceassociations;

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
import org.obeonetwork.sample.inheritanceassociations.Class11ENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao;

// End of user code

/**
 * Implementation of DAO interface IClass11ENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao
 */
public class HibernateClass11ENDSubDao implements IClass11ENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass11ENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_1_1_END_Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.createClass_1_1_END_Sub
     */
	public void createClass11ENDSub(final Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Create a new Class11ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_END_Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.updateClass_1_1_END_Sub
     */
	public void updateClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Update the entity Class_1_1_END_Sub with id =" + class11ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_1_1_END_Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.deleteClass_1_1_END_Sub
   	 */
	public void deleteClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_1_1_END_Sub with id =" + class11ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.findAllClass_1_1_END_Subs
     */
	public Collection<Class11ENDSub> findAllClass11ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_1_1_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11ENDSub.class);
			Collection<Class11ENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_1_1_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.findClass_1_1_END_SubById
     */
	public Class11ENDSub findClass11ENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_1_1_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11ENDSub.class)
				.add(Restrictions.eq("id", id));
			Class11ENDSub result = (Class11ENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

