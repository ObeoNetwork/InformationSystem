package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBISub;


// End of user code

/**
 * Test class for Class_Many_Many_BI_Sub.
 */
public class ClassManyManyBISubTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_Many_BI_Sub.
	 */
	private IClassManyManyBISubDao classManyManyBISubDao;
	
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
		classManyManyBISubDao = SampleDaoFactory.getInheritanceassociationsClassManyManyBISubDao();
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
	 * Tests the creation of the entity Class_Many_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassManyManyBISub() throws DaoException {
	    // fill attributes with example values
	    ClassManyManyBISub classManyManyBISub = getClassManyManyBISubExample();
	    
	    // Execute the tested code
	    classManyManyBISubDao.createClassManyManyBISub(classManyManyBISub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassManyManyBISub currentClassManyManyBISub : classManyManyBISubDao.findAllClassManyManyBISubs()) {
	        if (currentClassManyManyBISub.equals(classManyManyBISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_Many_BI_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassManyManyBISub() throws DaoException {
	    // Initialized the test
	    ClassManyManyBISub classManyManyBISub = getClassManyManyBISubExample();
	    classManyManyBISubDao.createClassManyManyBISub(classManyManyBISub);
	
	    // Execute the tested code
	    classManyManyBISubDao.updateClassManyManyBISub(classManyManyBISub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassManyManyBISub currentClassManyManyBISub : classManyManyBISubDao.findAllClassManyManyBISubs()) {
	        if (currentClassManyManyBISub.equals(classManyManyBISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("ClassManyManyBISub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassManyManyBISub() throws DaoException {
	    // Initialized the test
	    ClassManyManyBISub classManyManyBISub = getClassManyManyBISubExample();
	    classManyManyBISubDao.createClassManyManyBISub(classManyManyBISub);
	    
	    // Execute the tested code
	    classManyManyBISubDao.deleteClassManyManyBISub(classManyManyBISub);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassManyManyBISub currentClassManyManyBISub : classManyManyBISubDao.findAllClassManyManyBISubs()) {
	        if (currentClassManyManyBISub.getId().equals(classManyManyBISub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassManyManyBISub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassManyManyBISubs() throws DaoException {
	    // Verify number of element before testing
	    int before = classManyManyBISubDao.findAllClassManyManyBISubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassManyManyBISub classManyManyBISub1 = getClassManyManyBISubExample();
	    classManyManyBISubDao.createClassManyManyBISub(classManyManyBISub1);
	            
	    ClassManyManyBISub classManyManyBISub2 = getClassManyManyBISubExample();
	    classManyManyBISubDao.createClassManyManyBISub(classManyManyBISub2);
	
	    // Verify result
	    int after = classManyManyBISubDao.findAllClassManyManyBISubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_Many_BI_Sub.
	 * @return Returns a new instance of class Class_Many_Many_BI_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassManyManyBISub getClassManyManyBISubExample() throws DaoException {
	    // fill attributes with example values
	    ClassManyManyBISub classManyManyBISub = new ClassManyManyBISub();
	    classManyManyBISub.setFakeAttr("myFakeAttr");
	    
	    
	    return classManyManyBISub;
	}
	
	/**
	 * Creates a second example of Class_Many_Many_BI_Sub with other values.
	 * @return Returns a new instance of class Class_Many_Many_BI_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassManyManyBISub getClassManyManyBISubExample2() throws DaoException {
	    // fill attributes with example values
	    ClassManyManyBISub classManyManyBISub = new ClassManyManyBISub();
		classManyManyBISub.setFakeAttr("secondFakeAttr");
		
		
	    return classManyManyBISub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
