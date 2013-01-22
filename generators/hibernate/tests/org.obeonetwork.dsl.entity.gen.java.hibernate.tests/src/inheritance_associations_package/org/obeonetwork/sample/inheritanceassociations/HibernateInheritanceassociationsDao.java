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
import org.obeonetwork.sample.inheritanceassociations.Class0101;
import org.obeonetwork.sample.inheritanceassociations.Class0101END;
import org.obeonetwork.sample.inheritanceassociations.Class0101BI;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class101;
import org.obeonetwork.sample.inheritanceassociations.Class101END;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.Class101BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class011;
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.Class011BI;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11;
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class01Many;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyEND;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBI;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01END;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BI;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIEND;
import org.obeonetwork.sample.inheritanceassociations.ClassManyMany;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEnd;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBI;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.Class0101ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class101EndSub;
import org.obeonetwork.sample.inheritanceassociations.Class101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class011ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class011BiENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01ENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEndSub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class0101Sub;
import org.obeonetwork.sample.inheritanceassociations.Class0101BISub;
import org.obeonetwork.sample.inheritanceassociations.Class101Sub;
import org.obeonetwork.sample.inheritanceassociations.Class101BISub;
import org.obeonetwork.sample.inheritanceassociations.Class011Sub;
import org.obeonetwork.sample.inheritanceassociations.Class011BISub;
import org.obeonetwork.sample.inheritanceassociations.Class11Sub;
import org.obeonetwork.sample.inheritanceassociations.Class11BISub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManySub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBISub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01Sub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BISub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManySub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBISub;
import org.obeonetwork.sample.inheritanceassociations.IInheritanceassociationsDao;

// End of user code

/**
 * Implementation of DAO interface IInheritanceassociationsDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IInheritanceassociationsDao
 */
