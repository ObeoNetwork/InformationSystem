package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.BasicWithoutAttr;

// End of user code

/**
 * This class provides the data access layer to the BasicWithoutAttr entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IBasicWithoutAttrDao {

	/**
	 * Create a new element.
	 * @param basicWithoutAttr Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException;

	/**
	 * Update an existing element.
	 * @param basicWithoutAttr Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param basicWithoutAttr Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<BasicWithoutAttr> findAllBasicWithoutAttrs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public BasicWithoutAttr findBasicWithoutAttrById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
