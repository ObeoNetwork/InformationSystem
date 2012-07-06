package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.Sub1;

// End of user code for import

/**
 * This class provides the data access layer to the Sub1 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface ISub1Dao {

	/**
	 * Create a new element.
	 * @param sub1 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createSub1(Sub1 sub1) throws DaoException;

	/**
	 * Update an existing element.
	 * @param sub1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateSub1(Sub1 sub1) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param sub1 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteSub1(Sub1 sub1) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Sub1> findAllSub1s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Sub1 findSub1ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}