package org.obeonetwork.sample.demo.weblogng.informations;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.informations.Comment;
import org.obeonetwork.sample.demo.weblogng.informations.ICommentDao;

// End of user code

/**
 * Implementation of DAO interface ICommentDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.demo.weblogng.informations.ICommentDao
 */
public class HibernateCommentDao extends AbstractHibernateDAO<Comment> implements ICommentDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateCommentDao.class);

	/**
	 * Create a new element
	 * @param comment Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.informations.ICommentDao.createComment
     */
	public void createComment(final Comment comment) throws DaoException {
		LOG.debug("Create a new Comment entity");
		try {
			getHibernateTemplate().save(comment);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param comment
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.informations.ICommentDao.updateComment
     */
	public void updateComment(Comment comment) throws DaoException {
		LOG.debug("Update the entity Comment with id =" + comment.getId());
		try {
			getHibernateTemplate().update(comment);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param comment Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.informations.ICommentDao.deleteComment
   	 */
	public void deleteComment(Comment comment) throws DaoException {
		LOG.debug("Delete the entity Comment with id =" + comment.getId());
		try {
			getHibernateTemplate().delete(comment);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.informations.ICommentDao.findAllComments
     */
	public Collection<Comment> findAllComments() throws DaoException {
		LOG.debug("Find all instance of Comment entity");
		try {
			Collection<Comment> resultList = getHibernateTemplate().loadAll(Comment.class);
			LOG.debug("Found " + resultList.size() + " instances of Comment entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.informations.ICommentDao.findCommentById
     */
	public Comment findCommentById(String id) throws DaoException {
		LOG.debug("Find one instance of Comment entity by id : " + id);
		try {
			return (Comment) getHibernateTemplate().load(Comment.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code  
	//End of user code
}

