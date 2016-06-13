package org.obeonetwork.sample.demo.weblogng.users;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.users.User;

// End of user code

/**
 * This class provides the data access layer to the User entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IUserDao {

	/**
	 * Create a new element.
	 * @param user Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createUser(User user) throws DaoException;

	/**
	 * Update an existing element.
	 * @param user Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateUser(User user) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param user Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteUser(User user) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<User> findAllUsers() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public User findUserById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
