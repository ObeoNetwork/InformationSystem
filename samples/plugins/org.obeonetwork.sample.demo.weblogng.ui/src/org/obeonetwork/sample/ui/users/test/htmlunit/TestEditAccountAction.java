package org.obeonetwork.sample.ui.users.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>EditAccount Form</strong>
 * Scenario : editAccount
 *
 */
public class TestEditAccountAction extends TestCase {

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
	public TestEditAccountAction(String testName) {
		super(testName);
		//Start of user code for Constructor
 		//End of user code
	}
	/**
	  * Regression test for "validate" action of class EditAccountAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testEditAccountvalidateAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/editaccount/editaccount?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("EditAccountForm");
		final HtmlTextInput firstName = (HtmlTextInput)form.getInputByName("firstName");
		final HtmlTextInput email = (HtmlTextInput)form.getInputByName("email");
		final HtmlTextInput login = (HtmlTextInput)form.getInputByName("login");
		final HtmlPasswordInput password = (HtmlPasswordInput)form.getInputByName("password");
		final HtmlTextInput lastName = (HtmlTextInput)form.getInputByName("lastName");
	    final HtmlSubmitInput validate = (HtmlSubmitInput)form.getInputByName("validate");
	    
	    assertEquals("firstNameemailloginpasswordlastName", page1.getTitleText());

		//Start of user code for validate action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)validate.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}