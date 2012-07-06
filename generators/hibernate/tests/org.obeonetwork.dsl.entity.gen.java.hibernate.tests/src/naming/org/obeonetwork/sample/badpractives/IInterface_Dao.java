package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.Interface_;

// End of user code for import

/**
 * This class provides the data access layer to the Interface entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IInterface_Dao {

	/**
	 * Create a new element.
	 * @param interface_ Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createInterface_(Interface_ interface_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param interface_ Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateInterface_(Interface_ interface_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param interface_ Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteInterface_(Interface_ interface_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Interface_> findAllInterface_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Interface_ findInterface_ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}