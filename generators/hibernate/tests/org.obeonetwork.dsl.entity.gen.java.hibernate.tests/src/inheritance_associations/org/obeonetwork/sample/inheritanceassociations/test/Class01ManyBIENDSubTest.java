package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIENDSub;


// End of user code for import

/**
 * Test class for Class_01_Many_BI_END_Sub.
 */
public class Class01ManyBIENDSubTest extends TestCase {

	/**
	 * The DAO for class Class_01_Many_BI_END_Sub.
	 */
	private IClass01ManyBIENDSubDao class01ManyBIENDSubDao;

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
		class01ManyBIENDSubDao = SampleDaoFactory.getClass01ManyBIENDSubDao();
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
     * Tests the creation of the entity Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyBIENDSub() throws DaoException {
        // fill attributes with example values
        Class01ManyBIENDSub class01ManyBIENDSub = getClass01ManyBIENDSubExample();
        
        // Execute the tested code
        class01ManyBIENDSubDao.createClass01ManyBIENDSub(class01ManyBIENDSub);

        // Verify result
        boolean found = false;
        for (Class01ManyBIENDSub currentClass01ManyBIENDSub : class01ManyBIENDSubDao.findAllClass01ManyBIENDSubs()) {
            if (currentClass01ManyBIENDSub.equals(class01ManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyBIENDSub() throws DaoException {
        // Initialized the test
        Class01ManyBIENDSub class01ManyBIENDSub = getClass01ManyBIENDSubExample();
        class01ManyBIENDSubDao.createClass01ManyBIENDSub(class01ManyBIENDSub);

        // Execute the tested code
        class01ManyBIENDSubDao.updateClass01ManyBIENDSub(class01ManyBIENDSub);

        // Verify result
        boolean found = false;
        for (Class01ManyBIENDSub currentClass01ManyBIENDSub : class01ManyBIENDSubDao.findAllClass01ManyBIENDSubs()) {
            if (currentClass01ManyBIENDSub.equals(class01ManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class01ManyBIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyBIENDSub() throws DaoException {
        // Initialized the test
        Class01ManyBIENDSub class01ManyBIENDSub = getClass01ManyBIENDSubExample();
        class01ManyBIENDSubDao.createClass01ManyBIENDSub(class01ManyBIENDSub);
        
        // Execute the tested code
        class01ManyBIENDSubDao.deleteClass01ManyBIENDSub(class01ManyBIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBIENDSub currentClass01ManyBIENDSub : class01ManyBIENDSubDao.findAllClass01ManyBIENDSubs()) {
            if (currentClass01ManyBIENDSub.getId().equals(class01ManyBIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyBIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyBIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = class01ManyBIENDSubDao.findAllClass01ManyBIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBIENDSub class01ManyBIENDSub1 = getClass01ManyBIENDSubExample();
        class01ManyBIENDSubDao.createClass01ManyBIENDSub(class01ManyBIENDSub1);
                
        Class01ManyBIENDSub class01ManyBIENDSub2 = getClass01ManyBIENDSubExample();
        class01ManyBIENDSubDao.createClass01ManyBIENDSub(class01ManyBIENDSub2);

        // Verify result
        int after = class01ManyBIENDSubDao.findAllClass01ManyBIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_Many_BI_END_Sub.
     * @return Returns a new instance of class Class_01_Many_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBIENDSub getClass01ManyBIENDSubExample() throws DaoException {
        // fill attributes with example values
        Class01ManyBIENDSub class01ManyBIENDSub = new Class01ManyBIENDSub();
        class01ManyBIENDSub.setFakeAttr("myFakeAttr");


        return class01ManyBIENDSub;
    }
    
    /**
     * Creates a second example of Class_01_Many_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_01_Many_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBIENDSub getClass01ManyBIENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyBIENDSub class01ManyBIENDSub = new Class01ManyBIENDSub();
        class01ManyBIENDSub.setFakeAttr("secondFakeAttr");


        return class01ManyBIENDSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
