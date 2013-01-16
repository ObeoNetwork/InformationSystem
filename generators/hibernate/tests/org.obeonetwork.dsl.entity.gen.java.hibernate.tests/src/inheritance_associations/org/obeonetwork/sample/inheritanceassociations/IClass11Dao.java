package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class11;

// End of user code

/**
 * This class provides the data access layer to the Class_1_1 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass11Dao {

	/**
	 * Create a new element.
	 * @param class11 Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass11(Class11 class11) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class11 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass11(Class11 class11) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class11 Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass11(Class11 class11) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class11> findAllClass11s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class11 findClass11ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
