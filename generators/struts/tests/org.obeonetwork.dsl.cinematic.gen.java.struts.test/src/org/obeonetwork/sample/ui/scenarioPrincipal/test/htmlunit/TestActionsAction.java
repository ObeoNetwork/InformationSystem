package org.obeonetwork.sample.ui.scenarioPrincipal.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>Actions Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class TestActionsAction extends TestCase {

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
	public TestActionsAction(String testName) {
		super(testName);
		//Start of user code for Constructor
 		//End of user code
	}
	/**
	  * Regression test for "action1" action of class ActionsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testActionsaction1Action() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenario principal/actions?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ActionsForm");
	    final HtmlSubmitInput action1 = (HtmlSubmitInput)form.getInputByName("action1");
	    
	    assertEquals("", page1.getTitleText());

		//Start of user code for action1 action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)action1.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "monAction" action of class ActionsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testActionsmonActionAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenario principal/actions?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ActionsForm");
	    final HtmlSubmitInput monAction = (HtmlSubmitInput)form.getInputByName("mon Action");
	    
	    assertEquals("", page1.getTitleText());

		//Start of user code for mon Action action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)monAction.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "MonAutreAction" action of class ActionsAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testActionsMonAutreActionAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenario principal/actions?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("ActionsForm");
	    final HtmlSubmitInput MonAutreAction = (HtmlSubmitInput)form.getInputByName("MonAutreAction");
	    
	    assertEquals("", page1.getTitleText());

		//Start of user code for MonAutreAction action
 	
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)MonAutreAction.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}