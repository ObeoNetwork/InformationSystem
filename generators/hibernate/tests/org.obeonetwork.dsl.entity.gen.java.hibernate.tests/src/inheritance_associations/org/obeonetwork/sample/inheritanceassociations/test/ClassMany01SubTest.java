package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01Sub;


// End of user code for import

/**
 * Test class for Class_Many_01_Sub.
 */
public class ClassMany01SubTest extends TestCase {

	/**
	 * The DAO for class Class_Many_01_Sub.
	 */
	private IClassMany01SubDao classMany01SubDao;

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
		classMany01SubDao = SampleDaoFactory.getClassMany01SubDao();
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
     * Tests the creation of the entity Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01Sub() throws DaoException {
        // fill attributes with example values
        ClassMany01Sub classMany01Sub = getClassMany01SubExample();
        
        // Execute the tested code
        classMany01SubDao.createClassMany01Sub(classMany01Sub);

        // Verify result
        boolean found = false;
        for (ClassMany01Sub currentClassMany01Sub : classMany01SubDao.findAllClassMany01Subs()) {
            if (currentClassMany01Sub.equals(classMany01Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01Sub() throws DaoException {
        // Initialized the test
        ClassMany01Sub classMany01Sub = getClassMany01SubExample();
        classMany01SubDao.createClassMany01Sub(classMany01Sub);

        // Execute the tested code
        classMany01SubDao.updateClassMany01Sub(classMany01Sub);

        // Verify result
        boolean found = false;
        for (ClassMany01Sub currentClassMany01Sub : classMany01SubDao.findAllClassMany01Subs()) {
            if (currentClassMany01Sub.equals(classMany01Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassMany01Sub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01Sub() throws DaoException {
        // Initialized the test
        ClassMany01Sub classMany01Sub = getClassMany01SubExample();
        classMany01SubDao.createClassMany01Sub(classMany01Sub);
        
        // Execute the tested code
        classMany01SubDao.deleteClassMany01Sub(classMany01Sub);
        
        // Verify result
        boolean found = false;
        for (ClassMany01Sub currentClassMany01Sub : classMany01SubDao.findAllClassMany01Subs()) {
            if (currentClassMany01Sub.getId().equals(classMany01Sub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01Sub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01Subs() throws DaoException {
        // Verify number of element before testing
        int before = classMany01SubDao.findAllClassMany01Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01Sub classMany01Sub1 = getClassMany01SubExample();
        classMany01SubDao.createClassMany01Sub(classMany01Sub1);
                
        ClassMany01Sub classMany01Sub2 = getClassMany01SubExample();
        classMany01SubDao.createClassMany01Sub(classMany01Sub2);

        // Verify result
        int after = classMany01SubDao.findAllClassMany01Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_01_Sub.
     * @return Returns a new instance of class Class_Many_01_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01Sub getClassMany01SubExample() throws DaoException {
        // fill attributes with example values
        ClassMany01Sub classMany01Sub = new ClassMany01Sub();
        classMany01Sub.setFakeAttr("myFakeAttr");


        return classMany01Sub;
    }
    
    /**
     * Creates a second example of Class_Many_01_Sub with other values.
     * @return Returns a new instance of class Class_Many_01_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01Sub getClassMany01SubExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01Sub classMany01Sub = new ClassMany01Sub();
        classMany01Sub.setFakeAttr("secondFakeAttr");


        return classMany01Sub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
