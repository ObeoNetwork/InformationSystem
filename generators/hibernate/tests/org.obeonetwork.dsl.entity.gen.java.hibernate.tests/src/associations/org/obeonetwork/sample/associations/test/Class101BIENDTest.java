package org.obeonetwork.sample.associations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.associations.IClass101BIENDDao;
import org.obeonetwork.sample.associations.Class101BIEND;
import org.obeonetwork.sample.associations.Class101BI;
import org.obeonetwork.sample.associations.IClass101BIDao;
// End of user code

/**
 * Test class for Class_1_01_BI_END.
 */
public class Class101BIENDTest extends TestCase {
	
	/**
	 * The DAO for class Class_1_01_BI.
	 */
	private IClass101BIDao class101BIDao;
	
	/**
	 * The DAO for class Class_1_01_BI_END.
	 */
	private IClass101BIENDDao class101BIENDDao;
	
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
		class101BIDao = SampleDaoFactory.getAssociationsClass_1_01_BIClass101BIDao();
		class101BIENDDao = SampleDaoFactory.getAssociationsClass_1_01_BI_ENDClass101BIENDDao();
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
	 * Tests the creation of the entity Class_1_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass101BIEND() throws DaoException {
	    // fill attributes with example values
	    Class101BIEND class101BIEND = getClass101BIENDExample();
	    
	    // Execute the tested code
	    class101BIENDDao.createClass101BIEND(class101BIEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class101BIEND currentClass101BIEND : class101BIENDDao.findAllClass101BIENDs()) {
	        if (currentClass101BIEND.equals(class101BIEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_1_01_BI_END not created", found);
	}
	
	/**
	 * Test the modification of an entity Class_1_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass101BIEND() throws DaoException {
	    // Initialized the test
	    Class101BIEND class101BIEND = getClass101BIENDExample();
	    class101BIENDDao.createClass101BIEND(class101BIEND);
	
	    // Execute the tested code
	    class101BIENDDao.updateClass101BIEND(class101BIEND);
	
	    // Verify result
	    boolean found = false;
	    for (Class101BIEND currentClass101BIEND : class101BIENDDao.findAllClass101BIENDs()) {
	        if (currentClass101BIEND.equals(class101BIEND)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class101BIEND not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class_1_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass101BIEND() throws DaoException {
	    // Initialized the test
	    Class101BIEND class101BIEND = getClass101BIENDExample();
	    class101BIENDDao.createClass101BIEND(class101BIEND);
	    
	    // Execute the tested code
	    class101BIENDDao.deleteClass101BIEND(class101BIEND);
	    
	    // Verify result
	    boolean found = false;
	    for (Class101BIEND currentClass101BIEND : class101BIENDDao.findAllClass101BIENDs()) {
	        if (currentClass101BIEND.getId().equals(class101BIEND.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class101BIEND not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class_1_01_BI_END.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass101BIENDs() throws DaoException {
	    // Verify number of element before testing
	    int before = class101BIENDDao.findAllClass101BIENDs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class101BIEND class101BIEND1 = getClass101BIENDExample();
	    class101BIENDDao.createClass101BIEND(class101BIEND1);
	            
	    Class101BIEND class101BIEND2 = getClass101BIENDExample();
	    class101BIENDDao.createClass101BIEND(class101BIEND2);
	
	    // Verify result
	    int after = class101BIENDDao.findAllClass101BIENDs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Class_1_01_BI_END.
	 * @return Returns a new instance of class Class_1_01_BI_END, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101BIEND getClass101BIENDExample() throws DaoException {
	    // fill attributes with example values
	    Class101BIEND class101BIEND = new Class101BIEND();
	    
	    Class101BI sourceExample = new Class101BI();
	    class101BIEND.setSource(sourceExample);   
	    sourceExample.setTarget(class101BIEND); 
	    class101BIDao.createClass101BI(sourceExample);
	    
	    return class101BIEND;
	}
	
	/**
	 * Creates a second example of Class_1_01_BI_END with other values.
	 * @return Returns a new instance of class Class_1_01_BI_END with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class101BIEND getClass101BIENDExample2() throws DaoException {
	    // fill attributes with example values
	    Class101BIEND class101BIEND = new Class101BIEND();
		
		Class101BI sourceExample = new Class101BI();
		class101BIEND.setSource(sourceExample);   
		sourceExample.setTarget(class101BIEND); 
		class101BIDao.createClass101BI(sourceExample);
		
	    return class101BIEND;
	}
    
    // Start of user code of specific tests
    // End of user code

}
