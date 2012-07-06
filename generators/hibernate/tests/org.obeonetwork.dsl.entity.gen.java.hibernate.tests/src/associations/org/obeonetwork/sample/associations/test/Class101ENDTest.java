package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass101ENDDao;
import org.obeonetwork.sample.associations.Class101END;


// End of user code for import

/**
 * Test class for Class_1_01_END.
 */
public class Class101ENDTest extends TestCase {

	/**
	 * The DAO for class Class_1_01_END.
	 */
	private IClass101ENDDao class101ENDDao;

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
		class101ENDDao = SampleDaoFactory.getClass101ENDDao();
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
     * Tests the creation of the entity Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101END() throws DaoException {
        // fill attributes with example values
        Class101END class101END = getClass101ENDExample();
        
        // Execute the tested code
        class101ENDDao.createClass101END(class101END);

        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : class101ENDDao.findAllClass101ENDs()) {
            if (currentClass101END.equals(class101END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_END not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101END() throws DaoException {
        // Initialized the test
        Class101END class101END = getClass101ENDExample();
        class101ENDDao.createClass101END(class101END);

        // Execute the tested code
        class101END.setFakeAttr(new Integer(725185254));
        class101ENDDao.updateClass101END(class101END);

        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : class101ENDDao.findAllClass101ENDs()) {
            if (currentClass101END.equals(class101END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class101END.getFakeAttr());
            }
        }
        Assert.assertTrue("Class101END not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101END() throws DaoException {
        // Initialized the test
        Class101END class101END = getClass101ENDExample();
        class101ENDDao.createClass101END(class101END);
        
        // Execute the tested code
        class101ENDDao.deleteClass101END(class101END);
        
        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : class101ENDDao.findAllClass101ENDs()) {
            if (currentClass101END.getId().equals(class101END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101END not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101ENDs() throws DaoException {
        // Verify number of element before testing
        int before = class101ENDDao.findAllClass101ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101END class101END1 = getClass101ENDExample();
        class101ENDDao.createClass101END(class101END1);
                
        Class101END class101END2 = getClass101ENDExample();
        class101ENDDao.createClass101END(class101END2);

        // Verify result
        int after = class101ENDDao.findAllClass101ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_1_01_END.
     * @return Returns a new instance of class Class_1_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101END getClass101ENDExample() throws DaoException {
        // fill attributes with example values
        Class101END class101END = new Class101END();
        class101END.setFakeAttr(new Integer(725185254 + 1));


        return class101END;
    }
    
    /**
     * Creates a second example of Class_1_01_END with other values.
     * @return Returns a new instance of class Class_1_01_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101END getClass101ENDExample2() throws DaoException {
        // fill attributes with example values
        Class101END class101END = new Class101END();
        class101END.setFakeAttr(new Integer(725185254));


        return class101END;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
