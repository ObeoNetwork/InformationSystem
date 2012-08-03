package org.obeonetwork.sample.informations;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.informations.Category;
import org.obeonetwork.sample.informations.ICategoryDao;

// End of user code for import

/**
 * Implementation of DAO interface ICategoryDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.informations.ICategoryDao
 */
public class HibernateCategoryDao extends AbstractHibernateDAO<Category> implements ICategoryDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateCategoryDao.class);

	/**
	 * Create a new element
	 * @param category Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.informations.ICategoryDao.createCategory
     */
	public void createCategory(final Category category) throws DaoException {
		LOG.debug("Create a new Category entity");
		try {
			getHibernateTemplate().save(category);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param category
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.informations.ICategoryDao.updateCategory
     */
	public void updateCategory(Category category) throws DaoException {
		LOG.debug("Update the entity Category with id =" + category.getId());
		try {
			getHibernateTemplate().update(category);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param category Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.informations.ICategoryDao.deleteCategory
   	 */
	public void deleteCategory(Category category) throws DaoException {
		LOG.debug("Delete the entity Category with id =" + category.getId());
		try {
			getHibernateTemplate().delete(category);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.informations.ICategoryDao.findAllCategorys
     */
	public Collection<Category> findAllCategorys() throws DaoException {
		LOG.debug("Find all instance of Category entity");
		try {
			Collection<Category> resultList = getHibernateTemplate().loadAll(Category.class);
			LOG.debug("Found " + resultList.size() + " instances of Category entity");
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
     * @see org.obeonetwork.sample.informations.ICategoryDao.findCategoryById
     */
	public Category findCategoryById(String id) throws DaoException {
		LOG.debug("Find one instance of Category entity by id : " + id);
		try {
			return (Category) getHibernateTemplate().load(Category.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}
