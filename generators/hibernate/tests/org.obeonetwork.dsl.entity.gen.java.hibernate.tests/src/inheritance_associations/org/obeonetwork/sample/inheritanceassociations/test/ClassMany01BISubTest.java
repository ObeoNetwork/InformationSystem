package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BISub;


// End of user code

/**
 * Test class for Class_Many_01_BI_Sub.
 */
public class ClassMany01BISubTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_01_BI_Sub.
	 */
	private IClassMany01BISubDao classMany01BISubDao;
	
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
		classMany01BISubDao = SampleDaoFactory.getInheritanceassociationsClassMany01BISubDao();
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
	 * Tests the creation of the entity Class_Many_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassMany01BISub() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BISub classMany01BISub = getClassMany01BISubExample();
	    
	    // Execute the tested code
	    classMany01BISubDao.createClassMany01BISub(classMany01BISub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BISub currentClassMany01BISub : classMany01BISubDao.findAllClassMany01BISubs()) {
	        if (currentClassMany01BISub.equals(classMany01BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_01_BI_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassMany01BISub() throws DaoException {
	    // Initialized the test
	    ClassMany01BISub classMany01BISub = getClassMany01BISubExample();
	    classMany01BISubDao.createClassMany01BISub(classMany01BISub);
	
	    // Execute the tested code
	    classMany01BISubDao.updateClassMany01BISub(classMany01BISub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BISub currentClassMany01BISub : classMany01BISubDao.findAllClassMany01BISubs()) {
	        if (currentClassMany01BISub.equals(classMany01BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("ClassMany01BISub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassMany01BISub() throws DaoException {
	    // Initialized the test
	    ClassMany01BISub classMany01BISub = getClassMany01BISubExample();
	    classMany01BISubDao.createClassMany01BISub(classMany01BISub);
	    
	    // Execute the tested code
	    classMany01BISubDao.deleteClassMany01BISub(classMany01BISub);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassMany01BISub currentClassMany01BISub : classMany01BISubDao.findAllClassMany01BISubs()) {
	        if (currentClassMany01BISub.getId().equals(classMany01BISub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassMany01BISub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassMany01BISubs() throws DaoException {
	    // Verify number of element before testing
	    int before = classMany01BISubDao.findAllClassMany01BISubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassMany01BISub classMany01BISub1 = getClassMany01BISubExample();
	    classMany01BISubDao.createClassMany01BISub(classMany01BISub1);
	            
	    ClassMany01BISub classMany01BISub2 = getClassMany01BISubExample();
	    classMany01BISubDao.createClassMany01BISub(classMany01BISub2);
	
	    // Verify result
	    int after = classMany01BISubDao.findAllClassMany01BISubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_01_BI_Sub.
	 * @return Returns a new instance of class Class_Many_01_BI_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01BISub getClassMany01BISubExample() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BISub classMany01BISub = new ClassMany01BISub();
	    classMany01BISub.setFakeAttr("myFakeAttr");
	    
	    
	    return classMany01BISub;
	}
	
	/**
	 * Creates a second example of Class_Many_01_BI_Sub with other values.
	 * @return Returns a new instance of class Class_Many_01_BI_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01BISub getClassMany01BISubExample2() throws DaoException {
	    // fill attributes with example values
	    ClassMany01BISub classMany01BISub = new ClassMany01BISub();
		classMany01BISub.setFakeAttr("secondFakeAttr");
		
		
	    return classMany01BISub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
