package org.obeonetwork.sample.attributes.test;

// Start of user code for import 
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.attributes.IAttributesDao;
import org.obeonetwork.sample.attributes.Cardinality;
import org.obeonetwork.sample.attributes.PrimitiveType;
// End of user code for import

/**
 * Test class for attributes.
 */
public class AttributesTest extends TestCase {

	/**
	 * The DAO for class attributes.
	 */
	private IAttributesDao attributesDao;

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
		attributesDao = SampleDaoFactory.getAttributesDao();
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
     * Tests the creation of the entity Cardinality.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateCardinality() throws DaoException {
        // fill attributes with example values
        Cardinality cardinality = getCardinalityExample();
        
        // Execute the tested code
        attributesDao.createCardinality(cardinality);

        // Verify result
        boolean found = false;
        for (Cardinality currentCardinality : attributesDao.findAllCardinalitys()) {
            if (currentCardinality.equals(cardinality)) {
                found = true;
            }
        }
        Assert.assertTrue("Cardinality not created", found);
    }

    /**
     * Test the modification of an entity Cardinality.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateCardinality() throws DaoException {
        // Initialized the test
        Cardinality cardinality = getCardinalityExample();
        attributesDao.createCardinality(cardinality);

        // Execute the tested code
        cardinality.setOne("secondOne");
        cardinality.setZeroOrOne("secondZeroOrOne");
        attributesDao.updateCardinality(cardinality);

        // Verify result
        boolean found = false;
        for (Cardinality currentCardinality : attributesDao.findAllCardinalitys()) {
            if (currentCardinality.equals(cardinality)) {
                found = true;
                Assert.assertEquals("Value one not modified",
                        "secondOne",
                        cardinality.getOne());
                Assert.assertEquals("Value zeroOrOne not modified",
                        "secondZeroOrOne",
                        cardinality.getZeroOrOne());
            }
        }
        Assert.assertTrue("Cardinality not found", found);
    }

    /**
     * Test the suppression of an entity Cardinality.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteCardinality() throws DaoException {
        // Initialized the test
        Cardinality cardinality = getCardinalityExample();
        attributesDao.createCardinality(cardinality);
        
        // Execute the tested code
        attributesDao.deleteCardinality(cardinality);
        
        // Verify result
        boolean found = false;
        for (Cardinality currentCardinality : attributesDao.findAllCardinalitys()) {
            if (currentCardinality.getId().equals(cardinality.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Cardinality not deleted", found);
    }

    /**
     * Test the search of all entities Cardinality.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllCardinalitys() throws DaoException {
        // Verify number of element before testing
        int before = attributesDao.findAllCardinalitys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Cardinality cardinality1 = getCardinalityExample();
        attributesDao.createCardinality(cardinality1);
                
        Cardinality cardinality2 = getCardinalityExample();
        attributesDao.createCardinality(cardinality2);

        // Verify result
        int after = attributesDao.findAllCardinalitys().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity PrimitiveType.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreatePrimitiveType() throws DaoException {
        // fill attributes with example values
        PrimitiveType primitiveType = getPrimitiveTypeExample();
        
        // Execute the tested code
        attributesDao.createPrimitiveType(primitiveType);

        // Verify result
        boolean found = false;
        for (PrimitiveType currentPrimitiveType : attributesDao.findAllPrimitiveTypes()) {
            if (currentPrimitiveType.equals(primitiveType)) {
                found = true;
            }
        }
        Assert.assertTrue("PrimitiveType not created", found);
    }

    /**
     * Test the modification of an entity PrimitiveType.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdatePrimitiveType() throws DaoException {
        // Initialized the test
        PrimitiveType primitiveType = getPrimitiveTypeExample();
        attributesDao.createPrimitiveType(primitiveType);

        // Execute the tested code
        primitiveType.setStringAttribute("secondStringAttribute");
        primitiveType.setIntegerAttribute(new Integer(-1427190018));
        primitiveType.setBooleanAttribute(new Boolean(false));
        primitiveType.setDoubleAttribute(new Double(-1502475829.0));
        primitiveType.setEmailAttribute("secondEmailAttribute");
        primitiveType.setDateAttribute(new Date(1));
        primitiveType.setFloatAttribute(new Float(-2016112736.0));
        primitiveType.setLongAttribute(new Long(-1319596160));
        attributesDao.updatePrimitiveType(primitiveType);

        // Verify result
        boolean found = false;
        for (PrimitiveType currentPrimitiveType : attributesDao.findAllPrimitiveTypes()) {
            if (currentPrimitiveType.equals(primitiveType)) {
                found = true;
                Assert.assertEquals("Value stringAttribute not modified",
                        "secondStringAttribute",
                        primitiveType.getStringAttribute());
                Assert.assertEquals("Value integerAttribute not modified",
                        new Integer(-1427190018),
                        primitiveType.getIntegerAttribute());
                Assert.assertEquals("Value booleanAttribute not modified",
                        new Boolean(false),
                        primitiveType.getBooleanAttribute());
                Assert.assertEquals("Value doubleAttribute not modified",
                        new Double(-1502475829.0),
                        primitiveType.getDoubleAttribute());
                Assert.assertEquals("Value emailAttribute not modified",
                        "secondEmailAttribute",
                        primitiveType.getEmailAttribute());
                Assert.assertEquals("Value dateAttribute not modified",
                        new Date(1),
                        primitiveType.getDateAttribute());
                Assert.assertEquals("Value floatAttribute not modified",
                        new Float(-2016112736.0),
                        primitiveType.getFloatAttribute());
                Assert.assertEquals("Value longAttribute not modified",
                        new Long(-1319596160),
                        primitiveType.getLongAttribute());
            }
        }
        Assert.assertTrue("PrimitiveType not found", found);
    }

    /**
     * Test the suppression of an entity PrimitiveType.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeletePrimitiveType() throws DaoException {
        // Initialized the test
        PrimitiveType primitiveType = getPrimitiveTypeExample();
        attributesDao.createPrimitiveType(primitiveType);
        
        // Execute the tested code
        attributesDao.deletePrimitiveType(primitiveType);
        
        // Verify result
        boolean found = false;
        for (PrimitiveType currentPrimitiveType : attributesDao.findAllPrimitiveTypes()) {
            if (currentPrimitiveType.getId().equals(primitiveType.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("PrimitiveType not deleted", found);
    }

    /**
     * Test the search of all entities PrimitiveType.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllPrimitiveTypes() throws DaoException {
        // Verify number of element before testing
        int before = attributesDao.findAllPrimitiveTypes().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        PrimitiveType primitiveType1 = getPrimitiveTypeExample();
        attributesDao.createPrimitiveType(primitiveType1);
                
        PrimitiveType primitiveType2 = getPrimitiveTypeExample();
        attributesDao.createPrimitiveType(primitiveType2);

        // Verify result
        int after = attributesDao.findAllPrimitiveTypes().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Cardinality.
     * @return Returns a new instance of class Cardinality, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Cardinality getCardinalityExample() throws DaoException {
        // fill attributes with example values
        Cardinality cardinality = new Cardinality();
        cardinality.setOne("myOne");
        cardinality.setZeroOrOne("myZeroOrOne");
        List<String> listOneOrMany = new ArrayList<String>();
        listOneOrMany.add("myOneOrMany");
        cardinality.setOneOrMany(listOneOrMany);
        List<String> listZeroOrMany = new ArrayList<String>();
        listZeroOrMany.add("myZeroOrMany");
        cardinality.setZeroOrMany(listZeroOrMany);


        return cardinality;
    }
    
    /**
     * Creates a second example of Cardinality with other values.
     * @return Returns a new instance of class Cardinality with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Cardinality getCardinalityExample2() throws DaoException {
        // fill attributes with example values
        Cardinality cardinality = new Cardinality();
        cardinality.setOne("secondOne");
        cardinality.setZeroOrOne("secondZeroOrOne");
        List<String> listOneOrMany = new ArrayList<String>();
        listOneOrMany.add("secondOneOrMany");
        cardinality.setOneOrMany(listOneOrMany);
        List<String> listZeroOrMany = new ArrayList<String>();
        listZeroOrMany.add("secondZeroOrMany");
        cardinality.setZeroOrMany(listZeroOrMany);


        return cardinality;
    }
   /**
     * Creates an example of PrimitiveType.
     * @return Returns a new instance of class PrimitiveType, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected PrimitiveType getPrimitiveTypeExample() throws DaoException {
        // fill attributes with example values
        PrimitiveType primitiveType = new PrimitiveType();
        primitiveType.setStringAttribute("myStringAttribute");
        primitiveType.setIntegerAttribute(new Integer(-1427190018 + 1));
        primitiveType.setBooleanAttribute(new Boolean(false));
        primitiveType.setDoubleAttribute(new Double(-1502475829.1));
        primitiveType.setEmailAttribute("myEmailAttribute");
        primitiveType.setDateAttribute(new Date(0));
        primitiveType.setFloatAttribute(new Float(-2016112736.1));
        primitiveType.setLongAttribute(new Long(-1319596160 + 1));


        return primitiveType;
    }
    
    /**
     * Creates a second example of PrimitiveType with other values.
     * @return Returns a new instance of class PrimitiveType with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected PrimitiveType getPrimitiveTypeExample2() throws DaoException {
        // fill attributes with example values
        PrimitiveType primitiveType = new PrimitiveType();
        primitiveType.setStringAttribute("secondStringAttribute");
        primitiveType.setIntegerAttribute(new Integer(-1427190018));
        primitiveType.setBooleanAttribute(new Boolean(false));
        primitiveType.setDoubleAttribute(new Double(-1502475829.0));
        primitiveType.setEmailAttribute("secondEmailAttribute");
        primitiveType.setDateAttribute(new Date(1));
        primitiveType.setFloatAttribute(new Float(-2016112736.0));
        primitiveType.setLongAttribute(new Long(-1319596160));


        return primitiveType;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
