package org.obeonetwork.sample.types.test;

// Start of user code for import 
import java.util.Date;
import org.hibernate.Transaction;
import junit.framework.Assert;
import junit.framework.TestCase;


import org.obeonetwork.sample.SampleDaoFactory;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.types.ITypesDao;
import org.obeonetwork.sample.types.Types;


// End of user code for import

/**
 * Test class for Types.
 */
public class TypesTest extends TestCase {

	/**
	 * The DAO for class Types.
	 */
	private ITypesDao typesDao;

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
		typesDao = SampleDaoFactory.getTypesDao();
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
     * Tests the creation of the entity Types.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateTypes() throws DaoException {
        // fill attributes with example values
        Types types = getTypesExample();
        
        // Execute the tested code
        typesDao.createTypes(types);

        // Verify result
        boolean found = false;
        for (Types currentTypes : typesDao.findAllTypess()) {
            if (currentTypes.equals(types)) {
                found = true;
            }
        }
        Assert.assertTrue("Types not created", found);
    }

    /**
     * Test the modification of an entity Types.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateTypes() throws DaoException {
        // Initialized the test
        Types types = getTypesExample();
        typesDao.createTypes(types);

        // Execute the tested code
        types.setMyBoolean(new Boolean(false));
        types.setMyDate(new Date(1));
        types.setMyDouble(new Double(-1240562531.0));
        types.setMyMail("secondMyMail");
        types.setMyFloat(new Float(1485754384.0));
        types.setMyInteger(new Integer(310350322));
        types.setMyLong(new Long(-1060269496));
        types.setMyString("secondMyString");
        typesDao.updateTypes(types);

        // Verify result
        boolean found = false;
        for (Types currentTypes : typesDao.findAllTypess()) {
            if (currentTypes.equals(types)) {
                found = true;
                Assert.assertEquals("Value myBoolean not modified",
                        new Boolean(false),
                        types.getMyBoolean());
                Assert.assertEquals("Value myDate not modified",
                        new Date(1),
                        types.getMyDate());
                Assert.assertEquals("Value myDouble not modified",
                        new Double(-1240562531.0),
                        types.getMyDouble());
                Assert.assertEquals("Value myMail not modified",
                        "secondMyMail",
                        types.getMyMail());
                Assert.assertEquals("Value myFloat not modified",
                        new Float(1485754384.0),
                        types.getMyFloat());
                Assert.assertEquals("Value myInteger not modified",
                        new Integer(310350322),
                        types.getMyInteger());
                Assert.assertEquals("Value myLong not modified",
                        new Long(-1060269496),
                        types.getMyLong());
                Assert.assertEquals("Value myString not modified",
                        "secondMyString",
                        types.getMyString());
            }
        }
        Assert.assertTrue("Types not found", found);
    }

    /**
     * Test the suppression of an entity Types.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteTypes() throws DaoException {
        // Initialized the test
        Types types = getTypesExample();
        typesDao.createTypes(types);
        
        // Execute the tested code
        typesDao.deleteTypes(types);
        
        // Verify result
        boolean found = false;
        for (Types currentTypes : typesDao.findAllTypess()) {
            if (currentTypes.getId().equals(types.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Types not deleted", found);
    }

    /**
     * Test the search of all entities Types.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllTypess() throws DaoException {
        // Verify number of element before testing
        int before = typesDao.findAllTypess().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Types types1 = getTypesExample();
        typesDao.createTypes(types1);
                
        Types types2 = getTypesExample();
        typesDao.createTypes(types2);

        // Verify result
        int after = typesDao.findAllTypess().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Types.
     * @return Returns a new instance of class Types, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Types getTypesExample() throws DaoException {
        // fill attributes with example values
        Types types = new Types();
        types.setMyBoolean(new Boolean(false));
        types.setMyDate(new Date(0));
        types.setMyDouble(new Double(-1240562531.1));
        types.setMyMail("myMyMail");
        types.setMyFloat(new Float(1485754384.1));
        types.setMyInteger(new Integer(310350322 + 1));
        types.setMyLong(new Long(-1060269496 + 1));
        types.setMyString("myMyString");


        return types;
    }
    
    /**
     * Creates a second example of Types with other values.
     * @return Returns a new instance of class Types with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Types getTypesExample2() throws DaoException {
        // fill attributes with example values
        Types types = new Types();
        types.setMyBoolean(new Boolean(false));
        types.setMyDate(new Date(1));
        types.setMyDouble(new Double(-1240562531.0));
        types.setMyMail("secondMyMail");
        types.setMyFloat(new Float(1485754384.0));
        types.setMyInteger(new Integer(310350322));
        types.setMyLong(new Long(-1060269496));
        types.setMyString("secondMyString");


        return types;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
