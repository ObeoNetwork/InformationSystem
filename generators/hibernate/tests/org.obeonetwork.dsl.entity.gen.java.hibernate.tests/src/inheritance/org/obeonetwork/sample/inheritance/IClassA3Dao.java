package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.ClassA3;

// End of user code

/**
 * This class provides the data access layer to the ClassA3 entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassA3Dao {

	/**
	 * Create a new element.
	 * @param classA3 Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassA3(ClassA3 classA3) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classA3 Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassA3(ClassA3 classA3) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classA3 Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassA3(ClassA3 classA3) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassA3> findAllClassA3s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassA3 findClassA3ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
