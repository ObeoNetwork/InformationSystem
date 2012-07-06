package org.obeonetwork.sample.operation;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.operation.Finders;

// End of user code for import

/**
 * This class provides the data access layer to the Finders entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IFindersDao {

	/**
	 * Create a new element.
	 * @param finders Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createFinders(Finders finders) throws DaoException;

	/**
	 * Update an existing element.
	 * @param finders Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateFinders(Finders finders) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param finders Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteFinders(Finders finders) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Finders> findAllFinderss() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Finders findFindersById(String id) throws DaoException;

	/**
	 * Find all entities by the attributes .
	 * @return A collection with all matching entities.
	 */
	public Collection<Finders> finder() throws DaoException;
	
	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}