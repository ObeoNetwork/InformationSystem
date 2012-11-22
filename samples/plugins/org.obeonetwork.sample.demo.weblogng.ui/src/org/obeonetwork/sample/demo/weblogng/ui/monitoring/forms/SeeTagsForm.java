package org.obeonetwork.sample.demo.weblogng.ui.monitoring.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>SeeTags Form</strong>
 * Scenario : Monitoring
 *
 */
public class SeeTagsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection tags = new ArrayList();		

	/**
	 * Return tags
	 * @return 
	 */
	 public Collection getTags() {
		return tags;
	}
	
	/**
	 * Set a value to parameter tags.
	 * @param tags 
	 */
	 public void setTags(Collection tags) {
		this.tags = tags;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.tags.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}