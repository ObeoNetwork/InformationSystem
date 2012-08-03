package org.obeonetwork.sample.ui.main.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>CreateLog Form</strong>
 * Scenario : CreateLog
 *
 */
public class CreateLogForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String title = null;
	public String content = null;

	/**
	 * Return title
	 * @return 
	 */
	 public String getTitle() {
		return title;
	}
	
	/**
	 * Set a value to parameter title.
	 * @param title 
	 */
	 public void setTitle(String title) {
		this.title = title;
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
		this.title = null;
		this.content = null;
	}

// Start of user code for other methods  	
// End of user code
	
}