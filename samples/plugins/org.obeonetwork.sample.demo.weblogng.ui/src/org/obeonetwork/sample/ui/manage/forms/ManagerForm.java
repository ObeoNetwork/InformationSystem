package org.obeonetwork.sample.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Manager Form</strong>
 * Scenario : Manage
 *
 */
public class ManagerForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String screenDeleteUser = null;
	public String screenManageTags = null;
	public String screenManageComments = null;
	public String screenManageCategories = null;

	/**
	 * Return screenDeleteUser
	 * @return 
	 */
	 public String getScreenDeleteUser() {
		return screenDeleteUser;
	}
	
	/**
	 * Set a value to parameter screenDeleteUser.
	 * @param screenDeleteUser 
	 */
	 public void setScreenDeleteUser(String screenDeleteUser) {
		this.screenDeleteUser = screenDeleteUser;
	}
	/**
	 * Return screenManageTags
	 * @return 
	 */
	 public String getScreenManageTags() {
		return screenManageTags;
	}
	
	/**
	 * Set a value to parameter screenManageTags.
	 * @param screenManageTags 
	 */
	 public void setScreenManageTags(String screenManageTags) {
		this.screenManageTags = screenManageTags;
	}
	/**
	 * Return screenManageComments
	 * @return 
	 */
	 public String getScreenManageComments() {
		return screenManageComments;
	}
	
	/**
	 * Set a value to parameter screenManageComments.
	 * @param screenManageComments 
	 */
	 public void setScreenManageComments(String screenManageComments) {
		this.screenManageComments = screenManageComments;
	}
	/**
	 * Return screenManageCategories
	 * @return 
	 */
	 public String getScreenManageCategories() {
		return screenManageCategories;
	}
	
	/**
	 * Set a value to parameter screenManageCategories.
	 * @param screenManageCategories 
	 */
	 public void setScreenManageCategories(String screenManageCategories) {
		this.screenManageCategories = screenManageCategories;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.screenDeleteUser = null;
		this.screenManageTags = null;
		this.screenManageComments = null;
		this.screenManageCategories = null;
	}

// Start of user code for other methods  	
// End of user code
	
}