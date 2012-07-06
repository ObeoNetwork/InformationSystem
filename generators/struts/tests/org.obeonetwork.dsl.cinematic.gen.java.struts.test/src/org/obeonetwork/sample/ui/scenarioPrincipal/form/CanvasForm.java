package org.obeonetwork.sample.ui.scenarioPrincipal.form;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

// End of user code for import

/**
 * Implementation of <strong>Canvas Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class CanvasForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String myCanvas1 = null;
	public String myCanvas2 = null;
	public String myCanvas3 = null;

	/**
	 * Return myCanvas1
	 * @return 
	 */
	 public String getMyCanvas1() {
		return myCanvas1;
	}
	
	/**
	 * Set a value to parameter myCanvas1.
	 * @param myCanvas1 
	 */
	 public void setMyCanvas1(String myCanvas1) {
		this.myCanvas1 = myCanvas1;
	}
	/**
	 * Return myCanvas2
	 * @return 
	 */
	 public String getMyCanvas2() {
		return myCanvas2;
	}
	
	/**
	 * Set a value to parameter myCanvas2.
	 * @param myCanvas2 
	 */
	 public void setMyCanvas2(String myCanvas2) {
		this.myCanvas2 = myCanvas2;
	}
	/**
	 * Return myCanvas3
	 * @return 
	 */
	 public String getMyCanvas3() {
		return myCanvas3;
	}
	
	/**
	 * Set a value to parameter myCanvas3.
	 * @param myCanvas3 
	 */
	 public void setMyCanvas3(String myCanvas3) {
		this.myCanvas3 = myCanvas3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.myCanvas1 = null;
		this.myCanvas2 = null;
		this.myCanvas3 = null;
	}

// Start of user code for other methods  	
// End of user code
	
}