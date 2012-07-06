package org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.tests.ui.scenariodefaultname.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Ecran1 Form</strong>
 * Scenario : ScenarioDefaultName
 *
 */
public class Ecran1Form extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String label1 = null;
	public String textFiel1 = null;
	public Collection combobox1Values = new ArrayList();
	public String combobox1 = null;
	public String password1 = null;
	public String checkbox1 = null;
	public String radio1 = null;
	public String slider1 = null;
	public String push1 = null;
	public String toogle1 = null;
	public String button1 = null;
	public Collection displayList1 = new ArrayList();		
	public String canvas1 = null;
	public String link1 = null;
	public String textArea = null;

	/**
	 * Return label1
	 * @return 
	 */
	 public String getLabel1() {
		return label1;
	}
	
	/**
	 * Set a value to parameter label1.
	 * @param label1 
	 */
	 public void setLabel1(String label1) {
		this.label1 = label1;
	}
	/**
	 * Return textFiel1
	 * @return 
	 */
	 public String getTextFiel1() {
		return textFiel1;
	}
	
	/**
	 * Set a value to parameter textFiel1.
	 * @param textFiel1 
	 */
	 public void setTextFiel1(String textFiel1) {
		this.textFiel1 = textFiel1;
	}
	/**
	 * Return Combobox1 combobox values
	 * @return all the Combobox1 combobox values
	 */
	public Collection getCombobox1Values() {
		return combobox1Values;
	}
	
	/**
	 * Set a values to Combobox1.combobox
	 * @param the  Combobox1 combobox values
	 */
	 public void setCombobox1Values(Collection combobox1Values) {
		this.combobox1Values = combobox1Values;
	}	

	/**
	 * Return Combobox1
	 * @return 
	 */
	 public String getCombobox1() {
		return combobox1;
	}
	
	/**
	 * Set a value to parameter Combobox1.
	 * @param Combobox1 
	 */
	 public void setCombobox1(String combobox1) {
		this.combobox1 = combobox1;
	}
	/**
	 * Return password1
	 * @return 
	 */
	 public String getPassword1() {
		return password1;
	}
	
	/**
	 * Set a value to parameter password1.
	 * @param password1 
	 */
	 public void setPassword1(String password1) {
		this.password1 = password1;
	}
	/**
	 * Return checkbox1
	 * @return 
	 */
	 public String getCheckbox1() {
		return checkbox1;
	}
	
	/**
	 * Set a value to parameter checkbox1.
	 * @param checkbox1 
	 */
	 public void setCheckbox1(String checkbox1) {
		this.checkbox1 = checkbox1;
	}
	/**
	 * Return radio1
	 * @return 
	 */
	 public String getRadio1() {
		return radio1;
	}
	
	/**
	 * Set a value to parameter radio1.
	 * @param radio1 
	 */
	 public void setRadio1(String radio1) {
		this.radio1 = radio1;
	}
	/**
	 * Return slider1
	 * @return 
	 */
	 public String getSlider1() {
		return slider1;
	}
	
	/**
	 * Set a value to parameter slider1.
	 * @param slider1 
	 */
	 public void setSlider1(String slider1) {
		this.slider1 = slider1;
	}
	/**
	 * Return push1
	 * @return 
	 */
	 public String getPush1() {
		return push1;
	}
	
	/**
	 * Set a value to parameter push1.
	 * @param push1 
	 */
	 public void setPush1(String push1) {
		this.push1 = push1;
	}
	/**
	 * Return toogle1
	 * @return 
	 */
	 public String getToogle1() {
		return toogle1;
	}
	
	/**
	 * Set a value to parameter toogle1.
	 * @param toogle1 
	 */
	 public void setToogle1(String toogle1) {
		this.toogle1 = toogle1;
	}
	/**
	 * Return button1
	 * @return 
	 */
	 public String getButton1() {
		return button1;
	}
	
	/**
	 * Set a value to parameter button1.
	 * @param button1 
	 */
	 public void setButton1(String button1) {
		this.button1 = button1;
	}
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
	 * Return canvas1
	 * @return 
	 */
	 public String getCanvas1() {
		return canvas1;
	}
	
	/**
	 * Set a value to parameter canvas1.
	 * @param canvas1 
	 */
	 public void setCanvas1(String canvas1) {
		this.canvas1 = canvas1;
	}
	/**
	 * Return link1
	 * @return 
	 */
	 public String getLink1() {
		return link1;
	}
	
	/**
	 * Set a value to parameter link1.
	 * @param link1 
	 */
	 public void setLink1(String link1) {
		this.link1 = link1;
	}
	/**
	 * Return textArea
	 * @return 
	 */
	 public String getTextArea() {
		return textArea;
	}
	
	/**
	 * Set a value to parameter textArea.
	 * @param textArea 
	 */
	 public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.label1 = null;
		this.textFiel1 = null;
		this.combobox1Values.clear();
		this.combobox1 = null;
		this.password1 = null;
		this.checkbox1 = null;
		this.radio1 = null;
		this.slider1 = null;
		this.push1 = null;
		this.toogle1 = null;
		this.button1 = null;
		this.displayList1.clear();
		this.canvas1 = null;
		this.link1 = null;
		this.textArea = null;
	}

// Start of user code for other methods
// End of user code
	
}