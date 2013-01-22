package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101Sub;


// End of user code

/**
 * Test class for Class_01_01_Sub.
 */
public class Class0101SubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_01_Sub.
	 */
	private IClass0101SubDao class0101SubDao;
	
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
		class0101SubDao = SampleDaoFactory.getInheritanceassociationsClass0101SubDao();
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
	 * Tests the creation of the entity Class_01_01_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass0101Sub() throws DaoException {
	    // fill attributes with example values
	    Class0101Sub class0101Sub = getClass0101SubExample();
	    
	    // Execute the tested code
	    class0101SubDao.createClass0101Sub(class0101Sub);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101Sub currentClass0101Sub : class0101SubDao.findAllClass0101Subs()) {
	        if (currentClass0101Sub.equals(class0101Sub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_01_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_01_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass0101Sub() throws DaoException {
	    // Initialized the test
	    Class0101Sub class0101Sub = getClass0101SubExample();
	    class0101SubDao.createClass0101Sub(class0101Sub);
	
	    // Execute the tested code
	    class0101SubDao.updateClass0101Sub(class0101Sub);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101Sub currentClass0101Sub : class0101SubDao.findAllClass0101Subs()) {
	        if (currentClass0101Sub.equals(class0101Sub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class0101Sub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_01_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass0101Sub() throws DaoException {
	    // Initialized the test
	    Class0101Sub class0101Sub = getClass0101SubExample();
	    class0101SubDao.createClass0101Sub(class0101Sub);
	    
	    // Execute the tested code
	    class0101SubDao.deleteClass0101Sub(class0101Sub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class0101Sub currentClass0101Sub : class0101SubDao.findAllClass0101Subs()) {
	        if (currentClass0101Sub.getId().equals(class0101Sub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class0101Sub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_01_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass0101Subs() throws DaoException {
	    // Verify number of element before testing
	    int before = class0101SubDao.findAllClass0101Subs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class0101Sub class0101Sub1 = getClass0101SubExample();
	    class0101SubDao.createClass0101Sub(class0101Sub1);
	            
	    Class0101Sub class0101Sub2 = getClass0101SubExample();
	    class0101SubDao.createClass0101Sub(class0101Sub2);
	
	    // Verify result
	    int after = class0101SubDao.findAllClass0101Subs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_01_Sub.
	 * @return Returns a new instance of class Class_01_01_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101Sub getClass0101SubExample() throws DaoException {
	    // fill attributes with example values
	    Class0101Sub class0101Sub = new Class0101Sub();
	    class0101Sub.setFakeAttr("myFakeAttr");
	    
	    
	    return class0101Sub;
	}
	
	/**
	 * Creates a second example of Class_01_01_Sub with other values.
	 * @return Returns a new instance of class Class_01_01_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101Sub getClass0101SubExample2() throws DaoException {
	    // fill attributes with example values
	    Class0101Sub class0101Sub = new Class0101Sub();
		class0101Sub.setFakeAttr("secondFakeAttr");
		
		
	    return class0101Sub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
