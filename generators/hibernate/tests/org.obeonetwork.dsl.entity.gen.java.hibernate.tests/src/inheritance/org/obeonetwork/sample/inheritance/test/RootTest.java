package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.IRootDao;
import org.obeonetwork.sample.inheritance.Root;


// End of user code for import

/**
 * Test class for Root.
 */
public class RootTest extends TestCase {

	/**
	 * The DAO for class Root.
	 */
	private IRootDao rootDao;

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
		rootDao = SampleDaoFactory.getRootDao();
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
     * Tests the creation of the entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateRoot() throws DaoException {
        // fill attributes with example values
        Root root = getRootExample();
        
        // Execute the tested code
        rootDao.createRoot(root);

        // Verify result
        boolean found = false;
        for (Root currentRoot : rootDao.findAllRoots()) {
            if (currentRoot.equals(root)) {
                found = true;
            }
        }
        Assert.assertTrue("Root not created", found);
    }

    /**
     * Test the modification of an entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateRoot() throws DaoException {
        // Initialized the test
        Root root = getRootExample();
        rootDao.createRoot(root);

        // Execute the tested code
        root.setRootProp(new Double(-166963355.0));
        rootDao.updateRoot(root);

        // Verify result
        boolean found = false;
        for (Root currentRoot : rootDao.findAllRoots()) {
            if (currentRoot.equals(root)) {
                found = true;
                Assert.assertEquals("Value rootProp not modified",
                        new Double(-166963355.0),
                        root.getRootProp());
            }
        }
        Assert.assertTrue("Root not found", found);
    }

    /**
     * Test the suppression of an entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteRoot() throws DaoException {
        // Initialized the test
        Root root = getRootExample();
        rootDao.createRoot(root);
        
        // Execute the tested code
        rootDao.deleteRoot(root);
        
        // Verify result
        boolean found = false;
        for (Root currentRoot : rootDao.findAllRoots()) {
            if (currentRoot.getId().equals(root.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Root not deleted", found);
    }

    /**
     * Test the search of all entities Root.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllRoots() throws DaoException {
        // Verify number of element before testing
        int before = rootDao.findAllRoots().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Root root1 = getRootExample();
        rootDao.createRoot(root1);
                
        Root root2 = getRootExample();
        rootDao.createRoot(root2);

        // Verify result
        int after = rootDao.findAllRoots().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Root.
     * @return Returns a new instance of class Root, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Root getRootExample() throws DaoException {
        // fill attributes with example values
        Root root = new Root();
        root.setRootProp(new Double(-166963355.1));


        return root;
    }
    
    /**
     * Creates a second example of Root with other values.
     * @return Returns a new instance of class Root with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Root getRootExample2() throws DaoException {
        // fill attributes with example values
        Root root = new Root();
        root.setRootProp(new Double(-166963355.0));


        return root;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
