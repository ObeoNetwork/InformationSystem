package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01ENDSub;

// End of user code for import

/**
 * This class provides the data access layer to the Class_Many_01_END_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassMany01ENDSubDao {

	/**
	 * Create a new element.
	 * @param classMany01ENDSub Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classMany01ENDSub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classMany01ENDSub Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassMany01ENDSub> findAllClassMany01ENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassMany01ENDSub findClassMany01ENDSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}