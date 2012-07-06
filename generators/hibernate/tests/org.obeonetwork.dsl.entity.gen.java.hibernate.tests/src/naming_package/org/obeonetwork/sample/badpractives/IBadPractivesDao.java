package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

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

// End of user code for import

/**
 * This class provides the data access layer to the badPractives entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IBadPractivesDao {

	/**
	 * Create a new element.
	 * @param interface Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createInterface_(Interface_ interface_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param interface Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateInterface_(Interface_ interface_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param interface Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteInterface_(Interface_ interface_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Interface_> findAllInterface_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Interface_ findInterface_ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass_(Class_ class_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass_(Class_ class_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass_(Class_ class_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class_> findAllClass_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class_ findClass_ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param bad name Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createBadName(BadName badName) throws DaoException;

	/**
	 * Update an existing element.
	 * @param bad name Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateBadName(BadName badName) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param bad name Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteBadName(BadName badName) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<BadName> findAllBadNames() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public BadName findBadNameById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param another.name Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createAnothername(Anothername anothername) throws DaoException;

	/**
	 * Update an existing element.
	 * @param another.name Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateAnothername(Anothername anothername) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param another.name Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteAnothername(Anothername anothername) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Anothername> findAllAnothernames() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Anothername findAnothernameById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entityWithSpécialChars Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entityWithSpécialChars Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entityWithSpécialChars Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<EntityWithSpecialChars> findAllentityWithSpecialCharss() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public EntityWithSpecialChars findentityWithSpecialCharsById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param public Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createpublic_(Public_ public_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param public Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updatepublic_(Public_ public_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param public Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deletepublic_(Public_ public_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Public_> findAllpublic_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Public_ findpublic_ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param private Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createprivate_(Private_ private_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param private Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateprivate_(Private_ private_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param private Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteprivate_(Private_ private_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Private_> findAllprivate_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Private_ findprivate_ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param protected Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createprotected_(Protected_ protected_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param protected Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateprotected_(Protected_ protected_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param protected Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteprotected_(Protected_ protected_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Protected_> findAllprotected_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Protected_ findprotected_ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param null Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createnull_(Null_ null_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param null Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updatenull_(Null_ null_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param null Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deletenull_(Null_ null_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Null_> findAllnull_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Null_ findnull_ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param myEntity Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createmyEntity(MyEntity myEntity) throws DaoException;

	/**
	 * Update an existing element.
	 * @param myEntity Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updatemyEntity(MyEntity myEntity) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param myEntity Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deletemyEntity(MyEntity myEntity) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<MyEntity> findAllmyEntitys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public MyEntity findmyEntityById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param tABLE Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createTABLE(TABLE tABLE) throws DaoException;

	/**
	 * Update an existing element.
	 * @param tABLE Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateTABLE(TABLE tABLE) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param tABLE Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteTABLE(TABLE tABLE) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<TABLE> findAllTABLEs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public TABLE findTABLEById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}