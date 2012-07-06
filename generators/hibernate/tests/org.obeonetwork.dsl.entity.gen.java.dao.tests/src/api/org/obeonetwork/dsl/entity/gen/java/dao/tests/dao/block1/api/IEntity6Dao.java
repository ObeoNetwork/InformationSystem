package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.block1.Entity6;

// End of user code for import

/**
 * This class provides the data access layer to the Entity6 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntity6Dao {

	/**
	 * Create a new element.
	 * @param entity6 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createEntity6(Entity6 entity6) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity6 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateEntity6(Entity6 entity6) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity6 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteEntity6(Entity6 entity6) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Entity6> findAllEntity6s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Entity6 findEntity6ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}