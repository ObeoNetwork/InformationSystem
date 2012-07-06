package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEnd;

// End of user code for import

/**
 * This class provides the data access layer to the Class_Many_Many_End entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassManyManyEndDao {

	/**
	 * Create a new element.
	 * @param classManyManyEnd Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classManyManyEnd Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classManyManyEnd Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassManyManyEnd> findAllClassManyManyEnds() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassManyManyEnd findClassManyManyEndById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}