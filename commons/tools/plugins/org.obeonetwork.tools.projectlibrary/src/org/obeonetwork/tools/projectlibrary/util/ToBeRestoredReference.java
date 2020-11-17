/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Represents a reference to be restored
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ToBeRestoredReference {

	private EObject sourceObject;
	
	private EStructuralFeature referencingFeature;
	
	private String targetKey;
	
	private Integer position;
	
	private boolean canBeRestored = false;
	
	public ToBeRestoredReference(EObject sourceObject, EStructuralFeature referencingFeature, String targetKey, Integer position, boolean canBeRestored) {
		super();
		this.sourceObject = sourceObject;
		this.referencingFeature = referencingFeature;
		this.targetKey = targetKey;
		this.position = position;
		this.canBeRestored = canBeRestored;
	}

	public EObject getSourceObject() {
		return sourceObject;
	}

	public void setSourceObject(EObject sourceObject) {
		this.sourceObject = sourceObject;
	}

	public EStructuralFeature getReferencingFeature() {
		return referencingFeature;
	}

	public void setReferencingFeature(EStructuralFeature referencingFeature) {
		this.referencingFeature = referencingFeature;
	}

	public String getTargetKey() {
		return targetKey;
	}

	public void setTargetKey(String targetKey) {
		this.targetKey = targetKey;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public boolean getCanBeRestored() {
		return canBeRestored;
	}

	public void setCanBeRestored(boolean canBeRestored) {
		this.canBeRestored = canBeRestored;
	}
}
