/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.parts.forms;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.sirius.viewpoint.DSemanticDecorator;

/**
 * Specific class to override resolveSemanticElement() so it works with tables
 * 
 */
public class CustomRequirementPropertiesEditionPartForm extends RequirementPropertiesEditionPartForm {
	
	public CustomRequirementPropertiesEditionPartForm() {
		super();
	}

	public CustomRequirementPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	@Override
	protected EObject resolveSemanticObject(Object object) {
		if (object instanceof DSemanticDecorator) {
			return((DSemanticDecorator) object).getTarget();
		}
		return super.resolveSemanticObject(object);
	}
}
