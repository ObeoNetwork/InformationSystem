package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>UpdateComment Form</strong>
 * Scenario : Manage
 *
 */
public class UpdateCommentForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String name = null;
	public String email = null;
	public String website = null;
	public String content = null;

	/**
	 * Return name
	 * @return 
	 */
	 public String getName() {
		return name;
	}
	
	/**
	 * Set a value to parameter name.
	 * @param name 
	 */
	 public void setName(String name) {
		this.name = name;
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
	 * Return website
	 * @return 
	 */
	 public String getWebsite() {
		return website;
	}
	
	/**
	 * Set a value to parameter website.
	 * @param website 
	 */
	 public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * Return content
	 * @return 
	 */
	 public String getContent() {
		return content;
	}
	
	/**
	 * Set a value to parameter content.
	 * @param content 
	 */
	 public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name = null;
		this.email = null;
		this.website = null;
		this.content = null;
	}

// Start of user code for other methods  	
// End of user code
	
}