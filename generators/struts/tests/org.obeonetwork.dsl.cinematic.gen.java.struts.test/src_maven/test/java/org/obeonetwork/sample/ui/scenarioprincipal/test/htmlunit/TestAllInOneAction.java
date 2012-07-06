package org.obeonetwork.sample.ui.scenarioprincipal.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>All In One Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class TestAllInOneAction extends TestCase {

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
	public TestAllInOneAction(String testName) {
		super(testName);
		//Start of user code for Constructor
		//End of user code
	}
	/**
	  * Regression test for "Action" action of class AllInOneAction
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testAllInOneActionAction() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenario principal/all in one?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("All In OneForm");
		final HtmlPasswordInput password = (HtmlPasswordInput)form.getInputByName("password");
		final HtmlCheckBoxInput check = (HtmlCheckBoxInput)form.getInputByName("check");
		final HtmlRadioButtonInput radio = (HtmlRadioButtonInput)form.getInputByName("radio");
		final HtmlTextInput textfield = (HtmlTextInput)form.getInputByName("textfield");
		final List textarea = (List)form.getTextAreasByName("textarea");
		final HtmlTextInput slider = (HtmlTextInput)form.getInputByName("slider");
		final HtmlTextInput pushbutton = (HtmlTextInput)form.getInputByName("pushbutton");
		final HtmlTextInput toggle = (HtmlTextInput)form.getInputByName("toggle");
		final HtmlTextInput button = (HtmlTextInput)form.getInputByName("button");
		final HtmlTextInput canvas = (HtmlTextInput)form.getInputByName("canvas");
		final HtmlTextInput link = (HtmlTextInput)form.getInputByName("link");
		final HtmlTextInput progressbar = (HtmlTextInput)form.getInputByName("progressbar");
	    final HtmlSubmitInput Action = (HtmlSubmitInput)form.getInputByName("Action");
	    
	    assertEquals("ComboPasswordCheckRadioDisplayTextfieldTextareaLabelSliderPushbuttonToggleButtonCanvasLinkProgressbar", page1.getTitleText());

		//Start of user code for Action action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)Action.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}