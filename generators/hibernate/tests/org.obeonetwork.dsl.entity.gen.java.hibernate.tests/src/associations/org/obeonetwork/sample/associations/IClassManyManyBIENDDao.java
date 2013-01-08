package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.ClassManyManyBIEND;

// End of user code

/**
 * This class provides the data access layer to the Class_Many_Many_BI_END entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassManyManyBIENDDao {

	/**
	 * Create a new element.
	 * @param classManyManyBIEND Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classManyManyBIEND Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classManyManyBIEND Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassManyManyBIEND> findAllClassManyManyBIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassManyManyBIEND findClassManyManyBIENDById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
