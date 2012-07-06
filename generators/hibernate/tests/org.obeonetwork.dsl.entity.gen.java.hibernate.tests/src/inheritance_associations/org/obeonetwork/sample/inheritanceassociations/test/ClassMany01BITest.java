package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BI;


// End of user code for import

/**
 * Test class for Class_Many_01_BI.
 */
public class ClassMany01BITest extends TestCase {

	/**
	 * The DAO for class Class_Many_01_BI.
	 */
	private IClassMany01BIDao classMany01BIDao;

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
		classMany01BIDao = SampleDaoFactory.getClassMany01BIDao();
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
     * Tests the creation of the entity Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01BI() throws DaoException {
        // fill attributes with example values
        ClassMany01BI classMany01BI = getClassMany01BIExample();
        
        // Execute the tested code
        classMany01BIDao.createClassMany01BI(classMany01BI);

        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : classMany01BIDao.findAllClassMany01BIs()) {
            if (currentClassMany01BI.equals(classMany01BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01BI() throws DaoException {
        // Initialized the test
        ClassMany01BI classMany01BI = getClassMany01BIExample();
        classMany01BIDao.createClassMany01BI(classMany01BI);

        // Execute the tested code
        classMany01BI.setFakeAttr("secondFakeAttr");
        classMany01BIDao.updateClassMany01BI(classMany01BI);

        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : classMany01BIDao.findAllClassMany01BIs()) {
            if (currentClassMany01BI.equals(classMany01BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        classMany01BI.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassMany01BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01BI() throws DaoException {
        // Initialized the test
        ClassMany01BI classMany01BI = getClassMany01BIExample();
        classMany01BIDao.createClassMany01BI(classMany01BI);
        
        // Execute the tested code
        classMany01BIDao.deleteClassMany01BI(classMany01BI);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : classMany01BIDao.findAllClassMany01BIs()) {
            if (currentClassMany01BI.getId().equals(classMany01BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01BIs() throws DaoException {
        // Verify number of element before testing
        int before = classMany01BIDao.findAllClassMany01BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BI classMany01BI1 = getClassMany01BIExample();
        classMany01BIDao.createClassMany01BI(classMany01BI1);
                
        ClassMany01BI classMany01BI2 = getClassMany01BIExample();
        classMany01BIDao.createClassMany01BI(classMany01BI2);

        // Verify result
        int after = classMany01BIDao.findAllClassMany01BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_01_BI.
     * @return Returns a new instance of class Class_Many_01_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BI getClassMany01BIExample() throws DaoException {
        // fill attributes with example values
        ClassMany01BI classMany01BI = new ClassMany01BI();
        classMany01BI.setFakeAttr("myFakeAttr");


        return classMany01BI;
    }
    
    /**
     * Creates a second example of Class_Many_01_BI with other values.
     * @return Returns a new instance of class Class_Many_01_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BI getClassMany01BIExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01BI classMany01BI = new ClassMany01BI();
        classMany01BI.setFakeAttr("secondFakeAttr");


        return classMany01BI;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
