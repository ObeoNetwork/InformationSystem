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
public interface EntityBindingPropertiesEditionPart {

	/**
	 * @return the entity
	 * 
	 */
	public EObject getEntity();

	/**
	 * Init the entity
	 * @param settings the combo setting
	 */
	public void initEntity(EObjectFlatComboSettings settings);

	/**
	 * Defines a new entity
	 * @param newValue the new entity to set
	 * 
	 */
	public void setEntity(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEntityButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the entity edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEntity(ViewerFilter filter);

	/**
	 * Adds the given filter to the entity edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEntity(ViewerFilter filter);


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
