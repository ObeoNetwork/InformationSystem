package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.IClassA2Dao;
import org.obeonetwork.sample.inheritance.ClassA2;


// End of user code for import

/**
 * Test class for ClassA2.
 */
public class ClassA2Test extends TestCase {

	/**
	 * The DAO for class ClassA2.
	 */
	private IClassA2Dao classA2Dao;

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
		classA2Dao = SampleDaoFactory.getClassA2Dao();
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
     * Tests the creation of the entity ClassA2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassA2() throws DaoException {
        // fill attributes with example values
        ClassA2 classA2 = getClassA2Example();
        
        // Execute the tested code
        classA2Dao.createClassA2(classA2);

        // Verify result
        boolean found = false;
        for (ClassA2 currentClassA2 : classA2Dao.findAllClassA2s()) {
            if (currentClassA2.equals(classA2)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassA2 not created", found);
    }

    /**
     * Test the modification of an entity ClassA2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassA2() throws DaoException {
        // Initialized the test
        ClassA2 classA2 = getClassA2Example();
        classA2Dao.createClassA2(classA2);

        // Execute the tested code
        classA2.setA2("secondA2");
        classA2Dao.updateClassA2(classA2);

        // Verify result
        boolean found = false;
        for (ClassA2 currentClassA2 : classA2Dao.findAllClassA2s()) {
            if (currentClassA2.equals(classA2)) {
                found = true;
                Assert.assertEquals("Value a2 not modified",
                        "secondA2",
                        classA2.getA2());
            }
        }
        Assert.assertTrue("ClassA2 not found", found);
    }

    /**
     * Test the suppression of an entity ClassA2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassA2() throws DaoException {
        // Initialized the test
        ClassA2 classA2 = getClassA2Example();
        classA2Dao.createClassA2(classA2);
        
        // Execute the tested code
        classA2Dao.deleteClassA2(classA2);
        
        // Verify result
        boolean found = false;
        for (ClassA2 currentClassA2 : classA2Dao.findAllClassA2s()) {
            if (currentClassA2.getId().equals(classA2.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassA2 not deleted", found);
    }

    /**
     * Test the search of all entities ClassA2.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassA2s() throws DaoException {
        // Verify number of element before testing
        int before = classA2Dao.findAllClassA2s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassA2 classA21 = getClassA2Example();
        classA2Dao.createClassA2(classA21);
                
        ClassA2 classA22 = getClassA2Example();
        classA2Dao.createClassA2(classA22);

        // Verify result
        int after = classA2Dao.findAllClassA2s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of ClassA2.
     * @return Returns a new instance of class ClassA2, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA2 getClassA2Example() throws DaoException {
        // fill attributes with example values
        ClassA2 classA2 = new ClassA2();
        classA2.setA2("myA2");
        classA2.setA1(new Float(3056.1));


        return classA2;
    }
    
    /**
     * Creates a second example of ClassA2 with other values.
     * @return Returns a new instance of class ClassA2 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA2 getClassA2Example2() throws DaoException {
        // fill attributes with example values
        ClassA2 classA2 = new ClassA2();
        classA2.setA2("secondA2");
        classA2.setA1(new Float(3056.0));


        return classA2;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
