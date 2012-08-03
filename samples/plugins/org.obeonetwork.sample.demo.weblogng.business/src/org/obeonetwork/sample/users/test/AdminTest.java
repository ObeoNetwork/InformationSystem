package org.obeonetwork.sample.users.test;

// Start of user code for import 


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.sample.users.IAdminDao;
import org.obeonetwork.sample.users.Admin;

// End of user code for import

/**
 * Test class for Admin.
 */
public class AdminTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private IAdminDao adminDao = (IAdminDao)getApplicationContext().getBean("AdminDAO");



    /**
     * Tests the creation of the entity Admin.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateAdmin() throws DaoException {
        // fill attributes with example values
        Admin admin = getAdminExample();
        
        // Execute the tested code
        adminDao.createAdmin(admin);

        // Verify result
        boolean found = false;
        for (Admin currentAdmin : adminDao.findAllAdmins()) {
            if (currentAdmin.equals(admin)) {
                found = true;
            }
        }
        Assert.assertTrue("Admin not created", found);
    }

    /**
     * Test the modification of an entity Admin.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateAdmin() throws DaoException {
        // Initialized the test
        Admin admin = getAdminExample();
        adminDao.createAdmin(admin);

        // Execute the tested code
        adminDao.updateAdmin(admin);

        // Verify result
        boolean found = false;
        for (Admin currentAdmin : adminDao.findAllAdmins()) {
            if (currentAdmin.equals(admin)) {
                found = true;
            }
        }
        Assert.assertTrue("Admin not found", found);
    }

    /**
     * Test the suppression of an entity Admin.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteAdmin() throws DaoException {
        // Initialized the test
        Admin admin = getAdminExample();
        adminDao.createAdmin(admin);
        
        // Execute the tested code
        adminDao.deleteAdmin(admin);
        
        // Verify result
        boolean found = false;
        for (Admin currentAdmin : adminDao.findAllAdmins()) {
            if (currentAdmin.getId().equals(admin.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Admin not deleted", found);
    }

    /**
     * Test the search of all entities Admin.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllAdmins() throws DaoException {
        // Verify number of element before testing
        int before = adminDao.findAllAdmins().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Admin admin1 = getAdminExample();
        adminDao.createAdmin(admin1);
                
        Admin admin2 = getAdminExample();
        adminDao.createAdmin(admin2);

        // Verify result
        int after = adminDao.findAllAdmins().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Admin.
     * @return Returns a new instance of class Admin, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Admin getAdminExample() throws DaoException {
        // fill attributes with example values
        Admin admin = new Admin();
        admin.setEmail("myEmail");
        admin.setFirstName("myFirstName");
        admin.setLastName("myLastName");
        admin.setLogin("myLogin");
        admin.setPassword("myPassword");
        admin.setTelephone("myTelephone");


        return admin;
    }
    
    /**
     * Creates a second example of Admin with other values.
     * @return Returns a new instance of class Admin with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Admin getAdminExample2() throws DaoException {
        // fill attributes with example values
        Admin admin = new Admin();
        admin.setEmail("secondEmail");
        admin.setFirstName("secondFirstName");
        admin.setLastName("secondLastName");
        admin.setLogin("secondLogin");
        admin.setPassword("secondPassword");
        admin.setTelephone("secondTelephone");


        return admin;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
