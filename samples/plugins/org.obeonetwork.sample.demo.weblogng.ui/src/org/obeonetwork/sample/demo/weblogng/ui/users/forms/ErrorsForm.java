package org.obeonetwork.sample.demo.weblogng.ui.users.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Errors Form</strong>
 * Scenario : Errors
 *
 */
public class ErrorsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String message = null;

	/**
	 * Return message
	 * @return 
	 */
	 public String getMessage() {
		return message;
	}
	
	/**
	 * Set a value to parameter message.
	 * @param message 
	 */
	 public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.message = null;
	}

// Start of user code for other methods  	
// End of user code
	
}