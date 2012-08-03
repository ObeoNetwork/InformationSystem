package org.obeonetwork.sample.ui.search.forms;

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
	public Collection logs = new ArrayList();		
	public String logHeader = null;
	public Collection comments = new ArrayList();		
	public String searchField = null;
	public String commentHeader = null;

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
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.logs.clear();
		this.logHeader = null;
		this.comments.clear();
		this.searchField = null;
		this.commentHeader = null;
	}

// Start of user code for other methods  	
// End of user code
	
}