package org.obeonetwork.demo.weblog.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>ManageCategories Form</strong>
 * Scenario : Manage
 *
 */
public class ManageCategoriesForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String remove = null;
	public String update = null;
	public Collection categories = new ArrayList();		
	public String create = null;
	public String add = null;
	public String hidden = null;
	public String delete = null;

	/**
	 * Return remove
	 * @return 
	 */
	 public String getRemove() {
		return remove;
	}
	
	/**
	 * Set a value to parameter remove.
	 * @param remove 
	 */
	 public void setRemove(String remove) {
		this.remove = remove;
	}
	/**
	 * Return update
	 * @return 
	 */
	 public String getUpdate() {
		return update;
	}
	
	/**
	 * Set a value to parameter update.
	 * @param update 
	 */
	 public void setUpdate(String update) {
		this.update = update;
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
	 * Return create
	 * @return 
	 */
	 public String getCreate() {
		return create;
	}
	
	/**
	 * Set a value to parameter create.
	 * @param create 
	 */
	 public void setCreate(String create) {
		this.create = create;
	}
	/**
	 * Return add
	 * @return 
	 */
	 public String getAdd() {
		return add;
	}
	
	/**
	 * Set a value to parameter add.
	 * @param add 
	 */
	 public void setAdd(String add) {
		this.add = add;
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
		this.remove = null;
		this.update = null;
		this.categories.clear();
		this.create = null;
		this.add = null;
		this.hidden = null;
		this.delete = null;
	}

// Start of user code for other methods  	
// End of user code
	
}