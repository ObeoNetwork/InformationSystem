package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Text Areas Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class TextAreasForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String textArea1 = null;
	public String textArea2 = null;
	public String textArea3 = null;

	/**
	 * Return textArea1
	 * @return 
	 */
	 public String getTextArea1() {
		return textArea1;
	}
	
	/**
	 * Set a value to parameter textArea1.
	 * @param textArea1 
	 */
	 public void setTextArea1(String textArea1) {
		this.textArea1 = textArea1;
	}
	/**
	 * Return textArea2
	 * @return 
	 */
	 public String getTextArea2() {
		return textArea2;
	}
	
	/**
	 * Set a value to parameter textArea2.
	 * @param textArea2 
	 */
	 public void setTextArea2(String textArea2) {
		this.textArea2 = textArea2;
	}
	/**
	 * Return textArea3
	 * @return 
	 */
	 public String getTextArea3() {
		return textArea3;
	}
	
	/**
	 * Set a value to parameter textArea3.
	 * @param textArea3 
	 */
	 public void setTextArea3(String textArea3) {
		this.textArea3 = textArea3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.textArea1 = null;
		this.textArea2 = null;
		this.textArea3 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}