package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao;
import org.obeonetwork.sample.inheritanceassociations.Class01ManySub;


// End of user code

/**
 * Test class for Class_01_Many_Sub.
 */
public class Class01ManySubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_Many_Sub.
	 */
	private IClass01ManySubDao class01ManySubDao;
	
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
		class01ManySubDao = SampleDaoFactory.getInheritanceassociationsClass01ManySubDao();
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
	 * Tests the creation of the entity Class_01_Many_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass01ManySub() throws DaoException {
	    // fill attributes with example values
	    Class01ManySub class01ManySub = getClass01ManySubExample();
	    
	    // Execute the tested code
	    class01ManySubDao.createClass01ManySub(class01ManySub);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManySub currentClass01ManySub : class01ManySubDao.findAllClass01ManySubs()) {
	        if (currentClass01ManySub.equals(class01ManySub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_Many_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_Many_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass01ManySub() throws DaoException {
	    // Initialized the test
	    Class01ManySub class01ManySub = getClass01ManySubExample();
	    class01ManySubDao.createClass01ManySub(class01ManySub);
	
	    // Execute the tested code
	    class01ManySubDao.updateClass01ManySub(class01ManySub);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManySub currentClass01ManySub : class01ManySubDao.findAllClass01ManySubs()) {
	        if (currentClass01ManySub.equals(class01ManySub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class01ManySub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_Many_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass01ManySub() throws DaoException {
	    // Initialized the test
	    Class01ManySub class01ManySub = getClass01ManySubExample();
	    class01ManySubDao.createClass01ManySub(class01ManySub);
	    
	    // Execute the tested code
	    class01ManySubDao.deleteClass01ManySub(class01ManySub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class01ManySub currentClass01ManySub : class01ManySubDao.findAllClass01ManySubs()) {
	        if (currentClass01ManySub.getId().equals(class01ManySub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class01ManySub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_Many_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass01ManySubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class01ManySubDao.findAllClass01ManySubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class01ManySub class01ManySub1 = getClass01ManySubExample();
	    class01ManySubDao.createClass01ManySub(class01ManySub1);
	            
	    Class01ManySub class01ManySub2 = getClass01ManySubExample();
	    class01ManySubDao.createClass01ManySub(class01ManySub2);
	
	    // Verify result
	    int after = class01ManySubDao.findAllClass01ManySubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_Many_Sub.
	 * @return Returns a new instance of class Class_01_Many_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManySub getClass01ManySubExample() throws DaoException {
	    // fill attributes with example values
	    Class01ManySub class01ManySub = new Class01ManySub();
	    class01ManySub.setFakeAttr("myFakeAttr");
	    
	    
	    return class01ManySub;
	}
	
	/**
	 * Creates a second example of Class_01_Many_Sub with other values.
	 * @return Returns a new instance of class Class_01_Many_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManySub getClass01ManySubExample2() throws DaoException {
	    // fill attributes with example values
	    Class01ManySub class01ManySub = new Class01ManySub();
		class01ManySub.setFakeAttr("secondFakeAttr");
		
		
	    return class01ManySub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
