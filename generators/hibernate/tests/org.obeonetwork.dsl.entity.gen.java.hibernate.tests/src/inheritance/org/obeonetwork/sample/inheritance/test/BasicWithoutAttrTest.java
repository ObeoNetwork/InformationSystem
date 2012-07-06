package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao;
import org.obeonetwork.sample.inheritance.BasicWithoutAttr;


// End of user code for import

/**
 * Test class for BasicWithoutAttr.
 */
public class BasicWithoutAttrTest extends TestCase {

	/**
	 * The DAO for class BasicWithoutAttr.
	 */
	private IBasicWithoutAttrDao basicWithoutAttrDao;

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
		basicWithoutAttrDao = SampleDaoFactory.getBasicWithoutAttrDao();
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
     * Tests the creation of the entity BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateBasicWithoutAttr() throws DaoException {
        // fill attributes with example values
        BasicWithoutAttr basicWithoutAttr = getBasicWithoutAttrExample();
        
        // Execute the tested code
        basicWithoutAttrDao.createBasicWithoutAttr(basicWithoutAttr);

        // Verify result
        boolean found = false;
        for (BasicWithoutAttr currentBasicWithoutAttr : basicWithoutAttrDao.findAllBasicWithoutAttrs()) {
            if (currentBasicWithoutAttr.equals(basicWithoutAttr)) {
                found = true;
            }
        }
        Assert.assertTrue("BasicWithoutAttr not created", found);
    }

    /**
     * Test the modification of an entity BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateBasicWithoutAttr() throws DaoException {
        // Initialized the test
        BasicWithoutAttr basicWithoutAttr = getBasicWithoutAttrExample();
        basicWithoutAttrDao.createBasicWithoutAttr(basicWithoutAttr);

        // Execute the tested code
        basicWithoutAttrDao.updateBasicWithoutAttr(basicWithoutAttr);

        // Verify result
        boolean found = false;
        for (BasicWithoutAttr currentBasicWithoutAttr : basicWithoutAttrDao.findAllBasicWithoutAttrs()) {
            if (currentBasicWithoutAttr.equals(basicWithoutAttr)) {
                found = true;
            }
        }
        Assert.assertTrue("BasicWithoutAttr not found", found);
    }

    /**
     * Test the suppression of an entity BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteBasicWithoutAttr() throws DaoException {
        // Initialized the test
        BasicWithoutAttr basicWithoutAttr = getBasicWithoutAttrExample();
        basicWithoutAttrDao.createBasicWithoutAttr(basicWithoutAttr);
        
        // Execute the tested code
        basicWithoutAttrDao.deleteBasicWithoutAttr(basicWithoutAttr);
        
        // Verify result
        boolean found = false;
        for (BasicWithoutAttr currentBasicWithoutAttr : basicWithoutAttrDao.findAllBasicWithoutAttrs()) {
            if (currentBasicWithoutAttr.getId().equals(basicWithoutAttr.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("BasicWithoutAttr not deleted", found);
    }

    /**
     * Test the search of all entities BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllBasicWithoutAttrs() throws DaoException {
        // Verify number of element before testing
        int before = basicWithoutAttrDao.findAllBasicWithoutAttrs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        BasicWithoutAttr basicWithoutAttr1 = getBasicWithoutAttrExample();
        basicWithoutAttrDao.createBasicWithoutAttr(basicWithoutAttr1);
                
        BasicWithoutAttr basicWithoutAttr2 = getBasicWithoutAttrExample();
        basicWithoutAttrDao.createBasicWithoutAttr(basicWithoutAttr2);

        // Verify result
        int after = basicWithoutAttrDao.findAllBasicWithoutAttrs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of BasicWithoutAttr.
     * @return Returns a new instance of class BasicWithoutAttr, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected BasicWithoutAttr getBasicWithoutAttrExample() throws DaoException {
        // fill attributes with example values
        BasicWithoutAttr basicWithoutAttr = new BasicWithoutAttr();
        basicWithoutAttr.setRootProp(new Double(-166963355.1));


        return basicWithoutAttr;
    }
    
    /**
     * Creates a second example of BasicWithoutAttr with other values.
     * @return Returns a new instance of class BasicWithoutAttr with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected BasicWithoutAttr getBasicWithoutAttrExample2() throws DaoException {
        // fill attributes with example values
        BasicWithoutAttr basicWithoutAttr = new BasicWithoutAttr();
        basicWithoutAttr.setRootProp(new Double(-166963355.0));


        return basicWithoutAttr;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
