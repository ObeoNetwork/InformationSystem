package org.obeonetwork.sample.associations;

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
import org.obeonetwork.sample.associations.ClassMany01BI;
import org.obeonetwork.sample.associations.IClassMany01BIDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassMany01BIDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClassMany01BIDao
 */
public class HibernateClassMany01BIDao implements IClassMany01BIDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01BIDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_BI Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.createClass_Many_01_BI
     */
	public void createClassMany01BI(final ClassMany01BI classMany01BI) throws DaoException {
		LOG.debug("Create a new ClassMany01BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.updateClass_Many_01_BI
     */
	public void updateClassMany01BI(ClassMany01BI classMany01BI) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_BI with id =" + classMany01BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.deleteClass_Many_01_BI
   	 */
	public void deleteClassMany01BI(ClassMany01BI classMany01BI) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_BI with id =" + classMany01BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.findAllClass_Many_01_BIs
     */
	public Collection<ClassMany01BI> findAllClassMany01BIs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BI.class);
			Collection<ClassMany01BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_BI entity");
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.findClass_Many_01_BIById
     */
	public ClassMany01BI findClassMany01BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BI.class)
				.add(Restrictions.eq("id", id));
			ClassMany01BI result = (ClassMany01BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

