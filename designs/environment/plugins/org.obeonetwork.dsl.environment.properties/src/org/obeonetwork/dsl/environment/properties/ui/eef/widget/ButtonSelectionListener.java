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

import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * Utility class used to encapsulate the selection listener.
 * 
 * @author sbegaudeau
 */
public class ButtonSelectionListener implements SelectionListener {

	private EditingContextAdapter editingContextAdapter;
	
	private Runnable runnable;

	public ButtonSelectionListener(EditingContextAdapter editingContextAdapter, Runnable runnable) {
		this.editingContextAdapter = editingContextAdapter;
		this.runnable = runnable;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		this.editingContextAdapter.performModelChange(this.runnable);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		this.editingContextAdapter.performModelChange(this.runnable);
	}

}
