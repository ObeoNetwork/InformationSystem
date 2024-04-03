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
package org.obeonetwork.dsl.environment.binding.dialect.ui.editor;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

public class BindingTreeEditorManager {

	private TransactionalEditingDomain editingDomain;
	private ModelAccessor accessor;
	
	public BindingTreeEditorManager(TransactionalEditingDomain editingDomain, ModelAccessor accessor) {
		super();
		this.editingDomain = editingDomain;
		this.accessor = accessor;
	}

	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public ModelAccessor getAccessor() {
		return accessor;
	}

	public void execute(Command command) {
		getEditingDomain().getCommandStack().execute(command);
	}
	
}
