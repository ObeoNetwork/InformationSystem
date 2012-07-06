package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class101EndSub;


// End of user code for import

/**
 * Test class for Class_1_01_End_Sub.
 */
public class Class101EndSubTest extends TestCase {

	/**
	 * The DAO for class Class_1_01_End_Sub.
	 */
	private IClass101EndSubDao class101EndSubDao;

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
		class101EndSubDao = SampleDaoFactory.getClass101EndSubDao();
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
     * Tests the creation of the entity Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101EndSub() throws DaoException {
        // fill attributes with example values
        Class101EndSub class101EndSub = getClass101EndSubExample();
        
        // Execute the tested code
        class101EndSubDao.createClass101EndSub(class101EndSub);

        // Verify result
        boolean found = false;
        for (Class101EndSub currentClass101EndSub : class101EndSubDao.findAllClass101EndSubs()) {
            if (currentClass101EndSub.equals(class101EndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_End_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101EndSub() throws DaoException {
        // Initialized the test
        Class101EndSub class101EndSub = getClass101EndSubExample();
        class101EndSubDao.createClass101EndSub(class101EndSub);

        // Execute the tested code
        class101EndSubDao.updateClass101EndSub(class101EndSub);

        // Verify result
        boolean found = false;
        for (Class101EndSub currentClass101EndSub : class101EndSubDao.findAllClass101EndSubs()) {
            if (currentClass101EndSub.equals(class101EndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101EndSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101EndSub() throws DaoException {
        // Initialized the test
        Class101EndSub class101EndSub = getClass101EndSubExample();
        class101EndSubDao.createClass101EndSub(class101EndSub);
        
        // Execute the tested code
        class101EndSubDao.deleteClass101EndSub(class101EndSub);
        
        // Verify result
        boolean found = false;
        for (Class101EndSub currentClass101EndSub : class101EndSubDao.findAllClass101EndSubs()) {
            if (currentClass101EndSub.getId().equals(class101EndSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101EndSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101EndSubs() throws DaoException {
        // Verify number of element before testing
        int before = class101EndSubDao.findAllClass101EndSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101EndSub class101EndSub1 = getClass101EndSubExample();
        class101EndSubDao.createClass101EndSub(class101EndSub1);
                
        Class101EndSub class101EndSub2 = getClass101EndSubExample();
        class101EndSubDao.createClass101EndSub(class101EndSub2);

        // Verify result
        int after = class101EndSubDao.findAllClass101EndSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_1_01_End_Sub.
     * @return Returns a new instance of class Class_1_01_End_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101EndSub getClass101EndSubExample() throws DaoException {
        // fill attributes with example values
        Class101EndSub class101EndSub = new Class101EndSub();
        class101EndSub.setFakeAttr("myFakeAttr");


        return class101EndSub;
    }
    
    /**
     * Creates a second example of Class_1_01_End_Sub with other values.
     * @return Returns a new instance of class Class_1_01_End_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101EndSub getClass101EndSubExample2() throws DaoException {
        // fill attributes with example values
        Class101EndSub class101EndSub = new Class101EndSub();
        class101EndSub.setFakeAttr("secondFakeAttr");


        return class101EndSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
