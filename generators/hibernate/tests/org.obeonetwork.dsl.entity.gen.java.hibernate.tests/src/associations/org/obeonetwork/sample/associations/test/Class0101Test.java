package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass0101Dao;
import org.obeonetwork.sample.associations.Class0101;


// End of user code

/**
 * Test class for Class_01_01.
 */
public class Class0101Test extends TestCase {
	
	/**
	 * The DAO for class Class_01_01.
	 */
	private IClass0101Dao class0101Dao;
	
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
		class0101Dao = SampleDaoFactory.getAssociationsClass_01_01Class0101Dao();
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
	 * Tests the creation of the entity Class_01_01.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass0101() throws DaoException {
	    // fill attributes with example values
	    Class0101 class0101 = getClass0101Example();
	    
	    // Execute the tested code
	    class0101Dao.createClass0101(class0101);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101 currentClass0101 : class0101Dao.findAllClass0101s()) {
	        if (currentClass0101.equals(class0101)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_01 not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_01.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass0101() throws DaoException {
	    // Initialized the test
	    Class0101 class0101 = getClass0101Example();
	    class0101Dao.createClass0101(class0101);
	
	    // Execute the tested code
	    class0101.setFakeAttr("secondFakeAttr");
	    class0101Dao.updateClass0101(class0101);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101 currentClass0101 : class0101Dao.findAllClass0101s()) {
	        if (currentClass0101.equals(class0101)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    "secondFakeAttr",
	                    class0101.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class0101 not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_01.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass0101() throws DaoException {
	    // Initialized the test
	    Class0101 class0101 = getClass0101Example();
	    class0101Dao.createClass0101(class0101);
	    
	    // Execute the tested code
	    class0101Dao.deleteClass0101(class0101);
	    
	    // Verify result
	    boolean found = false;
	    for (Class0101 currentClass0101 : class0101Dao.findAllClass0101s()) {
	        if (currentClass0101.getId().equals(class0101.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class0101 not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_01.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass0101s() throws DaoException {
	    // Verify number of element before testing
	    int before = class0101Dao.findAllClass0101s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class0101 class01011 = getClass0101Example();
	    class0101Dao.createClass0101(class01011);
	            
	    Class0101 class01012 = getClass0101Example();
	    class0101Dao.createClass0101(class01012);
	
	    // Verify result
	    int after = class0101Dao.findAllClass0101s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_01.
	 * @return Returns a new instance of class Class_01_01, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101 getClass0101Example() throws DaoException {
	    // fill attributes with example values
	    Class0101 class0101 = new Class0101();
	    class0101.setFakeAttr("myFakeAttr");
	    
	    
	    return class0101;
	}
	
	/**
	 * Creates a second example of Class_01_01 with other values.
	 * @return Returns a new instance of class Class_01_01 with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101 getClass0101Example2() throws DaoException {
	    // fill attributes with example values
	    Class0101 class0101 = new Class0101();
		class0101.setFakeAttr("secondFakeAttr");
		
		
	    return class0101;
	}
    
    // Start of user code of specific tests
    // End of user code

}
