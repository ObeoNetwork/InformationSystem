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
import org.obeonetwork.sample.inheritanceassociations.Class01ManyENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass01ManyENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao
 */
public class HibernateClass01ManyENDSubDao implements IClass01ManyENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.createClass_01_Many_END_Sub
     */
	public void createClass01ManyENDSub(final Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Create a new Class01ManyENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.updateClass_01_Many_END_Sub
     */
	public void updateClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_END_Sub with id =" + class01ManyENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.deleteClass_01_Many_END_Sub
   	 */
	public void deleteClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_END_Sub with id =" + class01ManyENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.findAllClass_01_Many_END_Subs
     */
	public Collection<Class01ManyENDSub> findAllClass01ManyENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyENDSub.class);
			Collection<Class01ManyENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.findClass_01_Many_END_SubById
     */
	public Class01ManyENDSub findClass01ManyENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyENDSub.class)
				.add(Restrictions.eq("id", id));
			Class01ManyENDSub result = (Class01ManyENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

