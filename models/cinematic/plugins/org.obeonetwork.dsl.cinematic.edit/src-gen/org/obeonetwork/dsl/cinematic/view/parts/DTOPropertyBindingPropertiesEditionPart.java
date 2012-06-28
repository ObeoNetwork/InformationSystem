/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface DTOPropertyBindingPropertiesEditionPart {

	/**
	 * @return the property
	 * 
	 */
	public EObject getProperty();

	/**
	 * Init the property
	 * @param settings the combo setting
	 */
	public void initProperty(EObjectFlatComboSettings settings);

	/**
	 * Defines a new property
	 * @param newValue the new property to set
	 * 
	 */
	public void setProperty(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setPropertyButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the property edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToProperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the property edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToProperty(ViewerFilter filter);


	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
