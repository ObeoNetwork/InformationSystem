/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface UseCasePropertiesEditionPart {

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
	 * Init the tasks
	 * @param settings settings for the tasks ReferencesTable 
	 */
	public void initTasks(ReferencesTableSettings settings);

	/**
	 * Update the tasks
	 * @param newValue the tasks to update
	 * 
	 */
	public void updateTasks();

	/**
	 * Adds the given filter to the tasks edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTasks(ViewerFilter filter);

	/**
	 * Adds the given filter to the tasks edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTasks(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the tasks table
	 * 
	 */
	public boolean isContainedInTasksTable(EObject element);




	/**
	 * Init the namespaces
	 * @param settings settings for the namespaces ReferencesTable 
	 */
	public void initNamespaces(ReferencesTableSettings settings);

	/**
	 * Update the namespaces
	 * @param newValue the namespaces to update
	 * 
	 */
	public void updateNamespaces();

	/**
	 * Adds the given filter to the namespaces edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToNamespaces(ViewerFilter filter);

	/**
	 * Adds the given filter to the namespaces edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToNamespaces(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the namespaces table
	 * 
	 */
	public boolean isContainedInNamespacesTable(EObject element);




	/**
	 * Init the domainClasses
	 * @param settings settings for the domainClasses ReferencesTable 
	 */
	public void initDomainClasses(ReferencesTableSettings settings);

	/**
	 * Update the domainClasses
	 * @param newValue the domainClasses to update
	 * 
	 */
	public void updateDomainClasses();

	/**
	 * Adds the given filter to the domainClasses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDomainClasses(ViewerFilter filter);

	/**
	 * Adds the given filter to the domainClasses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDomainClasses(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the domainClasses table
	 * 
	 */
	public boolean isContainedInDomainClassesTable(EObject element);





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
