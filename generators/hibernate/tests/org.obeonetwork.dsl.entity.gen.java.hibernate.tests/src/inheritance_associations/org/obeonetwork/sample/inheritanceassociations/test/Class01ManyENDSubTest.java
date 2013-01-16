package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyENDSub;


// End of user code

/**
 * Test class for Class_01_Many_END_Sub.
 */
public class Class01ManyENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_Many_END_Sub.
	 */
	private IClass01ManyENDSubDao class01ManyENDSubDao;
	
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
		class01ManyENDSubDao = SampleDaoFactory.getInheritanceassociationsClass01ManyENDSubDao();
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
	 * Tests the creation of the entity Class_01_Many_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass01ManyENDSub() throws DaoException {
	    // fill attributes with example values
	    Class01ManyENDSub class01ManyENDSub = getClass01ManyENDSubExample();
	    
	    // Execute the tested code
	    class01ManyENDSubDao.createClass01ManyENDSub(class01ManyENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyENDSub currentClass01ManyENDSub : class01ManyENDSubDao.findAllClass01ManyENDSubs()) {
	        if (currentClass01ManyENDSub.equals(class01ManyENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_Many_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_Many_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass01ManyENDSub() throws DaoException {
	    // Initialized the test
	    Class01ManyENDSub class01ManyENDSub = getClass01ManyENDSubExample();
	    class01ManyENDSubDao.createClass01ManyENDSub(class01ManyENDSub);
	
	    // Execute the tested code
	    class01ManyENDSubDao.updateClass01ManyENDSub(class01ManyENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyENDSub currentClass01ManyENDSub : class01ManyENDSubDao.findAllClass01ManyENDSubs()) {
	        if (currentClass01ManyENDSub.equals(class01ManyENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class01ManyENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_Many_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass01ManyENDSub() throws DaoException {
	    // Initialized the test
	    Class01ManyENDSub class01ManyENDSub = getClass01ManyENDSubExample();
	    class01ManyENDSubDao.createClass01ManyENDSub(class01ManyENDSub);
	    
	    // Execute the tested code
	    class01ManyENDSubDao.deleteClass01ManyENDSub(class01ManyENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class01ManyENDSub currentClass01ManyENDSub : class01ManyENDSubDao.findAllClass01ManyENDSubs()) {
	        if (currentClass01ManyENDSub.getId().equals(class01ManyENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class01ManyENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_Many_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass01ManyENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class01ManyENDSubDao.findAllClass01ManyENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class01ManyENDSub class01ManyENDSub1 = getClass01ManyENDSubExample();
	    class01ManyENDSubDao.createClass01ManyENDSub(class01ManyENDSub1);
	            
	    Class01ManyENDSub class01ManyENDSub2 = getClass01ManyENDSubExample();
	    class01ManyENDSubDao.createClass01ManyENDSub(class01ManyENDSub2);
	
	    // Verify result
	    int after = class01ManyENDSubDao.findAllClass01ManyENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_Many_END_Sub.
	 * @return Returns a new instance of class Class_01_Many_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyENDSub getClass01ManyENDSubExample() throws DaoException {
	    // fill attributes with example values
	    Class01ManyENDSub class01ManyENDSub = new Class01ManyENDSub();
	    class01ManyENDSub.setFakeAttr("myFakeAttr");
	    
	    
	    return class01ManyENDSub;
	}
	
	/**
	 * Creates a second example of Class_01_Many_END_Sub with other values.
	 * @return Returns a new instance of class Class_01_Many_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyENDSub getClass01ManyENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    Class01ManyENDSub class01ManyENDSub = new Class01ManyENDSub();
		class01ManyENDSub.setFakeAttr("secondFakeAttr");
		
		
	    return class01ManyENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
