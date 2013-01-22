package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIENDSub;

// End of user code

/**
 * This class provides the data access layer to the Class_01_01_BI_END_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass0101BIENDSubDao {

	/**
	 * Create a new element.
	 * @param class0101BIENDSub Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class0101BIENDSub Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class0101BIENDSub Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class0101BIENDSub> findAllClass0101BIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class0101BIENDSub findClass0101BIENDSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
