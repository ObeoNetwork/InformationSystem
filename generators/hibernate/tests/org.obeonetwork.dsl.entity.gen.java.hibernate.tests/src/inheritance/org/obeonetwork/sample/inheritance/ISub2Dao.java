package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.Sub2;

// End of user code

/**
 * This class provides the data access layer to the Sub2 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface ISub2Dao {

	/**
	 * Create a new element.
	 * @param sub2 Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createSub2(Sub2 sub2) throws DaoException;

	/**
	 * Update an existing element.
	 * @param sub2 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateSub2(Sub2 sub2) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param sub2 Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteSub2(Sub2 sub2) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Sub2> findAllSub2s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Sub2 findSub2ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
