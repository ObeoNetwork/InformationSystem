package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.ISub1Dao;
import org.obeonetwork.sample.inheritance.Sub1;


// End of user code for import

/**
 * Test class for Sub1.
 */
public class Sub1Test extends TestCase {

	/**
	 * The DAO for class Sub1.
	 */
	private ISub1Dao sub1Dao;

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
		sub1Dao = SampleDaoFactory.getSub1Dao();
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
     * Tests the creation of the entity Sub1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateSub1() throws DaoException {
        // fill attributes with example values
        Sub1 sub1 = getSub1Example();
        
        // Execute the tested code
        sub1Dao.createSub1(sub1);

        // Verify result
        boolean found = false;
        for (Sub1 currentSub1 : sub1Dao.findAllSub1s()) {
            if (currentSub1.equals(sub1)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub1 not created", found);
    }

    /**
     * Test the modification of an entity Sub1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateSub1() throws DaoException {
        // Initialized the test
        Sub1 sub1 = getSub1Example();
        sub1Dao.createSub1(sub1);

        // Execute the tested code
        sub1Dao.updateSub1(sub1);

        // Verify result
        boolean found = false;
        for (Sub1 currentSub1 : sub1Dao.findAllSub1s()) {
            if (currentSub1.equals(sub1)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub1 not found", found);
    }

    /**
     * Test the suppression of an entity Sub1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteSub1() throws DaoException {
        // Initialized the test
        Sub1 sub1 = getSub1Example();
        sub1Dao.createSub1(sub1);
        
        // Execute the tested code
        sub1Dao.deleteSub1(sub1);
        
        // Verify result
        boolean found = false;
        for (Sub1 currentSub1 : sub1Dao.findAllSub1s()) {
            if (currentSub1.getId().equals(sub1.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Sub1 not deleted", found);
    }

    /**
     * Test the search of all entities Sub1.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllSub1s() throws DaoException {
        // Verify number of element before testing
        int before = sub1Dao.findAllSub1s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Sub1 sub11 = getSub1Example();
        sub1Dao.createSub1(sub11);
                
        Sub1 sub12 = getSub1Example();
        sub1Dao.createSub1(sub12);

        // Verify result
        int after = sub1Dao.findAllSub1s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Sub1.
     * @return Returns a new instance of class Sub1, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub1 getSub1Example() throws DaoException {
        // fill attributes with example values
        Sub1 sub1 = new Sub1();


        return sub1;
    }
    
    /**
     * Creates a second example of Sub1 with other values.
     * @return Returns a new instance of class Sub1 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub1 getSub1Example2() throws DaoException {
        // fill attributes with example values
        Sub1 sub1 = new Sub1();


        return sub1;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
