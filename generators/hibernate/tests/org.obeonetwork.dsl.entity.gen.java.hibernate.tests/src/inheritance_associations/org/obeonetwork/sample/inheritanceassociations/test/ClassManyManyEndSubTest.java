package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEndSub;


// End of user code for import

/**
 * Test class for Class_Many_Many_End_Sub.
 */
public class ClassManyManyEndSubTest extends TestCase {

	/**
	 * The DAO for class Class_Many_Many_End_Sub.
	 */
	private IClassManyManyEndSubDao classManyManyEndSubDao;

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
		classManyManyEndSubDao = SampleDaoFactory.getClassManyManyEndSubDao();
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
     * Tests the creation of the entity Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyEndSub() throws DaoException {
        // fill attributes with example values
        ClassManyManyEndSub classManyManyEndSub = getClassManyManyEndSubExample();
        
        // Execute the tested code
        classManyManyEndSubDao.createClassManyManyEndSub(classManyManyEndSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyEndSub currentClassManyManyEndSub : classManyManyEndSubDao.findAllClassManyManyEndSubs()) {
            if (currentClassManyManyEndSub.equals(classManyManyEndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_End_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyEndSub() throws DaoException {
        // Initialized the test
        ClassManyManyEndSub classManyManyEndSub = getClassManyManyEndSubExample();
        classManyManyEndSubDao.createClassManyManyEndSub(classManyManyEndSub);

        // Execute the tested code
        classManyManyEndSubDao.updateClassManyManyEndSub(classManyManyEndSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyEndSub currentClassManyManyEndSub : classManyManyEndSubDao.findAllClassManyManyEndSubs()) {
            if (currentClassManyManyEndSub.equals(classManyManyEndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManyEndSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyEndSub() throws DaoException {
        // Initialized the test
        ClassManyManyEndSub classManyManyEndSub = getClassManyManyEndSubExample();
        classManyManyEndSubDao.createClassManyManyEndSub(classManyManyEndSub);
        
        // Execute the tested code
        classManyManyEndSubDao.deleteClassManyManyEndSub(classManyManyEndSub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyEndSub currentClassManyManyEndSub : classManyManyEndSubDao.findAllClassManyManyEndSubs()) {
            if (currentClassManyManyEndSub.getId().equals(classManyManyEndSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyEndSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyEndSubs() throws DaoException {
        // Verify number of element before testing
        int before = classManyManyEndSubDao.findAllClassManyManyEndSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyEndSub classManyManyEndSub1 = getClassManyManyEndSubExample();
        classManyManyEndSubDao.createClassManyManyEndSub(classManyManyEndSub1);
                
        ClassManyManyEndSub classManyManyEndSub2 = getClassManyManyEndSubExample();
        classManyManyEndSubDao.createClassManyManyEndSub(classManyManyEndSub2);

        // Verify result
        int after = classManyManyEndSubDao.findAllClassManyManyEndSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_Many_End_Sub.
     * @return Returns a new instance of class Class_Many_Many_End_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEndSub getClassManyManyEndSubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyEndSub classManyManyEndSub = new ClassManyManyEndSub();
        classManyManyEndSub.setFakeAttr("myFakeAttr");


        return classManyManyEndSub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_End_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_End_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEndSub getClassManyManyEndSubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyEndSub classManyManyEndSub = new ClassManyManyEndSub();
        classManyManyEndSub.setFakeAttr("secondFakeAttr");


        return classManyManyEndSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
