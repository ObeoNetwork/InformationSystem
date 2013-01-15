package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.inheritance.test.BasicTest;
import org.obeonetwork.sample.inheritance.test.BasicWithoutAttrTest;
import org.obeonetwork.sample.inheritance.test.RootTest;
import org.obeonetwork.sample.inheritance.test.ClassA1Test;
import org.obeonetwork.sample.inheritance.test.ClassA2Test;
import org.obeonetwork.sample.inheritance.test.ClassA3Test;
import org.obeonetwork.sample.inheritance.test.MainTest;
import org.obeonetwork.sample.inheritance.test.Sub1Test;
import org.obeonetwork.sample.inheritance.test.Sub2Test;

// End of user code

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(BasicTest.class);
		suite.addTestSuite(BasicWithoutAttrTest.class);
		suite.addTestSuite(RootTest.class);
		suite.addTestSuite(ClassA1Test.class);
		suite.addTestSuite(ClassA2Test.class);
		suite.addTestSuite(ClassA3Test.class);
		suite.addTestSuite(MainTest.class);
		suite.addTestSuite(Sub1Test.class);
		suite.addTestSuite(Sub2Test.class);
		//Start of user code others unit tests
		
		//End of user code
		return suite;
	}

}
