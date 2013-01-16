package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBISub;


// End of user code

/**
 * Test class for Class_01_Many_BI_Sub.
 */
public class Class01ManyBISubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_Many_BI_Sub.
	 */
	private IClass01ManyBISubDao class01ManyBISubDao;
	
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
		class01ManyBISubDao = SampleDaoFactory.getInheritanceassociationsClass01ManyBISubDao();
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
	 * Tests the creation of the entity Class_01_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass01ManyBISub() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBISub class01ManyBISub = getClass01ManyBISubExample();
	    
	    // Execute the tested code
	    class01ManyBISubDao.createClass01ManyBISub(class01ManyBISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBISub currentClass01ManyBISub : class01ManyBISubDao.findAllClass01ManyBISubs()) {
	        if (currentClass01ManyBISub.equals(class01ManyBISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_Many_BI_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass01ManyBISub() throws DaoException {
	    // Initialized the test
	    Class01ManyBISub class01ManyBISub = getClass01ManyBISubExample();
	    class01ManyBISubDao.createClass01ManyBISub(class01ManyBISub);
	
	    // Execute the tested code
	    class01ManyBISubDao.updateClass01ManyBISub(class01ManyBISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBISub currentClass01ManyBISub : class01ManyBISubDao.findAllClass01ManyBISubs()) {
	        if (currentClass01ManyBISub.equals(class01ManyBISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class01ManyBISub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass01ManyBISub() throws DaoException {
	    // Initialized the test
	    Class01ManyBISub class01ManyBISub = getClass01ManyBISubExample();
	    class01ManyBISubDao.createClass01ManyBISub(class01ManyBISub);
	    
	    // Execute the tested code
	    class01ManyBISubDao.deleteClass01ManyBISub(class01ManyBISub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class01ManyBISub currentClass01ManyBISub : class01ManyBISubDao.findAllClass01ManyBISubs()) {
	        if (currentClass01ManyBISub.getId().equals(class01ManyBISub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class01ManyBISub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_Many_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass01ManyBISubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class01ManyBISubDao.findAllClass01ManyBISubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class01ManyBISub class01ManyBISub1 = getClass01ManyBISubExample();
	    class01ManyBISubDao.createClass01ManyBISub(class01ManyBISub1);
	            
	    Class01ManyBISub class01ManyBISub2 = getClass01ManyBISubExample();
	    class01ManyBISubDao.createClass01ManyBISub(class01ManyBISub2);
	
	    // Verify result
	    int after = class01ManyBISubDao.findAllClass01ManyBISubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_Many_BI_Sub.
	 * @return Returns a new instance of class Class_01_Many_BI_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyBISub getClass01ManyBISubExample() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBISub class01ManyBISub = new Class01ManyBISub();
	    class01ManyBISub.setFakeAttr("myFakeAttr");
	    
	    
	    return class01ManyBISub;
	}
	
	/**
	 * Creates a second example of Class_01_Many_BI_Sub with other values.
	 * @return Returns a new instance of class Class_01_Many_BI_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class01ManyBISub getClass01ManyBISubExample2() throws DaoException {
	    // fill attributes with example values
	    Class01ManyBISub class01ManyBISub = new Class01ManyBISub();
		class01ManyBISub.setFakeAttr("secondFakeAttr");
		
		
	    return class01ManyBISub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
