package org.obeonetwork.sample;

// Start of user code for import 
import junit.framework.Test;
import junit.framework.TestSuite;

import org.obeonetwork.sample.inheritanceassociations.test.Class0101Test;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101ENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101BITest;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101BIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101Test;
import org.obeonetwork.sample.inheritanceassociations.test.Class101ENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101BITest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101BIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011Test;
import org.obeonetwork.sample.inheritanceassociations.test.Class011ENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011BITest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011BIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11Test;
import org.obeonetwork.sample.inheritanceassociations.test.Class11ENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11BITest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11BIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyBITest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyBIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01Test;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01ENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01BITest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01BIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyEndTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyBITest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyBIENDTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101ENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101BIENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101EndSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101BIENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011ENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011BiENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11ENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11BIENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyBIENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01ENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01BIENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyEndSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyBIENDSubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101SubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class0101BISubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101SubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class101BISubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011SubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class011BISubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11SubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class11BISubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManySubTest;
import org.obeonetwork.sample.inheritanceassociations.test.Class01ManyBISubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01SubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassMany01BISubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManySubTest;
import org.obeonetwork.sample.inheritanceassociations.test.ClassManyManyBISubTest;

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
		suite.addTestSuite(Class0101ENDSubTest.class);
		suite.addTestSuite(Class0101BIENDSubTest.class);
		suite.addTestSuite(Class101EndSubTest.class);
		suite.addTestSuite(Class101BIENDSubTest.class);
		suite.addTestSuite(Class011ENDSubTest.class);
		suite.addTestSuite(Class011BiENDSubTest.class);
		suite.addTestSuite(Class11ENDSubTest.class);
		suite.addTestSuite(Class11BIENDSubTest.class);
		suite.addTestSuite(Class01ManyENDSubTest.class);
		suite.addTestSuite(Class01ManyBIENDSubTest.class);
		suite.addTestSuite(ClassMany01ENDSubTest.class);
		suite.addTestSuite(ClassMany01BIENDSubTest.class);
		suite.addTestSuite(ClassManyManyEndSubTest.class);
		suite.addTestSuite(ClassManyManyBIENDSubTest.class);
		suite.addTestSuite(Class0101SubTest.class);
		suite.addTestSuite(Class0101BISubTest.class);
		suite.addTestSuite(Class101SubTest.class);
		suite.addTestSuite(Class101BISubTest.class);
		suite.addTestSuite(Class011SubTest.class);
		suite.addTestSuite(Class011BISubTest.class);
		suite.addTestSuite(Class11SubTest.class);
		suite.addTestSuite(Class11BISubTest.class);
		suite.addTestSuite(Class01ManySubTest.class);
		suite.addTestSuite(Class01ManyBISubTest.class);
		suite.addTestSuite(ClassMany01SubTest.class);
		suite.addTestSuite(ClassMany01BISubTest.class);
		suite.addTestSuite(ClassManyManySubTest.class);
		suite.addTestSuite(ClassManyManyBISubTest.class);
		//Start of user code others unit tests
		
		//End of user code
		return suite;
	}

}
