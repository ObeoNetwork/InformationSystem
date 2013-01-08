package org.obeonetwork.sample.associations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;

import junit.framework.Assert;

import org.obeonetwork.sample.SampleDaoFactory;
import org.obeonetwork.sample.associations.IClass011BIDao;
import org.obeonetwork.sample.associations.Class011BI;
import org.obeonetwork.sample.associations.Class011BIEND;
import org.obeonetwork.sample.associations.IClass011BIENDDao;
// End of user code

/**
 * Test class for Class_01_1_BI.
 */
public class Class011BITest extends TestCase {
	
	/**
	 * The DAO for class Class_01_1_BI.
	 */
	private IClass011BIDao class011BIDao;
	
	/**
	 * The DAO for class Class_01_1_BI_END.
	 */
	private IClass011BIENDDao class011BIENDDao;
	
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
		class011BIDao = SampleDaoFactory.getAssociationsClass_01_1_BIClass011BIDao();
		class011BIENDDao = SampleDaoFactory.getAssociationsClass_01_1_BI_ENDClass011BIENDDao();
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
	 * Tests the creation of the entity Class_01_1_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass011BI() throws DaoException {
	    // fill attributes with example values
	    Class011BI class011BI = getClass011BIExample();
	    
	    // Execute the tested code
	    class011BIDao.createClass011BI(class011BI);
	
	    // Verify result
	    boolean found = false;
	    for (Class011BI currentClass011BI : class011BIDao.findAllClass011BIs()) {
	        if (currentClass011BI.equals(class011BI)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_1_BI not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_1_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass011BI() throws DaoException {
	    // Initialized the test
	    Class011BI class011BI = getClass011BIExample();
	    class011BIDao.createClass011BI(class011BI);
	
	    // Execute the tested code
	    class011BI.setFakeAttr("secondFakeAttr");
	    class011BIDao.updateClass011BI(class011BI);
	
	    // Verify result
	    boolean found = false;
	    for (Class011BI currentClass011BI : class011BIDao.findAllClass011BIs()) {
	        if (currentClass011BI.equals(class011BI)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    "secondFakeAttr",
	                    class011BI.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class011BI not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_1_BI.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass011BI() throws DaoException {
	    // Initialized the test
	    Class011BI class011BI = getClass011BIExample();
	    class011BIDao.createClass011BI(class011BI);
	    
	    // Execute the tested code
	    class011BIDao.deleteClass011BI(class011BI);
	    
	    // Verify result
	    boolean found = false;
	    for (Class011BI currentClass011BI : class011BIDao.findAllClass011BIs()) {
	        if (currentClass011BI.getId().equals(class011BI.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class011BI not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_1_BI.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass011BIs() throws DaoException {
	    // Verify number of element before testing
	    int before = class011BIDao.findAllClass011BIs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class011BI class011BI1 = getClass011BIExample();
	    class011BIDao.createClass011BI(class011BI1);
	            
	    Class011BI class011BI2 = getClass011BIExample();
	    class011BIDao.createClass011BI(class011BI2);
	
	    // Verify result
	    int after = class011BIDao.findAllClass011BIs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_1_BI.
	 * @return Returns a new instance of class Class_01_1_BI, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011BI getClass011BIExample() throws DaoException {
	    // fill attributes with example values
	    Class011BI class011BI = new Class011BI();
	    class011BI.setFakeAttr("myFakeAttr");
	    
	    Class011BIEND targetExample = new Class011BIEND();
	    class011BI.setTarget(targetExample);   
	    targetExample.setSource(class011BI); 
	    class011BIENDDao.createClass011BIEND(targetExample);
	    
	    return class011BI;
	}
	
	/**
	 * Creates a second example of Class_01_1_BI with other values.
	 * @return Returns a new instance of class Class_01_1_BI with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011BI getClass011BIExample2() throws DaoException {
	    // fill attributes with example values
	    Class011BI class011BI = new Class011BI();
		class011BI.setFakeAttr("secondFakeAttr");
		
		Class011BIEND targetExample = new Class011BIEND();
		class011BI.setTarget(targetExample);   
		targetExample.setSource(class011BI); 
		class011BIENDDao.createClass011BIEND(targetExample);
		
	    return class011BI;
	}
    
    // Start of user code of specific tests
    // End of user code

}
