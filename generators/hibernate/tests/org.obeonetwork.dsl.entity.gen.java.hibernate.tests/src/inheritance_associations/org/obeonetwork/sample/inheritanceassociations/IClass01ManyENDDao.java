package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyEND;

// End of user code

/**
 * This class provides the data access layer to the Class_01_Many_END entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass01ManyENDDao {

	/**
	 * Create a new element.
	 * @param class01ManyEND Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class01ManyEND Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class01ManyEND Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class01ManyEND> findAllClass01ManyENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class01ManyEND findClass01ManyENDById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
