package org.obeonetwork.sample.collections.composition.onetoonecomp.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao;
import org.obeonetwork.sample.collections.composition.onetoonecomp.A;
import org.obeonetwork.sample.collections.composition.onetoonecomp.B;
// End of user code

/**
 * Test class for one_to_one_comp.
 */
public class OnetoonecompTest extends TestCase {
	
	/**
	 * The DAO for class one_to_one_comp.
	 */
	private IOnetoonecompDao onetoonecompDao;
	
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
		onetoonecompDao = null; //FIXME
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
	 * Tests the creation of the entity A.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateA() throws DaoException {
	    // fill attributes with example values
	    A a = getAExample();
	    
	    // Execute the tested code
	    onetoonecompDao.createA(a);
	
	    // Verify result
	    boolean found = false;
	    for (A currentA : onetoonecompDao.findAllAs()) {
	        if (currentA.equals(a)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("A not created", found);
	}
	
	/**
	 * Test the modification of an entity A.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateA() throws DaoException {
	    // Initialized the test
	    A a = getAExample();
	    onetoonecompDao.createA(a);
	
	    // Execute the tested code
	    onetoonecompDao.updateA(a);
	
	    // Verify result
	    boolean found = false;
	    for (A currentA : onetoonecompDao.findAllAs()) {
	        if (currentA.equals(a)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("A not found", found);
	}
	
	/**
	 * Test the suppression of an entity A.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteA() throws DaoException {
	    // Initialized the test
	    A a = getAExample();
	    onetoonecompDao.createA(a);
	    
	    // Execute the tested code
	    onetoonecompDao.deleteA(a);
	    
	    // Verify result
	    boolean found = false;
	    for (A currentA : onetoonecompDao.findAllAs()) {
	        if (currentA.getId().equals(a.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("A not deleted", found);
	}
	
	/**
	 * Test the search of all entities A.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllAs() throws DaoException {
	    // Verify number of element before testing
	    int before = onetoonecompDao.findAllAs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    A a1 = getAExample();
	    onetoonecompDao.createA(a1);
	            
	    A a2 = getAExample();
	    onetoonecompDao.createA(a2);
	
	    // Verify result
	    int after = onetoonecompDao.findAllAs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity B.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateB() throws DaoException {
	    // fill attributes with example values
	    B b = getBExample();
	    
	    // Execute the tested code
	    onetoonecompDao.createB(b);
	
	    // Verify result
	    boolean found = false;
	    for (B currentB : onetoonecompDao.findAllBs()) {
	        if (currentB.equals(b)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("B not created", found);
	}
	
	/**
	 * Test the modification of an entity B.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateB() throws DaoException {
	    // Initialized the test
	    B b = getBExample();
	    onetoonecompDao.createB(b);
	
	    // Execute the tested code
	    onetoonecompDao.updateB(b);
	
	    // Verify result
	    boolean found = false;
	    for (B currentB : onetoonecompDao.findAllBs()) {
	        if (currentB.equals(b)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("B not found", found);
	}
	
	/**
	 * Test the suppression of an entity B.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteB() throws DaoException {
	    // Initialized the test
	    B b = getBExample();
	    onetoonecompDao.createB(b);
	    
	    // Execute the tested code
	    onetoonecompDao.deleteB(b);
	    
	    // Verify result
	    boolean found = false;
	    for (B currentB : onetoonecompDao.findAllBs()) {
	        if (currentB.getId().equals(b.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("B not deleted", found);
	}
	
	/**
	 * Test the search of all entities B.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllBs() throws DaoException {
	    // Verify number of element before testing
	    int before = onetoonecompDao.findAllBs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    B b1 = getBExample();
	    onetoonecompDao.createB(b1);
	            
	    B b2 = getBExample();
	    onetoonecompDao.createB(b2);
	
	    // Verify result
	    int after = onetoonecompDao.findAllBs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	

	
	/**
	 * Creates an example of A.
	 * @return Returns a new instance of class A, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected A getAExample() throws DaoException {
	    // fill attributes with example values
	    A a = new A();
	    
	    
	    return a;
	}
	
	/**
	 * Creates a second example of A with other values.
	 * @return Returns a new instance of class A with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected A getAExample2() throws DaoException {
	    // fill attributes with example values
	    A a = new A();
		
		
	    return a;
	}
	
	/**
	 * Creates an example of B.
	 * @return Returns a new instance of class B, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected B getBExample() throws DaoException {
	    // fill attributes with example values
	    B b = new B();
	    
	    
	    return b;
	}
	
	/**
	 * Creates a second example of B with other values.
	 * @return Returns a new instance of class B with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected B getBExample2() throws DaoException {
	    // fill attributes with example values
	    B b = new B();
		
		
	    return b;
	}
	
    
    // Start of user code of specific tests
    // End of user code

}
