package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.badpractives.test.BadPractivesTest;
import org.obeonetwork.sample.badpractives.package_.test.Package_Test;

// End of user code

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(BadPractivesTest.class);
		suite.addTestSuite(Package_Test.class);
		//Start of user code others unit tests
		
		//End of user code
		return suite;
	}

}
