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
import org.obeonetwork.sample.inheritanceassociations.Class011BiENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClass011BiENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao
 */
public class HibernateClass011BiENDSubDao implements IClass011BiENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass011BiENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_01_1_Bi_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.createClass_01_1_Bi_END_Sub
     */
	public void createClass011BiENDSub(final Class011BiENDSub class011BiENDSub) throws DaoException {
		LOG.debug("Create a new Class011BiENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BiENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_Bi_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.updateClass_01_1_Bi_END_Sub
     */
	public void updateClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException {
		LOG.debug("Update the entity Class_01_1_Bi_END_Sub with id =" + class011BiENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BiENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_1_Bi_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.deleteClass_01_1_Bi_END_Sub
   	 */
	public void deleteClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_01_1_Bi_END_Sub with id =" + class011BiENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BiENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.findAllClass_01_1_Bi_END_Subs
     */
	public Collection<Class011BiENDSub> findAllClass011BiENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_01_1_Bi_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BiENDSub.class);
			Collection<Class011BiENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_1_Bi_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.findClass_01_1_Bi_END_SubById
     */
	public Class011BiENDSub findClass011BiENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_1_Bi_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BiENDSub.class)
				.add(Restrictions.eq("id", id));
			Class011BiENDSub result = (Class011BiENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

