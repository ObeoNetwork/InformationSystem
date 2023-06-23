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
package org.obeonetwork.graal.design.services.usability;

import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.graal.NamedElement;
import org.obeonetwork.graal.TaskReference;
import org.obeonetwork.graal.Transition;
import org.obeonetwork.graal.util.GraalSwitch;

/**
 * Utilities services to edit labels of Graal elements
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 *
 */
public class EditLabelServices extends GraalSwitch<ObeoDSMObject> {
	
	private String editedLabelContent;
	
	/**
	 * Edits the label of any Graal elements
	 * Uses the generated GraalSwitch class to do so
	 * @param context Element for which the label has been edited
	 * @param editedLabelContent New label typed by the user
	 * @return the modified Graal element
	 */
	public ObeoDSMObject editGraalLabel(ObeoDSMObject context, String editedLabelContent) {
		this.editedLabelContent =  editedLabelContent;
		return doSwitch(context);
	}

	@Override
	public ObeoDSMObject caseNamedElement(NamedElement object) {
		object.setName(editedLabelContent);
		return object;
	}

	@Override
	public ObeoDSMObject caseTaskReference(TaskReference object) {
		return caseNamedElement(object.getTask());
	}

	@Override
	public ObeoDSMObject caseTransition(Transition object) {
		String actualLabel = editedLabelContent;
		if (actualLabel != null) {	
			if (actualLabel.startsWith("[")) {
				actualLabel = actualLabel.substring(1);
			} 
			if (actualLabel.endsWith("]")) {
				actualLabel = actualLabel.substring(0, actualLabel.length() - 1);
			}
			object.setGuard(actualLabel);
		}
		return object;
	}	
}
