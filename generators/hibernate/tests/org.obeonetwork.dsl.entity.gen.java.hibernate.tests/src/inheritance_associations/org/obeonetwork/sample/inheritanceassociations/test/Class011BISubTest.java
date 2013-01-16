package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao;
import org.obeonetwork.sample.inheritanceassociations.Class011BISub;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;
import org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao;
// End of user code

/**
 * Test class for Class_01_1_BI_Sub.
 */
public class Class011BISubTest extends TestCase {
	
	/**
	 * The DAO for class Class_01_1_BI_END.
	 */
	private IClass011BIENDDao class011BIENDDao;
	
	/**
	 * The DAO for class Class_01_1_BI_Sub.
	 */
	private IClass011BISubDao class011BISubDao;
	
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
		class011BIENDDao = SampleDaoFactory.getInheritanceassociationsClass011BIENDDao();
		class011BISubDao = SampleDaoFactory.getInheritanceassociationsClass011BISubDao();
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
	 * Tests the creation of the entity Class_01_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass011BISub() throws DaoException {
	    // fill attributes with example values
	    Class011BISub class011BISub = getClass011BISubExample();
	    
	    // Execute the tested code
	    class011BISubDao.createClass011BISub(class011BISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class011BISub currentClass011BISub : class011BISubDao.findAllClass011BISubs()) {
	        if (currentClass011BISub.equals(class011BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_01_1_BI_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_01_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass011BISub() throws DaoException {
	    // Initialized the test
	    Class011BISub class011BISub = getClass011BISubExample();
	    class011BISubDao.createClass011BISub(class011BISub);
	
	    // Execute the tested code
	    class011BISubDao.updateClass011BISub(class011BISub);
	
	    // Verify result
	    boolean found = false;
	    for (Class011BISub currentClass011BISub : class011BISubDao.findAllClass011BISubs()) {
	        if (currentClass011BISub.equals(class011BISub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class011BISub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_01_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass011BISub() throws DaoException {
	    // Initialized the test
	    Class011BISub class011BISub = getClass011BISubExample();
	    class011BISubDao.createClass011BISub(class011BISub);
	    
	    // Execute the tested code
	    class011BISubDao.deleteClass011BISub(class011BISub);
	    
	    // Verify result
	    boolean found = false;
	    for (Class011BISub currentClass011BISub : class011BISubDao.findAllClass011BISubs()) {
	        if (currentClass011BISub.getId().equals(class011BISub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class011BISub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_01_1_BI_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass011BISubs() throws DaoException {
	    // Verify number of element before testing
	    int before = class011BISubDao.findAllClass011BISubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class011BISub class011BISub1 = getClass011BISubExample();
	    class011BISubDao.createClass011BISub(class011BISub1);
	            
	    Class011BISub class011BISub2 = getClass011BISubExample();
	    class011BISubDao.createClass011BISub(class011BISub2);
	
	    // Verify result
	    int after = class011BISubDao.findAllClass011BISubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_01_1_BI_Sub.
	 * @return Returns a new instance of class Class_01_1_BI_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011BISub getClass011BISubExample() throws DaoException {
	    // fill attributes with example values
	    Class011BISub class011BISub = new Class011BISub();
	    class011BISub.setFakeAttr("myFakeAttr");
	    
	    Class011BIEND targetExample = new Class011BIEND();
	    class011BISub.setTarget(targetExample);   
	    targetExample.setSource(class011BISub); 
	    class011BIENDDao.createClass011BIEND(targetExample);
	    
	    return class011BISub;
	}
	
	/**
	 * Creates a second example of Class_01_1_BI_Sub with other values.
	 * @return Returns a new instance of class Class_01_1_BI_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class011BISub getClass011BISubExample2() throws DaoException {
	    // fill attributes with example values
	    Class011BISub class011BISub = new Class011BISub();
		class011BISub.setFakeAttr("secondFakeAttr");
		
		Class011BIEND targetExample = new Class011BIEND();
		class011BISub.setTarget(targetExample);   
		targetExample.setSource(class011BISub); 
		class011BIENDDao.createClass011BIEND(targetExample);
		
	    return class011BISub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
