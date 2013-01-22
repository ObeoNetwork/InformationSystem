package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIEND;

// End of user code

/**
 * This class provides the data access layer to the Class_Many_01_BI_END entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassMany01BIENDDao {

	/**
	 * Create a new element.
	 * @param classMany01BIEND Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classMany01BIEND Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classMany01BIEND Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassMany01BIEND> findAllClassMany01BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassMany01BIEND findClassMany01BIENDById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
