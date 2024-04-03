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
package org.obeonetwork.dsl.requirement.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;

public class ValidationDelegateClientSelector implements IClientSelector {
	
	public static boolean running = false;
	
	public boolean selects(Object object) {
		if (running) {
			return  (object instanceof Repository
					|| object instanceof Category
					|| object instanceof Requirement);
		}
		return false;
	}

}
