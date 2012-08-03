package org.obeonetwork.sample.ui.test.htmlunit;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestLoginAction;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestEditAccountAction;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestCreateAccountAction;
import org.obeonetwork.sample.ui.main.test.htmlunit.TestViewLogsAction;
import org.obeonetwork.sample.ui.main.test.htmlunit.TestCreateLogAction;

/**
 * Junit Suite testing for sample
 * Launch all HtmlUnit tests
 *
 */
public class UiFunctionnalTests {

/**
 * Main method
 *
 */
public static Test suite() {
		TestSuite suite = new TestSuite("UI Functionnal Tests");

		// Add one entry for each test class 
		// or test suite.
		suite.addTestSuite(TestLoginAction.class);
		suite.addTestSuite(TestEditAccountAction.class);
		suite.addTestSuite(TestCreateAccountAction.class);
		suite.addTestSuite(TestViewLogsAction.class);
		suite.addTestSuite(TestCreateLogAction.class);

		//Start of user code for suite tests
		//End of user code

		return suite;
	}

	//Start of user code for other tests
	//End of user code

}