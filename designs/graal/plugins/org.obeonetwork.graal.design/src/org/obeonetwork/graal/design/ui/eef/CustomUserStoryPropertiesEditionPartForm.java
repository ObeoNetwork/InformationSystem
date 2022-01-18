/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.design.ui.eef;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.obeonetwork.graal.parts.forms.UserStoryPropertiesEditionPartForm;

import org.eclipse.sirius.viewpoint.DSemanticDecorator;



/**
 * Specific class to override resolveSemanticElement() so it works with tables
 * 
 */
public class CustomUserStoryPropertiesEditionPartForm extends UserStoryPropertiesEditionPartForm {

	public CustomUserStoryPropertiesEditionPartForm() {
		super();
	}

	public CustomUserStoryPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
