package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IBadNameDao;
import org.obeonetwork.sample.badpractives.BadName;


// End of user code

/**
 * Test class for Bad name.
 */
public class BadNameTest extends TestCase {
	
	/**
	 * The DAO for class Bad name.
	 */
	private IBadNameDao badNameDao;
	
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
		badNameDao = SampleDaoFactory.getBadPractivesBadNameDao();
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
	 * Tests the creation of the entity Bad name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateBadName() throws DaoException {
	    // fill attributes with example values
	    BadName badName = getBadNameExample();
	    
	    // Execute the tested code
	    badNameDao.createBadName(badName);
	
	    // Verify result
	    boolean found = false;
	    for (BadName currentBadName : badNameDao.findAllBadNames()) {
	        if (currentBadName.equals(badName)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Bad name not created", found);
	}
	
	/**
	 * Test the modification of an entity Bad name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateBadName() throws DaoException {
	    // Initialized the test
	    BadName badName = getBadNameExample();
	    badNameDao.createBadName(badName);
	
	    // Execute the tested code
	    badNameDao.updateBadName(badName);
	
	    // Verify result
	    boolean found = false;
	    for (BadName currentBadName : badNameDao.findAllBadNames()) {
	        if (currentBadName.equals(badName)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("BadName not found", found);
	}
	
	/**
	 * Test the suppression of an entity Bad name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteBadName() throws DaoException {
	    // Initialized the test
	    BadName badName = getBadNameExample();
	    badNameDao.createBadName(badName);
	    
	    // Execute the tested code
	    badNameDao.deleteBadName(badName);
	    
	    // Verify result
	    boolean found = false;
	    for (BadName currentBadName : badNameDao.findAllBadNames()) {
	        if (currentBadName.getId().equals(badName.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("BadName not deleted", found);
	}
	
	/**
	 * Test the search of all entities Bad name.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllBadNames() throws DaoException {
	    // Verify number of element before testing
	    int before = badNameDao.findAllBadNames().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    BadName badName1 = getBadNameExample();
	    badNameDao.createBadName(badName1);
	            
	    BadName badName2 = getBadNameExample();
	    badNameDao.createBadName(badName2);
	
	    // Verify result
	    int after = badNameDao.findAllBadNames().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Bad name.
	 * @return Returns a new instance of class Bad name, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected BadName getBadNameExample() throws DaoException {
	    // fill attributes with example values
	    BadName badName = new BadName();
	    
	    
	    return badName;
	}
	
	/**
	 * Creates a second example of Bad name with other values.
	 * @return Returns a new instance of class Bad name with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected BadName getBadNameExample2() throws DaoException {
	    // fill attributes with example values
	    BadName badName = new BadName();
		
		
	    return badName;
	}
    
    // Start of user code of specific tests
    // End of user code

}
