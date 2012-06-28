/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface UserDefinedTypesLibraryPropertiesEditionPart {

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
	 * Init the userDefinedTypes
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initUserDefinedTypes(ReferencesTableSettings settings);

	/**
	 * Update the userDefinedTypes
	 * @param newValue the userDefinedTypes to update
	 * 
	 */
	public void updateUserDefinedTypes();

	/**
	 * Adds the given filter to the userDefinedTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToUserDefinedTypes(ViewerFilter filter);

	/**
	 * Adds the given filter to the userDefinedTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToUserDefinedTypes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the userDefinedTypes table
	 * 
	 */
	public boolean isContainedInUserDefinedTypesTable(EObject element);





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
