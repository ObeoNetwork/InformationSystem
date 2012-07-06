package org.obeonetwork.sample.operation;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.operation.Operations;

// End of user code for import

/**
 * This class provides the data access layer to the Operations entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IOperationsDao {

	/**
	 * Create a new element.
	 * @param operations Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createOperations(Operations operations) throws DaoException;

	/**
	 * Update an existing element.
	 * @param operations Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateOperations(Operations operations) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param operations Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteOperations(Operations operations) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Operations> findAllOperationss() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Operations findOperationsById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}