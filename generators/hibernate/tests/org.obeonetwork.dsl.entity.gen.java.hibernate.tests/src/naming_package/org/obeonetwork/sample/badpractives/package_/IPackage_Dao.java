package org.obeonetwork.sample.badpractives.package_;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.package_.Return_;

// End of user code for import

/**
 * This class provides the data access layer to the package entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IPackage_Dao {

	/**
	 * Create a new element.
	 * @param return Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createreturn_(Return_ return_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param return Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updatereturn_(Return_ return_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param return Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deletereturn_(Return_ return_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Return_> findAllreturn_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Return_ findreturn_ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}