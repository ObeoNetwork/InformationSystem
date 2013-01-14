package org.obeonetwork.sample.customize;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.customize.Person;

// End of user code

/**
 * This class provides the data access layer to the Person entity class.<br/>
 * This is the interface which represent the contrat of the DAO access.
 */
public interface IPersonDao {

	/**
	 * Create a new element.
	 * @param person Element to create.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void createPerson(Person person) throws DaoException;

	/**
	 * Update an existing element.
	 * @param person Element to update. 
     *            If the element has an id, it may use it.
     	 * @throws DaoException If a Dao problem occurs.
	 */
	public void updatePerson(Person person) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param person Element which will be delete. 
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public void deletePerson(Person person) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Collection<Person> findAllPersons() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 	 * @throws DaoException If a Dao problem occurs.
	 */
	public Person findPersonById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code
}
