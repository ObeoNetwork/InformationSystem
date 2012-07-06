package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIDao;
// End of user code for import

/**
 * Test class for Class_1_1_BI_END.
 */
public class Class11BIENDTest extends TestCase {

	/**
	 * The DAO for class Class_1_1_BI_END.
	 */
	private IClass11BIENDDao class11BIENDDao;

	/**
	 * The DAO for class Class_1_1_BI.
	 */
	private IClass11BIDao class11BIDao;

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
		class11BIENDDao = SampleDaoFactory.getClass11BIENDDao();
		class11BIDao = SampleDaoFactory.getClass11BIDao();
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
     * Tests the creation of the entity Class_1_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BIEND() throws DaoException {
        // fill attributes with example values
        Class11BIEND class11BIEND = getClass11BIENDExample();
        
        // Execute the tested code
        class11BIENDDao.createClass11BIEND(class11BIEND);

        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : class11BIENDDao.findAllClass11BIENDs()) {
            if (currentClass11BIEND.equals(class11BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11BIEND() throws DaoException {
        // Initialized the test
        Class11BIEND class11BIEND = getClass11BIENDExample();
        class11BIENDDao.createClass11BIEND(class11BIEND);

        // Execute the tested code
        class11BIEND.setFakeAttr("secondFakeAttr");
        class11BIENDDao.updateClass11BIEND(class11BIEND);

        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : class11BIENDDao.findAllClass11BIENDs()) {
            if (currentClass11BIEND.equals(class11BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class11BIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("Class11BIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11BIEND() throws DaoException {
        // Initialized the test
        Class11BIEND class11BIEND = getClass11BIENDExample();
        class11BIENDDao.createClass11BIEND(class11BIEND);
        
        // Execute the tested code
        class11BIENDDao.deleteClass11BIEND(class11BIEND);
        
        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : class11BIENDDao.findAllClass11BIENDs()) {
            if (currentClass11BIEND.getId().equals(class11BIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11BIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11BIENDs() throws DaoException {
        // Verify number of element before testing
        int before = class11BIENDDao.findAllClass11BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BIEND class11BIEND1 = getClass11BIENDExample();
        class11BIENDDao.createClass11BIEND(class11BIEND1);
                
        Class11BIEND class11BIEND2 = getClass11BIENDExample();
        class11BIENDDao.createClass11BIEND(class11BIEND2);

        // Verify result
        int after = class11BIENDDao.findAllClass11BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_1_1_BI_END.
     * @return Returns a new instance of class Class_1_1_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BIEND getClass11BIENDExample() throws DaoException {
        // fill attributes with example values
        Class11BIEND class11BIEND = new Class11BIEND();
        class11BIEND.setFakeAttr("myFakeAttr");

        Class11BI sourceExample = new Class11BI();
        class11BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class11BIEND); 
        class11BIDao.createClass11BI(sourceExample);

        return class11BIEND;
    }
    
    /**
     * Creates a second example of Class_1_1_BI_END with other values.
     * @return Returns a new instance of class Class_1_1_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BIEND getClass11BIENDExample2() throws DaoException {
        // fill attributes with example values
        Class11BIEND class11BIEND = new Class11BIEND();
        class11BIEND.setFakeAttr("secondFakeAttr");

        Class11BI sourceExample = new Class11BI();
        class11BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class11BIEND); 
        class11BIDao.createClass11BI(sourceExample);

        return class11BIEND;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
