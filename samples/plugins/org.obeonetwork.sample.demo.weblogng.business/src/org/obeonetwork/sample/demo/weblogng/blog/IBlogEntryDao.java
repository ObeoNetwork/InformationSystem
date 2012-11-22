package org.obeonetwork.sample.demo.weblogng.blog;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.blog.BlogEntry;

// End of user code

/**
 * This class provides the data access layer to the BlogEntry entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IBlogEntryDao {

	/**
	 * Create a new element.
	 * @param blogEntry Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createBlogEntry(BlogEntry blogEntry) throws DaoException;

	/**
	 * Update an existing element.
	 * @param blogEntry Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateBlogEntry(BlogEntry blogEntry) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param blogEntry Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteBlogEntry(BlogEntry blogEntry) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<BlogEntry> findAllBlogEntrys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public BlogEntry findBlogEntryById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
