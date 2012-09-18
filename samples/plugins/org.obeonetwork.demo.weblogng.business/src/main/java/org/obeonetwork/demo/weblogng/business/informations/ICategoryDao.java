package org.obeonetwork.demo.weblogng.business.informations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.demo.weblogng.business.informations.Category;

// End of user code

/**
 * This class provides the data access layer to the Category entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface ICategoryDao {

	/**
	 * Create a new element.
	 * @param category Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createCategory(Category category) throws DaoException;

	/**
	 * Update an existing element.
	 * @param category Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateCategory(Category category) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param category Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteCategory(Category category) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Category> findAllCategorys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Category findCategoryById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
