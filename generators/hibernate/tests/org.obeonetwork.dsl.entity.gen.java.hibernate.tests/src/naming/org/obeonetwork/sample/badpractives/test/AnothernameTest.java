package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IAnothernameDao;
import org.obeonetwork.sample.badpractives.Anothername;


// End of user code for import

/**
 * Test class for Another.name.
 */
public class AnothernameTest extends TestCase {

	/**
	 * The DAO for class Another.name.
	 */
	private IAnothernameDao anothernameDao;

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
		anothernameDao = SampleDaoFactory.getAnothernameDao();
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
     * Tests the creation of the entity Another.name.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateAnothername() throws DaoException {
        // fill attributes with example values
        Anothername anothername = getAnothernameExample();
        
        // Execute the tested code
        anothernameDao.createAnothername(anothername);

        // Verify result
        boolean found = false;
        for (Anothername currentAnothername : anothernameDao.findAllAnothernames()) {
            if (currentAnothername.equals(anothername)) {
                found = true;
            }
        }
        Assert.assertTrue("Another.name not created", found);
    }

    /**
     * Test the modification of an entity Another.name.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateAnothername() throws DaoException {
        // Initialized the test
        Anothername anothername = getAnothernameExample();
        anothernameDao.createAnothername(anothername);

        // Execute the tested code
        anothernameDao.updateAnothername(anothername);

        // Verify result
        boolean found = false;
        for (Anothername currentAnothername : anothernameDao.findAllAnothernames()) {
            if (currentAnothername.equals(anothername)) {
                found = true;
            }
        }
        Assert.assertTrue("Anothername not found", found);
    }

    /**
     * Test the suppression of an entity Another.name.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteAnothername() throws DaoException {
        // Initialized the test
        Anothername anothername = getAnothernameExample();
        anothernameDao.createAnothername(anothername);
        
        // Execute the tested code
        anothernameDao.deleteAnothername(anothername);
        
        // Verify result
        boolean found = false;
        for (Anothername currentAnothername : anothernameDao.findAllAnothernames()) {
            if (currentAnothername.getId().equals(anothername.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Anothername not deleted", found);
    }

    /**
     * Test the search of all entities Another.name.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllAnothernames() throws DaoException {
        // Verify number of element before testing
        int before = anothernameDao.findAllAnothernames().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Anothername anothername1 = getAnothernameExample();
        anothernameDao.createAnothername(anothername1);
                
        Anothername anothername2 = getAnothernameExample();
        anothernameDao.createAnothername(anothername2);

        // Verify result
        int after = anothernameDao.findAllAnothernames().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Another.name.
     * @return Returns a new instance of class Another.name, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Anothername getAnothernameExample() throws DaoException {
        // fill attributes with example values
        Anothername anothername = new Anothername();


        return anothername;
    }
    
    /**
     * Creates a second example of Another.name with other values.
     * @return Returns a new instance of class Another.name with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Anothername getAnothernameExample2() throws DaoException {
        // fill attributes with example values
        Anothername anothername = new Anothername();


        return anothername;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
