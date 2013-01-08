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
import org.obeonetwork.sample.inheritanceassociations.ClassMany01ENDSub;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassMany01ENDSubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao
 */
public class HibernateClassMany01ENDSubDao implements IClassMany01ENDSubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01ENDSubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_END_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.createClass_Many_01_END_Sub
     */
	public void createClassMany01ENDSub(final ClassMany01ENDSub classMany01ENDSub) throws DaoException {
		LOG.debug("Create a new ClassMany01ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.updateClass_Many_01_END_Sub
     */
	public void updateClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_END_Sub with id =" + classMany01ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_END_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.deleteClass_Many_01_END_Sub
   	 */
	public void deleteClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_END_Sub with id =" + classMany01ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.findAllClass_Many_01_END_Subs
     */
	public Collection<ClassMany01ENDSub> findAllClassMany01ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_END_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01ENDSub.class);
			Collection<ClassMany01ENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_END_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.findClass_Many_01_END_SubById
     */
	public ClassMany01ENDSub findClassMany01ENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_END_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01ENDSub.class)
				.add(Restrictions.eq("id", id));
			ClassMany01ENDSub result = (ClassMany01ENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

