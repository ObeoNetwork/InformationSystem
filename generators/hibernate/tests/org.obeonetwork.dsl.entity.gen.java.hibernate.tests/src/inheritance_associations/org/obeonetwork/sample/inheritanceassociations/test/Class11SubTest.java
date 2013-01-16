package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass11SubDao;
import org.obeonetwork.sample.inheritanceassociations.Class11Sub;
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao;
// End of user code

/**
 * Test class for Class_1_1_Sub.
 */
public class Class11SubTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_1_END.
	 */
	private IClass11ENDDao class11ENDDao;
	
	/**
	 * The DAO for class Class_1_1_Sub.
	 */
	private IClass11SubDao class11SubDao;
	
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
		class11ENDDao = SampleDaoFactory.getInheritanceassociationsClass11ENDDao();
		class11SubDao = SampleDaoFactory.getInheritanceassociationsClass11SubDao();
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
	 * Tests the creation of the entity Class_1_1_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass11Sub() throws DaoException {
	    // fill attributes with example values
	    Class11Sub class11Sub = getClass11SubExample();
	    
	    // Execute the tested code
	    class11SubDao.createClass11Sub(class11Sub);
	
	    // Verify result
	    boolean found = false;
	    for (Class11Sub currentClass11Sub : class11SubDao.findAllClass11Subs()) {
	        if (currentClass11Sub.equals(class11Sub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_1_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_1_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass11Sub() throws DaoException {
	    // Initialized the test
	    Class11Sub class11Sub = getClass11SubExample();
	    class11SubDao.createClass11Sub(class11Sub);
	
	    // Execute the tested code
	    class11SubDao.updateClass11Sub(class11Sub);
	
	    // Verify result
	    boolean found = false;
	    for (Class11Sub currentClass11Sub : class11SubDao.findAllClass11Subs()) {
	        if (currentClass11Sub.equals(class11Sub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class11Sub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_1_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass11Sub() throws DaoException {
	    // Initialized the test
	    Class11Sub class11Sub = getClass11SubExample();
	    class11SubDao.createClass11Sub(class11Sub);
	    
	    // Execute the tested code
	    class11SubDao.deleteClass11Sub(class11Sub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class11Sub currentClass11Sub : class11SubDao.findAllClass11Subs()) {
	        if (currentClass11Sub.getId().equals(class11Sub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class11Sub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_1_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass11Subs() throws DaoException {
	    // Verify number of element before testing
	    int before = class11SubDao.findAllClass11Subs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class11Sub class11Sub1 = getClass11SubExample();
	    class11SubDao.createClass11Sub(class11Sub1);
	            
	    Class11Sub class11Sub2 = getClass11SubExample();
	    class11SubDao.createClass11Sub(class11Sub2);
	
	    // Verify result
	    int after = class11SubDao.findAllClass11Subs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_1_Sub.
	 * @return Returns a new instance of class Class_1_1_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11Sub getClass11SubExample() throws DaoException {
	    // fill attributes with example values
	    Class11Sub class11Sub = new Class11Sub();
	    class11Sub.setFakeAttr("myFakeAttr");
	    
	    Class11END targetExample = new Class11END();
	    class11Sub.setTarget(targetExample);   
	    class11ENDDao.createClass11END(targetExample);
	    
	    return class11Sub;
	}
	
	/**
	 * Creates a second example of Class_1_1_Sub with other values.
	 * @return Returns a new instance of class Class_1_1_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11Sub getClass11SubExample2() throws DaoException {
	    // fill attributes with example values
	    Class11Sub class11Sub = new Class11Sub();
		class11Sub.setFakeAttr("secondFakeAttr");
		
		Class11END targetExample = new Class11END();
		class11Sub.setTarget(targetExample);   
		class11ENDDao.createClass11END(targetExample);
		
	    return class11Sub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
