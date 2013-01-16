package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBISub;

// End of user code

/**
 * This class provides the data access layer to the Class_01_Many_BI_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass01ManyBISubDao {

	/**
	 * Create a new element.
	 * @param class01ManyBISub Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class01ManyBISub Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class01ManyBISub Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class01ManyBISub> findAllClass01ManyBISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class01ManyBISub findClass01ManyBISubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
