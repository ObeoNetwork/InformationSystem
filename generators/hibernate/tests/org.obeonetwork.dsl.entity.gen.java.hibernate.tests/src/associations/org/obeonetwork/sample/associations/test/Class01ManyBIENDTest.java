package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass01ManyBIENDDao;
import org.obeonetwork.sample.associations.Class01ManyBIEND;


// End of user code

/**
 * Test class for Class_01_Many_BI_END.
 */
public class Class01ManyBIENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_Many_BI_END.
	 */
	private IClass01ManyBIENDDao class01ManyBIENDDao;
	
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
		class01ManyBIENDDao = SampleDaoFactory.getAssociationsClass01ManyBIENDDao();
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
	 * Tests the creation of the entity Class_01_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass01ManyBIEND() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBIEND class01ManyBIEND = getClass01ManyBIENDExample();
	    
	    // Execute the tested code
	    class01ManyBIENDDao.createClass01ManyBIEND(class01ManyBIEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBIEND currentClass01ManyBIEND : class01ManyBIENDDao.findAllClass01ManyBIENDs()) {
	        if (currentClass01ManyBIEND.equals(class01ManyBIEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_Many_BI_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass01ManyBIEND() throws DaoException {
	    // Initialized the test
	    Class01ManyBIEND class01ManyBIEND = getClass01ManyBIENDExample();
	    class01ManyBIENDDao.createClass01ManyBIEND(class01ManyBIEND);
	
	    // Execute the tested code
	    class01ManyBIEND.setFakeAttr(new Integer(725185254));
	    class01ManyBIENDDao.updateClass01ManyBIEND(class01ManyBIEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBIEND currentClass01ManyBIEND : class01ManyBIENDDao.findAllClass01ManyBIENDs()) {
	        if (currentClass01ManyBIEND.equals(class01ManyBIEND)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Integer(725185254),
	                    class01ManyBIEND.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class01ManyBIEND not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass01ManyBIEND() throws DaoException {
	    // Initialized the test
	    Class01ManyBIEND class01ManyBIEND = getClass01ManyBIENDExample();
	    class01ManyBIENDDao.createClass01ManyBIEND(class01ManyBIEND);
	    
	    // Execute the tested code
	    class01ManyBIENDDao.deleteClass01ManyBIEND(class01ManyBIEND);
	    
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBIEND currentClass01ManyBIEND : class01ManyBIENDDao.findAllClass01ManyBIENDs()) {
	        if (currentClass01ManyBIEND.getId().equals(class01ManyBIEND.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class01ManyBIEND not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass01ManyBIENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = class01ManyBIENDDao.findAllClass01ManyBIENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class01ManyBIEND class01ManyBIEND1 = getClass01ManyBIENDExample();
	    class01ManyBIENDDao.createClass01ManyBIEND(class01ManyBIEND1);
	            
	    Class01ManyBIEND class01ManyBIEND2 = getClass01ManyBIENDExample();
	    class01ManyBIENDDao.createClass01ManyBIEND(class01ManyBIEND2);
	
	    // Verify result
	    int after = class01ManyBIENDDao.findAllClass01ManyBIENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_Many_BI_END.
	 * @return Returns a new instance of class Class_01_Many_BI_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyBIEND getClass01ManyBIENDExample() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBIEND class01ManyBIEND = new Class01ManyBIEND();
	    class01ManyBIEND.setFakeAttr(new Integer(725185254 + 1));
	    
	    
	    return class01ManyBIEND;
	}
	
	/**
	 * Creates a second example of Class_01_Many_BI_END with other values.
	 * @return Returns a new instance of class Class_01_Many_BI_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyBIEND getClass01ManyBIENDExample2() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBIEND class01ManyBIEND = new Class01ManyBIEND();
		class01ManyBIEND.setFakeAttr(new Integer(725185254));
		
		
	    return class01ManyBIEND;
	}
    
    // Start of user code of specific tests
    // End of user code

}
