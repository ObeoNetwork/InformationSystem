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
import org.obeonetwork.sample.associations.ClassMany01END;
import org.obeonetwork.sample.associations.IClassMany01ENDDao;

// End of user code for import

/**
 * Implementation of DAO interface IClassMany01ENDDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IClassMany01ENDDao
 */
public class HibernateClassMany01ENDDao implements IClassMany01ENDDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateClassMany01ENDDao.class);

	/**
	 * Create a new element
	 * @param class_Many_01_END Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.createClass_Many_01_END
     */
	public void createClassMany01END(final ClassMany01END classMany01END) throws DaoException {
		LOG.debug("Create a new ClassMany01END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.updateClass_Many_01_END
     */
	public void updateClassMany01END(ClassMany01END classMany01END) throws DaoException {
		LOG.debug("Update the entity Class_Many_01_END with id =" + classMany01END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_END Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.deleteClass_Many_01_END
   	 */
	public void deleteClassMany01END(ClassMany01END classMany01END) throws DaoException {
		LOG.debug("Delete the entity Class_Many_01_END with id =" + classMany01END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.findAllClass_Many_01_ENDs
     */
	public Collection<ClassMany01END> findAllClassMany01ENDs() throws DaoException {
		LOG.debug("Find all instance of Class_Many_01_END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01END.class);
			Collection<ClassMany01END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class_Many_01_END entity");
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
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.findClass_Many_01_ENDById
     */
	public ClassMany01END findClassMany01ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_Many_01_END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01END.class)
				.add(Restrictions.eq("id", id));
			ClassMany01END result = (ClassMany01END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

