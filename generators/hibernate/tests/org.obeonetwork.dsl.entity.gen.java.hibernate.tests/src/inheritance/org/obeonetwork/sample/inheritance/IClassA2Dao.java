package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.ClassA2;

// End of user code for import

/**
 * This class provides the data access layer to the ClassA2 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassA2Dao {

	/**
	 * Create a new element.
	 * @param classA2 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassA2(ClassA2 classA2) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classA2 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassA2(ClassA2 classA2) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classA2 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassA2(ClassA2 classA2) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassA2> findAllClassA2s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassA2 findClassA2ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}