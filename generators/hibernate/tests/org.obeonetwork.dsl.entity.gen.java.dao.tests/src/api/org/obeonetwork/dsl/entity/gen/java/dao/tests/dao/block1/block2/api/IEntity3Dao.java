package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.block1.block2.Entity3;

// End of user code for import

/**
 * This class provides the data access layer to the Entity3 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntity3Dao {

	/**
	 * Create a new element.
	 * @param entity3 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createEntity3(Entity3 entity3) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entity3 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateEntity3(Entity3 entity3) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entity3 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteEntity3(Entity3 entity3) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Entity3> findAllEntity3s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Entity3 findEntity3ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}