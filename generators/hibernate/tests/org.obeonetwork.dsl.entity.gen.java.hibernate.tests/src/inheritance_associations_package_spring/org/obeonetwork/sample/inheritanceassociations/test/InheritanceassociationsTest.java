package org.obeonetwork.sample.inheritanceassociations.test;

// Start of user code for import 


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.sample.inheritanceassociations.IInheritanceassociationsDao;
import org.obeonetwork.sample.inheritanceassociations.Class0101;
import org.obeonetwork.sample.inheritanceassociations.Class0101END;
import org.obeonetwork.sample.inheritanceassociations.Class0101BI;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class101;
import org.obeonetwork.sample.inheritanceassociations.Class101END;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.Class101BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.Class011;
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.Class011BI;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11;
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.Class01Many;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyEND;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBI;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01END;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BI;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIEND;
import org.obeonetwork.sample.inheritanceassociations.ClassManyMany;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEnd;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBI;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.Class0101ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class101EndSub;
import org.obeonetwork.sample.inheritanceassociations.Class101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.Class011ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class011BiENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01ENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEndSub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class0101Sub;
import org.obeonetwork.sample.inheritanceassociations.Class0101BISub;
import org.obeonetwork.sample.inheritanceassociations.Class101Sub;
import org.obeonetwork.sample.inheritanceassociations.Class101BISub;
import org.obeonetwork.sample.inheritanceassociations.Class011Sub;
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.Class011BISub;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11Sub;
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.Class11BISub;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class01ManySub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBISub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01Sub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BISub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManySub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBISub;
// End of user code for import

/**
 * Test class for inheritance_associations.
 */
