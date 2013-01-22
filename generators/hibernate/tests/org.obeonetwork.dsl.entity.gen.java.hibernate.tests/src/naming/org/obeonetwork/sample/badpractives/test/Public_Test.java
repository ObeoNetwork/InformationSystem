package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IPublic_Dao;
import org.obeonetwork.sample.badpractives.Public_;


// End of user code

/**
 * Test class for public.
 */
public class Public_Test extends TestCase {
	
	/**
	 * The DAO for class public.
	 */
	private IPublic_Dao public_Dao;
	
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
		public_Dao = SampleDaoFactory.getBadPractivesPublic_Dao();
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
	 * Tests the creation of the entity public.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreatepublic_() throws DaoException {
	    // fill attributes with example values
	    Public_ public_ = getPublic_Example();
	    
	    // Execute the tested code
	    public_Dao.createpublic_(public_);
	
	    // Verify result
	    boolean found = false;
	    for (Public_ currentpublic_ : public_Dao.findAllpublic_s()) {
	        if (currentpublic_.equals(public_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("public not created", found);
	}
	
	/**
	 * Test the modification of an entity public.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdatepublic_() throws DaoException {
	    // Initialized the test
	    Public_ public_ = getPublic_Example();
	    public_Dao.createpublic_(public_);
	
	    // Execute the tested code
	    public_Dao.updatepublic_(public_);
	
	    // Verify result
	    boolean found = false;
	    for (Public_ currentpublic_ : public_Dao.findAllpublic_s()) {
	        if (currentpublic_.equals(public_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("public_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity public.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeletepublic_() throws DaoException {
	    // Initialized the test
	    Public_ public_ = getPublic_Example();
	    public_Dao.createpublic_(public_);
	    
	    // Execute the tested code
	    public_Dao.deletepublic_(public_);
	    
	    // Verify result
	    boolean found = false;
	    for (Public_ currentpublic_ : public_Dao.findAllpublic_s()) {
	        if (currentpublic_.getId().equals(public_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("public_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities public.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllpublic_s() throws DaoException {
	    // Verify number of element before testing
	    int before = public_Dao.findAllpublic_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Public_ public_1 = getPublic_Example();
	    public_Dao.createpublic_(public_1);
	            
	    Public_ public_2 = getPublic_Example();
	    public_Dao.createpublic_(public_2);
	
	    // Verify result
	    int after = public_Dao.findAllpublic_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of public.
	 * @return Returns a new instance of class public, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Public_ getPublic_Example() throws DaoException {
	    // fill attributes with example values
	    Public_ public_ = new Public_();
	    
	    
	    return public_;
	}
	
	/**
	 * Creates a second example of public with other values.
	 * @return Returns a new instance of class public with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Public_ getPublic_Example2() throws DaoException {
	    // fill attributes with example values
	    Public_ public_ = new Public_();
		
		
	    return public_;
	}
    
    // Start of user code of specific tests
    // End of user code

}
