package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>CreateCategory Form</strong>
 * Scenario : Manage
 *
 */
public class CreateCategoryForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String name = null;
	public String description = null;

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
	 * Return description
	 * @return 
	 */
	 public String getDescription() {
		return description;
	}
	
	/**
	 * Set a value to parameter description.
	 * @param description 
	 */
	 public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name = null;
		this.description = null;
	}

// Start of user code for other methods  	
// End of user code
	
}