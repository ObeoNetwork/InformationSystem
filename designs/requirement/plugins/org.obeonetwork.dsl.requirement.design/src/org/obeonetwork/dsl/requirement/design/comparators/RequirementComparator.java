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
package org.obeonetwork.dsl.requirement.design.comparators;

import java.util.Comparator;

import org.obeonetwork.dsl.requirement.Requirement;

/**
 * Comparator used to compare Requirement based on their labels.
 * A requirement's label is the concatenation of its id and name.
 * @author sthibaudeau
 *
 */
public class RequirementComparator implements Comparator<Requirement> {
	
	public static RequirementComparator INSTANCE = new RequirementComparator();

	public int compare(Requirement req1, Requirement req2) {
		String label1 = getRequirementLabel(req1);
		String label2 = getRequirementLabel(req2);
		return label1.compareToIgnoreCase(label2);
	}

	private String getRequirementLabel(Requirement requirement) {
		if (requirement != null) {
			return requirement.getId() + " - " + requirement.getName();
		}
		return null;
	}

}
