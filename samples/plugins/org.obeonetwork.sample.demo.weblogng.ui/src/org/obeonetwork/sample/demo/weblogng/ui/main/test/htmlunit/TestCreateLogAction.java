package org.obeonetwork.sample.demo.weblogng.ui.main.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>CreateLog Form</strong>
 * Scenario : createLog
 *
 */
public class TestCreateLogAction extends TestCase {

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
	public TestCreateLogAction(String testName) {
		super(testName);
		//Start of user code for Constructor
 		//End of user code
	}
	/**
	  * Regression test for "validate" action of class CreateLogAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testCreateLogvalidateAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/createlog/createlog?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("CreateLogForm");
		final HtmlTextInput title = (HtmlTextInput)form.getInputByName("title");
		final List content = (List)form.getTextAreasByName("content");
	    final HtmlSubmitInput validate = (HtmlSubmitInput)form.getInputByName("validate");
	    
	    assertEquals("titlecontent", page1.getTitleText());

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