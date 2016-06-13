package org.obeonetwork.sample.demo.weblogng.ui.search.forms;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Search Form</strong>
 * Scenario : Search
 *
 */
public class SearchForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String searchField = null;
	public String logHeader = null;
	public Collection logs = new ArrayList();		
	public String commentHeader = null;
	public Collection comments = new ArrayList();		

	/**
	 * Return searchField
	 * @return 
	 */
	 public String getSearchField() {
		return searchField;
	}
	
	/**
	 * Set a value to parameter searchField.
	 * @param searchField 
	 */
	 public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	/**
	 * Return logHeader
	 * @return 
	 */
	 public String getLogHeader() {
		return logHeader;
	}
	
	/**
	 * Set a value to parameter logHeader.
	 * @param logHeader 
	 */
	 public void setLogHeader(String logHeader) {
		this.logHeader = logHeader;
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
	 * Return commentHeader
	 * @return 
	 */
	 public String getCommentHeader() {
		return commentHeader;
	}
	
	/**
	 * Set a value to parameter commentHeader.
	 * @param commentHeader 
	 */
	 public void setCommentHeader(String commentHeader) {
		this.commentHeader = commentHeader;
	}
	/**
	 * Return comments
	 * @return 
	 */
	 public Collection getComments() {
		return comments;
	}
	
	/**
	 * Set a value to parameter comments.
	 * @param comments 
	 */
	 public void setComments(Collection comments) {
		this.comments = comments;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.searchField = null;
		this.logHeader = null;
		this.logs.clear();
		this.commentHeader = null;
		this.comments.clear();
	}

// Start of user code for other methods  	
// End of user code
	
}