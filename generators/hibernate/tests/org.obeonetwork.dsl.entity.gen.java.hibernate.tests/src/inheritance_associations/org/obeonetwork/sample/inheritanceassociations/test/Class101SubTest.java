package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass101SubDao;
import org.obeonetwork.sample.inheritanceassociations.Class101Sub;


// End of user code

/**
 * Test class for Class_1_01_Sub.
 */
public class Class101SubTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_01_Sub.
	 */
	private IClass101SubDao class101SubDao;
	
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
		class101SubDao = SampleDaoFactory.getInheritanceassociationsClass101SubDao();
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
	 * Tests the creation of the entity Class_1_01_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass101Sub() throws DaoException {
	    // fill attributes with example values
	    Class101Sub class101Sub = getClass101SubExample();
	    
	    // Execute the tested code
	    class101SubDao.createClass101Sub(class101Sub);
	
	    // Verify result
	    boolean found = false;
	    for (Class101Sub currentClass101Sub : class101SubDao.findAllClass101Subs()) {
	        if (currentClass101Sub.equals(class101Sub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_01_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_01_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass101Sub() throws DaoException {
	    // Initialized the test
	    Class101Sub class101Sub = getClass101SubExample();
	    class101SubDao.createClass101Sub(class101Sub);
	
	    // Execute the tested code
	    class101SubDao.updateClass101Sub(class101Sub);
	
	    // Verify result
	    boolean found = false;
	    for (Class101Sub currentClass101Sub : class101SubDao.findAllClass101Subs()) {
	        if (currentClass101Sub.equals(class101Sub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class101Sub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_01_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass101Sub() throws DaoException {
	    // Initialized the test
	    Class101Sub class101Sub = getClass101SubExample();
	    class101SubDao.createClass101Sub(class101Sub);
	    
	    // Execute the tested code
	    class101SubDao.deleteClass101Sub(class101Sub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class101Sub currentClass101Sub : class101SubDao.findAllClass101Subs()) {
	        if (currentClass101Sub.getId().equals(class101Sub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class101Sub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_01_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass101Subs() throws DaoException {
	    // Verify number of element before testing
	    int before = class101SubDao.findAllClass101Subs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class101Sub class101Sub1 = getClass101SubExample();
	    class101SubDao.createClass101Sub(class101Sub1);
	            
	    Class101Sub class101Sub2 = getClass101SubExample();
	    class101SubDao.createClass101Sub(class101Sub2);
	
	    // Verify result
	    int after = class101SubDao.findAllClass101Subs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_01_Sub.
	 * @return Returns a new instance of class Class_1_01_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101Sub getClass101SubExample() throws DaoException {
	    // fill attributes with example values
	    Class101Sub class101Sub = new Class101Sub();
	    class101Sub.setFakeAttr("myFakeAttr");
	    
	    
	    return class101Sub;
	}
	
	/**
	 * Creates a second example of Class_1_01_Sub with other values.
	 * @return Returns a new instance of class Class_1_01_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101Sub getClass101SubExample2() throws DaoException {
	    // fill attributes with example values
	    Class101Sub class101Sub = new Class101Sub();
		class101Sub.setFakeAttr("secondFakeAttr");
		
		
	    return class101Sub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
