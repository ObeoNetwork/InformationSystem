package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class11ENDSub;


// End of user code

/**
 * Test class for Class_1_1_END_Sub.
 */
public class Class11ENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_1_END_Sub.
	 */
	private IClass11ENDSubDao class11ENDSubDao;
	
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
		class11ENDSubDao = SampleDaoFactory.getInheritanceassociationsClass11ENDSubDao();
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
	 * Tests the creation of the entity Class_1_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass11ENDSub() throws DaoException {
	    // fill attributes with example values
	    Class11ENDSub class11ENDSub = getClass11ENDSubExample();
	    
	    // Execute the tested code
	    class11ENDSubDao.createClass11ENDSub(class11ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class11ENDSub currentClass11ENDSub : class11ENDSubDao.findAllClass11ENDSubs()) {
	        if (currentClass11ENDSub.equals(class11ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_1_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass11ENDSub() throws DaoException {
	    // Initialized the test
	    Class11ENDSub class11ENDSub = getClass11ENDSubExample();
	    class11ENDSubDao.createClass11ENDSub(class11ENDSub);
	
	    // Execute the tested code
	    class11ENDSubDao.updateClass11ENDSub(class11ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class11ENDSub currentClass11ENDSub : class11ENDSubDao.findAllClass11ENDSubs()) {
	        if (currentClass11ENDSub.equals(class11ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class11ENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass11ENDSub() throws DaoException {
	    // Initialized the test
	    Class11ENDSub class11ENDSub = getClass11ENDSubExample();
	    class11ENDSubDao.createClass11ENDSub(class11ENDSub);
	    
	    // Execute the tested code
	    class11ENDSubDao.deleteClass11ENDSub(class11ENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class11ENDSub currentClass11ENDSub : class11ENDSubDao.findAllClass11ENDSubs()) {
	        if (currentClass11ENDSub.getId().equals(class11ENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class11ENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_1_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass11ENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class11ENDSubDao.findAllClass11ENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class11ENDSub class11ENDSub1 = getClass11ENDSubExample();
	    class11ENDSubDao.createClass11ENDSub(class11ENDSub1);
	            
	    Class11ENDSub class11ENDSub2 = getClass11ENDSubExample();
	    class11ENDSubDao.createClass11ENDSub(class11ENDSub2);
	
	    // Verify result
	    int after = class11ENDSubDao.findAllClass11ENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_1_END_Sub.
	 * @return Returns a new instance of class Class_1_1_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11ENDSub getClass11ENDSubExample() throws DaoException {
	    // fill attributes with example values
	    Class11ENDSub class11ENDSub = new Class11ENDSub();
	    class11ENDSub.setFakeAttr("myFakeAttr");
	    
	    
	    return class11ENDSub;
	}
	
	/**
	 * Creates a second example of Class_1_1_END_Sub with other values.
	 * @return Returns a new instance of class Class_1_1_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11ENDSub getClass11ENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    Class11ENDSub class11ENDSub = new Class11ENDSub();
		class11ENDSub.setFakeAttr("secondFakeAttr");
		
		
	    return class11ENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
