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
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BISub;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao;

// End of user code

/**
 * Implementation of DAO interface IClassMany01BISubDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao
 */
public class HibernateClassMany01BISubDao implements IClassMany01BISubDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01BISubDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_BI_Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.createClass_Many_01_BI_Sub
     */
	public void createClassMany01BISub(final ClassMany01BISub classMany01BISub) throws DaoException {
		LOG.debug("Create a new ClassMany01BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.updateClass_Many_01_BI_Sub
     */
	public void updateClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_BI_Sub with id =" + classMany01BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI_Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.deleteClass_Many_01_BI_Sub
   	 */
	public void deleteClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_BI_Sub with id =" + classMany01BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.findAllClass_Many_01_BI_Subs
     */
	public Collection<ClassMany01BISub> findAllClassMany01BISubs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_BI_Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BISub.class);
			Collection<ClassMany01BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_BI_Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.findClass_Many_01_BI_SubById
     */
	public ClassMany01BISub findClassMany01BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_BI_Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BISub.class)
				.add(Restrictions.eq("id", id));
			ClassMany01BISub result = (ClassMany01BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

