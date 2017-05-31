/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;

public class ScaffoldLogicalDatabaseToPhysicalDatabaseHandler extends AbstractScaffoldHandler {

	@Override
	protected ScaffoldType getWizardKind() {
		return ScaffoldType.MLD_TO_MPD;
	}
}
