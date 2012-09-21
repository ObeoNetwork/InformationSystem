package org.obeonetwork.demo.weblog.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>RemoveTag Form</strong>
 * Scenario : Manage
 *
 */
public class RemoveTagForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String hidden = null;
	public String select = null;
	public Collection tagDescription = new ArrayList();		
	public Collection logs = new ArrayList();		

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
	 * Return select
	 * @return 
	 */
	 public String getSelect() {
		return select;
	}
	
	/**
	 * Set a value to parameter select.
	 * @param select 
	 */
	 public void setSelect(String select) {
		this.select = select;
	}
	/**
	 * Return tagDescription
	 * @return 
	 */
	 public Collection getTagDescription() {
		return tagDescription;
	}
	
	/**
	 * Set a value to parameter tagDescription.
	 * @param tagDescription 
	 */
	 public void setTagDescription(Collection tagDescription) {
		this.tagDescription = tagDescription;
	}
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
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.hidden = null;
		this.select = null;
		this.tagDescription.clear();
		this.logs.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}