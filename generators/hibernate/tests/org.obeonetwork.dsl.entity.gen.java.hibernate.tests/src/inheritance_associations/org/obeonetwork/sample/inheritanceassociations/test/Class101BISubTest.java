package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao;
import org.obeonetwork.sample.inheritanceassociations.Class101BISub;


// End of user code for import

/**
 * Test class for Class_1_01_BI_Sub.
 */
public class Class101BISubTest extends TestCase {

	/**
	 * The DAO for class Class_1_01_BI_Sub.
	 */
	private IClass101BISubDao class101BISubDao;

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
		class101BISubDao = SampleDaoFactory.getClass101BISubDao();
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
     * Tests the creation of the entity Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101BISub() throws DaoException {
        // fill attributes with example values
        Class101BISub class101BISub = getClass101BISubExample();
        
        // Execute the tested code
        class101BISubDao.createClass101BISub(class101BISub);

        // Verify result
        boolean found = false;
        for (Class101BISub currentClass101BISub : class101BISubDao.findAllClass101BISubs()) {
            if (currentClass101BISub.equals(class101BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101BISub() throws DaoException {
        // Initialized the test
        Class101BISub class101BISub = getClass101BISubExample();
        class101BISubDao.createClass101BISub(class101BISub);

        // Execute the tested code
        class101BISubDao.updateClass101BISub(class101BISub);

        // Verify result
        boolean found = false;
        for (Class101BISub currentClass101BISub : class101BISubDao.findAllClass101BISubs()) {
            if (currentClass101BISub.equals(class101BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101BISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101BISub() throws DaoException {
        // Initialized the test
        Class101BISub class101BISub = getClass101BISubExample();
        class101BISubDao.createClass101BISub(class101BISub);
        
        // Execute the tested code
        class101BISubDao.deleteClass101BISub(class101BISub);
        
        // Verify result
        boolean found = false;
        for (Class101BISub currentClass101BISub : class101BISubDao.findAllClass101BISubs()) {
            if (currentClass101BISub.getId().equals(class101BISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101BISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101BISubs() throws DaoException {
        // Verify number of element before testing
        int before = class101BISubDao.findAllClass101BISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BISub class101BISub1 = getClass101BISubExample();
        class101BISubDao.createClass101BISub(class101BISub1);
                
        Class101BISub class101BISub2 = getClass101BISubExample();
        class101BISubDao.createClass101BISub(class101BISub2);

        // Verify result
        int after = class101BISubDao.findAllClass101BISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_1_01_BI_Sub.
     * @return Returns a new instance of class Class_1_01_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BISub getClass101BISubExample() throws DaoException {
        // fill attributes with example values
        Class101BISub class101BISub = new Class101BISub();


        return class101BISub;
    }
    
    /**
     * Creates a second example of Class_1_01_BI_Sub with other values.
     * @return Returns a new instance of class Class_1_01_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BISub getClass101BISubExample2() throws DaoException {
        // fill attributes with example values
        Class101BISub class101BISub = new Class101BISub();


        return class101BISub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
