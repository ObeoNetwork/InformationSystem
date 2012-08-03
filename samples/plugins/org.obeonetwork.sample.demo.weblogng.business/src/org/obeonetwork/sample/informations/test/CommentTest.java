package org.obeonetwork.sample.informations.test;

// Start of user code for import 
import java.util.Date;


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.sample.informations.ICommentDao;
import org.obeonetwork.sample.informations.Comment;
import org.obeonetwork.sample.blog.BlogEntry;
import org.obeonetwork.sample.blog.IBlogEntryDao;

// End of user code for import

/**
 * Test class for Comment.
 */
public class CommentTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
	    return new String[]{"/conf/spring/tests/applicationContext.xml"};
	}

	private ICommentDao commentDao = (ICommentDao)getApplicationContext().getBean("CommentDAO");

	private IBlogEntryDao blogEntryDao = (IBlogEntryDao)getApplicationContext().getBean("BlogEntryDAO");



    /**
     * Tests the creation of the entity Comment.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Search the entity and verify it exists</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testCreateComment() throws DaoException {
        // fill attributes with example values
        Comment comment = getCommentExample();
        
        // Execute the tested code
        commentDao.createComment(comment);

        // Verify result
        boolean found = false;
        for (Comment currentComment : commentDao.findAllComments()) {
            if (currentComment.equals(comment)) {
                found = true;
            }
        }
        Assert.assertTrue("Comment not created", found);
    }

    /**
     * Test the modification of an entity Comment.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Modify the entity</li>
     * <li>Step 3 : Search the entity and verify the modified values</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testUpdateComment() throws DaoException {
        // Initialized the test
        Comment comment = getCommentExample();
        commentDao.createComment(comment);

        // Execute the tested code
        comment.setName("secondName");
        comment.setEmail("secondEmail");
        comment.setWebsite("secondWebsite");
        comment.setContent("secondContent");
        comment.setCreationDate(new Date(1));
        commentDao.updateComment(comment);

        // Verify result
        boolean found = false;
        for (Comment currentComment : commentDao.findAllComments()) {
            if (currentComment.equals(comment)) {
                found = true;
                Assert.assertEquals("Value name not modified",
                        "secondName",
                        comment.getName());
                Assert.assertEquals("Value email not modified",
                        "secondEmail",
                        comment.getEmail());
                Assert.assertEquals("Value website not modified",
                        "secondWebsite",
                        comment.getWebsite());
                Assert.assertEquals("Value content not modified",
                        "secondContent",
                        comment.getContent());
                Assert.assertEquals("Value creationDate not modified",
                        new Date(1),
                        comment.getCreationDate());
            }
        }
        Assert.assertTrue("Comment not found", found);
    }

    /**
     * Test the suppression of an entity Comment.<br/>
     * <ul><li>Step 1 : Create an entity</li>
     * <li>Step 2 : Delete the entity</li>
     * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
     * </ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testDeleteComment() throws DaoException {
        // Initialized the test
        Comment comment = getCommentExample();
        commentDao.createComment(comment);
        
        // Execute the tested code
        commentDao.deleteComment(comment);
        
        // Verify result
        boolean found = false;
        for (Comment currentComment : commentDao.findAllComments()) {
            if (currentComment.getId().equals(comment.getId())) {
                found = true;                
            }
        }
        Assert.assertFalse("Comment not deleted", found);
    }

    /**
     * Test the search of all entities Comment.<br/>
     * <ul><li>Step 1 : Create many entities</li>
     * <li>Step 2 : Search all entities and verify the entities created are
     * found</li></ul>
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    public final void testFindAllComments() throws DaoException {
        // Verify number of element before testing
        int before = commentDao.findAllComments().size();
        Assert.assertTrue("FindAll must return at least 0", before >= 0);
        
        // Add two elements
        Comment comment1 = getCommentExample();
        commentDao.createComment(comment1);
                
        Comment comment2 = getCommentExample();
        commentDao.createComment(comment2);

        // Verify result
        int after = commentDao.findAllComments().size();
        Assert.assertEquals(
                "FindAll don't find the good number of elements", 
                2,
                after - before);
    }


   /**
     * Creates an example of Comment.
     * @return Returns a new instance of class Comment, with fields filled
     * with example values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Comment getCommentExample() throws DaoException {
        // fill attributes with example values
        Comment comment = new Comment();
        comment.setName("myName");
        comment.setEmail("myEmail");
        comment.setWebsite("myWebsite");
        comment.setContent("myContent");
        comment.setCreationDate(new Date(0));

        BlogEntry isCommentOfExample = new BlogEntry();
        comment.setIsCommentOf(isCommentOfExample);   
        isCommentOfExample.getComments().add(comment);        
        blogEntryDao.createBlogEntry(isCommentOfExample);

        return comment;
    }
    
    /**
     * Creates a second example of Comment with other values.
     * @return Returns a new instance of class Comment with fields filled
     * with other test values.
     * @throws DaoException if an unexpected DAO exception occurs.
     */
    protected Comment getCommentExample2() throws DaoException {
        // fill attributes with example values
        Comment comment = new Comment();
        comment.setName("secondName");
        comment.setEmail("secondEmail");
        comment.setWebsite("secondWebsite");
        comment.setContent("secondContent");
        comment.setCreationDate(new Date(1));

        BlogEntry isCommentOfExample = new BlogEntry();
        comment.setIsCommentOf(isCommentOfExample);   
        isCommentOfExample.getComments().add(comment);        
        blogEntryDao.createBlogEntry(isCommentOfExample);

        return comment;
    }
    
    // Start of user code of specific tests
    // End of user code of specific tests

}
