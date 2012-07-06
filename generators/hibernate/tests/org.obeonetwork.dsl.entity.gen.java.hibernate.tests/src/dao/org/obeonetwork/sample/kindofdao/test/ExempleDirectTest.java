package org.obeonetwork.sample.kindofdao.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.kindofdao.IExempleDirectDao;
import org.obeonetwork.sample.kindofdao.ExempleDirect;


// End of user code for import

/**
 * Test class for ExempleDirect.
 */
public class ExempleDirectTest extends TestCase {

	/**
	 * The DAO for class ExempleDirect.
	 */
	private IExempleDirectDao exempleDirectDao;

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
		exempleDirectDao = SampleDaoFactory.getExempleDirectDao();
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
     * Tests the creation of the entity ExempleDirect.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateExempleDirect() throws DaoException {
        // fill attributes with example values
        ExempleDirect exempleDirect = getExempleDirectExample();
        
        // Execute the tested code
        exempleDirectDao.createExempleDirect(exempleDirect);

        // Verify result
        boolean found = false;
        for (ExempleDirect currentExempleDirect : exempleDirectDao.findAllExempleDirects()) {
            if (currentExempleDirect.equals(exempleDirect)) {
                found = true;
            }
        }
        Assert.assertTrue("ExempleDirect not created", found);
    }

    /**
     * Test the modification of an entity ExempleDirect.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateExempleDirect() throws DaoException {
        // Initialized the test
        ExempleDirect exempleDirect = getExempleDirectExample();
        exempleDirectDao.createExempleDirect(exempleDirect);

        // Execute the tested code
        exempleDirect.setMyAttribute("secondMyAttribute");
        exempleDirect.setMyId("secondMyId");
        exempleDirectDao.updateExempleDirect(exempleDirect);

        // Verify result
        boolean found = false;
        for (ExempleDirect currentExempleDirect : exempleDirectDao.findAllExempleDirects()) {
            if (currentExempleDirect.equals(exempleDirect)) {
                found = true;
                Assert.assertEquals("Value myAttribute not modified",
                        "secondMyAttribute",
                        exempleDirect.getMyAttribute());
                Assert.assertEquals("Value myId not modified",
                        "secondMyId",
                        exempleDirect.getMyId());
            }
        }
        Assert.assertTrue("ExempleDirect not found", found);
    }

    /**
     * Test the suppression of an entity ExempleDirect.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteExempleDirect() throws DaoException {
        // Initialized the test
        ExempleDirect exempleDirect = getExempleDirectExample();
        exempleDirectDao.createExempleDirect(exempleDirect);
        
        // Execute the tested code
        exempleDirectDao.deleteExempleDirect(exempleDirect);
        
        // Verify result
        boolean found = false;
        for (ExempleDirect currentExempleDirect : exempleDirectDao.findAllExempleDirects()) {
            if (currentExempleDirect.getId().equals(exempleDirect.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ExempleDirect not deleted", found);
    }

    /**
     * Test the search of all entities ExempleDirect.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllExempleDirects() throws DaoException {
        // Verify number of element before testing
        int before = exempleDirectDao.findAllExempleDirects().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ExempleDirect exempleDirect1 = getExempleDirectExample();
        exempleDirectDao.createExempleDirect(exempleDirect1);
                
        ExempleDirect exempleDirect2 = getExempleDirectExample();
        exempleDirectDao.createExempleDirect(exempleDirect2);

        // Verify result
        int after = exempleDirectDao.findAllExempleDirects().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of ExempleDirect.
     * @return Returns a new instance of class ExempleDirect, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ExempleDirect getExempleDirectExample() throws DaoException {
        // fill attributes with example values
        ExempleDirect exempleDirect = new ExempleDirect();
        exempleDirect.setMyAttribute("myMyAttribute");
        exempleDirect.setMyId("myMyId");


        return exempleDirect;
    }
    
    /**
     * Creates a second example of ExempleDirect with other values.
     * @return Returns a new instance of class ExempleDirect with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ExempleDirect getExempleDirectExample2() throws DaoException {
        // fill attributes with example values
        ExempleDirect exempleDirect = new ExempleDirect();
        exempleDirect.setMyAttribute("secondMyAttribute");
        exempleDirect.setMyId("secondMyId");


        return exempleDirect;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
