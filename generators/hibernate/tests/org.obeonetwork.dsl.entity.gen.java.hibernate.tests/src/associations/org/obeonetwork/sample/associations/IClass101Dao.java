package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.Class101;

// End of user code for import

/**
 * This class provides the data access layer to the Class_1_01 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass101Dao {

	/**
	 * Create a new element.
	 * @param class101 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass101(Class101 class101) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class101 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass101(Class101 class101) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class101 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass101(Class101 class101) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class101> findAllClass101s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class101 findClass101ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}