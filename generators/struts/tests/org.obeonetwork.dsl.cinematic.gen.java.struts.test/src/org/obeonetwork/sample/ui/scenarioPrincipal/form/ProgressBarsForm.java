package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Progress Bars Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class ProgressBarsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String progressBar1 = null;
	public String progressBar2 = null;
	public String progressBar3 = null;

	/**
	 * Return progressBar1
	 * @return 
	 */
	 public String getProgressBar1() {
		return progressBar1;
	}
	
	/**
	 * Set a value to parameter progressBar1.
	 * @param progressBar1 
	 */
	 public void setProgressBar1(String progressBar1) {
		this.progressBar1 = progressBar1;
	}
	/**
	 * Return progressBar2
	 * @return 
	 */
	 public String getProgressBar2() {
		return progressBar2;
	}
	
	/**
	 * Set a value to parameter progressBar2.
	 * @param progressBar2 
	 */
	 public void setProgressBar2(String progressBar2) {
		this.progressBar2 = progressBar2;
	}
	/**
	 * Return progressBar3
	 * @return 
	 */
	 public String getProgressBar3() {
		return progressBar3;
	}
	
	/**
	 * Set a value to parameter progressBar3.
	 * @param progressBar3 
	 */
	 public void setProgressBar3(String progressBar3) {
		this.progressBar3 = progressBar3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.progressBar1 = null;
		this.progressBar2 = null;
		this.progressBar3 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}