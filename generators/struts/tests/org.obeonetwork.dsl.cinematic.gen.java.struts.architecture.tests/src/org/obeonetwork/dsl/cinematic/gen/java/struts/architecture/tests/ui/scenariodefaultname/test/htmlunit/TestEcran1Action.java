package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.test.htmlunit;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import junit.framework.TestCase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * HtmlUnit testing for <strong>Ecran1 Form</strong>
 * Scenario : ScenarioDefaultName
 *
 */
public class TestEcran1Action extends TestCase {

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
	public TestEcran1Action(String testName) {
		super(testName);
		//Start of user code for Constructor
		//End of user code
	}
	/**
	  * Regression test for "Action1" action of class Ecran1Action
	  * @param Nothing
	  * @return Nothing
	  * @throws Exception
	  */
	public void testEcran1Action1Action() throws Exception {
	    final WebClient webClient = new WebClient();
	    
	    ResourceBundle r = ResourceBundle.getBundle("tests");
	    final URL url = new URL(r.getString("fr.website.url") + "/pages/scenariodefaultname/ecran1?event=init");
	    final HtmlPage page1 = (HtmlPage)webClient.getPage(url);
	    final HtmlForm form = page1.getFormByName("Ecran1Form");
		final HtmlTextInput textFiel1 = (HtmlTextInput)form.getInputByName("textFiel1");
		final HtmlPasswordInput password1 = (HtmlPasswordInput)form.getInputByName("password1");
		final HtmlCheckBoxInput checkbox1 = (HtmlCheckBoxInput)form.getInputByName("checkbox1");
		final HtmlRadioButtonInput radio1 = (HtmlRadioButtonInput)form.getInputByName("radio1");
		final HtmlTextInput slider1 = (HtmlTextInput)form.getInputByName("slider1");
		final HtmlTextInput push1 = (HtmlTextInput)form.getInputByName("push1");
		final HtmlTextInput toogle1 = (HtmlTextInput)form.getInputByName("toogle1");
		final HtmlTextInput button1 = (HtmlTextInput)form.getInputByName("button1");
		final HtmlTextInput canvas1 = (HtmlTextInput)form.getInputByName("canvas1");
		final HtmlTextInput link1 = (HtmlTextInput)form.getInputByName("link1");
		final List textArea = (List)form.getTextAreasByName("textArea");
	    final HtmlSubmitInput Action1 = (HtmlSubmitInput)form.getInputByName("Action1");
	    
	    assertEquals("Label1TextFiel1Combobox1Password1Checkbox1Radio1Slider1Push1Toogle1Button1DisplayList1Canvas1Link1TextArea", page1.getTitleText());

		//Start of user code for Action1 action
	    
	    //TODO : initialize form here
	    
	    //Subit the form and get the result page
	    final HtmlPage page2 = (HtmlPage)Action1.click();

	    //TODO : validate resulting page
	    
		//End of user code
	}
	//Start of user code for other tests
	//End of user code
}