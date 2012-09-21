package org.obeonetwork.demo.weblogng.business.informations.test;

// Start of user code for import


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.demo.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.demo.weblogng.business.informations.ITagDao;
import org.obeonetwork.demo.weblogng.business.informations.Tag;

// End of user code

/**
 * Test class for Tag.
 */
public class TagTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
    return new String[]{"/conf/spring/tests/applicationContext.xml"};
}

private ITagDao tagDao = (ITagDao)getApplicationContext().getBean("TagDAO");

	
	
	
	/**
 * Tests the creation of the entity Tag.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Search the entity and verify it exists</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testCreateTag() throws DaoException {
    // fill attributes with example values
    Tag tag = getTagExample();
    
    // Execute the tested code
    tagDao.createTag(tag);

    // Verify result
    boolean found = false;
    for (Tag currentTag : tagDao.findAllTags()) {
        if (currentTag.equals(tag)) {
            found = true;
        }
    }
    Assert.assertTrue("Tag not created", found);
}

/**
 * Test the modification of an entity Tag.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Modify the entity</li>
 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testUpdateTag() throws DaoException {
    // Initialized the test
    Tag tag = getTagExample();
    tagDao.createTag(tag);

    // Execute the tested code
    tag.setName("secondName");
    tagDao.updateTag(tag);

    // Verify result
    boolean found = false;
    for (Tag currentTag : tagDao.findAllTags()) {
        if (currentTag.equals(tag)) {
            found = true;
            Assert.assertEquals("Value name not modified",
                    "secondName",
                    tag.getName());
        }
    }
    Assert.assertTrue("Tag not found", found);
}

/**
 * Test the suppression of an entity Tag.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Delete the entity</li>
 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
 * </ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testDeleteTag() throws DaoException {
    // Initialized the test
    Tag tag = getTagExample();
    tagDao.createTag(tag);
    
    // Execute the tested code
    tagDao.deleteTag(tag);
    
    // Verify result
    boolean found = false;
    for (Tag currentTag : tagDao.findAllTags()) {
        if (currentTag.getId().equals(tag.getId())) {
            found = true;                
        }
    }
    Assert.assertFalse("Tag not deleted", found);
}

/**
 * Test the search of all entities Tag.<br/>
 * <ul><li>Step 1 : Create many entities</li>
 * <li>Step 2 : Search all entities and verify the entities created are
 * found</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testFindAllTags() throws DaoException {
    // Verify number of element before testing
    int before = tagDao.findAllTags().size();
    Assert.assertTrue("FindAll must return at least 0", before >= 0);
    
    // Add two elements
    Tag tag1 = getTagExample();
    tagDao.createTag(tag1);
            
    Tag tag2 = getTagExample();
    tagDao.createTag(tag2);

    // Verify result
    int after = tagDao.findAllTags().size();
    Assert.assertEquals(
            "FindAll don't find the good number of elements", 
            2,
            after - before);
}

	
/**
 * Creates an example of Tag.
 * @return Returns a new instance of class Tag, with fields filled
 * with example values.
 * @throws DaoException if an unexpected DAO exception occurs.
 */
protected Tag getTagExample() throws DaoException {
    // fill attributes with example values
    Tag tag = new Tag();
    tag.setName("myName");
    
    
    return tag;
}

/**
 * Creates a second example of Tag with other values.
 * @return Returns a new instance of class Tag with fields filled
 * with other test values.
 * @throws DaoException if an unexpected DAO exception occurs.
 */
protected Tag getTagExample2() throws DaoException {
    // fill attributes with example values
    Tag tag = new Tag();
	tag.setName("secondName");
	
	
    return tag;
}
    
    // Start of user code of specific tests
    // End of user code

}
