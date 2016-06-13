/*******************************************************************************
 * Copyright (c) 2009-2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.ui.wizards;

import org.obeonetwork.dsl.is.overview.IsOverviewModelDef;
import org.obeonetwork.dsl.overview.presentation.OverviewModelWizard;

public class ISModelWizard extends OverviewModelWizard {
	
	protected String getOverviewModelDefID(){
		return IsOverviewModelDef.ID;
	}
	
}
