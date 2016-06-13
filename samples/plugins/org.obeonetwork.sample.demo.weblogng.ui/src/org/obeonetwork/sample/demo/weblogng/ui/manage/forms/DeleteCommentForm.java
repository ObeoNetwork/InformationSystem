package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>DeleteComment Form</strong>
 * Scenario : Manage
 *
 */
public class DeleteCommentForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection commentDescription = new ArrayList();		

	/**
	 * Return commentDescription
	 * @return 
	 */
	 public Collection getCommentDescription() {
		return commentDescription;
	}
	
	/**
	 * Set a value to parameter commentDescription.
	 * @param commentDescription 
	 */
	 public void setCommentDescription(Collection commentDescription) {
		this.commentDescription = commentDescription;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.commentDescription.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}