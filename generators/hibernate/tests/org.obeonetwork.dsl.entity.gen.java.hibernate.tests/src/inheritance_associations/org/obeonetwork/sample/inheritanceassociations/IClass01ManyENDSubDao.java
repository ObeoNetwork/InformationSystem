package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyENDSub;

// End of user code

/**
 * This class provides the data access layer to the Class_01_Many_END_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClass01ManyENDSubDao {

	/**
	 * Create a new element.
	 * @param class01ManyENDSub Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class01ManyENDSub Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class01ManyENDSub Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Class01ManyENDSub> findAllClass01ManyENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Class01ManyENDSub findClass01ManyENDSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
