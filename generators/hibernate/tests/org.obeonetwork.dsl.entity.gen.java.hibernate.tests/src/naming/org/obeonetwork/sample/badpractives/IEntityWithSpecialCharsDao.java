package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.EntityWithSpecialChars;

// End of user code for import

/**
 * This class provides the data access layer to the entityWithSpécialChars entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IEntityWithSpecialCharsDao {

	/**
	 * Create a new element.
	 * @param entityWithSpecialChars Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException;

	/**
	 * Update an existing element.
	 * @param entityWithSpecialChars Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param entityWithSpecialChars Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteentityWithSpecialChars(EntityWithSpecialChars entityWithSpecialChars) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<EntityWithSpecialChars> findAllentityWithSpecialCharss() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public EntityWithSpecialChars findentityWithSpecialCharsById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}