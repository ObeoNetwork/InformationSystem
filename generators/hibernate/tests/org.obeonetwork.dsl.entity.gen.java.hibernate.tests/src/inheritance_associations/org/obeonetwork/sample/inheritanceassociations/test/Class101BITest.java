package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass101BIDao;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;


// End of user code

/**
 * Test class for Class_1_01_BI.
 */
public class Class101BITest extends TestCase {
	
	/**
	 * The DAO for class Class_1_01_BI.
	 */
	private IClass101BIDao class101BIDao;
	
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
		class101BIDao = SampleDaoFactory.getInheritanceassociationsClass101BIDao();
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
	 * Tests the creation of the entity Class_1_01_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass101BI() throws DaoException {
	    // fill attributes with example values
	    Class101BI class101BI = getClass101BIExample();
	    
	    // Execute the tested code
	    class101BIDao.createClass101BI(class101BI);
	
	    // Verify result
	    boolean found = false;
	    for (Class101BI currentClass101BI : class101BIDao.findAllClass101BIs()) {
	        if (currentClass101BI.equals(class101BI)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_01_BI not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_01_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass101BI() throws DaoException {
	    // Initialized the test
	    Class101BI class101BI = getClass101BIExample();
	    class101BIDao.createClass101BI(class101BI);
	
	    // Execute the tested code
	    class101BIDao.updateClass101BI(class101BI);
	
	    // Verify result
	    boolean found = false;
	    for (Class101BI currentClass101BI : class101BIDao.findAllClass101BIs()) {
	        if (currentClass101BI.equals(class101BI)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class101BI not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_01_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass101BI() throws DaoException {
	    // Initialized the test
	    Class101BI class101BI = getClass101BIExample();
	    class101BIDao.createClass101BI(class101BI);
	    
	    // Execute the tested code
	    class101BIDao.deleteClass101BI(class101BI);
	    
	    // Verify result
	    boolean found = false;
	    for (Class101BI currentClass101BI : class101BIDao.findAllClass101BIs()) {
	        if (currentClass101BI.getId().equals(class101BI.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class101BI not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_01_BI.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass101BIs() throws DaoException {
	    // Verify number of element before testing
	    int before = class101BIDao.findAllClass101BIs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class101BI class101BI1 = getClass101BIExample();
	    class101BIDao.createClass101BI(class101BI1);
	            
	    Class101BI class101BI2 = getClass101BIExample();
	    class101BIDao.createClass101BI(class101BI2);
	
	    // Verify result
	    int after = class101BIDao.findAllClass101BIs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_01_BI.
	 * @return Returns a new instance of class Class_1_01_BI, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101BI getClass101BIExample() throws DaoException {
	    // fill attributes with example values
	    Class101BI class101BI = new Class101BI();
	    
	    
	    return class101BI;
	}
	
	/**
	 * Creates a second example of Class_1_01_BI with other values.
	 * @return Returns a new instance of class Class_1_01_BI with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101BI getClass101BIExample2() throws DaoException {
	    // fill attributes with example values
	    Class101BI class101BI = new Class101BI();
		
		
	    return class101BI;
	}
    
    // Start of user code of specific tests
    // End of user code

}
