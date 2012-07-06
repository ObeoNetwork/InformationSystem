package org.obeonetwork.sample.badpractives;

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
public class HibernateBadPractivesDao implements IBadPractivesDao {

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
			Session session = HibernateUtil.currentSession();
			session.save(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param interface_
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.updateInterface_
     */
	public void updateInterface_(Interface_ interface_) throws DaoException {
		LOG.debug("Update the entity Interface_ with id =" + interface_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(interface_);
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
			Session session = HibernateUtil.currentSession();
			session.delete(interface_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IInterface_Dao.findAllInterface_s
     */
	public Collection<Interface_> findAllInterface_s() throws DaoException {
		LOG.debug("Find all instance of Interface_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Interface_.class);
			Collection<Interface_> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Interface_.class)
				.add(Restrictions.eq("id", id));
			Interface_ result = (Interface_)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param class_
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.updateClass_
     */
	public void updateClass_(Class_ class_) throws DaoException {
		LOG.debug("Update the entity Class_ with id =" + class_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(class_);
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
			Session session = HibernateUtil.currentSession();
			session.delete(class_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IClass_Dao.findAllClass_s
     */
	public Collection<Class_> findAllClass_s() throws DaoException {
		LOG.debug("Find all instance of Class_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class_.class);
			Collection<Class_> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Class_.class)
				.add(Restrictions.eq("id", id));
			Class_ result = (Class_)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param badName
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.updateBadName
     */
	public void updateBadName(BadName badName) throws DaoException {
		LOG.debug("Update the entity BadName with id =" + badName.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(badName);
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
			Session session = HibernateUtil.currentSession();
			session.delete(badName);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IBadNameDao.findAllBadNames
     */
	public Collection<BadName> findAllBadNames() throws DaoException {
		LOG.debug("Find all instance of BadName entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BadName.class);
			Collection<BadName> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BadName.class)
				.add(Restrictions.eq("id", id));
			BadName result = (BadName)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param anothername
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.updateAnothername
     */
	public void updateAnothername(Anothername anothername) throws DaoException {
		LOG.debug("Update the entity Anothername with id =" + anothername.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(anothername);
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
			Session session = HibernateUtil.currentSession();
			session.delete(anothername);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IAnothernameDao.findAllAnothernames
     */
	public Collection<Anothername> findAllAnothernames() throws DaoException {
		LOG.debug("Find all instance of Anothername entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Anothername.class);
			Collection<Anothername> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Anothername.class)
				.add(Restrictions.eq("id", id));
			Anothername result = (Anothername)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param entityWithSpecialChars
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.updateentityWithSpecialChars
     */
	public void updateentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException {
		LOG.debug("Update the entity EntityWithSpecialChars with id =" + entityWithSpecialChars.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(entityWithSpecialChars);
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
			Session session = HibernateUtil.currentSession();
			session.delete(entityWithSpecialChars);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.findAllentityWithSpecialCharss
     */
	public Collection<EntityWithSpecialChars> findAllentityWithSpecialCharss() throws DaoException {
		LOG.debug("Find all instance of EntityWithSpecialChars entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(EntityWithSpecialChars.class);
			Collection<EntityWithSpecialChars> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(EntityWithSpecialChars.class)
				.add(Restrictions.eq("id", id));
			EntityWithSpecialChars result = (EntityWithSpecialChars)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param public_
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.updatepublic_
     */
	public void updatepublic_(Public_ public_) throws DaoException {
		LOG.debug("Update the entity Public_ with id =" + public_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(public_);
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
			Session session = HibernateUtil.currentSession();
			session.delete(public_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPublic_Dao.findAllpublic_s
     */
	public Collection<Public_> findAllpublic_s() throws DaoException {
		LOG.debug("Find all instance of Public_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Public_.class);
			Collection<Public_> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Public_.class)
				.add(Restrictions.eq("id", id));
			Public_ result = (Public_)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param private_
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.updateprivate_
     */
	public void updateprivate_(Private_ private_) throws DaoException {
		LOG.debug("Update the entity Private_ with id =" + private_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(private_);
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
			Session session = HibernateUtil.currentSession();
			session.delete(private_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IPrivate_Dao.findAllprivate_s
     */
	public Collection<Private_> findAllprivate_s() throws DaoException {
		LOG.debug("Find all instance of Private_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Private_.class);
			Collection<Private_> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Private_.class)
				.add(Restrictions.eq("id", id));
			Private_ result = (Private_)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param protected_
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.updateprotected_
     */
	public void updateprotected_(Protected_ protected_) throws DaoException {
		LOG.debug("Update the entity Protected_ with id =" + protected_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(protected_);
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
			Session session = HibernateUtil.currentSession();
			session.delete(protected_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.IProtected_Dao.findAllprotected_s
     */
	public Collection<Protected_> findAllprotected_s() throws DaoException {
		LOG.debug("Find all instance of Protected_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Protected_.class);
			Collection<Protected_> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Protected_.class)
				.add(Restrictions.eq("id", id));
			Protected_ result = (Protected_)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param null_
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.updatenull_
     */
	public void updatenull_(Null_ null_) throws DaoException {
		LOG.debug("Update the entity Null_ with id =" + null_.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(null_);
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
			Session session = HibernateUtil.currentSession();
			session.delete(null_);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.badpractives.INull_Dao.findAllnull_s
     */
	public Collection<Null_> findAllnull_s() throws DaoException {
		LOG.debug("Find all instance of Null_ entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Null_.class);
			Collection<Null_> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Null_.class)
				.add(Restrictions.eq("id", id));
			Null_ result = (Null_)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(myEntity);
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
			Session session = HibernateUtil.currentSession();
			session.update(myEntity);
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
			Session session = HibernateUtil.currentSession();
			session.delete(myEntity);
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(MyEntity.class);
			Collection<MyEntity> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(MyEntity.class)
				.add(Restrictions.eq("id", id));
			MyEntity result = (MyEntity)criteria.uniqueResult();
			
			return result;
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
			Session session = HibernateUtil.currentSession();
			session.save(tABLE);
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
			Session session = HibernateUtil.currentSession();
			session.update(tABLE);
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
			Session session = HibernateUtil.currentSession();
			session.delete(tABLE);
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(TABLE.class);
			Collection<TABLE> resultList = criteria.list();
			
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
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(TABLE.class)
				.add(Restrictions.eq("id", id));
			TABLE result = (TABLE)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
