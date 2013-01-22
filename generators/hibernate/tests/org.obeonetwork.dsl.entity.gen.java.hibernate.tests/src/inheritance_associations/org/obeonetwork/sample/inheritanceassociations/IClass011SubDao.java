package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class011Sub;

// End of user code

/**
 * This class provides the data access layer to the Class_01_1_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass011SubDao {

	/**
	 * Create a new element.
	 * @param class011Sub Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass011Sub(Class011Sub class011Sub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class011Sub Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass011Sub(Class011Sub class011Sub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class011Sub Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass011Sub(Class011Sub class011Sub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class011Sub> findAllClass011Subs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class011Sub findClass011SubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
