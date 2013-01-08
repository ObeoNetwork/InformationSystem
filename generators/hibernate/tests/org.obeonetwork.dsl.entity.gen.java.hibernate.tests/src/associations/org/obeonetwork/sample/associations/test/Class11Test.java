package org.obeonetwork.sample.associations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.associations.IClass11Dao;
import org.obeonetwork.sample.associations.Class11;
import org.obeonetwork.sample.associations.Class11END;
import org.obeonetwork.sample.associations.IClass11ENDDao;
// End of user code

/**
 * Test class for Class_1_1.
 */
public class Class11Test extends TestCase {
	
	/**
	 * The DAO for class Class_1_1_END.
	 */
	private IClass11ENDDao class11ENDDao;
	
	/**
	 * The DAO for class Class_1_1.
	 */
	private IClass11Dao class11Dao;
	
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
		class11ENDDao = SampleDaoFactory.getAssociationsClass_1_1_ENDClass11ENDDao();
		class11Dao = SampleDaoFactory.getAssociationsClass_1_1Class11Dao();
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
	 * Tests the creation of the entity Class_1_1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass11() throws DaoException {
	    // fill attributes with example values
	    Class11 class11 = getClass11Example();
	    
	    // Execute the tested code
	    class11Dao.createClass11(class11);
	
	    // Verify result
	    boolean found = false;
	    for (Class11 currentClass11 : class11Dao.findAllClass11s()) {
	        if (currentClass11.equals(class11)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_1 not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass11() throws DaoException {
	    // Initialized the test
	    Class11 class11 = getClass11Example();
	    class11Dao.createClass11(class11);
	
	    // Execute the tested code
	    class11.setFakeAttr(new Float(725185254.0));
	    class11Dao.updateClass11(class11);
	
	    // Verify result
	    boolean found = false;
	    for (Class11 currentClass11 : class11Dao.findAllClass11s()) {
	        if (currentClass11.equals(class11)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Float(725185254.0),
	                    class11.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class11 not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass11() throws DaoException {
	    // Initialized the test
	    Class11 class11 = getClass11Example();
	    class11Dao.createClass11(class11);
	    
	    // Execute the tested code
	    class11Dao.deleteClass11(class11);
	    
	    // Verify result
	    boolean found = false;
	    for (Class11 currentClass11 : class11Dao.findAllClass11s()) {
	        if (currentClass11.getId().equals(class11.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class11 not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_1.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass11s() throws DaoException {
	    // Verify number of element before testing
	    int before = class11Dao.findAllClass11s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class11 class111 = getClass11Example();
	    class11Dao.createClass11(class111);
	            
	    Class11 class112 = getClass11Example();
	    class11Dao.createClass11(class112);
	
	    // Verify result
	    int after = class11Dao.findAllClass11s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_1.
	 * @return Returns a new instance of class Class_1_1, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11 getClass11Example() throws DaoException {
	    // fill attributes with example values
	    Class11 class11 = new Class11();
	    class11.setFakeAttr(new Float(725185254.1));
	    
	    Class11END targetExample = new Class11END();
	    class11.setTarget(targetExample);   
	    class11ENDDao.createClass11END(targetExample);
	    
	    return class11;
	}
	
	/**
	 * Creates a second example of Class_1_1 with other values.
	 * @return Returns a new instance of class Class_1_1 with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11 getClass11Example2() throws DaoException {
	    // fill attributes with example values
	    Class11 class11 = new Class11();
		class11.setFakeAttr(new Float(725185254.0));
		
		Class11END targetExample = new Class11END();
		class11.setTarget(targetExample);   
		class11ENDDao.createClass11END(targetExample);
		
	    return class11;
	}
    
    // Start of user code of specific tests
    // End of user code

}
