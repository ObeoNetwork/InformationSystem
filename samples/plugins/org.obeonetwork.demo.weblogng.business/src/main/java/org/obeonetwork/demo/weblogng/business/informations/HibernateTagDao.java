package org.obeonetwork.demo.weblogng.business.informations;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.demo.weblogng.business.informations.Tag;
import org.obeonetwork.demo.weblogng.business.informations.ITagDao;

// End of user code

/**
 * Implementation of DAO interface ITagDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.demo.weblogng.business.informations.ITagDao
 */
public class HibernateTagDao extends AbstractHibernateDAO<Tag> implements ITagDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateTagDao.class);

	/**
	 * Create a new element
	 * @param tag Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.demo.weblogng.business.informations.ITagDao.createTag
     */
	public void createTag(final Tag tag) throws DaoException {
		LOG.debug("Create a new Tag entity");
		try {
			getHibernateTemplate().save(tag);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param tag
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.demo.weblogng.business.informations.ITagDao.updateTag
     */
	public void updateTag(Tag tag) throws DaoException {
		LOG.debug("Update the entity Tag with id =" + tag.getId());
		try {
			getHibernateTemplate().update(tag);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param tag Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.demo.weblogng.business.informations.ITagDao.deleteTag
   	 */
	public void deleteTag(Tag tag) throws DaoException {
		LOG.debug("Delete the entity Tag with id =" + tag.getId());
		try {
			getHibernateTemplate().delete(tag);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.demo.weblogng.business.informations.ITagDao.findAllTags
     */
	public Collection<Tag> findAllTags() throws DaoException {
		LOG.debug("Find all instance of Tag entity");
		try {
			Collection<Tag> resultList = getHibernateTemplate().loadAll(Tag.class);
			LOG.debug("Found " + resultList.size() + " instances of Tag entity");
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
     * @see org.obeonetwork.demo.weblogng.business.informations.ITagDao.findTagById
     */
	public Tag findTagById(String id) throws DaoException {
		LOG.debug("Find one instance of Tag entity by id : " + id);
		try {
			return (Tag) getHibernateTemplate().load(Tag.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code 
	//End of user code
}

