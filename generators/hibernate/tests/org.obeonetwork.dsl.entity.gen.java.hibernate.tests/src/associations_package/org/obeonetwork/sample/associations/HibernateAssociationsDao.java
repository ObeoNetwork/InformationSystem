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
import org.obeonetwork.sample.associations.Class0101;
import org.obeonetwork.sample.associations.Class0101END;
import org.obeonetwork.sample.associations.Class0101BI;
import org.obeonetwork.sample.associations.Class0101BIEND;
import org.obeonetwork.sample.associations.Class101;
import org.obeonetwork.sample.associations.Class101END;
import org.obeonetwork.sample.associations.Class101BI;
import org.obeonetwork.sample.associations.Class101BIEND;
import org.obeonetwork.sample.associations.Class011;
import org.obeonetwork.sample.associations.Class011END;
import org.obeonetwork.sample.associations.Class011BI;
import org.obeonetwork.sample.associations.Class011BIEND;
import org.obeonetwork.sample.associations.Class11;
import org.obeonetwork.sample.associations.Class11END;
import org.obeonetwork.sample.associations.Class11BI;
import org.obeonetwork.sample.associations.Class11BIEND;
import org.obeonetwork.sample.associations.Class01Many;
import org.obeonetwork.sample.associations.Class01ManyEND;
import org.obeonetwork.sample.associations.Class01ManyBI;
import org.obeonetwork.sample.associations.Class01ManyBIEND;
import org.obeonetwork.sample.associations.ClassMany01;
import org.obeonetwork.sample.associations.ClassMany01END;
import org.obeonetwork.sample.associations.ClassMany01BI;
import org.obeonetwork.sample.associations.ClassMany01BIEND;
import org.obeonetwork.sample.associations.ClassManyMany;
import org.obeonetwork.sample.associations.ClassManyManyEnd;
import org.obeonetwork.sample.associations.ClassManyManyBI;
import org.obeonetwork.sample.associations.ClassManyManyBIEND;
import org.obeonetwork.sample.associations.IAssociationsDao;

// End of user code

/**
 * Implementation of DAO interface IAssociationsDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IAssociationsDao
 */
