package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClassMany01BIENDDao;
import org.obeonetwork.sample.associations.ClassMany01BIEND;


// End of user code

/**
 * Test class for Class_Many_01_BI_END.
 */
public class ClassMany01BIENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_01_BI_END.
	 */
	private IClassMany01BIENDDao classMany01BIENDDao;
	
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
		classMany01BIENDDao = SampleDaoFactory.getAssociationsClass_Many_01_BI_ENDClassMany01BIENDDao();
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
	 * Tests the creation of the entity Class_Many_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassMany01BIEND() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BIEND classMany01BIEND = getClassMany01BIENDExample();
	    
	    // Execute the tested code
	    classMany01BIENDDao.createClassMany01BIEND(classMany01BIEND);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BIEND currentClassMany01BIEND : classMany01BIENDDao.findAllClassMany01BIENDs()) {
	        if (currentClassMany01BIEND.equals(classMany01BIEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_01_BI_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassMany01BIEND() throws DaoException {
	    // Initialized the test
	    ClassMany01BIEND classMany01BIEND = getClassMany01BIENDExample();
	    classMany01BIENDDao.createClassMany01BIEND(classMany01BIEND);
	
	    // Execute the tested code
	    classMany01BIEND.setFakeAttr(new Integer(725185254));
	    classMany01BIENDDao.updateClassMany01BIEND(classMany01BIEND);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BIEND currentClassMany01BIEND : classMany01BIENDDao.findAllClassMany01BIENDs()) {
	        if (currentClassMany01BIEND.equals(classMany01BIEND)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Integer(725185254),
	                    classMany01BIEND.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("ClassMany01BIEND not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassMany01BIEND() throws DaoException {
	    // Initialized the test
	    ClassMany01BIEND classMany01BIEND = getClassMany01BIENDExample();
	    classMany01BIENDDao.createClassMany01BIEND(classMany01BIEND);
	    
	    // Execute the tested code
	    classMany01BIENDDao.deleteClassMany01BIEND(classMany01BIEND);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BIEND currentClassMany01BIEND : classMany01BIENDDao.findAllClassMany01BIENDs()) {
	        if (currentClassMany01BIEND.getId().equals(classMany01BIEND.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassMany01BIEND not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassMany01BIENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = classMany01BIENDDao.findAllClassMany01BIENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassMany01BIEND classMany01BIEND1 = getClassMany01BIENDExample();
	    classMany01BIENDDao.createClassMany01BIEND(classMany01BIEND1);
	            
	    ClassMany01BIEND classMany01BIEND2 = getClassMany01BIENDExample();
	    classMany01BIENDDao.createClassMany01BIEND(classMany01BIEND2);
	
	    // Verify result
	    int after = classMany01BIENDDao.findAllClassMany01BIENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_01_BI_END.
	 * @return Returns a new instance of class Class_Many_01_BI_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01BIEND getClassMany01BIENDExample() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BIEND classMany01BIEND = new ClassMany01BIEND();
	    classMany01BIEND.setFakeAttr(new Integer(725185254 + 1));
	    
	    
	    return classMany01BIEND;
	}
	
	/**
	 * Creates a second example of Class_Many_01_BI_END with other values.
	 * @return Returns a new instance of class Class_Many_01_BI_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01BIEND getClassMany01BIENDExample2() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BIEND classMany01BIEND = new ClassMany01BIEND();
		classMany01BIEND.setFakeAttr(new Integer(725185254));
		
		
	    return classMany01BIEND;
	}
    
    // Start of user code of specific tests
    // End of user code

}
