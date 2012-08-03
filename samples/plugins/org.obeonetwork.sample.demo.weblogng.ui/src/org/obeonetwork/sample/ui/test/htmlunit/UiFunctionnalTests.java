package org.obeonetwork.sample.ui.test.htmlunit;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestLoginAction;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestEditAccountAction;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestErrorsAction;
import org.obeonetwork.sample.ui.users.test.htmlunit.TestCreateAccountAction;
import org.obeonetwork.sample.ui.main.test.htmlunit.TestViewLogsAction;
import org.obeonetwork.sample.ui.main.test.htmlunit.TestCreateLogAction;
import org.obeonetwork.sample.ui.main.test.htmlunit.TestViewCommentsAction;
import org.obeonetwork.sample.ui.grant.test.htmlunit.TestGrantAdministrateAction;
import org.obeonetwork.sample.ui.grant.test.htmlunit.TestGrantModerateAction;
import org.obeonetwork.sample.ui.search.test.htmlunit.TestSearchAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestDeleteUserAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestDeleteCommentAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestManagerAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestManageCommentsAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestManageCategoriesAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestManageTagsAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestUpdateCommentAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestCreateCategoryAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestUpdateCategoryAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestDeleteCategoryAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestCreateTagAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestUpdateTagAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestDeleteTagAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestAddTagAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestRemoveTagAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestAddCategoryAction;
import org.obeonetwork.sample.ui.manage.test.htmlunit.TestRemoveCategoryAction;
import org.obeonetwork.sample.ui.monitoring.test.htmlunit.TestMonitorAction;
import org.obeonetwork.sample.ui.monitoring.test.htmlunit.TestSeeUsersAction;
import org.obeonetwork.sample.ui.monitoring.test.htmlunit.TestSeeCategoriesAction;
import org.obeonetwork.sample.ui.monitoring.test.htmlunit.TestSeeTagsAction;
import org.obeonetwork.sample.ui.monitoring.test.htmlunit.TestSeeCommentsAction;

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
		suite.addTestSuite(TestErrorsAction.class);
		suite.addTestSuite(TestCreateAccountAction.class);
		suite.addTestSuite(TestViewLogsAction.class);
		suite.addTestSuite(TestCreateLogAction.class);
		suite.addTestSuite(TestViewCommentsAction.class);
		suite.addTestSuite(TestGrantAdministrateAction.class);
		suite.addTestSuite(TestGrantModerateAction.class);
		suite.addTestSuite(TestSearchAction.class);
		suite.addTestSuite(TestDeleteUserAction.class);
		suite.addTestSuite(TestDeleteCommentAction.class);
		suite.addTestSuite(TestManagerAction.class);
		suite.addTestSuite(TestManageCommentsAction.class);
		suite.addTestSuite(TestManageCategoriesAction.class);
		suite.addTestSuite(TestManageTagsAction.class);
		suite.addTestSuite(TestUpdateCommentAction.class);
		suite.addTestSuite(TestCreateCategoryAction.class);
		suite.addTestSuite(TestUpdateCategoryAction.class);
		suite.addTestSuite(TestDeleteCategoryAction.class);
		suite.addTestSuite(TestCreateTagAction.class);
		suite.addTestSuite(TestUpdateTagAction.class);
		suite.addTestSuite(TestDeleteTagAction.class);
		suite.addTestSuite(TestAddTagAction.class);
		suite.addTestSuite(TestRemoveTagAction.class);
		suite.addTestSuite(TestAddCategoryAction.class);
		suite.addTestSuite(TestRemoveCategoryAction.class);
		suite.addTestSuite(TestMonitorAction.class);
		suite.addTestSuite(TestSeeUsersAction.class);
		suite.addTestSuite(TestSeeCategoriesAction.class);
		suite.addTestSuite(TestSeeTagsAction.class);
		suite.addTestSuite(TestSeeCommentsAction.class);

		//Start of user code for suite tests
 		//End of user code

		return suite;
	}

	//Start of user code for other tests
 	//End of user code

}