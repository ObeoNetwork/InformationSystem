package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.badpractives.test.Interface_Test;
import org.obeonetwork.sample.badpractives.test.Class_Test;
import org.obeonetwork.sample.badpractives.test.BadNameTest;
import org.obeonetwork.sample.badpractives.test.AnothernameTest;
import org.obeonetwork.sample.badpractives.test.EntityWithSpecialCharsTest;
import org.obeonetwork.sample.badpractives.test.Public_Test;
import org.obeonetwork.sample.badpractives.test.Private_Test;
import org.obeonetwork.sample.badpractives.test.Protected_Test;
import org.obeonetwork.sample.badpractives.test.Null_Test;
import org.obeonetwork.sample.badpractives.test.MyEntityTest;
import org.obeonetwork.sample.badpractives.test.TABLETest;

// End of user code for import

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(Interface_Test.class);
		suite.addTestSuite(Class_Test.class);
		suite.addTestSuite(BadNameTest.class);
		suite.addTestSuite(AnothernameTest.class);
		suite.addTestSuite(EntityWithSpecialCharsTest.class);
		suite.addTestSuite(Public_Test.class);
		suite.addTestSuite(Private_Test.class);
		suite.addTestSuite(Protected_Test.class);
		suite.addTestSuite(Null_Test.class);
		suite.addTestSuite(MyEntityTest.class);
		suite.addTestSuite(TABLETest.class);
		//Start of user code others unit tests
		
		//End of user code others unit tests
		return suite;
	}

}