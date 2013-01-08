package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.Class11BI;

// End of user code

/**
 * This class provides the data access layer to the Class_1_1_BI entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass11BIDao {

	/**
	 * Create a new element.
	 * @param class11BI Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass11BI(Class11BI class11BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class11BI Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass11BI(Class11BI class11BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class11BI Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass11BI(Class11BI class11BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class11BI> findAllClass11BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class11BI findClass11BIById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
