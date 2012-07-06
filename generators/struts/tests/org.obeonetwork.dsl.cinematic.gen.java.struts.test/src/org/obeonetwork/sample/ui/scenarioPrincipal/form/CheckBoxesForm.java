package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Check Boxes Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class CheckBoxesForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String checkBox1 = null;
	public String checkBox2 = null;
	public String checkBox3 = null;

	/**
	 * Return checkBox1
	 * @return 
	 */
	 public String getCheckBox1() {
		return checkBox1;
	}
	
	/**
	 * Set a value to parameter checkBox1.
	 * @param checkBox1 
	 */
	 public void setCheckBox1(String checkBox1) {
		this.checkBox1 = checkBox1;
	}
	/**
	 * Return checkBox2
	 * @return 
	 */
	 public String getCheckBox2() {
		return checkBox2;
	}
	
	/**
	 * Set a value to parameter checkBox2.
	 * @param checkBox2 
	 */
	 public void setCheckBox2(String checkBox2) {
		this.checkBox2 = checkBox2;
	}
	/**
	 * Return checkBox3
	 * @return 
	 */
	 public String getCheckBox3() {
		return checkBox3;
	}
	
	/**
	 * Set a value to parameter checkBox3.
	 * @param checkBox3 
	 */
	 public void setCheckBox3(String checkBox3) {
		this.checkBox3 = checkBox3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.checkBox1 = null;
		this.checkBox2 = null;
		this.checkBox3 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}