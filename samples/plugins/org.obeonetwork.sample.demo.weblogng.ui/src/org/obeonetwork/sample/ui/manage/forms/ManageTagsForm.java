package org.obeonetwork.sample.ui.manage.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>ManageTags Form</strong>
 * Scenario : Manage
 *
 */
public class ManageTagsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String hidden = null;
	public String create = null;
	public String update = null;
	public String add = null;
	public Collection tags = new ArrayList();		
	public String remove = null;
	public String delete = null;

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
		this.hidden = null;
		this.create = null;
		this.update = null;
		this.add = null;
		this.tags.clear();
		this.remove = null;
		this.delete = null;
	}

// Start of user code for other methods  	
// End of user code
	
}