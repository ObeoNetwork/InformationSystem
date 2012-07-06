package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>All In One Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class AllInOneForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public Collection comboValues = new ArrayList();
	public String combo = null;
	public String password = null;
	public String check = null;
	public String radio = null;
	public Collection display = new ArrayList();		
	public String textfield = null;
	public String textarea = null;
	public String label = null;
	public String slider = null;
	public String pushbutton = null;
	public String toggle = null;
	public String button = null;
	public String canvas = null;
	public String link = null;
	public String progressbar = null;

	/**
	 * Return Combo combobox values
	 * @return all the Combo combobox values
	 */
	public Collection getComboValues() {
		return comboValues;
	}
	
	/**
	 * Set a values to Combo.combobox
	 * @param the  Combo combobox values
	 */
	 public void setComboValues(Collection comboValues) {
		this.comboValues = comboValues;
	}	

	/**
	 * Return Combo
	 * @return 
	 */
	 public String getCombo() {
		return combo;
	}
	
	/**
	 * Set a value to parameter Combo.
	 * @param Combo 
	 */
	 public void setCombo(String combo) {
		this.combo = combo;
	}
	/**
	 * Return password
	 * @return 
	 */
	 public String getPassword() {
		return password;
	}
	
	/**
	 * Set a value to parameter password.
	 * @param password 
	 */
	 public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Return check
	 * @return 
	 */
	 public String getCheck() {
		return check;
	}
	
	/**
	 * Set a value to parameter check.
	 * @param check 
	 */
	 public void setCheck(String check) {
		this.check = check;
	}
	/**
	 * Return radio
	 * @return 
	 */
	 public String getRadio() {
		return radio;
	}
	
	/**
	 * Set a value to parameter radio.
	 * @param radio 
	 */
	 public void setRadio(String radio) {
		this.radio = radio;
	}
	/**
	 * Return display
	 * @return 
	 */
	 public Collection getDisplay() {
		return display;
	}
	
	/**
	 * Set a value to parameter display.
	 * @param display 
	 */
	 public void setDisplay(Collection display) {
		this.display = display;
	}
	/**
	 * Return textfield
	 * @return 
	 */
	 public String getTextfield() {
		return textfield;
	}
	
	/**
	 * Set a value to parameter textfield.
	 * @param textfield 
	 */
	 public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	/**
	 * Return textarea
	 * @return 
	 */
	 public String getTextarea() {
		return textarea;
	}
	
	/**
	 * Set a value to parameter textarea.
	 * @param textarea 
	 */
	 public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
	/**
	 * Return label
	 * @return 
	 */
	 public String getLabel() {
		return label;
	}
	
	/**
	 * Set a value to parameter label.
	 * @param label 
	 */
	 public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * Return slider
	 * @return 
	 */
	 public String getSlider() {
		return slider;
	}
	
	/**
	 * Set a value to parameter slider.
	 * @param slider 
	 */
	 public void setSlider(String slider) {
		this.slider = slider;
	}
	/**
	 * Return pushbutton
	 * @return 
	 */
	 public String getPushbutton() {
		return pushbutton;
	}
	
	/**
	 * Set a value to parameter pushbutton.
	 * @param pushbutton 
	 */
	 public void setPushbutton(String pushbutton) {
		this.pushbutton = pushbutton;
	}
	/**
	 * Return toggle
	 * @return 
	 */
	 public String getToggle() {
		return toggle;
	}
	
	/**
	 * Set a value to parameter toggle.
	 * @param toggle 
	 */
	 public void setToggle(String toggle) {
		this.toggle = toggle;
	}
	/**
	 * Return button
	 * @return 
	 */
	 public String getButton() {
		return button;
	}
	
	/**
	 * Set a value to parameter button.
	 * @param button 
	 */
	 public void setButton(String button) {
		this.button = button;
	}
	/**
	 * Return canvas
	 * @return 
	 */
	 public String getCanvas() {
		return canvas;
	}
	
	/**
	 * Set a value to parameter canvas.
	 * @param canvas 
	 */
	 public void setCanvas(String canvas) {
		this.canvas = canvas;
	}
	/**
	 * Return link
	 * @return 
	 */
	 public String getLink() {
		return link;
	}
	
	/**
	 * Set a value to parameter link.
	 * @param link 
	 */
	 public void setLink(String link) {
		this.link = link;
	}
	/**
	 * Return progressbar
	 * @return 
	 */
	 public String getProgressbar() {
		return progressbar;
	}
	
	/**
	 * Set a value to parameter progressbar.
	 * @param progressbar 
	 */
	 public void setProgressbar(String progressbar) {
		this.progressbar = progressbar;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.comboValues.clear();
		this.combo = null;
		this.password = null;
		this.check = null;
		this.radio = null;
		this.display.clear();
		this.textfield = null;
		this.textarea = null;
		this.label = null;
		this.slider = null;
		this.pushbutton = null;
		this.toggle = null;
		this.button = null;
		this.canvas = null;
		this.link = null;
		this.progressbar = null;
	}

// Start of user code for other methods
// End of user code
	
}