public class HibernateInheritanceassociationsDao implements IInheritanceassociationsDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateInheritanceassociationsDao.class);

	/**
	 * Create a new element
	 * @param class0101 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.createClass0101
     */
	public void createClass0101(Class0101 class0101) throws DaoException {
		LOG.debug("Create a new Class0101 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.updateClass0101
     */
	public void updateClass0101(Class0101 class0101) throws DaoException {
		LOG.debug("Update the entity Class0101 with id =" + class0101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.deleteClass0101
   	 */
	public void deleteClass0101(Class0101 class0101) throws DaoException {
		LOG.debug("Delete the entity Class0101 with id =" + class0101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.findAllClass0101s
     */
	public Collection<Class0101> findAllClass0101s() throws DaoException {
		LOG.debug("Find all instance of Class0101 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101.class);
			Collection<Class0101> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.findClass0101ById
     */
	public Class0101 findClass0101ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101.class)
				.add(Restrictions.eq("id", id));
			Class0101 result = (Class0101)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class0101END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.createClass0101END
     */
	public void createClass0101END(Class0101END class0101END) throws DaoException {
		LOG.debug("Create a new Class0101END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.updateClass0101END
     */
	public void updateClass0101END(Class0101END class0101END) throws DaoException {
		LOG.debug("Update the entity Class0101END with id =" + class0101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.deleteClass0101END
   	 */
	public void deleteClass0101END(Class0101END class0101END) throws DaoException {
		LOG.debug("Delete the entity Class0101END with id =" + class0101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.findAllClass0101ENDs
     */
	public Collection<Class0101END> findAllClass0101ENDs() throws DaoException {
		LOG.debug("Find all instance of Class0101END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101END.class);
			Collection<Class0101END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.findClass0101ENDById
     */
	public Class0101END findClass0101ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101END.class)
				.add(Restrictions.eq("id", id));
			Class0101END result = (Class0101END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class0101BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.createClass0101BI
     */
	public void createClass0101BI(Class0101BI class0101BI) throws DaoException {
		LOG.debug("Create a new Class0101BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.updateClass0101BI
     */
	public void updateClass0101BI(Class0101BI class0101BI) throws DaoException {
		LOG.debug("Update the entity Class0101BI with id =" + class0101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.deleteClass0101BI
   	 */
	public void deleteClass0101BI(Class0101BI class0101BI) throws DaoException {
		LOG.debug("Delete the entity Class0101BI with id =" + class0101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.findAllClass0101BIs
     */
	public Collection<Class0101BI> findAllClass0101BIs() throws DaoException {
		LOG.debug("Find all instance of Class0101BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BI.class);
			Collection<Class0101BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.findClass0101BIById
     */
	public Class0101BI findClass0101BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BI.class)
				.add(Restrictions.eq("id", id));
			Class0101BI result = (Class0101BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class0101BIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.createClass0101BIEND
     */
	public void createClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Create a new Class0101BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101BIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.updateClass0101BIEND
     */
	public void updateClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Update the entity Class0101BIEND with id =" + class0101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101BIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.deleteClass0101BIEND
   	 */
	public void deleteClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Delete the entity Class0101BIEND with id =" + class0101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.findAllClass0101BIENDs
     */
	public Collection<Class0101BIEND> findAllClass0101BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class0101BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIEND.class);
			Collection<Class0101BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101BIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.findClass0101BIENDById
     */
	public Class0101BIEND findClass0101BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101BIEND entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIEND.class)
				.add(Restrictions.eq("id", id));
			Class0101BIEND result = (Class0101BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.createClass101
     */
	public void createClass101(Class101 class101) throws DaoException {
		LOG.debug("Create a new Class101 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.updateClass101
     */
	public void updateClass101(Class101 class101) throws DaoException {
		LOG.debug("Update the entity Class101 with id =" + class101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.deleteClass101
   	 */
	public void deleteClass101(Class101 class101) throws DaoException {
		LOG.debug("Delete the entity Class101 with id =" + class101.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.findAllClass101s
     */
	public Collection<Class101> findAllClass101s() throws DaoException {
		LOG.debug("Find all instance of Class101 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101.class);
			Collection<Class101> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.findClass101ById
     */
	public Class101 findClass101ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101.class)
				.add(Restrictions.eq("id", id));
			Class101 result = (Class101)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.createClass101END
     */
	public void createClass101END(Class101END class101END) throws DaoException {
		LOG.debug("Create a new Class101END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.updateClass101END
     */
	public void updateClass101END(Class101END class101END) throws DaoException {
		LOG.debug("Update the entity Class101END with id =" + class101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.deleteClass101END
   	 */
	public void deleteClass101END(Class101END class101END) throws DaoException {
		LOG.debug("Delete the entity Class101END with id =" + class101END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.findAllClass101ENDs
     */
	public Collection<Class101END> findAllClass101ENDs() throws DaoException {
		LOG.debug("Find all instance of Class101END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101END.class);
			Collection<Class101END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.findClass101ENDById
     */
	public Class101END findClass101ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101END.class)
				.add(Restrictions.eq("id", id));
			Class101END result = (Class101END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.createClass101BI
     */
	public void createClass101BI(Class101BI class101BI) throws DaoException {
		LOG.debug("Create a new Class101BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.updateClass101BI
     */
	public void updateClass101BI(Class101BI class101BI) throws DaoException {
		LOG.debug("Update the entity Class101BI with id =" + class101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.deleteClass101BI
   	 */
	public void deleteClass101BI(Class101BI class101BI) throws DaoException {
		LOG.debug("Delete the entity Class101BI with id =" + class101BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.findAllClass101BIs
     */
	public Collection<Class101BI> findAllClass101BIs() throws DaoException {
		LOG.debug("Find all instance of Class101BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BI.class);
			Collection<Class101BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.findClass101BIById
     */
	public Class101BI findClass101BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BI.class)
				.add(Restrictions.eq("id", id));
			Class101BI result = (Class101BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101BIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.createClass101BIEND
     */
	public void createClass101BIEND(Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Create a new Class101BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101BIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.updateClass101BIEND
     */
	public void updateClass101BIEND(Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Update the entity Class101BIEND with id =" + class101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101BIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.deleteClass101BIEND
   	 */
	public void deleteClass101BIEND(Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Delete the entity Class101BIEND with id =" + class101BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.findAllClass101BIENDs
     */
	public Collection<Class101BIEND> findAllClass101BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class101BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BIEND.class);
			Collection<Class101BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101BIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.findClass101BIENDById
     */
	public Class101BIEND findClass101BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101BIEND entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BIEND.class)
				.add(Restrictions.eq("id", id));
			Class101BIEND result = (Class101BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.createClass011
     */
	public void createClass011(Class011 class011) throws DaoException {
		LOG.debug("Create a new Class011 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.updateClass011
     */
	public void updateClass011(Class011 class011) throws DaoException {
		LOG.debug("Update the entity Class011 with id =" + class011.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.deleteClass011
   	 */
	public void deleteClass011(Class011 class011) throws DaoException {
		LOG.debug("Delete the entity Class011 with id =" + class011.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.findAllClass011s
     */
	public Collection<Class011> findAllClass011s() throws DaoException {
		LOG.debug("Find all instance of Class011 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011.class);
			Collection<Class011> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.findClass011ById
     */
	public Class011 findClass011ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011.class)
				.add(Restrictions.eq("id", id));
			Class011 result = (Class011)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.createClass011END
     */
	public void createClass011END(Class011END class011END) throws DaoException {
		LOG.debug("Create a new Class011END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.updateClass011END
     */
	public void updateClass011END(Class011END class011END) throws DaoException {
		LOG.debug("Update the entity Class011END with id =" + class011END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.deleteClass011END
   	 */
	public void deleteClass011END(Class011END class011END) throws DaoException {
		LOG.debug("Delete the entity Class011END with id =" + class011END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.findAllClass011ENDs
     */
	public Collection<Class011END> findAllClass011ENDs() throws DaoException {
		LOG.debug("Find all instance of Class011END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011END.class);
			Collection<Class011END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.findClass011ENDById
     */
	public Class011END findClass011ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011END.class)
				.add(Restrictions.eq("id", id));
			Class011END result = (Class011END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.createClass011BI
     */
	public void createClass011BI(Class011BI class011BI) throws DaoException {
		LOG.debug("Create a new Class011BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.updateClass011BI
     */
	public void updateClass011BI(Class011BI class011BI) throws DaoException {
		LOG.debug("Update the entity Class011BI with id =" + class011BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.deleteClass011BI
   	 */
	public void deleteClass011BI(Class011BI class011BI) throws DaoException {
		LOG.debug("Delete the entity Class011BI with id =" + class011BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.findAllClass011BIs
     */
	public Collection<Class011BI> findAllClass011BIs() throws DaoException {
		LOG.debug("Find all instance of Class011BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BI.class);
			Collection<Class011BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.findClass011BIById
     */
	public Class011BI findClass011BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BI.class)
				.add(Restrictions.eq("id", id));
			Class011BI result = (Class011BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011BIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.createClass011BIEND
     */
	public void createClass011BIEND(Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Create a new Class011BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011BIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.updateClass011BIEND
     */
	public void updateClass011BIEND(Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Update the entity Class011BIEND with id =" + class011BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011BIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.deleteClass011BIEND
   	 */
	public void deleteClass011BIEND(Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Delete the entity Class011BIEND with id =" + class011BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.findAllClass011BIENDs
     */
	public Collection<Class011BIEND> findAllClass011BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class011BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BIEND.class);
			Collection<Class011BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011BIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.findClass011BIENDById
     */
	public Class011BIEND findClass011BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011BIEND entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BIEND.class)
				.add(Restrictions.eq("id", id));
			Class011BIEND result = (Class011BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.createClass11
     */
	public void createClass11(Class11 class11) throws DaoException {
		LOG.debug("Create a new Class11 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.updateClass11
     */
	public void updateClass11(Class11 class11) throws DaoException {
		LOG.debug("Update the entity Class11 with id =" + class11.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.deleteClass11
   	 */
	public void deleteClass11(Class11 class11) throws DaoException {
		LOG.debug("Delete the entity Class11 with id =" + class11.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.findAllClass11s
     */
	public Collection<Class11> findAllClass11s() throws DaoException {
		LOG.debug("Find all instance of Class11 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11.class);
			Collection<Class11> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.findClass11ById
     */
	public Class11 findClass11ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11.class)
				.add(Restrictions.eq("id", id));
			Class11 result = (Class11)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.createClass11END
     */
	public void createClass11END(Class11END class11END) throws DaoException {
		LOG.debug("Create a new Class11END entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.updateClass11END
     */
	public void updateClass11END(Class11END class11END) throws DaoException {
		LOG.debug("Update the entity Class11END with id =" + class11END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.deleteClass11END
   	 */
	public void deleteClass11END(Class11END class11END) throws DaoException {
		LOG.debug("Delete the entity Class11END with id =" + class11END.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.findAllClass11ENDs
     */
	public Collection<Class11END> findAllClass11ENDs() throws DaoException {
		LOG.debug("Find all instance of Class11END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11END.class);
			Collection<Class11END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.findClass11ENDById
     */
	public Class11END findClass11ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11END entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11END.class)
				.add(Restrictions.eq("id", id));
			Class11END result = (Class11END)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.createClass11BI
     */
	public void createClass11BI(Class11BI class11BI) throws DaoException {
		LOG.debug("Create a new Class11BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.updateClass11BI
     */
	public void updateClass11BI(Class11BI class11BI) throws DaoException {
		LOG.debug("Update the entity Class11BI with id =" + class11BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.deleteClass11BI
   	 */
	public void deleteClass11BI(Class11BI class11BI) throws DaoException {
		LOG.debug("Delete the entity Class11BI with id =" + class11BI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.findAllClass11BIs
     */
	public Collection<Class11BI> findAllClass11BIs() throws DaoException {
		LOG.debug("Find all instance of Class11BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BI.class);
			Collection<Class11BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.findClass11BIById
     */
	public Class11BI findClass11BIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11BI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BI.class)
				.add(Restrictions.eq("id", id));
			Class11BI result = (Class11BI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11BIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.createClass11BIEND
     */
	public void createClass11BIEND(Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Create a new Class11BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11BIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.updateClass11BIEND
     */
	public void updateClass11BIEND(Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Update the entity Class11BIEND with id =" + class11BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11BIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.deleteClass11BIEND
   	 */
	public void deleteClass11BIEND(Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Delete the entity Class11BIEND with id =" + class11BIEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.findAllClass11BIENDs
     */
	public Collection<Class11BIEND> findAllClass11BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class11BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIEND.class);
			Collection<Class11BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11BIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.findClass11BIENDById
     */
	public Class11BIEND findClass11BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11BIEND entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIEND.class)
				.add(Restrictions.eq("id", id));
			Class11BIEND result = (Class11BIEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01Many Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.createClass01Many
     */
	public void createClass01Many(Class01Many class01Many) throws DaoException {
		LOG.debug("Create a new Class01Many entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01Many
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.updateClass01Many
     */
	public void updateClass01Many(Class01Many class01Many) throws DaoException {
		LOG.debug("Update the entity Class01Many with id =" + class01Many.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01Many Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.deleteClass01Many
   	 */
	public void deleteClass01Many(Class01Many class01Many) throws DaoException {
		LOG.debug("Delete the entity Class01Many with id =" + class01Many.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.findAllClass01Manys
     */
	public Collection<Class01Many> findAllClass01Manys() throws DaoException {
		LOG.debug("Find all instance of Class01Many entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01Many.class);
			Collection<Class01Many> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01Many entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.findClass01ManyById
     */
	public Class01Many findClass01ManyById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01Many entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01Many.class)
				.add(Restrictions.eq("id", id));
			Class01Many result = (Class01Many)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManyEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.createClass01ManyEND
     */
	public void createClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Create a new Class01ManyEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01ManyEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.updateClass01ManyEND
     */
	public void updateClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Update the entity Class01ManyEND with id =" + class01ManyEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01ManyEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.deleteClass01ManyEND
   	 */
	public void deleteClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Delete the entity Class01ManyEND with id =" + class01ManyEND.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.findAllClass01ManyENDs
     */
	public Collection<Class01ManyEND> findAllClass01ManyENDs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyEND.class);
			Collection<Class01ManyEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManyEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.findClass01ManyENDById
     */
	public Class01ManyEND findClass01ManyENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManyEND entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyEND.class)
				.add(Restrictions.eq("id", id));
			Class01ManyEND result = (Class01ManyEND)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManyBI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.createClass01ManyBI
     */
	public void createClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Create a new Class01ManyBI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01ManyBI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.updateClass01ManyBI
     */
	public void updateClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Update the entity Class01ManyBI with id =" + class01ManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01ManyBI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.deleteClass01ManyBI
   	 */
	public void deleteClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Delete the entity Class01ManyBI with id =" + class01ManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.findAllClass01ManyBIs
     */
	public Collection<Class01ManyBI> findAllClass01ManyBIs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBI.class);
			Collection<Class01ManyBI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManyBI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.findClass01ManyBIById
     */
	public Class01ManyBI findClass01ManyBIById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManyBI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBI.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBI result = (Class01ManyBI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManyBIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.createClass01ManyBIEND
     */
	public void createClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException {
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
	 * @param class01ManyBIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.updateClass01ManyBIEND
     */
	public void updateClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException {
		LOG.debug("Update the entity Class01ManyBIEND with id =" + class01ManyBIEND.getId());
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
	 * @param class01ManyBIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.deleteClass01ManyBIEND
   	 */
	public void deleteClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException {
		LOG.debug("Delete the entity Class01ManyBIEND with id =" + class01ManyBIEND.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.findAllClass01ManyBIENDs
     */
	public Collection<Class01ManyBIEND> findAllClass01ManyBIENDs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIEND.class);
			Collection<Class01ManyBIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManyBIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.findClass01ManyBIENDById
     */
	public Class01ManyBIEND findClass01ManyBIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManyBIEND entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classMany01 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.createClassMany01
     */
	public void createClassMany01(ClassMany01 classMany01) throws DaoException {
		LOG.debug("Create a new ClassMany01 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classMany01
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.updateClassMany01
     */
	public void updateClassMany01(ClassMany01 classMany01) throws DaoException {
		LOG.debug("Update the entity ClassMany01 with id =" + classMany01.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classMany01 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.deleteClassMany01
   	 */
	public void deleteClassMany01(ClassMany01 classMany01) throws DaoException {
		LOG.debug("Delete the entity ClassMany01 with id =" + classMany01.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.findAllClassMany01s
     */
	public Collection<ClassMany01> findAllClassMany01s() throws DaoException {
		LOG.debug("Find all instance of ClassMany01 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01.class);
			Collection<ClassMany01> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01 entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.findClassMany01ById
     */
	public ClassMany01 findClassMany01ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01.class)
				.add(Restrictions.eq("id", id));
			ClassMany01 result = (ClassMany01)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classMany01END Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.createClassMany01END
     */
	public void createClassMany01END(ClassMany01END classMany01END) throws DaoException {
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
	 * @param classMany01END
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.updateClassMany01END
     */
	public void updateClassMany01END(ClassMany01END classMany01END) throws DaoException {
		LOG.debug("Update the entity ClassMany01END with id =" + classMany01END.getId());
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
	 * @param classMany01END Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.deleteClassMany01END
   	 */
	public void deleteClassMany01END(ClassMany01END classMany01END) throws DaoException {
		LOG.debug("Delete the entity ClassMany01END with id =" + classMany01END.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.findAllClassMany01ENDs
     */
	public Collection<ClassMany01END> findAllClassMany01ENDs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01END entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01END.class);
			Collection<ClassMany01END> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01END entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.findClassMany01ENDById
     */
	public ClassMany01END findClassMany01ENDById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01END entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classMany01BI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.createClassMany01BI
     */
	public void createClassMany01BI(ClassMany01BI classMany01BI) throws DaoException {
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
	 * @param classMany01BI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.updateClassMany01BI
     */
	public void updateClassMany01BI(ClassMany01BI classMany01BI) throws DaoException {
		LOG.debug("Update the entity ClassMany01BI with id =" + classMany01BI.getId());
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
	 * @param classMany01BI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.deleteClassMany01BI
   	 */
	public void deleteClassMany01BI(ClassMany01BI classMany01BI) throws DaoException {
		LOG.debug("Delete the entity ClassMany01BI with id =" + classMany01BI.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.findAllClassMany01BIs
     */
	public Collection<ClassMany01BI> findAllClassMany01BIs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01BI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BI.class);
			Collection<ClassMany01BI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01BI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.findClassMany01BIById
     */
	public ClassMany01BI findClassMany01BIById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01BI entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classMany01BIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.createClassMany01BIEND
     */
	public void createClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException {
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
	 * @param classMany01BIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.updateClassMany01BIEND
     */
	public void updateClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException {
		LOG.debug("Update the entity ClassMany01BIEND with id =" + classMany01BIEND.getId());
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
	 * @param classMany01BIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.deleteClassMany01BIEND
   	 */
	public void deleteClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException {
		LOG.debug("Delete the entity ClassMany01BIEND with id =" + classMany01BIEND.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.findAllClassMany01BIENDs
     */
	public Collection<ClassMany01BIEND> findAllClassMany01BIENDs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01BIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIEND.class);
			Collection<ClassMany01BIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01BIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.findClassMany01BIENDById
     */
	public ClassMany01BIEND findClassMany01BIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01BIEND entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classManyMany Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.createClassManyMany
     */
	public void createClassManyMany(ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Create a new ClassManyMany entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classManyMany
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.updateClassManyMany
     */
	public void updateClassManyMany(ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Update the entity ClassManyMany with id =" + classManyMany.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classManyMany Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.deleteClassManyMany
   	 */
	public void deleteClassManyMany(ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Delete the entity ClassManyMany with id =" + classManyMany.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.findAllClassManyManys
     */
	public Collection<ClassManyMany> findAllClassManyManys() throws DaoException {
		LOG.debug("Find all instance of ClassManyMany entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyMany.class);
			Collection<ClassManyMany> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyMany entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.findClassManyManyById
     */
	public ClassManyMany findClassManyManyById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyMany entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyMany.class)
				.add(Restrictions.eq("id", id));
			ClassManyMany result = (ClassManyMany)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classManyManyEnd Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.createClassManyManyEnd
     */
	public void createClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Create a new ClassManyManyEnd entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classManyManyEnd
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.updateClassManyManyEnd
     */
	public void updateClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Update the entity ClassManyManyEnd with id =" + classManyManyEnd.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classManyManyEnd Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.deleteClassManyManyEnd
   	 */
	public void deleteClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Delete the entity ClassManyManyEnd with id =" + classManyManyEnd.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.findAllClassManyManyEnds
     */
	public Collection<ClassManyManyEnd> findAllClassManyManyEnds() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyEnd entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEnd.class);
			Collection<ClassManyManyEnd> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManyEnd entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.findClassManyManyEndById
     */
	public ClassManyManyEnd findClassManyManyEndById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyEnd entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEnd.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyEnd result = (ClassManyManyEnd)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classManyManyBI Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.createClassManyManyBI
     */
	public void createClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Create a new ClassManyManyBI entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classManyManyBI
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.updateClassManyManyBI
     */
	public void updateClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBI with id =" + classManyManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classManyManyBI Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.deleteClassManyManyBI
   	 */
	public void deleteClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Delete the entity ClassManyManyBI with id =" + classManyManyBI.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.findAllClassManyManyBIs
     */
	public Collection<ClassManyManyBI> findAllClassManyManyBIs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBI entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBI.class);
			Collection<ClassManyManyBI> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManyBI entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.findClassManyManyBIById
     */
	public ClassManyManyBI findClassManyManyBIById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyBI entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBI.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBI result = (ClassManyManyBI)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classManyManyBIEND Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.createClassManyManyBIEND
     */
	public void createClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException {
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
	 * @param classManyManyBIEND
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.updateClassManyManyBIEND
     */
	public void updateClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBIEND with id =" + classManyManyBIEND.getId());
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
	 * @param classManyManyBIEND Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.deleteClassManyManyBIEND
   	 */
	public void deleteClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException {
		LOG.debug("Delete the entity ClassManyManyBIEND with id =" + classManyManyBIEND.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.findAllClassManyManyBIENDs
     */
	public Collection<ClassManyManyBIEND> findAllClassManyManyBIENDs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBIEND entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIEND.class);
			Collection<ClassManyManyBIEND> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManyBIEND entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.findClassManyManyBIENDById
     */
	public ClassManyManyBIEND findClassManyManyBIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyBIEND entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param class0101ENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.createClass0101ENDSub
     */
	public void createClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException {
		LOG.debug("Create a new Class0101ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101ENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.updateClass0101ENDSub
     */
	public void updateClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException {
		LOG.debug("Update the entity Class0101ENDSub with id =" + class0101ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101ENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.deleteClass0101ENDSub
   	 */
	public void deleteClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException {
		LOG.debug("Delete the entity Class0101ENDSub with id =" + class0101ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.findAllClass0101ENDSubs
     */
	public Collection<Class0101ENDSub> findAllClass0101ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class0101ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101ENDSub.class);
			Collection<Class0101ENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101ENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.findClass0101ENDSubById
     */
	public Class0101ENDSub findClass0101ENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101ENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101ENDSub.class)
				.add(Restrictions.eq("id", id));
			Class0101ENDSub result = (Class0101ENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class0101BIENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.createClass0101BIENDSub
     */
	public void createClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Create a new Class0101BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101BIENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.updateClass0101BIENDSub
     */
	public void updateClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class0101BIENDSub with id =" + class0101BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101BIENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.deleteClass0101BIENDSub
   	 */
	public void deleteClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class0101BIENDSub with id =" + class0101BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.findAllClass0101BIENDSubs
     */
	public Collection<Class0101BIENDSub> findAllClass0101BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class0101BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIENDSub.class);
			Collection<Class0101BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101BIENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.findClass0101BIENDSubById
     */
	public Class0101BIENDSub findClass0101BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101BIENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class0101BIENDSub result = (Class0101BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101EndSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.createClass101EndSub
     */
	public void createClass101EndSub(Class101EndSub class101EndSub) throws DaoException {
		LOG.debug("Create a new Class101EndSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101EndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101EndSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.updateClass101EndSub
     */
	public void updateClass101EndSub(Class101EndSub class101EndSub) throws DaoException {
		LOG.debug("Update the entity Class101EndSub with id =" + class101EndSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101EndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101EndSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.deleteClass101EndSub
   	 */
	public void deleteClass101EndSub(Class101EndSub class101EndSub) throws DaoException {
		LOG.debug("Delete the entity Class101EndSub with id =" + class101EndSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101EndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.findAllClass101EndSubs
     */
	public Collection<Class101EndSub> findAllClass101EndSubs() throws DaoException {
		LOG.debug("Find all instance of Class101EndSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101EndSub.class);
			Collection<Class101EndSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101EndSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.findClass101EndSubById
     */
	public Class101EndSub findClass101EndSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101EndSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101EndSub.class)
				.add(Restrictions.eq("id", id));
			Class101EndSub result = (Class101EndSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101BIENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.createClass101BIENDSub
     */
	public void createClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException {
		LOG.debug("Create a new Class101BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101BIENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.updateClass101BIENDSub
     */
	public void updateClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class101BIENDSub with id =" + class101BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101BIENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.deleteClass101BIENDSub
   	 */
	public void deleteClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class101BIENDSub with id =" + class101BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.findAllClass101BIENDSubs
     */
	public Collection<Class101BIENDSub> findAllClass101BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class101BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BIENDSub.class);
			Collection<Class101BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101BIENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.findClass101BIENDSubById
     */
	public Class101BIENDSub findClass101BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101BIENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class101BIENDSub result = (Class101BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011ENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.createClass011ENDSub
     */
	public void createClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException {
		LOG.debug("Create a new Class011ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011ENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.updateClass011ENDSub
     */
	public void updateClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException {
		LOG.debug("Update the entity Class011ENDSub with id =" + class011ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011ENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.deleteClass011ENDSub
   	 */
	public void deleteClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException {
		LOG.debug("Delete the entity Class011ENDSub with id =" + class011ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.findAllClass011ENDSubs
     */
	public Collection<Class011ENDSub> findAllClass011ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class011ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011ENDSub.class);
			Collection<Class011ENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011ENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.findClass011ENDSubById
     */
	public Class011ENDSub findClass011ENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011ENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011ENDSub.class)
				.add(Restrictions.eq("id", id));
			Class011ENDSub result = (Class011ENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011BiENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.createClass011BiENDSub
     */
	public void createClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException {
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
	 * @param class011BiENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.updateClass011BiENDSub
     */
	public void updateClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException {
		LOG.debug("Update the entity Class011BiENDSub with id =" + class011BiENDSub.getId());
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
	 * @param class011BiENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.deleteClass011BiENDSub
   	 */
	public void deleteClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException {
		LOG.debug("Delete the entity Class011BiENDSub with id =" + class011BiENDSub.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.findAllClass011BiENDSubs
     */
	public Collection<Class011BiENDSub> findAllClass011BiENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class011BiENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BiENDSub.class);
			Collection<Class011BiENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011BiENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.findClass011BiENDSubById
     */
	public Class011BiENDSub findClass011BiENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011BiENDSub entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param class11ENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.createClass11ENDSub
     */
	public void createClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Create a new Class11ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11ENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.updateClass11ENDSub
     */
	public void updateClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Update the entity Class11ENDSub with id =" + class11ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11ENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.deleteClass11ENDSub
   	 */
	public void deleteClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Delete the entity Class11ENDSub with id =" + class11ENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.findAllClass11ENDSubs
     */
	public Collection<Class11ENDSub> findAllClass11ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class11ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11ENDSub.class);
			Collection<Class11ENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11ENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.findClass11ENDSubById
     */
	public Class11ENDSub findClass11ENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11ENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11ENDSub.class)
				.add(Restrictions.eq("id", id));
			Class11ENDSub result = (Class11ENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11BIENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.createClass11BIENDSub
     */
	public void createClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Create a new Class11BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11BIENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.updateClass11BIENDSub
     */
	public void updateClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class11BIENDSub with id =" + class11BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11BIENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.deleteClass11BIENDSub
   	 */
	public void deleteClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class11BIENDSub with id =" + class11BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.findAllClass11BIENDSubs
     */
	public Collection<Class11BIENDSub> findAllClass11BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class11BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIENDSub.class);
			Collection<Class11BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11BIENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.findClass11BIENDSubById
     */
	public Class11BIENDSub findClass11BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11BIENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class11BIENDSub result = (Class11BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManyENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.createClass01ManyENDSub
     */
	public void createClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Create a new Class01ManyENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01ManyENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.updateClass01ManyENDSub
     */
	public void updateClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Update the entity Class01ManyENDSub with id =" + class01ManyENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01ManyENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.deleteClass01ManyENDSub
   	 */
	public void deleteClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Delete the entity Class01ManyENDSub with id =" + class01ManyENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.findAllClass01ManyENDSubs
     */
	public Collection<Class01ManyENDSub> findAllClass01ManyENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyENDSub.class);
			Collection<Class01ManyENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManyENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.findClass01ManyENDSubById
     */
	public Class01ManyENDSub findClass01ManyENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManyENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyENDSub.class)
				.add(Restrictions.eq("id", id));
			Class01ManyENDSub result = (Class01ManyENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManyBIENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.createClass01ManyBIENDSub
     */
	public void createClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Create a new Class01ManyBIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01ManyBIENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.updateClass01ManyBIENDSub
     */
	public void updateClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Update the entity Class01ManyBIENDSub with id =" + class01ManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01ManyBIENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.deleteClass01ManyBIENDSub
   	 */
	public void deleteClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Delete the entity Class01ManyBIENDSub with id =" + class01ManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.findAllClass01ManyBIENDSubs
     */
	public Collection<Class01ManyBIENDSub> findAllClass01ManyBIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIENDSub.class);
			Collection<Class01ManyBIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManyBIENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.findClass01ManyBIENDSubById
     */
	public Class01ManyBIENDSub findClass01ManyBIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManyBIENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBIENDSub.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBIENDSub result = (Class01ManyBIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classMany01ENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.createClassMany01ENDSub
     */
	public void createClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException {
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
	 * @param classMany01ENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.updateClassMany01ENDSub
     */
	public void updateClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException {
		LOG.debug("Update the entity ClassMany01ENDSub with id =" + classMany01ENDSub.getId());
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
	 * @param classMany01ENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.deleteClassMany01ENDSub
   	 */
	public void deleteClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException {
		LOG.debug("Delete the entity ClassMany01ENDSub with id =" + classMany01ENDSub.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.findAllClassMany01ENDSubs
     */
	public Collection<ClassMany01ENDSub> findAllClassMany01ENDSubs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01ENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01ENDSub.class);
			Collection<ClassMany01ENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01ENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.findClassMany01ENDSubById
     */
	public ClassMany01ENDSub findClassMany01ENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01ENDSub entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classMany01BIENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.createClassMany01BIENDSub
     */
	public void createClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Create a new ClassMany01BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classMany01BIENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.updateClassMany01BIENDSub
     */
	public void updateClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Update the entity ClassMany01BIENDSub with id =" + classMany01BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classMany01BIENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.deleteClassMany01BIENDSub
   	 */
	public void deleteClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Delete the entity ClassMany01BIENDSub with id =" + classMany01BIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.findAllClassMany01BIENDSubs
     */
	public Collection<ClassMany01BIENDSub> findAllClassMany01BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01BIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIENDSub.class);
			Collection<ClassMany01BIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01BIENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.findClassMany01BIENDSubById
     */
	public ClassMany01BIENDSub findClassMany01BIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01BIENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BIENDSub.class)
				.add(Restrictions.eq("id", id));
			ClassMany01BIENDSub result = (ClassMany01BIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classManyManyEndSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.createClassManyManyEndSub
     */
	public void createClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Create a new ClassManyManyEndSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classManyManyEndSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.updateClassManyManyEndSub
     */
	public void updateClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Update the entity ClassManyManyEndSub with id =" + classManyManyEndSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classManyManyEndSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.deleteClassManyManyEndSub
   	 */
	public void deleteClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Delete the entity ClassManyManyEndSub with id =" + classManyManyEndSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.findAllClassManyManyEndSubs
     */
	public Collection<ClassManyManyEndSub> findAllClassManyManyEndSubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyEndSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEndSub.class);
			Collection<ClassManyManyEndSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManyEndSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.findClassManyManyEndSubById
     */
	public ClassManyManyEndSub findClassManyManyEndSubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyEndSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyEndSub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyEndSub result = (ClassManyManyEndSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classManyManyBIENDSub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.createClassManyManyBIENDSub
     */
	public void createClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Create a new ClassManyManyBIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classManyManyBIENDSub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.updateClassManyManyBIENDSub
     */
	public void updateClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBIENDSub with id =" + classManyManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classManyManyBIENDSub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.deleteClassManyManyBIENDSub
   	 */
	public void deleteClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Delete the entity ClassManyManyBIENDSub with id =" + classManyManyBIENDSub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.findAllClassManyManyBIENDSubs
     */
	public Collection<ClassManyManyBIENDSub> findAllClassManyManyBIENDSubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBIENDSub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIENDSub.class);
			Collection<ClassManyManyBIENDSub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManyBIENDSub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.findClassManyManyBIENDSubById
     */
	public ClassManyManyBIENDSub findClassManyManyBIENDSubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyBIENDSub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBIENDSub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBIENDSub result = (ClassManyManyBIENDSub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class0101Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.createClass0101Sub
     */
	public void createClass0101Sub(Class0101Sub class0101Sub) throws DaoException {
		LOG.debug("Create a new Class0101Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.updateClass0101Sub
     */
	public void updateClass0101Sub(Class0101Sub class0101Sub) throws DaoException {
		LOG.debug("Update the entity Class0101Sub with id =" + class0101Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.deleteClass0101Sub
   	 */
	public void deleteClass0101Sub(Class0101Sub class0101Sub) throws DaoException {
		LOG.debug("Delete the entity Class0101Sub with id =" + class0101Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.findAllClass0101Subs
     */
	public Collection<Class0101Sub> findAllClass0101Subs() throws DaoException {
		LOG.debug("Find all instance of Class0101Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101Sub.class);
			Collection<Class0101Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.findClass0101SubById
     */
	public Class0101Sub findClass0101SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101Sub.class)
				.add(Restrictions.eq("id", id));
			Class0101Sub result = (Class0101Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class0101BISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.createClass0101BISub
     */
	public void createClass0101BISub(Class0101BISub class0101BISub) throws DaoException {
		LOG.debug("Create a new Class0101BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class0101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class0101BISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.updateClass0101BISub
     */
	public void updateClass0101BISub(Class0101BISub class0101BISub) throws DaoException {
		LOG.debug("Update the entity Class0101BISub with id =" + class0101BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class0101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class0101BISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.deleteClass0101BISub
   	 */
	public void deleteClass0101BISub(Class0101BISub class0101BISub) throws DaoException {
		LOG.debug("Delete the entity Class0101BISub with id =" + class0101BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class0101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.findAllClass0101BISubs
     */
	public Collection<Class0101BISub> findAllClass0101BISubs() throws DaoException {
		LOG.debug("Find all instance of Class0101BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BISub.class);
			Collection<Class0101BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class0101BISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.findClass0101BISubById
     */
	public Class0101BISub findClass0101BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class0101BISub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class0101BISub.class)
				.add(Restrictions.eq("id", id));
			Class0101BISub result = (Class0101BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.createClass101Sub
     */
	public void createClass101Sub(Class101Sub class101Sub) throws DaoException {
		LOG.debug("Create a new Class101Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.updateClass101Sub
     */
	public void updateClass101Sub(Class101Sub class101Sub) throws DaoException {
		LOG.debug("Update the entity Class101Sub with id =" + class101Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.deleteClass101Sub
   	 */
	public void deleteClass101Sub(Class101Sub class101Sub) throws DaoException {
		LOG.debug("Delete the entity Class101Sub with id =" + class101Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.findAllClass101Subs
     */
	public Collection<Class101Sub> findAllClass101Subs() throws DaoException {
		LOG.debug("Find all instance of Class101Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101Sub.class);
			Collection<Class101Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.findClass101SubById
     */
	public Class101Sub findClass101SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101Sub.class)
				.add(Restrictions.eq("id", id));
			Class101Sub result = (Class101Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class101BISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.createClass101BISub
     */
	public void createClass101BISub(Class101BISub class101BISub) throws DaoException {
		LOG.debug("Create a new Class101BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class101BISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.updateClass101BISub
     */
	public void updateClass101BISub(Class101BISub class101BISub) throws DaoException {
		LOG.debug("Update the entity Class101BISub with id =" + class101BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class101BISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.deleteClass101BISub
   	 */
	public void deleteClass101BISub(Class101BISub class101BISub) throws DaoException {
		LOG.debug("Delete the entity Class101BISub with id =" + class101BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.findAllClass101BISubs
     */
	public Collection<Class101BISub> findAllClass101BISubs() throws DaoException {
		LOG.debug("Find all instance of Class101BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BISub.class);
			Collection<Class101BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class101BISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.findClass101BISubById
     */
	public Class101BISub findClass101BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class101BISub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class101BISub.class)
				.add(Restrictions.eq("id", id));
			Class101BISub result = (Class101BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.createClass011Sub
     */
	public void createClass011Sub(Class011Sub class011Sub) throws DaoException {
		LOG.debug("Create a new Class011Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.updateClass011Sub
     */
	public void updateClass011Sub(Class011Sub class011Sub) throws DaoException {
		LOG.debug("Update the entity Class011Sub with id =" + class011Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.deleteClass011Sub
   	 */
	public void deleteClass011Sub(Class011Sub class011Sub) throws DaoException {
		LOG.debug("Delete the entity Class011Sub with id =" + class011Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.findAllClass011Subs
     */
	public Collection<Class011Sub> findAllClass011Subs() throws DaoException {
		LOG.debug("Find all instance of Class011Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011Sub.class);
			Collection<Class011Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.findClass011SubById
     */
	public Class011Sub findClass011SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011Sub.class)
				.add(Restrictions.eq("id", id));
			Class011Sub result = (Class011Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class011BISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.createClass011BISub
     */
	public void createClass011BISub(Class011BISub class011BISub) throws DaoException {
		LOG.debug("Create a new Class011BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class011BISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.updateClass011BISub
     */
	public void updateClass011BISub(Class011BISub class011BISub) throws DaoException {
		LOG.debug("Update the entity Class011BISub with id =" + class011BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class011BISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.deleteClass011BISub
   	 */
	public void deleteClass011BISub(Class011BISub class011BISub) throws DaoException {
		LOG.debug("Delete the entity Class011BISub with id =" + class011BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.findAllClass011BISubs
     */
	public Collection<Class011BISub> findAllClass011BISubs() throws DaoException {
		LOG.debug("Find all instance of Class011BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BISub.class);
			Collection<Class011BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class011BISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.findClass011BISubById
     */
	public Class011BISub findClass011BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class011BISub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class011BISub.class)
				.add(Restrictions.eq("id", id));
			Class011BISub result = (Class011BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.createClass11Sub
     */
	public void createClass11Sub(Class11Sub class11Sub) throws DaoException {
		LOG.debug("Create a new Class11Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.updateClass11Sub
     */
	public void updateClass11Sub(Class11Sub class11Sub) throws DaoException {
		LOG.debug("Update the entity Class11Sub with id =" + class11Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.deleteClass11Sub
   	 */
	public void deleteClass11Sub(Class11Sub class11Sub) throws DaoException {
		LOG.debug("Delete the entity Class11Sub with id =" + class11Sub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.findAllClass11Subs
     */
	public Collection<Class11Sub> findAllClass11Subs() throws DaoException {
		LOG.debug("Find all instance of Class11Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11Sub.class);
			Collection<Class11Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.findClass11SubById
     */
	public Class11Sub findClass11SubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11Sub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11Sub.class)
				.add(Restrictions.eq("id", id));
			Class11Sub result = (Class11Sub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class11BISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.createClass11BISub
     */
	public void createClass11BISub(Class11BISub class11BISub) throws DaoException {
		LOG.debug("Create a new Class11BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class11BISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.updateClass11BISub
     */
	public void updateClass11BISub(Class11BISub class11BISub) throws DaoException {
		LOG.debug("Update the entity Class11BISub with id =" + class11BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class11BISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.deleteClass11BISub
   	 */
	public void deleteClass11BISub(Class11BISub class11BISub) throws DaoException {
		LOG.debug("Delete the entity Class11BISub with id =" + class11BISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.findAllClass11BISubs
     */
	public Collection<Class11BISub> findAllClass11BISubs() throws DaoException {
		LOG.debug("Find all instance of Class11BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BISub.class);
			Collection<Class11BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class11BISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.findClass11BISubById
     */
	public Class11BISub findClass11BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class11BISub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class11BISub.class)
				.add(Restrictions.eq("id", id));
			Class11BISub result = (Class11BISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManySub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.createClass01ManySub
     */
	public void createClass01ManySub(Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Create a new Class01ManySub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01ManySub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.updateClass01ManySub
     */
	public void updateClass01ManySub(Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Update the entity Class01ManySub with id =" + class01ManySub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01ManySub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.deleteClass01ManySub
   	 */
	public void deleteClass01ManySub(Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Delete the entity Class01ManySub with id =" + class01ManySub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.findAllClass01ManySubs
     */
	public Collection<Class01ManySub> findAllClass01ManySubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManySub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManySub.class);
			Collection<Class01ManySub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManySub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.findClass01ManySubById
     */
	public Class01ManySub findClass01ManySubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManySub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManySub.class)
				.add(Restrictions.eq("id", id));
			Class01ManySub result = (Class01ManySub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class01ManyBISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.createClass01ManyBISub
     */
	public void createClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Create a new Class01ManyBISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class01ManyBISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.updateClass01ManyBISub
     */
	public void updateClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Update the entity Class01ManyBISub with id =" + class01ManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class01ManyBISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.deleteClass01ManyBISub
   	 */
	public void deleteClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Delete the entity Class01ManyBISub with id =" + class01ManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.findAllClass01ManyBISubs
     */
	public Collection<Class01ManyBISub> findAllClass01ManyBISubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBISub.class);
			Collection<Class01ManyBISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Class01ManyBISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.findClass01ManyBISubById
     */
	public Class01ManyBISub findClass01ManyBISubById(String id) throws DaoException {
		LOG.debug("Find one instance of Class01ManyBISub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class01ManyBISub.class)
				.add(Restrictions.eq("id", id));
			Class01ManyBISub result = (Class01ManyBISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classMany01Sub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.createClassMany01Sub
     */
	public void createClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException {
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
	 * @param classMany01Sub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.updateClassMany01Sub
     */
	public void updateClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException {
		LOG.debug("Update the entity ClassMany01Sub with id =" + classMany01Sub.getId());
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
	 * @param classMany01Sub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.deleteClassMany01Sub
   	 */
	public void deleteClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException {
		LOG.debug("Delete the entity ClassMany01Sub with id =" + classMany01Sub.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.findAllClassMany01Subs
     */
	public Collection<ClassMany01Sub> findAllClassMany01Subs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01Sub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01Sub.class);
			Collection<ClassMany01Sub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01Sub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.findClassMany01SubById
     */
	public ClassMany01Sub findClassMany01SubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01Sub entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classMany01BISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.createClassMany01BISub
     */
	public void createClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException {
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
	 * @param classMany01BISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.updateClassMany01BISub
     */
	public void updateClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException {
		LOG.debug("Update the entity ClassMany01BISub with id =" + classMany01BISub.getId());
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
	 * @param classMany01BISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.deleteClassMany01BISub
   	 */
	public void deleteClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException {
		LOG.debug("Delete the entity ClassMany01BISub with id =" + classMany01BISub.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.findAllClassMany01BISubs
     */
	public Collection<ClassMany01BISub> findAllClassMany01BISubs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01BISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassMany01BISub.class);
			Collection<ClassMany01BISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassMany01BISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.findClassMany01BISubById
     */
	public ClassMany01BISub findClassMany01BISubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassMany01BISub entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classManyManySub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.createClassManyManySub
     */
	public void createClassManyManySub(ClassManyManySub classManyManySub) throws DaoException {
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
	 * @param classManyManySub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.updateClassManyManySub
     */
	public void updateClassManyManySub(ClassManyManySub classManyManySub) throws DaoException {
		LOG.debug("Update the entity ClassManyManySub with id =" + classManyManySub.getId());
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
	 * @param classManyManySub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.deleteClassManyManySub
   	 */
	public void deleteClassManyManySub(ClassManyManySub classManyManySub) throws DaoException {
		LOG.debug("Delete the entity ClassManyManySub with id =" + classManyManySub.getId());
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.findAllClassManyManySubs
     */
	public Collection<ClassManyManySub> findAllClassManyManySubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManySub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManySub.class);
			Collection<ClassManyManySub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManySub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.findClassManyManySubById
     */
	public ClassManyManySub findClassManyManySubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManySub entity by id : " + id);
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
	

	/**
	 * Create a new element
	 * @param classManyManyBISub Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.createClassManyManyBISub
     */
	public void createClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Create a new ClassManyManyBISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classManyManyBISub
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.updateClassManyManyBISub
     */
	public void updateClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBISub with id =" + classManyManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classManyManyBISub Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.deleteClassManyManyBISub
   	 */
	public void deleteClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Delete the entity ClassManyManyBISub with id =" + classManyManyBISub.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.findAllClassManyManyBISubs
     */
	public Collection<ClassManyManyBISub> findAllClassManyManyBISubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBISub entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBISub.class);
			Collection<ClassManyManyBISub> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassManyManyBISub entity");
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.findClassManyManyBISubById
     */
	public ClassManyManyBISub findClassManyManyBISubById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyBISub entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassManyManyBISub.class)
				.add(Restrictions.eq("id", id));
			ClassManyManyBISub result = (ClassManyManyBISub)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

