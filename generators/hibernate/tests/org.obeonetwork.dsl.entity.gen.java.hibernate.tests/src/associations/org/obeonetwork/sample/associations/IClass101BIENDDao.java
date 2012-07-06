package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.Class101BIEND;

// End of user code for import

/**
 * This class provides the data access layer to the Class_1_01_BI_END entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass101BIENDDao {

	/**
	 * Create a new element.
	 * @param class101BIEND Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass101BIEND(Class101BIEND class101BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class101BIEND Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass101BIEND(Class101BIEND class101BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class101BIEND Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass101BIEND(Class101BIEND class101BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class101BIEND> findAllClass101BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class101BIEND findClass101BIENDById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}