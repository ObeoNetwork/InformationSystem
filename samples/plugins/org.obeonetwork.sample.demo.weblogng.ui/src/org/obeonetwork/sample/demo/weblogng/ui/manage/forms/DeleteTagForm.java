package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>DeleteTag Form</strong>
 * Scenario : Manage
 *
 */
public class DeleteTagForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection tagDescription = new ArrayList();		

	/**
	 * Return tagDescription
	 * @return 
	 */
	 public Collection getTagDescription() {
		return tagDescription;
	}
	
	/**
	 * Set a value to parameter tagDescription.
	 * @param tagDescription 
	 */
	 public void setTagDescription(Collection tagDescription) {
		this.tagDescription = tagDescription;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.tagDescription.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}