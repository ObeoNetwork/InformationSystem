package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.blog.test.BlogEntryTest;
import org.obeonetwork.sample.informations.test.CommentTest;
import org.obeonetwork.sample.informations.test.TagTest;
import org.obeonetwork.sample.informations.test.CategoryTest;
import org.obeonetwork.sample.users.test.AdminTest;
import org.obeonetwork.sample.users.test.UserTest;
import org.obeonetwork.sample.users.test.ModeratorTest;

// End of user code for import

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(BlogEntryTest.class);
		suite.addTestSuite(CommentTest.class);
		suite.addTestSuite(TagTest.class);
		suite.addTestSuite(CategoryTest.class);
		suite.addTestSuite(AdminTest.class);
		suite.addTestSuite(UserTest.class);
		suite.addTestSuite(ModeratorTest.class);
		//Start of user code others unit tests
		
		//End of user code others unit tests
		return suite;
	}

}