package org.obeonetwork.sample.ui.main.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>ViewLogs Form</strong>
 * Scenario : viewLogs
 *
 */
public class TestViewLogsAction extends TestCase {

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
	public TestViewLogsAction(String testName) {
		super(testName);
		//Start of user code for Constructor
		//End of user code
	}
	/**
	  * Regression test for "logout" action of class ViewLogsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testViewLogslogoutAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/viewlogs/viewlogs?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ViewLogsForm");
		final HtmlTextInput user = (HtmlTextInput)form.getInputByName("user");
		final HtmlTextInput message = (HtmlTextInput)form.getInputByName("message");
	    final HtmlSubmitInput logout = (HtmlSubmitInput)form.getInputByName("logout");
	    
	    assertEquals("logsusermessage", page1.getTitleText());

		//Start of user code for logout action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)logout.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "createLog" action of class ViewLogsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testViewLogscreateLogAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/viewlogs/viewlogs?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ViewLogsForm");
		final HtmlTextInput user = (HtmlTextInput)form.getInputByName("user");
		final HtmlTextInput message = (HtmlTextInput)form.getInputByName("message");
	    final HtmlSubmitInput createLog = (HtmlSubmitInput)form.getInputByName("createLog");
	    
	    assertEquals("logsusermessage", page1.getTitleText());

		//Start of user code for createLog action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)createLog.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "editAccount" action of class ViewLogsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testViewLogseditAccountAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/viewlogs/viewlogs?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ViewLogsForm");
		final HtmlTextInput user = (HtmlTextInput)form.getInputByName("user");
		final HtmlTextInput message = (HtmlTextInput)form.getInputByName("message");
	    final HtmlSubmitInput editAccount = (HtmlSubmitInput)form.getInputByName("editAccount");
	    
	    assertEquals("logsusermessage", page1.getTitleText());

		//Start of user code for editAccount action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)editAccount.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "login" action of class ViewLogsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testViewLogsloginAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/viewlogs/viewlogs?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ViewLogsForm");
		final HtmlTextInput user = (HtmlTextInput)form.getInputByName("user");
		final HtmlTextInput message = (HtmlTextInput)form.getInputByName("message");
	    final HtmlSubmitInput login = (HtmlSubmitInput)form.getInputByName("login");
	    
	    assertEquals("logsusermessage", page1.getTitleText());

		//Start of user code for login action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)login.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "reload" action of class ViewLogsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testViewLogsreloadAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/viewlogs/viewlogs?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ViewLogsForm");
		final HtmlTextInput user = (HtmlTextInput)form.getInputByName("user");
		final HtmlTextInput message = (HtmlTextInput)form.getInputByName("message");
	    final HtmlSubmitInput reload = (HtmlSubmitInput)form.getInputByName("reload");
	    
	    assertEquals("logsusermessage", page1.getTitleText());

		//Start of user code for reload action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)reload.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}