package org.obeonetwork.sample.users;

// Start of user code for import
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.users.User;
import org.obeonetwork.sample.users.IUserDao;

// End of user code for import

/**
 * Implementation of DAO interface IUserDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.users.IUserDao
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
     * @see org.obeonetwork.sample.users.IUserDao.createUser
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
     * @see org.obeonetwork.sample.users.IUserDao.updateUser
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
     * @see org.obeonetwork.sample.users.IUserDao.deleteUser
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
     * @see org.obeonetwork.sample.users.IUserDao.findAllUsers
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
     * @see org.obeonetwork.sample.users.IUserDao.findUserById
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
	
	/**
	 * Get a User according to its login and password
	 * @param login 
	 * @param password 
	 * @return UserDto 
	 */
	public User findByLoginAndPassword(String login, String password) throws DaoException {		
		LOG.debug("Call findByLoginAndPassword on User entity");		
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass( User.class )
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("password", password));

			List<?> l = getHibernateTemplate().findByCriteria(criteria);
			User result=null;
			if(l.size()>0){
				result = (User)l.get(0);
			}
			return result;

		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	
	//End of user code
}
