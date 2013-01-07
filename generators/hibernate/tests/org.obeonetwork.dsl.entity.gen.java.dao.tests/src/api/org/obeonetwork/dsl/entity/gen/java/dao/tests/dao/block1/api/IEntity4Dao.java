package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity4;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity4 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntity4Dao {

	/**
	 * Create a new element.
	 * @param entity4 Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createEntity4(Entity4 entity4) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity4 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateEntity4(Entity4 entity4) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity4 Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteEntity4(Entity4 entity4) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection findAllEntity4s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Entity4 findEntity4ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
