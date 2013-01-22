package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.TABLE;

// End of user code

/**
 * This class provides the data access layer to the TABLE entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface ITABLEDao {

	/**
	 * Create a new element.
	 * @param tABLE Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createTABLE(TABLE tABLE) throws DaoException;

	/**
	 * Update an existing element.
	 * @param tABLE Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateTABLE(TABLE tABLE) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param tABLE Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteTABLE(TABLE tABLE) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<TABLE> findAllTABLEs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public TABLE findTABLEById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
