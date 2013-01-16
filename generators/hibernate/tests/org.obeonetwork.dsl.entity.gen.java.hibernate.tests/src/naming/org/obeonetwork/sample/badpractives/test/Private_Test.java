package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IPrivate_Dao;
import org.obeonetwork.sample.badpractives.Private_;


// End of user code

/**
 * Test class for private.
 */
public class Private_Test extends TestCase {
	
	/**
	 * The DAO for class private.
	 */
	private IPrivate_Dao private_Dao;
	
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
		private_Dao = SampleDaoFactory.getBadPractivesPrivate_Dao();
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
	 * Tests the creation of the entity private.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateprivate_() throws DaoException {
	    // fill attributes with example values
	    Private_ private_ = getPrivate_Example();
	    
	    // Execute the tested code
	    private_Dao.createprivate_(private_);
	
	    // Verify result
	    boolean found = false;
	    for (Private_ currentprivate_ : private_Dao.findAllprivate_s()) {
	        if (currentprivate_.equals(private_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("private not created", found);
	}
	
	/**
	 * Test the modification of an entity private.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateprivate_() throws DaoException {
	    // Initialized the test
	    Private_ private_ = getPrivate_Example();
	    private_Dao.createprivate_(private_);
	
	    // Execute the tested code
	    private_Dao.updateprivate_(private_);
	
	    // Verify result
	    boolean found = false;
	    for (Private_ currentprivate_ : private_Dao.findAllprivate_s()) {
	        if (currentprivate_.equals(private_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("private_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity private.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteprivate_() throws DaoException {
	    // Initialized the test
	    Private_ private_ = getPrivate_Example();
	    private_Dao.createprivate_(private_);
	    
	    // Execute the tested code
	    private_Dao.deleteprivate_(private_);
	    
	    // Verify result
	    boolean found = false;
	    for (Private_ currentprivate_ : private_Dao.findAllprivate_s()) {
	        if (currentprivate_.getId().equals(private_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("private_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities private.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllprivate_s() throws DaoException {
	    // Verify number of element before testing
	    int before = private_Dao.findAllprivate_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Private_ private_1 = getPrivate_Example();
	    private_Dao.createprivate_(private_1);
	            
	    Private_ private_2 = getPrivate_Example();
	    private_Dao.createprivate_(private_2);
	
	    // Verify result
	    int after = private_Dao.findAllprivate_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of private.
	 * @return Returns a new instance of class private, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Private_ getPrivate_Example() throws DaoException {
	    // fill attributes with example values
	    Private_ private_ = new Private_();
	    
	    
	    return private_;
	}
	
	/**
	 * Creates a second example of private with other values.
	 * @return Returns a new instance of class private with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Private_ getPrivate_Example2() throws DaoException {
	    // fill attributes with example values
	    Private_ private_ = new Private_();
		
		
	    return private_;
	}
    
    // Start of user code of specific tests
    // End of user code

}
