package org.obeonetwork.demo.weblogng.business.informations.test;

// Start of user code for import


import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.obeonetwork.demo.fwk.dao.exception.DaoException;


import junit.framework.Assert;

import org.obeonetwork.demo.weblogng.business.informations.ICategoryDao;
import org.obeonetwork.demo.weblogng.business.informations.Category;

// End of user code

/**
 * Test class for Category.
 */
public class CategoryTest extends AbstractTransactionalSpringContextTests {
	protected final String[] getConfigLocations(){
    return new String[]{"/conf/spring/tests/applicationContext.xml"};
}

private ICategoryDao categoryDao = (ICategoryDao)getApplicationContext().getBean("CategoryDAO");

	
	
	
	/**
 * Tests the creation of the entity Category.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Search the entity and verify it exists</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testCreateCategory() throws DaoException {
    // fill attributes with example values
    Category category = getCategoryExample();
    
    // Execute the tested code
    categoryDao.createCategory(category);

    // Verify result
    boolean found = false;
    for (Category currentCategory : categoryDao.findAllCategorys()) {
        if (currentCategory.equals(category)) {
            found = true;
        }
    }
    Assert.assertTrue("Category not created", found);
}

/**
 * Test the modification of an entity Category.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Modify the entity</li>
 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testUpdateCategory() throws DaoException {
    // Initialized the test
    Category category = getCategoryExample();
    categoryDao.createCategory(category);

    // Execute the tested code
    category.setName("secondName");
    category.setDescription("secondDescription");
    categoryDao.updateCategory(category);

    // Verify result
    boolean found = false;
    for (Category currentCategory : categoryDao.findAllCategorys()) {
        if (currentCategory.equals(category)) {
            found = true;
            Assert.assertEquals("Value name not modified",
                    "secondName",
                    category.getName());
            Assert.assertEquals("Value description not modified",
                    "secondDescription",
                    category.getDescription());
        }
    }
    Assert.assertTrue("Category not found", found);
}

/**
 * Test the suppression of an entity Category.<br/>
 * <ul><li>Step 1 : Create an entity</li>
 * <li>Step 2 : Delete the entity</li>
 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
 * </ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testDeleteCategory() throws DaoException {
    // Initialized the test
    Category category = getCategoryExample();
    categoryDao.createCategory(category);
    
    // Execute the tested code
    categoryDao.deleteCategory(category);
    
    // Verify result
    boolean found = false;
    for (Category currentCategory : categoryDao.findAllCategorys()) {
        if (currentCategory.getId().equals(category.getId())) {
            found = true;                
        }
    }
    Assert.assertFalse("Category not deleted", found);
}

/**
 * Test the search of all entities Category.<br/>
 * <ul><li>Step 1 : Create many entities</li>
 * <li>Step 2 : Search all entities and verify the entities created are
 * found</li></ul>
 * @throws DaoException if an unexpected DAO exception occurs.
 */
public final void testFindAllCategorys() throws DaoException {
    // Verify number of element before testing
    int before = categoryDao.findAllCategorys().size();
    Assert.assertTrue("FindAll must return at least 0", before >= 0);
    
    // Add two elements
    Category category1 = getCategoryExample();
    categoryDao.createCategory(category1);
            
    Category category2 = getCategoryExample();
    categoryDao.createCategory(category2);

    // Verify result
    int after = categoryDao.findAllCategorys().size();
    Assert.assertEquals(
            "FindAll don't find the good number of elements", 
            2,
            after - before);
}

	
/**
 * Creates an example of Category.
 * @return Returns a new instance of class Category, with fields filled
 * with example values.
 * @throws DaoException if an unexpected DAO exception occurs.
 */
protected Category getCategoryExample() throws DaoException {
    // fill attributes with example values
    Category category = new Category();
    category.setName("myName");
    category.setDescription("myDescription");
    
    
    return category;
}

/**
 * Creates a second example of Category with other values.
 * @return Returns a new instance of class Category with fields filled
 * with other test values.
 * @throws DaoException if an unexpected DAO exception occurs.
 */
protected Category getCategoryExample2() throws DaoException {
    // fill attributes with example values
    Category category = new Category();
	category.setName("secondName");
	category.setDescription("secondDescription");
	
	
    return category;
}
    
    // Start of user code of specific tests
    // End of user code

}
