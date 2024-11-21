/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
}
