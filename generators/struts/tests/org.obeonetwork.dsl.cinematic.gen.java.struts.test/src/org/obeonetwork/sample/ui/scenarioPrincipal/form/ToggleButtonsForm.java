package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Toggle Buttons Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class ToggleButtonsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String toggleButton1 = null;
	public String toggleButton2 = null;
	public String toggleButton3 = null;

	/**
	 * Return toggleButton1
	 * @return 
	 */
	 public String getToggleButton1() {
		return toggleButton1;
	}
	
	/**
	 * Set a value to parameter toggleButton1.
	 * @param toggleButton1 
	 */
	 public void setToggleButton1(String toggleButton1) {
		this.toggleButton1 = toggleButton1;
	}
	/**
	 * Return toggleButton2
	 * @return 
	 */
	 public String getToggleButton2() {
		return toggleButton2;
	}
	
	/**
	 * Set a value to parameter toggleButton2.
	 * @param toggleButton2 
	 */
	 public void setToggleButton2(String toggleButton2) {
		this.toggleButton2 = toggleButton2;
	}
	/**
	 * Return toggleButton3
	 * @return 
	 */
	 public String getToggleButton3() {
		return toggleButton3;
	}
	
	/**
	 * Set a value to parameter toggleButton3.
	 * @param toggleButton3 
	 */
	 public void setToggleButton3(String toggleButton3) {
		this.toggleButton3 = toggleButton3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.toggleButton1 = null;
		this.toggleButton2 = null;
		this.toggleButton3 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}