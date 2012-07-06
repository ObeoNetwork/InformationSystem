package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101BI;


// End of user code for import

/**
 * Test class for Class_01_01_BI.
 */
public class Class0101BITest extends TestCase {

	/**
	 * The DAO for class Class_01_01_BI.
	 */
	private IClass0101BIDao class0101BIDao;

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
		class0101BIDao = SampleDaoFactory.getClass0101BIDao();
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
     * Tests the creation of the entity Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101BI() throws DaoException {
        // fill attributes with example values
        Class0101BI class0101BI = getClass0101BIExample();
        
        // Execute the tested code
        class0101BIDao.createClass0101BI(class0101BI);

        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : class0101BIDao.findAllClass0101BIs()) {
            if (currentClass0101BI.equals(class0101BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101BI() throws DaoException {
        // Initialized the test
        Class0101BI class0101BI = getClass0101BIExample();
        class0101BIDao.createClass0101BI(class0101BI);

        // Execute the tested code
        class0101BI.setFakeAttr("secondFakeAttr");
        class0101BIDao.updateClass0101BI(class0101BI);

        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : class0101BIDao.findAllClass0101BIs()) {
            if (currentClass0101BI.equals(class0101BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class0101BI.getFakeAttr());
            }
        }
        Assert.assertTrue("Class0101BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101BI() throws DaoException {
        // Initialized the test
        Class0101BI class0101BI = getClass0101BIExample();
        class0101BIDao.createClass0101BI(class0101BI);
        
        // Execute the tested code
        class0101BIDao.deleteClass0101BI(class0101BI);
        
        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : class0101BIDao.findAllClass0101BIs()) {
            if (currentClass0101BI.getId().equals(class0101BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101BIs() throws DaoException {
        // Verify number of element before testing
        int before = class0101BIDao.findAllClass0101BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BI class0101BI1 = getClass0101BIExample();
        class0101BIDao.createClass0101BI(class0101BI1);
                
        Class0101BI class0101BI2 = getClass0101BIExample();
        class0101BIDao.createClass0101BI(class0101BI2);

        // Verify result
        int after = class0101BIDao.findAllClass0101BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_01_BI.
     * @return Returns a new instance of class Class_01_01_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BI getClass0101BIExample() throws DaoException {
        // fill attributes with example values
        Class0101BI class0101BI = new Class0101BI();
        class0101BI.setFakeAttr("myFakeAttr");


        return class0101BI;
    }
    
    /**
     * Creates a second example of Class_01_01_BI with other values.
     * @return Returns a new instance of class Class_01_01_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BI getClass0101BIExample2() throws DaoException {
        // fill attributes with example values
        Class0101BI class0101BI = new Class0101BI();
        class0101BI.setFakeAttr("secondFakeAttr");


        return class0101BI;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
