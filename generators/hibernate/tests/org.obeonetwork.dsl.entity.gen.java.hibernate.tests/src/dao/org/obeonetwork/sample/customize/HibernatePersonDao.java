package org.obeonetwork.sample.customize;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.customize.Person;
import org.obeonetwork.sample.customize.IPersonDao;

// End of user code for import

/**
 * Implementation of DAO interface IPersonDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.customize.IPersonDao
 */
public class HibernatePersonDao implements IPersonDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernatePersonDao.class);

	/**
	 * Create a new element
	 * @param person Element to create.
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.customize.IPersonDao.createPerson
     */
	public void createPerson(final Person person) throws DaoException {
		LOG.debug("Create a new Person entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(person);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param person
     *            Element to update. If the element has an id,it may use it. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.customize.IPersonDao.updatePerson
     */
	public void updatePerson(Person person) throws DaoException {
		LOG.debug("Update the entity Person with id =" + person.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(person);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param person Element which will be deleted. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.customize.IPersonDao.deletePerson
   	 */
	public void deletePerson(Person person) throws DaoException {
		LOG.debug("Delete the entity Person with id =" + person.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(person);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.customize.IPersonDao.findAllPersons
     */
	public Collection<Person> findAllPersons() throws DaoException {
		LOG.debug("Find all instance of Person entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Person.class);
			Collection<Person> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Person entity");
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
     * @see org.obeonetwork.sample.customize.IPersonDao.findPersonById
     */
	public Person findPersonById(String id) throws DaoException {
		LOG.debug("Find one instance of Person entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Person.class)
				.add(Restrictions.eq("id", id));
			Person result = (Person)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

