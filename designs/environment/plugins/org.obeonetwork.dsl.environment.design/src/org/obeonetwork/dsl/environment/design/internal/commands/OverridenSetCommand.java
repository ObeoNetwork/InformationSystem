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
package org.obeonetwork.dsl.environment.design.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class OverridenSetCommand extends SetCommand {

	public OverridenSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {
		super(domain, owner, feature, value);
	}
	
	protected void setOldValue(Object newOldValue) {
		super.oldValue = newOldValue;
	}
}
