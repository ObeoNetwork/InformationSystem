package org.obeonetwork.sample.associations.test;

// Start of user code for import 
import java.util.Date;

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.associations.IAssociationsDao;
import org.obeonetwork.sample.associations.Class0101;
import org.obeonetwork.sample.associations.Class0101END;
import org.obeonetwork.sample.associations.Class0101BI;
import org.obeonetwork.sample.associations.Class0101BIEND;
import org.obeonetwork.sample.associations.Class101;
import org.obeonetwork.sample.associations.Class101END;
import org.obeonetwork.sample.associations.Class101BI;
import org.obeonetwork.sample.associations.Class101BIEND;
import org.obeonetwork.sample.associations.Class101BI;
import org.obeonetwork.sample.associations.Class011;
import org.obeonetwork.sample.associations.Class011END;
import org.obeonetwork.sample.associations.Class011END;
import org.obeonetwork.sample.associations.Class011BI;
import org.obeonetwork.sample.associations.Class011BIEND;
import org.obeonetwork.sample.associations.Class011BIEND;
import org.obeonetwork.sample.associations.Class11;
import org.obeonetwork.sample.associations.Class11END;
import org.obeonetwork.sample.associations.Class11END;
import org.obeonetwork.sample.associations.Class11BI;
import org.obeonetwork.sample.associations.Class11BIEND;
import org.obeonetwork.sample.associations.Class11BIEND;
import org.obeonetwork.sample.associations.Class11BI;
import org.obeonetwork.sample.associations.Class01Many;
import org.obeonetwork.sample.associations.Class01ManyEND;
import org.obeonetwork.sample.associations.Class01ManyBI;
import org.obeonetwork.sample.associations.Class01ManyBIEND;
import org.obeonetwork.sample.associations.ClassMany01;
import org.obeonetwork.sample.associations.ClassMany01END;
import org.obeonetwork.sample.associations.ClassMany01BI;
import org.obeonetwork.sample.associations.ClassMany01BIEND;
import org.obeonetwork.sample.associations.ClassManyMany;
import org.obeonetwork.sample.associations.ClassManyManyEnd;
import org.obeonetwork.sample.associations.ClassManyManyBI;
import org.obeonetwork.sample.associations.ClassManyManyBIEND;
// End of user code for import

/**
 * Test class for associations.
 */
public class AssociationsTest extends TestCase {

