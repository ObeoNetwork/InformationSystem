/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.extensionpoint;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Interface for the extension point: boundableElementChildrenDefinitions used
 * to get children of BoundableElement to be displayed in the binding details
 * editor.
 * 
 * @author Obeo
 *
 */
public interface IBoundableElementChildren {

	/**
	 * 
	 * @param object
	 * @return Children of object to be displayed in binding editor if the object's
	 *         {@link EClass} is among values in {@link #getApplicableEClasses()}
	 */
	public List<? extends EObject> getChildren(EObject object);

	/**
	 * 
	 * @return {@link EClass}es for which children will be given
	 */
	public List<EClass> getApplicableEClasses();

	/**
	 * 
	 * @return a label of eObject to be displayed if the object's {@link EClass} is
	 *         among values in {@link #getApplicableEClasses()}
	 */
	public String getLabel(EObject eObject);
	
	/**
	 * <p>
	 * Used to break cycles when building the elements tree and checking for non repeating
	 * parent-child couples.
	 * </p>
	 * <p>
	 * It addresses the case where a node in the tree can be represented by different elements.
	 * This is typically the case for a StructuredElement that can be represented as the root 
	 * element and a Reference typed with the same StructuredType. In such a case, the Reference
	 * should be identified as the same object as the StructuredType when looking for cycles.
	 * </p>
	 * <p>
	 * This method returns the unique object representing the given element.
	 * Its default behavior is to return the given element as is.
	 * </p>
	 * 
	 * @param element
	 * @return the unambiguous corresponding element
	 */
	public default Object asUnambiguousElement(Object element) {
		return element;
	};
	
}
