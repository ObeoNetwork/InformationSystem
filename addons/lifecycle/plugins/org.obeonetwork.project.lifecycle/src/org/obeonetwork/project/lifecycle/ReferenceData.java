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
package org.obeonetwork.project.lifecycle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;

public class ReferenceData {

	private EObject referencingElement;
	private EStructuralFeature referencingFeature;
	private EObject referencedElement;
	
	public ReferenceData(EObject referencedElement, Setting setting) {
		this.referencingElement = setting.getEObject();
		this.referencingFeature = setting.getEStructuralFeature();
		this.referencedElement = referencedElement;
	}
	
	public EObject getReferencingElement() {
		return referencingElement;
	}
	
	public EStructuralFeature getReferencingFeature() {
		return referencingFeature;
	}
	
	public EObject getReferencedElement() {
		return referencedElement;
	}
}
