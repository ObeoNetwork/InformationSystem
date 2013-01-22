package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.BadName;

// End of user code

/**
 * This class provides the data access layer to the Bad name entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IBadNameDao {

	/**
	 * Create a new element.
	 * @param badName Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createBadName(BadName badName) throws DaoException;

	/**
	 * Update an existing element.
	 * @param badName Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateBadName(BadName badName) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param badName Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteBadName(BadName badName) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<BadName> findAllBadNames() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public BadName findBadNameById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
