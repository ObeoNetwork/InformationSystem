package org.obeonetwork.sample.demo.weblogng.business.users;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.business.users.Moderator;

// End of user code

/**
 * This class provides the data access layer to the Moderator entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IModeratorDao {

	/**
	 * Create a new element.
	 * @param moderator Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createModerator(Moderator moderator) throws DaoException;

	/**
	 * Update an existing element.
	 * @param moderator Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateModerator(Moderator moderator) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param moderator Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteModerator(Moderator moderator) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Moderator> findAllModerators() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Moderator findModeratorById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
