package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.associations.IClass01ManyDao;
import org.obeonetwork.sample.associations.Class01Many;


// End of user code for import

/**
 * Test class for Class_01_Many.
 */
public class Class01ManyTest extends TestCase {

	/**
	 * The DAO for class Class_01_Many.
	 */
	private IClass01ManyDao class01ManyDao;

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
		class01ManyDao = SampleDaoFactory.getClass01ManyDao();
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
     * Tests the creation of the entity Class_01_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01Many() throws DaoException {
        // fill attributes with example values
        Class01Many class01Many = getClass01ManyExample();
        
        // Execute the tested code
        class01ManyDao.createClass01Many(class01Many);

        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : class01ManyDao.findAllClass01Manys()) {
            if (currentClass01Many.equals(class01Many)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01Many() throws DaoException {
        // Initialized the test
        Class01Many class01Many = getClass01ManyExample();
        class01ManyDao.createClass01Many(class01Many);

        // Execute the tested code
        class01Many.setFakeAttr(new Integer(725185254));
        class01ManyDao.updateClass01Many(class01Many);

        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : class01ManyDao.findAllClass01Manys()) {
            if (currentClass01Many.equals(class01Many)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class01Many.getFakeAttr());
            }
        }
        Assert.assertTrue("Class01Many not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01Many() throws DaoException {
        // Initialized the test
        Class01Many class01Many = getClass01ManyExample();
        class01ManyDao.createClass01Many(class01Many);
        
        // Execute the tested code
        class01ManyDao.deleteClass01Many(class01Many);
        
        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : class01ManyDao.findAllClass01Manys()) {
            if (currentClass01Many.getId().equals(class01Many.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01Many not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01Manys() throws DaoException {
        // Verify number of element before testing
        int before = class01ManyDao.findAllClass01Manys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01Many class01Many1 = getClass01ManyExample();
        class01ManyDao.createClass01Many(class01Many1);
                
        Class01Many class01Many2 = getClass01ManyExample();
        class01ManyDao.createClass01Many(class01Many2);

        // Verify result
        int after = class01ManyDao.findAllClass01Manys().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_Many.
     * @return Returns a new instance of class Class_01_Many, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01Many getClass01ManyExample() throws DaoException {
        // fill attributes with example values
        Class01Many class01Many = new Class01Many();
        class01Many.setFakeAttr(new Integer(725185254 + 1));


        return class01Many;
    }
    
    /**
     * Creates a second example of Class_01_Many with other values.
     * @return Returns a new instance of class Class_01_Many with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01Many getClass01ManyExample2() throws DaoException {
        // fill attributes with example values
        Class01Many class01Many = new Class01Many();
        class01Many.setFakeAttr(new Integer(725185254));


        return class01Many;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
