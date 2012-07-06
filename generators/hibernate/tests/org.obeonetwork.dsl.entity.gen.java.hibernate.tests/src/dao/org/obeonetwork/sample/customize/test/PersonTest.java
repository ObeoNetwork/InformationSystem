package org.obeonetwork.sample.customize.test;

// Start of user code for import 
import java.util.Date;

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.customize.IPersonDao;
import org.obeonetwork.sample.customize.Person;
import org.obeonetwork.sample.customize.Address;
import org.obeonetwork.sample.customize.IAddressDao;
// End of user code for import

/**
 * Test class for Person.
 */
public class PersonTest extends TestCase {

	/**
	 * The DAO for class Person.
	 */
	private IPersonDao personDao;

	/**
	 * The DAO for class Address.
	 */
	private IAddressDao addressDao;

	/**
	 * The transaction that will be used.
	 */
	private Transaction tx;



	/**
	 * Sets up the test before its execution, by creating the dao and the
	 * transaction.
	 * @throws Exception if an unexpected exception occurs.
	 */
	@Override
	protected void setUp() throws Exception {
	    super.setUp();
		personDao = SampleDaoFactory.getPersonDao();
		addressDao = SampleDaoFactory.getAddressDao();
		tx = HibernateUtil.currentSession().beginTransaction();
	}


	/**
	 * Cleans up the test after its execution, by commiting the transaction in
	 * order for the DB changes to become visible, and closing hibernate's
	 * session.
	 * @throws Exception if an unexpected exception occurs.
	 */
	@Override
	protected void tearDown() throws Exception {
	    super.tearDown();
		tx.commit();
	    HibernateUtil.closeSession();
	}

    /**
     * Tests the creation of the entity Person.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreatePerson() throws DaoException {
        // fill attributes with example values
        Person person = getPersonExample();
        
        // Execute the tested code
        personDao.createPerson(person);

        // Verify result
        boolean found = false;
        for (Person currentPerson : personDao.findAllPersons()) {
            if (currentPerson.equals(person)) {
                found = true;
            }
        }
        Assert.assertTrue("Person not created", found);
    }

    /**
     * Test the modification of an entity Person.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdatePerson() throws DaoException {
        // Initialized the test
        Person person = getPersonExample();
        personDao.createPerson(person);

        // Execute the tested code
        person.setFirstName("secondFirstName");
        person.setAge(new Integer(96511));
        person.setBirthDate(new Date(1));
        person.setLastName("secondLastName");
        personDao.updatePerson(person);

        // Verify result
        boolean found = false;
        for (Person currentPerson : personDao.findAllPersons()) {
            if (currentPerson.equals(person)) {
                found = true;
                Assert.assertEquals("Value firstName not modified",
                        "secondFirstName",
                        person.getFirstName());
                Assert.assertEquals("Value age not modified",
                        new Integer(96511),
                        person.getAge());
                Assert.assertEquals("Value birthDate not modified",
                        new Date(1),
                        person.getBirthDate());
                Assert.assertEquals("Value lastName not modified",
                        "secondLastName",
                        person.getLastName());
            }
        }
        Assert.assertTrue("Person not found", found);
    }

    /**
     * Test the suppression of an entity Person.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeletePerson() throws DaoException {
        // Initialized the test
        Person person = getPersonExample();
        personDao.createPerson(person);
        
        // Execute the tested code
        personDao.deletePerson(person);
        
        // Verify result
        boolean found = false;
        for (Person currentPerson : personDao.findAllPersons()) {
            if (currentPerson.getId().equals(person.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Person not deleted", found);
    }

    /**
     * Test the search of all entities Person.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllPersons() throws DaoException {
        // Verify number of element before testing
        int before = personDao.findAllPersons().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Person person1 = getPersonExample();
        personDao.createPerson(person1);
                
        Person person2 = getPersonExample();
        personDao.createPerson(person2);

        // Verify result
        int after = personDao.findAllPersons().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Person.
     * @return Returns a new instance of class Person, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Person getPersonExample() throws DaoException {
        // fill attributes with example values
        Person person = new Person();
        person.setFirstName("myFirstName");
        person.setAge(new Integer(96511 + 1));
        person.setBirthDate(new Date(0));
        person.setLastName("myLastName");

        Address addressExample = new Address();
        person.setAddress(addressExample);   
        addressExample.setPerson(person); 
        addressDao.createAddress(addressExample);

        return person;
    }
    
    /**
     * Creates a second example of Person with other values.
     * @return Returns a new instance of class Person with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Person getPersonExample2() throws DaoException {
        // fill attributes with example values
        Person person = new Person();
        person.setFirstName("secondFirstName");
        person.setAge(new Integer(96511));
        person.setBirthDate(new Date(1));
        person.setLastName("secondLastName");

        Address addressExample = new Address();
        person.setAddress(addressExample);   
        addressExample.setPerson(person); 
        addressDao.createAddress(addressExample);

        return person;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
