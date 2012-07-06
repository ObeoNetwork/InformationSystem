package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.ClassA1;

// End of user code for import

/**
 * This class provides the data access layer to the ClassA1 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassA1Dao {

	/**
	 * Create a new element.
	 * @param classA1 Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassA1(ClassA1 classA1) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classA1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassA1(ClassA1 classA1) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classA1 Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassA1(ClassA1 classA1) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassA1> findAllClassA1s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassA1 findClassA1ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}