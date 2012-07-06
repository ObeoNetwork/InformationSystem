package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.test.htmlunit;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.test.htmlunit.TestEcran1Action;
import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.test.htmlunit.TestEcran2Action;
import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.test.htmlunit.TestEcran3Action;

/**
 * Junit Suite testing for dsl.cinematic.gen.java.struts.architecture.tests
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
		suite.addTestSuite(TestEcran1Action.class);
		suite.addTestSuite(TestEcran2Action.class);
		suite.addTestSuite(TestEcran3Action.class);

		//Start of user code for suite tests
		//End of user code

		return suite;
	}

	//Start of user code for other tests
	//End of user code

}