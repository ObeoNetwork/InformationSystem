package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.ITABLEDao;
import org.obeonetwork.sample.badpractives.TABLE;


// End of user code

/**
 * Test class for TABLE.
 */
public class TABLETest extends TestCase {
	
	/**
	 * The DAO for class TABLE.
	 */
	private ITABLEDao tABLEDao;
	
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
		tABLEDao = SampleDaoFactory.getBadPractivesTABLEDao();
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
	 * Tests the creation of the entity TABLE.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateTABLE() throws DaoException {
	    // fill attributes with example values
	    TABLE tABLE = getTABLEExample();
	    
	    // Execute the tested code
	    tABLEDao.createTABLE(tABLE);
	
	    // Verify result
	    boolean found = false;
	    for (TABLE currentTABLE : tABLEDao.findAllTABLEs()) {
	        if (currentTABLE.equals(tABLE)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("TABLE not created", found);
	}
	
	/**
	 * Test the modification of an entity TABLE.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateTABLE() throws DaoException {
	    // Initialized the test
	    TABLE tABLE = getTABLEExample();
	    tABLEDao.createTABLE(tABLE);
	
	    // Execute the tested code
	    tABLE.setCOLUMN(new Integer(1993459542));
	    tABLE.setPRIMARYKEY(new Integer(1284802305));
	    tABLEDao.updateTABLE(tABLE);
	
	    // Verify result
	    boolean found = false;
	    for (TABLE currentTABLE : tABLEDao.findAllTABLEs()) {
	        if (currentTABLE.equals(tABLE)) {
	            found = true;
	            Assert.assertEquals("Value cOLUMN not modified",
	                    new Integer(1993459542),
	                    tABLE.getCOLUMN());
	            Assert.assertEquals("Value pRIMARYKEY not modified",
	                    new Integer(1284802305),
	                    tABLE.getPRIMARYKEY());
	        }
	    }
	    Assert.assertTrue("TABLE not found", found);
	}
	
	/**
	 * Test the suppression of an entity TABLE.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteTABLE() throws DaoException {
	    // Initialized the test
	    TABLE tABLE = getTABLEExample();
	    tABLEDao.createTABLE(tABLE);
	    
	    // Execute the tested code
	    tABLEDao.deleteTABLE(tABLE);
	    
	    // Verify result
	    boolean found = false;
	    for (TABLE currentTABLE : tABLEDao.findAllTABLEs()) {
	        if (currentTABLE.getId().equals(tABLE.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("TABLE not deleted", found);
	}
	
	/**
	 * Test the search of all entities TABLE.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllTABLEs() throws DaoException {
	    // Verify number of element before testing
	    int before = tABLEDao.findAllTABLEs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    TABLE tABLE1 = getTABLEExample();
	    tABLEDao.createTABLE(tABLE1);
	            
	    TABLE tABLE2 = getTABLEExample();
	    tABLEDao.createTABLE(tABLE2);
	
	    // Verify result
	    int after = tABLEDao.findAllTABLEs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of TABLE.
	 * @return Returns a new instance of class TABLE, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected TABLE getTABLEExample() throws DaoException {
	    // fill attributes with example values
	    TABLE tABLE = new TABLE();
	    tABLE.setCOLUMN(new Integer(1993459542 + 1));
	    tABLE.setPRIMARYKEY(new Integer(1284802305 + 1));
	    
	    
	    return tABLE;
	}
	
	/**
	 * Creates a second example of TABLE with other values.
	 * @return Returns a new instance of class TABLE with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected TABLE getTABLEExample2() throws DaoException {
	    // fill attributes with example values
	    TABLE tABLE = new TABLE();
		tABLE.setCOLUMN(new Integer(1993459542));
		tABLE.setPRIMARYKEY(new Integer(1284802305));
		
		
	    return tABLE;
	}
    
    // Start of user code of specific tests
    // End of user code

}