public class InheritanceassociationsTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private IInheritanceassociationsDao inheritanceassociationsDao = (IInheritanceassociationsDao)getApplicationContext().getBean("InheritanceassociationsDAO");



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
        inheritanceassociationsDao.createClass0101(class0101);

        // Verify result
        boolean found = false;
        for (Class0101 currentClass0101 : inheritanceassociationsDao.findAllClass0101s()) {
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
        inheritanceassociationsDao.createClass0101(class0101);

        // Execute the tested code
        class0101.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass0101(class0101);

        // Verify result
        boolean found = false;
        for (Class0101 currentClass0101 : inheritanceassociationsDao.findAllClass0101s()) {
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
        inheritanceassociationsDao.createClass0101(class0101);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101(class0101);
        
        // Verify result
        boolean found = false;
        for (Class0101 currentClass0101 : inheritanceassociationsDao.findAllClass0101s()) {
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
        int before = inheritanceassociationsDao.findAllClass0101s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101 class01011 = getClass0101Example();
        inheritanceassociationsDao.createClass0101(class01011);
                
        Class0101 class01012 = getClass0101Example();
        inheritanceassociationsDao.createClass0101(class01012);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101s().size();
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
        inheritanceassociationsDao.createClass0101END(class0101END);

        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : inheritanceassociationsDao.findAllClass0101ENDs()) {
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
        inheritanceassociationsDao.createClass0101END(class0101END);

        // Execute the tested code
        class0101END.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass0101END(class0101END);

        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : inheritanceassociationsDao.findAllClass0101ENDs()) {
            if (currentClass0101END.equals(class0101END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass0101END(class0101END);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101END(class0101END);
        
        // Verify result
        boolean found = false;
        for (Class0101END currentClass0101END : inheritanceassociationsDao.findAllClass0101ENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass0101ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101END class0101END1 = getClass0101ENDExample();
        inheritanceassociationsDao.createClass0101END(class0101END1);
                
        Class0101END class0101END2 = getClass0101ENDExample();
        inheritanceassociationsDao.createClass0101END(class0101END2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101ENDs().size();
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
        inheritanceassociationsDao.createClass0101BI(class0101BI);

        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : inheritanceassociationsDao.findAllClass0101BIs()) {
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
        inheritanceassociationsDao.createClass0101BI(class0101BI);

        // Execute the tested code
        class0101BI.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass0101BI(class0101BI);

        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : inheritanceassociationsDao.findAllClass0101BIs()) {
            if (currentClass0101BI.equals(class0101BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass0101BI(class0101BI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101BI(class0101BI);
        
        // Verify result
        boolean found = false;
        for (Class0101BI currentClass0101BI : inheritanceassociationsDao.findAllClass0101BIs()) {
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
        int before = inheritanceassociationsDao.findAllClass0101BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BI class0101BI1 = getClass0101BIExample();
        inheritanceassociationsDao.createClass0101BI(class0101BI1);
                
        Class0101BI class0101BI2 = getClass0101BIExample();
        inheritanceassociationsDao.createClass0101BI(class0101BI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101BIs().size();
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
        inheritanceassociationsDao.createClass0101BIEND(class0101BIEND);

        // Verify result
        boolean found = false;
        for (Class0101BIEND currentClass0101BIEND : inheritanceassociationsDao.findAllClass0101BIENDs()) {
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
        inheritanceassociationsDao.createClass0101BIEND(class0101BIEND);

        // Execute the tested code
        class0101BIEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass0101BIEND(class0101BIEND);

        // Verify result
        boolean found = false;
        for (Class0101BIEND currentClass0101BIEND : inheritanceassociationsDao.findAllClass0101BIENDs()) {
            if (currentClass0101BIEND.equals(class0101BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass0101BIEND(class0101BIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101BIEND(class0101BIEND);
        
        // Verify result
        boolean found = false;
        for (Class0101BIEND currentClass0101BIEND : inheritanceassociationsDao.findAllClass0101BIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass0101BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BIEND class0101BIEND1 = getClass0101BIENDExample();
        inheritanceassociationsDao.createClass0101BIEND(class0101BIEND1);
                
        Class0101BIEND class0101BIEND2 = getClass0101BIENDExample();
        inheritanceassociationsDao.createClass0101BIEND(class0101BIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101BIENDs().size();
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
        inheritanceassociationsDao.createClass101(class101);

        // Verify result
        boolean found = false;
        for (Class101 currentClass101 : inheritanceassociationsDao.findAllClass101s()) {
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
        inheritanceassociationsDao.createClass101(class101);

        // Execute the tested code
        class101.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass101(class101);

        // Verify result
        boolean found = false;
        for (Class101 currentClass101 : inheritanceassociationsDao.findAllClass101s()) {
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
        inheritanceassociationsDao.createClass101(class101);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101(class101);
        
        // Verify result
        boolean found = false;
        for (Class101 currentClass101 : inheritanceassociationsDao.findAllClass101s()) {
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
        int before = inheritanceassociationsDao.findAllClass101s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101 class1011 = getClass101Example();
        inheritanceassociationsDao.createClass101(class1011);
                
        Class101 class1012 = getClass101Example();
        inheritanceassociationsDao.createClass101(class1012);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101s().size();
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
        inheritanceassociationsDao.createClass101END(class101END);

        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : inheritanceassociationsDao.findAllClass101ENDs()) {
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
        inheritanceassociationsDao.createClass101END(class101END);

        // Execute the tested code
        class101END.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass101END(class101END);

        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : inheritanceassociationsDao.findAllClass101ENDs()) {
            if (currentClass101END.equals(class101END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass101END(class101END);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101END(class101END);
        
        // Verify result
        boolean found = false;
        for (Class101END currentClass101END : inheritanceassociationsDao.findAllClass101ENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass101ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101END class101END1 = getClass101ENDExample();
        inheritanceassociationsDao.createClass101END(class101END1);
                
        Class101END class101END2 = getClass101ENDExample();
        inheritanceassociationsDao.createClass101END(class101END2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101ENDs().size();
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
        inheritanceassociationsDao.createClass101BI(class101BI);

        // Verify result
        boolean found = false;
        for (Class101BI currentClass101BI : inheritanceassociationsDao.findAllClass101BIs()) {
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
        inheritanceassociationsDao.createClass101BI(class101BI);

        // Execute the tested code
        inheritanceassociationsDao.updateClass101BI(class101BI);

        // Verify result
        boolean found = false;
        for (Class101BI currentClass101BI : inheritanceassociationsDao.findAllClass101BIs()) {
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
        inheritanceassociationsDao.createClass101BI(class101BI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101BI(class101BI);
        
        // Verify result
        boolean found = false;
        for (Class101BI currentClass101BI : inheritanceassociationsDao.findAllClass101BIs()) {
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
        int before = inheritanceassociationsDao.findAllClass101BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BI class101BI1 = getClass101BIExample();
        inheritanceassociationsDao.createClass101BI(class101BI1);
                
        Class101BI class101BI2 = getClass101BIExample();
        inheritanceassociationsDao.createClass101BI(class101BI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101BIs().size();
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
        inheritanceassociationsDao.createClass101BIEND(class101BIEND);

        // Verify result
        boolean found = false;
        for (Class101BIEND currentClass101BIEND : inheritanceassociationsDao.findAllClass101BIENDs()) {
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
        inheritanceassociationsDao.createClass101BIEND(class101BIEND);

        // Execute the tested code
        inheritanceassociationsDao.updateClass101BIEND(class101BIEND);

        // Verify result
        boolean found = false;
        for (Class101BIEND currentClass101BIEND : inheritanceassociationsDao.findAllClass101BIENDs()) {
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
        inheritanceassociationsDao.createClass101BIEND(class101BIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101BIEND(class101BIEND);
        
        // Verify result
        boolean found = false;
        for (Class101BIEND currentClass101BIEND : inheritanceassociationsDao.findAllClass101BIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass101BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BIEND class101BIEND1 = getClass101BIENDExample();
        inheritanceassociationsDao.createClass101BIEND(class101BIEND1);
                
        Class101BIEND class101BIEND2 = getClass101BIENDExample();
        inheritanceassociationsDao.createClass101BIEND(class101BIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101BIENDs().size();
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
        inheritanceassociationsDao.createClass011(class011);

        // Verify result
        boolean found = false;
        for (Class011 currentClass011 : inheritanceassociationsDao.findAllClass011s()) {
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
        inheritanceassociationsDao.createClass011(class011);

        // Execute the tested code
        class011.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass011(class011);

        // Verify result
        boolean found = false;
        for (Class011 currentClass011 : inheritanceassociationsDao.findAllClass011s()) {
            if (currentClass011.equals(class011)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass011(class011);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011(class011);
        
        // Verify result
        boolean found = false;
        for (Class011 currentClass011 : inheritanceassociationsDao.findAllClass011s()) {
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
        int before = inheritanceassociationsDao.findAllClass011s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011 class0111 = getClass011Example();
        inheritanceassociationsDao.createClass011(class0111);
                
        Class011 class0112 = getClass011Example();
        inheritanceassociationsDao.createClass011(class0112);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011s().size();
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
        inheritanceassociationsDao.createClass011END(class011END);

        // Verify result
        boolean found = false;
        for (Class011END currentClass011END : inheritanceassociationsDao.findAllClass011ENDs()) {
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
        inheritanceassociationsDao.createClass011END(class011END);

        // Execute the tested code
        class011END.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass011END(class011END);

        // Verify result
        boolean found = false;
        for (Class011END currentClass011END : inheritanceassociationsDao.findAllClass011ENDs()) {
            if (currentClass011END.equals(class011END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass011END(class011END);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011END(class011END);
        
        // Verify result
        boolean found = false;
        for (Class011END currentClass011END : inheritanceassociationsDao.findAllClass011ENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass011ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011END class011END1 = getClass011ENDExample();
        inheritanceassociationsDao.createClass011END(class011END1);
                
        Class011END class011END2 = getClass011ENDExample();
        inheritanceassociationsDao.createClass011END(class011END2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011ENDs().size();
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
        inheritanceassociationsDao.createClass011BI(class011BI);

        // Verify result
        boolean found = false;
        for (Class011BI currentClass011BI : inheritanceassociationsDao.findAllClass011BIs()) {
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
        inheritanceassociationsDao.createClass011BI(class011BI);

        // Execute the tested code
        class011BI.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass011BI(class011BI);

        // Verify result
        boolean found = false;
        for (Class011BI currentClass011BI : inheritanceassociationsDao.findAllClass011BIs()) {
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
        inheritanceassociationsDao.createClass011BI(class011BI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011BI(class011BI);
        
        // Verify result
        boolean found = false;
        for (Class011BI currentClass011BI : inheritanceassociationsDao.findAllClass011BIs()) {
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
        int before = inheritanceassociationsDao.findAllClass011BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BI class011BI1 = getClass011BIExample();
        inheritanceassociationsDao.createClass011BI(class011BI1);
                
        Class011BI class011BI2 = getClass011BIExample();
        inheritanceassociationsDao.createClass011BI(class011BI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011BIs().size();
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
        inheritanceassociationsDao.createClass011BIEND(class011BIEND);

        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : inheritanceassociationsDao.findAllClass011BIENDs()) {
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
        inheritanceassociationsDao.createClass011BIEND(class011BIEND);

        // Execute the tested code
        class011BIEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass011BIEND(class011BIEND);

        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : inheritanceassociationsDao.findAllClass011BIENDs()) {
            if (currentClass011BIEND.equals(class011BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass011BIEND(class011BIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011BIEND(class011BIEND);
        
        // Verify result
        boolean found = false;
        for (Class011BIEND currentClass011BIEND : inheritanceassociationsDao.findAllClass011BIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass011BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BIEND class011BIEND1 = getClass011BIENDExample();
        inheritanceassociationsDao.createClass011BIEND(class011BIEND1);
                
        Class011BIEND class011BIEND2 = getClass011BIENDExample();
        inheritanceassociationsDao.createClass011BIEND(class011BIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011BIENDs().size();
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
        inheritanceassociationsDao.createClass11(class11);

        // Verify result
        boolean found = false;
        for (Class11 currentClass11 : inheritanceassociationsDao.findAllClass11s()) {
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
        inheritanceassociationsDao.createClass11(class11);

        // Execute the tested code
        class11.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass11(class11);

        // Verify result
        boolean found = false;
        for (Class11 currentClass11 : inheritanceassociationsDao.findAllClass11s()) {
            if (currentClass11.equals(class11)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass11(class11);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11(class11);
        
        // Verify result
        boolean found = false;
        for (Class11 currentClass11 : inheritanceassociationsDao.findAllClass11s()) {
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
        int before = inheritanceassociationsDao.findAllClass11s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11 class111 = getClass11Example();
        inheritanceassociationsDao.createClass11(class111);
                
        Class11 class112 = getClass11Example();
        inheritanceassociationsDao.createClass11(class112);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11s().size();
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
        inheritanceassociationsDao.createClass11END(class11END);

        // Verify result
        boolean found = false;
        for (Class11END currentClass11END : inheritanceassociationsDao.findAllClass11ENDs()) {
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
        inheritanceassociationsDao.createClass11END(class11END);

        // Execute the tested code
        class11END.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass11END(class11END);

        // Verify result
        boolean found = false;
        for (Class11END currentClass11END : inheritanceassociationsDao.findAllClass11ENDs()) {
            if (currentClass11END.equals(class11END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass11END(class11END);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11END(class11END);
        
        // Verify result
        boolean found = false;
        for (Class11END currentClass11END : inheritanceassociationsDao.findAllClass11ENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass11ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11END class11END1 = getClass11ENDExample();
        inheritanceassociationsDao.createClass11END(class11END1);
                
        Class11END class11END2 = getClass11ENDExample();
        inheritanceassociationsDao.createClass11END(class11END2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11ENDs().size();
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
        inheritanceassociationsDao.createClass11BI(class11BI);

        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : inheritanceassociationsDao.findAllClass11BIs()) {
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
        inheritanceassociationsDao.createClass11BI(class11BI);

        // Execute the tested code
        class11BI.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass11BI(class11BI);

        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : inheritanceassociationsDao.findAllClass11BIs()) {
            if (currentClass11BI.equals(class11BI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass11BI(class11BI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11BI(class11BI);
        
        // Verify result
        boolean found = false;
        for (Class11BI currentClass11BI : inheritanceassociationsDao.findAllClass11BIs()) {
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
        int before = inheritanceassociationsDao.findAllClass11BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BI class11BI1 = getClass11BIExample();
        inheritanceassociationsDao.createClass11BI(class11BI1);
                
        Class11BI class11BI2 = getClass11BIExample();
        inheritanceassociationsDao.createClass11BI(class11BI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11BIs().size();
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
        inheritanceassociationsDao.createClass11BIEND(class11BIEND);

        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : inheritanceassociationsDao.findAllClass11BIENDs()) {
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
        inheritanceassociationsDao.createClass11BIEND(class11BIEND);

        // Execute the tested code
        class11BIEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass11BIEND(class11BIEND);

        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : inheritanceassociationsDao.findAllClass11BIENDs()) {
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
        inheritanceassociationsDao.createClass11BIEND(class11BIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11BIEND(class11BIEND);
        
        // Verify result
        boolean found = false;
        for (Class11BIEND currentClass11BIEND : inheritanceassociationsDao.findAllClass11BIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass11BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BIEND class11BIEND1 = getClass11BIENDExample();
        inheritanceassociationsDao.createClass11BIEND(class11BIEND1);
                
        Class11BIEND class11BIEND2 = getClass11BIENDExample();
        inheritanceassociationsDao.createClass11BIEND(class11BIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11BIENDs().size();
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
        inheritanceassociationsDao.createClass01Many(class01Many);

        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : inheritanceassociationsDao.findAllClass01Manys()) {
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
        inheritanceassociationsDao.createClass01Many(class01Many);

        // Execute the tested code
        class01Many.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass01Many(class01Many);

        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : inheritanceassociationsDao.findAllClass01Manys()) {
            if (currentClass01Many.equals(class01Many)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass01Many(class01Many);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01Many(class01Many);
        
        // Verify result
        boolean found = false;
        for (Class01Many currentClass01Many : inheritanceassociationsDao.findAllClass01Manys()) {
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
        int before = inheritanceassociationsDao.findAllClass01Manys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01Many class01Many1 = getClass01ManyExample();
        inheritanceassociationsDao.createClass01Many(class01Many1);
                
        Class01Many class01Many2 = getClass01ManyExample();
        inheritanceassociationsDao.createClass01Many(class01Many2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01Manys().size();
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
        inheritanceassociationsDao.createClass01ManyEND(class01ManyEND);

        // Verify result
        boolean found = false;
        for (Class01ManyEND currentClass01ManyEND : inheritanceassociationsDao.findAllClass01ManyENDs()) {
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
        inheritanceassociationsDao.createClass01ManyEND(class01ManyEND);

        // Execute the tested code
        class01ManyEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass01ManyEND(class01ManyEND);

        // Verify result
        boolean found = false;
        for (Class01ManyEND currentClass01ManyEND : inheritanceassociationsDao.findAllClass01ManyENDs()) {
            if (currentClass01ManyEND.equals(class01ManyEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass01ManyEND(class01ManyEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManyEND(class01ManyEND);
        
        // Verify result
        boolean found = false;
        for (Class01ManyEND currentClass01ManyEND : inheritanceassociationsDao.findAllClass01ManyENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass01ManyENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyEND class01ManyEND1 = getClass01ManyENDExample();
        inheritanceassociationsDao.createClass01ManyEND(class01ManyEND1);
                
        Class01ManyEND class01ManyEND2 = getClass01ManyENDExample();
        inheritanceassociationsDao.createClass01ManyEND(class01ManyEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManyENDs().size();
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
        inheritanceassociationsDao.createClass01ManyBI(class01ManyBI);

        // Verify result
        boolean found = false;
        for (Class01ManyBI currentClass01ManyBI : inheritanceassociationsDao.findAllClass01ManyBIs()) {
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
        inheritanceassociationsDao.createClass01ManyBI(class01ManyBI);

        // Execute the tested code
        class01ManyBI.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass01ManyBI(class01ManyBI);

        // Verify result
        boolean found = false;
        for (Class01ManyBI currentClass01ManyBI : inheritanceassociationsDao.findAllClass01ManyBIs()) {
            if (currentClass01ManyBI.equals(class01ManyBI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass01ManyBI(class01ManyBI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManyBI(class01ManyBI);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBI currentClass01ManyBI : inheritanceassociationsDao.findAllClass01ManyBIs()) {
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
        int before = inheritanceassociationsDao.findAllClass01ManyBIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBI class01ManyBI1 = getClass01ManyBIExample();
        inheritanceassociationsDao.createClass01ManyBI(class01ManyBI1);
                
        Class01ManyBI class01ManyBI2 = getClass01ManyBIExample();
        inheritanceassociationsDao.createClass01ManyBI(class01ManyBI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManyBIs().size();
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
        inheritanceassociationsDao.createClass01ManyBIEND(class01ManyBIEND);

        // Verify result
        boolean found = false;
        for (Class01ManyBIEND currentClass01ManyBIEND : inheritanceassociationsDao.findAllClass01ManyBIENDs()) {
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
        inheritanceassociationsDao.createClass01ManyBIEND(class01ManyBIEND);

        // Execute the tested code
        class01ManyBIEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClass01ManyBIEND(class01ManyBIEND);

        // Verify result
        boolean found = false;
        for (Class01ManyBIEND currentClass01ManyBIEND : inheritanceassociationsDao.findAllClass01ManyBIENDs()) {
            if (currentClass01ManyBIEND.equals(class01ManyBIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClass01ManyBIEND(class01ManyBIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManyBIEND(class01ManyBIEND);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBIEND currentClass01ManyBIEND : inheritanceassociationsDao.findAllClass01ManyBIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClass01ManyBIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBIEND class01ManyBIEND1 = getClass01ManyBIENDExample();
        inheritanceassociationsDao.createClass01ManyBIEND(class01ManyBIEND1);
                
        Class01ManyBIEND class01ManyBIEND2 = getClass01ManyBIENDExample();
        inheritanceassociationsDao.createClass01ManyBIEND(class01ManyBIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManyBIENDs().size();
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
        inheritanceassociationsDao.createClassMany01(classMany01);

        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : inheritanceassociationsDao.findAllClassMany01s()) {
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
        inheritanceassociationsDao.createClassMany01(classMany01);

        // Execute the tested code
        classMany01.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassMany01(classMany01);

        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : inheritanceassociationsDao.findAllClassMany01s()) {
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
        inheritanceassociationsDao.createClassMany01(classMany01);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01(classMany01);
        
        // Verify result
        boolean found = false;
        for (ClassMany01 currentClassMany01 : inheritanceassociationsDao.findAllClassMany01s()) {
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
        int before = inheritanceassociationsDao.findAllClassMany01s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01 classMany011 = getClassMany01Example();
        inheritanceassociationsDao.createClassMany01(classMany011);
                
        ClassMany01 classMany012 = getClassMany01Example();
        inheritanceassociationsDao.createClassMany01(classMany012);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01s().size();
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
        inheritanceassociationsDao.createClassMany01END(classMany01END);

        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : inheritanceassociationsDao.findAllClassMany01ENDs()) {
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
        inheritanceassociationsDao.createClassMany01END(classMany01END);

        // Execute the tested code
        classMany01END.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassMany01END(classMany01END);

        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : inheritanceassociationsDao.findAllClassMany01ENDs()) {
            if (currentClassMany01END.equals(classMany01END)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClassMany01END(classMany01END);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01END(classMany01END);
        
        // Verify result
        boolean found = false;
        for (ClassMany01END currentClassMany01END : inheritanceassociationsDao.findAllClassMany01ENDs()) {
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
        int before = inheritanceassociationsDao.findAllClassMany01ENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01END classMany01END1 = getClassMany01ENDExample();
        inheritanceassociationsDao.createClassMany01END(classMany01END1);
                
        ClassMany01END classMany01END2 = getClassMany01ENDExample();
        inheritanceassociationsDao.createClassMany01END(classMany01END2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01ENDs().size();
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
        inheritanceassociationsDao.createClassMany01BI(classMany01BI);

        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : inheritanceassociationsDao.findAllClassMany01BIs()) {
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
        inheritanceassociationsDao.createClassMany01BI(classMany01BI);

        // Execute the tested code
        classMany01BI.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassMany01BI(classMany01BI);

        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : inheritanceassociationsDao.findAllClassMany01BIs()) {
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
        inheritanceassociationsDao.createClassMany01BI(classMany01BI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01BI(classMany01BI);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BI currentClassMany01BI : inheritanceassociationsDao.findAllClassMany01BIs()) {
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
        int before = inheritanceassociationsDao.findAllClassMany01BIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BI classMany01BI1 = getClassMany01BIExample();
        inheritanceassociationsDao.createClassMany01BI(classMany01BI1);
                
        ClassMany01BI classMany01BI2 = getClassMany01BIExample();
        inheritanceassociationsDao.createClassMany01BI(classMany01BI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01BIs().size();
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
        inheritanceassociationsDao.createClassMany01BIEND(classMany01BIEND);

        // Verify result
        boolean found = false;
        for (ClassMany01BIEND currentClassMany01BIEND : inheritanceassociationsDao.findAllClassMany01BIENDs()) {
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
        inheritanceassociationsDao.createClassMany01BIEND(classMany01BIEND);

        // Execute the tested code
        classMany01BIEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassMany01BIEND(classMany01BIEND);

        // Verify result
        boolean found = false;
        for (ClassMany01BIEND currentClassMany01BIEND : inheritanceassociationsDao.findAllClassMany01BIENDs()) {
            if (currentClassMany01BIEND.equals(classMany01BIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClassMany01BIEND(classMany01BIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01BIEND(classMany01BIEND);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BIEND currentClassMany01BIEND : inheritanceassociationsDao.findAllClassMany01BIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClassMany01BIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BIEND classMany01BIEND1 = getClassMany01BIENDExample();
        inheritanceassociationsDao.createClassMany01BIEND(classMany01BIEND1);
                
        ClassMany01BIEND classMany01BIEND2 = getClassMany01BIENDExample();
        inheritanceassociationsDao.createClassMany01BIEND(classMany01BIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01BIENDs().size();
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
        inheritanceassociationsDao.createClassManyMany(classManyMany);

        // Verify result
        boolean found = false;
        for (ClassManyMany currentClassManyMany : inheritanceassociationsDao.findAllClassManyManys()) {
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
        inheritanceassociationsDao.createClassManyMany(classManyMany);

        // Execute the tested code
        classManyMany.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassManyMany(classManyMany);

        // Verify result
        boolean found = false;
        for (ClassManyMany currentClassManyMany : inheritanceassociationsDao.findAllClassManyManys()) {
            if (currentClassManyMany.equals(classManyMany)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClassManyMany(classManyMany);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyMany(classManyMany);
        
        // Verify result
        boolean found = false;
        for (ClassManyMany currentClassManyMany : inheritanceassociationsDao.findAllClassManyManys()) {
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
        int before = inheritanceassociationsDao.findAllClassManyManys().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyMany classManyMany1 = getClassManyManyExample();
        inheritanceassociationsDao.createClassManyMany(classManyMany1);
                
        ClassManyMany classManyMany2 = getClassManyManyExample();
        inheritanceassociationsDao.createClassManyMany(classManyMany2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManys().size();
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
        inheritanceassociationsDao.createClassManyManyEnd(classManyManyEnd);

        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : inheritanceassociationsDao.findAllClassManyManyEnds()) {
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
        inheritanceassociationsDao.createClassManyManyEnd(classManyManyEnd);

        // Execute the tested code
        classManyManyEnd.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassManyManyEnd(classManyManyEnd);

        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : inheritanceassociationsDao.findAllClassManyManyEnds()) {
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
        inheritanceassociationsDao.createClassManyManyEnd(classManyManyEnd);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManyEnd(classManyManyEnd);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyEnd currentClassManyManyEnd : inheritanceassociationsDao.findAllClassManyManyEnds()) {
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
        int before = inheritanceassociationsDao.findAllClassManyManyEnds().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyEnd classManyManyEnd1 = getClassManyManyEndExample();
        inheritanceassociationsDao.createClassManyManyEnd(classManyManyEnd1);
                
        ClassManyManyEnd classManyManyEnd2 = getClassManyManyEndExample();
        inheritanceassociationsDao.createClassManyManyEnd(classManyManyEnd2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManyEnds().size();
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
        inheritanceassociationsDao.createClassManyManyBI(classManyManyBI);

        // Verify result
        boolean found = false;
        for (ClassManyManyBI currentClassManyManyBI : inheritanceassociationsDao.findAllClassManyManyBIs()) {
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
        inheritanceassociationsDao.createClassManyManyBI(classManyManyBI);

        // Execute the tested code
        classManyManyBI.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassManyManyBI(classManyManyBI);

        // Verify result
        boolean found = false;
        for (ClassManyManyBI currentClassManyManyBI : inheritanceassociationsDao.findAllClassManyManyBIs()) {
            if (currentClassManyManyBI.equals(classManyManyBI)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClassManyManyBI(classManyManyBI);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManyBI(classManyManyBI);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBI currentClassManyManyBI : inheritanceassociationsDao.findAllClassManyManyBIs()) {
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
        int before = inheritanceassociationsDao.findAllClassManyManyBIs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBI classManyManyBI1 = getClassManyManyBIExample();
        inheritanceassociationsDao.createClassManyManyBI(classManyManyBI1);
                
        ClassManyManyBI classManyManyBI2 = getClassManyManyBIExample();
        inheritanceassociationsDao.createClassManyManyBI(classManyManyBI2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManyBIs().size();
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
        inheritanceassociationsDao.createClassManyManyBIEND(classManyManyBIEND);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIEND currentClassManyManyBIEND : inheritanceassociationsDao.findAllClassManyManyBIENDs()) {
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
        inheritanceassociationsDao.createClassManyManyBIEND(classManyManyBIEND);

        // Execute the tested code
        classManyManyBIEND.setFakeAttr("secondFakeAttr");
        inheritanceassociationsDao.updateClassManyManyBIEND(classManyManyBIEND);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIEND currentClassManyManyBIEND : inheritanceassociationsDao.findAllClassManyManyBIENDs()) {
            if (currentClassManyManyBIEND.equals(classManyManyBIEND)) {
                found = true;
                Assert.assertEquals("Value fakeAttr not modified",
                        "secondFakeAttr",
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
        inheritanceassociationsDao.createClassManyManyBIEND(classManyManyBIEND);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManyBIEND(classManyManyBIEND);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBIEND currentClassManyManyBIEND : inheritanceassociationsDao.findAllClassManyManyBIENDs()) {
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
        int before = inheritanceassociationsDao.findAllClassManyManyBIENDs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBIEND classManyManyBIEND1 = getClassManyManyBIENDExample();
        inheritanceassociationsDao.createClassManyManyBIEND(classManyManyBIEND1);
                
        ClassManyManyBIEND classManyManyBIEND2 = getClassManyManyBIENDExample();
        inheritanceassociationsDao.createClassManyManyBIEND(classManyManyBIEND2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManyBIENDs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101ENDSub() throws DaoException {
        // fill attributes with example values
        Class0101ENDSub class0101ENDSub = getClass0101ENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass0101ENDSub(class0101ENDSub);

        // Verify result
        boolean found = false;
        for (Class0101ENDSub currentClass0101ENDSub : inheritanceassociationsDao.findAllClass0101ENDSubs()) {
            if (currentClass0101ENDSub.equals(class0101ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101ENDSub() throws DaoException {
        // Initialized the test
        Class0101ENDSub class0101ENDSub = getClass0101ENDSubExample();
        inheritanceassociationsDao.createClass0101ENDSub(class0101ENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass0101ENDSub(class0101ENDSub);

        // Verify result
        boolean found = false;
        for (Class0101ENDSub currentClass0101ENDSub : inheritanceassociationsDao.findAllClass0101ENDSubs()) {
            if (currentClass0101ENDSub.equals(class0101ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class0101ENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101ENDSub() throws DaoException {
        // Initialized the test
        Class0101ENDSub class0101ENDSub = getClass0101ENDSubExample();
        inheritanceassociationsDao.createClass0101ENDSub(class0101ENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101ENDSub(class0101ENDSub);
        
        // Verify result
        boolean found = false;
        for (Class0101ENDSub currentClass0101ENDSub : inheritanceassociationsDao.findAllClass0101ENDSubs()) {
            if (currentClass0101ENDSub.getId().equals(class0101ENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101ENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101ENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass0101ENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101ENDSub class0101ENDSub1 = getClass0101ENDSubExample();
        inheritanceassociationsDao.createClass0101ENDSub(class0101ENDSub1);
                
        Class0101ENDSub class0101ENDSub2 = getClass0101ENDSubExample();
        inheritanceassociationsDao.createClass0101ENDSub(class0101ENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101ENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101BIENDSub() throws DaoException {
        // fill attributes with example values
        Class0101BIENDSub class0101BIENDSub = getClass0101BIENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass0101BIENDSub(class0101BIENDSub);

        // Verify result
        boolean found = false;
        for (Class0101BIENDSub currentClass0101BIENDSub : inheritanceassociationsDao.findAllClass0101BIENDSubs()) {
            if (currentClass0101BIENDSub.equals(class0101BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101BIENDSub() throws DaoException {
        // Initialized the test
        Class0101BIENDSub class0101BIENDSub = getClass0101BIENDSubExample();
        inheritanceassociationsDao.createClass0101BIENDSub(class0101BIENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass0101BIENDSub(class0101BIENDSub);

        // Verify result
        boolean found = false;
        for (Class0101BIENDSub currentClass0101BIENDSub : inheritanceassociationsDao.findAllClass0101BIENDSubs()) {
            if (currentClass0101BIENDSub.equals(class0101BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class0101BIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101BIENDSub() throws DaoException {
        // Initialized the test
        Class0101BIENDSub class0101BIENDSub = getClass0101BIENDSubExample();
        inheritanceassociationsDao.createClass0101BIENDSub(class0101BIENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101BIENDSub(class0101BIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class0101BIENDSub currentClass0101BIENDSub : inheritanceassociationsDao.findAllClass0101BIENDSubs()) {
            if (currentClass0101BIENDSub.getId().equals(class0101BIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101BIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101BIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass0101BIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BIENDSub class0101BIENDSub1 = getClass0101BIENDSubExample();
        inheritanceassociationsDao.createClass0101BIENDSub(class0101BIENDSub1);
                
        Class0101BIENDSub class0101BIENDSub2 = getClass0101BIENDSubExample();
        inheritanceassociationsDao.createClass0101BIENDSub(class0101BIENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101BIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101EndSub() throws DaoException {
        // fill attributes with example values
        Class101EndSub class101EndSub = getClass101EndSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass101EndSub(class101EndSub);

        // Verify result
        boolean found = false;
        for (Class101EndSub currentClass101EndSub : inheritanceassociationsDao.findAllClass101EndSubs()) {
            if (currentClass101EndSub.equals(class101EndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_End_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101EndSub() throws DaoException {
        // Initialized the test
        Class101EndSub class101EndSub = getClass101EndSubExample();
        inheritanceassociationsDao.createClass101EndSub(class101EndSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass101EndSub(class101EndSub);

        // Verify result
        boolean found = false;
        for (Class101EndSub currentClass101EndSub : inheritanceassociationsDao.findAllClass101EndSubs()) {
            if (currentClass101EndSub.equals(class101EndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101EndSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101EndSub() throws DaoException {
        // Initialized the test
        Class101EndSub class101EndSub = getClass101EndSubExample();
        inheritanceassociationsDao.createClass101EndSub(class101EndSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101EndSub(class101EndSub);
        
        // Verify result
        boolean found = false;
        for (Class101EndSub currentClass101EndSub : inheritanceassociationsDao.findAllClass101EndSubs()) {
            if (currentClass101EndSub.getId().equals(class101EndSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101EndSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_End_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101EndSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass101EndSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101EndSub class101EndSub1 = getClass101EndSubExample();
        inheritanceassociationsDao.createClass101EndSub(class101EndSub1);
                
        Class101EndSub class101EndSub2 = getClass101EndSubExample();
        inheritanceassociationsDao.createClass101EndSub(class101EndSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101EndSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101BIENDSub() throws DaoException {
        // fill attributes with example values
        Class101BIENDSub class101BIENDSub = getClass101BIENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass101BIENDSub(class101BIENDSub);

        // Verify result
        boolean found = false;
        for (Class101BIENDSub currentClass101BIENDSub : inheritanceassociationsDao.findAllClass101BIENDSubs()) {
            if (currentClass101BIENDSub.equals(class101BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101BIENDSub() throws DaoException {
        // Initialized the test
        Class101BIENDSub class101BIENDSub = getClass101BIENDSubExample();
        inheritanceassociationsDao.createClass101BIENDSub(class101BIENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass101BIENDSub(class101BIENDSub);

        // Verify result
        boolean found = false;
        for (Class101BIENDSub currentClass101BIENDSub : inheritanceassociationsDao.findAllClass101BIENDSubs()) {
            if (currentClass101BIENDSub.equals(class101BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101BIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101BIENDSub() throws DaoException {
        // Initialized the test
        Class101BIENDSub class101BIENDSub = getClass101BIENDSubExample();
        inheritanceassociationsDao.createClass101BIENDSub(class101BIENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101BIENDSub(class101BIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class101BIENDSub currentClass101BIENDSub : inheritanceassociationsDao.findAllClass101BIENDSubs()) {
            if (currentClass101BIENDSub.getId().equals(class101BIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101BIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101BIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass101BIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BIENDSub class101BIENDSub1 = getClass101BIENDSubExample();
        inheritanceassociationsDao.createClass101BIENDSub(class101BIENDSub1);
                
        Class101BIENDSub class101BIENDSub2 = getClass101BIENDSubExample();
        inheritanceassociationsDao.createClass101BIENDSub(class101BIENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101BIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011ENDSub() throws DaoException {
        // fill attributes with example values
        Class011ENDSub class011ENDSub = getClass011ENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass011ENDSub(class011ENDSub);

        // Verify result
        boolean found = false;
        for (Class011ENDSub currentClass011ENDSub : inheritanceassociationsDao.findAllClass011ENDSubs()) {
            if (currentClass011ENDSub.equals(class011ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011ENDSub() throws DaoException {
        // Initialized the test
        Class011ENDSub class011ENDSub = getClass011ENDSubExample();
        inheritanceassociationsDao.createClass011ENDSub(class011ENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass011ENDSub(class011ENDSub);

        // Verify result
        boolean found = false;
        for (Class011ENDSub currentClass011ENDSub : inheritanceassociationsDao.findAllClass011ENDSubs()) {
            if (currentClass011ENDSub.equals(class011ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class011ENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011ENDSub() throws DaoException {
        // Initialized the test
        Class011ENDSub class011ENDSub = getClass011ENDSubExample();
        inheritanceassociationsDao.createClass011ENDSub(class011ENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011ENDSub(class011ENDSub);
        
        // Verify result
        boolean found = false;
        for (Class011ENDSub currentClass011ENDSub : inheritanceassociationsDao.findAllClass011ENDSubs()) {
            if (currentClass011ENDSub.getId().equals(class011ENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011ENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011ENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass011ENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011ENDSub class011ENDSub1 = getClass011ENDSubExample();
        inheritanceassociationsDao.createClass011ENDSub(class011ENDSub1);
                
        Class011ENDSub class011ENDSub2 = getClass011ENDSubExample();
        inheritanceassociationsDao.createClass011ENDSub(class011ENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011ENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011BiENDSub() throws DaoException {
        // fill attributes with example values
        Class011BiENDSub class011BiENDSub = getClass011BiENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass011BiENDSub(class011BiENDSub);

        // Verify result
        boolean found = false;
        for (Class011BiENDSub currentClass011BiENDSub : inheritanceassociationsDao.findAllClass011BiENDSubs()) {
            if (currentClass011BiENDSub.equals(class011BiENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_Bi_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011BiENDSub() throws DaoException {
        // Initialized the test
        Class011BiENDSub class011BiENDSub = getClass011BiENDSubExample();
        inheritanceassociationsDao.createClass011BiENDSub(class011BiENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass011BiENDSub(class011BiENDSub);

        // Verify result
        boolean found = false;
        for (Class011BiENDSub currentClass011BiENDSub : inheritanceassociationsDao.findAllClass011BiENDSubs()) {
            if (currentClass011BiENDSub.equals(class011BiENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class011BiENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011BiENDSub() throws DaoException {
        // Initialized the test
        Class011BiENDSub class011BiENDSub = getClass011BiENDSubExample();
        inheritanceassociationsDao.createClass011BiENDSub(class011BiENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011BiENDSub(class011BiENDSub);
        
        // Verify result
        boolean found = false;
        for (Class011BiENDSub currentClass011BiENDSub : inheritanceassociationsDao.findAllClass011BiENDSubs()) {
            if (currentClass011BiENDSub.getId().equals(class011BiENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011BiENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_Bi_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011BiENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass011BiENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BiENDSub class011BiENDSub1 = getClass011BiENDSubExample();
        inheritanceassociationsDao.createClass011BiENDSub(class011BiENDSub1);
                
        Class011BiENDSub class011BiENDSub2 = getClass011BiENDSubExample();
        inheritanceassociationsDao.createClass011BiENDSub(class011BiENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011BiENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11ENDSub() throws DaoException {
        // fill attributes with example values
        Class11ENDSub class11ENDSub = getClass11ENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass11ENDSub(class11ENDSub);

        // Verify result
        boolean found = false;
        for (Class11ENDSub currentClass11ENDSub : inheritanceassociationsDao.findAllClass11ENDSubs()) {
            if (currentClass11ENDSub.equals(class11ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11ENDSub() throws DaoException {
        // Initialized the test
        Class11ENDSub class11ENDSub = getClass11ENDSubExample();
        inheritanceassociationsDao.createClass11ENDSub(class11ENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass11ENDSub(class11ENDSub);

        // Verify result
        boolean found = false;
        for (Class11ENDSub currentClass11ENDSub : inheritanceassociationsDao.findAllClass11ENDSubs()) {
            if (currentClass11ENDSub.equals(class11ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class11ENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11ENDSub() throws DaoException {
        // Initialized the test
        Class11ENDSub class11ENDSub = getClass11ENDSubExample();
        inheritanceassociationsDao.createClass11ENDSub(class11ENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11ENDSub(class11ENDSub);
        
        // Verify result
        boolean found = false;
        for (Class11ENDSub currentClass11ENDSub : inheritanceassociationsDao.findAllClass11ENDSubs()) {
            if (currentClass11ENDSub.getId().equals(class11ENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11ENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11ENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass11ENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11ENDSub class11ENDSub1 = getClass11ENDSubExample();
        inheritanceassociationsDao.createClass11ENDSub(class11ENDSub1);
                
        Class11ENDSub class11ENDSub2 = getClass11ENDSubExample();
        inheritanceassociationsDao.createClass11ENDSub(class11ENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11ENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BIENDSub() throws DaoException {
        // fill attributes with example values
        Class11BIENDSub class11BIENDSub = getClass11BIENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass11BIENDSub(class11BIENDSub);

        // Verify result
        boolean found = false;
        for (Class11BIENDSub currentClass11BIENDSub : inheritanceassociationsDao.findAllClass11BIENDSubs()) {
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
        inheritanceassociationsDao.createClass11BIENDSub(class11BIENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass11BIENDSub(class11BIENDSub);

        // Verify result
        boolean found = false;
        for (Class11BIENDSub currentClass11BIENDSub : inheritanceassociationsDao.findAllClass11BIENDSubs()) {
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
        inheritanceassociationsDao.createClass11BIENDSub(class11BIENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11BIENDSub(class11BIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class11BIENDSub currentClass11BIENDSub : inheritanceassociationsDao.findAllClass11BIENDSubs()) {
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
        int before = inheritanceassociationsDao.findAllClass11BIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BIENDSub class11BIENDSub1 = getClass11BIENDSubExample();
        inheritanceassociationsDao.createClass11BIENDSub(class11BIENDSub1);
                
        Class11BIENDSub class11BIENDSub2 = getClass11BIENDSubExample();
        inheritanceassociationsDao.createClass11BIENDSub(class11BIENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11BIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyENDSub() throws DaoException {
        // fill attributes with example values
        Class01ManyENDSub class01ManyENDSub = getClass01ManyENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass01ManyENDSub(class01ManyENDSub);

        // Verify result
        boolean found = false;
        for (Class01ManyENDSub currentClass01ManyENDSub : inheritanceassociationsDao.findAllClass01ManyENDSubs()) {
            if (currentClass01ManyENDSub.equals(class01ManyENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyENDSub() throws DaoException {
        // Initialized the test
        Class01ManyENDSub class01ManyENDSub = getClass01ManyENDSubExample();
        inheritanceassociationsDao.createClass01ManyENDSub(class01ManyENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass01ManyENDSub(class01ManyENDSub);

        // Verify result
        boolean found = false;
        for (Class01ManyENDSub currentClass01ManyENDSub : inheritanceassociationsDao.findAllClass01ManyENDSubs()) {
            if (currentClass01ManyENDSub.equals(class01ManyENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class01ManyENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyENDSub() throws DaoException {
        // Initialized the test
        Class01ManyENDSub class01ManyENDSub = getClass01ManyENDSubExample();
        inheritanceassociationsDao.createClass01ManyENDSub(class01ManyENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManyENDSub(class01ManyENDSub);
        
        // Verify result
        boolean found = false;
        for (Class01ManyENDSub currentClass01ManyENDSub : inheritanceassociationsDao.findAllClass01ManyENDSubs()) {
            if (currentClass01ManyENDSub.getId().equals(class01ManyENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass01ManyENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyENDSub class01ManyENDSub1 = getClass01ManyENDSubExample();
        inheritanceassociationsDao.createClass01ManyENDSub(class01ManyENDSub1);
                
        Class01ManyENDSub class01ManyENDSub2 = getClass01ManyENDSubExample();
        inheritanceassociationsDao.createClass01ManyENDSub(class01ManyENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManyENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyBIENDSub() throws DaoException {
        // fill attributes with example values
        Class01ManyBIENDSub class01ManyBIENDSub = getClass01ManyBIENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass01ManyBIENDSub(class01ManyBIENDSub);

        // Verify result
        boolean found = false;
        for (Class01ManyBIENDSub currentClass01ManyBIENDSub : inheritanceassociationsDao.findAllClass01ManyBIENDSubs()) {
            if (currentClass01ManyBIENDSub.equals(class01ManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyBIENDSub() throws DaoException {
        // Initialized the test
        Class01ManyBIENDSub class01ManyBIENDSub = getClass01ManyBIENDSubExample();
        inheritanceassociationsDao.createClass01ManyBIENDSub(class01ManyBIENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass01ManyBIENDSub(class01ManyBIENDSub);

        // Verify result
        boolean found = false;
        for (Class01ManyBIENDSub currentClass01ManyBIENDSub : inheritanceassociationsDao.findAllClass01ManyBIENDSubs()) {
            if (currentClass01ManyBIENDSub.equals(class01ManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class01ManyBIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyBIENDSub() throws DaoException {
        // Initialized the test
        Class01ManyBIENDSub class01ManyBIENDSub = getClass01ManyBIENDSubExample();
        inheritanceassociationsDao.createClass01ManyBIENDSub(class01ManyBIENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManyBIENDSub(class01ManyBIENDSub);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBIENDSub currentClass01ManyBIENDSub : inheritanceassociationsDao.findAllClass01ManyBIENDSubs()) {
            if (currentClass01ManyBIENDSub.getId().equals(class01ManyBIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyBIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyBIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass01ManyBIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBIENDSub class01ManyBIENDSub1 = getClass01ManyBIENDSubExample();
        inheritanceassociationsDao.createClass01ManyBIENDSub(class01ManyBIENDSub1);
                
        Class01ManyBIENDSub class01ManyBIENDSub2 = getClass01ManyBIENDSubExample();
        inheritanceassociationsDao.createClass01ManyBIENDSub(class01ManyBIENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManyBIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01ENDSub() throws DaoException {
        // fill attributes with example values
        ClassMany01ENDSub classMany01ENDSub = getClassMany01ENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassMany01ENDSub(classMany01ENDSub);

        // Verify result
        boolean found = false;
        for (ClassMany01ENDSub currentClassMany01ENDSub : inheritanceassociationsDao.findAllClassMany01ENDSubs()) {
            if (currentClassMany01ENDSub.equals(classMany01ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01ENDSub() throws DaoException {
        // Initialized the test
        ClassMany01ENDSub classMany01ENDSub = getClassMany01ENDSubExample();
        inheritanceassociationsDao.createClassMany01ENDSub(classMany01ENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassMany01ENDSub(classMany01ENDSub);

        // Verify result
        boolean found = false;
        for (ClassMany01ENDSub currentClassMany01ENDSub : inheritanceassociationsDao.findAllClassMany01ENDSubs()) {
            if (currentClassMany01ENDSub.equals(classMany01ENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassMany01ENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01ENDSub() throws DaoException {
        // Initialized the test
        ClassMany01ENDSub classMany01ENDSub = getClassMany01ENDSubExample();
        inheritanceassociationsDao.createClassMany01ENDSub(classMany01ENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01ENDSub(classMany01ENDSub);
        
        // Verify result
        boolean found = false;
        for (ClassMany01ENDSub currentClassMany01ENDSub : inheritanceassociationsDao.findAllClassMany01ENDSubs()) {
            if (currentClassMany01ENDSub.getId().equals(classMany01ENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01ENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01ENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassMany01ENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01ENDSub classMany01ENDSub1 = getClassMany01ENDSubExample();
        inheritanceassociationsDao.createClassMany01ENDSub(classMany01ENDSub1);
                
        ClassMany01ENDSub classMany01ENDSub2 = getClassMany01ENDSubExample();
        inheritanceassociationsDao.createClassMany01ENDSub(classMany01ENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01ENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01BIENDSub() throws DaoException {
        // fill attributes with example values
        ClassMany01BIENDSub classMany01BIENDSub = getClassMany01BIENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassMany01BIENDSub(classMany01BIENDSub);

        // Verify result
        boolean found = false;
        for (ClassMany01BIENDSub currentClassMany01BIENDSub : inheritanceassociationsDao.findAllClassMany01BIENDSubs()) {
            if (currentClassMany01BIENDSub.equals(classMany01BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01BIENDSub() throws DaoException {
        // Initialized the test
        ClassMany01BIENDSub classMany01BIENDSub = getClassMany01BIENDSubExample();
        inheritanceassociationsDao.createClassMany01BIENDSub(classMany01BIENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassMany01BIENDSub(classMany01BIENDSub);

        // Verify result
        boolean found = false;
        for (ClassMany01BIENDSub currentClassMany01BIENDSub : inheritanceassociationsDao.findAllClassMany01BIENDSubs()) {
            if (currentClassMany01BIENDSub.equals(classMany01BIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassMany01BIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01BIENDSub() throws DaoException {
        // Initialized the test
        ClassMany01BIENDSub classMany01BIENDSub = getClassMany01BIENDSubExample();
        inheritanceassociationsDao.createClassMany01BIENDSub(classMany01BIENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01BIENDSub(classMany01BIENDSub);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BIENDSub currentClassMany01BIENDSub : inheritanceassociationsDao.findAllClassMany01BIENDSubs()) {
            if (currentClassMany01BIENDSub.getId().equals(classMany01BIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01BIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01BIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassMany01BIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BIENDSub classMany01BIENDSub1 = getClassMany01BIENDSubExample();
        inheritanceassociationsDao.createClassMany01BIENDSub(classMany01BIENDSub1);
                
        ClassMany01BIENDSub classMany01BIENDSub2 = getClassMany01BIENDSubExample();
        inheritanceassociationsDao.createClassMany01BIENDSub(classMany01BIENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01BIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyEndSub() throws DaoException {
        // fill attributes with example values
        ClassManyManyEndSub classManyManyEndSub = getClassManyManyEndSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassManyManyEndSub(classManyManyEndSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyEndSub currentClassManyManyEndSub : inheritanceassociationsDao.findAllClassManyManyEndSubs()) {
            if (currentClassManyManyEndSub.equals(classManyManyEndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_End_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyEndSub() throws DaoException {
        // Initialized the test
        ClassManyManyEndSub classManyManyEndSub = getClassManyManyEndSubExample();
        inheritanceassociationsDao.createClassManyManyEndSub(classManyManyEndSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassManyManyEndSub(classManyManyEndSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyEndSub currentClassManyManyEndSub : inheritanceassociationsDao.findAllClassManyManyEndSubs()) {
            if (currentClassManyManyEndSub.equals(classManyManyEndSub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManyEndSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyEndSub() throws DaoException {
        // Initialized the test
        ClassManyManyEndSub classManyManyEndSub = getClassManyManyEndSubExample();
        inheritanceassociationsDao.createClassManyManyEndSub(classManyManyEndSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManyEndSub(classManyManyEndSub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyEndSub currentClassManyManyEndSub : inheritanceassociationsDao.findAllClassManyManyEndSubs()) {
            if (currentClassManyManyEndSub.getId().equals(classManyManyEndSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyEndSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_End_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyEndSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassManyManyEndSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyEndSub classManyManyEndSub1 = getClassManyManyEndSubExample();
        inheritanceassociationsDao.createClassManyManyEndSub(classManyManyEndSub1);
                
        ClassManyManyEndSub classManyManyEndSub2 = getClassManyManyEndSubExample();
        inheritanceassociationsDao.createClassManyManyEndSub(classManyManyEndSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManyEndSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyBIENDSub() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIENDSub classManyManyBIENDSub = getClassManyManyBIENDSubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassManyManyBIENDSub(classManyManyBIENDSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIENDSub currentClassManyManyBIENDSub : inheritanceassociationsDao.findAllClassManyManyBIENDSubs()) {
            if (currentClassManyManyBIENDSub.equals(classManyManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_BI_END_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyBIENDSub() throws DaoException {
        // Initialized the test
        ClassManyManyBIENDSub classManyManyBIENDSub = getClassManyManyBIENDSubExample();
        inheritanceassociationsDao.createClassManyManyBIENDSub(classManyManyBIENDSub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassManyManyBIENDSub(classManyManyBIENDSub);

        // Verify result
        boolean found = false;
        for (ClassManyManyBIENDSub currentClassManyManyBIENDSub : inheritanceassociationsDao.findAllClassManyManyBIENDSubs()) {
            if (currentClassManyManyBIENDSub.equals(classManyManyBIENDSub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManyBIENDSub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyBIENDSub() throws DaoException {
        // Initialized the test
        ClassManyManyBIENDSub classManyManyBIENDSub = getClassManyManyBIENDSubExample();
        inheritanceassociationsDao.createClassManyManyBIENDSub(classManyManyBIENDSub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManyBIENDSub(classManyManyBIENDSub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBIENDSub currentClassManyManyBIENDSub : inheritanceassociationsDao.findAllClassManyManyBIENDSubs()) {
            if (currentClassManyManyBIENDSub.getId().equals(classManyManyBIENDSub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyBIENDSub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_BI_END_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyBIENDSubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassManyManyBIENDSubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBIENDSub classManyManyBIENDSub1 = getClassManyManyBIENDSubExample();
        inheritanceassociationsDao.createClassManyManyBIENDSub(classManyManyBIENDSub1);
                
        ClassManyManyBIENDSub classManyManyBIENDSub2 = getClassManyManyBIENDSubExample();
        inheritanceassociationsDao.createClassManyManyBIENDSub(classManyManyBIENDSub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManyBIENDSubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101Sub() throws DaoException {
        // fill attributes with example values
        Class0101Sub class0101Sub = getClass0101SubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass0101Sub(class0101Sub);

        // Verify result
        boolean found = false;
        for (Class0101Sub currentClass0101Sub : inheritanceassociationsDao.findAllClass0101Subs()) {
            if (currentClass0101Sub.equals(class0101Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101Sub() throws DaoException {
        // Initialized the test
        Class0101Sub class0101Sub = getClass0101SubExample();
        inheritanceassociationsDao.createClass0101Sub(class0101Sub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass0101Sub(class0101Sub);

        // Verify result
        boolean found = false;
        for (Class0101Sub currentClass0101Sub : inheritanceassociationsDao.findAllClass0101Subs()) {
            if (currentClass0101Sub.equals(class0101Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class0101Sub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101Sub() throws DaoException {
        // Initialized the test
        Class0101Sub class0101Sub = getClass0101SubExample();
        inheritanceassociationsDao.createClass0101Sub(class0101Sub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101Sub(class0101Sub);
        
        // Verify result
        boolean found = false;
        for (Class0101Sub currentClass0101Sub : inheritanceassociationsDao.findAllClass0101Subs()) {
            if (currentClass0101Sub.getId().equals(class0101Sub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101Sub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101Subs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass0101Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101Sub class0101Sub1 = getClass0101SubExample();
        inheritanceassociationsDao.createClass0101Sub(class0101Sub1);
                
        Class0101Sub class0101Sub2 = getClass0101SubExample();
        inheritanceassociationsDao.createClass0101Sub(class0101Sub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass0101BISub() throws DaoException {
        // fill attributes with example values
        Class0101BISub class0101BISub = getClass0101BISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass0101BISub(class0101BISub);

        // Verify result
        boolean found = false;
        for (Class0101BISub currentClass0101BISub : inheritanceassociationsDao.findAllClass0101BISubs()) {
            if (currentClass0101BISub.equals(class0101BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_01_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass0101BISub() throws DaoException {
        // Initialized the test
        Class0101BISub class0101BISub = getClass0101BISubExample();
        inheritanceassociationsDao.createClass0101BISub(class0101BISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass0101BISub(class0101BISub);

        // Verify result
        boolean found = false;
        for (Class0101BISub currentClass0101BISub : inheritanceassociationsDao.findAllClass0101BISubs()) {
            if (currentClass0101BISub.equals(class0101BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class0101BISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass0101BISub() throws DaoException {
        // Initialized the test
        Class0101BISub class0101BISub = getClass0101BISubExample();
        inheritanceassociationsDao.createClass0101BISub(class0101BISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass0101BISub(class0101BISub);
        
        // Verify result
        boolean found = false;
        for (Class0101BISub currentClass0101BISub : inheritanceassociationsDao.findAllClass0101BISubs()) {
            if (currentClass0101BISub.getId().equals(class0101BISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class0101BISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass0101BISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass0101BISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class0101BISub class0101BISub1 = getClass0101BISubExample();
        inheritanceassociationsDao.createClass0101BISub(class0101BISub1);
                
        Class0101BISub class0101BISub2 = getClass0101BISubExample();
        inheritanceassociationsDao.createClass0101BISub(class0101BISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass0101BISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101Sub() throws DaoException {
        // fill attributes with example values
        Class101Sub class101Sub = getClass101SubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass101Sub(class101Sub);

        // Verify result
        boolean found = false;
        for (Class101Sub currentClass101Sub : inheritanceassociationsDao.findAllClass101Subs()) {
            if (currentClass101Sub.equals(class101Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101Sub() throws DaoException {
        // Initialized the test
        Class101Sub class101Sub = getClass101SubExample();
        inheritanceassociationsDao.createClass101Sub(class101Sub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass101Sub(class101Sub);

        // Verify result
        boolean found = false;
        for (Class101Sub currentClass101Sub : inheritanceassociationsDao.findAllClass101Subs()) {
            if (currentClass101Sub.equals(class101Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101Sub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101Sub() throws DaoException {
        // Initialized the test
        Class101Sub class101Sub = getClass101SubExample();
        inheritanceassociationsDao.createClass101Sub(class101Sub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101Sub(class101Sub);
        
        // Verify result
        boolean found = false;
        for (Class101Sub currentClass101Sub : inheritanceassociationsDao.findAllClass101Subs()) {
            if (currentClass101Sub.getId().equals(class101Sub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101Sub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101Subs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass101Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101Sub class101Sub1 = getClass101SubExample();
        inheritanceassociationsDao.createClass101Sub(class101Sub1);
                
        Class101Sub class101Sub2 = getClass101SubExample();
        inheritanceassociationsDao.createClass101Sub(class101Sub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass101BISub() throws DaoException {
        // fill attributes with example values
        Class101BISub class101BISub = getClass101BISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass101BISub(class101BISub);

        // Verify result
        boolean found = false;
        for (Class101BISub currentClass101BISub : inheritanceassociationsDao.findAllClass101BISubs()) {
            if (currentClass101BISub.equals(class101BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_01_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass101BISub() throws DaoException {
        // Initialized the test
        Class101BISub class101BISub = getClass101BISubExample();
        inheritanceassociationsDao.createClass101BISub(class101BISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass101BISub(class101BISub);

        // Verify result
        boolean found = false;
        for (Class101BISub currentClass101BISub : inheritanceassociationsDao.findAllClass101BISubs()) {
            if (currentClass101BISub.equals(class101BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class101BISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass101BISub() throws DaoException {
        // Initialized the test
        Class101BISub class101BISub = getClass101BISubExample();
        inheritanceassociationsDao.createClass101BISub(class101BISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass101BISub(class101BISub);
        
        // Verify result
        boolean found = false;
        for (Class101BISub currentClass101BISub : inheritanceassociationsDao.findAllClass101BISubs()) {
            if (currentClass101BISub.getId().equals(class101BISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class101BISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass101BISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass101BISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class101BISub class101BISub1 = getClass101BISubExample();
        inheritanceassociationsDao.createClass101BISub(class101BISub1);
                
        Class101BISub class101BISub2 = getClass101BISubExample();
        inheritanceassociationsDao.createClass101BISub(class101BISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass101BISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011Sub() throws DaoException {
        // fill attributes with example values
        Class011Sub class011Sub = getClass011SubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass011Sub(class011Sub);

        // Verify result
        boolean found = false;
        for (Class011Sub currentClass011Sub : inheritanceassociationsDao.findAllClass011Subs()) {
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
        inheritanceassociationsDao.createClass011Sub(class011Sub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass011Sub(class011Sub);

        // Verify result
        boolean found = false;
        for (Class011Sub currentClass011Sub : inheritanceassociationsDao.findAllClass011Subs()) {
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
        inheritanceassociationsDao.createClass011Sub(class011Sub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011Sub(class011Sub);
        
        // Verify result
        boolean found = false;
        for (Class011Sub currentClass011Sub : inheritanceassociationsDao.findAllClass011Subs()) {
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
        int before = inheritanceassociationsDao.findAllClass011Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011Sub class011Sub1 = getClass011SubExample();
        inheritanceassociationsDao.createClass011Sub(class011Sub1);
                
        Class011Sub class011Sub2 = getClass011SubExample();
        inheritanceassociationsDao.createClass011Sub(class011Sub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass011BISub() throws DaoException {
        // fill attributes with example values
        Class011BISub class011BISub = getClass011BISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass011BISub(class011BISub);

        // Verify result
        boolean found = false;
        for (Class011BISub currentClass011BISub : inheritanceassociationsDao.findAllClass011BISubs()) {
            if (currentClass011BISub.equals(class011BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_1_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass011BISub() throws DaoException {
        // Initialized the test
        Class011BISub class011BISub = getClass011BISubExample();
        inheritanceassociationsDao.createClass011BISub(class011BISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass011BISub(class011BISub);

        // Verify result
        boolean found = false;
        for (Class011BISub currentClass011BISub : inheritanceassociationsDao.findAllClass011BISubs()) {
            if (currentClass011BISub.equals(class011BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class011BISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass011BISub() throws DaoException {
        // Initialized the test
        Class011BISub class011BISub = getClass011BISubExample();
        inheritanceassociationsDao.createClass011BISub(class011BISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass011BISub(class011BISub);
        
        // Verify result
        boolean found = false;
        for (Class011BISub currentClass011BISub : inheritanceassociationsDao.findAllClass011BISubs()) {
            if (currentClass011BISub.getId().equals(class011BISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class011BISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass011BISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass011BISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class011BISub class011BISub1 = getClass011BISubExample();
        inheritanceassociationsDao.createClass011BISub(class011BISub1);
                
        Class011BISub class011BISub2 = getClass011BISubExample();
        inheritanceassociationsDao.createClass011BISub(class011BISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass011BISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11Sub() throws DaoException {
        // fill attributes with example values
        Class11Sub class11Sub = getClass11SubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass11Sub(class11Sub);

        // Verify result
        boolean found = false;
        for (Class11Sub currentClass11Sub : inheritanceassociationsDao.findAllClass11Subs()) {
            if (currentClass11Sub.equals(class11Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11Sub() throws DaoException {
        // Initialized the test
        Class11Sub class11Sub = getClass11SubExample();
        inheritanceassociationsDao.createClass11Sub(class11Sub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass11Sub(class11Sub);

        // Verify result
        boolean found = false;
        for (Class11Sub currentClass11Sub : inheritanceassociationsDao.findAllClass11Subs()) {
            if (currentClass11Sub.equals(class11Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class11Sub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11Sub() throws DaoException {
        // Initialized the test
        Class11Sub class11Sub = getClass11SubExample();
        inheritanceassociationsDao.createClass11Sub(class11Sub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11Sub(class11Sub);
        
        // Verify result
        boolean found = false;
        for (Class11Sub currentClass11Sub : inheritanceassociationsDao.findAllClass11Subs()) {
            if (currentClass11Sub.getId().equals(class11Sub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11Sub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11Subs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass11Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11Sub class11Sub1 = getClass11SubExample();
        inheritanceassociationsDao.createClass11Sub(class11Sub1);
                
        Class11Sub class11Sub2 = getClass11SubExample();
        inheritanceassociationsDao.createClass11Sub(class11Sub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_1_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass11BISub() throws DaoException {
        // fill attributes with example values
        Class11BISub class11BISub = getClass11BISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass11BISub(class11BISub);

        // Verify result
        boolean found = false;
        for (Class11BISub currentClass11BISub : inheritanceassociationsDao.findAllClass11BISubs()) {
            if (currentClass11BISub.equals(class11BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_1_1_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_1_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass11BISub() throws DaoException {
        // Initialized the test
        Class11BISub class11BISub = getClass11BISubExample();
        inheritanceassociationsDao.createClass11BISub(class11BISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass11BISub(class11BISub);

        // Verify result
        boolean found = false;
        for (Class11BISub currentClass11BISub : inheritanceassociationsDao.findAllClass11BISubs()) {
            if (currentClass11BISub.equals(class11BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class11BISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_1_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass11BISub() throws DaoException {
        // Initialized the test
        Class11BISub class11BISub = getClass11BISubExample();
        inheritanceassociationsDao.createClass11BISub(class11BISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass11BISub(class11BISub);
        
        // Verify result
        boolean found = false;
        for (Class11BISub currentClass11BISub : inheritanceassociationsDao.findAllClass11BISubs()) {
            if (currentClass11BISub.getId().equals(class11BISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class11BISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_1_1_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass11BISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass11BISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class11BISub class11BISub1 = getClass11BISubExample();
        inheritanceassociationsDao.createClass11BISub(class11BISub1);
                
        Class11BISub class11BISub2 = getClass11BISubExample();
        inheritanceassociationsDao.createClass11BISub(class11BISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass11BISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManySub() throws DaoException {
        // fill attributes with example values
        Class01ManySub class01ManySub = getClass01ManySubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass01ManySub(class01ManySub);

        // Verify result
        boolean found = false;
        for (Class01ManySub currentClass01ManySub : inheritanceassociationsDao.findAllClass01ManySubs()) {
            if (currentClass01ManySub.equals(class01ManySub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManySub() throws DaoException {
        // Initialized the test
        Class01ManySub class01ManySub = getClass01ManySubExample();
        inheritanceassociationsDao.createClass01ManySub(class01ManySub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass01ManySub(class01ManySub);

        // Verify result
        boolean found = false;
        for (Class01ManySub currentClass01ManySub : inheritanceassociationsDao.findAllClass01ManySubs()) {
            if (currentClass01ManySub.equals(class01ManySub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class01ManySub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManySub() throws DaoException {
        // Initialized the test
        Class01ManySub class01ManySub = getClass01ManySubExample();
        inheritanceassociationsDao.createClass01ManySub(class01ManySub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManySub(class01ManySub);
        
        // Verify result
        boolean found = false;
        for (Class01ManySub currentClass01ManySub : inheritanceassociationsDao.findAllClass01ManySubs()) {
            if (currentClass01ManySub.getId().equals(class01ManySub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManySub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManySubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass01ManySubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManySub class01ManySub1 = getClass01ManySubExample();
        inheritanceassociationsDao.createClass01ManySub(class01ManySub1);
                
        Class01ManySub class01ManySub2 = getClass01ManySubExample();
        inheritanceassociationsDao.createClass01ManySub(class01ManySub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManySubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_01_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClass01ManyBISub() throws DaoException {
        // fill attributes with example values
        Class01ManyBISub class01ManyBISub = getClass01ManyBISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClass01ManyBISub(class01ManyBISub);

        // Verify result
        boolean found = false;
        for (Class01ManyBISub currentClass01ManyBISub : inheritanceassociationsDao.findAllClass01ManyBISubs()) {
            if (currentClass01ManyBISub.equals(class01ManyBISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_01_Many_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_01_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClass01ManyBISub() throws DaoException {
        // Initialized the test
        Class01ManyBISub class01ManyBISub = getClass01ManyBISubExample();
        inheritanceassociationsDao.createClass01ManyBISub(class01ManyBISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClass01ManyBISub(class01ManyBISub);

        // Verify result
        boolean found = false;
        for (Class01ManyBISub currentClass01ManyBISub : inheritanceassociationsDao.findAllClass01ManyBISubs()) {
            if (currentClass01ManyBISub.equals(class01ManyBISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class01ManyBISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_01_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClass01ManyBISub() throws DaoException {
        // Initialized the test
        Class01ManyBISub class01ManyBISub = getClass01ManyBISubExample();
        inheritanceassociationsDao.createClass01ManyBISub(class01ManyBISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClass01ManyBISub(class01ManyBISub);
        
        // Verify result
        boolean found = false;
        for (Class01ManyBISub currentClass01ManyBISub : inheritanceassociationsDao.findAllClass01ManyBISubs()) {
            if (currentClass01ManyBISub.getId().equals(class01ManyBISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Class01ManyBISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_01_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClass01ManyBISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClass01ManyBISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Class01ManyBISub class01ManyBISub1 = getClass01ManyBISubExample();
        inheritanceassociationsDao.createClass01ManyBISub(class01ManyBISub1);
                
        Class01ManyBISub class01ManyBISub2 = getClass01ManyBISubExample();
        inheritanceassociationsDao.createClass01ManyBISub(class01ManyBISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClass01ManyBISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01Sub() throws DaoException {
        // fill attributes with example values
        ClassMany01Sub classMany01Sub = getClassMany01SubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassMany01Sub(classMany01Sub);

        // Verify result
        boolean found = false;
        for (ClassMany01Sub currentClassMany01Sub : inheritanceassociationsDao.findAllClassMany01Subs()) {
            if (currentClassMany01Sub.equals(classMany01Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01Sub() throws DaoException {
        // Initialized the test
        ClassMany01Sub classMany01Sub = getClassMany01SubExample();
        inheritanceassociationsDao.createClassMany01Sub(classMany01Sub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassMany01Sub(classMany01Sub);

        // Verify result
        boolean found = false;
        for (ClassMany01Sub currentClassMany01Sub : inheritanceassociationsDao.findAllClassMany01Subs()) {
            if (currentClassMany01Sub.equals(classMany01Sub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassMany01Sub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01Sub() throws DaoException {
        // Initialized the test
        ClassMany01Sub classMany01Sub = getClassMany01SubExample();
        inheritanceassociationsDao.createClassMany01Sub(classMany01Sub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01Sub(classMany01Sub);
        
        // Verify result
        boolean found = false;
        for (ClassMany01Sub currentClassMany01Sub : inheritanceassociationsDao.findAllClassMany01Subs()) {
            if (currentClassMany01Sub.getId().equals(classMany01Sub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01Sub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01Subs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassMany01Subs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01Sub classMany01Sub1 = getClassMany01SubExample();
        inheritanceassociationsDao.createClassMany01Sub(classMany01Sub1);
                
        ClassMany01Sub classMany01Sub2 = getClassMany01SubExample();
        inheritanceassociationsDao.createClassMany01Sub(classMany01Sub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01Subs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassMany01BISub() throws DaoException {
        // fill attributes with example values
        ClassMany01BISub classMany01BISub = getClassMany01BISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassMany01BISub(classMany01BISub);

        // Verify result
        boolean found = false;
        for (ClassMany01BISub currentClassMany01BISub : inheritanceassociationsDao.findAllClassMany01BISubs()) {
            if (currentClassMany01BISub.equals(classMany01BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_01_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassMany01BISub() throws DaoException {
        // Initialized the test
        ClassMany01BISub classMany01BISub = getClassMany01BISubExample();
        inheritanceassociationsDao.createClassMany01BISub(classMany01BISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassMany01BISub(classMany01BISub);

        // Verify result
        boolean found = false;
        for (ClassMany01BISub currentClassMany01BISub : inheritanceassociationsDao.findAllClassMany01BISubs()) {
            if (currentClassMany01BISub.equals(classMany01BISub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassMany01BISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassMany01BISub() throws DaoException {
        // Initialized the test
        ClassMany01BISub classMany01BISub = getClassMany01BISubExample();
        inheritanceassociationsDao.createClassMany01BISub(classMany01BISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassMany01BISub(classMany01BISub);
        
        // Verify result
        boolean found = false;
        for (ClassMany01BISub currentClassMany01BISub : inheritanceassociationsDao.findAllClassMany01BISubs()) {
            if (currentClassMany01BISub.getId().equals(classMany01BISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassMany01BISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_01_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassMany01BISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassMany01BISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassMany01BISub classMany01BISub1 = getClassMany01BISubExample();
        inheritanceassociationsDao.createClassMany01BISub(classMany01BISub1);
                
        ClassMany01BISub classMany01BISub2 = getClassMany01BISubExample();
        inheritanceassociationsDao.createClassMany01BISub(classMany01BISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassMany01BISubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManySub() throws DaoException {
        // fill attributes with example values
        ClassManyManySub classManyManySub = getClassManyManySubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassManyManySub(classManyManySub);

        // Verify result
        boolean found = false;
        for (ClassManyManySub currentClassManyManySub : inheritanceassociationsDao.findAllClassManyManySubs()) {
            if (currentClassManyManySub.equals(classManyManySub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManySub() throws DaoException {
        // Initialized the test
        ClassManyManySub classManyManySub = getClassManyManySubExample();
        inheritanceassociationsDao.createClassManyManySub(classManyManySub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassManyManySub(classManyManySub);

        // Verify result
        boolean found = false;
        for (ClassManyManySub currentClassManyManySub : inheritanceassociationsDao.findAllClassManyManySubs()) {
            if (currentClassManyManySub.equals(classManyManySub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManySub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManySub() throws DaoException {
        // Initialized the test
        ClassManyManySub classManyManySub = getClassManyManySubExample();
        inheritanceassociationsDao.createClassManyManySub(classManyManySub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManySub(classManyManySub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManySub currentClassManyManySub : inheritanceassociationsDao.findAllClassManyManySubs()) {
            if (currentClassManyManySub.getId().equals(classManyManySub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManySub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManySubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassManyManySubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManySub classManyManySub1 = getClassManyManySubExample();
        inheritanceassociationsDao.createClassManyManySub(classManyManySub1);
                
        ClassManyManySub classManyManySub2 = getClassManyManySubExample();
        inheritanceassociationsDao.createClassManyManySub(classManyManySub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManySubs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Class_Many_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassManyManyBISub() throws DaoException {
        // fill attributes with example values
        ClassManyManyBISub classManyManyBISub = getClassManyManyBISubExample();
        
        // Execute the tested code
        inheritanceassociationsDao.createClassManyManyBISub(classManyManyBISub);

        // Verify result
        boolean found = false;
        for (ClassManyManyBISub currentClassManyManyBISub : inheritanceassociationsDao.findAllClassManyManyBISubs()) {
            if (currentClassManyManyBISub.equals(classManyManyBISub)) {
                found = true;
            }
        }
        Assert.assertTrue("Class_Many_Many_BI_Sub not created", found);
    }

    /**
     * Test the modification of an entity Class_Many_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassManyManyBISub() throws DaoException {
        // Initialized the test
        ClassManyManyBISub classManyManyBISub = getClassManyManyBISubExample();
        inheritanceassociationsDao.createClassManyManyBISub(classManyManyBISub);

        // Execute the tested code
        inheritanceassociationsDao.updateClassManyManyBISub(classManyManyBISub);

        // Verify result
        boolean found = false;
        for (ClassManyManyBISub currentClassManyManyBISub : inheritanceassociationsDao.findAllClassManyManyBISubs()) {
            if (currentClassManyManyBISub.equals(classManyManyBISub)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassManyManyBISub not found", found);
    }

    /**
     * Test the suppression of an entity Class_Many_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassManyManyBISub() throws DaoException {
        // Initialized the test
        ClassManyManyBISub classManyManyBISub = getClassManyManyBISubExample();
        inheritanceassociationsDao.createClassManyManyBISub(classManyManyBISub);
        
        // Execute the tested code
        inheritanceassociationsDao.deleteClassManyManyBISub(classManyManyBISub);
        
        // Verify result
        boolean found = false;
        for (ClassManyManyBISub currentClassManyManyBISub : inheritanceassociationsDao.findAllClassManyManyBISubs()) {
            if (currentClassManyManyBISub.getId().equals(classManyManyBISub.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassManyManyBISub not deleted", found);
    }

    /**
     * Test the search of all entities Class_Many_Many_BI_Sub.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassManyManyBISubs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceassociationsDao.findAllClassManyManyBISubs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassManyManyBISub classManyManyBISub1 = getClassManyManyBISubExample();
        inheritanceassociationsDao.createClassManyManyBISub(classManyManyBISub1);
                
        ClassManyManyBISub classManyManyBISub2 = getClassManyManyBISubExample();
        inheritanceassociationsDao.createClassManyManyBISub(classManyManyBISub2);

        // Verify result
        int after = inheritanceassociationsDao.findAllClassManyManyBISubs().size();
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
        class0101END.setFakeAttr("myFakeAttr");


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
        class0101END.setFakeAttr("secondFakeAttr");


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
        class0101BI.setFakeAttr("myFakeAttr");


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
        class0101BI.setFakeAttr("secondFakeAttr");


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
        class0101BIEND.setFakeAttr("myFakeAttr");


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
        class0101BIEND.setFakeAttr("secondFakeAttr");


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
        class101END.setFakeAttr("myFakeAttr");


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
        class101END.setFakeAttr("secondFakeAttr");


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
        inheritanceassociationsDao.createClass101BI(sourceExample);

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
        inheritanceassociationsDao.createClass101BI(sourceExample);

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
        class011.setFakeAttr("myFakeAttr");

        Class011END targetExample = new Class011END();
        class011.setTarget(targetExample);   
        inheritanceassociationsDao.createClass011END(targetExample);

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
        class011.setFakeAttr("secondFakeAttr");

        Class011END targetExample = new Class011END();
        class011.setTarget(targetExample);   
        inheritanceassociationsDao.createClass011END(targetExample);

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
        class011END.setFakeAttr("myFakeAttr");


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
        class011END.setFakeAttr("secondFakeAttr");


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
        inheritanceassociationsDao.createClass011BIEND(targetExample);

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
        inheritanceassociationsDao.createClass011BIEND(targetExample);

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
        class011BIEND.setFakeAttr("myFakeAttr");


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
        class011BIEND.setFakeAttr("secondFakeAttr");


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
        class11.setFakeAttr("myFakeAttr");

        Class11END targetExample = new Class11END();
        class11.setTarget(targetExample);   
        inheritanceassociationsDao.createClass11END(targetExample);

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
        class11.setFakeAttr("secondFakeAttr");

        Class11END targetExample = new Class11END();
        class11.setTarget(targetExample);   
        inheritanceassociationsDao.createClass11END(targetExample);

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
        class11END.setFakeAttr("myFakeAttr");


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
        class11END.setFakeAttr("secondFakeAttr");


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
        class11BI.setFakeAttr("myFakeAttr");

        Class11BIEND targetExample = new Class11BIEND();
        class11BI.setTarget(targetExample);   
        targetExample.setSource(class11BI); 
        inheritanceassociationsDao.createClass11BIEND(targetExample);

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
        class11BI.setFakeAttr("secondFakeAttr");

        Class11BIEND targetExample = new Class11BIEND();
        class11BI.setTarget(targetExample);   
        targetExample.setSource(class11BI); 
        inheritanceassociationsDao.createClass11BIEND(targetExample);

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
        class11BIEND.setFakeAttr("myFakeAttr");

        Class11BI sourceExample = new Class11BI();
        class11BIEND.setSource(sourceExample);   
        sourceExample.setTarget(class11BIEND); 
        inheritanceassociationsDao.createClass11BI(sourceExample);

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
        inheritanceassociationsDao.createClass11BI(sourceExample);

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
        class01Many.setFakeAttr("myFakeAttr");


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
        class01Many.setFakeAttr("secondFakeAttr");


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
        class01ManyEND.setFakeAttr("myFakeAttr");


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
        class01ManyEND.setFakeAttr("secondFakeAttr");


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
        class01ManyBI.setFakeAttr("myFakeAttr");


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
        class01ManyBI.setFakeAttr("secondFakeAttr");


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
        class01ManyBIEND.setFakeAttr("myFakeAttr");


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
        class01ManyBIEND.setFakeAttr("secondFakeAttr");


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
   /**
     * Creates an example of Class_Many_01_END.
     * @return Returns a new instance of class Class_Many_01_END, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01END getClassMany01ENDExample() throws DaoException {
        // fill attributes with example values
        ClassMany01END classMany01END = new ClassMany01END();
        classMany01END.setFakeAttr("myFakeAttr");


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
        classMany01END.setFakeAttr("secondFakeAttr");


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
        classMany01BIEND.setFakeAttr("myFakeAttr");


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
        classMany01BIEND.setFakeAttr("secondFakeAttr");


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
        classManyMany.setFakeAttr("myFakeAttr");


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
        classManyMany.setFakeAttr("secondFakeAttr");


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
        classManyManyBI.setFakeAttr("myFakeAttr");


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
        classManyManyBI.setFakeAttr("secondFakeAttr");


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
        classManyManyBIEND.setFakeAttr("myFakeAttr");


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
        classManyManyBIEND.setFakeAttr("secondFakeAttr");


        return classManyManyBIEND;
    }
   /**
     * Creates an example of Class_01_01_END_Sub.
     * @return Returns a new instance of class Class_01_01_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101ENDSub getClass0101ENDSubExample() throws DaoException {
        // fill attributes with example values
        Class0101ENDSub class0101ENDSub = new Class0101ENDSub();
        class0101ENDSub.setFakeAttr("myFakeAttr");


        return class0101ENDSub;
    }
    
    /**
     * Creates a second example of Class_01_01_END_Sub with other values.
     * @return Returns a new instance of class Class_01_01_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101ENDSub getClass0101ENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class0101ENDSub class0101ENDSub = new Class0101ENDSub();
        class0101ENDSub.setFakeAttr("secondFakeAttr");


        return class0101ENDSub;
    }
   /**
     * Creates an example of Class_01_01_BI_END_Sub.
     * @return Returns a new instance of class Class_01_01_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BIENDSub getClass0101BIENDSubExample() throws DaoException {
        // fill attributes with example values
        Class0101BIENDSub class0101BIENDSub = new Class0101BIENDSub();
        class0101BIENDSub.setFakeAttr("myFakeAttr");


        return class0101BIENDSub;
    }
    
    /**
     * Creates a second example of Class_01_01_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_01_01_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BIENDSub getClass0101BIENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class0101BIENDSub class0101BIENDSub = new Class0101BIENDSub();
        class0101BIENDSub.setFakeAttr("secondFakeAttr");


        return class0101BIENDSub;
    }
   /**
     * Creates an example of Class_1_01_End_Sub.
     * @return Returns a new instance of class Class_1_01_End_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101EndSub getClass101EndSubExample() throws DaoException {
        // fill attributes with example values
        Class101EndSub class101EndSub = new Class101EndSub();
        class101EndSub.setFakeAttr("myFakeAttr");


        return class101EndSub;
    }
    
    /**
     * Creates a second example of Class_1_01_End_Sub with other values.
     * @return Returns a new instance of class Class_1_01_End_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101EndSub getClass101EndSubExample2() throws DaoException {
        // fill attributes with example values
        Class101EndSub class101EndSub = new Class101EndSub();
        class101EndSub.setFakeAttr("secondFakeAttr");


        return class101EndSub;
    }
   /**
     * Creates an example of Class_1_01_BI_END_Sub.
     * @return Returns a new instance of class Class_1_01_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BIENDSub getClass101BIENDSubExample() throws DaoException {
        // fill attributes with example values
        Class101BIENDSub class101BIENDSub = new Class101BIENDSub();

        Class101BI sourceExample = new Class101BI();
        class101BIENDSub.setSource(sourceExample);   
        sourceExample.setTarget(class101BIENDSub); 
        inheritanceassociationsDao.createClass101BI(sourceExample);

        return class101BIENDSub;
    }
    
    /**
     * Creates a second example of Class_1_01_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_1_01_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BIENDSub getClass101BIENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class101BIENDSub class101BIENDSub = new Class101BIENDSub();

        Class101BI sourceExample = new Class101BI();
        class101BIENDSub.setSource(sourceExample);   
        sourceExample.setTarget(class101BIENDSub); 
        inheritanceassociationsDao.createClass101BI(sourceExample);

        return class101BIENDSub;
    }
   /**
     * Creates an example of Class_01_1_END_Sub.
     * @return Returns a new instance of class Class_01_1_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011ENDSub getClass011ENDSubExample() throws DaoException {
        // fill attributes with example values
        Class011ENDSub class011ENDSub = new Class011ENDSub();
        class011ENDSub.setFakeAttr("myFakeAttr");


        return class011ENDSub;
    }
    
    /**
     * Creates a second example of Class_01_1_END_Sub with other values.
     * @return Returns a new instance of class Class_01_1_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011ENDSub getClass011ENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class011ENDSub class011ENDSub = new Class011ENDSub();
        class011ENDSub.setFakeAttr("secondFakeAttr");


        return class011ENDSub;
    }
   /**
     * Creates an example of Class_01_1_Bi_END_Sub.
     * @return Returns a new instance of class Class_01_1_Bi_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BiENDSub getClass011BiENDSubExample() throws DaoException {
        // fill attributes with example values
        Class011BiENDSub class011BiENDSub = new Class011BiENDSub();
        class011BiENDSub.setFakeAttr("myFakeAttr");


        return class011BiENDSub;
    }
    
    /**
     * Creates a second example of Class_01_1_Bi_END_Sub with other values.
     * @return Returns a new instance of class Class_01_1_Bi_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BiENDSub getClass011BiENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class011BiENDSub class011BiENDSub = new Class011BiENDSub();
        class011BiENDSub.setFakeAttr("secondFakeAttr");


        return class011BiENDSub;
    }
   /**
     * Creates an example of Class_1_1_END_Sub.
     * @return Returns a new instance of class Class_1_1_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11ENDSub getClass11ENDSubExample() throws DaoException {
        // fill attributes with example values
        Class11ENDSub class11ENDSub = new Class11ENDSub();
        class11ENDSub.setFakeAttr("myFakeAttr");


        return class11ENDSub;
    }
    
    /**
     * Creates a second example of Class_1_1_END_Sub with other values.
     * @return Returns a new instance of class Class_1_1_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11ENDSub getClass11ENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class11ENDSub class11ENDSub = new Class11ENDSub();
        class11ENDSub.setFakeAttr("secondFakeAttr");


        return class11ENDSub;
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
        inheritanceassociationsDao.createClass11BI(sourceExample);

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
        inheritanceassociationsDao.createClass11BI(sourceExample);

        return class11BIENDSub;
    }
   /**
     * Creates an example of Class_01_Many_END_Sub.
     * @return Returns a new instance of class Class_01_Many_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyENDSub getClass01ManyENDSubExample() throws DaoException {
        // fill attributes with example values
        Class01ManyENDSub class01ManyENDSub = new Class01ManyENDSub();
        class01ManyENDSub.setFakeAttr("myFakeAttr");


        return class01ManyENDSub;
    }
    
    /**
     * Creates a second example of Class_01_Many_END_Sub with other values.
     * @return Returns a new instance of class Class_01_Many_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyENDSub getClass01ManyENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyENDSub class01ManyENDSub = new Class01ManyENDSub();
        class01ManyENDSub.setFakeAttr("secondFakeAttr");


        return class01ManyENDSub;
    }
   /**
     * Creates an example of Class_01_Many_BI_END_Sub.
     * @return Returns a new instance of class Class_01_Many_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBIENDSub getClass01ManyBIENDSubExample() throws DaoException {
        // fill attributes with example values
        Class01ManyBIENDSub class01ManyBIENDSub = new Class01ManyBIENDSub();
        class01ManyBIENDSub.setFakeAttr("myFakeAttr");


        return class01ManyBIENDSub;
    }
    
    /**
     * Creates a second example of Class_01_Many_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_01_Many_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBIENDSub getClass01ManyBIENDSubExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyBIENDSub class01ManyBIENDSub = new Class01ManyBIENDSub();
        class01ManyBIENDSub.setFakeAttr("secondFakeAttr");


        return class01ManyBIENDSub;
    }
   /**
     * Creates an example of Class_Many_01_END_Sub.
     * @return Returns a new instance of class Class_Many_01_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01ENDSub getClassMany01ENDSubExample() throws DaoException {
        // fill attributes with example values
        ClassMany01ENDSub classMany01ENDSub = new ClassMany01ENDSub();
        classMany01ENDSub.setFakeAttr("myFakeAttr");


        return classMany01ENDSub;
    }
    
    /**
     * Creates a second example of Class_Many_01_END_Sub with other values.
     * @return Returns a new instance of class Class_Many_01_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01ENDSub getClassMany01ENDSubExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01ENDSub classMany01ENDSub = new ClassMany01ENDSub();
        classMany01ENDSub.setFakeAttr("secondFakeAttr");


        return classMany01ENDSub;
    }
   /**
     * Creates an example of Class_Many_01_BI_END_Sub.
     * @return Returns a new instance of class Class_Many_01_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BIENDSub getClassMany01BIENDSubExample() throws DaoException {
        // fill attributes with example values
        ClassMany01BIENDSub classMany01BIENDSub = new ClassMany01BIENDSub();
        classMany01BIENDSub.setFakeAttr("myFakeAttr");


        return classMany01BIENDSub;
    }
    
    /**
     * Creates a second example of Class_Many_01_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_Many_01_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BIENDSub getClassMany01BIENDSubExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01BIENDSub classMany01BIENDSub = new ClassMany01BIENDSub();
        classMany01BIENDSub.setFakeAttr("secondFakeAttr");


        return classMany01BIENDSub;
    }
   /**
     * Creates an example of Class_Many_Many_End_Sub.
     * @return Returns a new instance of class Class_Many_Many_End_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEndSub getClassManyManyEndSubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyEndSub classManyManyEndSub = new ClassManyManyEndSub();
        classManyManyEndSub.setFakeAttr("myFakeAttr");


        return classManyManyEndSub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_End_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_End_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyEndSub getClassManyManyEndSubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyEndSub classManyManyEndSub = new ClassManyManyEndSub();
        classManyManyEndSub.setFakeAttr("secondFakeAttr");


        return classManyManyEndSub;
    }
   /**
     * Creates an example of Class_Many_Many_BI_END_Sub.
     * @return Returns a new instance of class Class_Many_Many_BI_END_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBIENDSub getClassManyManyBIENDSubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIENDSub classManyManyBIENDSub = new ClassManyManyBIENDSub();
        classManyManyBIENDSub.setFakeAttr("myFakeAttr");


        return classManyManyBIENDSub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_BI_END_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_BI_END_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBIENDSub getClassManyManyBIENDSubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyBIENDSub classManyManyBIENDSub = new ClassManyManyBIENDSub();
        classManyManyBIENDSub.setFakeAttr("secondFakeAttr");


        return classManyManyBIENDSub;
    }
   /**
     * Creates an example of Class_01_01_Sub.
     * @return Returns a new instance of class Class_01_01_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101Sub getClass0101SubExample() throws DaoException {
        // fill attributes with example values
        Class0101Sub class0101Sub = new Class0101Sub();
        class0101Sub.setFakeAttr("myFakeAttr");


        return class0101Sub;
    }
    
    /**
     * Creates a second example of Class_01_01_Sub with other values.
     * @return Returns a new instance of class Class_01_01_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101Sub getClass0101SubExample2() throws DaoException {
        // fill attributes with example values
        Class0101Sub class0101Sub = new Class0101Sub();
        class0101Sub.setFakeAttr("secondFakeAttr");


        return class0101Sub;
    }
   /**
     * Creates an example of Class_01_01_BI_Sub.
     * @return Returns a new instance of class Class_01_01_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BISub getClass0101BISubExample() throws DaoException {
        // fill attributes with example values
        Class0101BISub class0101BISub = new Class0101BISub();
        class0101BISub.setFakeAttr("myFakeAttr");


        return class0101BISub;
    }
    
    /**
     * Creates a second example of Class_01_01_BI_Sub with other values.
     * @return Returns a new instance of class Class_01_01_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class0101BISub getClass0101BISubExample2() throws DaoException {
        // fill attributes with example values
        Class0101BISub class0101BISub = new Class0101BISub();
        class0101BISub.setFakeAttr("secondFakeAttr");


        return class0101BISub;
    }
   /**
     * Creates an example of Class_1_01_Sub.
     * @return Returns a new instance of class Class_1_01_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101Sub getClass101SubExample() throws DaoException {
        // fill attributes with example values
        Class101Sub class101Sub = new Class101Sub();
        class101Sub.setFakeAttr("myFakeAttr");


        return class101Sub;
    }
    
    /**
     * Creates a second example of Class_1_01_Sub with other values.
     * @return Returns a new instance of class Class_1_01_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101Sub getClass101SubExample2() throws DaoException {
        // fill attributes with example values
        Class101Sub class101Sub = new Class101Sub();
        class101Sub.setFakeAttr("secondFakeAttr");


        return class101Sub;
    }
   /**
     * Creates an example of Class_1_01_BI_Sub.
     * @return Returns a new instance of class Class_1_01_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BISub getClass101BISubExample() throws DaoException {
        // fill attributes with example values
        Class101BISub class101BISub = new Class101BISub();


        return class101BISub;
    }
    
    /**
     * Creates a second example of Class_1_01_BI_Sub with other values.
     * @return Returns a new instance of class Class_1_01_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class101BISub getClass101BISubExample2() throws DaoException {
        // fill attributes with example values
        Class101BISub class101BISub = new Class101BISub();


        return class101BISub;
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
        inheritanceassociationsDao.createClass011END(targetExample);

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
        inheritanceassociationsDao.createClass011END(targetExample);

        return class011Sub;
    }
   /**
     * Creates an example of Class_01_1_BI_Sub.
     * @return Returns a new instance of class Class_01_1_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BISub getClass011BISubExample() throws DaoException {
        // fill attributes with example values
        Class011BISub class011BISub = new Class011BISub();
        class011BISub.setFakeAttr("myFakeAttr");

        Class011BIEND targetExample = new Class011BIEND();
        class011BISub.setTarget(targetExample);   
        targetExample.setSource(class011BISub); 
        inheritanceassociationsDao.createClass011BIEND(targetExample);

        return class011BISub;
    }
    
    /**
     * Creates a second example of Class_01_1_BI_Sub with other values.
     * @return Returns a new instance of class Class_01_1_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class011BISub getClass011BISubExample2() throws DaoException {
        // fill attributes with example values
        Class011BISub class011BISub = new Class011BISub();
        class011BISub.setFakeAttr("secondFakeAttr");

        Class011BIEND targetExample = new Class011BIEND();
        class011BISub.setTarget(targetExample);   
        targetExample.setSource(class011BISub); 
        inheritanceassociationsDao.createClass011BIEND(targetExample);

        return class011BISub;
    }
   /**
     * Creates an example of Class_1_1_Sub.
     * @return Returns a new instance of class Class_1_1_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11Sub getClass11SubExample() throws DaoException {
        // fill attributes with example values
        Class11Sub class11Sub = new Class11Sub();
        class11Sub.setFakeAttr("myFakeAttr");

        Class11END targetExample = new Class11END();
        class11Sub.setTarget(targetExample);   
        inheritanceassociationsDao.createClass11END(targetExample);

        return class11Sub;
    }
    
    /**
     * Creates a second example of Class_1_1_Sub with other values.
     * @return Returns a new instance of class Class_1_1_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11Sub getClass11SubExample2() throws DaoException {
        // fill attributes with example values
        Class11Sub class11Sub = new Class11Sub();
        class11Sub.setFakeAttr("secondFakeAttr");

        Class11END targetExample = new Class11END();
        class11Sub.setTarget(targetExample);   
        inheritanceassociationsDao.createClass11END(targetExample);

        return class11Sub;
    }
   /**
     * Creates an example of Class_1_1_BI_Sub.
     * @return Returns a new instance of class Class_1_1_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BISub getClass11BISubExample() throws DaoException {
        // fill attributes with example values
        Class11BISub class11BISub = new Class11BISub();
        class11BISub.setFakeAttr("myFakeAttr");

        Class11BIEND targetExample = new Class11BIEND();
        class11BISub.setTarget(targetExample);   
        targetExample.setSource(class11BISub); 
        inheritanceassociationsDao.createClass11BIEND(targetExample);

        return class11BISub;
    }
    
    /**
     * Creates a second example of Class_1_1_BI_Sub with other values.
     * @return Returns a new instance of class Class_1_1_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class11BISub getClass11BISubExample2() throws DaoException {
        // fill attributes with example values
        Class11BISub class11BISub = new Class11BISub();
        class11BISub.setFakeAttr("secondFakeAttr");

        Class11BIEND targetExample = new Class11BIEND();
        class11BISub.setTarget(targetExample);   
        targetExample.setSource(class11BISub); 
        inheritanceassociationsDao.createClass11BIEND(targetExample);

        return class11BISub;
    }
   /**
     * Creates an example of Class_01_Many_Sub.
     * @return Returns a new instance of class Class_01_Many_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManySub getClass01ManySubExample() throws DaoException {
        // fill attributes with example values
        Class01ManySub class01ManySub = new Class01ManySub();
        class01ManySub.setFakeAttr("myFakeAttr");


        return class01ManySub;
    }
    
    /**
     * Creates a second example of Class_01_Many_Sub with other values.
     * @return Returns a new instance of class Class_01_Many_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManySub getClass01ManySubExample2() throws DaoException {
        // fill attributes with example values
        Class01ManySub class01ManySub = new Class01ManySub();
        class01ManySub.setFakeAttr("secondFakeAttr");


        return class01ManySub;
    }
   /**
     * Creates an example of Class_01_Many_BI_Sub.
     * @return Returns a new instance of class Class_01_Many_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBISub getClass01ManyBISubExample() throws DaoException {
        // fill attributes with example values
        Class01ManyBISub class01ManyBISub = new Class01ManyBISub();
        class01ManyBISub.setFakeAttr("myFakeAttr");


        return class01ManyBISub;
    }
    
    /**
     * Creates a second example of Class_01_Many_BI_Sub with other values.
     * @return Returns a new instance of class Class_01_Many_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Class01ManyBISub getClass01ManyBISubExample2() throws DaoException {
        // fill attributes with example values
        Class01ManyBISub class01ManyBISub = new Class01ManyBISub();
        class01ManyBISub.setFakeAttr("secondFakeAttr");


        return class01ManyBISub;
    }
   /**
     * Creates an example of Class_Many_01_Sub.
     * @return Returns a new instance of class Class_Many_01_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01Sub getClassMany01SubExample() throws DaoException {
        // fill attributes with example values
        ClassMany01Sub classMany01Sub = new ClassMany01Sub();
        classMany01Sub.setFakeAttr("myFakeAttr");


        return classMany01Sub;
    }
    
    /**
     * Creates a second example of Class_Many_01_Sub with other values.
     * @return Returns a new instance of class Class_Many_01_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01Sub getClassMany01SubExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01Sub classMany01Sub = new ClassMany01Sub();
        classMany01Sub.setFakeAttr("secondFakeAttr");


        return classMany01Sub;
    }
   /**
     * Creates an example of Class_Many_01_BI_Sub.
     * @return Returns a new instance of class Class_Many_01_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BISub getClassMany01BISubExample() throws DaoException {
        // fill attributes with example values
        ClassMany01BISub classMany01BISub = new ClassMany01BISub();
        classMany01BISub.setFakeAttr("myFakeAttr");


        return classMany01BISub;
    }
    
    /**
     * Creates a second example of Class_Many_01_BI_Sub with other values.
     * @return Returns a new instance of class Class_Many_01_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassMany01BISub getClassMany01BISubExample2() throws DaoException {
        // fill attributes with example values
        ClassMany01BISub classMany01BISub = new ClassMany01BISub();
        classMany01BISub.setFakeAttr("secondFakeAttr");


        return classMany01BISub;
    }
   /**
     * Creates an example of Class_Many_Many_Sub.
     * @return Returns a new instance of class Class_Many_Many_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManySub getClassManyManySubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManySub classManyManySub = new ClassManyManySub();
        classManyManySub.setFakeAttr("myFakeAttr");


        return classManyManySub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManySub getClassManyManySubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManySub classManyManySub = new ClassManyManySub();
        classManyManySub.setFakeAttr("secondFakeAttr");


        return classManyManySub;
    }
   /**
     * Creates an example of Class_Many_Many_BI_Sub.
     * @return Returns a new instance of class Class_Many_Many_BI_Sub, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBISub getClassManyManyBISubExample() throws DaoException {
        // fill attributes with example values
        ClassManyManyBISub classManyManyBISub = new ClassManyManyBISub();
        classManyManyBISub.setFakeAttr("myFakeAttr");


        return classManyManyBISub;
    }
    
    /**
     * Creates a second example of Class_Many_Many_BI_Sub with other values.
     * @return Returns a new instance of class Class_Many_Many_BI_Sub with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassManyManyBISub getClassManyManyBISubExample2() throws DaoException {
        // fill attributes with example values
        ClassManyManyBISub classManyManyBISub = new ClassManyManyBISub();
        classManyManyBISub.setFakeAttr("secondFakeAttr");


        return classManyManyBISub;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
