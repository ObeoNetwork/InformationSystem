package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.Class_;

// End of user code

/**
 * This class provides the data access layer to the Class entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass_Dao {

	/**
	 * Create a new element.
	 * @param class_ Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass_(Class_ class_) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_ Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass_(Class_ class_) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_ Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass_(Class_ class_) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class_> findAllClass_s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class_ findClass_ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
