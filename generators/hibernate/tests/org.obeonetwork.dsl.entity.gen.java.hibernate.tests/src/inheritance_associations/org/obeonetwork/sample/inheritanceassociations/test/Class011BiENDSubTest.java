package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class011BiENDSub;


// End of user code for import

/**
 * Test class for Class_01_1_Bi_END_Sub.
 */
public class Class011BiENDSubTest extends TestCase {

	/**
	 * The DAO for class Class_01_1_Bi_END_Sub.
	 */
	private IClass011BiENDSubDao class011BiENDSubDao;

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
		class011BiENDSubDao = SampleDaoFactory.getClass011BiENDSubDao();
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
     * Tests the creation of the entity Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011BiENDSub() throws DaoException {
        // fill attributes with example values
        Class011BiENDSub class011BiENDSub = getClass011BiENDSubExample();
        
        // Execute the tested code
        class011BiENDSubDao.createClass011BiENDSub(class011BiENDSub);

        // Verify result
        boolean found = false;
        for (Class011BiENDSub currentClass011BiENDSub : class011BiENDSubDao.findAllClass011BiENDSubs()) {
            if (currentClass011BiENDSub.equals(class011BiENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_Bi_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011BiENDSub() throws DaoException {
        // Initialized the test
        Class011BiENDSub class011BiENDSub = getClass011BiENDSubExample();
        class011BiENDSubDao.createClass011BiENDSub(class011BiENDSub);

        // Execute the tested code
        class011BiENDSubDao.updateClass011BiENDSub(class011BiENDSub);

        // Verify result
        boolean found = false;
        for (Class011BiENDSub currentClass011BiENDSub : class011BiENDSubDao.findAllClass011BiENDSubs()) {
            if (currentClass011BiENDSub.equals(class011BiENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class011BiENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011BiENDSub() throws DaoException {
        // Initialized the test
        Class011BiENDSub class011BiENDSub = getClass011BiENDSubExample();
        class011BiENDSubDao.createClass011BiENDSub(class011BiENDSub);
        
        // Execute the tested code
        class011BiENDSubDao.deleteClass011BiENDSub(class011BiENDSub);
        
        // Verify result
        boolean found = false;
        for (Class011BiENDSub currentClass011BiENDSub : class011BiENDSubDao.findAllClass011BiENDSubs()) {
            if (currentClass011BiENDSub.getId().equals(class011BiENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011BiENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011BiENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = class011BiENDSubDao.findAllClass011BiENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BiENDSub class011BiENDSub1 = getClass011BiENDSubExample();
        class011BiENDSubDao.createClass011BiENDSub(class011BiENDSub1);
                
        Class011BiENDSub class011BiENDSub2 = getClass011BiENDSubExample();
        class011BiENDSubDao.createClass011BiENDSub(class011BiENDSub2);

        // Verify result
        int after = class011BiENDSubDao.findAllClass011BiENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_1_Bi_END_Sub.
     * @return Returns a new instance of class Class_01_1_Bi_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BiENDSub getClass011BiENDSubExample() throws DaoException {
        // fill attributes with example values
        Class011BiENDSub class011BiENDSub = new Class011BiENDSub();
        class011BiENDSub.setFakeAttr("myFakeAttr");


        return class011BiENDSub;
    }
    
    /**
     * Creates a second example of Class_01_1_Bi_END_Sub with other values.
     * @return Returns a new instance of class Class_01_1_Bi_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BiENDSub getClass011BiENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class011BiENDSub class011BiENDSub = new Class011BiENDSub();
        class011BiENDSub.setFakeAttr("secondFakeAttr");


        return class011BiENDSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
