package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.block2.api;

// Start of user code for import
import java.util.Collection;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity2;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity3;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity5;
import org.obeonetwork.fwk.dao.pack.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Block2 entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IBlock2Dao {

	/**
	 * Create a new element.
	 * @param entity2 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity2(Entity2 entity2) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity2 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity2(Entity2 entity2) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity2 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity2(Entity2 entity2) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity2s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity2 findEntity2ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entity3 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity3(Entity3 entity3) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity3 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity3(Entity3 entity3) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity3 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity3(Entity3 entity3) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity3s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity3 findEntity3ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param entity5 Element to create.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createEntity5(Entity5 entity5) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity5 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateEntity5(Entity5 entity5) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity5 Element which will be delete. 
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteEntity5(Entity5 entity5) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection findAllEntity5s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a DAO problem occurs.
	 */
	public Entity5 findEntity5ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
