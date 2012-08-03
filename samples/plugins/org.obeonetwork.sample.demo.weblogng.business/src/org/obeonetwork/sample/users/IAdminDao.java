package org.obeonetwork.sample.users;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.users.Admin;

// End of user code for import

/**
 * This class provides the data access layer to the Admin entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IAdminDao {

	/**
	 * Create a new element.
	 * @param admin Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createAdmin(Admin admin) throws DaoException;

	/**
	 * Update an existing element.
	 * @param admin Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateAdmin(Admin admin) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param admin Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteAdmin(Admin admin) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Admin> findAllAdmins() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Admin findAdminById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}