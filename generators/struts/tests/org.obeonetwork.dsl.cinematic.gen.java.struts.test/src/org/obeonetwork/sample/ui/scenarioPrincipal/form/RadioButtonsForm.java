package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Radio Buttons Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class RadioButtonsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String radioButton1 = null;
	public String radioButton2 = null;
	public String radioButton3 = null;
	public String radioButton11 = null;

	/**
	 * Return radioButton1
	 * @return 
	 */
	 public String getRadioButton1() {
		return radioButton1;
	}
	
	/**
	 * Set a value to parameter radioButton1.
	 * @param radioButton1 
	 */
	 public void setRadioButton1(String radioButton1) {
		this.radioButton1 = radioButton1;
	}
	/**
	 * Return radioButton2
	 * @return 
	 */
	 public String getRadioButton2() {
		return radioButton2;
	}
	
	/**
	 * Set a value to parameter radioButton2.
	 * @param radioButton2 
	 */
	 public void setRadioButton2(String radioButton2) {
		this.radioButton2 = radioButton2;
	}
	/**
	 * Return radioButton3
	 * @return 
	 */
	 public String getRadioButton3() {
		return radioButton3;
	}
	
	/**
	 * Set a value to parameter radioButton3.
	 * @param radioButton3 
	 */
	 public void setRadioButton3(String radioButton3) {
		this.radioButton3 = radioButton3;
	}
	/**
	 * Return radioButton11
	 * @return 
	 */
	 public String getRadioButton11() {
		return radioButton11;
	}
	
	/**
	 * Set a value to parameter radioButton11.
	 * @param radioButton11 
	 */
	 public void setRadioButton11(String radioButton11) {
		this.radioButton11 = radioButton11;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.radioButton1 = null;
		this.radioButton2 = null;
		this.radioButton3 = null;
		this.radioButton11 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}