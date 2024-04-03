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
/**
 * 
 */
package org.obeonetwork.tools.requirement.wizard.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementFactory;

/**
 * @author Obeo
 *
 */
public class RequirementCreationPropertiesEditingContext extends DomainPropertiesEditionContext {

	public RequirementCreationPropertiesEditingContext(PropertiesEditingContext parentContext,
			IPropertiesEditionComponent editionComponent, EditingDomain domain, AdapterFactory adapterFactory,
			EObject selectedEObject) {
		super(parentContext, editionComponent, domain, adapterFactory, selectedEObject);
	}

	public void preProcess() {
		EObject selectedEObject = this.eObject;
		this.eObject = RequirementFactory.eINSTANCE.createRequirement();
		selectedEObject.eResource().getContents().add(eObject);
		((Requirement) eObject).getReferencedObject().add(selectedEObject);
	}

}
