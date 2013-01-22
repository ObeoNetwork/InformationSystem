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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManySub;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao;

// End of user code

/**
 * Implementation of DAO interface IClassManyManySubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao
 */
public class HibernateClassManyManySubDao implements IClassManyManySubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManySubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.createClass_Many_Many_Sub
     */
	public void createClassManyManySub(final ClassManyManySub classManyManySub) throws DaoException {
		LOG.debug("Create a new ClassManyManySub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.updateClass_Many_Many_Sub
     */
	public void updateClassManyManySub(ClassManyManySub classManyManySub) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_Sub with id =" + classManyManySub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.deleteClass_Many_Many_Sub
   	 */
	public void deleteClassManyManySub(ClassManyManySub classManyManySub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_Sub with id =" + classManyManySub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.findAllClass_Many_Many_Subs
     */
	public Collection<ClassManyManySub> findAllClassManyManySubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManySub.class);
			Collection<ClassManyManySub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.findClass_Many_Many_SubById
     */
	public ClassManyManySub findClassManyManySubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManySub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManySub result = (ClassManyManySub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

