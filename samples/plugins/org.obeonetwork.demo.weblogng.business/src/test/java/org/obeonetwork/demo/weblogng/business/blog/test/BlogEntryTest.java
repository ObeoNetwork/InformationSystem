package org.obeonetwork.demo.weblogng.business.blog.test;

// Start of user code for import
import java.util.Date;


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.demo.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.demo.weblogng.business.blog.IBlogEntryDao;
import org.obeonetwork.demo.weblogng.business.blog.BlogEntry;

import org.obeonetwork.demo.weblogng.business.users.IUserDao;
import org.obeonetwork.demo.weblogng.business.users.User;
// End of user code

/**
 * Test class for BlogEntry.
 */
public class BlogEntryTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
    return new String[]{"/conf/spring/tests/applicationContext.xml"};
}

private IBlogEntryDao blogEntryDao = (IBlogEntryDao)getApplicationContext().getBean("BlogEntryDAO");
private IUserDao userDao = (IUserDao)getApplicationContext().getBean("UserDAO");

	
	
	
	/**
 * Tests the creation of the entity BlogEntry.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Search the entity and verify it exists</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testCreateBlogEntry() throws DaoException {
    // fill attributes with example values
    BlogEntry blogEntry = getBlogEntryExample();
    
    // Execute the tested code
    blogEntryDao.createBlogEntry(blogEntry);

    // Verify result
    boolean found = false;
    for (BlogEntry currentBlogEntry : blogEntryDao.findAllBlogEntrys()) {
        if (currentBlogEntry.equals(blogEntry)) {
            found = true;
        }
    }
    Assert.assertTrue("BlogEntry not created", found);
}

/**
 * Test the modification of an entity BlogEntry.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Modify the entity</li>
 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testUpdateBlogEntry() throws DaoException {
    // Initialized the test
    BlogEntry blogEntry = getBlogEntryExample();
    blogEntryDao.createBlogEntry(blogEntry);

    // Execute the tested code
    blogEntry.setTitle("secondTitle");
    blogEntry.setCreationDate(new Date(1));
    blogEntry.setContent("secondContent");
    blogEntryDao.updateBlogEntry(blogEntry);

    // Verify result
    boolean found = false;
    for (BlogEntry currentBlogEntry : blogEntryDao.findAllBlogEntrys()) {
        if (currentBlogEntry.equals(blogEntry)) {
            found = true;
            Assert.assertEquals("Value title not modified",
                    "secondTitle",
                    blogEntry.getTitle());
            Assert.assertEquals("Value creationDate not modified",
                    new Date(1),
                    blogEntry.getCreationDate());
            Assert.assertEquals("Value content not modified",
                    "secondContent",
                    blogEntry.getContent());
        }
    }
    Assert.assertTrue("BlogEntry not found", found);
}

/**
 * Test the suppression of an entity BlogEntry.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Delete the entity</li>
 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
 * </ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testDeleteBlogEntry() throws DaoException {
    // Initialized the test
    BlogEntry blogEntry = getBlogEntryExample();
    blogEntryDao.createBlogEntry(blogEntry);
    
    // Execute the tested code
    blogEntryDao.deleteBlogEntry(blogEntry);
    
    // Verify result
    boolean found = false;
    for (BlogEntry currentBlogEntry : blogEntryDao.findAllBlogEntrys()) {
        if (currentBlogEntry.getId().equals(blogEntry.getId())) {
            found = true;                
        }
    }
    Assert.assertFalse("BlogEntry not deleted", found);
}

/**
 * Test the search of all entities BlogEntry.<br/>
 * <ul><li>Step 1 : Create many entities</li>
 * <li>Step 2 : Search all entities and verify the entities created are
 * found</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testFindAllBlogEntrys() throws DaoException {
    // Verify number of element before testing
    int before = blogEntryDao.findAllBlogEntrys().size();
    Assert.assertTrue("FindAll must return at least 0", before >= 0);
    
    // Add two elements
    BlogEntry blogEntry1 = getBlogEntryExample();
    blogEntryDao.createBlogEntry(blogEntry1);
            
    BlogEntry blogEntry2 = getBlogEntryExample();
    blogEntryDao.createBlogEntry(blogEntry2);

    // Verify result
    int after = blogEntryDao.findAllBlogEntrys().size();
    Assert.assertEquals(
            "FindAll don't find the good number of elements", 
            2,
            after - before);
}

	
/**
 * Creates an example of BlogEntry.
 * @return Returns a new instance of class BlogEntry, with fields filled
 * with example values.
 * @throws DaoException if an unexpected DAO exception occurs.
 */
protected BlogEntry getBlogEntryExample() throws DaoException {
    // fill attributes with example values
    BlogEntry blogEntry = new BlogEntry();
    blogEntry.setTitle("myTitle");
    blogEntry.setCreationDate(new Date(0));
    blogEntry.setContent("myContent");
    
    User authorUserExample = new User();
    blogEntry.setAuthorUser(authorUserExample);   
    authorUserExample.getEntries().add(blogEntry);        
    userDao.createUser(authorUserExample);
    
    return blogEntry;
}

/**
 * Creates a second example of BlogEntry with other values.
 * @return Returns a new instance of class BlogEntry with fields filled
 * with other test values.
 * @throws DaoException if an unexpected DAO exception occurs.
 */
protected BlogEntry getBlogEntryExample2() throws DaoException {
    // fill attributes with example values
    BlogEntry blogEntry = new BlogEntry();
	blogEntry.setTitle("secondTitle");
	blogEntry.setCreationDate(new Date(1));
	blogEntry.setContent("secondContent");
	
	User authorUserExample = new User();
	blogEntry.setAuthorUser(authorUserExample);   
	authorUserExample.getEntries().add(blogEntry);        
	userDao.createUser(authorUserExample);
	
    return blogEntry;
}
    
    // Start of user code of specific tests
    // End of user code

}
