package org.obeonetwork.sample.ui.test.htmlunit;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestEcranPrincipalAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestEcranSecondaireAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestLabelsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestTextFieldsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestComboBoxesAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestPasswordsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestCheckBoxesAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestRadioButtonsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestSlideBarsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestPushButtonsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestToggleButtonsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestSimpleButtonsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestDisplayListsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestCanvasAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestLinksAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestProgressBarsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestTextAreasAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestActionsAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestAllInOneAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestCircuitStartAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestCircuitReturnAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestLoopAction;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestMany1Action;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestMany2Action;
import org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit.TestManyToOneAction;

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
		suite.addTestSuite(TestEcranPrincipalAction.class);
		suite.addTestSuite(TestEcranSecondaireAction.class);
		suite.addTestSuite(TestLabelsAction.class);
		suite.addTestSuite(TestTextFieldsAction.class);
		suite.addTestSuite(TestComboBoxesAction.class);
		suite.addTestSuite(TestPasswordsAction.class);
		suite.addTestSuite(TestCheckBoxesAction.class);
		suite.addTestSuite(TestRadioButtonsAction.class);
		suite.addTestSuite(TestSlideBarsAction.class);
		suite.addTestSuite(TestPushButtonsAction.class);
		suite.addTestSuite(TestToggleButtonsAction.class);
		suite.addTestSuite(TestSimpleButtonsAction.class);
		suite.addTestSuite(TestDisplayListsAction.class);
		suite.addTestSuite(TestCanvasAction.class);
		suite.addTestSuite(TestLinksAction.class);
		suite.addTestSuite(TestProgressBarsAction.class);
		suite.addTestSuite(TestTextAreasAction.class);
		suite.addTestSuite(TestActionsAction.class);
		suite.addTestSuite(TestAllInOneAction.class);
		suite.addTestSuite(TestCircuitStartAction.class);
		suite.addTestSuite(TestCircuitReturnAction.class);
		suite.addTestSuite(TestLoopAction.class);
		suite.addTestSuite(TestMany1Action.class);
		suite.addTestSuite(TestMany2Action.class);
		suite.addTestSuite(TestManyToOneAction.class);

		//Start of user code for suite tests
		//End of user code

		return suite;
	}

	//Start of user code for other tests
	//End of user code

}