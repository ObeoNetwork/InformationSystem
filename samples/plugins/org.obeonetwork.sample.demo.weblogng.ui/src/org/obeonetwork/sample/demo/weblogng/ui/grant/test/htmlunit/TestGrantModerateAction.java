package org.obeonetwork.sample.demo.weblogng.ui.grant.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 * HtmlUnit testing for <strong>GrantModerate Form</strong>
 * Scenario : grant
 *
 */
public class TestGrantModerateAction extends TestCase {

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
	public TestGrantModerateAction(String testName) {
		super(testName);
		//Start of user code for Constructor
 		//End of user code
	}
	/**
	  * Regression test for "addRight" action of class GrantModerateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantModerateaddRightAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantmoderate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantModerateForm");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput addRight = (HtmlSubmitInput)form.getInputByName("addRight");
	    
	    assertEquals("usersaddhiddenmoderatorsremove", page1.getTitleText());

		//Start of user code for addRight action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)addRight.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "showUsers" action of class GrantModerateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantModerateshowUsersAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantmoderate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantModerateForm");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput showUsers = (HtmlSubmitInput)form.getInputByName("showUsers");
	    
	    assertEquals("usersaddhiddenmoderatorsremove", page1.getTitleText());

		//Start of user code for showUsers action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)showUsers.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "removeRight" action of class GrantModerateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantModerateremoveRightAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantmoderate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantModerateForm");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput removeRight = (HtmlSubmitInput)form.getInputByName("removeRight");
	    
	    assertEquals("usersaddhiddenmoderatorsremove", page1.getTitleText());

		//Start of user code for removeRight action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)removeRight.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "showModerators" action of class GrantModerateAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testGrantModerateshowModeratorsAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/grant/grantmoderate?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("GrantModerateForm");
		final HtmlTextInput add = (HtmlTextInput)form.getInputByName("add");
		final HtmlTextInput hidden = (HtmlTextInput)form.getInputByName("hidden");
		final HtmlTextInput remove = (HtmlTextInput)form.getInputByName("remove");
	    final HtmlSubmitInput showModerators = (HtmlSubmitInput)form.getInputByName("showModerators");
	    
	    assertEquals("usersaddhiddenmoderatorsremove", page1.getTitleText());

		//Start of user code for showModerators action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)showModerators.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}