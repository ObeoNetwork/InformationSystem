package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IClass_Dao;
import org.obeonetwork.sample.badpractives.Class_;


// End of user code

/**
 * Test class for Class.
 */
public class Class_Test extends TestCase {
	
	/**
	 * The DAO for class Class.
	 */
	private IClass_Dao class_Dao;
	
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
		class_Dao = SampleDaoFactory.getBadPractivesClass_Dao();
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
	 * Tests the creation of the entity Class.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass_() throws DaoException {
	    // fill attributes with example values
	    Class_ class_ = getClass_Example();
	    
	    // Execute the tested code
	    class_Dao.createClass_(class_);
	
	    // Verify result
	    boolean found = false;
	    for (Class_ currentClass_ : class_Dao.findAllClass_s()) {
	        if (currentClass_.equals(class_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class not created", found);
	}
	
	/**
	 * Test the modification of an entity Class.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass_() throws DaoException {
	    // Initialized the test
	    Class_ class_ = getClass_Example();
	    class_Dao.createClass_(class_);
	
	    // Execute the tested code
	    class_Dao.updateClass_(class_);
	
	    // Verify result
	    boolean found = false;
	    for (Class_ currentClass_ : class_Dao.findAllClass_s()) {
	        if (currentClass_.equals(class_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass_() throws DaoException {
	    // Initialized the test
	    Class_ class_ = getClass_Example();
	    class_Dao.createClass_(class_);
	    
	    // Execute the tested code
	    class_Dao.deleteClass_(class_);
	    
	    // Verify result
	    boolean found = false;
	    for (Class_ currentClass_ : class_Dao.findAllClass_s()) {
	        if (currentClass_.getId().equals(class_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass_s() throws DaoException {
	    // Verify number of element before testing
	    int before = class_Dao.findAllClass_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class_ class_1 = getClass_Example();
	    class_Dao.createClass_(class_1);
	            
	    Class_ class_2 = getClass_Example();
	    class_Dao.createClass_(class_2);
	
	    // Verify result
	    int after = class_Dao.findAllClass_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class.
	 * @return Returns a new instance of class Class, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class_ getClass_Example() throws DaoException {
	    // fill attributes with example values
	    Class_ class_ = new Class_();
	    
	    
	    return class_;
	}
	
	/**
	 * Creates a second example of Class with other values.
	 * @return Returns a new instance of class Class with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class_ getClass_Example2() throws DaoException {
	    // fill attributes with example values
	    Class_ class_ = new Class_();
		
		
	    return class_;
	}
    
    // Start of user code of specific tests
    // End of user code

}
