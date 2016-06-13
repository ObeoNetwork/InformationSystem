package org.obeonetwork.sample.demo.weblogng.ui.users.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>CreateAccount Form</strong>
 * Scenario : CreateAccount
 *
 */
public class CreateAccountForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String firstName = null;
	public String lastName = null;
	public String email = null;
	public String login = null;
	public String password = null;

	/**
	 * Return firstName
	 * @return 
	 */
	 public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set a value to parameter firstName.
	 * @param firstName 
	 */
	 public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Return lastName
	 * @return 
	 */
	 public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set a value to parameter lastName.
	 * @param lastName 
	 */
	 public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Return email
	 * @return 
	 */
	 public String getEmail() {
		return email;
	}
	
	/**
	 * Set a value to parameter email.
	 * @param email 
	 */
	 public void setEmail(String email) {
		this.email = email;
	}
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
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.login = null;
		this.password = null;
	}

// Start of user code for other methods  	
// End of user code
	
}