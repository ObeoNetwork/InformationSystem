package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IClass011SubDao;
import org.obeonetwork.sample.inheritanceassociations.Class011Sub;
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao;
// End of user code for import

/**
 * Test class for Class_01_1_Sub.
 */
public class Class011SubTest extends TestCase {

	/**
	 * The DAO for class Class_01_1_Sub.
	 */
	private IClass011SubDao class011SubDao;

	/**
	 * The DAO for class Class_01_1_END.
	 */
	private IClass011ENDDao class011ENDDao;

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
		class011SubDao = SampleDaoFactory.getClass011SubDao();
		class011ENDDao = SampleDaoFactory.getClass011ENDDao();
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
     * Tests the creation of the entity Class_01_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011Sub() throws DaoException {
        // fill attributes with example values
        Class011Sub class011Sub = getClass011SubExample();
        
        // Execute the tested code
        class011SubDao.createClass011Sub(class011Sub);

        // Verify result
        boolean found = false;
        for (Class011Sub currentClass011Sub : class011SubDao.findAllClass011Subs()) {
            if (currentClass011Sub.equals(class011Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011Sub() throws DaoException {
        // Initialized the test
        Class011Sub class011Sub = getClass011SubExample();
        class011SubDao.createClass011Sub(class011Sub);

        // Execute the tested code
        class011SubDao.updateClass011Sub(class011Sub);

        // Verify result
        boolean found = false;
        for (Class011Sub currentClass011Sub : class011SubDao.findAllClass011Subs()) {
            if (currentClass011Sub.equals(class011Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class011Sub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011Sub() throws DaoException {
        // Initialized the test
        Class011Sub class011Sub = getClass011SubExample();
        class011SubDao.createClass011Sub(class011Sub);
        
        // Execute the tested code
        class011SubDao.deleteClass011Sub(class011Sub);
        
        // Verify result
        boolean found = false;
        for (Class011Sub currentClass011Sub : class011SubDao.findAllClass011Subs()) {
            if (currentClass011Sub.getId().equals(class011Sub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011Sub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011Subs() throws DaoException {
        // Verify number of element before testing
        int before = class011SubDao.findAllClass011Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011Sub class011Sub1 = getClass011SubExample();
        class011SubDao.createClass011Sub(class011Sub1);
                
        Class011Sub class011Sub2 = getClass011SubExample();
        class011SubDao.createClass011Sub(class011Sub2);

        // Verify result
        int after = class011SubDao.findAllClass011Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_1_Sub.
     * @return Returns a new instance of class Class_01_1_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011Sub getClass011SubExample() throws DaoException {
        // fill attributes with example values
        Class011Sub class011Sub = new Class011Sub();
        class011Sub.setFakeAttr("myFakeAttr");

        Class011END targetExample = new Class011END();
        class011Sub.setTarget(targetExample);   
        class011ENDDao.createClass011END(targetExample);

        return class011Sub;
    }
    
    /**
     * Creates a second example of Class_01_1_Sub with other values.
     * @return Returns a new instance of class Class_01_1_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011Sub getClass011SubExample2() throws DaoException {
        // fill attributes with example values
        Class011Sub class011Sub = new Class011Sub();
        class011Sub.setFakeAttr("secondFakeAttr");

        Class011END targetExample = new Class011END();
        class011Sub.setTarget(targetExample);   
        class011ENDDao.createClass011END(targetExample);

        return class011Sub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
