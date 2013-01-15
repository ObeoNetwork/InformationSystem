package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.Basic;

// End of user code

/**
 * This class provides the data access layer to the Basic entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IBasicDao {

	/**
	 * Create a new element.
	 * @param basic Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createBasic(Basic basic) throws DaoException;

	/**
	 * Update an existing element.
	 * @param basic Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateBasic(Basic basic) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param basic Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteBasic(Basic basic) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Basic> findAllBasics() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Basic findBasicById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
