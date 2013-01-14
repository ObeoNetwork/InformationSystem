package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass0101BIENDDao;
import org.obeonetwork.sample.associations.Class0101BIEND;


// End of user code

/**
 * Test class for Class_01_01_BI_END.
 */
public class Class0101BIENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_01_BI_END.
	 */
	private IClass0101BIENDDao class0101BIENDDao;
	
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
		class0101BIENDDao = SampleDaoFactory.getAssociationsClass0101BIENDDao();
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
	 * Tests the creation of the entity Class_01_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass0101BIEND() throws DaoException {
	    // fill attributes with example values
	    Class0101BIEND class0101BIEND = getClass0101BIENDExample();
	    
	    // Execute the tested code
	    class0101BIENDDao.createClass0101BIEND(class0101BIEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101BIEND currentClass0101BIEND : class0101BIENDDao.findAllClass0101BIENDs()) {
	        if (currentClass0101BIEND.equals(class0101BIEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_01_BI_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass0101BIEND() throws DaoException {
	    // Initialized the test
	    Class0101BIEND class0101BIEND = getClass0101BIENDExample();
	    class0101BIENDDao.createClass0101BIEND(class0101BIEND);
	
	    // Execute the tested code
	    class0101BIEND.setFakeAttr(new Integer(725185254));
	    class0101BIENDDao.updateClass0101BIEND(class0101BIEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101BIEND currentClass0101BIEND : class0101BIENDDao.findAllClass0101BIENDs()) {
	        if (currentClass0101BIEND.equals(class0101BIEND)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Integer(725185254),
	                    class0101BIEND.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("Class0101BIEND not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass0101BIEND() throws DaoException {
	    // Initialized the test
	    Class0101BIEND class0101BIEND = getClass0101BIENDExample();
	    class0101BIENDDao.createClass0101BIEND(class0101BIEND);
	    
	    // Execute the tested code
	    class0101BIENDDao.deleteClass0101BIEND(class0101BIEND);
	    
	    // Verify result
	    boolean found = false;
	    for (Class0101BIEND currentClass0101BIEND : class0101BIENDDao.findAllClass0101BIENDs()) {
	        if (currentClass0101BIEND.getId().equals(class0101BIEND.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class0101BIEND not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass0101BIENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = class0101BIENDDao.findAllClass0101BIENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class0101BIEND class0101BIEND1 = getClass0101BIENDExample();
	    class0101BIENDDao.createClass0101BIEND(class0101BIEND1);
	            
	    Class0101BIEND class0101BIEND2 = getClass0101BIENDExample();
	    class0101BIENDDao.createClass0101BIEND(class0101BIEND2);
	
	    // Verify result
	    int after = class0101BIENDDao.findAllClass0101BIENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_01_BI_END.
	 * @return Returns a new instance of class Class_01_01_BI_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101BIEND getClass0101BIENDExample() throws DaoException {
	    // fill attributes with example values
	    Class0101BIEND class0101BIEND = new Class0101BIEND();
	    class0101BIEND.setFakeAttr(new Integer(725185254 + 1));
	    
	    
	    return class0101BIEND;
	}
	
	/**
	 * Creates a second example of Class_01_01_BI_END with other values.
	 * @return Returns a new instance of class Class_01_01_BI_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101BIEND getClass0101BIENDExample2() throws DaoException {
	    // fill attributes with example values
	    Class0101BIEND class0101BIEND = new Class0101BIEND();
		class0101BIEND.setFakeAttr(new Integer(725185254));
		
		
	    return class0101BIEND;
	}
    
    // Start of user code of specific tests
    // End of user code

}
