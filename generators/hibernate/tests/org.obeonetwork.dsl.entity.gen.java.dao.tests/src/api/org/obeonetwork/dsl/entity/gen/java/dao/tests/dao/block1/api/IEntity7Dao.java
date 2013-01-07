package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity7;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity7 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntity7Dao {

	/**
	 * Create a new element.
	 * @param entity7 Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createEntity7(Entity7 entity7) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity7 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateEntity7(Entity7 entity7) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity7 Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteEntity7(Entity7 entity7) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection findAllEntity7s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Entity7 findEntity7ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
