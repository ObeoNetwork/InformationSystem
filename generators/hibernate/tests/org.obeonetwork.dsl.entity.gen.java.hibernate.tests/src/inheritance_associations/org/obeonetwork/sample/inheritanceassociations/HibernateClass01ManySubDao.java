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
import org.obeonetwork.sample.inheritanceassociations.Class01ManySub;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass01ManySubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao
 */
public class HibernateClass01ManySubDao implements IClass01ManySubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManySubDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.createClass_01_Many_Sub
     */
	public void createClass01ManySub(final Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Create a new Class01ManySub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.updateClass_01_Many_Sub
     */
	public void updateClass01ManySub(Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_Sub with id =" + class01ManySub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.deleteClass_01_Many_Sub
   	 */
	public void deleteClass01ManySub(Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_Sub with id =" + class01ManySub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.findAllClass_01_Many_Subs
     */
	public Collection<Class01ManySub> findAllClass01ManySubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManySub.class);
			Collection<Class01ManySub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.findClass_01_Many_SubById
     */
	public Class01ManySub findClass01ManySubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManySub.class)
				.add(Restrictions.eq("id", id));
			Class01ManySub result = (Class01ManySub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

