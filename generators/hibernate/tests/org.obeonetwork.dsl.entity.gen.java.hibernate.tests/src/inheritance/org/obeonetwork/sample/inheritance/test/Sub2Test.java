package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.ISub2Dao;
import org.obeonetwork.sample.inheritance.Sub2;


// End of user code for import

/**
 * Test class for Sub2.
 */
public class Sub2Test extends TestCase {

	/**
	 * The DAO for class Sub2.
	 */
	private ISub2Dao sub2Dao;

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
		sub2Dao = SampleDaoFactory.getSub2Dao();
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
     * Tests the creation of the entity Sub2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateSub2() throws DaoException {
        // fill attributes with example values
        Sub2 sub2 = getSub2Example();
        
        // Execute the tested code
        sub2Dao.createSub2(sub2);

        // Verify result
        boolean found = false;
        for (Sub2 currentSub2 : sub2Dao.findAllSub2s()) {
            if (currentSub2.equals(sub2)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub2 not created", found);
    }

    /**
     * Test the modification of an entity Sub2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateSub2() throws DaoException {
        // Initialized the test
        Sub2 sub2 = getSub2Example();
        sub2Dao.createSub2(sub2);

        // Execute the tested code
        sub2Dao.updateSub2(sub2);

        // Verify result
        boolean found = false;
        for (Sub2 currentSub2 : sub2Dao.findAllSub2s()) {
            if (currentSub2.equals(sub2)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub2 not found", found);
    }

    /**
     * Test the suppression of an entity Sub2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteSub2() throws DaoException {
        // Initialized the test
        Sub2 sub2 = getSub2Example();
        sub2Dao.createSub2(sub2);
        
        // Execute the tested code
        sub2Dao.deleteSub2(sub2);
        
        // Verify result
        boolean found = false;
        for (Sub2 currentSub2 : sub2Dao.findAllSub2s()) {
            if (currentSub2.getId().equals(sub2.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Sub2 not deleted", found);
    }

    /**
     * Test the search of all entities Sub2.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllSub2s() throws DaoException {
        // Verify number of element before testing
        int before = sub2Dao.findAllSub2s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Sub2 sub21 = getSub2Example();
        sub2Dao.createSub2(sub21);
                
        Sub2 sub22 = getSub2Example();
        sub2Dao.createSub2(sub22);

        // Verify result
        int after = sub2Dao.findAllSub2s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Sub2.
     * @return Returns a new instance of class Sub2, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub2 getSub2Example() throws DaoException {
        // fill attributes with example values
        Sub2 sub2 = new Sub2();


        return sub2;
    }
    
    /**
     * Creates a second example of Sub2 with other values.
     * @return Returns a new instance of class Sub2 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub2 getSub2Example2() throws DaoException {
        // fill attributes with example values
        Sub2 sub2 = new Sub2();


        return sub2;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
