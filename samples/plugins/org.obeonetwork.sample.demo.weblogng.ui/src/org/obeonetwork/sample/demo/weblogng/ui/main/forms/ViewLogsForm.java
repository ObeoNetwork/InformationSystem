package org.obeonetwork.sample.demo.weblogng.ui.main.forms;

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
	public String message = null;
	public String user = null;
	public String comments = null;
	public Collection categories = new ArrayList();		
	public Collection tags = new ArrayList();		
	public String hidden = null;

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
	 * Return comments
	 * @return 
	 */
	 public String getComments() {
		return comments;
	}
	
	/**
	 * Set a value to parameter comments.
	 * @param comments 
	 */
	 public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * Return categories
	 * @return 
	 */
	 public Collection getCategories() {
		return categories;
	}
	
	/**
	 * Set a value to parameter categories.
	 * @param categories 
	 */
	 public void setCategories(Collection categories) {
		this.categories = categories;
	}
	/**
	 * Return tags
	 * @return 
	 */
	 public Collection getTags() {
		return tags;
	}
	
	/**
	 * Set a value to parameter tags.
	 * @param tags 
	 */
	 public void setTags(Collection tags) {
		this.tags = tags;
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
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.logs.clear();
		this.message = null;
		this.user = null;
		this.comments = null;
		this.categories.clear();
		this.tags.clear();
		this.hidden = null;
	}

// Start of user code for other methods  	
// End of user code
	
}