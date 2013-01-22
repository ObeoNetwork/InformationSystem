package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBI;


// End of user code

/**
 * Test class for Class_01_Many_BI.
 */
public class Class01ManyBITest extends TestCase {
	
	/**
	 * The DAO for class Class_01_Many_BI.
	 */
	private IClass01ManyBIDao class01ManyBIDao;
	
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
		class01ManyBIDao = SampleDaoFactory.getInheritanceassociationsClass01ManyBIDao();
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
	 * Tests the creation of the entity Class_01_Many_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass01ManyBI() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBI class01ManyBI = getClass01ManyBIExample();
	    
	    // Execute the tested code
	    class01ManyBIDao.createClass01ManyBI(class01ManyBI);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBI currentClass01ManyBI : class01ManyBIDao.findAllClass01ManyBIs()) {
	        if (currentClass01ManyBI.equals(class01ManyBI)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_Many_BI not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_Many_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass01ManyBI() throws DaoException {
	    // Initialized the test
	    Class01ManyBI class01ManyBI = getClass01ManyBIExample();
	    class01ManyBIDao.createClass01ManyBI(class01ManyBI);
	
	    // Execute the tested code
	    class01ManyBI.setFakeAttr("secondFakeAttr");
	    class01ManyBIDao.updateClass01ManyBI(class01ManyBI);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBI currentClass01ManyBI : class01ManyBIDao.findAllClass01ManyBIs()) {
	        if (currentClass01ManyBI.equals(class01ManyBI)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    "secondFakeAttr",
	                    class01ManyBI.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class01ManyBI not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_Many_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass01ManyBI() throws DaoException {
	    // Initialized the test
	    Class01ManyBI class01ManyBI = getClass01ManyBIExample();
	    class01ManyBIDao.createClass01ManyBI(class01ManyBI);
	    
	    // Execute the tested code
	    class01ManyBIDao.deleteClass01ManyBI(class01ManyBI);
	    
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBI currentClass01ManyBI : class01ManyBIDao.findAllClass01ManyBIs()) {
	        if (currentClass01ManyBI.getId().equals(class01ManyBI.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class01ManyBI not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_Many_BI.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass01ManyBIs() throws DaoException {
	    // Verify number of element before testing
	    int before = class01ManyBIDao.findAllClass01ManyBIs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class01ManyBI class01ManyBI1 = getClass01ManyBIExample();
	    class01ManyBIDao.createClass01ManyBI(class01ManyBI1);
	            
	    Class01ManyBI class01ManyBI2 = getClass01ManyBIExample();
	    class01ManyBIDao.createClass01ManyBI(class01ManyBI2);
	
	    // Verify result
	    int after = class01ManyBIDao.findAllClass01ManyBIs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_Many_BI.
	 * @return Returns a new instance of class Class_01_Many_BI, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyBI getClass01ManyBIExample() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBI class01ManyBI = new Class01ManyBI();
	    class01ManyBI.setFakeAttr("myFakeAttr");
	    
	    
	    return class01ManyBI;
	}
	
	/**
	 * Creates a second example of Class_01_Many_BI with other values.
	 * @return Returns a new instance of class Class_01_Many_BI with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyBI getClass01ManyBIExample2() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBI class01ManyBI = new Class01ManyBI();
		class01ManyBI.setFakeAttr("secondFakeAttr");
		
		
	    return class01ManyBI;
	}
    
    // Start of user code of specific tests
    // End of user code

}
