package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Display Lists Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class DisplayListsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection displayList1 = new ArrayList();		
	public Collection displayList2 = new ArrayList();		
	public Collection displayList3 = new ArrayList();		

	/**
	 * Return displayList1
	 * @return 
	 */
	 public Collection getDisplayList1() {
		return displayList1;
	}
	
	/**
	 * Set a value to parameter displayList1.
	 * @param displayList1 
	 */
	 public void setDisplayList1(Collection displayList1) {
		this.displayList1 = displayList1;
	}
	/**
	 * Return displayList2
	 * @return 
	 */
	 public Collection getDisplayList2() {
		return displayList2;
	}
	
	/**
	 * Set a value to parameter displayList2.
	 * @param displayList2 
	 */
	 public void setDisplayList2(Collection displayList2) {
		this.displayList2 = displayList2;
	}
	/**
	 * Return displayList3
	 * @return 
	 */
	 public Collection getDisplayList3() {
		return displayList3;
	}
	
	/**
	 * Set a value to parameter displayList3.
	 * @param displayList3 
	 */
	 public void setDisplayList3(Collection displayList3) {
		this.displayList3 = displayList3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.displayList1.clear();
		this.displayList2.clear();
		this.displayList3.clear();
	}

// Start of user code for other methods
// End of user code
	
}