package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.associations.test.AssociationsTest;

// End of user code for import

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(AssociationsTest.class);
		//Start of user code others unit tests
		
		//End of user code others unit tests
		return suite;
	}

}