package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIENDSub;


// End of user code

/**
 * Test class for Class_Many_01_BI_END_Sub.
 */
public class ClassMany01BIENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_01_BI_END_Sub.
	 */
	private IClassMany01BIENDSubDao classMany01BIENDSubDao;
	
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
		classMany01BIENDSubDao = SampleDaoFactory.getInheritanceassociationsClassMany01BIENDSubDao();
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
	 * Tests the creation of the entity Class_Many_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassMany01BIENDSub() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BIENDSub classMany01BIENDSub = getClassMany01BIENDSubExample();
	    
	    // Execute the tested code
	    classMany01BIENDSubDao.createClassMany01BIENDSub(classMany01BIENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BIENDSub currentClassMany01BIENDSub : classMany01BIENDSubDao.findAllClassMany01BIENDSubs()) {
	        if (currentClassMany01BIENDSub.equals(classMany01BIENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_01_BI_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassMany01BIENDSub() throws DaoException {
	    // Initialized the test
	    ClassMany01BIENDSub classMany01BIENDSub = getClassMany01BIENDSubExample();
	    classMany01BIENDSubDao.createClassMany01BIENDSub(classMany01BIENDSub);
	
	    // Execute the tested code
	    classMany01BIENDSubDao.updateClassMany01BIENDSub(classMany01BIENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BIENDSub currentClassMany01BIENDSub : classMany01BIENDSubDao.findAllClassMany01BIENDSubs()) {
	        if (currentClassMany01BIENDSub.equals(classMany01BIENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("ClassMany01BIENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassMany01BIENDSub() throws DaoException {
	    // Initialized the test
	    ClassMany01BIENDSub classMany01BIENDSub = getClassMany01BIENDSubExample();
	    classMany01BIENDSubDao.createClassMany01BIENDSub(classMany01BIENDSub);
	    
	    // Execute the tested code
	    classMany01BIENDSubDao.deleteClassMany01BIENDSub(classMany01BIENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BIENDSub currentClassMany01BIENDSub : classMany01BIENDSubDao.findAllClassMany01BIENDSubs()) {
	        if (currentClassMany01BIENDSub.getId().equals(classMany01BIENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassMany01BIENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_01_BI_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassMany01BIENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = classMany01BIENDSubDao.findAllClassMany01BIENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassMany01BIENDSub classMany01BIENDSub1 = getClassMany01BIENDSubExample();
	    classMany01BIENDSubDao.createClassMany01BIENDSub(classMany01BIENDSub1);
	            
	    ClassMany01BIENDSub classMany01BIENDSub2 = getClassMany01BIENDSubExample();
	    classMany01BIENDSubDao.createClassMany01BIENDSub(classMany01BIENDSub2);
	
	    // Verify result
	    int after = classMany01BIENDSubDao.findAllClassMany01BIENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_01_BI_END_Sub.
	 * @return Returns a new instance of class Class_Many_01_BI_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01BIENDSub getClassMany01BIENDSubExample() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BIENDSub classMany01BIENDSub = new ClassMany01BIENDSub();
	    classMany01BIENDSub.setFakeAttr("myFakeAttr");
	    
	    
	    return classMany01BIENDSub;
	}
	
	/**
	 * Creates a second example of Class_Many_01_BI_END_Sub with other values.
	 * @return Returns a new instance of class Class_Many_01_BI_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01BIENDSub getClassMany01BIENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BIENDSub classMany01BIENDSub = new ClassMany01BIENDSub();
		classMany01BIENDSub.setFakeAttr("secondFakeAttr");
		
		
	    return classMany01BIENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
