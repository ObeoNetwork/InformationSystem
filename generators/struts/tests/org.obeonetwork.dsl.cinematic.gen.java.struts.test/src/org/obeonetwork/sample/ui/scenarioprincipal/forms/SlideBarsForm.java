package org.obeonetwork.sample.ui.scenarioprincipal.forms;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;



// End of user code for import

/**
 * Implementation of <strong>Slide Bars Form</strong>
 * Scenario : Scenario Principal
 *
 */
public class SlideBarsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
	public String sliderBar1 = null;
	public String sliderBar2 = null;
	public String sliderBar3 = null;

	/**
	 * Return sliderBar1
	 * @return 
	 */
	 public String getSliderBar1() {
		return sliderBar1;
	}
	
	/**
	 * Set a value to parameter sliderBar1.
	 * @param sliderBar1 
	 */
	 public void setSliderBar1(String sliderBar1) {
		this.sliderBar1 = sliderBar1;
	}
	/**
	 * Return sliderBar2
	 * @return 
	 */
	 public String getSliderBar2() {
		return sliderBar2;
	}
	
	/**
	 * Set a value to parameter sliderBar2.
	 * @param sliderBar2 
	 */
	 public void setSliderBar2(String sliderBar2) {
		this.sliderBar2 = sliderBar2;
	}
	/**
	 * Return sliderBar3
	 * @return 
	 */
	 public String getSliderBar3() {
		return sliderBar3;
	}
	
	/**
	 * Set a value to parameter sliderBar3.
	 * @param sliderBar3 
	 */
	 public void setSliderBar3(String sliderBar3) {
		this.sliderBar3 = sliderBar3;
	}

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.sliderBar1 = null;
		this.sliderBar2 = null;
		this.sliderBar3 = null;
	}

// Start of user code for other methods
// End of user code
	
}