public class HibernateAssociationsDao implements IAssociationsDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateAssociationsDao.class);

	/**
	 * Create a new element
	 * @param class0101 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.createClass0101
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
     * @see org.obeonetwork.sample.associations.IClass0101Dao.updateClass0101
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
     * @see org.obeonetwork.sample.associations.IClass0101Dao.deleteClass0101
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
     * @see org.obeonetwork.sample.associations.IClass0101Dao.findAllClass0101s
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
     * @see org.obeonetwork.sample.associations.IClass0101Dao.findClass0101ById
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
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.createClass0101END
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
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.updateClass0101END
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
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.deleteClass0101END
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
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.findAllClass0101ENDs
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
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.findClass0101ENDById
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
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.createClass0101BI
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
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.updateClass0101BI
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
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.deleteClass0101BI
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
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.findAllClass0101BIs
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
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.findClass0101BIById
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
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.createClass0101BIEND
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
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.updateClass0101BIEND
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
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.deleteClass0101BIEND
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
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.findAllClass0101BIENDs
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
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.findClass0101BIENDById
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
     * @see org.obeonetwork.sample.associations.IClass101Dao.createClass101
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
     * @see org.obeonetwork.sample.associations.IClass101Dao.updateClass101
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
     * @see org.obeonetwork.sample.associations.IClass101Dao.deleteClass101
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
     * @see org.obeonetwork.sample.associations.IClass101Dao.findAllClass101s
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
     * @see org.obeonetwork.sample.associations.IClass101Dao.findClass101ById
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
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.createClass101END
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
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.updateClass101END
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
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.deleteClass101END
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
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.findAllClass101ENDs
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
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.findClass101ENDById
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
     * @see org.obeonetwork.sample.associations.IClass101BIDao.createClass101BI
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
     * @see org.obeonetwork.sample.associations.IClass101BIDao.updateClass101BI
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
     * @see org.obeonetwork.sample.associations.IClass101BIDao.deleteClass101BI
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
     * @see org.obeonetwork.sample.associations.IClass101BIDao.findAllClass101BIs
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
     * @see org.obeonetwork.sample.associations.IClass101BIDao.findClass101BIById
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
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.createClass101BIEND
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
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.updateClass101BIEND
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
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.deleteClass101BIEND
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
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.findAllClass101BIENDs
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
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.findClass101BIENDById
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
     * @see org.obeonetwork.sample.associations.IClass011Dao.createClass011
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
     * @see org.obeonetwork.sample.associations.IClass011Dao.updateClass011
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
     * @see org.obeonetwork.sample.associations.IClass011Dao.deleteClass011
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
     * @see org.obeonetwork.sample.associations.IClass011Dao.findAllClass011s
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
     * @see org.obeonetwork.sample.associations.IClass011Dao.findClass011ById
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
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.createClass011END
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
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.updateClass011END
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
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.deleteClass011END
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
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.findAllClass011ENDs
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
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.findClass011ENDById
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
     * @see org.obeonetwork.sample.associations.IClass011BIDao.createClass011BI
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
     * @see org.obeonetwork.sample.associations.IClass011BIDao.updateClass011BI
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
     * @see org.obeonetwork.sample.associations.IClass011BIDao.deleteClass011BI
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
     * @see org.obeonetwork.sample.associations.IClass011BIDao.findAllClass011BIs
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
     * @see org.obeonetwork.sample.associations.IClass011BIDao.findClass011BIById
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
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.createClass011BIEND
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
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.updateClass011BIEND
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
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.deleteClass011BIEND
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
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.findAllClass011BIENDs
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
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.findClass011BIENDById
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
     * @see org.obeonetwork.sample.associations.IClass11Dao.createClass11
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
     * @see org.obeonetwork.sample.associations.IClass11Dao.updateClass11
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
     * @see org.obeonetwork.sample.associations.IClass11Dao.deleteClass11
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
     * @see org.obeonetwork.sample.associations.IClass11Dao.findAllClass11s
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
     * @see org.obeonetwork.sample.associations.IClass11Dao.findClass11ById
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
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.createClass11END
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
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.updateClass11END
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
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.deleteClass11END
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
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.findAllClass11ENDs
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
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.findClass11ENDById
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
     * @see org.obeonetwork.sample.associations.IClass11BIDao.createClass11BI
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
     * @see org.obeonetwork.sample.associations.IClass11BIDao.updateClass11BI
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
     * @see org.obeonetwork.sample.associations.IClass11BIDao.deleteClass11BI
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
     * @see org.obeonetwork.sample.associations.IClass11BIDao.findAllClass11BIs
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
     * @see org.obeonetwork.sample.associations.IClass11BIDao.findClass11BIById
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
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.createClass11BIEND
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
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.updateClass11BIEND
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
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.deleteClass11BIEND
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
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.findAllClass11BIENDs
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
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.findClass11BIENDById
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
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.createClass01Many
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
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.updateClass01Many
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
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.deleteClass01Many
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
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.findAllClass01Manys
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
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.findClass01ManyById
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
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.createClass01ManyEND
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
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.updateClass01ManyEND
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
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.deleteClass01ManyEND
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
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.findAllClass01ManyENDs
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
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.findClass01ManyENDById
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.createClass01ManyBI
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.updateClass01ManyBI
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.deleteClass01ManyBI
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.findAllClass01ManyBIs
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.findClass01ManyBIById
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.createClass01ManyBIEND
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.updateClass01ManyBIEND
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.deleteClass01ManyBIEND
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.findAllClass01ManyBIENDs
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
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.findClass01ManyBIENDById
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
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.createClassMany01
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
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.updateClassMany01
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
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.deleteClassMany01
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
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.findAllClassMany01s
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
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.findClassMany01ById
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
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.createClassMany01END
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
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.updateClassMany01END
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
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.deleteClassMany01END
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
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.findAllClassMany01ENDs
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
     * @see org.obeonetwork.sample.associations.IClassMany01ENDDao.findClassMany01ENDById
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.createClassMany01BI
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.updateClassMany01BI
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.deleteClassMany01BI
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.findAllClassMany01BIs
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIDao.findClassMany01BIById
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.createClassMany01BIEND
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.updateClassMany01BIEND
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.deleteClassMany01BIEND
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.findAllClassMany01BIENDs
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
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.findClassMany01BIENDById
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
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.createClassManyMany
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
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.updateClassManyMany
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
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.deleteClassManyMany
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
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.findAllClassManyManys
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
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.findClassManyManyById
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
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.createClassManyManyEnd
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
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.updateClassManyManyEnd
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
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.deleteClassManyManyEnd
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
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.findAllClassManyManyEnds
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
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.findClassManyManyEndById
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.createClassManyManyBI
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.updateClassManyManyBI
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.deleteClassManyManyBI
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.findAllClassManyManyBIs
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.findClassManyManyBIById
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.createClassManyManyBIEND
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.updateClassManyManyBIEND
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.deleteClassManyManyBIEND
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.findAllClassManyManyBIENDs
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
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.findClassManyManyBIENDById
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
	

	//Start of user code
	//End of user code
}

