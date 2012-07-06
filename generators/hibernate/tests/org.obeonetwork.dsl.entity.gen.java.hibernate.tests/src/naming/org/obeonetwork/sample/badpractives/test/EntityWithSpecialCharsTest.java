package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao;
import org.obeonetwork.sample.badpractives.EntityWithSpecialChars;


// End of user code for import

/**
 * Test class for entityWithSpécialChars.
 */
public class EntityWithSpecialCharsTest extends TestCase {

	/**
	 * The DAO for class entityWithSpécialChars.
	 */
	private IEntityWithSpecialCharsDao entityWithSpecialCharsDao;

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
		entityWithSpecialCharsDao = SampleDaoFactory.getEntityWithSpecialCharsDao();
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
     * Tests the creation of the entity entityWithSpécialChars.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateentityWithSpecialChars() throws DaoException {
        // fill attributes with example values
        EntityWithSpecialChars entityWithSpecialChars = getEntityWithSpecialCharsExample();
        
        // Execute the tested code
        entityWithSpecialCharsDao.createentityWithSpecialChars(entityWithSpecialChars);

        // Verify result
        boolean found = false;
        for (EntityWithSpecialChars currententityWithSpecialChars : entityWithSpecialCharsDao.findAllentityWithSpecialCharss()) {
            if (currententityWithSpecialChars.equals(entityWithSpecialChars)) {
                found = true;
            }
        }
        Assert.assertTrue("entityWithSpécialChars not created", found);
    }

    /**
     * Test the modification of an entity entityWithSpécialChars.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateentityWithSpecialChars() throws DaoException {
        // Initialized the test
        EntityWithSpecialChars entityWithSpecialChars = getEntityWithSpecialCharsExample();
        entityWithSpecialCharsDao.createentityWithSpecialChars(entityWithSpecialChars);

        // Execute the tested code
        entityWithSpecialCharsDao.updateentityWithSpecialChars(entityWithSpecialChars);

        // Verify result
        boolean found = false;
        for (EntityWithSpecialChars currententityWithSpecialChars : entityWithSpecialCharsDao.findAllentityWithSpecialCharss()) {
            if (currententityWithSpecialChars.equals(entityWithSpecialChars)) {
                found = true;
            }
        }
        Assert.assertTrue("entityWithSpecialChars not found", found);
    }

    /**
     * Test the suppression of an entity entityWithSpécialChars.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteentityWithSpecialChars() throws DaoException {
        // Initialized the test
        EntityWithSpecialChars entityWithSpecialChars = getEntityWithSpecialCharsExample();
        entityWithSpecialCharsDao.createentityWithSpecialChars(entityWithSpecialChars);
        
        // Execute the tested code
        entityWithSpecialCharsDao.deleteentityWithSpecialChars(entityWithSpecialChars);
        
        // Verify result
        boolean found = false;
        for (EntityWithSpecialChars currententityWithSpecialChars : entityWithSpecialCharsDao.findAllentityWithSpecialCharss()) {
            if (currententityWithSpecialChars.getId().equals(entityWithSpecialChars.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("entityWithSpecialChars not deleted", found);
    }

    /**
     * Test the search of all entities entityWithSpécialChars.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllentityWithSpecialCharss() throws DaoException {
        // Verify number of element before testing
        int before = entityWithSpecialCharsDao.findAllentityWithSpecialCharss().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        EntityWithSpecialChars entityWithSpecialChars1 = getEntityWithSpecialCharsExample();
        entityWithSpecialCharsDao.createentityWithSpecialChars(entityWithSpecialChars1);
                
        EntityWithSpecialChars entityWithSpecialChars2 = getEntityWithSpecialCharsExample();
        entityWithSpecialCharsDao.createentityWithSpecialChars(entityWithSpecialChars2);

        // Verify result
        int after = entityWithSpecialCharsDao.findAllentityWithSpecialCharss().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of entityWithSpécialChars.
     * @return Returns a new instance of class entityWithSpécialChars, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected EntityWithSpecialChars getEntityWithSpecialCharsExample() throws DaoException {
        // fill attributes with example values
        EntityWithSpecialChars entityWithSpecialChars = new EntityWithSpecialChars();


        return entityWithSpecialChars;
    }
    
    /**
     * Creates a second example of entityWithSpécialChars with other values.
     * @return Returns a new instance of class entityWithSpécialChars with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected EntityWithSpecialChars getEntityWithSpecialCharsExample2() throws DaoException {
        // fill attributes with example values
        EntityWithSpecialChars entityWithSpecialChars = new EntityWithSpecialChars();


        return entityWithSpecialChars;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
