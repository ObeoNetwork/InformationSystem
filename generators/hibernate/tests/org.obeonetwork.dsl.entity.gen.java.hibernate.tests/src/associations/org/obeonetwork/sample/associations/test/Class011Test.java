package org.obeonetwork.sample.associations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.associations.IClass011Dao;
import org.obeonetwork.sample.associations.Class011;
import org.obeonetwork.sample.associations.Class011END;
import org.obeonetwork.sample.associations.IClass011ENDDao;
// End of user code

/**
 * Test class for Class_01_1.
 */
public class Class011Test extends TestCase {
	
	/**
	 * The DAO for class Class_01_1.
	 */
	private IClass011Dao class011Dao;
	
	/**
	 * The DAO for class Class_01_1_END.
	 */
	private IClass011ENDDao class011ENDDao;
	
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
		class011Dao = SampleDaoFactory.getAssociationsClass_01_1Class011Dao();
		class011ENDDao = SampleDaoFactory.getAssociationsClass_01_1_ENDClass011ENDDao();
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
	 * Tests the creation of the entity Class_01_1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass011() throws DaoException {
	    // fill attributes with example values
	    Class011 class011 = getClass011Example();
	    
	    // Execute the tested code
	    class011Dao.createClass011(class011);
	
	    // Verify result
	    boolean found = false;
	    for (Class011 currentClass011 : class011Dao.findAllClass011s()) {
	        if (currentClass011.equals(class011)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_1 not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass011() throws DaoException {
	    // Initialized the test
	    Class011 class011 = getClass011Example();
	    class011Dao.createClass011(class011);
	
	    // Execute the tested code
	    class011.setFakeAttr(new Float(725185254.0));
	    class011Dao.updateClass011(class011);
	
	    // Verify result
	    boolean found = false;
	    for (Class011 currentClass011 : class011Dao.findAllClass011s()) {
	        if (currentClass011.equals(class011)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Float(725185254.0),
	                    class011.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class011 not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_1.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass011() throws DaoException {
	    // Initialized the test
	    Class011 class011 = getClass011Example();
	    class011Dao.createClass011(class011);
	    
	    // Execute the tested code
	    class011Dao.deleteClass011(class011);
	    
	    // Verify result
	    boolean found = false;
	    for (Class011 currentClass011 : class011Dao.findAllClass011s()) {
	        if (currentClass011.getId().equals(class011.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class011 not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_1.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass011s() throws DaoException {
	    // Verify number of element before testing
	    int before = class011Dao.findAllClass011s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class011 class0111 = getClass011Example();
	    class011Dao.createClass011(class0111);
	            
	    Class011 class0112 = getClass011Example();
	    class011Dao.createClass011(class0112);
	
	    // Verify result
	    int after = class011Dao.findAllClass011s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_1.
	 * @return Returns a new instance of class Class_01_1, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011 getClass011Example() throws DaoException {
	    // fill attributes with example values
	    Class011 class011 = new Class011();
	    class011.setFakeAttr(new Float(725185254.1));
	    
	    Class011END targetExample = new Class011END();
	    class011.setTarget(targetExample);   
	    class011ENDDao.createClass011END(targetExample);
	    
	    return class011;
	}
	
	/**
	 * Creates a second example of Class_01_1 with other values.
	 * @return Returns a new instance of class Class_01_1 with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011 getClass011Example2() throws DaoException {
	    // fill attributes with example values
	    Class011 class011 = new Class011();
		class011.setFakeAttr(new Float(725185254.0));
		
		Class011END targetExample = new Class011END();
		class011.setTarget(targetExample);   
		class011ENDDao.createClass011END(targetExample);
		
	    return class011;
	}
    
    // Start of user code of specific tests
    // End of user code

}
