package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.IClass101BIDao;
// End of user code

/**
 * Test class for Class_1_01_BI_END_Sub.
 */
public class Class101BIENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_01_BI.
	 */
	private IClass101BIDao class101BIDao;
	
	/**
	 * The DAO for class Class_1_01_BI_END_Sub.
	 */
	private IClass101BIENDSubDao class101BIENDSubDao;
	
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
		class101BIENDSubDao = SampleDaoFactory.getInheritanceassociationsClass101BIENDSubDao();
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
	 * Tests the creation of the entity Class_1_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass101BIENDSub() throws DaoException {
	    // fill attributes with example values
	    Class101BIENDSub class101BIENDSub = getClass101BIENDSubExample();
	    
	    // Execute the tested code
	    class101BIENDSubDao.createClass101BIENDSub(class101BIENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class101BIENDSub currentClass101BIENDSub : class101BIENDSubDao.findAllClass101BIENDSubs()) {
	        if (currentClass101BIENDSub.equals(class101BIENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_01_BI_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass101BIENDSub() throws DaoException {
	    // Initialized the test
	    Class101BIENDSub class101BIENDSub = getClass101BIENDSubExample();
	    class101BIENDSubDao.createClass101BIENDSub(class101BIENDSub);
	
	    // Execute the tested code
	    class101BIENDSubDao.updateClass101BIENDSub(class101BIENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class101BIENDSub currentClass101BIENDSub : class101BIENDSubDao.findAllClass101BIENDSubs()) {
	        if (currentClass101BIENDSub.equals(class101BIENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class101BIENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass101BIENDSub() throws DaoException {
	    // Initialized the test
	    Class101BIENDSub class101BIENDSub = getClass101BIENDSubExample();
	    class101BIENDSubDao.createClass101BIENDSub(class101BIENDSub);
	    
	    // Execute the tested code
	    class101BIENDSubDao.deleteClass101BIENDSub(class101BIENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class101BIENDSub currentClass101BIENDSub : class101BIENDSubDao.findAllClass101BIENDSubs()) {
	        if (currentClass101BIENDSub.getId().equals(class101BIENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class101BIENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass101BIENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class101BIENDSubDao.findAllClass101BIENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class101BIENDSub class101BIENDSub1 = getClass101BIENDSubExample();
	    class101BIENDSubDao.createClass101BIENDSub(class101BIENDSub1);
	            
	    Class101BIENDSub class101BIENDSub2 = getClass101BIENDSubExample();
	    class101BIENDSubDao.createClass101BIENDSub(class101BIENDSub2);
	
	    // Verify result
	    int after = class101BIENDSubDao.findAllClass101BIENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_01_BI_END_Sub.
	 * @return Returns a new instance of class Class_1_01_BI_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101BIENDSub getClass101BIENDSubExample() throws DaoException {
	    // fill attributes with example values
	    Class101BIENDSub class101BIENDSub = new Class101BIENDSub();
	    
	    Class101BI sourceExample = new Class101BI();
	    class101BIENDSub.setSource(sourceExample);   
	    sourceExample.setTarget(class101BIENDSub); 
	    class101BIDao.createClass101BI(sourceExample);
	    
	    return class101BIENDSub;
	}
	
	/**
	 * Creates a second example of Class_1_01_BI_END_Sub with other values.
	 * @return Returns a new instance of class Class_1_01_BI_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101BIENDSub getClass101BIENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    Class101BIENDSub class101BIENDSub = new Class101BIENDSub();
		
		Class101BI sourceExample = new Class101BI();
		class101BIENDSub.setSource(sourceExample);   
		sourceExample.setTarget(class101BIENDSub); 
		class101BIDao.createClass101BI(sourceExample);
		
	    return class101BIENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
