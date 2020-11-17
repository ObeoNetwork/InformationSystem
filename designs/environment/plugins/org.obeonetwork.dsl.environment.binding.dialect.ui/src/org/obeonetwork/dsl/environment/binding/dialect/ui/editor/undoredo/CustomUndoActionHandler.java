/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.editor.undoredo;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.operations.UndoActionHandler;
import org.obeonetwork.dsl.environment.binding.dialect.ui.editor.BindingTreeEditor;

public class CustomUndoActionHandler extends Action {

	private UndoActionHandler actionHandler;
	private BindingTreeEditor editor;
	
	public CustomUndoActionHandler(BindingTreeEditor editor, IUndoContext context) {
		super();
		actionHandler = new UndoActionHandler(editor.getSite(), context);
		this.editor = editor;
	}

	@Override
	public void run() {
		actionHandler.run();
		editor.doRefresh();
	}
	
	@Override
	public String getToolTipText() {
		return actionHandler.getToolTipText();
	}
	
	@Override
	public String getText() {
		return actionHandler.getText();
	}
	
	@Override
	public String getDescription() {
		return actionHandler.getDescription();
	}

	public void dispose() {
		if (actionHandler != null) {
			actionHandler.dispose();
		}
	}
}
