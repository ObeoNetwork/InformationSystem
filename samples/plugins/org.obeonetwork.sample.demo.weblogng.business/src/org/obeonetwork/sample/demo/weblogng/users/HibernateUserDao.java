package org.obeonetwork.sample.demo.weblogng.users;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.demo.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.demo.weblogng.users.User;
import org.obeonetwork.sample.demo.weblogng.users.IUserDao;

// End of user code

/**
 * Implementation of DAO interface IUserDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.demo.weblogng.users.IUserDao
 */
public class HibernateUserDao extends AbstractHibernateDAO<User> implements IUserDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateUserDao.class);

	/**
	 * Create a new element
	 * @param user Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IUserDao.createUser
     */
	public void createUser(final User user) throws DaoException {
		LOG.debug("Create a new User entity");
		try {
			getHibernateTemplate().save(user);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param user
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IUserDao.updateUser
     */
	public void updateUser(User user) throws DaoException {
		LOG.debug("Update the entity User with id =" + user.getId());
		try {
			getHibernateTemplate().update(user);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param user Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IUserDao.deleteUser
   	 */
	public void deleteUser(User user) throws DaoException {
		LOG.debug("Delete the entity User with id =" + user.getId());
		try {
			getHibernateTemplate().delete(user);
			getHibernateTemplate().flush();
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.demo.weblogng.users.IUserDao.findAllUsers
     */
	public Collection<User> findAllUsers() throws DaoException {
		LOG.debug("Find all instance of User entity");
		try {
			Collection<User> resultList = getHibernateTemplate().loadAll(User.class);
			LOG.debug("Found " + resultList.size() + " instances of User entity");
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
     * @see org.obeonetwork.sample.demo.weblogng.users.IUserDao.findUserById
     */
	public User findUserById(String id) throws DaoException {
		LOG.debug("Find one instance of User entity by id : " + id);
		try {
			return (User) getHibernateTemplate().load(User.class, id);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code  
	//End of user code
}

