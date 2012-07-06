package org.obeonetwork.sample.inheritance.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.inheritance.IInheritanceDao;
import org.obeonetwork.sample.inheritance.Basic;
import org.obeonetwork.sample.inheritance.BasicWithoutAttr;
import org.obeonetwork.sample.inheritance.Root;
import org.obeonetwork.sample.inheritance.ClassA1;
import org.obeonetwork.sample.inheritance.ClassA2;
import org.obeonetwork.sample.inheritance.ClassA3;
import org.obeonetwork.sample.inheritance.Main;
import org.obeonetwork.sample.inheritance.Sub1;
import org.obeonetwork.sample.inheritance.Sub2;
// End of user code for import

/**
 * Test class for inheritance.
 */
public class InheritanceTest extends TestCase {

	/**
	 * The DAO for class inheritance.
	 */
	private IInheritanceDao inheritanceDao;

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
		inheritanceDao = SampleDaoFactory.getInheritanceDao();
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
     * Tests the creation of the entity Basic.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateBasic() throws DaoException {
        // fill attributes with example values
        Basic basic = getBasicExample();
        
        // Execute the tested code
        inheritanceDao.createBasic(basic);

        // Verify result
        boolean found = false;
        for (Basic currentBasic : inheritanceDao.findAllBasics()) {
            if (currentBasic.equals(basic)) {
                found = true;
            }
        }
        Assert.assertTrue("Basic not created", found);
    }

