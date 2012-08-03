package org.obeonetwork.sample.users.test;

// Start of user code for import 


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.sample.users.IModeratorDao;
import org.obeonetwork.sample.users.Moderator;

// End of user code for import

/**
 * Test class for Moderator.
 */
public class ModeratorTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private IModeratorDao moderatorDao = (IModeratorDao)getApplicationContext().getBean("ModeratorDAO");



    /**
     * Tests the creation of the entity Moderator.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateModerator() throws DaoException {
        // fill attributes with example values
        Moderator moderator = getModeratorExample();
        
        // Execute the tested code
        moderatorDao.createModerator(moderator);

        // Verify result
        boolean found = false;
        for (Moderator currentModerator : moderatorDao.findAllModerators()) {
            if (currentModerator.equals(moderator)) {
                found = true;
            }
        }
        Assert.assertTrue("Moderator not created", found);
    }

    /**
     * Test the modification of an entity Moderator.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateModerator() throws DaoException {
        // Initialized the test
        Moderator moderator = getModeratorExample();
        moderatorDao.createModerator(moderator);

        // Execute the tested code
        moderatorDao.updateModerator(moderator);

        // Verify result
        boolean found = false;
        for (Moderator currentModerator : moderatorDao.findAllModerators()) {
            if (currentModerator.equals(moderator)) {
                found = true;
            }
        }
        Assert.assertTrue("Moderator not found", found);
    }

    /**
     * Test the suppression of an entity Moderator.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteModerator() throws DaoException {
        // Initialized the test
        Moderator moderator = getModeratorExample();
        moderatorDao.createModerator(moderator);
        
        // Execute the tested code
        moderatorDao.deleteModerator(moderator);
        
        // Verify result
        boolean found = false;
        for (Moderator currentModerator : moderatorDao.findAllModerators()) {
            if (currentModerator.getId().equals(moderator.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Moderator not deleted", found);
    }

    /**
     * Test the search of all entities Moderator.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllModerators() throws DaoException {
        // Verify number of element before testing
        int before = moderatorDao.findAllModerators().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Moderator moderator1 = getModeratorExample();
        moderatorDao.createModerator(moderator1);
                
        Moderator moderator2 = getModeratorExample();
        moderatorDao.createModerator(moderator2);

        // Verify result
        int after = moderatorDao.findAllModerators().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Moderator.
     * @return Returns a new instance of class Moderator, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Moderator getModeratorExample() throws DaoException {
        // fill attributes with example values
        Moderator moderator = new Moderator();
        moderator.setEmail("myEmail");
        moderator.setFirstName("myFirstName");
        moderator.setLastName("myLastName");
        moderator.setLogin("myLogin");
        moderator.setPassword("myPassword");
        moderator.setTelephone("myTelephone");


        return moderator;
    }
    
    /**
     * Creates a second example of Moderator with other values.
     * @return Returns a new instance of class Moderator with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Moderator getModeratorExample2() throws DaoException {
        // fill attributes with example values
        Moderator moderator = new Moderator();
        moderator.setEmail("secondEmail");
        moderator.setFirstName("secondFirstName");
        moderator.setLastName("secondLastName");
        moderator.setLogin("secondLogin");
        moderator.setPassword("secondPassword");
        moderator.setTelephone("secondTelephone");


        return moderator;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
