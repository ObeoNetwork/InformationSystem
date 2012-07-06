package org.obeonetwork.sample.associations;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.obeonetwork.fwk.dao.exception.DaoException;
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

// End of user code for import

/**
 * Implementation of DAO interface IAssociationsDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.associations.IAssociationsDao
 */
public class HibernateAssociationsDao extends HibernateDaoSupport implements IAssociationsDao {

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
			getHibernateTemplate().save(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.updateClass_01_01
     */
	public void updateClass0101(Class0101 class0101) throws DaoException {
		LOG.debug("Update the entity Class0101 with id =" + class0101.getId());
		try {
			getHibernateTemplate().update(class0101);
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
			getHibernateTemplate().delete(class0101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101Dao.findAllClass_01_01s
     */
	public Collection<Class0101> findAllClass0101s() throws DaoException {
		LOG.debug("Find all instance of Class0101 entity");
		try {
			Collection<Class0101> resultList = getHibernateTemplate().loadAll(Class0101.class);

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
			return (Class0101) getHibernateTemplate().load(Class0101.class, id);
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
			getHibernateTemplate().save(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.updateClass_01_01_END
     */
	public void updateClass0101END(Class0101END class0101END) throws DaoException {
		LOG.debug("Update the entity Class0101END with id =" + class0101END.getId());
		try {
			getHibernateTemplate().update(class0101END);
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
			getHibernateTemplate().delete(class0101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101ENDDao.findAllClass_01_01_ENDs
     */
	public Collection<Class0101END> findAllClass0101ENDs() throws DaoException {
		LOG.debug("Find all instance of Class0101END entity");
		try {
			Collection<Class0101END> resultList = getHibernateTemplate().loadAll(Class0101END.class);

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
			return (Class0101END) getHibernateTemplate().load(Class0101END.class, id);
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
			getHibernateTemplate().save(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.updateClass_01_01_BI
     */
	public void updateClass0101BI(Class0101BI class0101BI) throws DaoException {
		LOG.debug("Update the entity Class0101BI with id =" + class0101BI.getId());
		try {
			getHibernateTemplate().update(class0101BI);
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
			getHibernateTemplate().delete(class0101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIDao.findAllClass_01_01_BIs
     */
	public Collection<Class0101BI> findAllClass0101BIs() throws DaoException {
		LOG.debug("Find all instance of Class0101BI entity");
		try {
			Collection<Class0101BI> resultList = getHibernateTemplate().loadAll(Class0101BI.class);

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
			return (Class0101BI) getHibernateTemplate().load(Class0101BI.class, id);
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
			getHibernateTemplate().save(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.updateClass_01_01_BI_END
     */
	public void updateClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException {
		LOG.debug("Update the entity Class0101BIEND with id =" + class0101BIEND.getId());
		try {
			getHibernateTemplate().update(class0101BIEND);
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
			getHibernateTemplate().delete(class0101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass0101BIENDDao.findAllClass_01_01_BI_ENDs
     */
	public Collection<Class0101BIEND> findAllClass0101BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class0101BIEND entity");
		try {
			Collection<Class0101BIEND> resultList = getHibernateTemplate().loadAll(Class0101BIEND.class);

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
			return (Class0101BIEND) getHibernateTemplate().load(Class0101BIEND.class, id);
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
			getHibernateTemplate().save(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101Dao.updateClass_1_01
     */
	public void updateClass101(Class101 class101) throws DaoException {
		LOG.debug("Update the entity Class101 with id =" + class101.getId());
		try {
			getHibernateTemplate().update(class101);
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
			getHibernateTemplate().delete(class101);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101Dao.findAllClass_1_01s
     */
	public Collection<Class101> findAllClass101s() throws DaoException {
		LOG.debug("Find all instance of Class101 entity");
		try {
			Collection<Class101> resultList = getHibernateTemplate().loadAll(Class101.class);

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
			return (Class101) getHibernateTemplate().load(Class101.class, id);
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
			getHibernateTemplate().save(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.updateClass_1_01_END
     */
	public void updateClass101END(Class101END class101END) throws DaoException {
		LOG.debug("Update the entity Class101END with id =" + class101END.getId());
		try {
			getHibernateTemplate().update(class101END);
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
			getHibernateTemplate().delete(class101END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101ENDDao.findAllClass_1_01_ENDs
     */
	public Collection<Class101END> findAllClass101ENDs() throws DaoException {
		LOG.debug("Find all instance of Class101END entity");
		try {
			Collection<Class101END> resultList = getHibernateTemplate().loadAll(Class101END.class);

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
			return (Class101END) getHibernateTemplate().load(Class101END.class, id);
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
			getHibernateTemplate().save(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIDao.updateClass_1_01_BI
     */
	public void updateClass101BI(Class101BI class101BI) throws DaoException {
		LOG.debug("Update the entity Class101BI with id =" + class101BI.getId());
		try {
			getHibernateTemplate().update(class101BI);
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
			getHibernateTemplate().delete(class101BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIDao.findAllClass_1_01_BIs
     */
	public Collection<Class101BI> findAllClass101BIs() throws DaoException {
		LOG.debug("Find all instance of Class101BI entity");
		try {
			Collection<Class101BI> resultList = getHibernateTemplate().loadAll(Class101BI.class);

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
			return (Class101BI) getHibernateTemplate().load(Class101BI.class, id);
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
			getHibernateTemplate().save(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.updateClass_1_01_BI_END
     */
	public void updateClass101BIEND(Class101BIEND class101BIEND) throws DaoException {
		LOG.debug("Update the entity Class101BIEND with id =" + class101BIEND.getId());
		try {
			getHibernateTemplate().update(class101BIEND);
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
			getHibernateTemplate().delete(class101BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass101BIENDDao.findAllClass_1_01_BI_ENDs
     */
	public Collection<Class101BIEND> findAllClass101BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class101BIEND entity");
		try {
			Collection<Class101BIEND> resultList = getHibernateTemplate().loadAll(Class101BIEND.class);

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
			return (Class101BIEND) getHibernateTemplate().load(Class101BIEND.class, id);
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
			getHibernateTemplate().save(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011Dao.updateClass_01_1
     */
	public void updateClass011(Class011 class011) throws DaoException {
		LOG.debug("Update the entity Class011 with id =" + class011.getId());
		try {
			getHibernateTemplate().update(class011);
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
			getHibernateTemplate().delete(class011);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011Dao.findAllClass_01_1s
     */
	public Collection<Class011> findAllClass011s() throws DaoException {
		LOG.debug("Find all instance of Class011 entity");
		try {
			Collection<Class011> resultList = getHibernateTemplate().loadAll(Class011.class);

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
			return (Class011) getHibernateTemplate().load(Class011.class, id);
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
			getHibernateTemplate().save(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.updateClass_01_1_END
     */
	public void updateClass011END(Class011END class011END) throws DaoException {
		LOG.debug("Update the entity Class011END with id =" + class011END.getId());
		try {
			getHibernateTemplate().update(class011END);
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
			getHibernateTemplate().delete(class011END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011ENDDao.findAllClass_01_1_ENDs
     */
	public Collection<Class011END> findAllClass011ENDs() throws DaoException {
		LOG.debug("Find all instance of Class011END entity");
		try {
			Collection<Class011END> resultList = getHibernateTemplate().loadAll(Class011END.class);

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
			return (Class011END) getHibernateTemplate().load(Class011END.class, id);
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
			getHibernateTemplate().save(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIDao.updateClass_01_1_BI
     */
	public void updateClass011BI(Class011BI class011BI) throws DaoException {
		LOG.debug("Update the entity Class011BI with id =" + class011BI.getId());
		try {
			getHibernateTemplate().update(class011BI);
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
			getHibernateTemplate().delete(class011BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIDao.findAllClass_01_1_BIs
     */
	public Collection<Class011BI> findAllClass011BIs() throws DaoException {
		LOG.debug("Find all instance of Class011BI entity");
		try {
			Collection<Class011BI> resultList = getHibernateTemplate().loadAll(Class011BI.class);

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
			return (Class011BI) getHibernateTemplate().load(Class011BI.class, id);
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
			getHibernateTemplate().save(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.updateClass_01_1_BI_END
     */
	public void updateClass011BIEND(Class011BIEND class011BIEND) throws DaoException {
		LOG.debug("Update the entity Class011BIEND with id =" + class011BIEND.getId());
		try {
			getHibernateTemplate().update(class011BIEND);
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
			getHibernateTemplate().delete(class011BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass011BIENDDao.findAllClass_01_1_BI_ENDs
     */
	public Collection<Class011BIEND> findAllClass011BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class011BIEND entity");
		try {
			Collection<Class011BIEND> resultList = getHibernateTemplate().loadAll(Class011BIEND.class);

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
			return (Class011BIEND) getHibernateTemplate().load(Class011BIEND.class, id);
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
			getHibernateTemplate().save(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11Dao.updateClass_1_1
     */
	public void updateClass11(Class11 class11) throws DaoException {
		LOG.debug("Update the entity Class11 with id =" + class11.getId());
		try {
			getHibernateTemplate().update(class11);
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
			getHibernateTemplate().delete(class11);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11Dao.findAllClass_1_1s
     */
	public Collection<Class11> findAllClass11s() throws DaoException {
		LOG.debug("Find all instance of Class11 entity");
		try {
			Collection<Class11> resultList = getHibernateTemplate().loadAll(Class11.class);

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
			return (Class11) getHibernateTemplate().load(Class11.class, id);
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
			getHibernateTemplate().save(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.updateClass_1_1_END
     */
	public void updateClass11END(Class11END class11END) throws DaoException {
		LOG.debug("Update the entity Class11END with id =" + class11END.getId());
		try {
			getHibernateTemplate().update(class11END);
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
			getHibernateTemplate().delete(class11END);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11ENDDao.findAllClass_1_1_ENDs
     */
	public Collection<Class11END> findAllClass11ENDs() throws DaoException {
		LOG.debug("Find all instance of Class11END entity");
		try {
			Collection<Class11END> resultList = getHibernateTemplate().loadAll(Class11END.class);

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
			return (Class11END) getHibernateTemplate().load(Class11END.class, id);
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
			getHibernateTemplate().save(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIDao.updateClass_1_1_BI
     */
	public void updateClass11BI(Class11BI class11BI) throws DaoException {
		LOG.debug("Update the entity Class11BI with id =" + class11BI.getId());
		try {
			getHibernateTemplate().update(class11BI);
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
			getHibernateTemplate().delete(class11BI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIDao.findAllClass_1_1_BIs
     */
	public Collection<Class11BI> findAllClass11BIs() throws DaoException {
		LOG.debug("Find all instance of Class11BI entity");
		try {
			Collection<Class11BI> resultList = getHibernateTemplate().loadAll(Class11BI.class);

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
			return (Class11BI) getHibernateTemplate().load(Class11BI.class, id);
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
			getHibernateTemplate().save(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.updateClass_1_1_BI_END
     */
	public void updateClass11BIEND(Class11BIEND class11BIEND) throws DaoException {
		LOG.debug("Update the entity Class11BIEND with id =" + class11BIEND.getId());
		try {
			getHibernateTemplate().update(class11BIEND);
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
			getHibernateTemplate().delete(class11BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass11BIENDDao.findAllClass_1_1_BI_ENDs
     */
	public Collection<Class11BIEND> findAllClass11BIENDs() throws DaoException {
		LOG.debug("Find all instance of Class11BIEND entity");
		try {
			Collection<Class11BIEND> resultList = getHibernateTemplate().loadAll(Class11BIEND.class);

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
			return (Class11BIEND) getHibernateTemplate().load(Class11BIEND.class, id);
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
			getHibernateTemplate().save(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.updateClass_01_Many
     */
	public void updateClass01Many(Class01Many class01Many) throws DaoException {
		LOG.debug("Update the entity Class01Many with id =" + class01Many.getId());
		try {
			getHibernateTemplate().update(class01Many);
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
			getHibernateTemplate().delete(class01Many);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyDao.findAllClass_01_Manys
     */
	public Collection<Class01Many> findAllClass01Manys() throws DaoException {
		LOG.debug("Find all instance of Class01Many entity");
		try {
			Collection<Class01Many> resultList = getHibernateTemplate().loadAll(Class01Many.class);

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
			return (Class01Many) getHibernateTemplate().load(Class01Many.class, id);
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
			getHibernateTemplate().save(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.updateClass_01_Many_END
     */
	public void updateClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException {
		LOG.debug("Update the entity Class01ManyEND with id =" + class01ManyEND.getId());
		try {
			getHibernateTemplate().update(class01ManyEND);
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
			getHibernateTemplate().delete(class01ManyEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyENDDao.findAllClass_01_Many_ENDs
     */
	public Collection<Class01ManyEND> findAllClass01ManyENDs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyEND entity");
		try {
			Collection<Class01ManyEND> resultList = getHibernateTemplate().loadAll(Class01ManyEND.class);

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
			return (Class01ManyEND) getHibernateTemplate().load(Class01ManyEND.class, id);
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
			getHibernateTemplate().save(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.updateClass_01_Many_BI
     */
	public void updateClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException {
		LOG.debug("Update the entity Class01ManyBI with id =" + class01ManyBI.getId());
		try {
			getHibernateTemplate().update(class01ManyBI);
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
			getHibernateTemplate().delete(class01ManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIDao.findAllClass_01_Many_BIs
     */
	public Collection<Class01ManyBI> findAllClass01ManyBIs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBI entity");
		try {
			Collection<Class01ManyBI> resultList = getHibernateTemplate().loadAll(Class01ManyBI.class);

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
			return (Class01ManyBI) getHibernateTemplate().load(Class01ManyBI.class, id);
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
			getHibernateTemplate().save(class01ManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.updateClass_01_Many_BI_END
     */
	public void updateClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException {
		LOG.debug("Update the entity Class01ManyBIEND with id =" + class01ManyBIEND.getId());
		try {
			getHibernateTemplate().update(class01ManyBIEND);
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
			getHibernateTemplate().delete(class01ManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClass01ManyBIENDDao.findAllClass_01_Many_BI_ENDs
     */
	public Collection<Class01ManyBIEND> findAllClass01ManyBIENDs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBIEND entity");
		try {
			Collection<Class01ManyBIEND> resultList = getHibernateTemplate().loadAll(Class01ManyBIEND.class);

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
			return (Class01ManyBIEND) getHibernateTemplate().load(Class01ManyBIEND.class, id);
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
			getHibernateTemplate().save(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.updateClass_Many_01
     */
	public void updateClassMany01(ClassMany01 classMany01) throws DaoException {
		LOG.debug("Update the entity ClassMany01 with id =" + classMany01.getId());
		try {
			getHibernateTemplate().update(classMany01);
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
			getHibernateTemplate().delete(classMany01);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01Dao.findAllClass_Many_01s
     */
	public Collection<ClassMany01> findAllClassMany01s() throws DaoException {
		LOG.debug("Find all instance of ClassMany01 entity");
		try {
			Collection<ClassMany01> resultList = getHibernateTemplate().loadAll(ClassMany01.class);

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
			return (ClassMany01) getHibernateTemplate().load(ClassMany01.class, id);
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
			getHibernateTemplate().save(classMany01END);
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
		LOG.debug("Update the entity ClassMany01END with id =" + classMany01END.getId());
		try {
			getHibernateTemplate().update(classMany01END);
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
			getHibernateTemplate().delete(classMany01END);
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
		LOG.debug("Find all instance of ClassMany01END entity");
		try {
			Collection<ClassMany01END> resultList = getHibernateTemplate().loadAll(ClassMany01END.class);

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
			return (ClassMany01END) getHibernateTemplate().load(ClassMany01END.class, id);
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
			getHibernateTemplate().save(classMany01BI);
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
		LOG.debug("Update the entity ClassMany01BI with id =" + classMany01BI.getId());
		try {
			getHibernateTemplate().update(classMany01BI);
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
			getHibernateTemplate().delete(classMany01BI);
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
		LOG.debug("Find all instance of ClassMany01BI entity");
		try {
			Collection<ClassMany01BI> resultList = getHibernateTemplate().loadAll(ClassMany01BI.class);

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
			return (ClassMany01BI) getHibernateTemplate().load(ClassMany01BI.class, id);
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
			getHibernateTemplate().save(classMany01BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.updateClass_Many_01_BI_END
     */
	public void updateClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException {
		LOG.debug("Update the entity ClassMany01BIEND with id =" + classMany01BIEND.getId());
		try {
			getHibernateTemplate().update(classMany01BIEND);
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
			getHibernateTemplate().delete(classMany01BIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassMany01BIENDDao.findAllClass_Many_01_BI_ENDs
     */
	public Collection<ClassMany01BIEND> findAllClassMany01BIENDs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01BIEND entity");
		try {
			Collection<ClassMany01BIEND> resultList = getHibernateTemplate().loadAll(ClassMany01BIEND.class);

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
			return (ClassMany01BIEND) getHibernateTemplate().load(ClassMany01BIEND.class, id);
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
			getHibernateTemplate().save(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.updateClass_Many_Many
     */
	public void updateClassManyMany(ClassManyMany classManyMany) throws DaoException {
		LOG.debug("Update the entity ClassManyMany with id =" + classManyMany.getId());
		try {
			getHibernateTemplate().update(classManyMany);
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
			getHibernateTemplate().delete(classManyMany);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyDao.findAllClass_Many_Manys
     */
	public Collection<ClassManyMany> findAllClassManyManys() throws DaoException {
		LOG.debug("Find all instance of ClassManyMany entity");
		try {
			Collection<ClassManyMany> resultList = getHibernateTemplate().loadAll(ClassManyMany.class);

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
			return (ClassManyMany) getHibernateTemplate().load(ClassManyMany.class, id);
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
			getHibernateTemplate().save(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_End
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.updateClass_Many_Many_End
     */
	public void updateClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException {
		LOG.debug("Update the entity ClassManyManyEnd with id =" + classManyManyEnd.getId());
		try {
			getHibernateTemplate().update(classManyManyEnd);
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
			getHibernateTemplate().delete(classManyManyEnd);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyEndDao.findAllClass_Many_Many_Ends
     */
	public Collection<ClassManyManyEnd> findAllClassManyManyEnds() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyEnd entity");
		try {
			Collection<ClassManyManyEnd> resultList = getHibernateTemplate().loadAll(ClassManyManyEnd.class);

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
			return (ClassManyManyEnd) getHibernateTemplate().load(ClassManyManyEnd.class, id);
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
			getHibernateTemplate().save(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.updateClass_Many_Many_BI
     */
	public void updateClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBI with id =" + classManyManyBI.getId());
		try {
			getHibernateTemplate().update(classManyManyBI);
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
			getHibernateTemplate().delete(classManyManyBI);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyBIDao.findAllClass_Many_Many_BIs
     */
	public Collection<ClassManyManyBI> findAllClassManyManyBIs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBI entity");
		try {
			Collection<ClassManyManyBI> resultList = getHibernateTemplate().loadAll(ClassManyManyBI.class);

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
			return (ClassManyManyBI) getHibernateTemplate().load(ClassManyManyBI.class, id);
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
			getHibernateTemplate().save(classManyManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI_END
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.updateClass_Many_Many_BI_END
     */
	public void updateClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBIEND with id =" + classManyManyBIEND.getId());
		try {
			getHibernateTemplate().update(classManyManyBIEND);
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
			getHibernateTemplate().delete(classManyManyBIEND);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.associations.IClassManyManyBIENDDao.findAllClass_Many_Many_BI_ENDs
     */
	public Collection<ClassManyManyBIEND> findAllClassManyManyBIENDs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBIEND entity");
		try {
			Collection<ClassManyManyBIEND> resultList = getHibernateTemplate().loadAll(ClassManyManyBIEND.class);

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
			return (ClassManyManyBIEND) getHibernateTemplate().load(ClassManyManyBIEND.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
