package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass101Dao;
import org.obeonetwork.sample.associations.Class101;


// End of user code

/**
 * Test class for Class_1_01.
 */
public class Class101Test extends TestCase {
	
	/**
	 * The DAO for class Class_1_01.
	 */
	private IClass101Dao class101Dao;
	
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
		class101Dao = SampleDaoFactory.getAssociationsClass101Dao();
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
	 * Tests the creation of the entity Class_1_01.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass101() throws DaoException {
	    // fill attributes with example values
	    Class101 class101 = getClass101Example();
	    
	    // Execute the tested code
	    class101Dao.createClass101(class101);
	
	    // Verify result
	    boolean found = false;
	    for (Class101 currentClass101 : class101Dao.findAllClass101s()) {
	        if (currentClass101.equals(class101)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_01 not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_01.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass101() throws DaoException {
	    // Initialized the test
	    Class101 class101 = getClass101Example();
	    class101Dao.createClass101(class101);
	
	    // Execute the tested code
	    class101.setFakeAttr("secondFakeAttr");
	    class101Dao.updateClass101(class101);
	
	    // Verify result
	    boolean found = false;
	    for (Class101 currentClass101 : class101Dao.findAllClass101s()) {
	        if (currentClass101.equals(class101)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    "secondFakeAttr",
	                    class101.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class101 not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_01.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass101() throws DaoException {
	    // Initialized the test
	    Class101 class101 = getClass101Example();
	    class101Dao.createClass101(class101);
	    
	    // Execute the tested code
	    class101Dao.deleteClass101(class101);
	    
	    // Verify result
	    boolean found = false;
	    for (Class101 currentClass101 : class101Dao.findAllClass101s()) {
	        if (currentClass101.getId().equals(class101.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class101 not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_01.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass101s() throws DaoException {
	    // Verify number of element before testing
	    int before = class101Dao.findAllClass101s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class101 class1011 = getClass101Example();
	    class101Dao.createClass101(class1011);
	            
	    Class101 class1012 = getClass101Example();
	    class101Dao.createClass101(class1012);
	
	    // Verify result
	    int after = class101Dao.findAllClass101s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_01.
	 * @return Returns a new instance of class Class_1_01, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101 getClass101Example() throws DaoException {
	    // fill attributes with example values
	    Class101 class101 = new Class101();
	    class101.setFakeAttr("myFakeAttr");
	    
	    
	    return class101;
	}
	
	/**
	 * Creates a second example of Class_1_01 with other values.
	 * @return Returns a new instance of class Class_1_01 with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101 getClass101Example2() throws DaoException {
	    // fill attributes with example values
	    Class101 class101 = new Class101();
		class101.setFakeAttr("secondFakeAttr");
		
		
	    return class101;
	}
    
    // Start of user code of specific tests
    // End of user code

}
