package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIENDSub;


// End of user code for import

/**
 * Test class for Class_01_01_BI_END_Sub.
 */
public class Class0101BIENDSubTest extends TestCase {

	/**
	 * The DAO for class Class_01_01_BI_END_Sub.
	 */
	private IClass0101BIENDSubDao class0101BIENDSubDao;

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
		class0101BIENDSubDao = SampleDaoFactory.getClass0101BIENDSubDao();
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
     * Tests the creation of the entity Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101BIENDSub() throws DaoException {
        // fill attributes with example values
        Class0101BIENDSub class0101BIENDSub = getClass0101BIENDSubExample();
        
        // Execute the tested code
        class0101BIENDSubDao.createClass0101BIENDSub(class0101BIENDSub);

        // Verify result
        boolean found = false;
        for (Class0101BIENDSub currentClass0101BIENDSub : class0101BIENDSubDao.findAllClass0101BIENDSubs()) {
            if (currentClass0101BIENDSub.equals(class0101BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101BIENDSub() throws DaoException {
        // Initialized the test
        Class0101BIENDSub class0101BIENDSub = getClass0101BIENDSubExample();
        class0101BIENDSubDao.createClass0101BIENDSub(class0101BIENDSub);

        // Execute the tested code
        class0101BIENDSubDao.updateClass0101BIENDSub(class0101BIENDSub);

        // Verify result
        boolean found = false;
        for (Class0101BIENDSub currentClass0101BIENDSub : class0101BIENDSubDao.findAllClass0101BIENDSubs()) {
            if (currentClass0101BIENDSub.equals(class0101BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class0101BIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101BIENDSub() throws DaoException {
        // Initialized the test
        Class0101BIENDSub class0101BIENDSub = getClass0101BIENDSubExample();
        class0101BIENDSubDao.createClass0101BIENDSub(class0101BIENDSub);
        
        // Execute the tested code
        class0101BIENDSubDao.deleteClass0101BIENDSub(class0101BIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class0101BIENDSub currentClass0101BIENDSub : class0101BIENDSubDao.findAllClass0101BIENDSubs()) {
            if (currentClass0101BIENDSub.getId().equals(class0101BIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101BIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101BIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = class0101BIENDSubDao.findAllClass0101BIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BIENDSub class0101BIENDSub1 = getClass0101BIENDSubExample();
        class0101BIENDSubDao.createClass0101BIENDSub(class0101BIENDSub1);
                
        Class0101BIENDSub class0101BIENDSub2 = getClass0101BIENDSubExample();
        class0101BIENDSubDao.createClass0101BIENDSub(class0101BIENDSub2);

        // Verify result
        int after = class0101BIENDSubDao.findAllClass0101BIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_01_BI_END_Sub.
     * @return Returns a new instance of class Class_01_01_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BIENDSub getClass0101BIENDSubExample() throws DaoException {
        // fill attributes with example values
        Class0101BIENDSub class0101BIENDSub = new Class0101BIENDSub();
        class0101BIENDSub.setFakeAttr("myFakeAttr");


        return class0101BIENDSub;
    }
    
    /**
     * Creates a second example of Class_01_01_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_01_01_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BIENDSub getClass0101BIENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class0101BIENDSub class0101BIENDSub = new Class0101BIENDSub();
        class0101BIENDSub.setFakeAttr("secondFakeAttr");


        return class0101BIENDSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
