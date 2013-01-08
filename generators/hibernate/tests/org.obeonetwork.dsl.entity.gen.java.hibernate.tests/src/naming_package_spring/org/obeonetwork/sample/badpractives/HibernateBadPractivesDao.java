package org.obeonetwork.sample.badpractives;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.Interface_;
import org.obeonetwork.sample.badpractives.Class_;
import org.obeonetwork.sample.badpractives.BadName;
import org.obeonetwork.sample.badpractives.Anothername;
import org.obeonetwork.sample.badpractives.EntityWithSpecialChars;
import org.obeonetwork.sample.badpractives.Public_;
import org.obeonetwork.sample.badpractives.Private_;
import org.obeonetwork.sample.badpractives.Protected_;
import org.obeonetwork.sample.badpractives.Null_;
import org.obeonetwork.sample.badpractives.MyEntity;
import org.obeonetwork.sample.badpractives.TABLE;
import org.obeonetwork.sample.badpractives.IBadPractivesDao;

// End of user code for import

/**
 * Implementation of DAO interface IBadPractivesDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.badpractives.IBadPractivesDao
 */
public class HibernateBadPractivesDao extends HibernateDaoSupport implements IBadPractivesDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateBadPractivesDao.class);

	/**
	 * Create a new element
	 * @param interface_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.createInterface_
     */
    public void createInterface_(Interface_ interface_) throws DaoException {
		LOG.debug("Create a new Interface_ entity");
		try {
			getHibernateTemplate().save(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param interface
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.updateInterface
     */
	public void updateInterface_(Interface_ interface_) throws DaoException {
		LOG.debug("Update the entity Interface_ with id =" + interface_.getId());
		try {
			getHibernateTemplate().update(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param interface_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.deleteInterface_
   	 */
	public void deleteInterface_(Interface_ interface_) throws DaoException {
		LOG.debug("Delete the entity Interface_ with id =" + interface_.getId());
		try {
			getHibernateTemplate().delete(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.findAllInterfaces
     */
	public Collection<Interface_> findAllInterface_s() throws DaoException {
		LOG.debug("Find all instance of Interface_ entity");
		try {
			Collection<Interface_> resultList = getHibernateTemplate().loadAll(Interface_.class);

			LOG.debug("Found " + resultList.size() + " instances of Interface_ entity");
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
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.findInterface_ById
     */
	public Interface_ findInterface_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Interface_ entity by id : " + id);
		try {
			return (Interface_) getHibernateTemplate().load(Interface_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param class_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.createClass_
     */
    public void createClass_(Class_ class_) throws DaoException {
		LOG.debug("Create a new Class_ entity");
		try {
			getHibernateTemplate().save(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.updateClass
     */
	public void updateClass_(Class_ class_) throws DaoException {
		LOG.debug("Update the entity Class_ with id =" + class_.getId());
		try {
			getHibernateTemplate().update(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param class_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.deleteClass_
   	 */
	public void deleteClass_(Class_ class_) throws DaoException {
		LOG.debug("Delete the entity Class_ with id =" + class_.getId());
		try {
			getHibernateTemplate().delete(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.findAllClasss
     */
	public Collection<Class_> findAllClass_s() throws DaoException {
		LOG.debug("Find all instance of Class_ entity");
		try {
			Collection<Class_> resultList = getHibernateTemplate().loadAll(Class_.class);

			LOG.debug("Found " + resultList.size() + " instances of Class_ entity");
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
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.findClass_ById
     */
	public Class_ findClass_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Class_ entity by id : " + id);
		try {
			return (Class_) getHibernateTemplate().load(Class_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param badName Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.createBadName
     */
    public void createBadName(BadName badName) throws DaoException {
		LOG.debug("Create a new BadName entity");
		try {
			getHibernateTemplate().save(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param bad name
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.updateBad name
     */
	public void updateBadName(BadName badName) throws DaoException {
		LOG.debug("Update the entity BadName with id =" + badName.getId());
		try {
			getHibernateTemplate().update(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param badName Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.deleteBadName
   	 */
	public void deleteBadName(BadName badName) throws DaoException {
		LOG.debug("Delete the entity BadName with id =" + badName.getId());
		try {
			getHibernateTemplate().delete(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.findAllBad names
     */
	public Collection<BadName> findAllBadNames() throws DaoException {
		LOG.debug("Find all instance of BadName entity");
		try {
			Collection<BadName> resultList = getHibernateTemplate().loadAll(BadName.class);

			LOG.debug("Found " + resultList.size() + " instances of BadName entity");
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
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.findBadNameById
     */
	public BadName findBadNameById(String id) throws DaoException {
		LOG.debug("Find one instance of BadName entity by id : " + id);
		try {
			return (BadName) getHibernateTemplate().load(BadName.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param anothername Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.createAnothername
     */
    public void createAnothername(Anothername anothername) throws DaoException {
		LOG.debug("Create a new Anothername entity");
		try {
			getHibernateTemplate().save(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param another.name
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.updateAnother.name
     */
	public void updateAnothername(Anothername anothername) throws DaoException {
		LOG.debug("Update the entity Anothername with id =" + anothername.getId());
		try {
			getHibernateTemplate().update(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param anothername Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.deleteAnothername
   	 */
	public void deleteAnothername(Anothername anothername) throws DaoException {
		LOG.debug("Delete the entity Anothername with id =" + anothername.getId());
		try {
			getHibernateTemplate().delete(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.findAllAnother.names
     */
	public Collection<Anothername> findAllAnothernames() throws DaoException {
		LOG.debug("Find all instance of Anothername entity");
		try {
			Collection<Anothername> resultList = getHibernateTemplate().loadAll(Anothername.class);

			LOG.debug("Found " + resultList.size() + " instances of Anothername entity");
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
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.findAnothernameById
     */
	public Anothername findAnothernameById(String id) throws DaoException {
		LOG.debug("Find one instance of Anothername entity by id : " + id);
		try {
			return (Anothername) getHibernateTemplate().load(Anothername.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param entityWithSpecialChars Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.createentityWithSpecialChars
     */
    public void createentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Create a new EntityWithSpecialChars entity");
		try {
			getHibernateTemplate().save(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param entityWithSp�cialChars
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.updateentityWithSp�cialChars
     */
	public void updateentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Update the entity EntityWithSpecialChars with id =" + entityWithSpecialChars.getId());
		try {
			getHibernateTemplate().update(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param entityWithSpecialChars Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.deleteentityWithSpecialChars
   	 */
	public void deleteentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Delete the entity EntityWithSpecialChars with id =" + entityWithSpecialChars.getId());
		try {
			getHibernateTemplate().delete(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.findAllentityWithSp�cialCharss
     */
	public Collection<EntityWithSpecialChars> findAllentityWithSpecialCharss() throws DaoException {
		LOG.debug("Find all instance of EntityWithSpecialChars entity");
		try {
			Collection<EntityWithSpecialChars> resultList = getHibernateTemplate().loadAll(EntityWithSpecialChars.class);

			LOG.debug("Found " + resultList.size() + " instances of EntityWithSpecialChars entity");
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
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.findentityWithSpecialCharsById
     */
	public EntityWithSpecialChars findentityWithSpecialCharsById(String id) throws DaoException {
		LOG.debug("Find one instance of EntityWithSpecialChars entity by id : " + id);
		try {
			return (EntityWithSpecialChars) getHibernateTemplate().load(EntityWithSpecialChars.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param public_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.createpublic_
     */
    public void createpublic_(Public_ public_) throws DaoException {
		LOG.debug("Create a new Public_ entity");
		try {
			getHibernateTemplate().save(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param public
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.updatepublic
     */
	public void updatepublic_(Public_ public_) throws DaoException {
		LOG.debug("Update the entity Public_ with id =" + public_.getId());
		try {
			getHibernateTemplate().update(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param public_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.deletepublic_
   	 */
	public void deletepublic_(Public_ public_) throws DaoException {
		LOG.debug("Delete the entity Public_ with id =" + public_.getId());
		try {
			getHibernateTemplate().delete(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.findAllpublics
     */
	public Collection<Public_> findAllpublic_s() throws DaoException {
		LOG.debug("Find all instance of Public_ entity");
		try {
			Collection<Public_> resultList = getHibernateTemplate().loadAll(Public_.class);

			LOG.debug("Found " + resultList.size() + " instances of Public_ entity");
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
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.findpublic_ById
     */
	public Public_ findpublic_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Public_ entity by id : " + id);
		try {
			return (Public_) getHibernateTemplate().load(Public_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param private_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.createprivate_
     */
    public void createprivate_(Private_ private_) throws DaoException {
		LOG.debug("Create a new Private_ entity");
		try {
			getHibernateTemplate().save(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param private
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.updateprivate
     */
	public void updateprivate_(Private_ private_) throws DaoException {
		LOG.debug("Update the entity Private_ with id =" + private_.getId());
		try {
			getHibernateTemplate().update(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param private_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.deleteprivate_
   	 */
	public void deleteprivate_(Private_ private_) throws DaoException {
		LOG.debug("Delete the entity Private_ with id =" + private_.getId());
		try {
			getHibernateTemplate().delete(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.findAllprivates
     */
	public Collection<Private_> findAllprivate_s() throws DaoException {
		LOG.debug("Find all instance of Private_ entity");
		try {
			Collection<Private_> resultList = getHibernateTemplate().loadAll(Private_.class);

			LOG.debug("Found " + resultList.size() + " instances of Private_ entity");
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
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.findprivate_ById
     */
	public Private_ findprivate_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Private_ entity by id : " + id);
		try {
			return (Private_) getHibernateTemplate().load(Private_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param protected_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.createprotected_
     */
    public void createprotected_(Protected_ protected_) throws DaoException {
		LOG.debug("Create a new Protected_ entity");
		try {
			getHibernateTemplate().save(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param protected
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.updateprotected
     */
	public void updateprotected_(Protected_ protected_) throws DaoException {
		LOG.debug("Update the entity Protected_ with id =" + protected_.getId());
		try {
			getHibernateTemplate().update(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param protected_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.deleteprotected_
   	 */
	public void deleteprotected_(Protected_ protected_) throws DaoException {
		LOG.debug("Delete the entity Protected_ with id =" + protected_.getId());
		try {
			getHibernateTemplate().delete(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.findAllprotecteds
     */
	public Collection<Protected_> findAllprotected_s() throws DaoException {
		LOG.debug("Find all instance of Protected_ entity");
		try {
			Collection<Protected_> resultList = getHibernateTemplate().loadAll(Protected_.class);

			LOG.debug("Found " + resultList.size() + " instances of Protected_ entity");
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
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.findprotected_ById
     */
	public Protected_ findprotected_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Protected_ entity by id : " + id);
		try {
			return (Protected_) getHibernateTemplate().load(Protected_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param null_ Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.createnull_
     */
    public void createnull_(Null_ null_) throws DaoException {
		LOG.debug("Create a new Null_ entity");
		try {
			getHibernateTemplate().save(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param null
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.updatenull
     */
	public void updatenull_(Null_ null_) throws DaoException {
		LOG.debug("Update the entity Null_ with id =" + null_.getId());
		try {
			getHibernateTemplate().update(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param null_ Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.deletenull_
   	 */
	public void deletenull_(Null_ null_) throws DaoException {
		LOG.debug("Delete the entity Null_ with id =" + null_.getId());
		try {
			getHibernateTemplate().delete(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.findAllnulls
     */
	public Collection<Null_> findAllnull_s() throws DaoException {
		LOG.debug("Find all instance of Null_ entity");
		try {
			Collection<Null_> resultList = getHibernateTemplate().loadAll(Null_.class);

			LOG.debug("Found " + resultList.size() + " instances of Null_ entity");
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
     * @see org.obeonetwork.sample.badpractives.INull_Dao.findnull_ById
     */
	public Null_ findnull_ById(String id) throws DaoException {
		LOG.debug("Find one instance of Null_ entity by id : " + id);
		try {
			return (Null_) getHibernateTemplate().load(Null_.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param myEntity Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.createmyEntity
     */
    public void createmyEntity(MyEntity myEntity) throws DaoException {
		LOG.debug("Create a new MyEntity entity");
		try {
			getHibernateTemplate().save(myEntity);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param myEntity
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.updatemyEntity
     */
	public void updatemyEntity(MyEntity myEntity) throws DaoException {
		LOG.debug("Update the entity MyEntity with id =" + myEntity.getId());
		try {
			getHibernateTemplate().update(myEntity);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param myEntity Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.deletemyEntity
   	 */
	public void deletemyEntity(MyEntity myEntity) throws DaoException {
		LOG.debug("Delete the entity MyEntity with id =" + myEntity.getId());
		try {
			getHibernateTemplate().delete(myEntity);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.findAllmyEntitys
     */
	public Collection<MyEntity> findAllmyEntitys() throws DaoException {
		LOG.debug("Find all instance of MyEntity entity");
		try {
			Collection<MyEntity> resultList = getHibernateTemplate().loadAll(MyEntity.class);

			LOG.debug("Found " + resultList.size() + " instances of MyEntity entity");
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
     * @see org.obeonetwork.sample.badpractives.IMyEntityDao.findmyEntityById
     */
	public MyEntity findmyEntityById(String id) throws DaoException {
		LOG.debug("Find one instance of MyEntity entity by id : " + id);
		try {
			return (MyEntity) getHibernateTemplate().load(MyEntity.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param tABLE Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.createTABLE
     */
    public void createTABLE(TABLE tABLE) throws DaoException {
		LOG.debug("Create a new TABLE entity");
		try {
			getHibernateTemplate().save(tABLE);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param tABLE
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.updateTABLE
     */
	public void updateTABLE(TABLE tABLE) throws DaoException {
		LOG.debug("Update the entity TABLE with id =" + tABLE.getId());
		try {
			getHibernateTemplate().update(tABLE);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param tABLE Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.deleteTABLE
   	 */
	public void deleteTABLE(TABLE tABLE) throws DaoException {
		LOG.debug("Delete the entity TABLE with id =" + tABLE.getId());
		try {
			getHibernateTemplate().delete(tABLE);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.findAllTABLEs
     */
	public Collection<TABLE> findAllTABLEs() throws DaoException {
		LOG.debug("Find all instance of TABLE entity");
		try {
			Collection<TABLE> resultList = getHibernateTemplate().loadAll(TABLE.class);

			LOG.debug("Found " + resultList.size() + " instances of TABLE entity");
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
     * @see org.obeonetwork.sample.badpractives.ITABLEDao.findTABLEById
     */
	public TABLE findTABLEById(String id) throws DaoException {
		LOG.debug("Find one instance of TABLE entity by id : " + id);
		try {
			return (TABLE) getHibernateTemplate().load(TABLE.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
