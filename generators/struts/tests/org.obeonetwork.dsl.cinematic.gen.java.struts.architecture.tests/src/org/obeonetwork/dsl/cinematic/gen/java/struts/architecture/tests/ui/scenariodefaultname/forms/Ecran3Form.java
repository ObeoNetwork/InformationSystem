package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Ecran3 Form</strong>
 * Scenario : ScenarioDefaultName
 *
 */
public class Ecran3Form extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection table3 = new ArrayList();		
	public String textField3 = null;

	/**
	 * Return table3
	 * @return 
	 */
	 public Collection getTable3() {
		return table3;
	}
	
	/**
	 * Set a value to parameter table3.
	 * @param table3 
	 */
	 public void setTable3(Collection table3) {
		this.table3 = table3;
	}
	/**
	 * Return textField3
	 * @return 
	 */
	 public String getTextField3() {
		return textField3;
	}
	
	/**
	 * Set a value to parameter textField3.
	 * @param textField3 
	 */
	 public void setTextField3(String textField3) {
		this.textField3 = textField3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.table3.clear();
		this.textField3 = null;
	}

// Start of user code for other methods
// End of user code
	
}