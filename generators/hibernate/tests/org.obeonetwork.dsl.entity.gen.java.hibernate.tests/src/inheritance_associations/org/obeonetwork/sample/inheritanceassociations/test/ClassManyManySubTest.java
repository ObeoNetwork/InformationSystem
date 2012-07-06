package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManySub;


// End of user code for import

/**
 * Test class for Class_Many_Many_Sub.
 */
public class ClassManyManySubTest extends TestCase {

	/**
	 * The DAO for class Class_Many_Many_Sub.
	 */
	private IClassManyManySubDao classManyManySubDao;

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
		classManyManySubDao = SampleDaoFactory.getClassManyManySubDao();
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
     * Tests the creation of the entity Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManySub() throws DaoException {
        // fill attributes with example values
        ClassManyManySub classManyManySub = getClassManyManySubExample();
        
        // Execute the tested code
        classManyManySubDao.createClassManyManySub(classManyManySub);

        // Verify result
        boolean found = false;
        for (ClassManyManySub currentClassManyManySub : classManyManySubDao.findAllClassManyManySubs()) {
            if (currentClassManyManySub.equals(classManyManySub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManySub() throws DaoException {
        // Initialized the test
        ClassManyManySub classManyManySub = getClassManyManySubExample();
        classManyManySubDao.createClassManyManySub(classManyManySub);

        // Execute the tested code
        classManyManySubDao.updateClassManyManySub(classManyManySub);

        // Verify result
        boolean found = false;
        for (ClassManyManySub currentClassManyManySub : classManyManySubDao.findAllClassManyManySubs()) {
            if (currentClassManyManySub.equals(classManyManySub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManySub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManySub() throws DaoException {
        // Initialized the test
        ClassManyManySub classManyManySub = getClassManyManySubExample();
        classManyManySubDao.createClassManyManySub(classManyManySub);
        
        // Execute the tested code
        classManyManySubDao.deleteClassManyManySub(classManyManySub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManySub currentClassManyManySub : classManyManySubDao.findAllClassManyManySubs()) {
            if (currentClassManyManySub.getId().equals(classManyManySub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManySub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManySubs() throws DaoException {
        // Verify number of element before testing
        int before = classManyManySubDao.findAllClassManyManySubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManySub classManyManySub1 = getClassManyManySubExample();
        classManyManySubDao.createClassManyManySub(classManyManySub1);
                
        ClassManyManySub classManyManySub2 = getClassManyManySubExample();
        classManyManySubDao.createClassManyManySub(classManyManySub2);

        // Verify result
        int after = classManyManySubDao.findAllClassManyManySubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_Many_Sub.
     * @return Returns a new instance of class Class_Many_Many_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManySub getClassManyManySubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManySub classManyManySub = new ClassManyManySub();
        classManyManySub.setFakeAttr("myFakeAttr");


        return classManyManySub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManySub getClassManyManySubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManySub classManyManySub = new ClassManyManySub();
        classManyManySub.setFakeAttr("secondFakeAttr");


        return classManyManySub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
