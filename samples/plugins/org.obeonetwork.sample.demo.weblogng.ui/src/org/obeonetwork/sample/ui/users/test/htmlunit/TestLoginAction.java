package org.obeonetwork.sample.ui.users.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>Login Form</strong>
 * Scenario : login
 *
 */
public class TestLoginAction extends TestCase {

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
	public TestLoginAction(String testName) {
		super(testName);
		//Start of user code for Constructor
 		//End of user code
	}
	/**
	  * Regression test for "validate" action of class LoginAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testLoginvalidateAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/login/login?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("LoginForm");
		final HtmlTextInput login = (HtmlTextInput)form.getInputByName("login");
		final HtmlPasswordInput password = (HtmlPasswordInput)form.getInputByName("password");
	    final HtmlSubmitInput validate = (HtmlSubmitInput)form.getInputByName("validate");
	    
	    assertEquals("loginpassword", page1.getTitleText());

		//Start of user code for validate action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)validate.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "createAccount" action of class LoginAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testLogincreateAccountAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/login/login?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("LoginForm");
		final HtmlTextInput login = (HtmlTextInput)form.getInputByName("login");
		final HtmlPasswordInput password = (HtmlPasswordInput)form.getInputByName("password");
	    final HtmlSubmitInput createAccount = (HtmlSubmitInput)form.getInputByName("createAccount");
	    
	    assertEquals("loginpassword", page1.getTitleText());

		//Start of user code for createAccount action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)createAccount.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}