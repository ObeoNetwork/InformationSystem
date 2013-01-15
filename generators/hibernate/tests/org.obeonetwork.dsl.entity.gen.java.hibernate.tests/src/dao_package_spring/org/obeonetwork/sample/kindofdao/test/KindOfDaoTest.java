package org.obeonetwork.sample.kindofdao.test;

// Start of user code for import 

import org.springframework.test.AbstractTransactionalSpringContextTests;
import junit.framework.Assert;


import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.kindofdao.IKindOfDaoDao;
import org.obeonetwork.sample.kindofdao.ExempleDirect;
// End of user code

/**
 * Test class for kind of dao.
 */
public class KindOfDaoTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}
	
	private IKindOfDaoDao kindOfDaoDao = (IKindOfDaoDao)getApplicationContext().getBean("KindOfDaoDAO");
	
	
	
	/**
	 * Tests the creation of the entity ExempleDirect.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateExempleDirect() throws DaoException {
	    // fill attributes with example values
	    ExempleDirect exempleDirect = getExempleDirectExample();
	    
	    // Execute the tested code
	    kindOfDaoDao.createExempleDirect(exempleDirect);
	
	    // Verify result
	    boolean found = false;
	    for (ExempleDirect currentExempleDirect : kindOfDaoDao.findAllExempleDirects()) {
	        if (currentExempleDirect.equals(exempleDirect)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("ExempleDirect not created", found);
	}
	
	/**
	 * Test the modification of an entity ExempleDirect.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateExempleDirect() throws DaoException {
	    // Initialized the test
	    ExempleDirect exempleDirect = getExempleDirectExample();
	    kindOfDaoDao.createExempleDirect(exempleDirect);
	
	    // Execute the tested code
	    exempleDirect.setMyAttribute("secondMyAttribute");
	    exempleDirect.setMyId("secondMyId");
	    kindOfDaoDao.updateExempleDirect(exempleDirect);
	
	    // Verify result
	    boolean found = false;
	    for (ExempleDirect currentExempleDirect : kindOfDaoDao.findAllExempleDirects()) {
	        if (currentExempleDirect.equals(exempleDirect)) {
	            found = true;
	            Assert.assertEquals("Value myAttribute not modified",
	                    "secondMyAttribute",
	                    exempleDirect.getMyAttribute());
	            Assert.assertEquals("Value myId not modified",
	                    "secondMyId",
	                    exempleDirect.getMyId());
	        }
	    }
	    Assert.assertTrue("ExempleDirect not found", found);
	}
	
	/**
	 * Test the suppression of an entity ExempleDirect.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteExempleDirect() throws DaoException {
	    // Initialized the test
	    ExempleDirect exempleDirect = getExempleDirectExample();
	    kindOfDaoDao.createExempleDirect(exempleDirect);
	    
	    // Execute the tested code
	    kindOfDaoDao.deleteExempleDirect(exempleDirect);
	    
	    // Verify result
	    boolean found = false;
	    for (ExempleDirect currentExempleDirect : kindOfDaoDao.findAllExempleDirects()) {
	        if (currentExempleDirect.getId().equals(exempleDirect.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("ExempleDirect not deleted", found);
	}
	
	/**
	 * Test the search of all entities ExempleDirect.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllExempleDirects() throws DaoException {
	    // Verify number of element before testing
	    int before = kindOfDaoDao.findAllExempleDirects().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    ExempleDirect exempleDirect1 = getExempleDirectExample();
	    kindOfDaoDao.createExempleDirect(exempleDirect1);
	            
	    ExempleDirect exempleDirect2 = getExempleDirectExample();
	    kindOfDaoDao.createExempleDirect(exempleDirect2);
	
	    // Verify result
	    int after = kindOfDaoDao.findAllExempleDirects().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	

	
	/**
	 * Creates an example of ExempleDirect.
	 * @return Returns a new instance of class ExempleDirect, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ExempleDirect getExempleDirectExample() throws DaoException {
	    // fill attributes with example values
	    ExempleDirect exempleDirect = new ExempleDirect();
	    exempleDirect.setMyAttribute("myMyAttribute");
	    exempleDirect.setMyId("myMyId");
	    
	    
	    return exempleDirect;
	}
	
	/**
	 * Creates a second example of ExempleDirect with other values.
	 * @return Returns a new instance of class ExempleDirect with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected ExempleDirect getExempleDirectExample2() throws DaoException {
	    // fill attributes with example values
	    ExempleDirect exempleDirect = new ExempleDirect();
		exempleDirect.setMyAttribute("secondMyAttribute");
		exempleDirect.setMyId("secondMyId");
		
		
	    return exempleDirect;
	}
	
    
    // Start of user code of specific tests
    // End of user code

}
