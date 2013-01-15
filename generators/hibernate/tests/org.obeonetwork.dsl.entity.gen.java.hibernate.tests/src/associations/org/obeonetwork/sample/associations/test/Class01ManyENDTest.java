package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass01ManyENDDao;
import org.obeonetwork.sample.associations.Class01ManyEND;


// End of user code

/**
 * Test class for Class_01_Many_END.
 */
public class Class01ManyENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_Many_END.
	 */
	private IClass01ManyENDDao class01ManyENDDao;
	
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
		class01ManyENDDao = SampleDaoFactory.getAssociationsClass01ManyENDDao();
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
	 * Tests the creation of the entity Class_01_Many_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass01ManyEND() throws DaoException {
	    // fill attributes with example values
	    Class01ManyEND class01ManyEND = getClass01ManyENDExample();
	    
	    // Execute the tested code
	    class01ManyENDDao.createClass01ManyEND(class01ManyEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyEND currentClass01ManyEND : class01ManyENDDao.findAllClass01ManyENDs()) {
	        if (currentClass01ManyEND.equals(class01ManyEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_Many_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_Many_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass01ManyEND() throws DaoException {
	    // Initialized the test
	    Class01ManyEND class01ManyEND = getClass01ManyENDExample();
	    class01ManyENDDao.createClass01ManyEND(class01ManyEND);
	
	    // Execute the tested code
	    class01ManyEND.setFakeAttr(new Float(725185254.0));
	    class01ManyENDDao.updateClass01ManyEND(class01ManyEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyEND currentClass01ManyEND : class01ManyENDDao.findAllClass01ManyENDs()) {
	        if (currentClass01ManyEND.equals(class01ManyEND)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Float(725185254.0),
	                    class01ManyEND.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class01ManyEND not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_Many_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass01ManyEND() throws DaoException {
	    // Initialized the test
	    Class01ManyEND class01ManyEND = getClass01ManyENDExample();
	    class01ManyENDDao.createClass01ManyEND(class01ManyEND);
	    
	    // Execute the tested code
	    class01ManyENDDao.deleteClass01ManyEND(class01ManyEND);
	    
	    // Verify result
	    boolean found = false;
	    for (Class01ManyEND currentClass01ManyEND : class01ManyENDDao.findAllClass01ManyENDs()) {
	        if (currentClass01ManyEND.getId().equals(class01ManyEND.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class01ManyEND not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_Many_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass01ManyENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = class01ManyENDDao.findAllClass01ManyENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class01ManyEND class01ManyEND1 = getClass01ManyENDExample();
	    class01ManyENDDao.createClass01ManyEND(class01ManyEND1);
	            
	    Class01ManyEND class01ManyEND2 = getClass01ManyENDExample();
	    class01ManyENDDao.createClass01ManyEND(class01ManyEND2);
	
	    // Verify result
	    int after = class01ManyENDDao.findAllClass01ManyENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_Many_END.
	 * @return Returns a new instance of class Class_01_Many_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyEND getClass01ManyENDExample() throws DaoException {
	    // fill attributes with example values
	    Class01ManyEND class01ManyEND = new Class01ManyEND();
	    class01ManyEND.setFakeAttr(new Float(725185254.1));
	    
	    
	    return class01ManyEND;
	}
	
	/**
	 * Creates a second example of Class_01_Many_END with other values.
	 * @return Returns a new instance of class Class_01_Many_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyEND getClass01ManyENDExample2() throws DaoException {
	    // fill attributes with example values
	    Class01ManyEND class01ManyEND = new Class01ManyEND();
		class01ManyEND.setFakeAttr(new Float(725185254.0));
		
		
	    return class01ManyEND;
	}
    
    // Start of user code of specific tests
    // End of user code

}
