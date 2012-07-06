package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Passwords Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class PasswordsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String passWord1 = null;
	public String passWord2 = null;
	public String passWord3 = null;

	/**
	 * Return passWord1
	 * @return 
	 */
	 public String getPassWord1() {
		return passWord1;
	}
	
	/**
	 * Set a value to parameter passWord1.
	 * @param passWord1 
	 */
	 public void setPassWord1(String passWord1) {
		this.passWord1 = passWord1;
	}
	/**
	 * Return passWord2
	 * @return 
	 */
	 public String getPassWord2() {
		return passWord2;
	}
	
	/**
	 * Set a value to parameter passWord2.
	 * @param passWord2 
	 */
	 public void setPassWord2(String passWord2) {
		this.passWord2 = passWord2;
	}
	/**
	 * Return passWord3
	 * @return 
	 */
	 public String getPassWord3() {
		return passWord3;
	}
	
	/**
	 * Set a value to parameter passWord3.
	 * @param passWord3 
	 */
	 public void setPassWord3(String passWord3) {
		this.passWord3 = passWord3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.passWord1 = null;
		this.passWord2 = null;
		this.passWord3 = null;
	}

// Start of user code for other methods
// End of user code
	
}