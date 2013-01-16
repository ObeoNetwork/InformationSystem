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
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao;

// End of user code

/**
 * Implementation of DAO interface IClass01ManyBIENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao
 */
public class HibernateClass01ManyBIENDDao implements IClass01ManyBIENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClass01ManyBIENDDao.class);

	/**
	 * Create a new element
	 * @param class_01_Many_BI_END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.createClass_01_Many_BI_END
     */
	public void createClass01ManyBIEND(final Class01ManyBIEND class01ManyBIEND) throws DaoException {
		LOG.debug("Create a new Class01ManyBIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI_END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.updateClass_01_Many_BI_END
     */
	public void updateClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException {
		LOG.debug("Update the entity Class_01_Many_BI_END with id =" + class01ManyBIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI_END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.deleteClass_01_Many_BI_END
   	 */
	public void deleteClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException {
		LOG.debug("Delete the entity Class_01_Many_BI_END with id =" + class01ManyBIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.findAllClass_01_Many_BI_ENDs
     */
	public Collection<Class01ManyBIEND> findAllClass01ManyBIENDs() throws DaoException {
		LOG.debug("Find all instance of Class_01_Many_BI_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIEND.class);
			Collection<Class01ManyBIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_01_Many_BI_END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.findClass_01_Many_BI_ENDById
     */
	public Class01ManyBIEND findClass01ManyBIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_01_Many_BI_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIEND.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBIEND result = (Class01ManyBIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

