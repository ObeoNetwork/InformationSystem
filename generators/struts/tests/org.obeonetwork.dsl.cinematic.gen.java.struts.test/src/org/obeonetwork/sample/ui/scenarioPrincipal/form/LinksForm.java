package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Links Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class LinksForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String myLink1 = null;
	public String myLink2 = null;
	public String myLink3 = null;
	public String anActionLink = null;
	public String anActionLink1 = null;
	public String anotherActionLink = null;
	public String allActionsLink = null;

	/**
	 * Return myLink1
	 * @return 
	 */
	 public String getMyLink1() {
		return myLink1;
	}
	
	/**
	 * Set a value to parameter myLink1.
	 * @param myLink1 
	 */
	 public void setMyLink1(String myLink1) {
		this.myLink1 = myLink1;
	}
	/**
	 * Return myLink2
	 * @return 
	 */
	 public String getMyLink2() {
		return myLink2;
	}
	
	/**
	 * Set a value to parameter myLink2.
	 * @param myLink2 
	 */
	 public void setMyLink2(String myLink2) {
		this.myLink2 = myLink2;
	}
	/**
	 * Return myLink3
	 * @return 
	 */
	 public String getMyLink3() {
		return myLink3;
	}
	
	/**
	 * Set a value to parameter myLink3.
	 * @param myLink3 
	 */
	 public void setMyLink3(String myLink3) {
		this.myLink3 = myLink3;
	}
	/**
	 * Return anActionLink
	 * @return 
	 */
	 public String getAnActionLink() {
		return anActionLink;
	}
	
	/**
	 * Set a value to parameter anActionLink.
	 * @param anActionLink 
	 */
	 public void setAnActionLink(String anActionLink) {
		this.anActionLink = anActionLink;
	}
	/**
	 * Return anActionLink1
	 * @return 
	 */
	 public String getAnActionLink1() {
		return anActionLink1;
	}
	
	/**
	 * Set a value to parameter anActionLink1.
	 * @param anActionLink1 
	 */
	 public void setAnActionLink1(String anActionLink1) {
		this.anActionLink1 = anActionLink1;
	}
	/**
	 * Return anotherActionLink
	 * @return 
	 */
	 public String getAnotherActionLink() {
		return anotherActionLink;
	}
	
	/**
	 * Set a value to parameter anotherActionLink.
	 * @param anotherActionLink 
	 */
	 public void setAnotherActionLink(String anotherActionLink) {
		this.anotherActionLink = anotherActionLink;
	}
	/**
	 * Return allActionsLink
	 * @return 
	 */
	 public String getAllActionsLink() {
		return allActionsLink;
	}
	
	/**
	 * Set a value to parameter allActionsLink.
	 * @param allActionsLink 
	 */
	 public void setAllActionsLink(String allActionsLink) {
		this.allActionsLink = allActionsLink;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.myLink1 = null;
		this.myLink2 = null;
		this.myLink3 = null;
		this.anActionLink = null;
		this.anActionLink1 = null;
		this.anotherActionLink = null;
		this.allActionsLink = null;
	}

// Start of user code for other methods  	
// End of user code
	
}