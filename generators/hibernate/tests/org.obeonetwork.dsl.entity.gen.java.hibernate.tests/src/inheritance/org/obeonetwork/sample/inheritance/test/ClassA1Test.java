package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.IClassA1Dao;
import org.obeonetwork.sample.inheritance.ClassA1;


// End of user code

/**
 * Test class for ClassA1.
 */
public class ClassA1Test extends TestCase {
	
	/**
	 * The DAO for class ClassA1.
	 */
	private IClassA1Dao classA1Dao;
	
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
		classA1Dao = SampleDaoFactory.getInheritanceClassA1Dao();
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
	 * Tests the creation of the entity ClassA1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassA1() throws DaoException {
	    // fill attributes with example values
	    ClassA1 classA1 = getClassA1Example();
	    
	    // Execute the tested code
	    classA1Dao.createClassA1(classA1);
	
	    // Verify result
	    boolean found = false;
	    for (ClassA1 currentClassA1 : classA1Dao.findAllClassA1s()) {
	        if (currentClassA1.equals(classA1)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("ClassA1 not created", found);
	}
	
	/**
	 * Test the modification of an entity ClassA1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassA1() throws DaoException {
	    // Initialized the test
	    ClassA1 classA1 = getClassA1Example();
	    classA1Dao.createClassA1(classA1);
	
	    // Execute the tested code
	    classA1.setA1(new Float(3056.0));
	    classA1Dao.updateClassA1(classA1);
	
	    // Verify result
	    boolean found = false;
	    for (ClassA1 currentClassA1 : classA1Dao.findAllClassA1s()) {
	        if (currentClassA1.equals(classA1)) {
	            found = true;
	            Assert.assertEquals("Value a1 not modified",
	                    new Float(3056.0),
	                    classA1.getA1());
	        }
	    }
	    Assert.assertTrue("ClassA1 not found", found);
	}
	
	/**
	 * Test the suppression of an entity ClassA1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassA1() throws DaoException {
	    // Initialized the test
	    ClassA1 classA1 = getClassA1Example();
	    classA1Dao.createClassA1(classA1);
	    
	    // Execute the tested code
	    classA1Dao.deleteClassA1(classA1);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassA1 currentClassA1 : classA1Dao.findAllClassA1s()) {
	        if (currentClassA1.getId().equals(classA1.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassA1 not deleted", found);
	}
	
	/**
	 * Test the search of all entities ClassA1.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassA1s() throws DaoException {
	    // Verify number of element before testing
	    int before = classA1Dao.findAllClassA1s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassA1 classA11 = getClassA1Example();
	    classA1Dao.createClassA1(classA11);
	            
	    ClassA1 classA12 = getClassA1Example();
	    classA1Dao.createClassA1(classA12);
	
	    // Verify result
	    int after = classA1Dao.findAllClassA1s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of ClassA1.
	 * @return Returns a new instance of class ClassA1, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassA1 getClassA1Example() throws DaoException {
	    // fill attributes with example values
	    ClassA1 classA1 = new ClassA1();
	    classA1.setA1(new Float(3056.1));
	    
	    
	    return classA1;
	}
	
	/**
	 * Creates a second example of ClassA1 with other values.
	 * @return Returns a new instance of class ClassA1 with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassA1 getClassA1Example2() throws DaoException {
	    // fill attributes with example values
	    ClassA1 classA1 = new ClassA1();
		classA1.setA1(new Float(3056.0));
		
		
	    return classA1;
	}
    
    // Start of user code of specific tests
    // End of user code

}
