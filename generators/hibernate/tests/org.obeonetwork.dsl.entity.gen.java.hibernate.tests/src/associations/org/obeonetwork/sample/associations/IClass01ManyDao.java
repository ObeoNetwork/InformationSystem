package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.Class01Many;

// End of user code

/**
 * This class provides the data access layer to the Class_01_Many entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass01ManyDao {

	/**
	 * Create a new element.
	 * @param class01Many Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass01Many(Class01Many class01Many) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class01Many Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass01Many(Class01Many class01Many) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class01Many Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass01Many(Class01Many class01Many) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class01Many> findAllClass01Manys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class01Many findClass01ManyById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
