package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>TextFields Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class TextFieldsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String textField1 = null;
	public String textField2 = null;
	public String textField3 = null;
	public Boolean boolean_ = Boolean.FALSE;
	public Date date = new Date();
	public Double double_ = new Double(0);
	public String mail = null;
	public String unnamed = null;

	/**
	 * Return textField1
	 * @return 
	 */
	 public String getTextField1() {
		return textField1;
	}
	
	/**
	 * Set a value to parameter textField1.
	 * @param textField1 
	 */
	 public void setTextField1(String textField1) {
		this.textField1 = textField1;
	}
	/**
	 * Return textField2
	 * @return 
	 */
	 public String getTextField2() {
		return textField2;
	}
	
	/**
	 * Set a value to parameter textField2.
	 * @param textField2 
	 */
	 public void setTextField2(String textField2) {
		this.textField2 = textField2;
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
	 * Return boolean_
	 * @return 
	 */
	 public Boolean getBoolean_() {
		return boolean_;
	}
	
	/**
	 * Set a value to parameter boolean_.
	 * @param boolean_ 
	 */
	 public void setBoolean_(Boolean boolean_) {
		this.boolean_ = boolean_;
	}
	/**
	 * Return date
	 * @return 
	 */
	 public Date getDate() {
		return date;
	}
	
	/**
	 * Set a value to parameter date.
	 * @param date 
	 */
	 public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Return double_
	 * @return 
	 */
	 public Double getDouble_() {
		return double_;
	}
	
	/**
	 * Set a value to parameter double_.
	 * @param double_ 
	 */
	 public void setDouble_(Double double_) {
		this.double_ = double_;
	}
	/**
	 * Return mail
	 * @return 
	 */
	 public String getMail() {
		return mail;
	}
	
	/**
	 * Set a value to parameter mail.
	 * @param mail 
	 */
	 public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * Return unnamed
	 * @return 
	 */
	 public String getUnnamed() {
		return unnamed;
	}
	
	/**
	 * Set a value to parameter unnamed.
	 * @param unnamed 
	 */
	 public void setUnnamed(String unnamed) {
		this.unnamed = unnamed;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.textField1 = null;
		this.textField2 = null;
		this.textField3 = null;
		this.boolean_ = Boolean.FALSE;
		this.date = new Date();
		this.double_ = new Double(0);
		this.mail = null;
		this.unnamed = null;
	}

// Start of user code for other methods
// End of user code
	
}