	/**
	 * The DAO for class associations.
	 */
	private IAssociationsDao associationsDao;

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
		associationsDao = SampleDaoFactory.getAssociationsDao();
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
     * Tests the creation of the entity Class_01_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101() throws DaoException {
        // fill attributes with example values
        Class0101 class0101 = getClass0101Example();
        
        // Execute the tested code
        associationsDao.createClass0101(class0101);

        // Verify result
        boolean found = false;
        for (Class0101 currentClass0101 : associationsDao.findAllClass0101s()) {
            if (currentClass0101.equals(class0101)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01 not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101() throws DaoException {
        // Initialized the test
        Class0101 class0101 = getClass0101Example();
        associationsDao.createClass0101(class0101);

        // Execute the tested code
        class0101.setFakeAttr("secondFakeAttr");
        associationsDao.updateClass0101(class0101);

        // Verify result
        boolean found = false;
        for (Class0101 currentClass0101 : associationsDao.findAllClass0101s()) {
            if (currentClass0101.equals(class0101)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class0101.getFakeAttr());
            }
        }
        Assert.assertTrue("Class0101 not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101() throws DaoException {
        // Initialized the test
        Class0101 class0101 = getClass0101Example();
        associationsDao.createClass0101(class0101);
        
        // Execute the tested code
        associationsDao.deleteClass0101(class0101);
        
        // Verify result
        boolean found = false;
        for (Class0101 currentClass0101 : associationsDao.findAllClass0101s()) {
            if (currentClass0101.getId().equals(class0101.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101 not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101s() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass0101s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101 class01011 = getClass0101Example();
        associationsDao.createClass0101(class01011);
                
        Class0101 class01012 = getClass0101Example();
        associationsDao.createClass0101(class01012);

        // Verify result
        int after = associationsDao.findAllClass0101s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101END() throws DaoException {
        // fill attributes with example values
        Class0101END class0101END = getClass0101ENDExample();
        
        // Execute the tested code
        associationsDao.createClass0101END(class0101END);

        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : associationsDao.findAllClass0101ENDs()) {
            if (currentClass0101END.equals(class0101END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101END() throws DaoException {
        // Initialized the test
        Class0101END class0101END = getClass0101ENDExample();
        associationsDao.createClass0101END(class0101END);

        // Execute the tested code
        class0101END.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass0101END(class0101END);

        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : associationsDao.findAllClass0101ENDs()) {
            if (currentClass0101END.equals(class0101END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class0101END.getFakeAttr());
            }
        }
        Assert.assertTrue("Class0101END not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101END() throws DaoException {
        // Initialized the test
        Class0101END class0101END = getClass0101ENDExample();
        associationsDao.createClass0101END(class0101END);
        
        // Execute the tested code
        associationsDao.deleteClass0101END(class0101END);
        
        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : associationsDao.findAllClass0101ENDs()) {
            if (currentClass0101END.getId().equals(class0101END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101END not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101ENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass0101ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101END class0101END1 = getClass0101ENDExample();
        associationsDao.createClass0101END(class0101END1);
                
        Class0101END class0101END2 = getClass0101ENDExample();
        associationsDao.createClass0101END(class0101END2);

        // Verify result
        int after = associationsDao.findAllClass0101ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101BI() throws DaoException {
        // fill attributes with example values
        Class0101BI class0101BI = getClass0101BIExample();
        
        // Execute the tested code
        associationsDao.createClass0101BI(class0101BI);

        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : associationsDao.findAllClass0101BIs()) {
            if (currentClass0101BI.equals(class0101BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101BI() throws DaoException {
        // Initialized the test
        Class0101BI class0101BI = getClass0101BIExample();
        associationsDao.createClass0101BI(class0101BI);

        // Execute the tested code
        class0101BI.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass0101BI(class0101BI);

        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : associationsDao.findAllClass0101BIs()) {
            if (currentClass0101BI.equals(class0101BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class0101BI.getFakeAttr());
            }
        }
        Assert.assertTrue("Class0101BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101BI() throws DaoException {
        // Initialized the test
        Class0101BI class0101BI = getClass0101BIExample();
        associationsDao.createClass0101BI(class0101BI);
        
        // Execute the tested code
        associationsDao.deleteClass0101BI(class0101BI);
        
        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : associationsDao.findAllClass0101BIs()) {
            if (currentClass0101BI.getId().equals(class0101BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101BIs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass0101BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BI class0101BI1 = getClass0101BIExample();
        associationsDao.createClass0101BI(class0101BI1);
                
        Class0101BI class0101BI2 = getClass0101BIExample();
        associationsDao.createClass0101BI(class0101BI2);

        // Verify result
        int after = associationsDao.findAllClass0101BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101BIEND() throws DaoException {
        // fill attributes with example values
        Class0101BIEND class0101BIEND = getClass0101BIENDExample();
        
        // Execute the tested code
        associationsDao.createClass0101BIEND(class0101BIEND);

        // Verify result
        boolean found = false;
        for (Class0101BIEND currentClass0101BIEND : associationsDao.findAllClass0101BIENDs()) {
            if (currentClass0101BIEND.equals(class0101BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101BIEND() throws DaoException {
        // Initialized the test
        Class0101BIEND class0101BIEND = getClass0101BIENDExample();
        associationsDao.createClass0101BIEND(class0101BIEND);

        // Execute the tested code
        class0101BIEND.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass0101BIEND(class0101BIEND);

        // Verify result
        boolean found = false;
        for (Class0101BIEND currentClass0101BIEND : associationsDao.findAllClass0101BIENDs()) {
            if (currentClass0101BIEND.equals(class0101BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class0101BIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("Class0101BIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101BIEND() throws DaoException {
        // Initialized the test
        Class0101BIEND class0101BIEND = getClass0101BIENDExample();
        associationsDao.createClass0101BIEND(class0101BIEND);
        
        // Execute the tested code
        associationsDao.deleteClass0101BIEND(class0101BIEND);
        
        // Verify result
        boolean found = false;
        for (Class0101BIEND currentClass0101BIEND : associationsDao.findAllClass0101BIENDs()) {
            if (currentClass0101BIEND.getId().equals(class0101BIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101BIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101BIENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass0101BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BIEND class0101BIEND1 = getClass0101BIENDExample();
        associationsDao.createClass0101BIEND(class0101BIEND1);
                
        Class0101BIEND class0101BIEND2 = getClass0101BIENDExample();
        associationsDao.createClass0101BIEND(class0101BIEND2);

        // Verify result
        int after = associationsDao.findAllClass0101BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101() throws DaoException {
        // fill attributes with example values
        Class101 class101 = getClass101Example();
        
        // Execute the tested code
        associationsDao.createClass101(class101);

        // Verify result
        boolean found = false;
        for (Class101 currentClass101 : associationsDao.findAllClass101s()) {
            if (currentClass101.equals(class101)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01 not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101() throws DaoException {
        // Initialized the test
        Class101 class101 = getClass101Example();
        associationsDao.createClass101(class101);

        // Execute the tested code
        class101.setFakeAttr("secondFakeAttr");
        associationsDao.updateClass101(class101);

        // Verify result
        boolean found = false;
        for (Class101 currentClass101 : associationsDao.findAllClass101s()) {
            if (currentClass101.equals(class101)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class101.getFakeAttr());
            }
        }
        Assert.assertTrue("Class101 not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101() throws DaoException {
        // Initialized the test
        Class101 class101 = getClass101Example();
        associationsDao.createClass101(class101);
        
        // Execute the tested code
        associationsDao.deleteClass101(class101);
        
        // Verify result
        boolean found = false;
        for (Class101 currentClass101 : associationsDao.findAllClass101s()) {
            if (currentClass101.getId().equals(class101.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101 not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101s() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass101s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101 class1011 = getClass101Example();
        associationsDao.createClass101(class1011);
                
        Class101 class1012 = getClass101Example();
        associationsDao.createClass101(class1012);

        // Verify result
        int after = associationsDao.findAllClass101s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101END() throws DaoException {
        // fill attributes with example values
        Class101END class101END = getClass101ENDExample();
        
        // Execute the tested code
        associationsDao.createClass101END(class101END);

        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : associationsDao.findAllClass101ENDs()) {
            if (currentClass101END.equals(class101END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_END not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101END() throws DaoException {
        // Initialized the test
        Class101END class101END = getClass101ENDExample();
        associationsDao.createClass101END(class101END);

        // Execute the tested code
        class101END.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass101END(class101END);

        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : associationsDao.findAllClass101ENDs()) {
            if (currentClass101END.equals(class101END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class101END.getFakeAttr());
            }
        }
        Assert.assertTrue("Class101END not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101END() throws DaoException {
        // Initialized the test
        Class101END class101END = getClass101ENDExample();
        associationsDao.createClass101END(class101END);
        
        // Execute the tested code
        associationsDao.deleteClass101END(class101END);
        
        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : associationsDao.findAllClass101ENDs()) {
            if (currentClass101END.getId().equals(class101END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101END not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101ENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass101ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101END class101END1 = getClass101ENDExample();
        associationsDao.createClass101END(class101END1);
                
        Class101END class101END2 = getClass101ENDExample();
        associationsDao.createClass101END(class101END2);

        // Verify result
        int after = associationsDao.findAllClass101ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101BI() throws DaoException {
        // fill attributes with example values
        Class101BI class101BI = getClass101BIExample();
        
        // Execute the tested code
        associationsDao.createClass101BI(class101BI);

        // Verify result
        boolean found = false;
        for (Class101BI currentClass101BI : associationsDao.findAllClass101BIs()) {
            if (currentClass101BI.equals(class101BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101BI() throws DaoException {
        // Initialized the test
        Class101BI class101BI = getClass101BIExample();
        associationsDao.createClass101BI(class101BI);

        // Execute the tested code
        associationsDao.updateClass101BI(class101BI);

        // Verify result
        boolean found = false;
        for (Class101BI currentClass101BI : associationsDao.findAllClass101BIs()) {
            if (currentClass101BI.equals(class101BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101BI() throws DaoException {
        // Initialized the test
        Class101BI class101BI = getClass101BIExample();
        associationsDao.createClass101BI(class101BI);
        
        // Execute the tested code
        associationsDao.deleteClass101BI(class101BI);
        
        // Verify result
        boolean found = false;
        for (Class101BI currentClass101BI : associationsDao.findAllClass101BIs()) {
            if (currentClass101BI.getId().equals(class101BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101BIs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass101BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BI class101BI1 = getClass101BIExample();
        associationsDao.createClass101BI(class101BI1);
                
        Class101BI class101BI2 = getClass101BIExample();
        associationsDao.createClass101BI(class101BI2);

        // Verify result
        int after = associationsDao.findAllClass101BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101BIEND() throws DaoException {
        // fill attributes with example values
        Class101BIEND class101BIEND = getClass101BIENDExample();
        
        // Execute the tested code
        associationsDao.createClass101BIEND(class101BIEND);

        // Verify result
        boolean found = false;
        for (Class101BIEND currentClass101BIEND : associationsDao.findAllClass101BIENDs()) {
            if (currentClass101BIEND.equals(class101BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101BIEND() throws DaoException {
        // Initialized the test
        Class101BIEND class101BIEND = getClass101BIENDExample();
        associationsDao.createClass101BIEND(class101BIEND);

        // Execute the tested code
        associationsDao.updateClass101BIEND(class101BIEND);

        // Verify result
        boolean found = false;
        for (Class101BIEND currentClass101BIEND : associationsDao.findAllClass101BIENDs()) {
            if (currentClass101BIEND.equals(class101BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101BIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101BIEND() throws DaoException {
        // Initialized the test
        Class101BIEND class101BIEND = getClass101BIENDExample();
        associationsDao.createClass101BIEND(class101BIEND);
        
        // Execute the tested code
        associationsDao.deleteClass101BIEND(class101BIEND);
        
        // Verify result
        boolean found = false;
        for (Class101BIEND currentClass101BIEND : associationsDao.findAllClass101BIENDs()) {
            if (currentClass101BIEND.getId().equals(class101BIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101BIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101BIENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass101BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BIEND class101BIEND1 = getClass101BIENDExample();
        associationsDao.createClass101BIEND(class101BIEND1);
                
        Class101BIEND class101BIEND2 = getClass101BIENDExample();
        associationsDao.createClass101BIEND(class101BIEND2);

        // Verify result
        int after = associationsDao.findAllClass101BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011() throws DaoException {
        // fill attributes with example values
        Class011 class011 = getClass011Example();
        
        // Execute the tested code
        associationsDao.createClass011(class011);

        // Verify result
        boolean found = false;
        for (Class011 currentClass011 : associationsDao.findAllClass011s()) {
            if (currentClass011.equals(class011)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1 not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011() throws DaoException {
        // Initialized the test
        Class011 class011 = getClass011Example();
        associationsDao.createClass011(class011);

        // Execute the tested code
        class011.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass011(class011);

        // Verify result
        boolean found = false;
        for (Class011 currentClass011 : associationsDao.findAllClass011s()) {
            if (currentClass011.equals(class011)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class011.getFakeAttr());
            }
        }
        Assert.assertTrue("Class011 not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011() throws DaoException {
        // Initialized the test
        Class011 class011 = getClass011Example();
        associationsDao.createClass011(class011);
        
        // Execute the tested code
        associationsDao.deleteClass011(class011);
        
        // Verify result
        boolean found = false;
        for (Class011 currentClass011 : associationsDao.findAllClass011s()) {
            if (currentClass011.getId().equals(class011.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011 not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011s() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass011s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011 class0111 = getClass011Example();
        associationsDao.createClass011(class0111);
                
        Class011 class0112 = getClass011Example();
        associationsDao.createClass011(class0112);

        // Verify result
        int after = associationsDao.findAllClass011s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011END() throws DaoException {
        // fill attributes with example values
        Class011END class011END = getClass011ENDExample();
        
        // Execute the tested code
        associationsDao.createClass011END(class011END);

        // Verify result
        boolean found = false;
        for (Class011END currentClass011END : associationsDao.findAllClass011ENDs()) {
            if (currentClass011END.equals(class011END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011END() throws DaoException {
        // Initialized the test
        Class011END class011END = getClass011ENDExample();
        associationsDao.createClass011END(class011END);

        // Execute the tested code
        class011END.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass011END(class011END);

        // Verify result
        boolean found = false;
        for (Class011END currentClass011END : associationsDao.findAllClass011ENDs()) {
            if (currentClass011END.equals(class011END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class011END.getFakeAttr());
            }
        }
        Assert.assertTrue("Class011END not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011END() throws DaoException {
        // Initialized the test
        Class011END class011END = getClass011ENDExample();
        associationsDao.createClass011END(class011END);
        
        // Execute the tested code
        associationsDao.deleteClass011END(class011END);
        
        // Verify result
        boolean found = false;
        for (Class011END currentClass011END : associationsDao.findAllClass011ENDs()) {
            if (currentClass011END.getId().equals(class011END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011END not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011ENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass011ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011END class011END1 = getClass011ENDExample();
        associationsDao.createClass011END(class011END1);
                
        Class011END class011END2 = getClass011ENDExample();
        associationsDao.createClass011END(class011END2);

        // Verify result
        int after = associationsDao.findAllClass011ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011BI() throws DaoException {
        // fill attributes with example values
        Class011BI class011BI = getClass011BIExample();
        
        // Execute the tested code
        associationsDao.createClass011BI(class011BI);

        // Verify result
        boolean found = false;
        for (Class011BI currentClass011BI : associationsDao.findAllClass011BIs()) {
            if (currentClass011BI.equals(class011BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011BI() throws DaoException {
        // Initialized the test
        Class011BI class011BI = getClass011BIExample();
        associationsDao.createClass011BI(class011BI);

        // Execute the tested code
        class011BI.setFakeAttr("secondFakeAttr");
        associationsDao.updateClass011BI(class011BI);

        // Verify result
        boolean found = false;
        for (Class011BI currentClass011BI : associationsDao.findAllClass011BIs()) {
            if (currentClass011BI.equals(class011BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        class011BI.getFakeAttr());
            }
        }
        Assert.assertTrue("Class011BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011BI() throws DaoException {
        // Initialized the test
        Class011BI class011BI = getClass011BIExample();
        associationsDao.createClass011BI(class011BI);
        
        // Execute the tested code
        associationsDao.deleteClass011BI(class011BI);
        
        // Verify result
        boolean found = false;
        for (Class011BI currentClass011BI : associationsDao.findAllClass011BIs()) {
            if (currentClass011BI.getId().equals(class011BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011BIs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass011BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BI class011BI1 = getClass011BIExample();
        associationsDao.createClass011BI(class011BI1);
                
        Class011BI class011BI2 = getClass011BIExample();
        associationsDao.createClass011BI(class011BI2);

        // Verify result
        int after = associationsDao.findAllClass011BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011BIEND() throws DaoException {
        // fill attributes with example values
        Class011BIEND class011BIEND = getClass011BIENDExample();
        
        // Execute the tested code
        associationsDao.createClass011BIEND(class011BIEND);

        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : associationsDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.equals(class011BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011BIEND() throws DaoException {
        // Initialized the test
        Class011BIEND class011BIEND = getClass011BIENDExample();
        associationsDao.createClass011BIEND(class011BIEND);

        // Execute the tested code
        class011BIEND.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass011BIEND(class011BIEND);

        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : associationsDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.equals(class011BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class011BIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("Class011BIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011BIEND() throws DaoException {
        // Initialized the test
        Class011BIEND class011BIEND = getClass011BIENDExample();
        associationsDao.createClass011BIEND(class011BIEND);
        
        // Execute the tested code
        associationsDao.deleteClass011BIEND(class011BIEND);
        
        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : associationsDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.getId().equals(class011BIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011BIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011BIENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass011BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BIEND class011BIEND1 = getClass011BIENDExample();
        associationsDao.createClass011BIEND(class011BIEND1);
                
        Class011BIEND class011BIEND2 = getClass011BIENDExample();
        associationsDao.createClass011BIEND(class011BIEND2);

        // Verify result
        int after = associationsDao.findAllClass011BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11() throws DaoException {
        // fill attributes with example values
        Class11 class11 = getClass11Example();
        
        // Execute the tested code
        associationsDao.createClass11(class11);

        // Verify result
        boolean found = false;
        for (Class11 currentClass11 : associationsDao.findAllClass11s()) {
            if (currentClass11.equals(class11)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1 not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11() throws DaoException {
        // Initialized the test
        Class11 class11 = getClass11Example();
        associationsDao.createClass11(class11);

        // Execute the tested code
        class11.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass11(class11);

        // Verify result
        boolean found = false;
        for (Class11 currentClass11 : associationsDao.findAllClass11s()) {
            if (currentClass11.equals(class11)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class11.getFakeAttr());
            }
        }
        Assert.assertTrue("Class11 not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11() throws DaoException {
        // Initialized the test
        Class11 class11 = getClass11Example();
        associationsDao.createClass11(class11);
        
        // Execute the tested code
        associationsDao.deleteClass11(class11);
        
        // Verify result
        boolean found = false;
        for (Class11 currentClass11 : associationsDao.findAllClass11s()) {
            if (currentClass11.getId().equals(class11.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11 not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11s() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass11s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11 class111 = getClass11Example();
        associationsDao.createClass11(class111);
                
        Class11 class112 = getClass11Example();
        associationsDao.createClass11(class112);

        // Verify result
        int after = associationsDao.findAllClass11s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11END() throws DaoException {
        // fill attributes with example values
        Class11END class11END = getClass11ENDExample();
        
        // Execute the tested code
        associationsDao.createClass11END(class11END);

        // Verify result
        boolean found = false;
        for (Class11END currentClass11END : associationsDao.findAllClass11ENDs()) {
            if (currentClass11END.equals(class11END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_END not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11END() throws DaoException {
        // Initialized the test
        Class11END class11END = getClass11ENDExample();
        associationsDao.createClass11END(class11END);

        // Execute the tested code
        class11END.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass11END(class11END);

        // Verify result
        boolean found = false;
        for (Class11END currentClass11END : associationsDao.findAllClass11ENDs()) {
            if (currentClass11END.equals(class11END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class11END.getFakeAttr());
            }
        }
        Assert.assertTrue("Class11END not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11END() throws DaoException {
        // Initialized the test
        Class11END class11END = getClass11ENDExample();
        associationsDao.createClass11END(class11END);
        
        // Execute the tested code
        associationsDao.deleteClass11END(class11END);
        
        // Verify result
        boolean found = false;
        for (Class11END currentClass11END : associationsDao.findAllClass11ENDs()) {
            if (currentClass11END.getId().equals(class11END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11END not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11ENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass11ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11END class11END1 = getClass11ENDExample();
        associationsDao.createClass11END(class11END1);
                
        Class11END class11END2 = getClass11ENDExample();
        associationsDao.createClass11END(class11END2);

        // Verify result
        int after = associationsDao.findAllClass11ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BI() throws DaoException {
        // fill attributes with example values
        Class11BI class11BI = getClass11BIExample();
        
        // Execute the tested code
        associationsDao.createClass11BI(class11BI);

        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : associationsDao.findAllClass11BIs()) {
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
        associationsDao.createClass11BI(class11BI);

        // Execute the tested code
        class11BI.setFakeAttr(new Date(1));
        associationsDao.updateClass11BI(class11BI);

        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : associationsDao.findAllClass11BIs()) {
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
        associationsDao.createClass11BI(class11BI);
        
        // Execute the tested code
        associationsDao.deleteClass11BI(class11BI);
        
        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : associationsDao.findAllClass11BIs()) {
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
        int before = associationsDao.findAllClass11BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BI class11BI1 = getClass11BIExample();
        associationsDao.createClass11BI(class11BI1);
                
        Class11BI class11BI2 = getClass11BIExample();
        associationsDao.createClass11BI(class11BI2);

        // Verify result
        int after = associationsDao.findAllClass11BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BIEND() throws DaoException {
        // fill attributes with example values
        Class11BIEND class11BIEND = getClass11BIENDExample();
        
        // Execute the tested code
        associationsDao.createClass11BIEND(class11BIEND);

        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : associationsDao.findAllClass11BIENDs()) {
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
        associationsDao.createClass11BIEND(class11BIEND);

        // Execute the tested code
        class11BIEND.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass11BIEND(class11BIEND);

        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : associationsDao.findAllClass11BIENDs()) {
            if (currentClass11BIEND.equals(class11BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
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
        associationsDao.createClass11BIEND(class11BIEND);
        
        // Execute the tested code
        associationsDao.deleteClass11BIEND(class11BIEND);
        
        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : associationsDao.findAllClass11BIENDs()) {
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
        int before = associationsDao.findAllClass11BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BIEND class11BIEND1 = getClass11BIENDExample();
        associationsDao.createClass11BIEND(class11BIEND1);
                
        Class11BIEND class11BIEND2 = getClass11BIENDExample();
        associationsDao.createClass11BIEND(class11BIEND2);

        // Verify result
        int after = associationsDao.findAllClass11BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01Many() throws DaoException {
        // fill attributes with example values
        Class01Many class01Many = getClass01ManyExample();
        
        // Execute the tested code
        associationsDao.createClass01Many(class01Many);

        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : associationsDao.findAllClass01Manys()) {
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
        associationsDao.createClass01Many(class01Many);

        // Execute the tested code
        class01Many.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass01Many(class01Many);

        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : associationsDao.findAllClass01Manys()) {
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
        associationsDao.createClass01Many(class01Many);
        
        // Execute the tested code
        associationsDao.deleteClass01Many(class01Many);
        
        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : associationsDao.findAllClass01Manys()) {
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
        int before = associationsDao.findAllClass01Manys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01Many class01Many1 = getClass01ManyExample();
        associationsDao.createClass01Many(class01Many1);
                
        Class01Many class01Many2 = getClass01ManyExample();
        associationsDao.createClass01Many(class01Many2);

        // Verify result
        int after = associationsDao.findAllClass01Manys().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyEND() throws DaoException {
        // fill attributes with example values
        Class01ManyEND class01ManyEND = getClass01ManyENDExample();
        
        // Execute the tested code
        associationsDao.createClass01ManyEND(class01ManyEND);

        // Verify result
        boolean found = false;
        for (Class01ManyEND currentClass01ManyEND : associationsDao.findAllClass01ManyENDs()) {
            if (currentClass01ManyEND.equals(class01ManyEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyEND() throws DaoException {
        // Initialized the test
        Class01ManyEND class01ManyEND = getClass01ManyENDExample();
        associationsDao.createClass01ManyEND(class01ManyEND);

        // Execute the tested code
        class01ManyEND.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass01ManyEND(class01ManyEND);

        // Verify result
        boolean found = false;
        for (Class01ManyEND currentClass01ManyEND : associationsDao.findAllClass01ManyENDs()) {
            if (currentClass01ManyEND.equals(class01ManyEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class01ManyEND.getFakeAttr());
            }
        }
        Assert.assertTrue("Class01ManyEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyEND() throws DaoException {
        // Initialized the test
        Class01ManyEND class01ManyEND = getClass01ManyENDExample();
        associationsDao.createClass01ManyEND(class01ManyEND);
        
        // Execute the tested code
        associationsDao.deleteClass01ManyEND(class01ManyEND);
        
        // Verify result
        boolean found = false;
        for (Class01ManyEND currentClass01ManyEND : associationsDao.findAllClass01ManyENDs()) {
            if (currentClass01ManyEND.getId().equals(class01ManyEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass01ManyENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyEND class01ManyEND1 = getClass01ManyENDExample();
        associationsDao.createClass01ManyEND(class01ManyEND1);
                
        Class01ManyEND class01ManyEND2 = getClass01ManyENDExample();
        associationsDao.createClass01ManyEND(class01ManyEND2);

        // Verify result
        int after = associationsDao.findAllClass01ManyENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyBI() throws DaoException {
        // fill attributes with example values
        Class01ManyBI class01ManyBI = getClass01ManyBIExample();
        
        // Execute the tested code
        associationsDao.createClass01ManyBI(class01ManyBI);

        // Verify result
        boolean found = false;
        for (Class01ManyBI currentClass01ManyBI : associationsDao.findAllClass01ManyBIs()) {
            if (currentClass01ManyBI.equals(class01ManyBI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyBI() throws DaoException {
        // Initialized the test
        Class01ManyBI class01ManyBI = getClass01ManyBIExample();
        associationsDao.createClass01ManyBI(class01ManyBI);

        // Execute the tested code
        class01ManyBI.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClass01ManyBI(class01ManyBI);

        // Verify result
        boolean found = false;
        for (Class01ManyBI currentClass01ManyBI : associationsDao.findAllClass01ManyBIs()) {
            if (currentClass01ManyBI.equals(class01ManyBI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        class01ManyBI.getFakeAttr());
            }
        }
        Assert.assertTrue("Class01ManyBI not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyBI() throws DaoException {
        // Initialized the test
        Class01ManyBI class01ManyBI = getClass01ManyBIExample();
        associationsDao.createClass01ManyBI(class01ManyBI);
        
        // Execute the tested code
        associationsDao.deleteClass01ManyBI(class01ManyBI);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBI currentClass01ManyBI : associationsDao.findAllClass01ManyBIs()) {
            if (currentClass01ManyBI.getId().equals(class01ManyBI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyBI not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyBIs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass01ManyBIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBI class01ManyBI1 = getClass01ManyBIExample();
        associationsDao.createClass01ManyBI(class01ManyBI1);
                
        Class01ManyBI class01ManyBI2 = getClass01ManyBIExample();
        associationsDao.createClass01ManyBI(class01ManyBI2);

        // Verify result
        int after = associationsDao.findAllClass01ManyBIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyBIEND() throws DaoException {
        // fill attributes with example values
        Class01ManyBIEND class01ManyBIEND = getClass01ManyBIENDExample();
        
        // Execute the tested code
        associationsDao.createClass01ManyBIEND(class01ManyBIEND);

        // Verify result
        boolean found = false;
        for (Class01ManyBIEND currentClass01ManyBIEND : associationsDao.findAllClass01ManyBIENDs()) {
            if (currentClass01ManyBIEND.equals(class01ManyBIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyBIEND() throws DaoException {
        // Initialized the test
        Class01ManyBIEND class01ManyBIEND = getClass01ManyBIENDExample();
        associationsDao.createClass01ManyBIEND(class01ManyBIEND);

        // Execute the tested code
        class01ManyBIEND.setFakeAttr(new Integer(725185254));
        associationsDao.updateClass01ManyBIEND(class01ManyBIEND);

        // Verify result
        boolean found = false;
        for (Class01ManyBIEND currentClass01ManyBIEND : associationsDao.findAllClass01ManyBIENDs()) {
            if (currentClass01ManyBIEND.equals(class01ManyBIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        class01ManyBIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("Class01ManyBIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyBIEND() throws DaoException {
        // Initialized the test
        Class01ManyBIEND class01ManyBIEND = getClass01ManyBIENDExample();
        associationsDao.createClass01ManyBIEND(class01ManyBIEND);
        
        // Execute the tested code
        associationsDao.deleteClass01ManyBIEND(class01ManyBIEND);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBIEND currentClass01ManyBIEND : associationsDao.findAllClass01ManyBIENDs()) {
            if (currentClass01ManyBIEND.getId().equals(class01ManyBIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyBIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyBIENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClass01ManyBIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBIEND class01ManyBIEND1 = getClass01ManyBIENDExample();
        associationsDao.createClass01ManyBIEND(class01ManyBIEND1);
                
        Class01ManyBIEND class01ManyBIEND2 = getClass01ManyBIENDExample();
        associationsDao.createClass01ManyBIEND(class01ManyBIEND2);

        // Verify result
        int after = associationsDao.findAllClass01ManyBIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01() throws DaoException {
        // fill attributes with example values
        ClassMany01 classMany01 = getClassMany01Example();
        
        // Execute the tested code
        associationsDao.createClassMany01(classMany01);

        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : associationsDao.findAllClassMany01s()) {
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
        associationsDao.createClassMany01(classMany01);

        // Execute the tested code
        classMany01.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClassMany01(classMany01);

        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : associationsDao.findAllClassMany01s()) {
            if (currentClassMany01.equals(classMany01)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
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
        associationsDao.createClassMany01(classMany01);
        
        // Execute the tested code
        associationsDao.deleteClassMany01(classMany01);
        
        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : associationsDao.findAllClassMany01s()) {
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
        int before = associationsDao.findAllClassMany01s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01 classMany011 = getClassMany01Example();
        associationsDao.createClassMany01(classMany011);
                
        ClassMany01 classMany012 = getClassMany01Example();
        associationsDao.createClassMany01(classMany012);

        // Verify result
        int after = associationsDao.findAllClassMany01s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01END() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = getClassMany01ENDExample();
        
        // Execute the tested code
        associationsDao.createClassMany01END(classMany01END);

        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : associationsDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.equals(classMany01END)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_END not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01END() throws DaoException {
        // Initialized the test
        ClassMany01END classMany01END = getClassMany01ENDExample();
        associationsDao.createClassMany01END(classMany01END);

        // Execute the tested code
        classMany01END.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClassMany01END(classMany01END);

        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : associationsDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.equals(classMany01END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        classMany01END.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassMany01END not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01END() throws DaoException {
        // Initialized the test
        ClassMany01END classMany01END = getClassMany01ENDExample();
        associationsDao.createClassMany01END(classMany01END);
        
        // Execute the tested code
        associationsDao.deleteClassMany01END(classMany01END);
        
        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : associationsDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.getId().equals(classMany01END.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01END not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01ENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassMany01ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01END classMany01END1 = getClassMany01ENDExample();
        associationsDao.createClassMany01END(classMany01END1);
                
        ClassMany01END classMany01END2 = getClassMany01ENDExample();
        associationsDao.createClassMany01END(classMany01END2);

        // Verify result
        int after = associationsDao.findAllClassMany01ENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01BI() throws DaoException {
        // fill attributes with example values
        ClassMany01BI classMany01BI = getClassMany01BIExample();
        
        // Execute the tested code
        associationsDao.createClassMany01BI(classMany01BI);

        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : associationsDao.findAllClassMany01BIs()) {
            if (currentClassMany01BI.equals(classMany01BI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01BI() throws DaoException {
        // Initialized the test
        ClassMany01BI classMany01BI = getClassMany01BIExample();
        associationsDao.createClassMany01BI(classMany01BI);

        // Execute the tested code
        classMany01BI.setFakeAttr("secondFakeAttr");
        associationsDao.updateClassMany01BI(classMany01BI);

        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : associationsDao.findAllClassMany01BIs()) {
            if (currentClassMany01BI.equals(classMany01BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        classMany01BI.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassMany01BI not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01BI() throws DaoException {
        // Initialized the test
        ClassMany01BI classMany01BI = getClassMany01BIExample();
        associationsDao.createClassMany01BI(classMany01BI);
        
        // Execute the tested code
        associationsDao.deleteClassMany01BI(classMany01BI);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : associationsDao.findAllClassMany01BIs()) {
            if (currentClassMany01BI.getId().equals(classMany01BI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01BI not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01BIs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassMany01BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BI classMany01BI1 = getClassMany01BIExample();
        associationsDao.createClassMany01BI(classMany01BI1);
                
        ClassMany01BI classMany01BI2 = getClassMany01BIExample();
        associationsDao.createClassMany01BI(classMany01BI2);

        // Verify result
        int after = associationsDao.findAllClassMany01BIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01BIEND() throws DaoException {
        // fill attributes with example values
        ClassMany01BIEND classMany01BIEND = getClassMany01BIENDExample();
        
        // Execute the tested code
        associationsDao.createClassMany01BIEND(classMany01BIEND);

        // Verify result
        boolean found = false;
        for (ClassMany01BIEND currentClassMany01BIEND : associationsDao.findAllClassMany01BIENDs()) {
            if (currentClassMany01BIEND.equals(classMany01BIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01BIEND() throws DaoException {
        // Initialized the test
        ClassMany01BIEND classMany01BIEND = getClassMany01BIENDExample();
        associationsDao.createClassMany01BIEND(classMany01BIEND);

        // Execute the tested code
        classMany01BIEND.setFakeAttr(new Integer(725185254));
        associationsDao.updateClassMany01BIEND(classMany01BIEND);

        // Verify result
        boolean found = false;
        for (ClassMany01BIEND currentClassMany01BIEND : associationsDao.findAllClassMany01BIENDs()) {
            if (currentClassMany01BIEND.equals(classMany01BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Integer(725185254),
                        classMany01BIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassMany01BIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01BIEND() throws DaoException {
        // Initialized the test
        ClassMany01BIEND classMany01BIEND = getClassMany01BIENDExample();
        associationsDao.createClassMany01BIEND(classMany01BIEND);
        
        // Execute the tested code
        associationsDao.deleteClassMany01BIEND(classMany01BIEND);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BIEND currentClassMany01BIEND : associationsDao.findAllClassMany01BIENDs()) {
            if (currentClassMany01BIEND.getId().equals(classMany01BIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01BIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01BIENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassMany01BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BIEND classMany01BIEND1 = getClassMany01BIENDExample();
        associationsDao.createClassMany01BIEND(classMany01BIEND1);
                
        ClassMany01BIEND classMany01BIEND2 = getClassMany01BIENDExample();
        associationsDao.createClassMany01BIEND(classMany01BIEND2);

        // Verify result
        int after = associationsDao.findAllClassMany01BIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyMany() throws DaoException {
        // fill attributes with example values
        ClassManyMany classManyMany = getClassManyManyExample();
        
        // Execute the tested code
        associationsDao.createClassManyMany(classManyMany);

        // Verify result
        boolean found = false;
        for (ClassManyMany currentClassManyMany : associationsDao.findAllClassManyManys()) {
            if (currentClassManyMany.equals(classManyMany)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyMany() throws DaoException {
        // Initialized the test
        ClassManyMany classManyMany = getClassManyManyExample();
        associationsDao.createClassManyMany(classManyMany);

        // Execute the tested code
        classManyMany.setFakeAttr(new Float(725185254.0));
        associationsDao.updateClassManyMany(classManyMany);

        // Verify result
        boolean found = false;
        for (ClassManyMany currentClassManyMany : associationsDao.findAllClassManyManys()) {
            if (currentClassManyMany.equals(classManyMany)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Float(725185254.0),
                        classManyMany.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassManyMany not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyMany() throws DaoException {
        // Initialized the test
        ClassManyMany classManyMany = getClassManyManyExample();
        associationsDao.createClassManyMany(classManyMany);
        
        // Execute the tested code
        associationsDao.deleteClassManyMany(classManyMany);
        
        // Verify result
        boolean found = false;
        for (ClassManyMany currentClassManyMany : associationsDao.findAllClassManyManys()) {
            if (currentClassManyMany.getId().equals(classManyMany.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyMany not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManys() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassManyManys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyMany classManyMany1 = getClassManyManyExample();
        associationsDao.createClassManyMany(classManyMany1);
                
        ClassManyMany classManyMany2 = getClassManyManyExample();
        associationsDao.createClassManyMany(classManyMany2);

        // Verify result
        int after = associationsDao.findAllClassManyManys().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyEnd() throws DaoException {
        // fill attributes with example values
        ClassManyManyEnd classManyManyEnd = getClassManyManyEndExample();
        
        // Execute the tested code
        associationsDao.createClassManyManyEnd(classManyManyEnd);

        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : associationsDao.findAllClassManyManyEnds()) {
            if (currentClassManyManyEnd.equals(classManyManyEnd)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_End not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyEnd() throws DaoException {
        // Initialized the test
        ClassManyManyEnd classManyManyEnd = getClassManyManyEndExample();
        associationsDao.createClassManyManyEnd(classManyManyEnd);

        // Execute the tested code
        classManyManyEnd.setFakeAttr("secondFakeAttr");
        associationsDao.updateClassManyManyEnd(classManyManyEnd);

        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : associationsDao.findAllClassManyManyEnds()) {
            if (currentClassManyManyEnd.equals(classManyManyEnd)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
                        classManyManyEnd.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassManyManyEnd not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyEnd() throws DaoException {
        // Initialized the test
        ClassManyManyEnd classManyManyEnd = getClassManyManyEndExample();
        associationsDao.createClassManyManyEnd(classManyManyEnd);
        
        // Execute the tested code
        associationsDao.deleteClassManyManyEnd(classManyManyEnd);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : associationsDao.findAllClassManyManyEnds()) {
            if (currentClassManyManyEnd.getId().equals(classManyManyEnd.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyEnd not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_End.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyEnds() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassManyManyEnds().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyEnd classManyManyEnd1 = getClassManyManyEndExample();
        associationsDao.createClassManyManyEnd(classManyManyEnd1);
                
        ClassManyManyEnd classManyManyEnd2 = getClassManyManyEndExample();
        associationsDao.createClassManyManyEnd(classManyManyEnd2);

        // Verify result
        int after = associationsDao.findAllClassManyManyEnds().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyBI() throws DaoException {
        // fill attributes with example values
        ClassManyManyBI classManyManyBI = getClassManyManyBIExample();
        
        // Execute the tested code
        associationsDao.createClassManyManyBI(classManyManyBI);

        // Verify result
        boolean found = false;
        for (ClassManyManyBI currentClassManyManyBI : associationsDao.findAllClassManyManyBIs()) {
            if (currentClassManyManyBI.equals(classManyManyBI)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_BI not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyBI() throws DaoException {
        // Initialized the test
        ClassManyManyBI classManyManyBI = getClassManyManyBIExample();
        associationsDao.createClassManyManyBI(classManyManyBI);

        // Execute the tested code
        classManyManyBI.setFakeAttr(new Boolean(false));
        associationsDao.updateClassManyManyBI(classManyManyBI);

        // Verify result
        boolean found = false;
        for (ClassManyManyBI currentClassManyManyBI : associationsDao.findAllClassManyManyBIs()) {
            if (currentClassManyManyBI.equals(classManyManyBI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Boolean(false),
                        classManyManyBI.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassManyManyBI not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_BI.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyBI() throws DaoException {
        // Initialized the test
        ClassManyManyBI classManyManyBI = getClassManyManyBIExample();
        associationsDao.createClassManyManyBI(classManyManyBI);
        
        // Execute the tested code
        associationsDao.deleteClassManyManyBI(classManyManyBI);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBI currentClassManyManyBI : associationsDao.findAllClassManyManyBIs()) {
            if (currentClassManyManyBI.getId().equals(classManyManyBI.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyBI not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_BI.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyBIs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassManyManyBIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBI classManyManyBI1 = getClassManyManyBIExample();
        associationsDao.createClassManyManyBI(classManyManyBI1);
                
        ClassManyManyBI classManyManyBI2 = getClassManyManyBIExample();
        associationsDao.createClassManyManyBI(classManyManyBI2);

        // Verify result
        int after = associationsDao.findAllClassManyManyBIs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyBIEND() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIEND classManyManyBIEND = getClassManyManyBIENDExample();
        
        // Execute the tested code
        associationsDao.createClassManyManyBIEND(classManyManyBIEND);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIEND currentClassManyManyBIEND : associationsDao.findAllClassManyManyBIENDs()) {
            if (currentClassManyManyBIEND.equals(classManyManyBIEND)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_BI_END not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyBIEND() throws DaoException {
        // Initialized the test
        ClassManyManyBIEND classManyManyBIEND = getClassManyManyBIENDExample();
        associationsDao.createClassManyManyBIEND(classManyManyBIEND);

        // Execute the tested code
        classManyManyBIEND.setFakeAttr(new Double(725185254.0));
        associationsDao.updateClassManyManyBIEND(classManyManyBIEND);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIEND currentClassManyManyBIEND : associationsDao.findAllClassManyManyBIENDs()) {
            if (currentClassManyManyBIEND.equals(classManyManyBIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        new Double(725185254.0),
                        classManyManyBIEND.getFakeAttr());
            }
        }
        Assert.assertTrue("ClassManyManyBIEND not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyBIEND() throws DaoException {
        // Initialized the test
        ClassManyManyBIEND classManyManyBIEND = getClassManyManyBIENDExample();
        associationsDao.createClassManyManyBIEND(classManyManyBIEND);
        
        // Execute the tested code
        associationsDao.deleteClassManyManyBIEND(classManyManyBIEND);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBIEND currentClassManyManyBIEND : associationsDao.findAllClassManyManyBIENDs()) {
            if (currentClassManyManyBIEND.getId().equals(classManyManyBIEND.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyBIEND not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_BI_END.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyBIENDs() throws DaoException {
        // Verify number of element before testing
        int before = associationsDao.findAllClassManyManyBIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBIEND classManyManyBIEND1 = getClassManyManyBIENDExample();
        associationsDao.createClassManyManyBIEND(classManyManyBIEND1);
                
        ClassManyManyBIEND classManyManyBIEND2 = getClassManyManyBIENDExample();
        associationsDao.createClassManyManyBIEND(classManyManyBIEND2);

        // Verify result
        int after = associationsDao.findAllClassManyManyBIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Class_01_01.
     * @return Returns a new instance of class Class_01_01, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101 getClass0101Example() throws DaoException {
        // fill attributes with example values
        Class0101 class0101 = new Class0101();
        class0101.setFakeAttr("myFakeAttr");


        return class0101;
    }
    
    /**
     * Creates a second example of Class_01_01 with other values.
     * @return Returns a new instance of class Class_01_01 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101 getClass0101Example2() throws DaoException {
        // fill attributes with example values
        Class0101 class0101 = new Class0101();
        class0101.setFakeAttr("secondFakeAttr");


        return class0101;
    }
   /**
     * Creates an example of Class_01_01_END.
     * @return Returns a new instance of class Class_01_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101END getClass0101ENDExample() throws DaoException {
        // fill attributes with example values
        Class0101END class0101END = new Class0101END();
        class0101END.setFakeAttr(new Float(725185254.1));


        return class0101END;
    }
    
    /**
     * Creates a second example of Class_01_01_END with other values.
     * @return Returns a new instance of class Class_01_01_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101END getClass0101ENDExample2() throws DaoException {
        // fill attributes with example values
        Class0101END class0101END = new Class0101END();
        class0101END.setFakeAttr(new Float(725185254.0));


        return class0101END;
    }
   /**
     * Creates an example of Class_01_01_BI.
     * @return Returns a new instance of class Class_01_01_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BI getClass0101BIExample() throws DaoException {
        // fill attributes with example values
        Class0101BI class0101BI = new Class0101BI();
        class0101BI.setFakeAttr(new Integer(725185254 + 1));


        return class0101BI;
    }
    
    /**
     * Creates a second example of Class_01_01_BI with other values.
     * @return Returns a new instance of class Class_01_01_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BI getClass0101BIExample2() throws DaoException {
        // fill attributes with example values
        Class0101BI class0101BI = new Class0101BI();
        class0101BI.setFakeAttr(new Integer(725185254));


        return class0101BI;
    }
   /**
     * Creates an example of Class_01_01_BI_END.
     * @return Returns a new instance of class Class_01_01_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BIEND getClass0101BIENDExample() throws DaoException {
        // fill attributes with example values
        Class0101BIEND class0101BIEND = new Class0101BIEND();
        class0101BIEND.setFakeAttr(new Integer(725185254 + 1));


        return class0101BIEND;
    }
    
    /**
     * Creates a second example of Class_01_01_BI_END with other values.
     * @return Returns a new instance of class Class_01_01_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BIEND getClass0101BIENDExample2() throws DaoException {
        // fill attributes with example values
        Class0101BIEND class0101BIEND = new Class0101BIEND();
        class0101BIEND.setFakeAttr(new Integer(725185254));


        return class0101BIEND;
    }
   /**
     * Creates an example of Class_1_01.
     * @return Returns a new instance of class Class_1_01, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101 getClass101Example() throws DaoException {
        // fill attributes with example values
        Class101 class101 = new Class101();
        class101.setFakeAttr("myFakeAttr");


        return class101;
    }
    
    /**
     * Creates a second example of Class_1_01 with other values.
     * @return Returns a new instance of class Class_1_01 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101 getClass101Example2() throws DaoException {
        // fill attributes with example values
        Class101 class101 = new Class101();
        class101.setFakeAttr("secondFakeAttr");


        return class101;
    }
   /**
     * Creates an example of Class_1_01_END.
     * @return Returns a new instance of class Class_1_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101END getClass101ENDExample() throws DaoException {
        // fill attributes with example values
        Class101END class101END = new Class101END();
        class101END.setFakeAttr(new Integer(725185254 + 1));


        return class101END;
    }
    
    /**
     * Creates a second example of Class_1_01_END with other values.
     * @return Returns a new instance of class Class_1_01_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101END getClass101ENDExample2() throws DaoException {
        // fill attributes with example values
        Class101END class101END = new Class101END();
        class101END.setFakeAttr(new Integer(725185254));


        return class101END;
    }
   /**
     * Creates an example of Class_1_01_BI.
     * @return Returns a new instance of class Class_1_01_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BI getClass101BIExample() throws DaoException {
        // fill attributes with example values
        Class101BI class101BI = new Class101BI();


        return class101BI;
    }
    
    /**
     * Creates a second example of Class_1_01_BI with other values.
     * @return Returns a new instance of class Class_1_01_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BI getClass101BIExample2() throws DaoException {
        // fill attributes with example values
        Class101BI class101BI = new Class101BI();


        return class101BI;
    }
   /**
     * Creates an example of Class_1_01_BI_END.
     * @return Returns a new instance of class Class_1_01_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BIEND getClass101BIENDExample() throws DaoException {
        // fill attributes with example values
        Class101BIEND class101BIEND = new Class101BIEND();

        Class101BI sourceExample = new Class101BI();
        class101BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class101BIEND); 
        associationsDao.createClass101BI(sourceExample);

        return class101BIEND;
    }
    
    /**
     * Creates a second example of Class_1_01_BI_END with other values.
     * @return Returns a new instance of class Class_1_01_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BIEND getClass101BIENDExample2() throws DaoException {
        // fill attributes with example values
        Class101BIEND class101BIEND = new Class101BIEND();

        Class101BI sourceExample = new Class101BI();
        class101BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class101BIEND); 
        associationsDao.createClass101BI(sourceExample);

        return class101BIEND;
    }
   /**
     * Creates an example of Class_01_1.
     * @return Returns a new instance of class Class_01_1, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011 getClass011Example() throws DaoException {
        // fill attributes with example values
        Class011 class011 = new Class011();
        class011.setFakeAttr(new Float(725185254.1));

        Class011END targetExample = new Class011END();
        class011.setTarget(targetExample);   
        associationsDao.createClass011END(targetExample);

        return class011;
    }
    
    /**
     * Creates a second example of Class_01_1 with other values.
     * @return Returns a new instance of class Class_01_1 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011 getClass011Example2() throws DaoException {
        // fill attributes with example values
        Class011 class011 = new Class011();
        class011.setFakeAttr(new Float(725185254.0));

        Class011END targetExample = new Class011END();
        class011.setTarget(targetExample);   
        associationsDao.createClass011END(targetExample);

        return class011;
    }
   /**
     * Creates an example of Class_01_1_END.
     * @return Returns a new instance of class Class_01_1_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011END getClass011ENDExample() throws DaoException {
        // fill attributes with example values
        Class011END class011END = new Class011END();
        class011END.setFakeAttr(new Integer(725185254 + 1));


        return class011END;
    }
    
    /**
     * Creates a second example of Class_01_1_END with other values.
     * @return Returns a new instance of class Class_01_1_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011END getClass011ENDExample2() throws DaoException {
        // fill attributes with example values
        Class011END class011END = new Class011END();
        class011END.setFakeAttr(new Integer(725185254));


        return class011END;
    }
   /**
     * Creates an example of Class_01_1_BI.
     * @return Returns a new instance of class Class_01_1_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BI getClass011BIExample() throws DaoException {
        // fill attributes with example values
        Class011BI class011BI = new Class011BI();
        class011BI.setFakeAttr("myFakeAttr");

        Class011BIEND targetExample = new Class011BIEND();
        class011BI.setTarget(targetExample);   
        targetExample.setSource(class011BI); 
        associationsDao.createClass011BIEND(targetExample);

        return class011BI;
    }
    
    /**
     * Creates a second example of Class_01_1_BI with other values.
     * @return Returns a new instance of class Class_01_1_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BI getClass011BIExample2() throws DaoException {
        // fill attributes with example values
        Class011BI class011BI = new Class011BI();
        class011BI.setFakeAttr("secondFakeAttr");

        Class011BIEND targetExample = new Class011BIEND();
        class011BI.setTarget(targetExample);   
        targetExample.setSource(class011BI); 
        associationsDao.createClass011BIEND(targetExample);

        return class011BI;
    }
   /**
     * Creates an example of Class_01_1_BI_END.
     * @return Returns a new instance of class Class_01_1_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BIEND getClass011BIENDExample() throws DaoException {
        // fill attributes with example values
        Class011BIEND class011BIEND = new Class011BIEND();
        class011BIEND.setFakeAttr(new Float(725185254.1));


        return class011BIEND;
    }
    
    /**
     * Creates a second example of Class_01_1_BI_END with other values.
     * @return Returns a new instance of class Class_01_1_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BIEND getClass011BIENDExample2() throws DaoException {
        // fill attributes with example values
        Class011BIEND class011BIEND = new Class011BIEND();
        class011BIEND.setFakeAttr(new Float(725185254.0));


        return class011BIEND;
    }
   /**
     * Creates an example of Class_1_1.
     * @return Returns a new instance of class Class_1_1, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11 getClass11Example() throws DaoException {
        // fill attributes with example values
        Class11 class11 = new Class11();
        class11.setFakeAttr(new Float(725185254.1));

        Class11END targetExample = new Class11END();
        class11.setTarget(targetExample);   
        associationsDao.createClass11END(targetExample);

        return class11;
    }
    
    /**
     * Creates a second example of Class_1_1 with other values.
     * @return Returns a new instance of class Class_1_1 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11 getClass11Example2() throws DaoException {
        // fill attributes with example values
        Class11 class11 = new Class11();
        class11.setFakeAttr(new Float(725185254.0));

        Class11END targetExample = new Class11END();
        class11.setTarget(targetExample);   
        associationsDao.createClass11END(targetExample);

        return class11;
    }
   /**
     * Creates an example of Class_1_1_END.
     * @return Returns a new instance of class Class_1_1_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11END getClass11ENDExample() throws DaoException {
        // fill attributes with example values
        Class11END class11END = new Class11END();
        class11END.setFakeAttr(new Float(725185254.1));


        return class11END;
    }
    
    /**
     * Creates a second example of Class_1_1_END with other values.
     * @return Returns a new instance of class Class_1_1_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11END getClass11ENDExample2() throws DaoException {
        // fill attributes with example values
        Class11END class11END = new Class11END();
        class11END.setFakeAttr(new Float(725185254.0));


        return class11END;
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
        associationsDao.createClass11BIEND(targetExample);

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
        associationsDao.createClass11BIEND(targetExample);

        return class11BI;
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
        class11BIEND.setFakeAttr(new Integer(725185254 + 1));

        Class11BI sourceExample = new Class11BI();
        class11BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class11BIEND); 
        associationsDao.createClass11BI(sourceExample);

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
        class11BIEND.setFakeAttr(new Integer(725185254));

        Class11BI sourceExample = new Class11BI();
        class11BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class11BIEND); 
        associationsDao.createClass11BI(sourceExample);

        return class11BIEND;
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
   /**
     * Creates an example of Class_01_Many_END.
     * @return Returns a new instance of class Class_01_Many_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyEND getClass01ManyENDExample() throws DaoException {
        // fill attributes with example values
        Class01ManyEND class01ManyEND = new Class01ManyEND();
        class01ManyEND.setFakeAttr(new Float(725185254.1));


        return class01ManyEND;
    }
    
    /**
     * Creates a second example of Class_01_Many_END with other values.
     * @return Returns a new instance of class Class_01_Many_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyEND getClass01ManyENDExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyEND class01ManyEND = new Class01ManyEND();
        class01ManyEND.setFakeAttr(new Float(725185254.0));


        return class01ManyEND;
    }
   /**
     * Creates an example of Class_01_Many_BI.
     * @return Returns a new instance of class Class_01_Many_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBI getClass01ManyBIExample() throws DaoException {
        // fill attributes with example values
        Class01ManyBI class01ManyBI = new Class01ManyBI();
        class01ManyBI.setFakeAttr(new Float(725185254.1));


        return class01ManyBI;
    }
    
    /**
     * Creates a second example of Class_01_Many_BI with other values.
     * @return Returns a new instance of class Class_01_Many_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBI getClass01ManyBIExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyBI class01ManyBI = new Class01ManyBI();
        class01ManyBI.setFakeAttr(new Float(725185254.0));


        return class01ManyBI;
    }
   /**
     * Creates an example of Class_01_Many_BI_END.
     * @return Returns a new instance of class Class_01_Many_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBIEND getClass01ManyBIENDExample() throws DaoException {
        // fill attributes with example values
        Class01ManyBIEND class01ManyBIEND = new Class01ManyBIEND();
        class01ManyBIEND.setFakeAttr(new Integer(725185254 + 1));


        return class01ManyBIEND;
    }
    
    /**
     * Creates a second example of Class_01_Many_BI_END with other values.
     * @return Returns a new instance of class Class_01_Many_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBIEND getClass01ManyBIENDExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyBIEND class01ManyBIEND = new Class01ManyBIEND();
        class01ManyBIEND.setFakeAttr(new Integer(725185254));


        return class01ManyBIEND;
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
        classMany01.setFakeAttr(new Float(725185254.1));


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
        classMany01.setFakeAttr(new Float(725185254.0));


        return classMany01;
    }
   /**
     * Creates an example of Class_Many_01_END.
     * @return Returns a new instance of class Class_Many_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01END getClassMany01ENDExample() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = new ClassMany01END();
        classMany01END.setFakeAttr(new Float(725185254.1));


        return classMany01END;
    }
    
    /**
     * Creates a second example of Class_Many_01_END with other values.
     * @return Returns a new instance of class Class_Many_01_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01END getClassMany01ENDExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = new ClassMany01END();
        classMany01END.setFakeAttr(new Float(725185254.0));


        return classMany01END;
    }
   /**
     * Creates an example of Class_Many_01_BI.
     * @return Returns a new instance of class Class_Many_01_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BI getClassMany01BIExample() throws DaoException {
        // fill attributes with example values
        ClassMany01BI classMany01BI = new ClassMany01BI();
        classMany01BI.setFakeAttr("myFakeAttr");


        return classMany01BI;
    }
    
    /**
     * Creates a second example of Class_Many_01_BI with other values.
     * @return Returns a new instance of class Class_Many_01_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BI getClassMany01BIExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01BI classMany01BI = new ClassMany01BI();
        classMany01BI.setFakeAttr("secondFakeAttr");


        return classMany01BI;
    }
   /**
     * Creates an example of Class_Many_01_BI_END.
     * @return Returns a new instance of class Class_Many_01_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BIEND getClassMany01BIENDExample() throws DaoException {
        // fill attributes with example values
        ClassMany01BIEND classMany01BIEND = new ClassMany01BIEND();
        classMany01BIEND.setFakeAttr(new Integer(725185254 + 1));


        return classMany01BIEND;
    }
    
    /**
     * Creates a second example of Class_Many_01_BI_END with other values.
     * @return Returns a new instance of class Class_Many_01_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BIEND getClassMany01BIENDExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01BIEND classMany01BIEND = new ClassMany01BIEND();
        classMany01BIEND.setFakeAttr(new Integer(725185254));


        return classMany01BIEND;
    }
   /**
     * Creates an example of Class_Many_Many.
     * @return Returns a new instance of class Class_Many_Many, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyMany getClassManyManyExample() throws DaoException {
        // fill attributes with example values
        ClassManyMany classManyMany = new ClassManyMany();
        classManyMany.setFakeAttr(new Float(725185254.1));


        return classManyMany;
    }
    
    /**
     * Creates a second example of Class_Many_Many with other values.
     * @return Returns a new instance of class Class_Many_Many with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyMany getClassManyManyExample2() throws DaoException {
        // fill attributes with example values
        ClassManyMany classManyMany = new ClassManyMany();
        classManyMany.setFakeAttr(new Float(725185254.0));


        return classManyMany;
    }
   /**
     * Creates an example of Class_Many_Many_End.
     * @return Returns a new instance of class Class_Many_Many_End, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEnd getClassManyManyEndExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyEnd classManyManyEnd = new ClassManyManyEnd();
        classManyManyEnd.setFakeAttr("myFakeAttr");


        return classManyManyEnd;
    }
    
    /**
     * Creates a second example of Class_Many_Many_End with other values.
     * @return Returns a new instance of class Class_Many_Many_End with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEnd getClassManyManyEndExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyEnd classManyManyEnd = new ClassManyManyEnd();
        classManyManyEnd.setFakeAttr("secondFakeAttr");


        return classManyManyEnd;
    }
   /**
     * Creates an example of Class_Many_Many_BI.
     * @return Returns a new instance of class Class_Many_Many_BI, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBI getClassManyManyBIExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyBI classManyManyBI = new ClassManyManyBI();
        classManyManyBI.setFakeAttr(new Boolean(false));


        return classManyManyBI;
    }
    
    /**
     * Creates a second example of Class_Many_Many_BI with other values.
     * @return Returns a new instance of class Class_Many_Many_BI with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBI getClassManyManyBIExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyBI classManyManyBI = new ClassManyManyBI();
        classManyManyBI.setFakeAttr(new Boolean(false));


        return classManyManyBI;
    }
   /**
     * Creates an example of Class_Many_Many_BI_END.
     * @return Returns a new instance of class Class_Many_Many_BI_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBIEND getClassManyManyBIENDExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIEND classManyManyBIEND = new ClassManyManyBIEND();
        classManyManyBIEND.setFakeAttr(new Double(725185254.1));


        return classManyManyBIEND;
    }
    
    /**
     * Creates a second example of Class_Many_Many_BI_END with other values.
     * @return Returns a new instance of class Class_Many_Many_BI_END with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBIEND getClassManyManyBIENDExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIEND classManyManyBIEND = new ClassManyManyBIEND();
        classManyManyBIEND.setFakeAttr(new Double(725185254.0));


        return classManyManyBIEND;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
