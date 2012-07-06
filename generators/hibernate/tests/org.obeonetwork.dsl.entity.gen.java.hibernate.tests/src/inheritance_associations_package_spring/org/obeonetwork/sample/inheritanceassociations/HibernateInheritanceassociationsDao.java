package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.obeonetwork.fwk.dao.exception.DaoException;
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

// End of user code for import

/**
 * Implementation of DAO interface IInheritanceassociationsDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritanceassociations.IInheritanceassociationsDao
 */
public class HibernateInheritanceassociationsDao extends HibernateDaoSupport implements IInheritanceassociationsDao {

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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.updateClass_01_01
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.deleteClass0101
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.findAllClass_01_01s
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.findClass0101ById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.createClass0101END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.updateClass_01_01_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.deleteClass0101END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.findAllClass_01_01_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.findClass0101ENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.createClass0101BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.updateClass_01_01_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.deleteClass0101BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.findAllClass_01_01_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.findClass0101BIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.createClass0101BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.updateClass_01_01_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.deleteClass0101BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.findAllClass_01_01_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.findClass0101BIENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.createClass101
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.updateClass_1_01
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.deleteClass101
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.findAllClass_1_01s
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101Dao.findClass101ById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.createClass101END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.updateClass_1_01_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.deleteClass101END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.findAllClass_1_01_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.findClass101ENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.createClass101BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.updateClass_1_01_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.deleteClass101BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.findAllClass_1_01_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.findClass101BIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.createClass101BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.updateClass_1_01_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.deleteClass101BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.findAllClass_1_01_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.findClass101BIENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.createClass011
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.updateClass_01_1
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.deleteClass011
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.findAllClass_01_1s
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011Dao.findClass011ById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.createClass011END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.updateClass_01_1_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.deleteClass011END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.findAllClass_01_1_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.findClass011ENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.createClass011BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.updateClass_01_1_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.deleteClass011BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.findAllClass_01_1_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.findClass011BIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.createClass011BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.updateClass_01_1_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.deleteClass011BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.findAllClass_01_1_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.findClass011BIENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.createClass11
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.updateClass_1_1
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.deleteClass11
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.findAllClass_1_1s
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11Dao.findClass11ById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.createClass11END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.updateClass_1_1_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.deleteClass11END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.findAllClass_1_1_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.findClass11ENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.createClass11BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.updateClass_1_1_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.deleteClass11BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.findAllClass_1_1_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.findClass11BIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.createClass11BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.updateClass_1_1_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.deleteClass11BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.findAllClass_1_1_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.findClass11BIENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.createClass01Many
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.updateClass_01_Many
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.deleteClass01Many
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.findAllClass_01_Manys
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.findClass01ManyById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.createClass01ManyEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.updateClass_01_Many_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.deleteClass01ManyEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.findAllClass_01_Many_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.findClass01ManyENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.createClass01ManyBI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.updateClass_01_Many_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.deleteClass01ManyBI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.findAllClass_01_Many_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.findClass01ManyBIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.createClass01ManyBIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.updateClass_01_Many_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.deleteClass01ManyBIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.findAllClass_01_Many_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.findClass01ManyBIENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.createClassMany01
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.updateClass_Many_01
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.deleteClassMany01
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.findAllClass_Many_01s
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.findClassMany01ById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.createClassMany01END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.updateClass_Many_01_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.deleteClassMany01END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.findAllClass_Many_01_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.findClassMany01ENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.createClassMany01BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.updateClass_Many_01_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.deleteClassMany01BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.findAllClass_Many_01_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.findClassMany01BIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.createClassMany01BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.updateClass_Many_01_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.deleteClassMany01BIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.findAllClass_Many_01_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.findClassMany01BIENDById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.createClassManyMany
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.updateClass_Many_Many
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.deleteClassManyMany
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.findAllClass_Many_Manys
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.findClassManyManyById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.createClassManyManyEnd
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.updateClass_Many_Many_End
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.deleteClassManyManyEnd
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.findAllClass_Many_Many_Ends
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.findClassManyManyEndById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.createClassManyManyBI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.updateClass_Many_Many_BI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.deleteClassManyManyBI
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.findAllClass_Many_Many_BIs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.findClassManyManyBIById
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.createClassManyManyBIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.updateClass_Many_Many_BI_END
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.deleteClassManyManyBIEND
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.findAllClass_Many_Many_BI_ENDs
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
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.findClassManyManyBIENDById
     */
	public ClassManyManyBIEND findClassManyManyBIENDById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassManyManyBIEND entity by id : " + id);
		try {
			return (ClassManyManyBIEND) getHibernateTemplate().load(ClassManyManyBIEND.class, id);
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
			getHibernateTemplate().save(class0101ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.updateClass_01_01_END_Sub
     */
	public void updateClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException {
		LOG.debug("Update the entity Class0101ENDSub with id =" + class0101ENDSub.getId());
		try {
			getHibernateTemplate().update(class0101ENDSub);
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
			getHibernateTemplate().delete(class0101ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.findAllClass_01_01_END_Subs
     */
	public Collection<Class0101ENDSub> findAllClass0101ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class0101ENDSub entity");
		try {
			Collection<Class0101ENDSub> resultList = getHibernateTemplate().loadAll(Class0101ENDSub.class);

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
			return (Class0101ENDSub) getHibernateTemplate().load(Class0101ENDSub.class, id);
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
			getHibernateTemplate().save(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.updateClass_01_01_BI_END_Sub
     */
	public void updateClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class0101BIENDSub with id =" + class0101BIENDSub.getId());
		try {
			getHibernateTemplate().update(class0101BIENDSub);
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
			getHibernateTemplate().delete(class0101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.findAllClass_01_01_BI_END_Subs
     */
	public Collection<Class0101BIENDSub> findAllClass0101BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class0101BIENDSub entity");
		try {
			Collection<Class0101BIENDSub> resultList = getHibernateTemplate().loadAll(Class0101BIENDSub.class);

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
			return (Class0101BIENDSub) getHibernateTemplate().load(Class0101BIENDSub.class, id);
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
			getHibernateTemplate().save(class101EndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_End_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.updateClass_1_01_End_Sub
     */
	public void updateClass101EndSub(Class101EndSub class101EndSub) throws DaoException {
		LOG.debug("Update the entity Class101EndSub with id =" + class101EndSub.getId());
		try {
			getHibernateTemplate().update(class101EndSub);
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
			getHibernateTemplate().delete(class101EndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.findAllClass_1_01_End_Subs
     */
	public Collection<Class101EndSub> findAllClass101EndSubs() throws DaoException {
		LOG.debug("Find all instance of Class101EndSub entity");
		try {
			Collection<Class101EndSub> resultList = getHibernateTemplate().loadAll(Class101EndSub.class);

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
			return (Class101EndSub) getHibernateTemplate().load(Class101EndSub.class, id);
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
			getHibernateTemplate().save(class101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.updateClass_1_01_BI_END_Sub
     */
	public void updateClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class101BIENDSub with id =" + class101BIENDSub.getId());
		try {
			getHibernateTemplate().update(class101BIENDSub);
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
			getHibernateTemplate().delete(class101BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.findAllClass_1_01_BI_END_Subs
     */
	public Collection<Class101BIENDSub> findAllClass101BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class101BIENDSub entity");
		try {
			Collection<Class101BIENDSub> resultList = getHibernateTemplate().loadAll(Class101BIENDSub.class);

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
			return (Class101BIENDSub) getHibernateTemplate().load(Class101BIENDSub.class, id);
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
			getHibernateTemplate().save(class011ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.updateClass_01_1_END_Sub
     */
	public void updateClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException {
		LOG.debug("Update the entity Class011ENDSub with id =" + class011ENDSub.getId());
		try {
			getHibernateTemplate().update(class011ENDSub);
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
			getHibernateTemplate().delete(class011ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.findAllClass_01_1_END_Subs
     */
	public Collection<Class011ENDSub> findAllClass011ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class011ENDSub entity");
		try {
			Collection<Class011ENDSub> resultList = getHibernateTemplate().loadAll(Class011ENDSub.class);

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
			return (Class011ENDSub) getHibernateTemplate().load(Class011ENDSub.class, id);
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
			getHibernateTemplate().save(class011BiENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_Bi_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.updateClass_01_1_Bi_END_Sub
     */
	public void updateClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException {
		LOG.debug("Update the entity Class011BiENDSub with id =" + class011BiENDSub.getId());
		try {
			getHibernateTemplate().update(class011BiENDSub);
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
			getHibernateTemplate().delete(class011BiENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.findAllClass_01_1_Bi_END_Subs
     */
	public Collection<Class011BiENDSub> findAllClass011BiENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class011BiENDSub entity");
		try {
			Collection<Class011BiENDSub> resultList = getHibernateTemplate().loadAll(Class011BiENDSub.class);

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
			return (Class011BiENDSub) getHibernateTemplate().load(Class011BiENDSub.class, id);
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
			getHibernateTemplate().save(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.updateClass_1_1_END_Sub
     */
	public void updateClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException {
		LOG.debug("Update the entity Class11ENDSub with id =" + class11ENDSub.getId());
		try {
			getHibernateTemplate().update(class11ENDSub);
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
			getHibernateTemplate().delete(class11ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.findAllClass_1_1_END_Subs
     */
	public Collection<Class11ENDSub> findAllClass11ENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class11ENDSub entity");
		try {
			Collection<Class11ENDSub> resultList = getHibernateTemplate().loadAll(Class11ENDSub.class);

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
			return (Class11ENDSub) getHibernateTemplate().load(Class11ENDSub.class, id);
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
			getHibernateTemplate().save(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.updateClass_1_1_BI_END_Sub
     */
	public void updateClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException {
		LOG.debug("Update the entity Class11BIENDSub with id =" + class11BIENDSub.getId());
		try {
			getHibernateTemplate().update(class11BIENDSub);
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
			getHibernateTemplate().delete(class11BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.findAllClass_1_1_BI_END_Subs
     */
	public Collection<Class11BIENDSub> findAllClass11BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class11BIENDSub entity");
		try {
			Collection<Class11BIENDSub> resultList = getHibernateTemplate().loadAll(Class11BIENDSub.class);

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
			return (Class11BIENDSub) getHibernateTemplate().load(Class11BIENDSub.class, id);
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
			getHibernateTemplate().save(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.updateClass_01_Many_END_Sub
     */
	public void updateClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException {
		LOG.debug("Update the entity Class01ManyENDSub with id =" + class01ManyENDSub.getId());
		try {
			getHibernateTemplate().update(class01ManyENDSub);
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
			getHibernateTemplate().delete(class01ManyENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.findAllClass_01_Many_END_Subs
     */
	public Collection<Class01ManyENDSub> findAllClass01ManyENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyENDSub entity");
		try {
			Collection<Class01ManyENDSub> resultList = getHibernateTemplate().loadAll(Class01ManyENDSub.class);

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
			return (Class01ManyENDSub) getHibernateTemplate().load(Class01ManyENDSub.class, id);
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
			getHibernateTemplate().save(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.updateClass_01_Many_BI_END_Sub
     */
	public void updateClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException {
		LOG.debug("Update the entity Class01ManyBIENDSub with id =" + class01ManyBIENDSub.getId());
		try {
			getHibernateTemplate().update(class01ManyBIENDSub);
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
			getHibernateTemplate().delete(class01ManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.findAllClass_01_Many_BI_END_Subs
     */
	public Collection<Class01ManyBIENDSub> findAllClass01ManyBIENDSubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBIENDSub entity");
		try {
			Collection<Class01ManyBIENDSub> resultList = getHibernateTemplate().loadAll(Class01ManyBIENDSub.class);

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
			return (Class01ManyBIENDSub) getHibernateTemplate().load(Class01ManyBIENDSub.class, id);
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
			getHibernateTemplate().save(classMany01ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.updateClass_Many_01_END_Sub
     */
	public void updateClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException {
		LOG.debug("Update the entity ClassMany01ENDSub with id =" + classMany01ENDSub.getId());
		try {
			getHibernateTemplate().update(classMany01ENDSub);
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
			getHibernateTemplate().delete(classMany01ENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.findAllClass_Many_01_END_Subs
     */
	public Collection<ClassMany01ENDSub> findAllClassMany01ENDSubs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01ENDSub entity");
		try {
			Collection<ClassMany01ENDSub> resultList = getHibernateTemplate().loadAll(ClassMany01ENDSub.class);

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
			return (ClassMany01ENDSub) getHibernateTemplate().load(ClassMany01ENDSub.class, id);
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
			getHibernateTemplate().save(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_01_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.updateClass_Many_01_BI_END_Sub
     */
	public void updateClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException {
		LOG.debug("Update the entity ClassMany01BIENDSub with id =" + classMany01BIENDSub.getId());
		try {
			getHibernateTemplate().update(classMany01BIENDSub);
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
			getHibernateTemplate().delete(classMany01BIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.findAllClass_Many_01_BI_END_Subs
     */
	public Collection<ClassMany01BIENDSub> findAllClassMany01BIENDSubs() throws DaoException {
		LOG.debug("Find all instance of ClassMany01BIENDSub entity");
		try {
			Collection<ClassMany01BIENDSub> resultList = getHibernateTemplate().loadAll(ClassMany01BIENDSub.class);

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
			return (ClassMany01BIENDSub) getHibernateTemplate().load(ClassMany01BIENDSub.class, id);
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
			getHibernateTemplate().save(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_End_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.updateClass_Many_Many_End_Sub
     */
	public void updateClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException {
		LOG.debug("Update the entity ClassManyManyEndSub with id =" + classManyManyEndSub.getId());
		try {
			getHibernateTemplate().update(classManyManyEndSub);
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
			getHibernateTemplate().delete(classManyManyEndSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.findAllClass_Many_Many_End_Subs
     */
	public Collection<ClassManyManyEndSub> findAllClassManyManyEndSubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyEndSub entity");
		try {
			Collection<ClassManyManyEndSub> resultList = getHibernateTemplate().loadAll(ClassManyManyEndSub.class);

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
			return (ClassManyManyEndSub) getHibernateTemplate().load(ClassManyManyEndSub.class, id);
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
			getHibernateTemplate().save(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI_END_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.updateClass_Many_Many_BI_END_Sub
     */
	public void updateClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBIENDSub with id =" + classManyManyBIENDSub.getId());
		try {
			getHibernateTemplate().update(classManyManyBIENDSub);
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
			getHibernateTemplate().delete(classManyManyBIENDSub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.findAllClass_Many_Many_BI_END_Subs
     */
	public Collection<ClassManyManyBIENDSub> findAllClassManyManyBIENDSubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBIENDSub entity");
		try {
			Collection<ClassManyManyBIENDSub> resultList = getHibernateTemplate().loadAll(ClassManyManyBIENDSub.class);

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
			return (ClassManyManyBIENDSub) getHibernateTemplate().load(ClassManyManyBIENDSub.class, id);
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
			getHibernateTemplate().save(class0101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.updateClass_01_01_Sub
     */
	public void updateClass0101Sub(Class0101Sub class0101Sub) throws DaoException {
		LOG.debug("Update the entity Class0101Sub with id =" + class0101Sub.getId());
		try {
			getHibernateTemplate().update(class0101Sub);
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
			getHibernateTemplate().delete(class0101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.findAllClass_01_01_Subs
     */
	public Collection<Class0101Sub> findAllClass0101Subs() throws DaoException {
		LOG.debug("Find all instance of Class0101Sub entity");
		try {
			Collection<Class0101Sub> resultList = getHibernateTemplate().loadAll(Class0101Sub.class);

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
			return (Class0101Sub) getHibernateTemplate().load(Class0101Sub.class, id);
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
			getHibernateTemplate().save(class0101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_01_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.updateClass_01_01_BI_Sub
     */
	public void updateClass0101BISub(Class0101BISub class0101BISub) throws DaoException {
		LOG.debug("Update the entity Class0101BISub with id =" + class0101BISub.getId());
		try {
			getHibernateTemplate().update(class0101BISub);
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
			getHibernateTemplate().delete(class0101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.findAllClass_01_01_BI_Subs
     */
	public Collection<Class0101BISub> findAllClass0101BISubs() throws DaoException {
		LOG.debug("Find all instance of Class0101BISub entity");
		try {
			Collection<Class0101BISub> resultList = getHibernateTemplate().loadAll(Class0101BISub.class);

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
			return (Class0101BISub) getHibernateTemplate().load(Class0101BISub.class, id);
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
			getHibernateTemplate().save(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.updateClass_1_01_Sub
     */
	public void updateClass101Sub(Class101Sub class101Sub) throws DaoException {
		LOG.debug("Update the entity Class101Sub with id =" + class101Sub.getId());
		try {
			getHibernateTemplate().update(class101Sub);
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
			getHibernateTemplate().delete(class101Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.findAllClass_1_01_Subs
     */
	public Collection<Class101Sub> findAllClass101Subs() throws DaoException {
		LOG.debug("Find all instance of Class101Sub entity");
		try {
			Collection<Class101Sub> resultList = getHibernateTemplate().loadAll(Class101Sub.class);

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
			return (Class101Sub) getHibernateTemplate().load(Class101Sub.class, id);
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
			getHibernateTemplate().save(class101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_01_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.updateClass_1_01_BI_Sub
     */
	public void updateClass101BISub(Class101BISub class101BISub) throws DaoException {
		LOG.debug("Update the entity Class101BISub with id =" + class101BISub.getId());
		try {
			getHibernateTemplate().update(class101BISub);
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
			getHibernateTemplate().delete(class101BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.findAllClass_1_01_BI_Subs
     */
	public Collection<Class101BISub> findAllClass101BISubs() throws DaoException {
		LOG.debug("Find all instance of Class101BISub entity");
		try {
			Collection<Class101BISub> resultList = getHibernateTemplate().loadAll(Class101BISub.class);

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
			return (Class101BISub) getHibernateTemplate().load(Class101BISub.class, id);
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
			getHibernateTemplate().save(class011Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.updateClass_01_1_Sub
     */
	public void updateClass011Sub(Class011Sub class011Sub) throws DaoException {
		LOG.debug("Update the entity Class011Sub with id =" + class011Sub.getId());
		try {
			getHibernateTemplate().update(class011Sub);
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
			getHibernateTemplate().delete(class011Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.findAllClass_01_1_Subs
     */
	public Collection<Class011Sub> findAllClass011Subs() throws DaoException {
		LOG.debug("Find all instance of Class011Sub entity");
		try {
			Collection<Class011Sub> resultList = getHibernateTemplate().loadAll(Class011Sub.class);

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
			return (Class011Sub) getHibernateTemplate().load(Class011Sub.class, id);
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
			getHibernateTemplate().save(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_1_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.updateClass_01_1_BI_Sub
     */
	public void updateClass011BISub(Class011BISub class011BISub) throws DaoException {
		LOG.debug("Update the entity Class011BISub with id =" + class011BISub.getId());
		try {
			getHibernateTemplate().update(class011BISub);
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
			getHibernateTemplate().delete(class011BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.findAllClass_01_1_BI_Subs
     */
	public Collection<Class011BISub> findAllClass011BISubs() throws DaoException {
		LOG.debug("Find all instance of Class011BISub entity");
		try {
			Collection<Class011BISub> resultList = getHibernateTemplate().loadAll(Class011BISub.class);

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
			return (Class011BISub) getHibernateTemplate().load(Class011BISub.class, id);
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
			getHibernateTemplate().save(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.updateClass_1_1_Sub
     */
	public void updateClass11Sub(Class11Sub class11Sub) throws DaoException {
		LOG.debug("Update the entity Class11Sub with id =" + class11Sub.getId());
		try {
			getHibernateTemplate().update(class11Sub);
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
			getHibernateTemplate().delete(class11Sub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.findAllClass_1_1_Subs
     */
	public Collection<Class11Sub> findAllClass11Subs() throws DaoException {
		LOG.debug("Find all instance of Class11Sub entity");
		try {
			Collection<Class11Sub> resultList = getHibernateTemplate().loadAll(Class11Sub.class);

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
			return (Class11Sub) getHibernateTemplate().load(Class11Sub.class, id);
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
			getHibernateTemplate().save(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_1_1_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.updateClass_1_1_BI_Sub
     */
	public void updateClass11BISub(Class11BISub class11BISub) throws DaoException {
		LOG.debug("Update the entity Class11BISub with id =" + class11BISub.getId());
		try {
			getHibernateTemplate().update(class11BISub);
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
			getHibernateTemplate().delete(class11BISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.findAllClass_1_1_BI_Subs
     */
	public Collection<Class11BISub> findAllClass11BISubs() throws DaoException {
		LOG.debug("Find all instance of Class11BISub entity");
		try {
			Collection<Class11BISub> resultList = getHibernateTemplate().loadAll(Class11BISub.class);

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
			return (Class11BISub) getHibernateTemplate().load(Class11BISub.class, id);
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
			getHibernateTemplate().save(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.updateClass_01_Many_Sub
     */
	public void updateClass01ManySub(Class01ManySub class01ManySub) throws DaoException {
		LOG.debug("Update the entity Class01ManySub with id =" + class01ManySub.getId());
		try {
			getHibernateTemplate().update(class01ManySub);
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
			getHibernateTemplate().delete(class01ManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.findAllClass_01_Many_Subs
     */
	public Collection<Class01ManySub> findAllClass01ManySubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManySub entity");
		try {
			Collection<Class01ManySub> resultList = getHibernateTemplate().loadAll(Class01ManySub.class);

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
			return (Class01ManySub) getHibernateTemplate().load(Class01ManySub.class, id);
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
			getHibernateTemplate().save(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_01_Many_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.updateClass_01_Many_BI_Sub
     */
	public void updateClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException {
		LOG.debug("Update the entity Class01ManyBISub with id =" + class01ManyBISub.getId());
		try {
			getHibernateTemplate().update(class01ManyBISub);
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
			getHibernateTemplate().delete(class01ManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.findAllClass_01_Many_BI_Subs
     */
	public Collection<Class01ManyBISub> findAllClass01ManyBISubs() throws DaoException {
		LOG.debug("Find all instance of Class01ManyBISub entity");
		try {
			Collection<Class01ManyBISub> resultList = getHibernateTemplate().loadAll(Class01ManyBISub.class);

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
			return (Class01ManyBISub) getHibernateTemplate().load(Class01ManyBISub.class, id);
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
			getHibernateTemplate().save(classMany01Sub);
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
		LOG.debug("Update the entity ClassMany01Sub with id =" + classMany01Sub.getId());
		try {
			getHibernateTemplate().update(classMany01Sub);
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
			getHibernateTemplate().delete(classMany01Sub);
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
		LOG.debug("Find all instance of ClassMany01Sub entity");
		try {
			Collection<ClassMany01Sub> resultList = getHibernateTemplate().loadAll(ClassMany01Sub.class);

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
			return (ClassMany01Sub) getHibernateTemplate().load(ClassMany01Sub.class, id);
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
			getHibernateTemplate().save(classMany01BISub);
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
		LOG.debug("Update the entity ClassMany01BISub with id =" + classMany01BISub.getId());
		try {
			getHibernateTemplate().update(classMany01BISub);
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
			getHibernateTemplate().delete(classMany01BISub);
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
		LOG.debug("Find all instance of ClassMany01BISub entity");
		try {
			Collection<ClassMany01BISub> resultList = getHibernateTemplate().loadAll(ClassMany01BISub.class);

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
			return (ClassMany01BISub) getHibernateTemplate().load(ClassMany01BISub.class, id);
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
			getHibernateTemplate().save(classManyManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.updateClass_Many_Many_Sub
     */
	public void updateClassManyManySub(ClassManyManySub classManyManySub) throws DaoException {
		LOG.debug("Update the entity ClassManyManySub with id =" + classManyManySub.getId());
		try {
			getHibernateTemplate().update(classManyManySub);
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
			getHibernateTemplate().delete(classManyManySub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.findAllClass_Many_Many_Subs
     */
	public Collection<ClassManyManySub> findAllClassManyManySubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManySub entity");
		try {
			Collection<ClassManyManySub> resultList = getHibernateTemplate().loadAll(ClassManyManySub.class);

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
			return (ClassManyManySub) getHibernateTemplate().load(ClassManyManySub.class, id);
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
			getHibernateTemplate().save(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_Many_Many_BI_Sub
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.updateClass_Many_Many_BI_Sub
     */
	public void updateClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException {
		LOG.debug("Update the entity ClassManyManyBISub with id =" + classManyManyBISub.getId());
		try {
			getHibernateTemplate().update(classManyManyBISub);
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
			getHibernateTemplate().delete(classManyManyBISub);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.findAllClass_Many_Many_BI_Subs
     */
	public Collection<ClassManyManyBISub> findAllClassManyManyBISubs() throws DaoException {
		LOG.debug("Find all instance of ClassManyManyBISub entity");
		try {
			Collection<ClassManyManyBISub> resultList = getHibernateTemplate().loadAll(ClassManyManyBISub.class);

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
			return (ClassManyManyBISub) getHibernateTemplate().load(ClassManyManyBISub.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
