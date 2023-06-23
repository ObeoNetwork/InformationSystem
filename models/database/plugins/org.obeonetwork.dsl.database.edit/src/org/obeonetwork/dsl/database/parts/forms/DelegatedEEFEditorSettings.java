/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.parts.forms;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;

/**
 * Special EEFEditorSettings that delegates all calls to another EEFEditorSettings
 * This class is intended to be subclassed  
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 */
public class DelegatedEEFEditorSettings implements EEFEditorSettings {

	private EEFEditorSettings settings = null;
	
	public DelegatedEEFEditorSettings(EEFEditorSettings settings) {
		this.settings = settings;
	}
	
	public Object getValue() {
		return settings.getValue();
	}

	public Object choiceOfValues(AdapterFactory adapterFactory) {
		return settings.choiceOfValues(adapterFactory);
	}

	public boolean isAffectingFeature(EStructuralFeature feature) {
		return settings.isAffectingFeature(feature);
	}

	public boolean isAffectingEvent(Notification notification) {
		return settings.isAffectingEvent(notification);
	}

	public EObject getSource() {
		return settings.getSource();
	}

	public EClassifier getEType() {
		return settings.getEType();
	}

	public EReference getLastReference() {
		return settings.getLastReference();
	}

}
