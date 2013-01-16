package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class011BI;

// End of user code

/**
 * This class provides the data access layer to the Class_01_1_BI entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass011BIDao {

	/**
	 * Create a new element.
	 * @param class011BI Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass011BI(Class011BI class011BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class011BI Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass011BI(Class011BI class011BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class011BI Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass011BI(Class011BI class011BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class011BI> findAllClass011BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class011BI findClass011BIById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
