package org.obeonetwork.sample.inheritence.tableperhierarchy;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritence.tableperhierarchy.Root;
import org.obeonetwork.sample.inheritence.tableperhierarchy.C1;
import org.obeonetwork.sample.inheritence.tableperhierarchy.C2;

// End of user code for import

/**
 * This class provides the data access layer to the table_per_hierarchy entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface ITableperhierarchyDao {

	/**
	 * Create a new element.
	 * @param root Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createRoot(Root root) throws DaoException;

	/**
	 * Update an existing element.
	 * @param root Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateRoot(Root root) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param root Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteRoot(Root root) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Root> findAllRoots() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Root findRootById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param c1 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createC1(C1 c1) throws DaoException;

	/**
	 * Update an existing element.
	 * @param c1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateC1(C1 c1) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param c1 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteC1(C1 c1) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<C1> findAllC1s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public C1 findC1ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param c2 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createC2(C2 c2) throws DaoException;

	/**
	 * Update an existing element.
	 * @param c2 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateC2(C2 c2) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param c2 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteC2(C2 c2) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<C2> findAllC2s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public C2 findC2ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}