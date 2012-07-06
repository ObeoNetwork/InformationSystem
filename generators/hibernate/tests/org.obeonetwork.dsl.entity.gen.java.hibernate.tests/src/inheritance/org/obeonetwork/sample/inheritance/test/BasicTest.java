package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.IBasicDao;
import org.obeonetwork.sample.inheritance.Basic;


// End of user code for import

/**
 * Test class for Basic.
 */
public class BasicTest extends TestCase {

	/**
	 * The DAO for class Basic.
	 */
	private IBasicDao basicDao;

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
		basicDao = SampleDaoFactory.getBasicDao();
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
     * Tests the creation of the entity Basic.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateBasic() throws DaoException {
        // fill attributes with example values
        Basic basic = getBasicExample();
        
        // Execute the tested code
        basicDao.createBasic(basic);

        // Verify result
        boolean found = false;
        for (Basic currentBasic : basicDao.findAllBasics()) {
            if (currentBasic.equals(basic)) {
                found = true;
            }
        }
        Assert.assertTrue("Basic not created", found);
    }

    /**
     * Test the modification of an entity Basic.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateBasic() throws DaoException {
        // Initialized the test
        Basic basic = getBasicExample();
        basicDao.createBasic(basic);

        // Execute the tested code
        basic.setMyProp1("secondMyProp1");
        basic.setMyProp2(new Float(1495168739.0));
        basicDao.updateBasic(basic);

        // Verify result
        boolean found = false;
        for (Basic currentBasic : basicDao.findAllBasics()) {
            if (currentBasic.equals(basic)) {
                found = true;
                Assert.assertEquals("Value myProp1 not modified",
                        "secondMyProp1",
                        basic.getMyProp1());
                Assert.assertEquals("Value myProp2 not modified",
                        new Float(1495168739.0),
                        basic.getMyProp2());
            }
        }
        Assert.assertTrue("Basic not found", found);
    }

    /**
     * Test the suppression of an entity Basic.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteBasic() throws DaoException {
        // Initialized the test
        Basic basic = getBasicExample();
        basicDao.createBasic(basic);
        
        // Execute the tested code
        basicDao.deleteBasic(basic);
        
        // Verify result
        boolean found = false;
        for (Basic currentBasic : basicDao.findAllBasics()) {
            if (currentBasic.getId().equals(basic.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Basic not deleted", found);
    }

    /**
     * Test the search of all entities Basic.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllBasics() throws DaoException {
        // Verify number of element before testing
        int before = basicDao.findAllBasics().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Basic basic1 = getBasicExample();
        basicDao.createBasic(basic1);
                
        Basic basic2 = getBasicExample();
        basicDao.createBasic(basic2);

        // Verify result
        int after = basicDao.findAllBasics().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Basic.
     * @return Returns a new instance of class Basic, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Basic getBasicExample() throws DaoException {
        // fill attributes with example values
        Basic basic = new Basic();
        basic.setMyProp1("myMyProp1");
        basic.setMyProp2(new Float(1495168739.1));
        basic.setRootProp(new Double(-166963355.1));


        return basic;
    }
    
    /**
     * Creates a second example of Basic with other values.
     * @return Returns a new instance of class Basic with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Basic getBasicExample2() throws DaoException {
        // fill attributes with example values
        Basic basic = new Basic();
        basic.setMyProp1("secondMyProp1");
        basic.setMyProp2(new Float(1495168739.0));
        basic.setRootProp(new Double(-166963355.0));


        return basic;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
