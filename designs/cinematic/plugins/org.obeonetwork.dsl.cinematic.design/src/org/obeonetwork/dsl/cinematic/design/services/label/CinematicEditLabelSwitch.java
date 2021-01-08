/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services.label;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.util.CinematicSwitch;

public class CinematicEditLabelSwitch extends CinematicSwitch<EObject> implements EditLabelSwitch {
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
