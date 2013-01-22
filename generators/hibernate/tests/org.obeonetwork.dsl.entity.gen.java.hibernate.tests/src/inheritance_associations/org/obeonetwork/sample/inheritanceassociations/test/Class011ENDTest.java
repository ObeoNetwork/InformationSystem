package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao;
import org.obeonetwork.sample.inheritanceassociations.Class011END;


// End of user code

/**
 * Test class for Class_01_1_END.
 */
public class Class011ENDTest extends TestCase {
	
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
		class011ENDDao = SampleDaoFactory.getInheritanceassociationsClass011ENDDao();
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
	 * Tests the creation of the entity Class_01_1_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass011END() throws DaoException {
	    // fill attributes with example values
	    Class011END class011END = getClass011ENDExample();
	    
	    // Execute the tested code
	    class011ENDDao.createClass011END(class011END);
	
	    // Verify result
	    boolean found = false;
	    for (Class011END currentClass011END : class011ENDDao.findAllClass011ENDs()) {
	        if (currentClass011END.equals(class011END)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_1_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_1_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass011END() throws DaoException {
	    // Initialized the test
	    Class011END class011END = getClass011ENDExample();
	    class011ENDDao.createClass011END(class011END);
	
	    // Execute the tested code
	    class011END.setFakeAttr("secondFakeAttr");
	    class011ENDDao.updateClass011END(class011END);
	
	    // Verify result
	    boolean found = false;
	    for (Class011END currentClass011END : class011ENDDao.findAllClass011ENDs()) {
	        if (currentClass011END.equals(class011END)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    "secondFakeAttr",
	                    class011END.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class011END not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_1_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass011END() throws DaoException {
	    // Initialized the test
	    Class011END class011END = getClass011ENDExample();
	    class011ENDDao.createClass011END(class011END);
	    
	    // Execute the tested code
	    class011ENDDao.deleteClass011END(class011END);
	    
	    // Verify result
	    boolean found = false;
	    for (Class011END currentClass011END : class011ENDDao.findAllClass011ENDs()) {
	        if (currentClass011END.getId().equals(class011END.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class011END not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_1_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass011ENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = class011ENDDao.findAllClass011ENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class011END class011END1 = getClass011ENDExample();
	    class011ENDDao.createClass011END(class011END1);
	            
	    Class011END class011END2 = getClass011ENDExample();
	    class011ENDDao.createClass011END(class011END2);
	
	    // Verify result
	    int after = class011ENDDao.findAllClass011ENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_1_END.
	 * @return Returns a new instance of class Class_01_1_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011END getClass011ENDExample() throws DaoException {
	    // fill attributes with example values
	    Class011END class011END = new Class011END();
	    class011END.setFakeAttr("myFakeAttr");
	    
	    
	    return class011END;
	}
	
	/**
	 * Creates a second example of Class_01_1_END with other values.
	 * @return Returns a new instance of class Class_01_1_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011END getClass011ENDExample2() throws DaoException {
	    // fill attributes with example values
	    Class011END class011END = new Class011END();
		class011END.setFakeAttr("secondFakeAttr");
		
		
	    return class011END;
	}
    
    // Start of user code of specific tests
    // End of user code

}
