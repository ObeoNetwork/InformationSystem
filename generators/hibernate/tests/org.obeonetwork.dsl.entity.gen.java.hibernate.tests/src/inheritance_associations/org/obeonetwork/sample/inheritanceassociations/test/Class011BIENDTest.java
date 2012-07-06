package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;


// End of user code for import

/**
 * Test class for Class_01_1_BI_END.
 */
public class Class011BIENDTest extends TestCase {

	/**
	 * The DAO for class Class_01_1_BI_END.
	 */
	private IClass011BIENDDao class011BIENDDao;

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
		class011BIENDDao = SampleDaoFactory.getClass011BIENDDao();
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
     * Tests the creation of the entity Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011BIEND() throws DaoException {
        // fill attributes with example values
        Class011BIEND class011BIEND = getClass011BIENDExample();
        
        // Execute the tested code
        class011BIENDDao.createClass011BIEND(class011BIEND);

        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : class011BIENDDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.equals(class011BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011BIEND() throws DaoException {
        // Initialized the test
        Class011BIEND class011BIEND = getClass011BIENDExample();
        class011BIENDDao.createClass011BIEND(class011BIEND);

        // Execute the tested code
        class011BIEND.setFakeAttr("secondFakeAttr");
        class011BIENDDao.updateClass011BIEND(class011BIEND);

        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : class011BIENDDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.equals(class011BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class011BIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("Class011BIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011BIEND() throws DaoException {
        // Initialized the test
        Class011BIEND class011BIEND = getClass011BIENDExample();
        class011BIENDDao.createClass011BIEND(class011BIEND);
        
        // Execute the tested code
        class011BIENDDao.deleteClass011BIEND(class011BIEND);
        
        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : class011BIENDDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.getId().equals(class011BIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011BIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011BIENDs() throws DaoException {
        // Verify number of element before testing
        int before = class011BIENDDao.findAllClass011BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BIEND class011BIEND1 = getClass011BIENDExample();
        class011BIENDDao.createClass011BIEND(class011BIEND1);
                
        Class011BIEND class011BIEND2 = getClass011BIENDExample();
        class011BIENDDao.createClass011BIEND(class011BIEND2);

        // Verify result
        int after = class011BIENDDao.findAllClass011BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_1_BI_END.
     * @return Returns a new instance of class Class_01_1_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BIEND getClass011BIENDExample() throws DaoException {
        // fill attributes with example values
        Class011BIEND class011BIEND = new Class011BIEND();
        class011BIEND.setFakeAttr("myFakeAttr");


        return class011BIEND;
    }
    
    /**
     * Creates a second example of Class_01_1_BI_END with other values.
     * @return Returns a new instance of class Class_01_1_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BIEND getClass011BIENDExample2() throws DaoException {
        // fill attributes with example values
        Class011BIEND class011BIEND = new Class011BIEND();
        class011BIEND.setFakeAttr("secondFakeAttr");


        return class011BIEND;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
