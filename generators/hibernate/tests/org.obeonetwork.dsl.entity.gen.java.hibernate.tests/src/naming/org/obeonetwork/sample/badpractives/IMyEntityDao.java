package org.obeonetwork.sample.badpractives;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.MyEntity;

// End of user code

/**
 * This class provides the data access layer to the myEntity entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IMyEntityDao {

	/**
	 * Create a new element.
	 * @param myEntity Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createmyEntity(MyEntity myEntity) throws DaoException;

	/**
	 * Update an existing element.
	 * @param myEntity Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updatemyEntity(MyEntity myEntity) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param myEntity Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deletemyEntity(MyEntity myEntity) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<MyEntity> findAllmyEntitys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public MyEntity findmyEntityById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
