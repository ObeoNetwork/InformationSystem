package org.obeonetwork.sample.badpractives.test;

// Start of user code for import 

import org.hibernate.Transaction;
import junit.framework.TestCase;
import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.SampleDaoFactory;

import junit.framework.Assert;

import org.obeonetwork.sample.badpractives.IBadPractivesDao;
import org.obeonetwork.sample.badpractives.Interface_;
import org.obeonetwork.sample.badpractives.Class_;
import org.obeonetwork.sample.badpractives.BadName;
import org.obeonetwork.sample.badpractives.Anothername;
import org.obeonetwork.sample.badpractives.EntityWithSpecialChars;
import org.obeonetwork.sample.badpractives.Public_;
import org.obeonetwork.sample.badpractives.Private_;
import org.obeonetwork.sample.badpractives.Protected_;
import org.obeonetwork.sample.badpractives.Null_;
import org.obeonetwork.sample.badpractives.MyEntity;
import org.obeonetwork.sample.badpractives.TABLE;
// End of user code

/**
 * Test class for badPractives.
 */
public class BadPractivesTest extends TestCase {
	
	/**
	 * The DAO for class badPractives.
	 */
	private IBadPractivesDao badPractivesDao;
	
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
		badPractivesDao = null; //FIXME
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
	 * Tests the creation of the entity Interface.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateInterface_() throws DaoException {
	    // fill attributes with example values
	    Interface_ interface_ = getInterface_Example();
	    
	    // Execute the tested code
	    badPractivesDao.createInterface_(interface_);
	
	    // Verify result
	    boolean found = false;
	    for (Interface_ currentInterface_ : badPractivesDao.findAllInterface_s()) {
	        if (currentInterface_.equals(interface_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Interface not created", found);
	}
	
	/**
	 * Test the modification of an entity Interface.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateInterface_() throws DaoException {
	    // Initialized the test
	    Interface_ interface_ = getInterface_Example();
	    badPractivesDao.createInterface_(interface_);
	
	    // Execute the tested code
	    badPractivesDao.updateInterface_(interface_);
	
	    // Verify result
	    boolean found = false;
	    for (Interface_ currentInterface_ : badPractivesDao.findAllInterface_s()) {
	        if (currentInterface_.equals(interface_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Interface_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity Interface.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteInterface_() throws DaoException {
	    // Initialized the test
	    Interface_ interface_ = getInterface_Example();
	    badPractivesDao.createInterface_(interface_);
	    
	    // Execute the tested code
	    badPractivesDao.deleteInterface_(interface_);
	    
	    // Verify result
	    boolean found = false;
	    for (Interface_ currentInterface_ : badPractivesDao.findAllInterface_s()) {
	        if (currentInterface_.getId().equals(interface_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Interface_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities Interface.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllInterface_s() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllInterface_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Interface_ interface_1 = getInterface_Example();
	    badPractivesDao.createInterface_(interface_1);
	            
	    Interface_ interface_2 = getInterface_Example();
	    badPractivesDao.createInterface_(interface_2);
	
	    // Verify result
	    int after = badPractivesDao.findAllInterface_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity Class.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateClass_() throws DaoException {
	    // fill attributes with example values
	    Class_ class_ = getClass_Example();
	    
	    // Execute the tested code
	    badPractivesDao.createClass_(class_);
	
	    // Verify result
	    boolean found = false;
	    for (Class_ currentClass_ : badPractivesDao.findAllClass_s()) {
	        if (currentClass_.equals(class_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class not created", found);
	}
	
	/**
	 * Test the modification of an entity Class.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateClass_() throws DaoException {
	    // Initialized the test
	    Class_ class_ = getClass_Example();
	    badPractivesDao.createClass_(class_);
	
	    // Execute the tested code
	    badPractivesDao.updateClass_(class_);
	
	    // Verify result
	    boolean found = false;
	    for (Class_ currentClass_ : badPractivesDao.findAllClass_s()) {
	        if (currentClass_.equals(class_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Class_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity Class.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteClass_() throws DaoException {
	    // Initialized the test
	    Class_ class_ = getClass_Example();
	    badPractivesDao.createClass_(class_);
	    
	    // Execute the tested code
	    badPractivesDao.deleteClass_(class_);
	    
	    // Verify result
	    boolean found = false;
	    for (Class_ currentClass_ : badPractivesDao.findAllClass_s()) {
	        if (currentClass_.getId().equals(class_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Class_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities Class.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllClass_s() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllClass_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Class_ class_1 = getClass_Example();
	    badPractivesDao.createClass_(class_1);
	            
	    Class_ class_2 = getClass_Example();
	    badPractivesDao.createClass_(class_2);
	
	    // Verify result
	    int after = badPractivesDao.findAllClass_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity Bad name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateBadName() throws DaoException {
	    // fill attributes with example values
	    BadName badName = getBadNameExample();
	    
	    // Execute the tested code
	    badPractivesDao.createBadName(badName);
	
	    // Verify result
	    boolean found = false;
	    for (BadName currentBadName : badPractivesDao.findAllBadNames()) {
	        if (currentBadName.equals(badName)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Bad name not created", found);
	}
	
	/**
	 * Test the modification of an entity Bad name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateBadName() throws DaoException {
	    // Initialized the test
	    BadName badName = getBadNameExample();
	    badPractivesDao.createBadName(badName);
	
	    // Execute the tested code
	    badPractivesDao.updateBadName(badName);
	
	    // Verify result
	    boolean found = false;
	    for (BadName currentBadName : badPractivesDao.findAllBadNames()) {
	        if (currentBadName.equals(badName)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("BadName not found", found);
	}
	
	/**
	 * Test the suppression of an entity Bad name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteBadName() throws DaoException {
	    // Initialized the test
	    BadName badName = getBadNameExample();
	    badPractivesDao.createBadName(badName);
	    
	    // Execute the tested code
	    badPractivesDao.deleteBadName(badName);
	    
	    // Verify result
	    boolean found = false;
	    for (BadName currentBadName : badPractivesDao.findAllBadNames()) {
	        if (currentBadName.getId().equals(badName.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("BadName not deleted", found);
	}
	
	/**
	 * Test the search of all entities Bad name.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllBadNames() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllBadNames().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    BadName badName1 = getBadNameExample();
	    badPractivesDao.createBadName(badName1);
	            
	    BadName badName2 = getBadNameExample();
	    badPractivesDao.createBadName(badName2);
	
	    // Verify result
	    int after = badPractivesDao.findAllBadNames().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity Another.name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateAnothername() throws DaoException {
	    // fill attributes with example values
	    Anothername anothername = getAnothernameExample();
	    
	    // Execute the tested code
	    badPractivesDao.createAnothername(anothername);
	
	    // Verify result
	    boolean found = false;
	    for (Anothername currentAnothername : badPractivesDao.findAllAnothernames()) {
	        if (currentAnothername.equals(anothername)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Another.name not created", found);
	}
	
	/**
	 * Test the modification of an entity Another.name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateAnothername() throws DaoException {
	    // Initialized the test
	    Anothername anothername = getAnothernameExample();
	    badPractivesDao.createAnothername(anothername);
	
	    // Execute the tested code
	    badPractivesDao.updateAnothername(anothername);
	
	    // Verify result
	    boolean found = false;
	    for (Anothername currentAnothername : badPractivesDao.findAllAnothernames()) {
	        if (currentAnothername.equals(anothername)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("Anothername not found", found);
	}
	
	/**
	 * Test the suppression of an entity Another.name.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteAnothername() throws DaoException {
	    // Initialized the test
	    Anothername anothername = getAnothernameExample();
	    badPractivesDao.createAnothername(anothername);
	    
	    // Execute the tested code
	    badPractivesDao.deleteAnothername(anothername);
	    
	    // Verify result
	    boolean found = false;
	    for (Anothername currentAnothername : badPractivesDao.findAllAnothernames()) {
	        if (currentAnothername.getId().equals(anothername.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("Anothername not deleted", found);
	}
	
	/**
	 * Test the search of all entities Another.name.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllAnothernames() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllAnothernames().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Anothername anothername1 = getAnothernameExample();
	    badPractivesDao.createAnothername(anothername1);
	            
	    Anothername anothername2 = getAnothernameExample();
	    badPractivesDao.createAnothername(anothername2);
	
	    // Verify result
	    int after = badPractivesDao.findAllAnothernames().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity entityWithSpécialChars.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateentityWithSpecialChars() throws DaoException {
	    // fill attributes with example values
	    EntityWithSpecialChars entityWithSpecialChars = getEntityWithSpecialCharsExample();
	    
	    // Execute the tested code
	    badPractivesDao.createentityWithSpecialChars(entityWithSpecialChars);
	
	    // Verify result
	    boolean found = false;
	    for (EntityWithSpecialChars currententityWithSpecialChars : badPractivesDao.findAllentityWithSpecialCharss()) {
	        if (currententityWithSpecialChars.equals(entityWithSpecialChars)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("entityWithSpécialChars not created", found);
	}
	
	/**
	 * Test the modification of an entity entityWithSpécialChars.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateentityWithSpecialChars() throws DaoException {
	    // Initialized the test
	    EntityWithSpecialChars entityWithSpecialChars = getEntityWithSpecialCharsExample();
	    badPractivesDao.createentityWithSpecialChars(entityWithSpecialChars);
	
	    // Execute the tested code
	    badPractivesDao.updateentityWithSpecialChars(entityWithSpecialChars);
	
	    // Verify result
	    boolean found = false;
	    for (EntityWithSpecialChars currententityWithSpecialChars : badPractivesDao.findAllentityWithSpecialCharss()) {
	        if (currententityWithSpecialChars.equals(entityWithSpecialChars)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("entityWithSpecialChars not found", found);
	}
	
	/**
	 * Test the suppression of an entity entityWithSpécialChars.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteentityWithSpecialChars() throws DaoException {
	    // Initialized the test
	    EntityWithSpecialChars entityWithSpecialChars = getEntityWithSpecialCharsExample();
	    badPractivesDao.createentityWithSpecialChars(entityWithSpecialChars);
	    
	    // Execute the tested code
	    badPractivesDao.deleteentityWithSpecialChars(entityWithSpecialChars);
	    
	    // Verify result
	    boolean found = false;
	    for (EntityWithSpecialChars currententityWithSpecialChars : badPractivesDao.findAllentityWithSpecialCharss()) {
	        if (currententityWithSpecialChars.getId().equals(entityWithSpecialChars.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("entityWithSpecialChars not deleted", found);
	}
	
	/**
	 * Test the search of all entities entityWithSpécialChars.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllentityWithSpecialCharss() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllentityWithSpecialCharss().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    EntityWithSpecialChars entityWithSpecialChars1 = getEntityWithSpecialCharsExample();
	    badPractivesDao.createentityWithSpecialChars(entityWithSpecialChars1);
	            
	    EntityWithSpecialChars entityWithSpecialChars2 = getEntityWithSpecialCharsExample();
	    badPractivesDao.createentityWithSpecialChars(entityWithSpecialChars2);
	
	    // Verify result
	    int after = badPractivesDao.findAllentityWithSpecialCharss().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity public.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreatepublic_() throws DaoException {
	    // fill attributes with example values
	    Public_ public_ = getPublic_Example();
	    
	    // Execute the tested code
	    badPractivesDao.createpublic_(public_);
	
	    // Verify result
	    boolean found = false;
	    for (Public_ currentpublic_ : badPractivesDao.findAllpublic_s()) {
	        if (currentpublic_.equals(public_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("public not created", found);
	}
	
	/**
	 * Test the modification of an entity public.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdatepublic_() throws DaoException {
	    // Initialized the test
	    Public_ public_ = getPublic_Example();
	    badPractivesDao.createpublic_(public_);
	
	    // Execute the tested code
	    badPractivesDao.updatepublic_(public_);
	
	    // Verify result
	    boolean found = false;
	    for (Public_ currentpublic_ : badPractivesDao.findAllpublic_s()) {
	        if (currentpublic_.equals(public_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("public_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity public.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeletepublic_() throws DaoException {
	    // Initialized the test
	    Public_ public_ = getPublic_Example();
	    badPractivesDao.createpublic_(public_);
	    
	    // Execute the tested code
	    badPractivesDao.deletepublic_(public_);
	    
	    // Verify result
	    boolean found = false;
	    for (Public_ currentpublic_ : badPractivesDao.findAllpublic_s()) {
	        if (currentpublic_.getId().equals(public_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("public_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities public.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllpublic_s() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllpublic_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Public_ public_1 = getPublic_Example();
	    badPractivesDao.createpublic_(public_1);
	            
	    Public_ public_2 = getPublic_Example();
	    badPractivesDao.createpublic_(public_2);
	
	    // Verify result
	    int after = badPractivesDao.findAllpublic_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity private.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateprivate_() throws DaoException {
	    // fill attributes with example values
	    Private_ private_ = getPrivate_Example();
	    
	    // Execute the tested code
	    badPractivesDao.createprivate_(private_);
	
	    // Verify result
	    boolean found = false;
	    for (Private_ currentprivate_ : badPractivesDao.findAllprivate_s()) {
	        if (currentprivate_.equals(private_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("private not created", found);
	}
	
	/**
	 * Test the modification of an entity private.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateprivate_() throws DaoException {
	    // Initialized the test
	    Private_ private_ = getPrivate_Example();
	    badPractivesDao.createprivate_(private_);
	
	    // Execute the tested code
	    badPractivesDao.updateprivate_(private_);
	
	    // Verify result
	    boolean found = false;
	    for (Private_ currentprivate_ : badPractivesDao.findAllprivate_s()) {
	        if (currentprivate_.equals(private_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("private_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity private.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteprivate_() throws DaoException {
	    // Initialized the test
	    Private_ private_ = getPrivate_Example();
	    badPractivesDao.createprivate_(private_);
	    
	    // Execute the tested code
	    badPractivesDao.deleteprivate_(private_);
	    
	    // Verify result
	    boolean found = false;
	    for (Private_ currentprivate_ : badPractivesDao.findAllprivate_s()) {
	        if (currentprivate_.getId().equals(private_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("private_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities private.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllprivate_s() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllprivate_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Private_ private_1 = getPrivate_Example();
	    badPractivesDao.createprivate_(private_1);
	            
	    Private_ private_2 = getPrivate_Example();
	    badPractivesDao.createprivate_(private_2);
	
	    // Verify result
	    int after = badPractivesDao.findAllprivate_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity protected.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateprotected_() throws DaoException {
	    // fill attributes with example values
	    Protected_ protected_ = getProtected_Example();
	    
	    // Execute the tested code
	    badPractivesDao.createprotected_(protected_);
	
	    // Verify result
	    boolean found = false;
	    for (Protected_ currentprotected_ : badPractivesDao.findAllprotected_s()) {
	        if (currentprotected_.equals(protected_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("protected not created", found);
	}
	
	/**
	 * Test the modification of an entity protected.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateprotected_() throws DaoException {
	    // Initialized the test
	    Protected_ protected_ = getProtected_Example();
	    badPractivesDao.createprotected_(protected_);
	
	    // Execute the tested code
	    badPractivesDao.updateprotected_(protected_);
	
	    // Verify result
	    boolean found = false;
	    for (Protected_ currentprotected_ : badPractivesDao.findAllprotected_s()) {
	        if (currentprotected_.equals(protected_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("protected_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity protected.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteprotected_() throws DaoException {
	    // Initialized the test
	    Protected_ protected_ = getProtected_Example();
	    badPractivesDao.createprotected_(protected_);
	    
	    // Execute the tested code
	    badPractivesDao.deleteprotected_(protected_);
	    
	    // Verify result
	    boolean found = false;
	    for (Protected_ currentprotected_ : badPractivesDao.findAllprotected_s()) {
	        if (currentprotected_.getId().equals(protected_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("protected_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities protected.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllprotected_s() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllprotected_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Protected_ protected_1 = getProtected_Example();
	    badPractivesDao.createprotected_(protected_1);
	            
	    Protected_ protected_2 = getProtected_Example();
	    badPractivesDao.createprotected_(protected_2);
	
	    // Verify result
	    int after = badPractivesDao.findAllprotected_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity null.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreatenull_() throws DaoException {
	    // fill attributes with example values
	    Null_ null_ = getNull_Example();
	    
	    // Execute the tested code
	    badPractivesDao.createnull_(null_);
	
	    // Verify result
	    boolean found = false;
	    for (Null_ currentnull_ : badPractivesDao.findAllnull_s()) {
	        if (currentnull_.equals(null_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("null not created", found);
	}
	
	/**
	 * Test the modification of an entity null.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdatenull_() throws DaoException {
	    // Initialized the test
	    Null_ null_ = getNull_Example();
	    badPractivesDao.createnull_(null_);
	
	    // Execute the tested code
	    badPractivesDao.updatenull_(null_);
	
	    // Verify result
	    boolean found = false;
	    for (Null_ currentnull_ : badPractivesDao.findAllnull_s()) {
	        if (currentnull_.equals(null_)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("null_ not found", found);
	}
	
	/**
	 * Test the suppression of an entity null.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeletenull_() throws DaoException {
	    // Initialized the test
	    Null_ null_ = getNull_Example();
	    badPractivesDao.createnull_(null_);
	    
	    // Execute the tested code
	    badPractivesDao.deletenull_(null_);
	    
	    // Verify result
	    boolean found = false;
	    for (Null_ currentnull_ : badPractivesDao.findAllnull_s()) {
	        if (currentnull_.getId().equals(null_.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("null_ not deleted", found);
	}
	
	/**
	 * Test the search of all entities null.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllnull_s() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllnull_s().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    Null_ null_1 = getNull_Example();
	    badPractivesDao.createnull_(null_1);
	            
	    Null_ null_2 = getNull_Example();
	    badPractivesDao.createnull_(null_2);
	
	    // Verify result
	    int after = badPractivesDao.findAllnull_s().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity myEntity.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreatemyEntity() throws DaoException {
	    // fill attributes with example values
	    MyEntity myEntity = getMyEntityExample();
	    
	    // Execute the tested code
	    badPractivesDao.createmyEntity(myEntity);
	
	    // Verify result
	    boolean found = false;
	    for (MyEntity currentmyEntity : badPractivesDao.findAllmyEntitys()) {
	        if (currentmyEntity.equals(myEntity)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("myEntity not created", found);
	}
	
	/**
	 * Test the modification of an entity myEntity.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdatemyEntity() throws DaoException {
	    // Initialized the test
	    MyEntity myEntity = getMyEntityExample();
	    badPractivesDao.createmyEntity(myEntity);
	
	    // Execute the tested code
	    myEntity.setAttr1(new Integer(-1407244862));
	    myEntity.setPrivate_(new Integer(-314497661));
	    myEntity.setPublic_(new Integer(-977423767));
	    myEntity.setProtected_("secondProtected");
	    myEntity.setNull_("secondNull");
	    myEntity.setString("secondString");
	    myEntity.setA(new Float(224.0));
	    badPractivesDao.updatemyEntity(myEntity);
	
	    // Verify result
	    boolean found = false;
	    for (MyEntity currentmyEntity : badPractivesDao.findAllmyEntitys()) {
	        if (currentmyEntity.equals(myEntity)) {
	            found = true;
	            Assert.assertEquals("Value attr1 not modified",
	                    new Integer(-1407244862),
	                    myEntity.getAttr1());
	            Assert.assertEquals("Value private_ not modified",
	                    new Integer(-314497661),
	                    myEntity.getPrivate_());
	            Assert.assertEquals("Value public_ not modified",
	                    new Integer(-977423767),
	                    myEntity.getPublic_());
	            Assert.assertEquals("Value protected_ not modified",
	                    "secondProtected",
	                    myEntity.getProtected_());
	            Assert.assertEquals("Value null_ not modified",
	                    "secondNull",
	                    myEntity.getNull_());
	            Assert.assertEquals("Value string not modified",
	                    "secondString",
	                    myEntity.getString());
	            Assert.assertEquals("Value a not modified",
	                    new Float(224.0),
	                    myEntity.getA());
	        }
	    }
	    Assert.assertTrue("myEntity not found", found);
	}
	
	/**
	 * Test the suppression of an entity myEntity.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeletemyEntity() throws DaoException {
	    // Initialized the test
	    MyEntity myEntity = getMyEntityExample();
	    badPractivesDao.createmyEntity(myEntity);
	    
	    // Execute the tested code
	    badPractivesDao.deletemyEntity(myEntity);
	    
	    // Verify result
	    boolean found = false;
	    for (MyEntity currentmyEntity : badPractivesDao.findAllmyEntitys()) {
	        if (currentmyEntity.getId().equals(myEntity.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("myEntity not deleted", found);
	}
	
	/**
	 * Test the search of all entities myEntity.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllmyEntitys() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllmyEntitys().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    MyEntity myEntity1 = getMyEntityExample();
	    badPractivesDao.createmyEntity(myEntity1);
	            
	    MyEntity myEntity2 = getMyEntityExample();
	    badPractivesDao.createmyEntity(myEntity2);
	
	    // Verify result
	    int after = badPractivesDao.findAllmyEntitys().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	/**
	 * Tests the creation of the entity TABLE.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Search the entity and verify it exists</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testCreateTABLE() throws DaoException {
	    // fill attributes with example values
	    TABLE tABLE = getTABLEExample();
	    
	    // Execute the tested code
	    badPractivesDao.createTABLE(tABLE);
	
	    // Verify result
	    boolean found = false;
	    for (TABLE currentTABLE : badPractivesDao.findAllTABLEs()) {
	        if (currentTABLE.equals(tABLE)) {
	            found = true;
	        }
	    }
	    Assert.assertTrue("TABLE not created", found);
	}
	
	/**
	 * Test the modification of an entity TABLE.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Modify the entity</li>
	 * <li>Step 3 : Search the entity and verify the modified values</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testUpdateTABLE() throws DaoException {
	    // Initialized the test
	    TABLE tABLE = getTABLEExample();
	    badPractivesDao.createTABLE(tABLE);
	
	    // Execute the tested code
	    tABLE.setCOLUMN(new Integer(1993459542));
	    tABLE.setPRIMARYKEY(new Integer(1284802305));
	    badPractivesDao.updateTABLE(tABLE);
	
	    // Verify result
	    boolean found = false;
	    for (TABLE currentTABLE : badPractivesDao.findAllTABLEs()) {
	        if (currentTABLE.equals(tABLE)) {
	            found = true;
	            Assert.assertEquals("Value cOLUMN not modified",
	                    new Integer(1993459542),
	                    tABLE.getCOLUMN());
	            Assert.assertEquals("Value pRIMARYKEY not modified",
	                    new Integer(1284802305),
	                    tABLE.getPRIMARYKEY());
	        }
	    }
	    Assert.assertTrue("TABLE not found", found);
	}
	
	/**
	 * Test the suppression of an entity TABLE.<br/>
	 * <ul><li>Step 1 : Create an entity</li>
	 * <li>Step 2 : Delete the entity</li>
	 * <li>Step 3 : Search the entity and verify it doesn't exist anymore</li>
	 * </ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testDeleteTABLE() throws DaoException {
	    // Initialized the test
	    TABLE tABLE = getTABLEExample();
	    badPractivesDao.createTABLE(tABLE);
	    
	    // Execute the tested code
	    badPractivesDao.deleteTABLE(tABLE);
	    
	    // Verify result
	    boolean found = false;
	    for (TABLE currentTABLE : badPractivesDao.findAllTABLEs()) {
	        if (currentTABLE.getId().equals(tABLE.getId())) {
	            found = true;                
	        }
	    }
	    Assert.assertFalse("TABLE not deleted", found);
	}
	
	/**
	 * Test the search of all entities TABLE.<br/>
	 * <ul><li>Step 1 : Create many entities</li>
	 * <li>Step 2 : Search all entities and verify the entities created are
	 * found</li></ul>
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	public final void testFindAllTABLEs() throws DaoException {
	    // Verify number of element before testing
	    int before = badPractivesDao.findAllTABLEs().size();
	    Assert.assertTrue("FindAll must return at least 0", before >= 0);
	    
	    // Add two elements
	    TABLE tABLE1 = getTABLEExample();
	    badPractivesDao.createTABLE(tABLE1);
	            
	    TABLE tABLE2 = getTABLEExample();
	    badPractivesDao.createTABLE(tABLE2);
	
	    // Verify result
	    int after = badPractivesDao.findAllTABLEs().size();
	    Assert.assertEquals(
	            "FindAll don't find the good number of elements", 
	            2,
	            after - before);
	}
	
	

	
	/**
	 * Creates an example of Interface.
	 * @return Returns a new instance of class Interface, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Interface_ getInterface_Example() throws DaoException {
	    // fill attributes with example values
	    Interface_ interface_ = new Interface_();
	    
	    
	    return interface_;
	}
	
	/**
	 * Creates a second example of Interface with other values.
	 * @return Returns a new instance of class Interface with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Interface_ getInterface_Example2() throws DaoException {
	    // fill attributes with example values
	    Interface_ interface_ = new Interface_();
		
		
	    return interface_;
	}
	
	/**
	 * Creates an example of Class.
	 * @return Returns a new instance of class Class, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class_ getClass_Example() throws DaoException {
	    // fill attributes with example values
	    Class_ class_ = new Class_();
	    
	    
	    return class_;
	}
	
	/**
	 * Creates a second example of Class with other values.
	 * @return Returns a new instance of class Class with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Class_ getClass_Example2() throws DaoException {
	    // fill attributes with example values
	    Class_ class_ = new Class_();
		
		
	    return class_;
	}
	
	/**
	 * Creates an example of Bad name.
	 * @return Returns a new instance of class Bad name, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected BadName getBadNameExample() throws DaoException {
	    // fill attributes with example values
	    BadName badName = new BadName();
	    
	    
	    return badName;
	}
	
	/**
	 * Creates a second example of Bad name with other values.
	 * @return Returns a new instance of class Bad name with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected BadName getBadNameExample2() throws DaoException {
	    // fill attributes with example values
	    BadName badName = new BadName();
		
		
	    return badName;
	}
	
	/**
	 * Creates an example of Another.name.
	 * @return Returns a new instance of class Another.name, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Anothername getAnothernameExample() throws DaoException {
	    // fill attributes with example values
	    Anothername anothername = new Anothername();
	    
	    
	    return anothername;
	}
	
	/**
	 * Creates a second example of Another.name with other values.
	 * @return Returns a new instance of class Another.name with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Anothername getAnothernameExample2() throws DaoException {
	    // fill attributes with example values
	    Anothername anothername = new Anothername();
		
		
	    return anothername;
	}
	
	/**
	 * Creates an example of entityWithSpécialChars.
	 * @return Returns a new instance of class entityWithSpécialChars, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected EntityWithSpecialChars getEntityWithSpecialCharsExample() throws DaoException {
	    // fill attributes with example values
	    EntityWithSpecialChars entityWithSpecialChars = new EntityWithSpecialChars();
	    
	    
	    return entityWithSpecialChars;
	}
	
	/**
	 * Creates a second example of entityWithSpécialChars with other values.
	 * @return Returns a new instance of class entityWithSpécialChars with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected EntityWithSpecialChars getEntityWithSpecialCharsExample2() throws DaoException {
	    // fill attributes with example values
	    EntityWithSpecialChars entityWithSpecialChars = new EntityWithSpecialChars();
		
		
	    return entityWithSpecialChars;
	}
	
	/**
	 * Creates an example of public.
	 * @return Returns a new instance of class public, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Public_ getPublic_Example() throws DaoException {
	    // fill attributes with example values
	    Public_ public_ = new Public_();
	    
	    
	    return public_;
	}
	
	/**
	 * Creates a second example of public with other values.
	 * @return Returns a new instance of class public with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Public_ getPublic_Example2() throws DaoException {
	    // fill attributes with example values
	    Public_ public_ = new Public_();
		
		
	    return public_;
	}
	
	/**
	 * Creates an example of private.
	 * @return Returns a new instance of class private, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Private_ getPrivate_Example() throws DaoException {
	    // fill attributes with example values
	    Private_ private_ = new Private_();
	    
	    
	    return private_;
	}
	
	/**
	 * Creates a second example of private with other values.
	 * @return Returns a new instance of class private with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Private_ getPrivate_Example2() throws DaoException {
	    // fill attributes with example values
	    Private_ private_ = new Private_();
		
		
	    return private_;
	}
	
	/**
	 * Creates an example of protected.
	 * @return Returns a new instance of class protected, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Protected_ getProtected_Example() throws DaoException {
	    // fill attributes with example values
	    Protected_ protected_ = new Protected_();
	    
	    
	    return protected_;
	}
	
	/**
	 * Creates a second example of protected with other values.
	 * @return Returns a new instance of class protected with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Protected_ getProtected_Example2() throws DaoException {
	    // fill attributes with example values
	    Protected_ protected_ = new Protected_();
		
		
	    return protected_;
	}
	
	/**
	 * Creates an example of null.
	 * @return Returns a new instance of class null, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Null_ getNull_Example() throws DaoException {
	    // fill attributes with example values
	    Null_ null_ = new Null_();
	    
	    
	    return null_;
	}
	
	/**
	 * Creates a second example of null with other values.
	 * @return Returns a new instance of class null with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected Null_ getNull_Example2() throws DaoException {
	    // fill attributes with example values
	    Null_ null_ = new Null_();
		
		
	    return null_;
	}
	
	/**
	 * Creates an example of myEntity.
	 * @return Returns a new instance of class myEntity, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected MyEntity getMyEntityExample() throws DaoException {
	    // fill attributes with example values
	    MyEntity myEntity = new MyEntity();
	    myEntity.setAttr1(new Integer(-1407244862 + 1));
	    myEntity.setPrivate_(new Integer(-314497661 + 1));
	    myEntity.setPublic_(new Integer(-977423767 + 1));
	    myEntity.setProtected_("myProtected");
	    myEntity.setNull_("myNull");
	    myEntity.setString("myString");
	    myEntity.setA(new Float(224.1));
	    
	    
	    return myEntity;
	}
	
	/**
	 * Creates a second example of myEntity with other values.
	 * @return Returns a new instance of class myEntity with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected MyEntity getMyEntityExample2() throws DaoException {
	    // fill attributes with example values
	    MyEntity myEntity = new MyEntity();
		myEntity.setAttr1(new Integer(-1407244862));
		myEntity.setPrivate_(new Integer(-314497661));
		myEntity.setPublic_(new Integer(-977423767));
		myEntity.setProtected_("secondProtected");
		myEntity.setNull_("secondNull");
		myEntity.setString("secondString");
		myEntity.setA(new Float(224.0));
		
		
	    return myEntity;
	}
	
	/**
	 * Creates an example of TABLE.
	 * @return Returns a new instance of class TABLE, with fields filled
	 * with example values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected TABLE getTABLEExample() throws DaoException {
	    // fill attributes with example values
	    TABLE tABLE = new TABLE();
	    tABLE.setCOLUMN(new Integer(1993459542 + 1));
	    tABLE.setPRIMARYKEY(new Integer(1284802305 + 1));
	    
	    
	    return tABLE;
	}
	
	/**
	 * Creates a second example of TABLE with other values.
	 * @return Returns a new instance of class TABLE with fields filled
	 * with other test values.
	 * @throws DaoException if an unexpected DAO exception occurs.
	 */
	protected TABLE getTABLEExample2() throws DaoException {
	    // fill attributes with example values
	    TABLE tABLE = new TABLE();
		tABLE.setCOLUMN(new Integer(1993459542));
		tABLE.setPRIMARYKEY(new Integer(1284802305));
		
		
	    return tABLE;
	}
	
    
    // Start of user code of specific tests
    // End of user code

}
