package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01ENDSub;


// End of user code

/**
 * Test class for Class_Many_01_END_Sub.
 */
public class ClassMany01ENDSubTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_01_END_Sub.
	 */
	private IClassMany01ENDSubDao classMany01ENDSubDao;
	
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
		classMany01ENDSubDao = SampleDaoFactory.getInheritanceassociationsClassMany01ENDSubDao();
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
	 * Tests the creation of the entity Class_Many_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassMany01ENDSub() throws DaoException {
	    // fill attributes with example values
	    ClassMany01ENDSub classMany01ENDSub = getClassMany01ENDSubExample();
	    
	    // Execute the tested code
	    classMany01ENDSubDao.createClassMany01ENDSub(classMany01ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01ENDSub currentClassMany01ENDSub : classMany01ENDSubDao.findAllClassMany01ENDSubs()) {
	        if (currentClassMany01ENDSub.equals(classMany01ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_01_END_Sub not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassMany01ENDSub() throws DaoException {
	    // Initialized the test
	    ClassMany01ENDSub classMany01ENDSub = getClassMany01ENDSubExample();
	    classMany01ENDSubDao.createClassMany01ENDSub(classMany01ENDSub);
	
	    // Execute the tested code
	    classMany01ENDSubDao.updateClassMany01ENDSub(classMany01ENDSub);
	
	    // Verify result
	    boolean found = false;
	    for (ClassMany01ENDSub currentClassMany01ENDSub : classMany01ENDSubDao.findAllClassMany01ENDSubs()) {
	        if (currentClassMany01ENDSub.equals(classMany01ENDSub)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("ClassMany01ENDSub not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassMany01ENDSub() throws DaoException {
	    // Initialized the test
	    ClassMany01ENDSub classMany01ENDSub = getClassMany01ENDSubExample();
	    classMany01ENDSubDao.createClassMany01ENDSub(classMany01ENDSub);
	    
	    // Execute the tested code
	    classMany01ENDSubDao.deleteClassMany01ENDSub(classMany01ENDSub);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassMany01ENDSub currentClassMany01ENDSub : classMany01ENDSubDao.findAllClassMany01ENDSubs()) {
	        if (currentClassMany01ENDSub.getId().equals(classMany01ENDSub.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassMany01ENDSub not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_01_END_Sub.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassMany01ENDSubs() throws DaoException {
	    // Verify number of element before testing
	    int before = classMany01ENDSubDao.findAllClassMany01ENDSubs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassMany01ENDSub classMany01ENDSub1 = getClassMany01ENDSubExample();
	    classMany01ENDSubDao.createClassMany01ENDSub(classMany01ENDSub1);
	            
	    ClassMany01ENDSub classMany01ENDSub2 = getClassMany01ENDSubExample();
	    classMany01ENDSubDao.createClassMany01ENDSub(classMany01ENDSub2);
	
	    // Verify result
	    int after = classMany01ENDSubDao.findAllClassMany01ENDSubs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_01_END_Sub.
	 * @return Returns a new instance of class Class_Many_01_END_Sub, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01ENDSub getClassMany01ENDSubExample() throws DaoException {
	    // fill attributes with example values
	    ClassMany01ENDSub classMany01ENDSub = new ClassMany01ENDSub();
	    classMany01ENDSub.setFakeAttr("myFakeAttr");
	    
	    
	    return classMany01ENDSub;
	}
	
	/**
	 * Creates a second example of Class_Many_01_END_Sub with other values.
	 * @return Returns a new instance of class Class_Many_01_END_Sub with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassMany01ENDSub getClassMany01ENDSubExample2() throws DaoException {
	    // fill attributes with example values
	    ClassMany01ENDSub classMany01ENDSub = new ClassMany01ENDSub();
		classMany01ENDSub.setFakeAttr("secondFakeAttr");
		
		
	    return classMany01ENDSub;
	}
    
    // Start of user code of specific tests
    // End of user code

}
