package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.ClassMany01END;

// End of user code

/**
 * This class provides the data access layer to the Class_Many_01_END entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassMany01ENDDao {

	/**
	 * Create a new element.
	 * @param classMany01END Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassMany01END(ClassMany01END classMany01END) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classMany01END Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassMany01END(ClassMany01END classMany01END) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classMany01END Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassMany01END(ClassMany01END classMany01END) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassMany01END> findAllClassMany01ENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassMany01END findClassMany01ENDById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
