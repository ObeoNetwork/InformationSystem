package org.obeonetwork.sample.badpractives.package_.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.package_.IReturn_Dao;
import org.obeonetwork.sample.badpractives.package_.Return_;


// End of user code

/**
 * Test class for return.
 */
public class Return_Test extends TestCase {
	
	/**
	 * The DAO for class return.
	 */
	private IReturn_Dao return_Dao;
	
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
		return_Dao = SampleDaoFactory.getBadPractivesPackage_Return_Dao();
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
	 * Tests the creation of the entity return.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreatereturn_() throws DaoException {
	    // fill attributes with example values
	    Return_ return_ = getReturn_Example();
	    
	    // Execute the tested code
	    return_Dao.createreturn_(return_);
	
	    // Verify result
	    boolean found = false;
	    for (Return_ currentreturn_ : return_Dao.findAllreturn_s()) {
	        if (currentreturn_.equals(return_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("return not created", found);
	}
	
	/**
	 * Test the modification of an entity return.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdatereturn_() throws DaoException {
	    // Initialized the test
	    Return_ return_ = getReturn_Example();
	    return_Dao.createreturn_(return_);
	
	    // Execute the tested code
	    return_Dao.updatereturn_(return_);
	
	    // Verify result
	    boolean found = false;
	    for (Return_ currentreturn_ : return_Dao.findAllreturn_s()) {
	        if (currentreturn_.equals(return_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("return_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity return.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeletereturn_() throws DaoException {
	    // Initialized the test
	    Return_ return_ = getReturn_Example();
	    return_Dao.createreturn_(return_);
	    
	    // Execute the tested code
	    return_Dao.deletereturn_(return_);
	    
	    // Verify result
	    boolean found = false;
	    for (Return_ currentreturn_ : return_Dao.findAllreturn_s()) {
	        if (currentreturn_.getId().equals(return_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("return_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities return.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllreturn_s() throws DaoException {
	    // Verify number of element before testing
	    int before = return_Dao.findAllreturn_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Return_ return_1 = getReturn_Example();
	    return_Dao.createreturn_(return_1);
	            
	    Return_ return_2 = getReturn_Example();
	    return_Dao.createreturn_(return_2);
	
	    // Verify result
	    int after = return_Dao.findAllreturn_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of return.
	 * @return Returns a new instance of class return, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Return_ getReturn_Example() throws DaoException {
	    // fill attributes with example values
	    Return_ return_ = new Return_();
	    
	    
	    return return_;
	}
	
	/**
	 * Creates a second example of return with other values.
	 * @return Returns a new instance of class return with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Return_ getReturn_Example2() throws DaoException {
	    // fill attributes with example values
	    Return_ return_ = new Return_();
		
		
	    return return_;
	}
    
    // Start of user code of specific tests
    // End of user code

}
