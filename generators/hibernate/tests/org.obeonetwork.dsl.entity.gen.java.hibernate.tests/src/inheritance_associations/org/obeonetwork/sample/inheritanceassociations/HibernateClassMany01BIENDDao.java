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
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIEND;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao;

// End of user code

/**
 * Implementation of DAO interface IClassMany01BIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao
 */
public class HibernateClassMany01BIENDDao implements IClassMany01BIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01BIENDDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_BI_END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.createClass_Many_01_BI_END
     */
	public void createClassMany01BIEND(final ClassMany01BIEND classMany01BIEND) throws DaoException {
		LOG.debug("Create a new ClassMany01BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_BI_END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.updateClass_Many_01_BI_END
     */
	public void updateClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_BI_END with id =" + classMany01BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI_END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.deleteClass_Many_01_BI_END
   	 */
	public void deleteClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_BI_END with id =" + classMany01BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.findAllClass_Many_01_BI_ENDs
     */
	public Collection<ClassMany01BIEND> findAllClassMany01BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIEND.class);
			Collection<ClassMany01BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_BI_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.findClass_Many_01_BI_ENDById
     */
	public ClassMany01BIEND findClassMany01BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIEND.class)
				.add(Restrictions.eq("id", id));
			ClassMany01BIEND result = (ClassMany01BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

