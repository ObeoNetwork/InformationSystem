package org.obeonetwork.sample.ui.main.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>ViewLogs Form</strong>
 * Scenario : ViewLogs
 *
 */
public class ViewLogsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection logs = new ArrayList();		
	public String user = null;
	public String message = null;

	/**
	 * Return logs
	 * @return 
	 */
	 public Collection getLogs() {
		return logs;
	}
	
	/**
	 * Set a value to parameter logs.
	 * @param logs 
	 */
	 public void setLogs(Collection logs) {
		this.logs = logs;
	}
	/**
	 * Return user
	 * @return 
	 */
	 public String getUser() {
		return user;
	}
	
	/**
	 * Set a value to parameter user.
	 * @param user 
	 */
	 public void setUser(String user) {
		this.user = user;
	}
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
		this.logs.clear();
		this.user = null;
		this.message = null;
	}

// Start of user code for other methods
// End of user code
	
}