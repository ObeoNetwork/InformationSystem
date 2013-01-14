package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClassManyManyBIENDDao;
import org.obeonetwork.sample.associations.ClassManyManyBIEND;


// End of user code

/**
 * Test class for Class_Many_Many_BI_END.
 */
public class ClassManyManyBIENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_Many_BI_END.
	 */
	private IClassManyManyBIENDDao classManyManyBIENDDao;
	
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
		classManyManyBIENDDao = SampleDaoFactory.getAssociationsClassManyManyBIENDDao();
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
	 * Tests the creation of the entity Class_Many_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassManyManyBIEND() throws DaoException {
	    // fill attributes with example values
	    ClassManyManyBIEND classManyManyBIEND = getClassManyManyBIENDExample();
	    
	    // Execute the tested code
	    classManyManyBIENDDao.createClassManyManyBIEND(classManyManyBIEND);
	
	    // Verify result
	    boolean found = false;
	    for (ClassManyManyBIEND currentClassManyManyBIEND : classManyManyBIENDDao.findAllClassManyManyBIENDs()) {
	        if (currentClassManyManyBIEND.equals(classManyManyBIEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_Many_BI_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassManyManyBIEND() throws DaoException {
	    // Initialized the test
	    ClassManyManyBIEND classManyManyBIEND = getClassManyManyBIENDExample();
	    classManyManyBIENDDao.createClassManyManyBIEND(classManyManyBIEND);
	
	    // Execute the tested code
	    classManyManyBIEND.setFakeAttr(new Double(725185254.0));
	    classManyManyBIENDDao.updateClassManyManyBIEND(classManyManyBIEND);
	
	    // Verify result
	    boolean found = false;
	    for (ClassManyManyBIEND currentClassManyManyBIEND : classManyManyBIENDDao.findAllClassManyManyBIENDs()) {
	        if (currentClassManyManyBIEND.equals(classManyManyBIEND)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Double(725185254.0),
	                    classManyManyBIEND.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("ClassManyManyBIEND not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassManyManyBIEND() throws DaoException {
	    // Initialized the test
	    ClassManyManyBIEND classManyManyBIEND = getClassManyManyBIENDExample();
	    classManyManyBIENDDao.createClassManyManyBIEND(classManyManyBIEND);
	    
	    // Execute the tested code
	    classManyManyBIENDDao.deleteClassManyManyBIEND(classManyManyBIEND);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassManyManyBIEND currentClassManyManyBIEND : classManyManyBIENDDao.findAllClassManyManyBIENDs()) {
	        if (currentClassManyManyBIEND.getId().equals(classManyManyBIEND.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassManyManyBIEND not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_Many_BI_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassManyManyBIENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = classManyManyBIENDDao.findAllClassManyManyBIENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassManyManyBIEND classManyManyBIEND1 = getClassManyManyBIENDExample();
	    classManyManyBIENDDao.createClassManyManyBIEND(classManyManyBIEND1);
	            
	    ClassManyManyBIEND classManyManyBIEND2 = getClassManyManyBIENDExample();
	    classManyManyBIENDDao.createClassManyManyBIEND(classManyManyBIEND2);
	
	    // Verify result
	    int after = classManyManyBIENDDao.findAllClassManyManyBIENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_Many_BI_END.
	 * @return Returns a new instance of class Class_Many_Many_BI_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassManyManyBIEND getClassManyManyBIENDExample() throws DaoException {
	    // fill attributes with example values
	    ClassManyManyBIEND classManyManyBIEND = new ClassManyManyBIEND();
	    classManyManyBIEND.setFakeAttr(new Double(725185254.1));
	    
	    
	    return classManyManyBIEND;
	}
	
	/**
	 * Creates a second example of Class_Many_Many_BI_END with other values.
	 * @return Returns a new instance of class Class_Many_Many_BI_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassManyManyBIEND getClassManyManyBIENDExample2() throws DaoException {
	    // fill attributes with example values
	    ClassManyManyBIEND classManyManyBIEND = new ClassManyManyBIEND();
		classManyManyBIEND.setFakeAttr(new Double(725185254.0));
		
		
	    return classManyManyBIEND;
	}
    
    // Start of user code of specific tests
    // End of user code

}
