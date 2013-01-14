package org.obeonetwork.sample.operation.test;

// Start of user code for import 

import org.springframework.test.AbstractTransactionalSpringContextTests;
import junit.framework.Assert;


import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.operation.IOperationDao;
import org.obeonetwork.sample.operation.Operations;
import org.obeonetwork.sample.operation.Finders;
// End of user code

/**
 * Test class for operation.
 */
public class OperationTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}
	
	private IOperationDao operationDao = (IOperationDao)getApplicationContext().getBean("OperationDAO");
	
	
	
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
	    operationDao.createOperations(operations);
	
	    // Verify result
	    boolean found = false;
	    for (Operations currentOperations : operationDao.findAllOperationss()) {
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
	    operationDao.createOperations(operations);
	
	    // Execute the tested code
	    operationDao.updateOperations(operations);
	
	    // Verify result
	    boolean found = false;
	    for (Operations currentOperations : operationDao.findAllOperationss()) {
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
	    operationDao.createOperations(operations);
	    
	    // Execute the tested code
	    operationDao.deleteOperations(operations);
	    
	    // Verify result
	    boolean found = false;
	    for (Operations currentOperations : operationDao.findAllOperationss()) {
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
	    int before = operationDao.findAllOperationss().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Operations operations1 = getOperationsExample();
	    operationDao.createOperations(operations1);
	            
	    Operations operations2 = getOperationsExample();
	    operationDao.createOperations(operations2);
	
	    // Verify result
	    int after = operationDao.findAllOperationss().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity Finders.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateFinders() throws DaoException {
	    // fill attributes with example values
	    Finders finders = getFindersExample();
	    
	    // Execute the tested code
	    operationDao.createFinders(finders);
	
	    // Verify result
	    boolean found = false;
	    for (Finders currentFinders : operationDao.findAllFinderss()) {
	        if (currentFinders.equals(finders)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Finders not created", found);
	}
	
	/**
	 * Test the modification of an entity Finders.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateFinders() throws DaoException {
	    // Initialized the test
	    Finders finders = getFindersExample();
	    operationDao.createFinders(finders);
	
	    // Execute the tested code
	    operationDao.updateFinders(finders);
	
	    // Verify result
	    boolean found = false;
	    for (Finders currentFinders : operationDao.findAllFinderss()) {
	        if (currentFinders.equals(finders)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Finders not found", found);
	}
	
	/**
	 * Test the suppression of an entity Finders.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteFinders() throws DaoException {
	    // Initialized the test
	    Finders finders = getFindersExample();
	    operationDao.createFinders(finders);
	    
	    // Execute the tested code
	    operationDao.deleteFinders(finders);
	    
	    // Verify result
	    boolean found = false;
	    for (Finders currentFinders : operationDao.findAllFinderss()) {
	        if (currentFinders.getId().equals(finders.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Finders not deleted", found);
	}
	
	/**
	 * Test the search of all entities Finders.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllFinderss() throws DaoException {
	    // Verify number of element before testing
	    int before = operationDao.findAllFinderss().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Finders finders1 = getFindersExample();
	    operationDao.createFinders(finders1);
	            
	    Finders finders2 = getFindersExample();
	    operationDao.createFinders(finders2);
	
	    // Verify result
	    int after = operationDao.findAllFinderss().size();
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
	
	/**
	 * Creates an example of Finders.
	 * @return Returns a new instance of class Finders, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Finders getFindersExample() throws DaoException {
	    // fill attributes with example values
	    Finders finders = new Finders();
	    
	    
	    return finders;
	}
	
	/**
	 * Creates a second example of Finders with other values.
	 * @return Returns a new instance of class Finders with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Finders getFindersExample2() throws DaoException {
	    // fill attributes with example values
	    Finders finders = new Finders();
		
		
	    return finders;
	}
	
    
    // Start of user code of specific tests
    // End of user code

}
