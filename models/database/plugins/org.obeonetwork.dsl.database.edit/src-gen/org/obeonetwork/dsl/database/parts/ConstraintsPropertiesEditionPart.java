/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.database.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ConstraintsPropertiesEditionPart {



	/**
	 * Init the constraints
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initConstraints(ReferencesTableSettings settings);

	/**
	 * Update the constraints
	 * @param newValue the constraints to update
	 * 
	 */
	public void updateConstraints();

	/**
	 * Adds the given filter to the constraints edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToConstraints(ViewerFilter filter);

	/**
	 * Adds the given filter to the constraints edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToConstraints(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the constraints table
	 * 
	 */
	public boolean isContainedInConstraintsTable(EObject element);





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
