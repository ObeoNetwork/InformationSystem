package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Ecran2 Form</strong>
 * Scenario : ScenarioDefaultName
 *
 */
public class Ecran2Form extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection table2 = new ArrayList();		

	/**
	 * Return table2
	 * @return 
	 */
	 public Collection getTable2() {
		return table2;
	}
	
	/**
	 * Set a value to parameter table2.
	 * @param table2 
	 */
	 public void setTable2(Collection table2) {
		this.table2 = table2;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.table2.clear();
	}

// Start of user code for other methods
// End of user code
	
}