package org.obeonetwork.sample.inheritence.tableperhierarchy.test;

// Start of user code for import 

import org.springframework.test.AbstractTransactionalSpringContextTests;
import junit.framework.Assert;


import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao;
import org.obeonetwork.sample.inheritence.tableperhierarchy.Root;
import org.obeonetwork.sample.inheritence.tableperhierarchy.C1;
import org.obeonetwork.sample.inheritence.tableperhierarchy.C2;
// End of user code for import

/**
 * Test class for table_per_hierarchy.
 */
public class TableperhierarchyTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private ITableperhierarchyDao tableperhierarchyDao = (ITableperhierarchyDao)getApplicationContext().getBean("TableperhierarchyDAO");



    /**
     * Tests the creation of the entity Root.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateRoot() throws DaoException {
        // fill attributes with example values
        Root root = getRootExample();
        
        // Execute the tested code
        tableperhierarchyDao.createRoot(root);

        // Verify result
        boolean found = false;
        for (Root currentRoot : tableperhierarchyDao.findAllRoots()) {
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
        tableperhierarchyDao.createRoot(root);

        // Execute the tested code
        root.setName("secondName");
        tableperhierarchyDao.updateRoot(root);

        // Verify result
        boolean found = false;
        for (Root currentRoot : tableperhierarchyDao.findAllRoots()) {
            if (currentRoot.equals(root)) {
                found = true;
                Assert.assertEquals("Value name not modified",
                        "secondName",
                        root.getName());
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
        tableperhierarchyDao.createRoot(root);
        
        // Execute the tested code
        tableperhierarchyDao.deleteRoot(root);
        
        // Verify result
        boolean found = false;
        for (Root currentRoot : tableperhierarchyDao.findAllRoots()) {
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
        int before = tableperhierarchyDao.findAllRoots().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Root root1 = getRootExample();
        tableperhierarchyDao.createRoot(root1);
                
        Root root2 = getRootExample();
        tableperhierarchyDao.createRoot(root2);

        // Verify result
        int after = tableperhierarchyDao.findAllRoots().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity C1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateC1() throws DaoException {
        // fill attributes with example values
        C1 c1 = getC1Example();
        
        // Execute the tested code
        tableperhierarchyDao.createC1(c1);

        // Verify result
        boolean found = false;
        for (C1 currentC1 : tableperhierarchyDao.findAllC1s()) {
            if (currentC1.equals(c1)) {
                found = true;
            }
        }
        Assert.assertTrue("C1 not created", found);
    }

    /**
     * Test the modification of an entity C1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateC1() throws DaoException {
        // Initialized the test
        C1 c1 = getC1Example();
        tableperhierarchyDao.createC1(c1);

        // Execute the tested code
        c1.setA1("secondA1");
        tableperhierarchyDao.updateC1(c1);

        // Verify result
        boolean found = false;
        for (C1 currentC1 : tableperhierarchyDao.findAllC1s()) {
            if (currentC1.equals(c1)) {
                found = true;
                Assert.assertEquals("Value a1 not modified",
                        "secondA1",
                        c1.getA1());
            }
        }
        Assert.assertTrue("C1 not found", found);
    }

    /**
     * Test the suppression of an entity C1.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteC1() throws DaoException {
        // Initialized the test
        C1 c1 = getC1Example();
        tableperhierarchyDao.createC1(c1);
        
        // Execute the tested code
        tableperhierarchyDao.deleteC1(c1);
        
        // Verify result
        boolean found = false;
        for (C1 currentC1 : tableperhierarchyDao.findAllC1s()) {
            if (currentC1.getId().equals(c1.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("C1 not deleted", found);
    }

    /**
     * Test the search of all entities C1.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllC1s() throws DaoException {
        // Verify number of element before testing
        int before = tableperhierarchyDao.findAllC1s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        C1 c11 = getC1Example();
        tableperhierarchyDao.createC1(c11);
                
        C1 c12 = getC1Example();
        tableperhierarchyDao.createC1(c12);

        // Verify result
        int after = tableperhierarchyDao.findAllC1s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }    /**
     * Tests the creation of the entity C2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateC2() throws DaoException {
        // fill attributes with example values
        C2 c2 = getC2Example();
        
        // Execute the tested code
        tableperhierarchyDao.createC2(c2);

        // Verify result
        boolean found = false;
        for (C2 currentC2 : tableperhierarchyDao.findAllC2s()) {
            if (currentC2.equals(c2)) {
                found = true;
            }
        }
        Assert.assertTrue("C2 not created", found);
    }

    /**
     * Test the modification of an entity C2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateC2() throws DaoException {
        // Initialized the test
        C2 c2 = getC2Example();
        tableperhierarchyDao.createC2(c2);

        // Execute the tested code
        c2.setA2("secondA2");
        tableperhierarchyDao.updateC2(c2);

        // Verify result
        boolean found = false;
        for (C2 currentC2 : tableperhierarchyDao.findAllC2s()) {
            if (currentC2.equals(c2)) {
                found = true;
                Assert.assertEquals("Value a2 not modified",
                        "secondA2",
                        c2.getA2());
            }
        }
        Assert.assertTrue("C2 not found", found);
    }

    /**
     * Test the suppression of an entity C2.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteC2() throws DaoException {
        // Initialized the test
        C2 c2 = getC2Example();
        tableperhierarchyDao.createC2(c2);
        
        // Execute the tested code
        tableperhierarchyDao.deleteC2(c2);
        
        // Verify result
        boolean found = false;
        for (C2 currentC2 : tableperhierarchyDao.findAllC2s()) {
            if (currentC2.getId().equals(c2.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("C2 not deleted", found);
    }

    /**
     * Test the search of all entities C2.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllC2s() throws DaoException {
        // Verify number of element before testing
        int before = tableperhierarchyDao.findAllC2s().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        C2 c21 = getC2Example();
        tableperhierarchyDao.createC2(c21);
                
        C2 c22 = getC2Example();
        tableperhierarchyDao.createC2(c22);

        // Verify result
        int after = tableperhierarchyDao.findAllC2s().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
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
        root.setName("myName");


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
        root.setName("secondName");


        return root;
    }
   /**
     * Creates an example of C1.
     * @return Returns a new instance of class C1, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected C1 getC1Example() throws DaoException {
        // fill attributes with example values
        C1 c1 = new C1();
        c1.setA1("myA1");
        c1.setName("myName");


        return c1;
    }
    
    /**
     * Creates a second example of C1 with other values.
     * @return Returns a new instance of class C1 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected C1 getC1Example2() throws DaoException {
        // fill attributes with example values
        C1 c1 = new C1();
        c1.setA1("secondA1");
        c1.setName("secondName");


        return c1;
    }
   /**
     * Creates an example of C2.
     * @return Returns a new instance of class C2, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected C2 getC2Example() throws DaoException {
        // fill attributes with example values
        C2 c2 = new C2();
        c2.setA2("myA2");
        c2.setName("myName");


        return c2;
    }
    
    /**
     * Creates a second example of C2 with other values.
     * @return Returns a new instance of class C2 with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected C2 getC2Example2() throws DaoException {
        // fill attributes with example values
        C2 c2 = new C2();
        c2.setA2("secondA2");
        c2.setName("secondName");


        return c2;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
