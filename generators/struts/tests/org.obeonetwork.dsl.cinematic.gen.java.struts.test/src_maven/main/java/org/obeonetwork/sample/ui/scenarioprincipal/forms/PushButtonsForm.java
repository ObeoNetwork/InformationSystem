package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Push Buttons Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class PushButtonsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String pushButton1 = null;
	public String pushButton2 = null;
	public String pushButton3 = null;

	/**
	 * Return pushButton1
	 * @return 
	 */
	 public String getPushButton1() {
		return pushButton1;
	}
	
	/**
	 * Set a value to parameter pushButton1.
	 * @param pushButton1 
	 */
	 public void setPushButton1(String pushButton1) {
		this.pushButton1 = pushButton1;
	}
	/**
	 * Return pushButton2
	 * @return 
	 */
	 public String getPushButton2() {
		return pushButton2;
	}
	
	/**
	 * Set a value to parameter pushButton2.
	 * @param pushButton2 
	 */
	 public void setPushButton2(String pushButton2) {
		this.pushButton2 = pushButton2;
	}
	/**
	 * Return pushButton3
	 * @return 
	 */
	 public String getPushButton3() {
		return pushButton3;
	}
	
	/**
	 * Set a value to parameter pushButton3.
	 * @param pushButton3 
	 */
	 public void setPushButton3(String pushButton3) {
		this.pushButton3 = pushButton3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.pushButton1 = null;
		this.pushButton2 = null;
		this.pushButton3 = null;
	}

// Start of user code for other methods
// End of user code
	
}