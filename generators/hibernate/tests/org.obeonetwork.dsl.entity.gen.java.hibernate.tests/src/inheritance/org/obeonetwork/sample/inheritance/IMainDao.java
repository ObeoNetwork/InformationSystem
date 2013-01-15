package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.Main;

// End of user code

/**
 * This class provides the data access layer to the Main entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IMainDao {

	/**
	 * Create a new element.
	 * @param main Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createMain(Main main) throws DaoException;

	/**
	 * Update an existing element.
	 * @param main Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateMain(Main main) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param main Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteMain(Main main) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Main> findAllMains() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Main findMainById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
