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
package org.obeonetwork.dsl.database.design.reference.custom;

import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.AbstractEEFCustomWidgetController;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

public class CustomReferenceController extends AbstractEEFCustomWidgetController {
	
	private static final String REFERENCE_NAME_EXPRESSION_ID = "referenceNameExpression";
	
	private static final String REFERENCE_OWNER_EXPRESSION_ID = "referenceOwnerExpression";
	
	private static final String BROWSE_BUTTON_OPERATION_ID = "browseButtonOperation";
	
	private static final String ENABLE_ADD_BUTTON_EXPRESSION_ID = "enableAddButtonExpression";

	private static final String ADD_BUTTON_OPERATION_ID = "addButtonOperation";

	private static final String ENABLE_BROWSE_BUTTON_EXPRESSION_ID = "enableBrowseButtonExpression";

	private static final String ENABLE_REMOVE_BUTTON_EXPRESSION_ID = "enableRemoveButtonExpression";
	
	public CustomReferenceController(EEFCustomWidgetDescription description, IVariableManager variableManager,
			IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(description, variableManager, interpreter, contextAdapter);
		// TODO Auto-generated constructor stub
	}

	public String getReferenceNameExpression() {
		return this.getCustomExpression(REFERENCE_NAME_EXPRESSION_ID).orElse("");
	}

	public String getReferenceOwnerExpression() {
		return this.getCustomExpression(REFERENCE_OWNER_EXPRESSION_ID).orElse("");
	}
	
	public boolean browseButtonNeed() {
		return this.getCustomExpression(ENABLE_BROWSE_BUTTON_EXPRESSION_ID)
				.map(addButtonExpr -> this.newEval().evaluate(addButtonExpr))
				.filter(Boolean.class::isInstance)
				.map(Boolean.class::cast)
				.orElse(true);
	}

	public boolean hasBrowseButtonOperation() {
		return this.getCustomExpression(BROWSE_BUTTON_OPERATION_ID).isPresent();
	}

	public void executeBrowseButtonOperation() {
		this.executeCommandExpression(BROWSE_BUTTON_OPERATION_ID);
	}

	public boolean addButtonNeeded() {
		return this.getCustomExpression(ENABLE_ADD_BUTTON_EXPRESSION_ID)
				.map(addButtonExpr -> this.newEval().evaluate(addButtonExpr))
				.filter(Boolean.class::isInstance)
				.map(Boolean.class::cast)
				.orElse(true);
	}

	public boolean hasAddButtonOperation() {
		return this.getCustomExpression(ADD_BUTTON_OPERATION_ID).isPresent();
	}

	public void executeAddButtonOperation() {
		this.executeCommandExpression(ADD_BUTTON_OPERATION_ID);
	}

	public boolean removeButtonNeed() {
		return this.getCustomExpression(ENABLE_REMOVE_BUTTON_EXPRESSION_ID)
				.map(addButtonExpr -> this.newEval().evaluate(addButtonExpr))
				.filter(Boolean.class::isInstance)
				.map(Boolean.class::cast)
				.orElse(true);
	}

}
