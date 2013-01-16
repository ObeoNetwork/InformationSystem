package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEndSub;

// End of user code

/**
 * This class provides the data access layer to the Class_Many_Many_End_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassManyManyEndSubDao {

	/**
	 * Create a new element.
	 * @param classManyManyEndSub Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classManyManyEndSub Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classManyManyEndSub Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassManyManyEndSub> findAllClassManyManyEndSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassManyManyEndSub findClassManyManyEndSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
