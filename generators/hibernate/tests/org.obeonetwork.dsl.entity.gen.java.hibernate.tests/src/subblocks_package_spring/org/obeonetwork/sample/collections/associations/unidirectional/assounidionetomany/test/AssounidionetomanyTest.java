package org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.test;

// Start of user code for import 

import org.springframework.test.AbstractTransactionalSpringContextTests;
import junit.framework.Assert;


import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.A;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.B;
// End of user code for import

/**
 * Test class for asso_unidi_one_to_many.
 */
public class AssounidionetomanyTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private IAssounidionetomanyDao assounidionetomanyDao = (IAssounidionetomanyDao)getApplicationContext().getBean("AssounidionetomanyDAO");



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
        assounidionetomanyDao.createA(a);

        // Verify result
        boolean found = false;
        for (A currentA : assounidionetomanyDao.findAllAs()) {
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
        assounidionetomanyDao.createA(a);

        // Execute the tested code
        assounidionetomanyDao.updateA(a);

        // Verify result
        boolean found = false;
        for (A currentA : assounidionetomanyDao.findAllAs()) {
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
        assounidionetomanyDao.createA(a);
        
        // Execute the tested code
        assounidionetomanyDao.deleteA(a);
        
        // Verify result
        boolean found = false;
        for (A currentA : assounidionetomanyDao.findAllAs()) {
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
        int before = assounidionetomanyDao.findAllAs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        A a1 = getAExample();
        assounidionetomanyDao.createA(a1);
                
        A a2 = getAExample();
        assounidionetomanyDao.createA(a2);

        // Verify result
        int after = assounidionetomanyDao.findAllAs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity B.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateB() throws DaoException {
        // fill attributes with example values
        B b = getBExample();
        
        // Execute the tested code
        assounidionetomanyDao.createB(b);

        // Verify result
        boolean found = false;
        for (B currentB : assounidionetomanyDao.findAllBs()) {
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
        assounidionetomanyDao.createB(b);

        // Execute the tested code
        assounidionetomanyDao.updateB(b);

        // Verify result
        boolean found = false;
        for (B currentB : assounidionetomanyDao.findAllBs()) {
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
        assounidionetomanyDao.createB(b);
        
        // Execute the tested code
        assounidionetomanyDao.deleteB(b);
        
        // Verify result
        boolean found = false;
        for (B currentB : assounidionetomanyDao.findAllBs()) {
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
        int before = assounidionetomanyDao.findAllBs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        B b1 = getBExample();
        assounidionetomanyDao.createB(b1);
                
        B b2 = getBExample();
        assounidionetomanyDao.createB(b2);

        // Verify result
        int after = assounidionetomanyDao.findAllBs().size();
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
    // End of user code of specific tests

}
