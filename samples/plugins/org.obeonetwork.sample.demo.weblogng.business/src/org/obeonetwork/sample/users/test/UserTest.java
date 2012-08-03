package org.obeonetwork.sample.users.test;

// Start of user code for import 


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.sample.users.IUserDao;
import org.obeonetwork.sample.users.User;

// End of user code for import

/**
 * Test class for User.
 */
public class UserTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private IUserDao userDao = (IUserDao)getApplicationContext().getBean("UserDAO");



    /**
     * Tests the creation of the entity User.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateUser() throws DaoException {
        // fill attributes with example values
        User user = getUserExample();
        
        // Execute the tested code
        userDao.createUser(user);

        // Verify result
        boolean found = false;
        for (User currentUser : userDao.findAllUsers()) {
            if (currentUser.equals(user)) {
                found = true;
            }
        }
        Assert.assertTrue("User not created", found);
    }

    /**
     * Test the modification of an entity User.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateUser() throws DaoException {
        // Initialized the test
        User user = getUserExample();
        userDao.createUser(user);

        // Execute the tested code
        user.setEmail("secondEmail");
        user.setFirstName("secondFirstName");
        user.setLastName("secondLastName");
        user.setLogin("secondLogin");
        user.setPassword("secondPassword");
        user.setTelephone("secondTelephone");
        userDao.updateUser(user);

        // Verify result
        boolean found = false;
        for (User currentUser : userDao.findAllUsers()) {
            if (currentUser.equals(user)) {
                found = true;
                Assert.assertEquals("Value email not modified",
                        "secondEmail",
                        user.getEmail());
                Assert.assertEquals("Value firstName not modified",
                        "secondFirstName",
                        user.getFirstName());
                Assert.assertEquals("Value lastName not modified",
                        "secondLastName",
                        user.getLastName());
                Assert.assertEquals("Value login not modified",
                        "secondLogin",
                        user.getLogin());
                Assert.assertEquals("Value password not modified",
                        "secondPassword",
                        user.getPassword());
                Assert.assertEquals("Value telephone not modified",
                        "secondTelephone",
                        user.getTelephone());
            }
        }
        Assert.assertTrue("User not found", found);
    }

    /**
     * Test the suppression of an entity User.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteUser() throws DaoException {
        // Initialized the test
        User user = getUserExample();
        userDao.createUser(user);
        
        // Execute the tested code
        userDao.deleteUser(user);
        
        // Verify result
        boolean found = false;
        for (User currentUser : userDao.findAllUsers()) {
            if (currentUser.getId().equals(user.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("User not deleted", found);
    }

    /**
     * Test the search of all entities User.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllUsers() throws DaoException {
        // Verify number of element before testing
        int before = userDao.findAllUsers().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        User user1 = getUserExample();
        userDao.createUser(user1);
                
        User user2 = getUserExample();
        userDao.createUser(user2);

        // Verify result
        int after = userDao.findAllUsers().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of User.
     * @return Returns a new instance of class User, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected User getUserExample() throws DaoException {
        // fill attributes with example values
        User user = new User();
        user.setEmail("myEmail");
        user.setFirstName("myFirstName");
        user.setLastName("myLastName");
        user.setLogin("myLogin");
        user.setPassword("myPassword");
        user.setTelephone("myTelephone");


        return user;
    }
    
    /**
     * Creates a second example of User with other values.
     * @return Returns a new instance of class User with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected User getUserExample2() throws DaoException {
        // fill attributes with example values
        User user = new User();
        user.setEmail("secondEmail");
        user.setFirstName("secondFirstName");
        user.setLastName("secondLastName");
        user.setLogin("secondLogin");
        user.setPassword("secondPassword");
        user.setTelephone("secondTelephone");


        return user;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
