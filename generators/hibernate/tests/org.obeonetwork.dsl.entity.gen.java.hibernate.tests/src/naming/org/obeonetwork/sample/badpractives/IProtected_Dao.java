package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.Protected_;

// End of user code for import

/**
 * This class provides the data access layer to the protected entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IProtected_Dao {

	/**
	 * Create a new element.
	 * @param protected_ Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createprotected_(Protected_ protected_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param protected_ Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateprotected_(Protected_ protected_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param protected_ Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteprotected_(Protected_ protected_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Protected_> findAllprotected_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Protected_ findprotected_ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}