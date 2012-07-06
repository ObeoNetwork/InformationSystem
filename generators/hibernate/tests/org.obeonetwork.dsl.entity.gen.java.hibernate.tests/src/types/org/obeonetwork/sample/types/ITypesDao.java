package org.obeonetwork.sample.types;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.types.Types;

// End of user code for import

/**
 * This class provides the data access layer to the Types entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface ITypesDao {

	/**
	 * Create a new element.
	 * @param types Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createTypes(Types types) throws DaoException;

	/**
	 * Update an existing element.
	 * @param types Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateTypes(Types types) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param types Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteTypes(Types types) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Types> findAllTypess() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Types findTypesById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}