package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101ENDSub;


// End of user code

/**
 * Test class for Class_01_01_END_Sub.
 */
public class Class0101ENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_01_END_Sub.
	 */
	private IClass0101ENDSubDao class0101ENDSubDao;
	
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
		class0101ENDSubDao = SampleDaoFactory.getInheritanceassociationsClass0101ENDSubDao();
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
	 * Tests the creation of the entity Class_01_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass0101ENDSub() throws DaoException {
	    // fill attributes with example values
	    Class0101ENDSub class0101ENDSub = getClass0101ENDSubExample();
	    
	    // Execute the tested code
	    class0101ENDSubDao.createClass0101ENDSub(class0101ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101ENDSub currentClass0101ENDSub : class0101ENDSubDao.findAllClass0101ENDSubs()) {
	        if (currentClass0101ENDSub.equals(class0101ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_01_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass0101ENDSub() throws DaoException {
	    // Initialized the test
	    Class0101ENDSub class0101ENDSub = getClass0101ENDSubExample();
	    class0101ENDSubDao.createClass0101ENDSub(class0101ENDSub);
	
	    // Execute the tested code
	    class0101ENDSubDao.updateClass0101ENDSub(class0101ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101ENDSub currentClass0101ENDSub : class0101ENDSubDao.findAllClass0101ENDSubs()) {
	        if (currentClass0101ENDSub.equals(class0101ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class0101ENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass0101ENDSub() throws DaoException {
	    // Initialized the test
	    Class0101ENDSub class0101ENDSub = getClass0101ENDSubExample();
	    class0101ENDSubDao.createClass0101ENDSub(class0101ENDSub);
	    
	    // Execute the tested code
	    class0101ENDSubDao.deleteClass0101ENDSub(class0101ENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class0101ENDSub currentClass0101ENDSub : class0101ENDSubDao.findAllClass0101ENDSubs()) {
	        if (currentClass0101ENDSub.getId().equals(class0101ENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class0101ENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass0101ENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class0101ENDSubDao.findAllClass0101ENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class0101ENDSub class0101ENDSub1 = getClass0101ENDSubExample();
	    class0101ENDSubDao.createClass0101ENDSub(class0101ENDSub1);
	            
	    Class0101ENDSub class0101ENDSub2 = getClass0101ENDSubExample();
	    class0101ENDSubDao.createClass0101ENDSub(class0101ENDSub2);
	
	    // Verify result
	    int after = class0101ENDSubDao.findAllClass0101ENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_01_END_Sub.
	 * @return Returns a new instance of class Class_01_01_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101ENDSub getClass0101ENDSubExample() throws DaoException {
	    // fill attributes with example values
	    Class0101ENDSub class0101ENDSub = new Class0101ENDSub();
	    class0101ENDSub.setFakeAttr("myFakeAttr");
	    
	    
	    return class0101ENDSub;
	}
	
	/**
	 * Creates a second example of Class_01_01_END_Sub with other values.
	 * @return Returns a new instance of class Class_01_01_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101ENDSub getClass0101ENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    Class0101ENDSub class0101ENDSub = new Class0101ENDSub();
		class0101ENDSub.setFakeAttr("secondFakeAttr");
		
		
	    return class0101ENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
