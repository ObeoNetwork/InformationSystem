/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.properties.ui.eef.widget;

import org.eclipse.eef.EEFControlDescription;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManagerProvider;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

public class TableLifecycleManagerProvider implements IEEFLifecycleManagerProvider {
	
	private static final String SUPPORTED_ID = "org.obeonetwork.dsl.environment.properties.metadata.table";

	@Override
	public boolean canHandle(EEFControlDescription controlDescription) {
		return SUPPORTED_ID.equals(controlDescription.getIdentifier()) && controlDescription instanceof EEFCustomWidgetDescription;
	}

	@Override
	public IEEFLifecycleManager getLifecycleManager(EEFControlDescription controlDescription,
			IVariableManager variableManager, IInterpreter interpreter, EditingContextAdapter editingContextAdapter) {
		if (controlDescription instanceof EEFCustomWidgetDescription) {
			return new TableLifecycleManager((EEFCustomWidgetDescription) controlDescription, variableManager, interpreter, editingContextAdapter);
		}
		throw new IllegalArgumentException();
	}
}
