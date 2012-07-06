package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01END;


// End of user code for import

/**
 * Test class for Class_Many_01_END.
 */
public class ClassMany01ENDTest extends TestCase {

	/**
	 * The DAO for class Class_Many_01_END.
	 */
	private IClassMany01ENDDao classMany01ENDDao;

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
		classMany01ENDDao = SampleDaoFactory.getClassMany01ENDDao();
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
     * Tests the creation of the entity Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01END() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = getClassMany01ENDExample();
        
        // Execute the tested code
        classMany01ENDDao.createClassMany01END(classMany01END);

        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : classMany01ENDDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.equals(classMany01END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_END not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01END() throws DaoException {
        // Initialized the test
        ClassMany01END classMany01END = getClassMany01ENDExample();
        classMany01ENDDao.createClassMany01END(classMany01END);

        // Execute the tested code
        classMany01END.setFakeAttr("secondFakeAttr");
        classMany01ENDDao.updateClassMany01END(classMany01END);

        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : classMany01ENDDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.equals(classMany01END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        classMany01END.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassMany01END not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01END() throws DaoException {
        // Initialized the test
        ClassMany01END classMany01END = getClassMany01ENDExample();
        classMany01ENDDao.createClassMany01END(classMany01END);
        
        // Execute the tested code
        classMany01ENDDao.deleteClassMany01END(classMany01END);
        
        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : classMany01ENDDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.getId().equals(classMany01END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01END not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01ENDs() throws DaoException {
        // Verify number of element before testing
        int before = classMany01ENDDao.findAllClassMany01ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01END classMany01END1 = getClassMany01ENDExample();
        classMany01ENDDao.createClassMany01END(classMany01END1);
                
        ClassMany01END classMany01END2 = getClassMany01ENDExample();
        classMany01ENDDao.createClassMany01END(classMany01END2);

        // Verify result
        int after = classMany01ENDDao.findAllClassMany01ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_01_END.
     * @return Returns a new instance of class Class_Many_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01END getClassMany01ENDExample() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = new ClassMany01END();
        classMany01END.setFakeAttr("myFakeAttr");


        return classMany01END;
    }
    
    /**
     * Creates a second example of Class_Many_01_END with other values.
     * @return Returns a new instance of class Class_Many_01_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01END getClassMany01ENDExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = new ClassMany01END();
        classMany01END.setFakeAttr("secondFakeAttr");


        return classMany01END;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
