package org.obeonetwork.demo.weblog.ui.grant.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>GrantAdministrate Form</strong>
 * Scenario : grant
 *
 */
public class TestGrantAdministrateAction extends TestCase {

	/**
	 * initialize the TestCase.
	 * 
	 * @throws Exception if the test fails
	 */
	public void setUp() throws Exception {
		super.setUp();
		//Start of user code for setUp
		//End of user code
	}

	/**
	 * terminate the TestCase.
	 * 
	 * @throws Exception if the test fails
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		//Start of user code for tearDown
 		//End of user code
	}

	/**
	 * Constructor
	 */
	public TestGrantAdministrateAction(String testName) {
		super(testName);
		//Start of user code for Constructor
 		//End of user code
	}
	/**
	  * Regression test for "addRight" action of class GrantAdministrateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantAdministrateaddRightAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantadministrate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantAdministrateForm");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput addRight = (HtmlSubmitInput)form.getInputByName("addRight");
	    
	    assertEquals("hiddenmoderatorsadminsusersaddremove", page1.getTitleText());

		//Start of user code for addRight action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)addRight.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "removeRight" action of class GrantAdministrateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantAdministrateremoveRightAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantadministrate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantAdministrateForm");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput removeRight = (HtmlSubmitInput)form.getInputByName("removeRight");
	    
	    assertEquals("hiddenmoderatorsadminsusersaddremove", page1.getTitleText());

		//Start of user code for removeRight action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)removeRight.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "showModerators" action of class GrantAdministrateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantAdministrateshowModeratorsAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantadministrate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantAdministrateForm");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput showModerators = (HtmlSubmitInput)form.getInputByName("showModerators");
	    
	    assertEquals("hiddenmoderatorsadminsusersaddremove", page1.getTitleText());

		//Start of user code for showModerators action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)showModerators.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "showAdmins" action of class GrantAdministrateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantAdministrateshowAdminsAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantadministrate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantAdministrateForm");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput showAdmins = (HtmlSubmitInput)form.getInputByName("showAdmins");
	    
	    assertEquals("hiddenmoderatorsadminsusersaddremove", page1.getTitleText());

		//Start of user code for showAdmins action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)showAdmins.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "showUsers" action of class GrantAdministrateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantAdministrateshowUsersAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantadministrate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantAdministrateForm");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput showUsers = (HtmlSubmitInput)form.getInputByName("showUsers");
	    
	    assertEquals("hiddenmoderatorsadminsusersaddremove", page1.getTitleText());

		//Start of user code for showUsers action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)showUsers.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}