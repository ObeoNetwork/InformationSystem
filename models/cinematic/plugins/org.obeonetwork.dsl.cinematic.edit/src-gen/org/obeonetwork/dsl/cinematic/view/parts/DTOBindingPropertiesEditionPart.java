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
public interface DTOBindingPropertiesEditionPart {

	/**
	 * @return the dto
	 * 
	 */
	public EObject getDto();

	/**
	 * Init the dto
	 * @param settings the combo setting
	 */
	public void initDto(EObjectFlatComboSettings settings);

	/**
	 * Defines a new dto
	 * @param newValue the new dto to set
	 * 
	 */
	public void setDto(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setDtoButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the dto edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDto(ViewerFilter filter);

	/**
	 * Adds the given filter to the dto edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDto(ViewerFilter filter);


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
