package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.api;

// Start of user code for import
import java.util.Collection;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity1;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity4;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity6;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity7;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity8;
import org.obeonetwork.fwk.dao.pack.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Block 1 entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IBlock1Dao {

	/**
	 * Create a new element.
	 * @param entity 1 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity1(Entity1 entity1) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity 1 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity1(Entity1 entity1) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity 1 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity1(Entity1 entity1) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity1s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity1 findEntity1ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entity4 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity4(Entity4 entity4) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity4 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity4(Entity4 entity4) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity4 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity4(Entity4 entity4) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity4s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity4 findEntity4ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entity6 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity6(Entity6 entity6) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity6 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity6(Entity6 entity6) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity6 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity6(Entity6 entity6) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity6s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity6 findEntity6ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entity7 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity7(Entity7 entity7) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity7 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity7(Entity7 entity7) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity7 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity7(Entity7 entity7) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity7s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity7 findEntity7ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entity8 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity8(Entity8 entity8) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity8 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity8(Entity8 entity8) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity8 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity8(Entity8 entity8) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity8s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity8 findEntity8ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
