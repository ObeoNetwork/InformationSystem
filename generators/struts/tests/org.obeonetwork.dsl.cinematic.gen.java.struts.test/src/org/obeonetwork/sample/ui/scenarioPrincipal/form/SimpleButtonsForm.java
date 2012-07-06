package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Simple Buttons Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class SimpleButtonsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String simpleButton1 = null;
	public String simpleButton2 = null;
	public String simpleButton3 = null;

	/**
	 * Return simpleButton1
	 * @return 
	 */
	 public String getSimpleButton1() {
		return simpleButton1;
	}
	
	/**
	 * Set a value to parameter simpleButton1.
	 * @param simpleButton1 
	 */
	 public void setSimpleButton1(String simpleButton1) {
		this.simpleButton1 = simpleButton1;
	}
	/**
	 * Return simpleButton2
	 * @return 
	 */
	 public String getSimpleButton2() {
		return simpleButton2;
	}
	
	/**
	 * Set a value to parameter simpleButton2.
	 * @param simpleButton2 
	 */
	 public void setSimpleButton2(String simpleButton2) {
		this.simpleButton2 = simpleButton2;
	}
	/**
	 * Return simpleButton3
	 * @return 
	 */
	 public String getSimpleButton3() {
		return simpleButton3;
	}
	
	/**
	 * Set a value to parameter simpleButton3.
	 * @param simpleButton3 
	 */
	 public void setSimpleButton3(String simpleButton3) {
		this.simpleButton3 = simpleButton3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.simpleButton1 = null;
		this.simpleButton2 = null;
		this.simpleButton3 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}