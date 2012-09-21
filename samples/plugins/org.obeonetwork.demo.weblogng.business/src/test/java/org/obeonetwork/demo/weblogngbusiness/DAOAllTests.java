package org.obeonetwork.demo.weblogngbusiness;

// Start of user code for import
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.demo.weblogng.business.blog.test.BlogEntryTest;
import org.obeonetwork.demo.weblogng.business.informations.test.CommentTest;
import org.obeonetwork.demo.weblogng.business.informations.test.TagTest;
import org.obeonetwork.demo.weblogng.business.informations.test.CategoryTest;
import org.obeonetwork.demo.weblogng.business.users.test.AdminTest;
import org.obeonetwork.demo.weblogng.business.users.test.UserTest;
import org.obeonetwork.demo.weblogng.business.users.test.ModeratorTest;

// End of user code

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

//End of user code
		return suite;
	}

}
