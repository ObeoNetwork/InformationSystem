package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>Ecran2 Form</strong>
 * Scenario : ScenarioDefaultName
 *
 */
public class TestEcran2Action extends TestCase {

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
	public TestEcran2Action(String testName) {
		super(testName);
		//Start of user code for Constructor
		//End of user code
	}
	/**
	  * Regression test for "Action2" action of class Ecran2Action
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testEcran2Action2Action() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenariodefaultname/ecran2?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("Ecran2Form");
	    final HtmlSubmitInput Action2 = (HtmlSubmitInput)form.getInputByName("Action2");
	    
	    assertEquals("Table2", page1.getTitleText());

		//Start of user code for Action2 action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)Action2.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}