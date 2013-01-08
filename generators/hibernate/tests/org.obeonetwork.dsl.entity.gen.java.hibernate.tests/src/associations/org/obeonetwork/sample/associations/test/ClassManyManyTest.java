package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClassManyManyDao;
import org.obeonetwork.sample.associations.ClassManyMany;


// End of user code

/**
 * Test class for Class_Many_Many.
 */
public class ClassManyManyTest extends TestCase {
	
	/**
	 * The DAO for class Class_Many_Many.
	 */
	private IClassManyManyDao classManyManyDao;
	
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
		classManyManyDao = SampleDaoFactory.getAssociationsClass_Many_ManyClassManyManyDao();
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
	 * Tests the creation of the entity Class_Many_Many.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClassManyMany() throws DaoException {
	    // fill attributes with example values
	    ClassManyMany classManyMany = getClassManyManyExample();
	    
	    // Execute the tested code
	    classManyManyDao.createClassManyMany(classManyMany);
	
	    // Verify result
	    boolean found = false;
	    for (ClassManyMany currentClassManyMany : classManyManyDao.findAllClassManyManys()) {
	        if (currentClassManyMany.equals(classManyMany)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_Many_Many not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_Many_Many.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClassManyMany() throws DaoException {
	    // Initialized the test
	    ClassManyMany classManyMany = getClassManyManyExample();
	    classManyManyDao.createClassManyMany(classManyMany);
	
	    // Execute the tested code
	    classManyMany.setFakeAttr(new Float(725185254.0));
	    classManyManyDao.updateClassManyMany(classManyMany);
	
	    // Verify result
	    boolean found = false;
	    for (ClassManyMany currentClassManyMany : classManyManyDao.findAllClassManyManys()) {
	        if (currentClassManyMany.equals(classManyMany)) {
	            found = true;
	            Assert.assertEquals("Value fakeAttr not modified",
	                    new Float(725185254.0),
	                    classManyMany.getFakeAttr());
	        }
	    }
	    Assert.assertTrue("ClassManyMany not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_Many_Many.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClassManyMany() throws DaoException {
	    // Initialized the test
	    ClassManyMany classManyMany = getClassManyManyExample();
	    classManyManyDao.createClassManyMany(classManyMany);
	    
	    // Execute the tested code
	    classManyManyDao.deleteClassManyMany(classManyMany);
	    
	    // Verify result
	    boolean found = false;
	    for (ClassManyMany currentClassManyMany : classManyManyDao.findAllClassManyManys()) {
	        if (currentClassManyMany.getId().equals(classManyMany.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ClassManyMany not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_Many_Many.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClassManyManys() throws DaoException {
	    // Verify number of element before testing
	    int before = classManyManyDao.findAllClassManyManys().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ClassManyMany classManyMany1 = getClassManyManyExample();
	    classManyManyDao.createClassManyMany(classManyMany1);
	            
	    ClassManyMany classManyMany2 = getClassManyManyExample();
	    classManyManyDao.createClassManyMany(classManyMany2);
	
	    // Verify result
	    int after = classManyManyDao.findAllClassManyManys().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_Many_Many.
	 * @return Returns a new instance of class Class_Many_Many, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassManyMany getClassManyManyExample() throws DaoException {
	    // fill attributes with example values
	    ClassManyMany classManyMany = new ClassManyMany();
	    classManyMany.setFakeAttr(new Float(725185254.1));
	    
	    
	    return classManyMany;
	}
	
	/**
	 * Creates a second example of Class_Many_Many with other values.
	 * @return Returns a new instance of class Class_Many_Many with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ClassManyMany getClassManyManyExample2() throws DaoException {
	    // fill attributes with example values
	    ClassManyMany classManyMany = new ClassManyMany();
		classManyMany.setFakeAttr(new Float(725185254.0));
		
		
	    return classManyMany;
	}
    
    // Start of user code of specific tests
    // End of user code

}
