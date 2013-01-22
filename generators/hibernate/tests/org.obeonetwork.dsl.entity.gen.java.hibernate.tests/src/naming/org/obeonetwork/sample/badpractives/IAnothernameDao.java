package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.Anothername;

// End of user code

/**
 * This class provides the data access layer to the Another.name entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IAnothernameDao {

	/**
	 * Create a new element.
	 * @param anothername Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createAnothername(Anothername anothername) throws DaoException;

	/**
	 * Update an existing element.
	 * @param anothername Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateAnothername(Anothername anothername) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param anothername Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteAnothername(Anothername anothername) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Anothername> findAllAnothernames() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Anothername findAnothernameById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
