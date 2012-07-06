package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class11ENDSub;

// End of user code for import

/**
 * This class provides the data access layer to the Class_1_1_END_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass11ENDSubDao {

	/**
	 * Create a new element.
	 * @param class11ENDSub Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class11ENDSub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class11ENDSub Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class11ENDSub> findAllClass11ENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class11ENDSub findClass11ENDSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}