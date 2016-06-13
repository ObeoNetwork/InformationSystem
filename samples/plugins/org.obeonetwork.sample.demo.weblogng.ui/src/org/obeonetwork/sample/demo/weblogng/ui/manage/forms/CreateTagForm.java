package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>CreateTag Form</strong>
 * Scenario : Manage
 *
 */
public class CreateTagForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String name = null;

	/**
	 * Return name
	 * @return 
	 */
	 public String getName() {
		return name;
	}
	
	/**
	 * Set a value to parameter name.
	 * @param name 
	 */
	 public void setName(String name) {
		this.name = name;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name = null;
	}

// Start of user code for other methods  	
// End of user code
	
}