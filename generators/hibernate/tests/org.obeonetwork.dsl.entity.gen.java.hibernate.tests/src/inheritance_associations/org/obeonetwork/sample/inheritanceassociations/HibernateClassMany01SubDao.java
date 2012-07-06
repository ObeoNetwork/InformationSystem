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
import org.obeonetwork.sample.inheritanceassociations.ClassMany01Sub;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassMany01SubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao
 */
public class HibernateClassMany01SubDao implements IClassMany01SubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01SubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_Sub Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.createClass_Many_01_Sub
     */
	public void createClassMany01Sub(final ClassMany01Sub classMany01Sub) throws DaoException {
		LOG.debug("Create a new ClassMany01Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.updateClass_Many_01_Sub
     */
	public void updateClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_Sub with id =" + classMany01Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_Sub Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.deleteClass_Many_01_Sub
   	 */
	public void deleteClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_Sub with id =" + classMany01Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.findAllClass_Many_01_Subs
     */
	public Collection<ClassMany01Sub> findAllClassMany01Subs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01Sub.class);
			Collection<ClassMany01Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.findClass_Many_01_SubById
     */
	public ClassMany01Sub findClassMany01SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01Sub.class)
				.add(Restrictions.eq("id", id));
			ClassMany01Sub result = (ClassMany01Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