    /**
     * Test the modification of an entity Basic.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateBasic() throws DaoException {
        // Initialized the test
        Basic basic = getBasicExample();
        inheritanceDao.createBasic(basic);

        // Execute the tested code
        basic.setMyProp1("secondMyProp1");
        basic.setMyProp2(new Float(1495168739.0));
        inheritanceDao.updateBasic(basic);

        // Verify result
        boolean found = false;
        for (Basic currentBasic : inheritanceDao.findAllBasics()) {
            if (currentBasic.equals(basic)) {
                found = true;
                Assert.assertEquals("Value myProp1 not modified",
                        "secondMyProp1",
                        basic.getMyProp1());
                Assert.assertEquals("Value myProp2 not modified",
                        new Float(1495168739.0),
                        basic.getMyProp2());
            }
        }
        Assert.assertTrue("Basic not found", found);
    }

    /**
     * Test the suppression of an entity Basic.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteBasic() throws DaoException {
        // Initialized the test
        Basic basic = getBasicExample();
        inheritanceDao.createBasic(basic);
        
        // Execute the tested code
        inheritanceDao.deleteBasic(basic);
        
        // Verify result
        boolean found = false;
        for (Basic currentBasic : inheritanceDao.findAllBasics()) {
            if (currentBasic.getId().equals(basic.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Basic not deleted", found);
    }

    /**
     * Test the search of all entities Basic.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllBasics() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllBasics().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Basic basic1 = getBasicExample();
        inheritanceDao.createBasic(basic1);
                
        Basic basic2 = getBasicExample();
        inheritanceDao.createBasic(basic2);

        // Verify result
        int after = inheritanceDao.findAllBasics().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateBasicWithoutAttr() throws DaoException {
        // fill attributes with example values
        BasicWithoutAttr basicWithoutAttr = getBasicWithoutAttrExample();
        
        // Execute the tested code
        inheritanceDao.createBasicWithoutAttr(basicWithoutAttr);

        // Verify result
        boolean found = false;
        for (BasicWithoutAttr currentBasicWithoutAttr : inheritanceDao.findAllBasicWithoutAttrs()) {
            if (currentBasicWithoutAttr.equals(basicWithoutAttr)) {
                found = true;
            }
        }
        Assert.assertTrue("BasicWithoutAttr not created", found);
    }

    /**
     * Test the modification of an entity BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateBasicWithoutAttr() throws DaoException {
        // Initialized the test
        BasicWithoutAttr basicWithoutAttr = getBasicWithoutAttrExample();
        inheritanceDao.createBasicWithoutAttr(basicWithoutAttr);

        // Execute the tested code
        inheritanceDao.updateBasicWithoutAttr(basicWithoutAttr);

        // Verify result
        boolean found = false;
        for (BasicWithoutAttr currentBasicWithoutAttr : inheritanceDao.findAllBasicWithoutAttrs()) {
            if (currentBasicWithoutAttr.equals(basicWithoutAttr)) {
                found = true;
            }
        }
        Assert.assertTrue("BasicWithoutAttr not found", found);
    }

    /**
     * Test the suppression of an entity BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteBasicWithoutAttr() throws DaoException {
        // Initialized the test
        BasicWithoutAttr basicWithoutAttr = getBasicWithoutAttrExample();
        inheritanceDao.createBasicWithoutAttr(basicWithoutAttr);
        
        // Execute the tested code
        inheritanceDao.deleteBasicWithoutAttr(basicWithoutAttr);
        
        // Verify result
        boolean found = false;
        for (BasicWithoutAttr currentBasicWithoutAttr : inheritanceDao.findAllBasicWithoutAttrs()) {
            if (currentBasicWithoutAttr.getId().equals(basicWithoutAttr.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("BasicWithoutAttr not deleted", found);
    }

    /**
     * Test the search of all entities BasicWithoutAttr.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllBasicWithoutAttrs() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllBasicWithoutAttrs().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        BasicWithoutAttr basicWithoutAttr1 = getBasicWithoutAttrExample();
        inheritanceDao.createBasicWithoutAttr(basicWithoutAttr1);
                
        BasicWithoutAttr basicWithoutAttr2 = getBasicWithoutAttrExample();
        inheritanceDao.createBasicWithoutAttr(basicWithoutAttr2);

        // Verify result
        int after = inheritanceDao.findAllBasicWithoutAttrs().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateRoot() throws DaoException {
        // fill attributes with example values
        Root root = getRootExample();
        
        // Execute the tested code
        inheritanceDao.createRoot(root);

        // Verify result
        boolean found = false;
        for (Root currentRoot : inheritanceDao.findAllRoots()) {
            if (currentRoot.equals(root)) {
                found = true;
            }
        }
        Assert.assertTrue("Root not created", found);
    }

    /**
     * Test the modification of an entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateRoot() throws DaoException {
        // Initialized the test
        Root root = getRootExample();
        inheritanceDao.createRoot(root);

        // Execute the tested code
        root.setRootProp(new Double(-166963355.0));
        inheritanceDao.updateRoot(root);

        // Verify result
        boolean found = false;
        for (Root currentRoot : inheritanceDao.findAllRoots()) {
            if (currentRoot.equals(root)) {
                found = true;
                Assert.assertEquals("Value rootProp not modified",
                        new Double(-166963355.0),
                        root.getRootProp());
            }
        }
        Assert.assertTrue("Root not found", found);
    }

    /**
     * Test the suppression of an entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteRoot() throws DaoException {
        // Initialized the test
        Root root = getRootExample();
        inheritanceDao.createRoot(root);
        
        // Execute the tested code
        inheritanceDao.deleteRoot(root);
        
        // Verify result
        boolean found = false;
        for (Root currentRoot : inheritanceDao.findAllRoots()) {
            if (currentRoot.getId().equals(root.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Root not deleted", found);
    }

    /**
     * Test the search of all entities Root.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllRoots() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllRoots().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Root root1 = getRootExample();
        inheritanceDao.createRoot(root1);
                
        Root root2 = getRootExample();
        inheritanceDao.createRoot(root2);

        // Verify result
        int after = inheritanceDao.findAllRoots().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity ClassA1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassA1() throws DaoException {
        // fill attributes with example values
        ClassA1 classA1 = getClassA1Example();
        
        // Execute the tested code
        inheritanceDao.createClassA1(classA1);

        // Verify result
        boolean found = false;
        for (ClassA1 currentClassA1 : inheritanceDao.findAllClassA1s()) {
            if (currentClassA1.equals(classA1)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassA1 not created", found);
    }

    /**
     * Test the modification of an entity ClassA1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassA1() throws DaoException {
        // Initialized the test
        ClassA1 classA1 = getClassA1Example();
        inheritanceDao.createClassA1(classA1);

        // Execute the tested code
        classA1.setA1(new Float(3056.0));
        inheritanceDao.updateClassA1(classA1);

        // Verify result
        boolean found = false;
        for (ClassA1 currentClassA1 : inheritanceDao.findAllClassA1s()) {
            if (currentClassA1.equals(classA1)) {
                found = true;
                Assert.assertEquals("Value a1 not modified",
                        new Float(3056.0),
                        classA1.getA1());
            }
        }
        Assert.assertTrue("ClassA1 not found", found);
    }

    /**
     * Test the suppression of an entity ClassA1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassA1() throws DaoException {
        // Initialized the test
        ClassA1 classA1 = getClassA1Example();
        inheritanceDao.createClassA1(classA1);
        
        // Execute the tested code
        inheritanceDao.deleteClassA1(classA1);
        
        // Verify result
        boolean found = false;
        for (ClassA1 currentClassA1 : inheritanceDao.findAllClassA1s()) {
            if (currentClassA1.getId().equals(classA1.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassA1 not deleted", found);
    }

    /**
     * Test the search of all entities ClassA1.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassA1s() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllClassA1s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassA1 classA11 = getClassA1Example();
        inheritanceDao.createClassA1(classA11);
                
        ClassA1 classA12 = getClassA1Example();
        inheritanceDao.createClassA1(classA12);

        // Verify result
        int after = inheritanceDao.findAllClassA1s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity ClassA2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassA2() throws DaoException {
        // fill attributes with example values
        ClassA2 classA2 = getClassA2Example();
        
        // Execute the tested code
        inheritanceDao.createClassA2(classA2);

        // Verify result
        boolean found = false;
        for (ClassA2 currentClassA2 : inheritanceDao.findAllClassA2s()) {
            if (currentClassA2.equals(classA2)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassA2 not created", found);
    }

    /**
     * Test the modification of an entity ClassA2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassA2() throws DaoException {
        // Initialized the test
        ClassA2 classA2 = getClassA2Example();
        inheritanceDao.createClassA2(classA2);

        // Execute the tested code
        classA2.setA2("secondA2");
        inheritanceDao.updateClassA2(classA2);

        // Verify result
        boolean found = false;
        for (ClassA2 currentClassA2 : inheritanceDao.findAllClassA2s()) {
            if (currentClassA2.equals(classA2)) {
                found = true;
                Assert.assertEquals("Value a2 not modified",
                        "secondA2",
                        classA2.getA2());
            }
        }
        Assert.assertTrue("ClassA2 not found", found);
    }

    /**
     * Test the suppression of an entity ClassA2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassA2() throws DaoException {
        // Initialized the test
        ClassA2 classA2 = getClassA2Example();
        inheritanceDao.createClassA2(classA2);
        
        // Execute the tested code
        inheritanceDao.deleteClassA2(classA2);
        
        // Verify result
        boolean found = false;
        for (ClassA2 currentClassA2 : inheritanceDao.findAllClassA2s()) {
            if (currentClassA2.getId().equals(classA2.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassA2 not deleted", found);
    }

    /**
     * Test the search of all entities ClassA2.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassA2s() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllClassA2s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassA2 classA21 = getClassA2Example();
        inheritanceDao.createClassA2(classA21);
                
        ClassA2 classA22 = getClassA2Example();
        inheritanceDao.createClassA2(classA22);

        // Verify result
        int after = inheritanceDao.findAllClassA2s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity ClassA3.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateClassA3() throws DaoException {
        // fill attributes with example values
        ClassA3 classA3 = getClassA3Example();
        
        // Execute the tested code
        inheritanceDao.createClassA3(classA3);

        // Verify result
        boolean found = false;
        for (ClassA3 currentClassA3 : inheritanceDao.findAllClassA3s()) {
            if (currentClassA3.equals(classA3)) {
                found = true;
            }
        }
        Assert.assertTrue("ClassA3 not created", found);
    }

    /**
     * Test the modification of an entity ClassA3.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateClassA3() throws DaoException {
        // Initialized the test
        ClassA3 classA3 = getClassA3Example();
        inheritanceDao.createClassA3(classA3);

        // Execute the tested code
        classA3.setA3("secondA3");
        inheritanceDao.updateClassA3(classA3);

        // Verify result
        boolean found = false;
        for (ClassA3 currentClassA3 : inheritanceDao.findAllClassA3s()) {
            if (currentClassA3.equals(classA3)) {
                found = true;
                Assert.assertEquals("Value a3 not modified",
                        "secondA3",
                        classA3.getA3());
            }
        }
        Assert.assertTrue("ClassA3 not found", found);
    }

    /**
     * Test the suppression of an entity ClassA3.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteClassA3() throws DaoException {
        // Initialized the test
        ClassA3 classA3 = getClassA3Example();
        inheritanceDao.createClassA3(classA3);
        
        // Execute the tested code
        inheritanceDao.deleteClassA3(classA3);
        
        // Verify result
        boolean found = false;
        for (ClassA3 currentClassA3 : inheritanceDao.findAllClassA3s()) {
            if (currentClassA3.getId().equals(classA3.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("ClassA3 not deleted", found);
    }

    /**
     * Test the search of all entities ClassA3.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllClassA3s() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllClassA3s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        ClassA3 classA31 = getClassA3Example();
        inheritanceDao.createClassA3(classA31);
                
        ClassA3 classA32 = getClassA3Example();
        inheritanceDao.createClassA3(classA32);

        // Verify result
        int after = inheritanceDao.findAllClassA3s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Main.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateMain() throws DaoException {
        // fill attributes with example values
        Main main = getMainExample();
        
        // Execute the tested code
        inheritanceDao.createMain(main);

        // Verify result
        boolean found = false;
        for (Main currentMain : inheritanceDao.findAllMains()) {
            if (currentMain.equals(main)) {
                found = true;
            }
        }
        Assert.assertTrue("Main not created", found);
    }

    /**
     * Test the modification of an entity Main.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateMain() throws DaoException {
        // Initialized the test
        Main main = getMainExample();
        inheritanceDao.createMain(main);

        // Execute the tested code
        inheritanceDao.updateMain(main);

        // Verify result
        boolean found = false;
        for (Main currentMain : inheritanceDao.findAllMains()) {
            if (currentMain.equals(main)) {
                found = true;
            }
        }
        Assert.assertTrue("Main not found", found);
    }

    /**
     * Test the suppression of an entity Main.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteMain() throws DaoException {
        // Initialized the test
        Main main = getMainExample();
        inheritanceDao.createMain(main);
        
        // Execute the tested code
        inheritanceDao.deleteMain(main);
        
        // Verify result
        boolean found = false;
        for (Main currentMain : inheritanceDao.findAllMains()) {
            if (currentMain.getId().equals(main.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Main not deleted", found);
    }

    /**
     * Test the search of all entities Main.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllMains() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllMains().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Main main1 = getMainExample();
        inheritanceDao.createMain(main1);
                
        Main main2 = getMainExample();
        inheritanceDao.createMain(main2);

        // Verify result
        int after = inheritanceDao.findAllMains().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Sub1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateSub1() throws DaoException {
        // fill attributes with example values
        Sub1 sub1 = getSub1Example();
        
        // Execute the tested code
        inheritanceDao.createSub1(sub1);

        // Verify result
        boolean found = false;
        for (Sub1 currentSub1 : inheritanceDao.findAllSub1s()) {
            if (currentSub1.equals(sub1)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub1 not created", found);
    }

    /**
     * Test the modification of an entity Sub1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateSub1() throws DaoException {
        // Initialized the test
        Sub1 sub1 = getSub1Example();
        inheritanceDao.createSub1(sub1);

        // Execute the tested code
        inheritanceDao.updateSub1(sub1);

        // Verify result
        boolean found = false;
        for (Sub1 currentSub1 : inheritanceDao.findAllSub1s()) {
            if (currentSub1.equals(sub1)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub1 not found", found);
    }

    /**
     * Test the suppression of an entity Sub1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteSub1() throws DaoException {
        // Initialized the test
        Sub1 sub1 = getSub1Example();
        inheritanceDao.createSub1(sub1);
        
        // Execute the tested code
        inheritanceDao.deleteSub1(sub1);
        
        // Verify result
        boolean found = false;
        for (Sub1 currentSub1 : inheritanceDao.findAllSub1s()) {
            if (currentSub1.getId().equals(sub1.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Sub1 not deleted", found);
    }

    /**
     * Test the search of all entities Sub1.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllSub1s() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllSub1s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Sub1 sub11 = getSub1Example();
        inheritanceDao.createSub1(sub11);
                
        Sub1 sub12 = getSub1Example();
        inheritanceDao.createSub1(sub12);

        // Verify result
        int after = inheritanceDao.findAllSub1s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity Sub2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateSub2() throws DaoException {
        // fill attributes with example values
        Sub2 sub2 = getSub2Example();
        
        // Execute the tested code
        inheritanceDao.createSub2(sub2);

        // Verify result
        boolean found = false;
        for (Sub2 currentSub2 : inheritanceDao.findAllSub2s()) {
            if (currentSub2.equals(sub2)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub2 not created", found);
    }

    /**
     * Test the modification of an entity Sub2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateSub2() throws DaoException {
        // Initialized the test
        Sub2 sub2 = getSub2Example();
        inheritanceDao.createSub2(sub2);

        // Execute the tested code
        inheritanceDao.updateSub2(sub2);

        // Verify result
        boolean found = false;
        for (Sub2 currentSub2 : inheritanceDao.findAllSub2s()) {
            if (currentSub2.equals(sub2)) {
                found = true;
            }
        }
        Assert.assertTrue("Sub2 not found", found);
    }

    /**
     * Test the suppression of an entity Sub2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteSub2() throws DaoException {
        // Initialized the test
        Sub2 sub2 = getSub2Example();
        inheritanceDao.createSub2(sub2);
        
        // Execute the tested code
        inheritanceDao.deleteSub2(sub2);
        
        // Verify result
        boolean found = false;
        for (Sub2 currentSub2 : inheritanceDao.findAllSub2s()) {
            if (currentSub2.getId().equals(sub2.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Sub2 not deleted", found);
    }

    /**
     * Test the search of all entities Sub2.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllSub2s() throws DaoException {
        // Verify number of element before testing
        int before = inheritanceDao.findAllSub2s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Sub2 sub21 = getSub2Example();
        inheritanceDao.createSub2(sub21);
                
        Sub2 sub22 = getSub2Example();
        inheritanceDao.createSub2(sub22);

        // Verify result
        int after = inheritanceDao.findAllSub2s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Basic.
     * @return Returns a new instance of class Basic, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Basic getBasicExample() throws DaoException {
        // fill attributes with example values
        Basic basic = new Basic();
        basic.setMyProp1("myMyProp1");
        basic.setMyProp2(new Float(1495168739.1));
        basic.setRootProp(new Double(-166963355.1));


        return basic;
    }
    
    /**
     * Creates a second example of Basic with other values.
     * @return Returns a new instance of class Basic with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Basic getBasicExample2() throws DaoException {
        // fill attributes with example values
        Basic basic = new Basic();
        basic.setMyProp1("secondMyProp1");
        basic.setMyProp2(new Float(1495168739.0));
        basic.setRootProp(new Double(-166963355.0));


        return basic;
    }
   /**
     * Creates an example of BasicWithoutAttr.
     * @return Returns a new instance of class BasicWithoutAttr, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected BasicWithoutAttr getBasicWithoutAttrExample() throws DaoException {
        // fill attributes with example values
        BasicWithoutAttr basicWithoutAttr = new BasicWithoutAttr();
        basicWithoutAttr.setRootProp(new Double(-166963355.1));


        return basicWithoutAttr;
    }
    
    /**
     * Creates a second example of BasicWithoutAttr with other values.
     * @return Returns a new instance of class BasicWithoutAttr with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected BasicWithoutAttr getBasicWithoutAttrExample2() throws DaoException {
        // fill attributes with example values
        BasicWithoutAttr basicWithoutAttr = new BasicWithoutAttr();
        basicWithoutAttr.setRootProp(new Double(-166963355.0));


        return basicWithoutAttr;
    }
   /**
     * Creates an example of Root.
     * @return Returns a new instance of class Root, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Root getRootExample() throws DaoException {
        // fill attributes with example values
        Root root = new Root();
        root.setRootProp(new Double(-166963355.1));


        return root;
    }
    
    /**
     * Creates a second example of Root with other values.
     * @return Returns a new instance of class Root with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Root getRootExample2() throws DaoException {
        // fill attributes with example values
        Root root = new Root();
        root.setRootProp(new Double(-166963355.0));


        return root;
    }
   /**
     * Creates an example of ClassA1.
     * @return Returns a new instance of class ClassA1, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA1 getClassA1Example() throws DaoException {
        // fill attributes with example values
        ClassA1 classA1 = new ClassA1();
        classA1.setA1(new Float(3056.1));


        return classA1;
    }
    
    /**
     * Creates a second example of ClassA1 with other values.
     * @return Returns a new instance of class ClassA1 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA1 getClassA1Example2() throws DaoException {
        // fill attributes with example values
        ClassA1 classA1 = new ClassA1();
        classA1.setA1(new Float(3056.0));


        return classA1;
    }
   /**
     * Creates an example of ClassA2.
     * @return Returns a new instance of class ClassA2, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA2 getClassA2Example() throws DaoException {
        // fill attributes with example values
        ClassA2 classA2 = new ClassA2();
        classA2.setA2("myA2");
        classA2.setA1(new Float(3056.1));


        return classA2;
    }
    
    /**
     * Creates a second example of ClassA2 with other values.
     * @return Returns a new instance of class ClassA2 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA2 getClassA2Example2() throws DaoException {
        // fill attributes with example values
        ClassA2 classA2 = new ClassA2();
        classA2.setA2("secondA2");
        classA2.setA1(new Float(3056.0));


        return classA2;
    }
   /**
     * Creates an example of ClassA3.
     * @return Returns a new instance of class ClassA3, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA3 getClassA3Example() throws DaoException {
        // fill attributes with example values
        ClassA3 classA3 = new ClassA3();
        classA3.setA3("myA3");
        classA3.setA2("myA2");
        classA3.setA1(new Float(3056.1));


        return classA3;
    }
    
    /**
     * Creates a second example of ClassA3 with other values.
     * @return Returns a new instance of class ClassA3 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected ClassA3 getClassA3Example2() throws DaoException {
        // fill attributes with example values
        ClassA3 classA3 = new ClassA3();
        classA3.setA3("secondA3");
        classA3.setA2("secondA2");
        classA3.setA1(new Float(3056.0));


        return classA3;
    }
   /**
     * Creates an example of Main.
     * @return Returns a new instance of class Main, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Main getMainExample() throws DaoException {
        // fill attributes with example values
        Main main = new Main();


        return main;
    }
    
    /**
     * Creates a second example of Main with other values.
     * @return Returns a new instance of class Main with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Main getMainExample2() throws DaoException {
        // fill attributes with example values
        Main main = new Main();


        return main;
    }
   /**
     * Creates an example of Sub1.
     * @return Returns a new instance of class Sub1, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub1 getSub1Example() throws DaoException {
        // fill attributes with example values
        Sub1 sub1 = new Sub1();


        return sub1;
    }
    
    /**
     * Creates a second example of Sub1 with other values.
     * @return Returns a new instance of class Sub1 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub1 getSub1Example2() throws DaoException {
        // fill attributes with example values
        Sub1 sub1 = new Sub1();


        return sub1;
    }
   /**
     * Creates an example of Sub2.
     * @return Returns a new instance of class Sub2, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub2 getSub2Example() throws DaoException {
        // fill attributes with example values
        Sub2 sub2 = new Sub2();


        return sub2;
    }
    
    /**
     * Creates a second example of Sub2 with other values.
     * @return Returns a new instance of class Sub2 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Sub2 getSub2Example2() throws DaoException {
        // fill attributes with example values
        Sub2 sub2 = new Sub2();


        return sub2;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
