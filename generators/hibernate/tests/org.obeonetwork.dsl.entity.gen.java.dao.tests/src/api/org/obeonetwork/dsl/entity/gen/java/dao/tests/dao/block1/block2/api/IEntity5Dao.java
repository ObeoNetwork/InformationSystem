package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity5;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity5 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntity5Dao {

	/**
	 * Create a new element.
	 * @param entity5 Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createEntity5(Entity5 entity5) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity5 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateEntity5(Entity5 entity5) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity5 Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteEntity5(Entity5 entity5) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection findAllEntity5s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Entity5 findEntity5ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
