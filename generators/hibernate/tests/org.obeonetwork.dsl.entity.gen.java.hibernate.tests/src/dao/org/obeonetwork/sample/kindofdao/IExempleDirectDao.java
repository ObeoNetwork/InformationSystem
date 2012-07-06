package org.obeonetwork.sample.kindofdao;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.kindofdao.ExempleDirect;

// End of user code for import

/**
 * This class provides the data access layer to the ExempleDirect entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IExempleDirectDao {

	/**
	 * Create a new element.
	 * @param exempleDirect Element to create.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createExempleDirect(ExempleDirect exempleDirect) throws DaoException;

	/**
	 * Update an existing element.
	 * @param exempleDirect Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateExempleDirect(ExempleDirect exempleDirect) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param exempleDirect Element which will be delete. 
	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteExempleDirect(ExempleDirect exempleDirect) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<ExempleDirect> findAllExempleDirects() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a Dao problem occurs.
	 */
	public ExempleDirect findExempleDirectById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}