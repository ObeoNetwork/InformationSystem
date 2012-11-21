package org.obeonetwork.sample.demo.weblogng.business.informations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.business.informations.Comment;

// End of user code

/**
 * This class provides the data access layer to the Comment entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface ICommentDao {

	/**
	 * Create a new element.
	 * @param comment Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createComment(Comment comment) throws DaoException;

	/**
	 * Update an existing element.
	 * @param comment Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updateComment(Comment comment) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param comment Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deleteComment(Comment comment) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Comment> findAllComments() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Comment findCommentById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
