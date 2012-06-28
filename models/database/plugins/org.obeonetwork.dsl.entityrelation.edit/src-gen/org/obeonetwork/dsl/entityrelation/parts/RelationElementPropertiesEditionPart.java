/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts;

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
public interface RelationElementPropertiesEditionPart {

	/**
	 * @return the source entity
	 * 
	 */
	public String getSourceEntity();

	/**
	 * Defines a new source entity
	 * @param newValue the new source entity to set
	 * 
	 */
	public void setSourceEntity(String newValue);


	/**
	 * @return the source attribute
	 * 
	 */
	public EObject getSourceAttribute();

	/**
	 * Init the source attribute
	 * @param settings the combo setting
	 */
	public void initSourceAttribute(EObjectFlatComboSettings settings);

	/**
	 * Defines a new source attribute
	 * @param newValue the new source attribute to set
	 * 
	 */
	public void setSourceAttribute(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSourceAttributeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the source attribute edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSourceAttribute(ViewerFilter filter);

	/**
	 * Adds the given filter to the source attribute edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSourceAttribute(ViewerFilter filter);


	/**
	 * @return the target entity
	 * 
	 */
	public String getTargetEntity();

	/**
	 * Defines a new target entity
	 * @param newValue the new target entity to set
	 * 
	 */
	public void setTargetEntity(String newValue);


	/**
	 * @return the target attribute
	 * 
	 */
	public EObject getTargetAttribute();

	/**
	 * Init the target attribute
	 * @param settings the combo setting
	 */
	public void initTargetAttribute(EObjectFlatComboSettings settings);

	/**
	 * Defines a new target attribute
	 * @param newValue the new target attribute to set
	 * 
	 */
	public void setTargetAttribute(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTargetAttributeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the target attribute edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTargetAttribute(ViewerFilter filter);

	/**
	 * Adds the given filter to the target attribute edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTargetAttribute(ViewerFilter filter);


	/**
	 * @return the comments
	 * 
	 */
	public String getComments();

	/**
	 * Defines a new comments
	 * @param newValue the new comments to set
	 * 
	 */
	public void setComments(String newValue);





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
