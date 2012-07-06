package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IProtected_Dao;
import org.obeonetwork.sample.badpractives.Protected_;


// End of user code for import

/**
 * Test class for protected.
 */
public class Protected_Test extends TestCase {

	/**
	 * The DAO for class protected.
	 */
	private IProtected_Dao protected_Dao;

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
		protected_Dao = SampleDaoFactory.getProtected_Dao();
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
     * Tests the creation of the entity protected.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateprotected_() throws DaoException {
        // fill attributes with example values
        Protected_ protected_ = getProtected_Example();
        
        // Execute the tested code
        protected_Dao.createprotected_(protected_);

        // Verify result
        boolean found = false;
        for (Protected_ currentprotected_ : protected_Dao.findAllprotected_s()) {
            if (currentprotected_.equals(protected_)) {
                found = true;
            }
        }
        Assert.assertTrue("protected not created", found);
    }

    /**
     * Test the modification of an entity protected.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateprotected_() throws DaoException {
        // Initialized the test
        Protected_ protected_ = getProtected_Example();
        protected_Dao.createprotected_(protected_);

        // Execute the tested code
        protected_Dao.updateprotected_(protected_);

        // Verify result
        boolean found = false;
        for (Protected_ currentprotected_ : protected_Dao.findAllprotected_s()) {
            if (currentprotected_.equals(protected_)) {
                found = true;
            }
        }
        Assert.assertTrue("protected_ not found", found);
    }

    /**
     * Test the suppression of an entity protected.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteprotected_() throws DaoException {
        // Initialized the test
        Protected_ protected_ = getProtected_Example();
        protected_Dao.createprotected_(protected_);
        
        // Execute the tested code
        protected_Dao.deleteprotected_(protected_);
        
        // Verify result
        boolean found = false;
        for (Protected_ currentprotected_ : protected_Dao.findAllprotected_s()) {
            if (currentprotected_.getId().equals(protected_.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("protected_ not deleted", found);
    }

    /**
     * Test the search of all entities protected.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllprotected_s() throws DaoException {
        // Verify number of element before testing
        int before = protected_Dao.findAllprotected_s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Protected_ protected_1 = getProtected_Example();
        protected_Dao.createprotected_(protected_1);
                
        Protected_ protected_2 = getProtected_Example();
        protected_Dao.createprotected_(protected_2);

        // Verify result
        int after = protected_Dao.findAllprotected_s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of protected.
     * @return Returns a new instance of class protected, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Protected_ getProtected_Example() throws DaoException {
        // fill attributes with example values
        Protected_ protected_ = new Protected_();


        return protected_;
    }
    
    /**
     * Creates a second example of protected with other values.
     * @return Returns a new instance of class protected with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Protected_ getProtected_Example2() throws DaoException {
        // fill attributes with example values
        Protected_ protected_ = new Protected_();


        return protected_;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
