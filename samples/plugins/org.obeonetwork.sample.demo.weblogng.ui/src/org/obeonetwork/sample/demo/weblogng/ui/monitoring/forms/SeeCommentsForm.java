package org.obeonetwork.sample.demo.weblogng.ui.monitoring.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>SeeComments Form</strong>
 * Scenario : Monitoring
 *
 */
public class SeeCommentsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection comments = new ArrayList();		

	/**
	 * Return comments
	 * @return 
	 */
	 public Collection getComments() {
		return comments;
	}
	
	/**
	 * Set a value to parameter comments.
	 * @param comments 
	 */
	 public void setComments(Collection comments) {
		this.comments = comments;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.comments.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}