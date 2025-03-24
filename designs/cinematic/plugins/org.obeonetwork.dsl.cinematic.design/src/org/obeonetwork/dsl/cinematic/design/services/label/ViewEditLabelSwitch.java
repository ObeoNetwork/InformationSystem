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
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.view.util.ViewSwitch;

public class ViewEditLabelSwitch extends ViewSwitch<EObject> implements EditLabelSwitch {
	private String newLabel;
	
	public EObject editLabel(EObject eObject, String newLabel) {
		this.newLabel = newLabel;
		doSwitch(eObject);
		return eObject;
	}

	@Override
	public EObject caseNamedElement(NamedElement namedElement) {
		namedElement.setName(newLabel);
		return namedElement;
	}
	
}
