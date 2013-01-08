package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.associations.test.Class0101Test;
import org.obeonetwork.sample.associations.test.Class0101ENDTest;
import org.obeonetwork.sample.associations.test.Class0101BITest;
import org.obeonetwork.sample.associations.test.Class0101BIENDTest;
import org.obeonetwork.sample.associations.test.Class101Test;
import org.obeonetwork.sample.associations.test.Class101ENDTest;
import org.obeonetwork.sample.associations.test.Class101BITest;
import org.obeonetwork.sample.associations.test.Class101BIENDTest;
import org.obeonetwork.sample.associations.test.Class011Test;
import org.obeonetwork.sample.associations.test.Class011ENDTest;
import org.obeonetwork.sample.associations.test.Class011BITest;
import org.obeonetwork.sample.associations.test.Class011BIENDTest;
import org.obeonetwork.sample.associations.test.Class11Test;
import org.obeonetwork.sample.associations.test.Class11ENDTest;
import org.obeonetwork.sample.associations.test.Class11BITest;
import org.obeonetwork.sample.associations.test.Class11BIENDTest;
import org.obeonetwork.sample.associations.test.Class01ManyTest;
import org.obeonetwork.sample.associations.test.Class01ManyENDTest;
import org.obeonetwork.sample.associations.test.Class01ManyBITest;
import org.obeonetwork.sample.associations.test.Class01ManyBIENDTest;
import org.obeonetwork.sample.associations.test.ClassMany01Test;
import org.obeonetwork.sample.associations.test.ClassMany01ENDTest;
import org.obeonetwork.sample.associations.test.ClassMany01BITest;
import org.obeonetwork.sample.associations.test.ClassMany01BIENDTest;
import org.obeonetwork.sample.associations.test.ClassManyManyTest;
import org.obeonetwork.sample.associations.test.ClassManyManyEndTest;
import org.obeonetwork.sample.associations.test.ClassManyManyBITest;
import org.obeonetwork.sample.associations.test.ClassManyManyBIENDTest;

// End of user code

/**
 * Test class for All DAO Tests.
 */
public class DAOAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Tests suite for DAOAllTests");
		
		suite.addTestSuite(Class0101Test.class);
		suite.addTestSuite(Class0101ENDTest.class);
		suite.addTestSuite(Class0101BITest.class);
		suite.addTestSuite(Class0101BIENDTest.class);
		suite.addTestSuite(Class101Test.class);
		suite.addTestSuite(Class101ENDTest.class);
		suite.addTestSuite(Class101BITest.class);
		suite.addTestSuite(Class101BIENDTest.class);
		suite.addTestSuite(Class011Test.class);
		suite.addTestSuite(Class011ENDTest.class);
		suite.addTestSuite(Class011BITest.class);
		suite.addTestSuite(Class011BIENDTest.class);
		suite.addTestSuite(Class11Test.class);
		suite.addTestSuite(Class11ENDTest.class);
		suite.addTestSuite(Class11BITest.class);
		suite.addTestSuite(Class11BIENDTest.class);
		suite.addTestSuite(Class01ManyTest.class);
		suite.addTestSuite(Class01ManyENDTest.class);
		suite.addTestSuite(Class01ManyBITest.class);
		suite.addTestSuite(Class01ManyBIENDTest.class);
		suite.addTestSuite(ClassMany01Test.class);
		suite.addTestSuite(ClassMany01ENDTest.class);
		suite.addTestSuite(ClassMany01BITest.class);
		suite.addTestSuite(ClassMany01BIENDTest.class);
		suite.addTestSuite(ClassManyManyTest.class);
		suite.addTestSuite(ClassManyManyEndTest.class);
		suite.addTestSuite(ClassManyManyBITest.class);
		suite.addTestSuite(ClassManyManyBIENDTest.class);
		//Start of user code others unit tests
		
		//End of user code
		return suite;
	}

}
