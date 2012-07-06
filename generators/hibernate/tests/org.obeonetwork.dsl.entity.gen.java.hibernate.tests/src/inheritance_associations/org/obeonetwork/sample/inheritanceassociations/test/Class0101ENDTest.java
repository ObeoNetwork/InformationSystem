package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101END;


// End of user code for import

/**
 * Test class for Class_01_01_END.
 */
public class Class0101ENDTest extends TestCase {

	/**
	 * The DAO for class Class_01_01_END.
	 */
	private IClass0101ENDDao class0101ENDDao;

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
		class0101ENDDao = SampleDaoFactory.getClass0101ENDDao();
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
     * Tests the creation of the entity Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101END() throws DaoException {
        // fill attributes with example values
        Class0101END class0101END = getClass0101ENDExample();
        
        // Execute the tested code
        class0101ENDDao.createClass0101END(class0101END);

        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : class0101ENDDao.findAllClass0101ENDs()) {
            if (currentClass0101END.equals(class0101END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101END() throws DaoException {
        // Initialized the test
        Class0101END class0101END = getClass0101ENDExample();
        class0101ENDDao.createClass0101END(class0101END);

        // Execute the tested code
        class0101END.setFakeAttr("secondFakeAttr");
        class0101ENDDao.updateClass0101END(class0101END);

        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : class0101ENDDao.findAllClass0101ENDs()) {
            if (currentClass0101END.equals(class0101END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class0101END.getFakeAttr());
            }
        }
        Assert.assertTrue("Class0101END not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101END() throws DaoException {
        // Initialized the test
        Class0101END class0101END = getClass0101ENDExample();
        class0101ENDDao.createClass0101END(class0101END);
        
        // Execute the tested code
        class0101ENDDao.deleteClass0101END(class0101END);
        
        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : class0101ENDDao.findAllClass0101ENDs()) {
            if (currentClass0101END.getId().equals(class0101END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101END not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101ENDs() throws DaoException {
        // Verify number of element before testing
        int before = class0101ENDDao.findAllClass0101ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101END class0101END1 = getClass0101ENDExample();
        class0101ENDDao.createClass0101END(class0101END1);
                
        Class0101END class0101END2 = getClass0101ENDExample();
        class0101ENDDao.createClass0101END(class0101END2);

        // Verify result
        int after = class0101ENDDao.findAllClass0101ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_01_END.
     * @return Returns a new instance of class Class_01_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101END getClass0101ENDExample() throws DaoException {
        // fill attributes with example values
        Class0101END class0101END = new Class0101END();
        class0101END.setFakeAttr("myFakeAttr");


        return class0101END;
    }
    
    /**
     * Creates a second example of Class_01_01_END with other values.
     * @return Returns a new instance of class Class_01_01_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101END getClass0101ENDExample2() throws DaoException {
        // fill attributes with example values
        Class0101END class0101END = new Class0101END();
        class0101END.setFakeAttr("secondFakeAttr");


        return class0101END;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
