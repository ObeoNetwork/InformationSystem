package org.obeonetwork.demo.weblog.ui.manage.forms;

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
	public Collection logs = new ArrayList();		
	public Collection categoryDescription = new ArrayList();		
	public String select = null;
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
		this.categoryDescription.clear();
		this.select = null;
		this.hidden = null;
	}

// Start of user code for other methods  	
// End of user code
	
}