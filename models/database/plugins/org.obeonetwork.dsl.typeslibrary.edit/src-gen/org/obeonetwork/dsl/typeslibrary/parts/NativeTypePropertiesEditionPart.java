/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface NativeTypePropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the spec
	 * 
	 */
	public Enumerator getSpec();

	/**
	 * Init the spec
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSpec(Object input, Enumerator current);

	/**
	 * Defines a new spec
	 * @param newValue the new spec to set
	 * 
	 */
	public void setSpec(Enumerator newValue);


	/**
	 * @return the mapsTo
	 * 
	 */
	public EObject getMapsTo();

	/**
	 * Init the mapsTo
	 * @param settings the combo setting
	 */
	public void initMapsTo(EObjectFlatComboSettings settings);

	/**
	 * Defines a new mapsTo
	 * @param newValue the new mapsTo to set
	 * 
	 */
	public void setMapsTo(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setMapsToButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the mapsTo edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMapsTo(ViewerFilter filter);

	/**
	 * Adds the given filter to the mapsTo edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMapsTo(ViewerFilter filter);





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
