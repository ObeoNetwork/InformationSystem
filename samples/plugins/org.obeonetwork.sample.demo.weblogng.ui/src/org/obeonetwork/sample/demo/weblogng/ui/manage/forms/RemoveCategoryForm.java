package org.obeonetwork.sample.demo.weblogng.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>RemoveCategory Form</strong>
 * Scenario : Manage
 *
 */
public class RemoveCategoryForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection categoryDescription = new ArrayList();		
	public Collection logs = new ArrayList();		
	public String hidden = null;
	public String select = null;

	/**
	 * Return categoryDescription
	 * @return 
	 */
	 public Collection getCategoryDescription() {
		return categoryDescription;
	}
	
	/**
	 * Set a value to parameter categoryDescription.
	 * @param categoryDescription 
	 */
	 public void setCategoryDescription(Collection categoryDescription) {
		this.categoryDescription = categoryDescription;
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
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.categoryDescription.clear();
		this.logs.clear();
		this.hidden = null;
		this.select = null;
	}

// Start of user code for other methods  	
// End of user code
	
}