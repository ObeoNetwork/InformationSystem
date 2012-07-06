package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01;


// End of user code for import

/**
 * Test class for Class_Many_01.
 */
public class ClassMany01Test extends TestCase {

	/**
	 * The DAO for class Class_Many_01.
	 */
	private IClassMany01Dao classMany01Dao;

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
		classMany01Dao = SampleDaoFactory.getClassMany01Dao();
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
     * Tests the creation of the entity Class_Many_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01() throws DaoException {
        // fill attributes with example values
        ClassMany01 classMany01 = getClassMany01Example();
        
        // Execute the tested code
        classMany01Dao.createClassMany01(classMany01);

        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : classMany01Dao.findAllClassMany01s()) {
            if (currentClassMany01.equals(classMany01)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01 not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01() throws DaoException {
        // Initialized the test
        ClassMany01 classMany01 = getClassMany01Example();
        classMany01Dao.createClassMany01(classMany01);

        // Execute the tested code
        classMany01.setFakeAttr("secondFakeAttr");
        classMany01Dao.updateClassMany01(classMany01);

        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : classMany01Dao.findAllClassMany01s()) {
            if (currentClassMany01.equals(classMany01)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        classMany01.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassMany01 not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01() throws DaoException {
        // Initialized the test
        ClassMany01 classMany01 = getClassMany01Example();
        classMany01Dao.createClassMany01(classMany01);
        
        // Execute the tested code
        classMany01Dao.deleteClassMany01(classMany01);
        
        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : classMany01Dao.findAllClassMany01s()) {
            if (currentClassMany01.getId().equals(classMany01.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01 not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01s() throws DaoException {
        // Verify number of element before testing
        int before = classMany01Dao.findAllClassMany01s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01 classMany011 = getClassMany01Example();
        classMany01Dao.createClassMany01(classMany011);
                
        ClassMany01 classMany012 = getClassMany01Example();
        classMany01Dao.createClassMany01(classMany012);

        // Verify result
        int after = classMany01Dao.findAllClassMany01s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_Many_01.
     * @return Returns a new instance of class Class_Many_01, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01 getClassMany01Example() throws DaoException {
        // fill attributes with example values
        ClassMany01 classMany01 = new ClassMany01();
        classMany01.setFakeAttr("myFakeAttr");


        return classMany01;
    }
    
    /**
     * Creates a second example of Class_Many_01 with other values.
     * @return Returns a new instance of class Class_Many_01 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01 getClassMany01Example2() throws DaoException {
        // fill attributes with example values
        ClassMany01 classMany01 = new ClassMany01();
        classMany01.setFakeAttr("secondFakeAttr");


        return classMany01;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
