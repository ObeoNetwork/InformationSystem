package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.Class11BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIDao;
// End of user code for import

/**
 * Test class for Class_1_1_BI_END_Sub.
 */
public class Class11BIENDSubTest extends TestCase {

	/**
	 * The DAO for class Class_1_1_BI_END_Sub.
	 */
	private IClass11BIENDSubDao class11BIENDSubDao;

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
		class11BIENDSubDao = SampleDaoFactory.getClass11BIENDSubDao();
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
     * Tests the creation of the entity Class_1_1_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BIENDSub() throws DaoException {
        // fill attributes with example values
        Class11BIENDSub class11BIENDSub = getClass11BIENDSubExample();
        
        // Execute the tested code
        class11BIENDSubDao.createClass11BIENDSub(class11BIENDSub);

        // Verify result
        boolean found = false;
        for (Class11BIENDSub currentClass11BIENDSub : class11BIENDSubDao.findAllClass11BIENDSubs()) {
            if (currentClass11BIENDSub.equals(class11BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11BIENDSub() throws DaoException {
        // Initialized the test
        Class11BIENDSub class11BIENDSub = getClass11BIENDSubExample();
        class11BIENDSubDao.createClass11BIENDSub(class11BIENDSub);

        // Execute the tested code
        class11BIENDSubDao.updateClass11BIENDSub(class11BIENDSub);

        // Verify result
        boolean found = false;
        for (Class11BIENDSub currentClass11BIENDSub : class11BIENDSubDao.findAllClass11BIENDSubs()) {
            if (currentClass11BIENDSub.equals(class11BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class11BIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11BIENDSub() throws DaoException {
        // Initialized the test
        Class11BIENDSub class11BIENDSub = getClass11BIENDSubExample();
        class11BIENDSubDao.createClass11BIENDSub(class11BIENDSub);
        
        // Execute the tested code
        class11BIENDSubDao.deleteClass11BIENDSub(class11BIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class11BIENDSub currentClass11BIENDSub : class11BIENDSubDao.findAllClass11BIENDSubs()) {
            if (currentClass11BIENDSub.getId().equals(class11BIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11BIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11BIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = class11BIENDSubDao.findAllClass11BIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BIENDSub class11BIENDSub1 = getClass11BIENDSubExample();
        class11BIENDSubDao.createClass11BIENDSub(class11BIENDSub1);
                
        Class11BIENDSub class11BIENDSub2 = getClass11BIENDSubExample();
        class11BIENDSubDao.createClass11BIENDSub(class11BIENDSub2);

        // Verify result
        int after = class11BIENDSubDao.findAllClass11BIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_1_1_BI_END_Sub.
     * @return Returns a new instance of class Class_1_1_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BIENDSub getClass11BIENDSubExample() throws DaoException {
        // fill attributes with example values
        Class11BIENDSub class11BIENDSub = new Class11BIENDSub();
        class11BIENDSub.setFakeAttr("myFakeAttr");

        Class11BI sourceExample = new Class11BI();
        class11BIENDSub.setSource(sourceExample);   
        sourceExample.setTarget(class11BIENDSub); 
        class11BIDao.createClass11BI(sourceExample);

        return class11BIENDSub;
    }
    
    /**
     * Creates a second example of Class_1_1_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_1_1_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BIENDSub getClass11BIENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class11BIENDSub class11BIENDSub = new Class11BIENDSub();
        class11BIENDSub.setFakeAttr("secondFakeAttr");

        Class11BI sourceExample = new Class11BI();
        class11BIENDSub.setSource(sourceExample);   
        sourceExample.setTarget(class11BIENDSub); 
        class11BIDao.createClass11BI(sourceExample);

        return class11BIENDSub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
