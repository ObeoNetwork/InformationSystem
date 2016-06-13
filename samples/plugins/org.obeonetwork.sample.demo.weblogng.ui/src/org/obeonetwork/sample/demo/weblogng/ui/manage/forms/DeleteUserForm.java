package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>DeleteUser Form</strong>
 * Scenario : Manage
 *
 */
public class DeleteUserForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection users = new ArrayList();		
	public String hidden = null;
	public String delete = null;

	/**
	 * Return users
	 * @return 
	 */
	 public Collection getUsers() {
		return users;
	}
	
	/**
	 * Set a value to parameter users.
	 * @param users 
	 */
	 public void setUsers(Collection users) {
		this.users = users;
	}
	/**
	 * Return hidden
	 * @return 
	 */
	 public String getHidden() {
		return hidden;
	}
	
	/**
	 * Set a value to parameter hidden.
	 * @param hidden 
	 */
	 public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	/**
	 * Return delete
	 * @return 
	 */
	 public String getDelete() {
		return delete;
	}
	
	/**
	 * Set a value to parameter delete.
	 * @param delete 
	 */
	 public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.users.clear();
		this.hidden = null;
		this.delete = null;
	}

// Start of user code for other methods  	
// End of user code
	
}