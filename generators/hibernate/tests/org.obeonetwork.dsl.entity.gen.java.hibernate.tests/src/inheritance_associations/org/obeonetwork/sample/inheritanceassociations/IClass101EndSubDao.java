package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class101EndSub;

// End of user code for import

/**
 * This class provides the data access layer to the Class_1_01_End_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass101EndSubDao {

	/**
	 * Create a new element.
	 * @param class101EndSub Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass101EndSub(Class101EndSub class101EndSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class101EndSub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass101EndSub(Class101EndSub class101EndSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class101EndSub Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass101EndSub(Class101EndSub class101EndSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class101EndSub> findAllClass101EndSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class101EndSub findClass101EndSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}