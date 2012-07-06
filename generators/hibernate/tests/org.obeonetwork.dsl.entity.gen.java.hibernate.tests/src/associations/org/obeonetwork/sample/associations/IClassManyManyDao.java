package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.ClassManyMany;

// End of user code for import

/**
 * This class provides the data access layer to the Class_Many_Many entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassManyManyDao {

	/**
	 * Create a new element.
	 * @param classManyMany Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassManyMany(ClassManyMany classManyMany) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classManyMany Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassManyMany(ClassManyMany classManyMany) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classManyMany Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassManyMany(ClassManyMany classManyMany) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassManyMany> findAllClassManyManys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassManyMany findClassManyManyById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}