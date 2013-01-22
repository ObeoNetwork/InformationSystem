package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.INull_Dao;
import org.obeonetwork.sample.badpractives.Null_;


// End of user code

/**
 * Test class for null.
 */
public class Null_Test extends TestCase {
	
	/**
	 * The DAO for class null.
	 */
	private INull_Dao null_Dao;
	
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
		null_Dao = SampleDaoFactory.getBadPractivesNull_Dao();
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
	 * Tests the creation of the entity null.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreatenull_() throws DaoException {
	    // fill attributes with example values
	    Null_ null_ = getNull_Example();
	    
	    // Execute the tested code
	    null_Dao.createnull_(null_);
	
	    // Verify result
	    boolean found = false;
	    for (Null_ currentnull_ : null_Dao.findAllnull_s()) {
	        if (currentnull_.equals(null_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("null not created", found);
	}
	
	/**
	 * Test the modification of an entity null.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdatenull_() throws DaoException {
	    // Initialized the test
	    Null_ null_ = getNull_Example();
	    null_Dao.createnull_(null_);
	
	    // Execute the tested code
	    null_Dao.updatenull_(null_);
	
	    // Verify result
	    boolean found = false;
	    for (Null_ currentnull_ : null_Dao.findAllnull_s()) {
	        if (currentnull_.equals(null_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("null_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity null.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeletenull_() throws DaoException {
	    // Initialized the test
	    Null_ null_ = getNull_Example();
	    null_Dao.createnull_(null_);
	    
	    // Execute the tested code
	    null_Dao.deletenull_(null_);
	    
	    // Verify result
	    boolean found = false;
	    for (Null_ currentnull_ : null_Dao.findAllnull_s()) {
	        if (currentnull_.getId().equals(null_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("null_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities null.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllnull_s() throws DaoException {
	    // Verify number of element before testing
	    int before = null_Dao.findAllnull_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Null_ null_1 = getNull_Example();
	    null_Dao.createnull_(null_1);
	            
	    Null_ null_2 = getNull_Example();
	    null_Dao.createnull_(null_2);
	
	    // Verify result
	    int after = null_Dao.findAllnull_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of null.
	 * @return Returns a new instance of class null, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Null_ getNull_Example() throws DaoException {
	    // fill attributes with example values
	    Null_ null_ = new Null_();
	    
	    
	    return null_;
	}
	
	/**
	 * Creates a second example of null with other values.
	 * @return Returns a new instance of class null with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Null_ getNull_Example2() throws DaoException {
	    // fill attributes with example values
	    Null_ null_ = new Null_();
		
		
	    return null_;
	}
    
    // Start of user code of specific tests
    // End of user code

}
