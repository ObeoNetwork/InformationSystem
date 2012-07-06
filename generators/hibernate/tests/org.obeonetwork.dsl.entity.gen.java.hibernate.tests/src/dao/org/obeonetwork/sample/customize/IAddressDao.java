package org.obeonetwork.sample.customize;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.customize.Address;

// End of user code for import

/**
 * This class provides the data access layer to the Address entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IAddressDao {

	/**
	 * Create a new element.
	 * @param address Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createAddress(Address address) throws DaoException;

	/**
	 * Update an existing element.
	 * @param address Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateAddress(Address address) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param address Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteAddress(Address address) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Address> findAllAddresss() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Address findAddressById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}