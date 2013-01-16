package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class011ENDSub;


// End of user code

/**
 * Test class for Class_01_1_END_Sub.
 */
public class Class011ENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_1_END_Sub.
	 */
	private IClass011ENDSubDao class011ENDSubDao;
	
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
		class011ENDSubDao = SampleDaoFactory.getInheritanceassociationsClass011ENDSubDao();
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
	 * Tests the creation of the entity Class_01_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass011ENDSub() throws DaoException {
	    // fill attributes with example values
	    Class011ENDSub class011ENDSub = getClass011ENDSubExample();
	    
	    // Execute the tested code
	    class011ENDSubDao.createClass011ENDSub(class011ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class011ENDSub currentClass011ENDSub : class011ENDSubDao.findAllClass011ENDSubs()) {
	        if (currentClass011ENDSub.equals(class011ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_1_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass011ENDSub() throws DaoException {
	    // Initialized the test
	    Class011ENDSub class011ENDSub = getClass011ENDSubExample();
	    class011ENDSubDao.createClass011ENDSub(class011ENDSub);
	
	    // Execute the tested code
	    class011ENDSubDao.updateClass011ENDSub(class011ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class011ENDSub currentClass011ENDSub : class011ENDSubDao.findAllClass011ENDSubs()) {
	        if (currentClass011ENDSub.equals(class011ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class011ENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass011ENDSub() throws DaoException {
	    // Initialized the test
	    Class011ENDSub class011ENDSub = getClass011ENDSubExample();
	    class011ENDSubDao.createClass011ENDSub(class011ENDSub);
	    
	    // Execute the tested code
	    class011ENDSubDao.deleteClass011ENDSub(class011ENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class011ENDSub currentClass011ENDSub : class011ENDSubDao.findAllClass011ENDSubs()) {
	        if (currentClass011ENDSub.getId().equals(class011ENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class011ENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass011ENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class011ENDSubDao.findAllClass011ENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class011ENDSub class011ENDSub1 = getClass011ENDSubExample();
	    class011ENDSubDao.createClass011ENDSub(class011ENDSub1);
	            
	    Class011ENDSub class011ENDSub2 = getClass011ENDSubExample();
	    class011ENDSubDao.createClass011ENDSub(class011ENDSub2);
	
	    // Verify result
	    int after = class011ENDSubDao.findAllClass011ENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_1_END_Sub.
	 * @return Returns a new instance of class Class_01_1_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011ENDSub getClass011ENDSubExample() throws DaoException {
	    // fill attributes with example values
	    Class011ENDSub class011ENDSub = new Class011ENDSub();
	    class011ENDSub.setFakeAttr("myFakeAttr");
	    
	    
	    return class011ENDSub;
	}
	
	/**
	 * Creates a second example of Class_01_1_END_Sub with other values.
	 * @return Returns a new instance of class Class_01_1_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011ENDSub getClass011ENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    Class011ENDSub class011ENDSub = new Class011ENDSub();
		class011ENDSub.setFakeAttr("secondFakeAttr");
		
		
	    return class011ENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
