package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.kindofdao.test.ExempleDirectTest;
import org.obeonetwork.sample.customize.test.PersonTest;
import org.obeonetwork.sample.customize.test.AddressTest;
import org.obeonetwork.sample.operation.test.OperationsTest;
import org.obeonetwork.sample.operation.test.FindersTest;

// End of user code

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(ExempleDirectTest.class);
		suite.addTestSuite(PersonTest.class);
		suite.addTestSuite(AddressTest.class);
		suite.addTestSuite(OperationsTest.class);
		suite.addTestSuite(FindersTest.class);
		//Start of user code others unit tests
		
		//End of user code
		return suite;
	}

}
