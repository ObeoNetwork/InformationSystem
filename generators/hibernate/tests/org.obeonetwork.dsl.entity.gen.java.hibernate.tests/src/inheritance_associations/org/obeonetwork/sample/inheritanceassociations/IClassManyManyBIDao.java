package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBI;

// End of user code

/**
 * This class provides the data access layer to the Class_Many_Many_BI entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassManyManyBIDao {

	/**
	 * Create a new element.
	 * @param classManyManyBI Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classManyManyBI Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classManyManyBI Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassManyManyBI> findAllClassManyManyBIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassManyManyBI findClassManyManyBIById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
