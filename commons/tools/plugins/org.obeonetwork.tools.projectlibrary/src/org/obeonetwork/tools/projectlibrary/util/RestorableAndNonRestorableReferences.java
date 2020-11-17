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

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a list of references which can be restored and a list of references
 * which can not be restored
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class RestorableAndNonRestorableReferences {

	private Collection<ToBeRestoredReference> restorableReferences = new ArrayList<ToBeRestoredReference>();
	
	private Collection<ToBeRestoredReference> nonRestorableReferences = new ArrayList<ToBeRestoredReference>();

	public Collection<ToBeRestoredReference> addReference(ToBeRestoredReference restorableReference) {
		if (restorableReference.getCanBeRestored()) {
			return addRestorableReference(restorableReference);
		} else {
			return addNonRestorableReference(restorableReference);
		}
	}
	
	private Collection<ToBeRestoredReference> addRestorableReference(ToBeRestoredReference restorableReference) {
		restorableReferences.add(restorableReference);
		return restorableReferences;
	}
	
	private Collection<ToBeRestoredReference> addNonRestorableReference(ToBeRestoredReference nonRestorableReference) {
		nonRestorableReferences.add(nonRestorableReference);
		return nonRestorableReferences;
	}
	
	public Collection<ToBeRestoredReference> getRestorableReferences() {
		return restorableReferences;
	}

	public void setRestorableReferences(Collection<ToBeRestoredReference> restorableReferences) {
		this.restorableReferences = restorableReferences;
	}

	public Collection<ToBeRestoredReference> getNonRestorableReferences() {
		return nonRestorableReferences;
	}

	public void setNonRestorableReferences(Collection<ToBeRestoredReference> nonRestorableReferences) {
		this.nonRestorableReferences = nonRestorableReferences;
	}
}
