package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Combo Boxes Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class ComboBoxesForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection comboBox1Values = new ArrayList();
	public String comboBox1 = null;
	public Collection comboBox2Values = new ArrayList();
	public String comboBox2 = null;
	public Collection comboBox3Values = new ArrayList();
	public String comboBox3 = null;

	/**
	 * Return comboBox1 combobox values
	 * @return all the comboBox1 combobox values
	 */
	public Collection getComboBox1Values() {
		return comboBox1Values;
	}
	
	/**
	 * Set a values to comboBox1.combobox
	 * @param the  comboBox1 combobox values
	 */
	 public void setComboBox1Values(Collection comboBox1Values) {
		this.comboBox1Values = comboBox1Values;
	}	

	/**
	 * Return comboBox1
	 * @return 
	 */
	 public String getComboBox1() {
		return comboBox1;
	}
	
	/**
	 * Set a value to parameter comboBox1.
	 * @param comboBox1 
	 */
	 public void setComboBox1(String comboBox1) {
		this.comboBox1 = comboBox1;
	}
	/**
	 * Return combo Box2 combobox values
	 * @return all the combo Box2 combobox values
	 */
	public Collection getComboBox2Values() {
		return comboBox2Values;
	}
	
	/**
	 * Set a values to combo Box2.combobox
	 * @param the  combo Box2 combobox values
	 */
	 public void setComboBox2Values(Collection comboBox2Values) {
		this.comboBox2Values = comboBox2Values;
	}	

	/**
	 * Return combo Box2
	 * @return 
	 */
	 public String getComboBox2() {
		return comboBox2;
	}
	
	/**
	 * Set a value to parameter combo Box2.
	 * @param combo Box2 
	 */
	 public void setComboBox2(String comboBox2) {
		this.comboBox2 = comboBox2;
	}
	/**
	 * Return ComboBox3 combobox values
	 * @return all the ComboBox3 combobox values
	 */
	public Collection getComboBox3Values() {
		return comboBox3Values;
	}
	
	/**
	 * Set a values to ComboBox3.combobox
	 * @param the  ComboBox3 combobox values
	 */
	 public void setComboBox3Values(Collection comboBox3Values) {
		this.comboBox3Values = comboBox3Values;
	}	

	/**
	 * Return ComboBox3
	 * @return 
	 */
	 public String getComboBox3() {
		return comboBox3;
	}
	
	/**
	 * Set a value to parameter ComboBox3.
	 * @param ComboBox3 
	 */
	 public void setComboBox3(String comboBox3) {
		this.comboBox3 = comboBox3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.comboBox1Values.clear();
		this.comboBox1 = null;
		this.comboBox2Values.clear();
		this.comboBox2 = null;
		this.comboBox3Values.clear();
		this.comboBox3 = null;
	}

// Start of user code for other methods
// End of user code
	
}