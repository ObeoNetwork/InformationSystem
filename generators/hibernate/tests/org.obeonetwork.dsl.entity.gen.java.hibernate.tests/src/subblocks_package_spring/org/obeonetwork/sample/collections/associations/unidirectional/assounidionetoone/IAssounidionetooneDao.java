package org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.A;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.B;

// End of user code for import

/**
 * This class provides the data access layer to the asso_unidi_one_to_one entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IAssounidionetooneDao {

	/**
	 * Create a new element.
	 * @param a Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createA(A a) throws DaoException;

	/**
	 * Update an existing element.
	 * @param a Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateA(A a) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param a Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteA(A a) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<A> findAllAs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public A findAById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param b Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createB(B b) throws DaoException;

	/**
	 * Update an existing element.
	 * @param b Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateB(B b) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param b Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteB(B b) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<B> findAllBs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public B findBById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}