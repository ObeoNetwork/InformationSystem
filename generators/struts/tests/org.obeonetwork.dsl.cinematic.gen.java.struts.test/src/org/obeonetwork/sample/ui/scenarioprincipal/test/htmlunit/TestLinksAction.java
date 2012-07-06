package org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>Links Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class TestLinksAction extends TestCase {

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
	public TestLinksAction(String testName) {
		super(testName);
		//Start of user code for Constructor
		//End of user code
	}
	/**
	  * Regression test for "anAction" action of class LinksAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testLinksanActionAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenario principal/links?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("LinksForm");
		final HtmlTextInput myLink1 = (HtmlTextInput)form.getInputByName("myLink1");
		final HtmlTextInput myLink2 = (HtmlTextInput)form.getInputByName("myLink2");
		final HtmlTextInput myLink3 = (HtmlTextInput)form.getInputByName("myLink3");
		final HtmlTextInput anActionLink = (HtmlTextInput)form.getInputByName("anActionLink");
		final HtmlTextInput anActionLink1 = (HtmlTextInput)form.getInputByName("anActionLink1");
		final HtmlTextInput anotherActionLink = (HtmlTextInput)form.getInputByName("anotherActionLink");
		final HtmlTextInput allActionsLink = (HtmlTextInput)form.getInputByName("allActionsLink");
	    final HtmlSubmitInput anAction = (HtmlSubmitInput)form.getInputByName("anAction");
	    
	    assertEquals("myLink1my link2MyLink3anActionLinkanActionLinkanotherActionLinkallActionsLink", page1.getTitleText());

		//Start of user code for anAction action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)anAction.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	/**
	  * Regression test for "anotherAction" action of class LinksAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testLinksanotherActionAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenario principal/links?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("LinksForm");
		final HtmlTextInput myLink1 = (HtmlTextInput)form.getInputByName("myLink1");
		final HtmlTextInput myLink2 = (HtmlTextInput)form.getInputByName("myLink2");
		final HtmlTextInput myLink3 = (HtmlTextInput)form.getInputByName("myLink3");
		final HtmlTextInput anActionLink = (HtmlTextInput)form.getInputByName("anActionLink");
		final HtmlTextInput anActionLink1 = (HtmlTextInput)form.getInputByName("anActionLink1");
		final HtmlTextInput anotherActionLink = (HtmlTextInput)form.getInputByName("anotherActionLink");
		final HtmlTextInput allActionsLink = (HtmlTextInput)form.getInputByName("allActionsLink");
	    final HtmlSubmitInput anotherAction = (HtmlSubmitInput)form.getInputByName("anotherAction");
	    
	    assertEquals("myLink1my link2MyLink3anActionLinkanActionLinkanotherActionLinkallActionsLink", page1.getTitleText());

		//Start of user code for anotherAction action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)anotherAction.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}