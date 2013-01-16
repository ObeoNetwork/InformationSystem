package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao;
import org.obeonetwork.sample.inheritanceassociations.Class11BISub;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao;
// End of user code

/**
 * Test class for Class_1_1_BI_Sub.
 */
public class Class11BISubTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_1_BI_END.
	 */
	private IClass11BIENDDao class11BIENDDao;
	
	/**
	 * The DAO for class Class_1_1_BI_Sub.
	 */
	private IClass11BISubDao class11BISubDao;
	
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
		class11BIENDDao = SampleDaoFactory.getInheritanceassociationsClass11BIENDDao();
		class11BISubDao = SampleDaoFactory.getInheritanceassociationsClass11BISubDao();
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
	 * Tests the creation of the entity Class_1_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass11BISub() throws DaoException {
	    // fill attributes with example values
	    Class11BISub class11BISub = getClass11BISubExample();
	    
	    // Execute the tested code
	    class11BISubDao.createClass11BISub(class11BISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class11BISub currentClass11BISub : class11BISubDao.findAllClass11BISubs()) {
	        if (currentClass11BISub.equals(class11BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_1_BI_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass11BISub() throws DaoException {
	    // Initialized the test
	    Class11BISub class11BISub = getClass11BISubExample();
	    class11BISubDao.createClass11BISub(class11BISub);
	
	    // Execute the tested code
	    class11BISubDao.updateClass11BISub(class11BISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class11BISub currentClass11BISub : class11BISubDao.findAllClass11BISubs()) {
	        if (currentClass11BISub.equals(class11BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class11BISub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass11BISub() throws DaoException {
	    // Initialized the test
	    Class11BISub class11BISub = getClass11BISubExample();
	    class11BISubDao.createClass11BISub(class11BISub);
	    
	    // Execute the tested code
	    class11BISubDao.deleteClass11BISub(class11BISub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class11BISub currentClass11BISub : class11BISubDao.findAllClass11BISubs()) {
	        if (currentClass11BISub.getId().equals(class11BISub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class11BISub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass11BISubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class11BISubDao.findAllClass11BISubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class11BISub class11BISub1 = getClass11BISubExample();
	    class11BISubDao.createClass11BISub(class11BISub1);
	            
	    Class11BISub class11BISub2 = getClass11BISubExample();
	    class11BISubDao.createClass11BISub(class11BISub2);
	
	    // Verify result
	    int after = class11BISubDao.findAllClass11BISubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_1_BI_Sub.
	 * @return Returns a new instance of class Class_1_1_BI_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11BISub getClass11BISubExample() throws DaoException {
	    // fill attributes with example values
	    Class11BISub class11BISub = new Class11BISub();
	    class11BISub.setFakeAttr("myFakeAttr");
	    
	    Class11BIEND targetExample = new Class11BIEND();
	    class11BISub.setTarget(targetExample);   
	    targetExample.setSource(class11BISub); 
	    class11BIENDDao.createClass11BIEND(targetExample);
	    
	    return class11BISub;
	}
	
	/**
	 * Creates a second example of Class_1_1_BI_Sub with other values.
	 * @return Returns a new instance of class Class_1_1_BI_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class11BISub getClass11BISubExample2() throws DaoException {
	    // fill attributes with example values
	    Class11BISub class11BISub = new Class11BISub();
		class11BISub.setFakeAttr("secondFakeAttr");
		
		Class11BIEND targetExample = new Class11BIEND();
		class11BISub.setTarget(targetExample);   
		targetExample.setSource(class11BISub); 
		class11BIENDDao.createClass11BIEND(targetExample);
		
	    return class11BISub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
