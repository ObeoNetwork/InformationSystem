package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIENDSub;


// End of user code for import

/**
 * Test class for Class_Many_Many_BI_END_Sub.
 */
public class ClassManyManyBIENDSubTest extends TestCase {

	/**
	 * The DAO for class Class_Many_Many_BI_END_Sub.
	 */
	private IClassManyManyBIENDSubDao classManyManyBIENDSubDao;

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
		classManyManyBIENDSubDao = SampleDaoFactory.getClassManyManyBIENDSubDao();
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
     * Tests the creation of the entity Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyBIENDSub() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIENDSub classManyManyBIENDSub = getClassManyManyBIENDSubExample();
        
        // Execute the tested code
        classManyManyBIENDSubDao.createClassManyManyBIENDSub(classManyManyBIENDSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIENDSub currentClassManyManyBIENDSub : classManyManyBIENDSubDao.findAllClassManyManyBIENDSubs()) {
            if (currentClassManyManyBIENDSub.equals(classManyManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyBIENDSub() throws DaoException {
        // Initialized the test
        ClassManyManyBIENDSub classManyManyBIENDSub = getClassManyManyBIENDSubExample();
        classManyManyBIENDSubDao.createClassManyManyBIENDSub(classManyManyBIENDSub);

        // Execute the tested code
        classManyManyBIENDSubDao.updateClassManyManyBIENDSub(classManyManyBIENDSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIENDSub currentClassManyManyBIENDSub : classManyManyBIENDSubDao.findAllClassManyManyBIENDSubs()) {
            if (currentClassManyManyBIENDSub.equals(classManyManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManyBIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyBIENDSub() throws DaoException {
        // Initialized the test
        ClassManyManyBIENDSub classManyManyBIENDSub = getClassManyManyBIENDSubExample();
        classManyManyBIENDSubDao.createClassManyManyBIENDSub(classManyManyBIENDSub);
        
        // Execute the tested code
        classManyManyBIENDSubDao.deleteClassManyManyBIENDSub(classManyManyBIENDSub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBIENDSub currentClassManyManyBIENDSub : classManyManyBIENDSubDao.findAllClassManyManyBIENDSubs()) {
            if (currentClassManyManyBIENDSub.getId().equals(classManyManyBIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyBIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyBIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = classManyManyBIENDSubDao.findAllClassManyManyBIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBIENDSub classManyManyBIENDSub1 = getClassManyManyBIENDSubExample();
        classManyManyBIENDSubDao.createClassManyManyBIENDSub(classManyManyBIENDSub1);
                
        ClassManyManyBIENDSub classManyManyBIENDSub2 = getClassManyManyBIENDSubExample();
        classManyManyBIENDSubDao.createClassManyManyBIENDSub(classManyManyBIENDSub2);

        // Verify result
        int after = classManyManyBIENDSubDao.findAllClassManyManyBIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_Many_BI_END_Sub.
     * @return Returns a new instance of class Class_Many_Many_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBIENDSub getClassManyManyBIENDSubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIENDSub classManyManyBIENDSub = new ClassManyManyBIENDSub();
        classManyManyBIENDSub.setFakeAttr("myFakeAttr");


        return classManyManyBIENDSub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBIENDSub getClassManyManyBIENDSubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIENDSub classManyManyBIENDSub = new ClassManyManyBIENDSub();
        classManyManyBIENDSub.setFakeAttr("secondFakeAttr");


        return classManyManyBIENDSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
