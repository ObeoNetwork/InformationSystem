/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface RelationPropertiesEditionPart {

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
	 * @return the identifier
	 * 
	 */
	public EObject getIdentifier();

	/**
	 * Init the identifier
	 * @param settings the combo setting
	 */
	public void initIdentifier(EObjectFlatComboSettings settings);

	/**
	 * Defines a new identifier
	 * @param newValue the new identifier to set
	 * 
	 */
	public void setIdentifier(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setIdentifierButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the identifier edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToIdentifier(ViewerFilter filter);

	/**
	 * Adds the given filter to the identifier edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToIdentifier(ViewerFilter filter);


	/**
	 * @return the source
	 * 
	 */
	public EObject getSource();

	/**
	 * Init the source
	 * @param settings the combo setting
	 */
	public void initSource(EObjectFlatComboSettings settings);

	/**
	 * Defines a new source
	 * @param newValue the new source to set
	 * 
	 */
	public void setSource(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the source edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter);

	/**
	 * Adds the given filter to the source edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter);


	/**
	 * @return the sourceRole
	 * 
	 */
	public String getSourceRole();

	/**
	 * Defines a new sourceRole
	 * @param newValue the new sourceRole to set
	 * 
	 */
	public void setSourceRole(String newValue);


	/**
	 * @return the sourceCardinality
	 * 
	 */
	public Enumerator getSourceCardinality();

	/**
	 * Init the sourceCardinality
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSourceCardinality(Object input, Enumerator current);

	/**
	 * Defines a new sourceCardinality
	 * @param newValue the new sourceCardinality to set
	 * 
	 */
	public void setSourceCardinality(Enumerator newValue);


	/**
	 * @return the sourceIsComposite
	 * 
	 */
	public Boolean getSourceIsComposite();

	/**
	 * Defines a new sourceIsComposite
	 * @param newValue the new sourceIsComposite to set
	 * 
	 */
	public void setSourceIsComposite(Boolean newValue);


	/**
	 * @return the target
	 * 
	 */
	public EObject getTarget();

	/**
	 * Init the target
	 * @param settings the combo setting
	 */
	public void initTarget(EObjectFlatComboSettings settings);

	/**
	 * Defines a new target
	 * @param newValue the new target to set
	 * 
	 */
	public void setTarget(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTargetButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the target edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTarget(ViewerFilter filter);

	/**
	 * Adds the given filter to the target edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTarget(ViewerFilter filter);


	/**
	 * @return the targetRole
	 * 
	 */
	public String getTargetRole();

	/**
	 * Defines a new targetRole
	 * @param newValue the new targetRole to set
	 * 
	 */
	public void setTargetRole(String newValue);


	/**
	 * @return the targetCardinality
	 * 
	 */
	public Enumerator getTargetCardinality();

	/**
	 * Init the targetCardinality
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTargetCardinality(Object input, Enumerator current);

	/**
	 * Defines a new targetCardinality
	 * @param newValue the new targetCardinality to set
	 * 
	 */
	public void setTargetCardinality(Enumerator newValue);


	/**
	 * @return the targetIsComposite
	 * 
	 */
	public Boolean getTargetIsComposite();

	/**
	 * Defines a new targetIsComposite
	 * @param newValue the new targetIsComposite to set
	 * 
	 */
	public void setTargetIsComposite(Boolean newValue);




	/**
	 * Init the elements
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initElements(ReferencesTableSettings settings);

	/**
	 * Update the elements
	 * @param newValue the elements to update
	 * 
	 */
	public void updateElements();

	/**
	 * Adds the given filter to the elements edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToElements(ViewerFilter filter);

	/**
	 * Adds the given filter to the elements edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToElements(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the elements table
	 * 
	 */
	public boolean isContainedInElementsTable(EObject element);


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
