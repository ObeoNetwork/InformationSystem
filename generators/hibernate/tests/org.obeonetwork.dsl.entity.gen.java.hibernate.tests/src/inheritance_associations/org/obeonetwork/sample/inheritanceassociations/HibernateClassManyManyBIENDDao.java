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
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassManyManyBIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao
 */
public class HibernateClassManyManyBIENDDao implements IClassManyManyBIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassManyManyBIENDDao.class);

	/**
	 * Create a new element
	 * @param class_Many_Many_BI_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.createClass_Many_Many_BI_END
     */
	public void createClassManyManyBIEND(final ClassManyManyBIEND classManyManyBIEND) throws DaoException {
		LOG.debug("Create a new ClassManyManyBIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.updateClass_Many_Many_BI_END
     */
	public void updateClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException {
		LOG.debug("Update the entity Class_Many_Many_BI_END with id =" + classManyManyBIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.deleteClass_Many_Many_BI_END
   	 */
	public void deleteClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException {
		LOG.debug("Delete the entity Class_Many_Many_BI_END with id =" + classManyManyBIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.findAllClass_Many_Many_BI_ENDs
     */
	public Collection<ClassManyManyBIEND> findAllClassManyManyBIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_Many_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIEND.class);
			Collection<ClassManyManyBIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_Many_BI_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.findClass_Many_Many_BI_ENDById
     */
	public ClassManyManyBIEND findClassManyManyBIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_Many_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIEND.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBIEND result = (ClassManyManyBIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

