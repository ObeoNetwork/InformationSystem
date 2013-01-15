package org.obeonetwork.sample.operation.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.operation.IOperationsDao;
import org.obeonetwork.sample.operation.Operations;


// End of user code

/**
 * Test class for Operations.
 */
public class OperationsTest extends TestCase {
	
	/**
	 * The DAO for class Operations.
	 */
	private IOperationsDao operationsDao;
	
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
		operationsDao = SampleDaoFactory.getOperationOperationsDao();
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
	 * Tests the creation of the entity Operations.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateOperations() throws DaoException {
	    // fill attributes with example values
	    Operations operations = getOperationsExample();
	    
	    // Execute the tested code
	    operationsDao.createOperations(operations);
	
	    // Verify result
	    boolean found = false;
	    for (Operations currentOperations : operationsDao.findAllOperationss()) {
	        if (currentOperations.equals(operations)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Operations not created", found);
	}
	
	/**
	 * Test the modification of an entity Operations.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateOperations() throws DaoException {
	    // Initialized the test
	    Operations operations = getOperationsExample();
	    operationsDao.createOperations(operations);
	
	    // Execute the tested code
	    operationsDao.updateOperations(operations);
	
	    // Verify result
	    boolean found = false;
	    for (Operations currentOperations : operationsDao.findAllOperationss()) {
	        if (currentOperations.equals(operations)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Operations not found", found);
	}
	
	/**
	 * Test the suppression of an entity Operations.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteOperations() throws DaoException {
	    // Initialized the test
	    Operations operations = getOperationsExample();
	    operationsDao.createOperations(operations);
	    
	    // Execute the tested code
	    operationsDao.deleteOperations(operations);
	    
	    // Verify result
	    boolean found = false;
	    for (Operations currentOperations : operationsDao.findAllOperationss()) {
	        if (currentOperations.getId().equals(operations.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Operations not deleted", found);
	}
	
	/**
	 * Test the search of all entities Operations.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllOperationss() throws DaoException {
	    // Verify number of element before testing
	    int before = operationsDao.findAllOperationss().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Operations operations1 = getOperationsExample();
	    operationsDao.createOperations(operations1);
	            
	    Operations operations2 = getOperationsExample();
	    operationsDao.createOperations(operations2);
	
	    // Verify result
	    int after = operationsDao.findAllOperationss().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}

	
	/**
	 * Creates an example of Operations.
	 * @return Returns a new instance of class Operations, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Operations getOperationsExample() throws DaoException {
	    // fill attributes with example values
	    Operations operations = new Operations();
	    
	    
	    return operations;
	}
	
	/**
	 * Creates a second example of Operations with other values.
	 * @return Returns a new instance of class Operations with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Operations getOperationsExample2() throws DaoException {
	    // fill attributes with example values
	    Operations operations = new Operations();
		
		
	    return operations;
	}
    
    // Start of user code of specific tests
    // End of user code

}
