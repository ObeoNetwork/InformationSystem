package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.block1.Entity8;

// End of user code for import

/**
 * This class provides the data access layer to the Entity8 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntity8Dao {

	/**
	 * Create a new element.
	 * @param entity8 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createEntity8(Entity8 entity8) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity8 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateEntity8(Entity8 entity8) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity8 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteEntity8(Entity8 entity8) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Entity8> findAllEntity8s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Entity8 findEntity8ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}