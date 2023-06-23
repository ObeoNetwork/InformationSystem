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
package org.obeonetwork.database.ui.actions;

import org.obeonetwork.database.scaffold.ScaffoldType;

public class ScaffoldPhysicalDatabaseToLogicalDatabaseHandler extends AbstractScaffoldHandler {

	@Override
	protected ScaffoldType getWizardKind() {
		return ScaffoldType.MPD_TO_MLD;
	}
}
