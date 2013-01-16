package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao;
import org.obeonetwork.sample.inheritanceassociations.Class11END;


// End of user code

/**
 * Test class for Class_1_1_END.
 */
public class Class11ENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_1_END.
	 */
	private IClass11ENDDao class11ENDDao;
	
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
	 * Tests the creation of the entity Class_1_1_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass11END() throws DaoException {
	    // fill attributes with example values
	    Class11END class11END = getClass11ENDExample();
	    
	    // Execute the tested code
	    class11ENDDao.createClass11END(class11END);
	
	    // Verify result
	    boolean found = false;
	    for (Class11END currentClass11END : class11ENDDao.findAllClass11ENDs()) {
	        if (currentClass11END.equals(class11END)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_1_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_1_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass11END() throws DaoException {
	    // Initialized the test
	    Class11END class11END = getClass11ENDExample();
	    class11ENDDao.createClass11END(class11END);
	
	    // Execute the tested code
	    class11END.setFakeAttr("secondFakeAttr");
	    class11ENDDao.updateClass11END(class11END);
	
	    // Verify result
	    boolean found = false;
	    for (Class11END currentClass11END : class11ENDDao.findAllClass11ENDs()) {
	        if (currentClass11END.equals(class11END)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    "secondFakeAttr",
	                    class11END.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class11END not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_1_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass11END() throws DaoException {
	    // Initialized the test
	    Class11END class11END = getClass11ENDExample();
	    class11ENDDao.createClass11END(class11END);
	    
	    // Execute the tested code
	    class11ENDDao.deleteClass11END(class11END);
	    
	    // Verify result
	    boolean found = false;
	    for (Class11END currentClass11END : class11ENDDao.findAllClass11ENDs()) {
	        if (currentClass11END.getId().equals(class11END.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class11END not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_1_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass11ENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = class11ENDDao.findAllClass11ENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class11END class11END1 = getClass11ENDExample();
	    class11ENDDao.createClass11END(class11END1);
	            
	    Class11END class11END2 = getClass11ENDExample();
	    class11ENDDao.createClass11END(class11END2);
	
	    // Verify result
	    int after = class11ENDDao.findAllClass11ENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_1_END.
	 * @return Returns a new instance of class Class_1_1_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11END getClass11ENDExample() throws DaoException {
	    // fill attributes with example values
	    Class11END class11END = new Class11END();
	    class11END.setFakeAttr("myFakeAttr");
	    
	    
	    return class11END;
	}
	
	/**
	 * Creates a second example of Class_1_1_END with other values.
	 * @return Returns a new instance of class Class_1_1_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11END getClass11ENDExample2() throws DaoException {
	    // fill attributes with example values
	    Class11END class11END = new Class11END();
		class11END.setFakeAttr("secondFakeAttr");
		
		
	    return class11END;
	}
    
    // Start of user code of specific tests
    // End of user code

}
