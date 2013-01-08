package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.ClassMany01BI;

// End of user code

/**
 * This class provides the data access layer to the Class_Many_01_BI entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassMany01BIDao {

	/**
	 * Create a new element.
	 * @param classMany01BI Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassMany01BI(ClassMany01BI classMany01BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classMany01BI Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassMany01BI(ClassMany01BI classMany01BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classMany01BI Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassMany01BI(ClassMany01BI classMany01BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassMany01BI> findAllClassMany01BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassMany01BI findClassMany01BIById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
