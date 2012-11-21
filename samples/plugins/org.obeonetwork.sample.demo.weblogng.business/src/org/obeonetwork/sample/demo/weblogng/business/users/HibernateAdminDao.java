package org.obeonetwork.sample.demo.weblogng.business.users;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.business.users.Admin;
import org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao;

// End of user code

/**
 * Implementation of DAO interface IAdminDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao
 */
public class HibernateAdminDao extends AbstractHibernateDAO<Admin> implements IAdminDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateAdminDao.class);

	/**
	 * Create a new element
	 * @param admin Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao.createAdmin
     */
	public void createAdmin(final Admin admin) throws DaoException {
		LOG.debug("Create a new Admin entity");
		try {
			getHibernateTemplate().save(admin);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param admin
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao.updateAdmin
     */
	public void updateAdmin(Admin admin) throws DaoException {
		LOG.debug("Update the entity Admin with id =" + admin.getId());
		try {
			getHibernateTemplate().update(admin);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param admin Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao.deleteAdmin
   	 */
	public void deleteAdmin(Admin admin) throws DaoException {
		LOG.debug("Delete the entity Admin with id =" + admin.getId());
		try {
			getHibernateTemplate().delete(admin);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao.findAllAdmins
     */
	public Collection<Admin> findAllAdmins() throws DaoException {
		LOG.debug("Find all instance of Admin entity");
		try {
			Collection<Admin> resultList = getHibernateTemplate().loadAll(Admin.class);
			LOG.debug("Found " + resultList.size() + " instances of Admin entity");
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
     * @see org.obeonetwork.sample.demo.weblogng.business.users.IAdminDao.findAdminById
     */
	public Admin findAdminById(String id) throws DaoException {
		LOG.debug("Find one instance of Admin entity by id : " + id);
		try {
			return (Admin) getHibernateTemplate().load(Admin.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code  
	//End of user code
}

