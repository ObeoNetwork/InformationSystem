package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import java.util.Date;

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.associations.IClass11BIDao;
import org.obeonetwork.sample.associations.Class11BI;
import org.obeonetwork.sample.associations.Class11BIEND;
import org.obeonetwork.sample.associations.IClass11BIENDDao;
// End of user code for import

/**
 * Test class for Class_1_1_BI.
 */
public class Class11BITest extends TestCase {

	/**
	 * The DAO for class Class_1_1_BI.
	 */
	private IClass11BIDao class11BIDao;

	/**
	 * The DAO for class Class_1_1_BI_END.
	 */
	private IClass11BIENDDao class11BIENDDao;

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
		class11BIDao = SampleDaoFactory.getClass11BIDao();
		class11BIENDDao = SampleDaoFactory.getClass11BIENDDao();
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
     * Tests the creation of the entity Class_1_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BI() throws DaoException {
        // fill attributes with example values
        Class11BI class11BI = getClass11BIExample();
        
        // Execute the tested code
        class11BIDao.createClass11BI(class11BI);

        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : class11BIDao.findAllClass11BIs()) {
            if (currentClass11BI.equals(class11BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11BI() throws DaoException {
        // Initialized the test
        Class11BI class11BI = getClass11BIExample();
        class11BIDao.createClass11BI(class11BI);

        // Execute the tested code
        class11BI.setFakeAttr(new Date(1));
        class11BIDao.updateClass11BI(class11BI);

        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : class11BIDao.findAllClass11BIs()) {
            if (currentClass11BI.equals(class11BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Date(1),
                        class11BI.getFakeAttr());
            }
        }
        Assert.assertTrue("Class11BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11BI() throws DaoException {
        // Initialized the test
        Class11BI class11BI = getClass11BIExample();
        class11BIDao.createClass11BI(class11BI);
        
        // Execute the tested code
        class11BIDao.deleteClass11BI(class11BI);
        
        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : class11BIDao.findAllClass11BIs()) {
            if (currentClass11BI.getId().equals(class11BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11BIs() throws DaoException {
        // Verify number of element before testing
        int before = class11BIDao.findAllClass11BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BI class11BI1 = getClass11BIExample();
        class11BIDao.createClass11BI(class11BI1);
                
        Class11BI class11BI2 = getClass11BIExample();
        class11BIDao.createClass11BI(class11BI2);

        // Verify result
        int after = class11BIDao.findAllClass11BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_1_1_BI.
     * @return Returns a new instance of class Class_1_1_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BI getClass11BIExample() throws DaoException {
        // fill attributes with example values
        Class11BI class11BI = new Class11BI();
        class11BI.setFakeAttr(new Date(0));

        Class11BIEND targetExample = new Class11BIEND();
        class11BI.setTarget(targetExample);   
        targetExample.setSource(class11BI); 
        class11BIENDDao.createClass11BIEND(targetExample);

        return class11BI;
    }
    
    /**
     * Creates a second example of Class_1_1_BI with other values.
     * @return Returns a new instance of class Class_1_1_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BI getClass11BIExample2() throws DaoException {
        // fill attributes with example values
        Class11BI class11BI = new Class11BI();
        class11BI.setFakeAttr(new Date(1));

        Class11BIEND targetExample = new Class11BIEND();
        class11BI.setTarget(targetExample);   
        targetExample.setSource(class11BI); 
        class11BIENDDao.createClass11BIEND(targetExample);

        return class11BI;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
