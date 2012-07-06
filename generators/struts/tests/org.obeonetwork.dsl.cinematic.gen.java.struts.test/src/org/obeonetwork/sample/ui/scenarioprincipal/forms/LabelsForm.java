package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Labels Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class LabelsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String monLabe1l = null;
	public String monLabel2 = null;
	public String monLabel3 = null;

	/**
	 * Return monLabe1l
	 * @return 
	 */
	 public String getMonLabe1l() {
		return monLabe1l;
	}
	
	/**
	 * Set a value to parameter monLabe1l.
	 * @param monLabe1l 
	 */
	 public void setMonLabe1l(String monLabe1l) {
		this.monLabe1l = monLabe1l;
	}
	/**
	 * Return monLabel2
	 * @return 
	 */
	 public String getMonLabel2() {
		return monLabel2;
	}
	
	/**
	 * Set a value to parameter monLabel2.
	 * @param monLabel2 
	 */
	 public void setMonLabel2(String monLabel2) {
		this.monLabel2 = monLabel2;
	}
	/**
	 * Return monLabel3
	 * @return 
	 */
	 public String getMonLabel3() {
		return monLabel3;
	}
	
	/**
	 * Set a value to parameter monLabel3.
	 * @param monLabel3 
	 */
	 public void setMonLabel3(String monLabel3) {
		this.monLabel3 = monLabel3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.monLabe1l = null;
		this.monLabel2 = null;
		this.monLabel3 = null;
	}

// Start of user code for other methods
// End of user code
	
}