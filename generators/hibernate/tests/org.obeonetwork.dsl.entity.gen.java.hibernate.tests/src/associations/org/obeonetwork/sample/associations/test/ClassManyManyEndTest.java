package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClassManyManyEndDao;
import org.obeonetwork.sample.associations.ClassManyManyEnd;


// End of user code for import

/**
 * Test class for Class_Many_Many_End.
 */
public class ClassManyManyEndTest extends TestCase {

	/**
	 * The DAO for class Class_Many_Many_End.
	 */
	private IClassManyManyEndDao classManyManyEndDao;

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
		classManyManyEndDao = SampleDaoFactory.getClassManyManyEndDao();
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
     * Tests the creation of the entity Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyEnd() throws DaoException {
        // fill attributes with example values
        ClassManyManyEnd classManyManyEnd = getClassManyManyEndExample();
        
        // Execute the tested code
        classManyManyEndDao.createClassManyManyEnd(classManyManyEnd);

        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : classManyManyEndDao.findAllClassManyManyEnds()) {
            if (currentClassManyManyEnd.equals(classManyManyEnd)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_End not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyEnd() throws DaoException {
        // Initialized the test
        ClassManyManyEnd classManyManyEnd = getClassManyManyEndExample();
        classManyManyEndDao.createClassManyManyEnd(classManyManyEnd);

        // Execute the tested code
        classManyManyEnd.setFakeAttr("secondFakeAttr");
        classManyManyEndDao.updateClassManyManyEnd(classManyManyEnd);

        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : classManyManyEndDao.findAllClassManyManyEnds()) {
            if (currentClassManyManyEnd.equals(classManyManyEnd)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        classManyManyEnd.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassManyManyEnd not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyEnd() throws DaoException {
        // Initialized the test
        ClassManyManyEnd classManyManyEnd = getClassManyManyEndExample();
        classManyManyEndDao.createClassManyManyEnd(classManyManyEnd);
        
        // Execute the tested code
        classManyManyEndDao.deleteClassManyManyEnd(classManyManyEnd);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : classManyManyEndDao.findAllClassManyManyEnds()) {
            if (currentClassManyManyEnd.getId().equals(classManyManyEnd.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyEnd not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyEnds() throws DaoException {
        // Verify number of element before testing
        int before = classManyManyEndDao.findAllClassManyManyEnds().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyEnd classManyManyEnd1 = getClassManyManyEndExample();
        classManyManyEndDao.createClassManyManyEnd(classManyManyEnd1);
                
        ClassManyManyEnd classManyManyEnd2 = getClassManyManyEndExample();
        classManyManyEndDao.createClassManyManyEnd(classManyManyEnd2);

        // Verify result
        int after = classManyManyEndDao.findAllClassManyManyEnds().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_Many_End.
     * @return Returns a new instance of class Class_Many_Many_End, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEnd getClassManyManyEndExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyEnd classManyManyEnd = new ClassManyManyEnd();
        classManyManyEnd.setFakeAttr("myFakeAttr");


        return classManyManyEnd;
    }
    
    /**
     * Creates a second example of Class_Many_Many_End with other values.
     * @return Returns a new instance of class Class_Many_Many_End with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEnd getClassManyManyEndExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyEnd classManyManyEnd = new ClassManyManyEnd();
        classManyManyEnd.setFakeAttr("secondFakeAttr");


        return classManyManyEnd;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
