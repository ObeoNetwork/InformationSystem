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
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.List;

/**
 * Implement this interface to specify a cascaded selection behavior for {@link ISObjectSelectionWizard}
 */
public interface ISelectionInductor {

	/**
	 * @param selected
	 * 
	 * @return The objects to select when the given object is selected.
	 */
	public List<EObjectTreeItemWrapper> select(EObjectTreeItemWrapper selected);
	
}
