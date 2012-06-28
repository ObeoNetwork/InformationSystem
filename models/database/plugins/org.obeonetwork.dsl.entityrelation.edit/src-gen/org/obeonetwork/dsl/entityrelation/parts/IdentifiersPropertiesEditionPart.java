/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface IdentifiersPropertiesEditionPart {



	/**
	 * Init the identifiers
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initIdentifiers(ReferencesTableSettings settings);

	/**
	 * Update the identifiers
	 * @param newValue the identifiers to update
	 * 
	 */
	public void updateIdentifiers();

	/**
	 * Adds the given filter to the identifiers edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToIdentifiers(ViewerFilter filter);

	/**
	 * Adds the given filter to the identifiers edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToIdentifiers(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the identifiers table
	 * 
	 */
	public boolean isContainedInIdentifiersTable(EObject element);





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
