package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IInterface_Dao;
import org.obeonetwork.sample.badpractives.Interface_;


// End of user code

/**
 * Test class for Interface.
 */
public class Interface_Test extends TestCase {
	
	/**
	 * The DAO for class Interface.
	 */
	private IInterface_Dao interface_Dao;
	
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
		interface_Dao = SampleDaoFactory.getBadPractivesInterface_Dao();
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
	 * Tests the creation of the entity Interface.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateInterface_() throws DaoException {
	    // fill attributes with example values
	    Interface_ interface_ = getInterface_Example();
	    
	    // Execute the tested code
	    interface_Dao.createInterface_(interface_);
	
	    // Verify result
	    boolean found = false;
	    for (Interface_ currentInterface_ : interface_Dao.findAllInterface_s()) {
	        if (currentInterface_.equals(interface_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Interface not created", found);
	}
	
	/**
	 * Test the modification of an entity Interface.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateInterface_() throws DaoException {
	    // Initialized the test
	    Interface_ interface_ = getInterface_Example();
	    interface_Dao.createInterface_(interface_);
	
	    // Execute the tested code
	    interface_Dao.updateInterface_(interface_);
	
	    // Verify result
	    boolean found = false;
	    for (Interface_ currentInterface_ : interface_Dao.findAllInterface_s()) {
	        if (currentInterface_.equals(interface_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Interface_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity Interface.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteInterface_() throws DaoException {
	    // Initialized the test
	    Interface_ interface_ = getInterface_Example();
	    interface_Dao.createInterface_(interface_);
	    
	    // Execute the tested code
	    interface_Dao.deleteInterface_(interface_);
	    
	    // Verify result
	    boolean found = false;
	    for (Interface_ currentInterface_ : interface_Dao.findAllInterface_s()) {
	        if (currentInterface_.getId().equals(interface_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Interface_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities Interface.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllInterface_s() throws DaoException {
	    // Verify number of element before testing
	    int before = interface_Dao.findAllInterface_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Interface_ interface_1 = getInterface_Example();
	    interface_Dao.createInterface_(interface_1);
	            
	    Interface_ interface_2 = getInterface_Example();
	    interface_Dao.createInterface_(interface_2);
	
	    // Verify result
	    int after = interface_Dao.findAllInterface_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Interface.
	 * @return Returns a new instance of class Interface, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Interface_ getInterface_Example() throws DaoException {
	    // fill attributes with example values
	    Interface_ interface_ = new Interface_();
	    
	    
	    return interface_;
	}
	
	/**
	 * Creates a second example of Interface with other values.
	 * @return Returns a new instance of class Interface with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Interface_ getInterface_Example2() throws DaoException {
	    // fill attributes with example values
	    Interface_ interface_ = new Interface_();
		
		
	    return interface_;
	}
    
    // Start of user code of specific tests
    // End of user code

}
