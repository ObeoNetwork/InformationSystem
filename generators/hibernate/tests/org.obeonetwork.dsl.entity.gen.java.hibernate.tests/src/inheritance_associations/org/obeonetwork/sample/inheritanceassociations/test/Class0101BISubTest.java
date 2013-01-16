package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101BISub;


// End of user code

/**
 * Test class for Class_01_01_BI_Sub.
 */
public class Class0101BISubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_01_BI_Sub.
	 */
	private IClass0101BISubDao class0101BISubDao;
	
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
		class0101BISubDao = SampleDaoFactory.getInheritanceassociationsClass0101BISubDao();
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
	 * Tests the creation of the entity Class_01_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass0101BISub() throws DaoException {
	    // fill attributes with example values
	    Class0101BISub class0101BISub = getClass0101BISubExample();
	    
	    // Execute the tested code
	    class0101BISubDao.createClass0101BISub(class0101BISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101BISub currentClass0101BISub : class0101BISubDao.findAllClass0101BISubs()) {
	        if (currentClass0101BISub.equals(class0101BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_01_BI_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass0101BISub() throws DaoException {
	    // Initialized the test
	    Class0101BISub class0101BISub = getClass0101BISubExample();
	    class0101BISubDao.createClass0101BISub(class0101BISub);
	
	    // Execute the tested code
	    class0101BISubDao.updateClass0101BISub(class0101BISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class0101BISub currentClass0101BISub : class0101BISubDao.findAllClass0101BISubs()) {
	        if (currentClass0101BISub.equals(class0101BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class0101BISub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass0101BISub() throws DaoException {
	    // Initialized the test
	    Class0101BISub class0101BISub = getClass0101BISubExample();
	    class0101BISubDao.createClass0101BISub(class0101BISub);
	    
	    // Execute the tested code
	    class0101BISubDao.deleteClass0101BISub(class0101BISub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class0101BISub currentClass0101BISub : class0101BISubDao.findAllClass0101BISubs()) {
	        if (currentClass0101BISub.getId().equals(class0101BISub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class0101BISub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_01_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass0101BISubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class0101BISubDao.findAllClass0101BISubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class0101BISub class0101BISub1 = getClass0101BISubExample();
	    class0101BISubDao.createClass0101BISub(class0101BISub1);
	            
	    Class0101BISub class0101BISub2 = getClass0101BISubExample();
	    class0101BISubDao.createClass0101BISub(class0101BISub2);
	
	    // Verify result
	    int after = class0101BISubDao.findAllClass0101BISubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_01_BI_Sub.
	 * @return Returns a new instance of class Class_01_01_BI_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101BISub getClass0101BISubExample() throws DaoException {
	    // fill attributes with example values
	    Class0101BISub class0101BISub = new Class0101BISub();
	    class0101BISub.setFakeAttr("myFakeAttr");
	    
	    
	    return class0101BISub;
	}
	
	/**
	 * Creates a second example of Class_01_01_BI_Sub with other values.
	 * @return Returns a new instance of class Class_01_01_BI_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class0101BISub getClass0101BISubExample2() throws DaoException {
	    // fill attributes with example values
	    Class0101BISub class0101BISub = new Class0101BISub();
		class0101BISub.setFakeAttr("secondFakeAttr");
		
		
	    return class0101BISub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
