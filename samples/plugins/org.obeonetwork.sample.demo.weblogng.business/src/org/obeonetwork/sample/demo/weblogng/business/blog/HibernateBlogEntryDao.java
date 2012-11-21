package org.obeonetwork.sample.demo.weblogng.business.blog;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.business.blog.BlogEntry;
import org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao;

// End of user code

/**
 * Implementation of DAO interface IBlogEntryDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao
 */
public class HibernateBlogEntryDao extends AbstractHibernateDAO<BlogEntry> implements IBlogEntryDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateBlogEntryDao.class);

	/**
	 * Create a new element
	 * @param blogEntry Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao.createBlogEntry
     */
	public void createBlogEntry(final BlogEntry blogEntry) throws DaoException {
		LOG.debug("Create a new BlogEntry entity");
		try {
			getHibernateTemplate().save(blogEntry);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param blogEntry
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao.updateBlogEntry
     */
	public void updateBlogEntry(BlogEntry blogEntry) throws DaoException {
		LOG.debug("Update the entity BlogEntry with id =" + blogEntry.getId());
		try {
			getHibernateTemplate().update(blogEntry);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param blogEntry Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao.deleteBlogEntry
   	 */
	public void deleteBlogEntry(BlogEntry blogEntry) throws DaoException {
		LOG.debug("Delete the entity BlogEntry with id =" + blogEntry.getId());
		try {
			getHibernateTemplate().delete(blogEntry);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao.findAllBlogEntrys
     */
	public Collection<BlogEntry> findAllBlogEntrys() throws DaoException {
		LOG.debug("Find all instance of BlogEntry entity");
		try {
			Collection<BlogEntry> resultList = getHibernateTemplate().loadAll(BlogEntry.class);
			LOG.debug("Found " + resultList.size() + " instances of BlogEntry entity");
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
     * @see org.obeonetwork.sample.demo.weblogng.business.blog.IBlogEntryDao.findBlogEntryById
     */
	public BlogEntry findBlogEntryById(String id) throws DaoException {
		LOG.debug("Find one instance of BlogEntry entity by id : " + id);
		try {
			return (BlogEntry) getHibernateTemplate().load(BlogEntry.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code  
	//End of user code
}

