package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BISub;

// End of user code for import

/**
 * This class provides the data access layer to the Class_Many_01_BI_Sub entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IClassMany01BISubDao {

	/**
	 * Create a new element.
	 * @param classMany01BISub Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classMany01BISub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classMany01BISub Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ClassMany01BISub> findAllClassMany01BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ClassMany01BISub findClassMany01BISubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}