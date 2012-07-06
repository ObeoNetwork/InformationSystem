package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.IClassA3Dao;
import org.obeonetwork.sample.inheritance.ClassA3;


// End of user code for import

/**
 * Test class for ClassA3.
 */
public class ClassA3Test extends TestCase {

	/**
	 * The DAO for class ClassA3.
	 */
	private IClassA3Dao classA3Dao;

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
		classA3Dao = SampleDaoFactory.getClassA3Dao();
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
     * Tests the creation of the entity ClassA3.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassA3() throws DaoException {
        // fill attributes with example values
        ClassA3 classA3 = getClassA3Example();
        
        // Execute the tested code
        classA3Dao.createClassA3(classA3);

        // Verify result
        boolean found = false;
        for (ClassA3 currentClassA3 : classA3Dao.findAllClassA3s()) {
            if (currentClassA3.equals(classA3)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassA3 not created", found);
    }

    /**
     * Test the modification of an entity ClassA3.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassA3() throws DaoException {
        // Initialized the test
        ClassA3 classA3 = getClassA3Example();
        classA3Dao.createClassA3(classA3);

        // Execute the tested code
        classA3.setA3("secondA3");
        classA3Dao.updateClassA3(classA3);

        // Verify result
        boolean found = false;
        for (ClassA3 currentClassA3 : classA3Dao.findAllClassA3s()) {
            if (currentClassA3.equals(classA3)) {
                found = true;
                Assert.assertEquals("Value a3 not modified",
                        "secondA3",
                        classA3.getA3());
            }
        }
        Assert.assertTrue("ClassA3 not found", found);
    }

    /**
     * Test the suppression of an entity ClassA3.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassA3() throws DaoException {
        // Initialized the test
        ClassA3 classA3 = getClassA3Example();
        classA3Dao.createClassA3(classA3);
        
        // Execute the tested code
        classA3Dao.deleteClassA3(classA3);
        
        // Verify result
        boolean found = false;
        for (ClassA3 currentClassA3 : classA3Dao.findAllClassA3s()) {
            if (currentClassA3.getId().equals(classA3.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassA3 not deleted", found);
    }

    /**
     * Test the search of all entities ClassA3.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassA3s() throws DaoException {
        // Verify number of element before testing
        int before = classA3Dao.findAllClassA3s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassA3 classA31 = getClassA3Example();
        classA3Dao.createClassA3(classA31);
                
        ClassA3 classA32 = getClassA3Example();
        classA3Dao.createClassA3(classA32);

        // Verify result
        int after = classA3Dao.findAllClassA3s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of ClassA3.
     * @return Returns a new instance of class ClassA3, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA3 getClassA3Example() throws DaoException {
        // fill attributes with example values
        ClassA3 classA3 = new ClassA3();
        classA3.setA3("myA3");
        classA3.setA2("myA2");
        classA3.setA1(new Float(3056.1));


        return classA3;
    }
    
    /**
     * Creates a second example of ClassA3 with other values.
     * @return Returns a new instance of class ClassA3 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA3 getClassA3Example2() throws DaoException {
        // fill attributes with example values
        ClassA3 classA3 = new ClassA3();
        classA3.setA3("secondA3");
        classA3.setA2("secondA2");
        classA3.setA1(new Float(3056.0));


        return classA3;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
