package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class011BISub;

// End of user code

/**
 * This class provides the data access layer to the Class_01_1_BI_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass011BISubDao {

	/**
	 * Create a new element.
	 * @param class011BISub Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass011BISub(Class011BISub class011BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class011BISub Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass011BISub(Class011BISub class011BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class011BISub Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass011BISub(Class011BISub class011BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class011BISub> findAllClass011BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class011BISub findClass011BISubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
