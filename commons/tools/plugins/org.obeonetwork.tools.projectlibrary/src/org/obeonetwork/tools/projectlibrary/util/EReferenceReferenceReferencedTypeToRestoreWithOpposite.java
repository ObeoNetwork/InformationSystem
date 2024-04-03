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
package org.obeonetwork.tools.projectlibrary.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.Reference;

public class EReferenceReferenceReferencedTypeToRestoreWithOpposite extends ToBeRestoredReference {

	protected final Reference oppositeReference;

	public EReferenceReferenceReferencedTypeToRestoreWithOpposite(EObject sourceObject,
			EStructuralFeature referencingFeature, String targetKey, Integer position, boolean canBeRestored,
			final Reference oppositeReference) {
		super(sourceObject, referencingFeature, targetKey, position, canBeRestored);
		this.oppositeReference = oppositeReference;
	}
	
	public Reference getOppositeReference() {
		return oppositeReference;
	}

}
