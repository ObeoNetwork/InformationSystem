package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIENDSub;

// End of user code for import

/**
 * This class provides the data access layer to the Class_Many_01_BI_END_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassMany01BIENDSubDao {

	/**
	 * Create a new element.
	 * @param classMany01BIENDSub Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classMany01BIENDSub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classMany01BIENDSub Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassMany01BIENDSub> findAllClassMany01BIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassMany01BIENDSub findClassMany01BIENDSubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}