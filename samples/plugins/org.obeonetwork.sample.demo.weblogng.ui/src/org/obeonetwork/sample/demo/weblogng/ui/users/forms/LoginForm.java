package org.obeonetwork.sample.demo.weblogng.ui.users.forms;

// Start of user code for import 
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Login Form</strong>
 * Scenario : Login
 *
 */
public class LoginForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String login = null;
	public String password = null;

	/**
	 * Return login
	 * @return 
	 */
	 public String getLogin() {
		return login;
	}
	
	/**
	 * Set a value to parameter login.
	 * @param login 
	 */
	 public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Return password
	 * @return 
	 */
	 public String getPassword() {
		return password;
	}
	
	/**
	 * Set a value to parameter password.
	 * @param password 
	 */
	 public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.login = null;
		this.password = null;
	}

// Start of user code for other methods  	
// End of user code
	
}