package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.badpractives.IMyEntityDao;
import org.obeonetwork.sample.badpractives.MyEntity;


// End of user code for import

/**
 * Test class for myEntity.
 */
public class MyEntityTest extends TestCase {

	/**
	 * The DAO for class myEntity.
	 */
	private IMyEntityDao myEntityDao;

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
		myEntityDao = SampleDaoFactory.getMyEntityDao();
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
     * Tests the creation of the entity myEntity.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreatemyEntity() throws DaoException {
        // fill attributes with example values
        MyEntity myEntity = getMyEntityExample();
        
        // Execute the tested code
        myEntityDao.createmyEntity(myEntity);

        // Verify result
        boolean found = false;
        for (MyEntity currentmyEntity : myEntityDao.findAllmyEntitys()) {
            if (currentmyEntity.equals(myEntity)) {
                found = true;
            }
        }
        Assert.assertTrue("myEntity not created", found);
    }

    /**
     * Test the modification of an entity myEntity.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdatemyEntity() throws DaoException {
        // Initialized the test
        MyEntity myEntity = getMyEntityExample();
        myEntityDao.createmyEntity(myEntity);

        // Execute the tested code
        myEntity.setAttr1(new Integer(-1407244862));
        myEntity.setPrivate_(new Integer(-314497661));
        myEntity.setPublic_(new Integer(-977423767));
        myEntity.setProtected_("secondProtected");
        myEntity.setNull_("secondNull");
        myEntity.setString("secondString");
        myEntity.setA(new Float(224.0));
        myEntityDao.updatemyEntity(myEntity);

        // Verify result
        boolean found = false;
        for (MyEntity currentmyEntity : myEntityDao.findAllmyEntitys()) {
            if (currentmyEntity.equals(myEntity)) {
                found = true;
                Assert.assertEquals("Value attr1 not modified",
                        new Integer(-1407244862),
                        myEntity.getAttr1());
                Assert.assertEquals("Value private_ not modified",
                        new Integer(-314497661),
                        myEntity.getPrivate_());
                Assert.assertEquals("Value public_ not modified",
                        new Integer(-977423767),
                        myEntity.getPublic_());
                Assert.assertEquals("Value protected_ not modified",
                        "secondProtected",
                        myEntity.getProtected_());
                Assert.assertEquals("Value null_ not modified",
                        "secondNull",
                        myEntity.getNull_());
                Assert.assertEquals("Value string not modified",
                        "secondString",
                        myEntity.getString());
                Assert.assertEquals("Value a not modified",
                        new Float(224.0),
                        myEntity.getA());
            }
        }
        Assert.assertTrue("myEntity not found", found);
    }

    /**
     * Test the suppression of an entity myEntity.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeletemyEntity() throws DaoException {
        // Initialized the test
        MyEntity myEntity = getMyEntityExample();
        myEntityDao.createmyEntity(myEntity);
        
        // Execute the tested code
        myEntityDao.deletemyEntity(myEntity);
        
        // Verify result
        boolean found = false;
        for (MyEntity currentmyEntity : myEntityDao.findAllmyEntitys()) {
            if (currentmyEntity.getId().equals(myEntity.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("myEntity not deleted", found);
    }

    /**
     * Test the search of all entities myEntity.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllmyEntitys() throws DaoException {
        // Verify number of element before testing
        int before = myEntityDao.findAllmyEntitys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        MyEntity myEntity1 = getMyEntityExample();
        myEntityDao.createmyEntity(myEntity1);
                
        MyEntity myEntity2 = getMyEntityExample();
        myEntityDao.createmyEntity(myEntity2);

        // Verify result
        int after = myEntityDao.findAllmyEntitys().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of myEntity.
     * @return Returns a new instance of class myEntity, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected MyEntity getMyEntityExample() throws DaoException {
        // fill attributes with example values
        MyEntity myEntity = new MyEntity();
        myEntity.setAttr1(new Integer(-1407244862 + 1));
        myEntity.setPrivate_(new Integer(-314497661 + 1));
        myEntity.setPublic_(new Integer(-977423767 + 1));
        myEntity.setProtected_("myProtected");
        myEntity.setNull_("myNull");
        myEntity.setString("myString");
        myEntity.setA(new Float(224.1));


        return myEntity;
    }
    
    /**
     * Creates a second example of myEntity with other values.
     * @return Returns a new instance of class myEntity with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected MyEntity getMyEntityExample2() throws DaoException {
        // fill attributes with example values
        MyEntity myEntity = new MyEntity();
        myEntity.setAttr1(new Integer(-1407244862));
        myEntity.setPrivate_(new Integer(-314497661));
        myEntity.setPublic_(new Integer(-977423767));
        myEntity.setProtected_("secondProtected");
        myEntity.setNull_("secondNull");
        myEntity.setString("secondString");
        myEntity.setA(new Float(224.0));


        return myEntity;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
