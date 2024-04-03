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
package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;

public class UpdateMappingExpressionCommand extends RecordingCommand {

	private EObject element;
	private String expression;
	private ModelAccessor accessor;
	
	public UpdateMappingExpressionCommand(TransactionalEditingDomain domain, ModelAccessor accessor, EObject element, String expression) {
		super(domain, "Update Mapping expression");
		this.element = element;
		this.accessor = accessor;
		this.expression = expression;
	}

	@Override
	protected void doExecute() {
		if (element == null) {
			return;
		}
		try {
			accessor.eSet(element, "bindingExpression", expression);
		} catch (Exception e) {
			SiriusPlugin.getDefault().error("Error while modifying model", e);
		}
	}

}
