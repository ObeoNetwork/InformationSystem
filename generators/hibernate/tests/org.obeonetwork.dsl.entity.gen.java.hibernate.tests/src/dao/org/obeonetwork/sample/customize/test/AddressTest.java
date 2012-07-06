package org.obeonetwork.sample.customize.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.customize.IAddressDao;
import org.obeonetwork.sample.customize.Address;
import org.obeonetwork.sample.customize.Person;
import org.obeonetwork.sample.customize.IPersonDao;
// End of user code for import

/**
 * Test class for Address.
 */
public class AddressTest extends TestCase {

	/**
	 * The DAO for class Address.
	 */
	private IAddressDao addressDao;

	/**
	 * The DAO for class Person.
	 */
	private IPersonDao personDao;

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
		addressDao = SampleDaoFactory.getAddressDao();
		personDao = SampleDaoFactory.getPersonDao();
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
     * Tests the creation of the entity Address.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateAddress() throws DaoException {
        // fill attributes with example values
        Address address = getAddressExample();
        
        // Execute the tested code
        addressDao.createAddress(address);

        // Verify result
        boolean found = false;
        for (Address currentAddress : addressDao.findAllAddresss()) {
            if (currentAddress.equals(address)) {
                found = true;
            }
        }
        Assert.assertTrue("Address not created", found);
    }

    /**
     * Test the modification of an entity Address.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateAddress() throws DaoException {
        // Initialized the test
        Address address = getAddressExample();
        addressDao.createAddress(address);

        // Execute the tested code
        address.setCity("secondCity");
        address.setStreet("secondStreet");
        address.setNb("secondNb");
        addressDao.updateAddress(address);

        // Verify result
        boolean found = false;
        for (Address currentAddress : addressDao.findAllAddresss()) {
            if (currentAddress.equals(address)) {
                found = true;
                Assert.assertEquals("Value city not modified",
                        "secondCity",
                        address.getCity());
                Assert.assertEquals("Value street not modified",
                        "secondStreet",
                        address.getStreet());
                Assert.assertEquals("Value nb not modified",
                        "secondNb",
                        address.getNb());
            }
        }
        Assert.assertTrue("Address not found", found);
    }

    /**
     * Test the suppression of an entity Address.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteAddress() throws DaoException {
        // Initialized the test
        Address address = getAddressExample();
        addressDao.createAddress(address);
        
        // Execute the tested code
        addressDao.deleteAddress(address);
        
        // Verify result
        boolean found = false;
        for (Address currentAddress : addressDao.findAllAddresss()) {
            if (currentAddress.getId().equals(address.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Address not deleted", found);
    }

    /**
     * Test the search of all entities Address.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllAddresss() throws DaoException {
        // Verify number of element before testing
        int before = addressDao.findAllAddresss().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Address address1 = getAddressExample();
        addressDao.createAddress(address1);
                
        Address address2 = getAddressExample();
        addressDao.createAddress(address2);

        // Verify result
        int after = addressDao.findAllAddresss().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Address.
     * @return Returns a new instance of class Address, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Address getAddressExample() throws DaoException {
        // fill attributes with example values
        Address address = new Address();
        address.setCity("myCity");
        address.setStreet("myStreet");
        address.setNb("myNb");

        Person personExample = new Person();
        address.setPerson(personExample);   
        personExample.setAddress(address); 
        personDao.createPerson(personExample);

        return address;
    }
    
    /**
     * Creates a second example of Address with other values.
     * @return Returns a new instance of class Address with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Address getAddressExample2() throws DaoException {
        // fill attributes with example values
        Address address = new Address();
        address.setCity("secondCity");
        address.setStreet("secondStreet");
        address.setNb("secondNb");

        Person personExample = new Person();
        address.setPerson(personExample);   
        personExample.setAddress(address); 
        personDao.createPerson(personExample);

        return address;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
