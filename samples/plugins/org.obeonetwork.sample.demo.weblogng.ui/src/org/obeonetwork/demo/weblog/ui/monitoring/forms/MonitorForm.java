package org.obeonetwork.demo.weblog.ui.monitoring.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Monitor Form</strong>
 * Scenario : Monitoring
 *
 */
public class MonitorForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String viewComments = null;
	public String viewUsers = null;
	public String viewCategories = null;
	public String viewTags = null;

	/**
	 * Return viewComments
	 * @return 
	 */
	 public String getViewComments() {
		return viewComments;
	}
	
	/**
	 * Set a value to parameter viewComments.
	 * @param viewComments 
	 */
	 public void setViewComments(String viewComments) {
		this.viewComments = viewComments;
	}
	/**
	 * Return viewUsers
	 * @return 
	 */
	 public String getViewUsers() {
		return viewUsers;
	}
	
	/**
	 * Set a value to parameter viewUsers.
	 * @param viewUsers 
	 */
	 public void setViewUsers(String viewUsers) {
		this.viewUsers = viewUsers;
	}
	/**
	 * Return viewCategories
	 * @return 
	 */
	 public String getViewCategories() {
		return viewCategories;
	}
	
	/**
	 * Set a value to parameter viewCategories.
	 * @param viewCategories 
	 */
	 public void setViewCategories(String viewCategories) {
		this.viewCategories = viewCategories;
	}
	/**
	 * Return viewTags
	 * @return 
	 */
	 public String getViewTags() {
		return viewTags;
	}
	
	/**
	 * Set a value to parameter viewTags.
	 * @param viewTags 
	 */
	 public void setViewTags(String viewTags) {
		this.viewTags = viewTags;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.viewComments = null;
		this.viewUsers = null;
		this.viewCategories = null;
		this.viewTags = null;
	}

// Start of user code for other methods  	
// End of user code
	
}