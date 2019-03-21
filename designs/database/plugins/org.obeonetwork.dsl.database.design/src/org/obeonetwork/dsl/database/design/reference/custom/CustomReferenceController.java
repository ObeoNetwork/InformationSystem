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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.eef.EEFCustomExpression;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.EefPackage;
import org.eclipse.eef.core.api.EEFExpressionUtils;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.utils.EvalFactory;
import org.eclipse.eef.core.ext.widgets.reference.internal.EEFExtReferenceController;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.sirius.common.interpreter.api.IEvaluationResult;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

@SuppressWarnings("restriction")
public class CustomReferenceController extends EEFExtReferenceController {
	
	private static final String REFERENCE_NAME_EXPRESSION_ID = "referenceNameExpression";
	
	private static final String REFERENCE_OWNER_EXPRESSION_ID = "referenceOwnerExpression";
	
	private static final String BROWSE_BUTTON_OPERATION_ID = "browseButtonOperation";
	
	private static final String ENABLE_ADD_BUTTON_EXPRESSION_ID = "enableAddButtonExpression";
	
	private static final String DISABLE_ADD_BUTTON_DEFAULT_EXPRESSION_FORMAT = "aql:self.eClass().getEStructuralFeature('%1$s').many and self.eClass().getEStructuralFeature('%1$s').containment";

	private static final String ADD_BUTTON_OPERATION_ID = "addButtonOperation";

	private static final String ENABLE_BROWSE_BUTTON_EXPRESSION_ID = "enableBrowseButtonExpression";

	private static final String ENABLE_REMOVE_BUTTON_EXPRESSION_ID = "enableRemoveButtonExpression";
	
	private static final String ON_CLICK_EXPRESSION = "onClickOperation";
	
	private static final String ON_DOUBLE_CLICK_EXPRESSION = "onDoubleClickOperation";

	private EEFCustomWidgetDescription description;
	
	public CustomReferenceController(EEFCustomWidgetDescription description, IVariableManager variableManager,
			IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(null, variableManager, interpreter, contextAdapter);
		this.description = description;
	}
	
	@Override
	protected EEFWidgetDescription getDescription() {
		return this.description;
	}

	public String getReferenceNameExpression() {
		return this.getCustomExpression(REFERENCE_NAME_EXPRESSION_ID).orElse("");
	}
	
	public String getReferenceName() {
		IEvaluationResult evaluationResult = interpreter.evaluateExpression(variableManager.getVariables(), this.getReferenceNameExpression());
		if (evaluationResult.success()) {
			return evaluationResult.asString();
		}
		return ""; //$NON-NLS-1$
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

	/**
	 * Whether add button is needed. Evaluates the expression identified by
	 * {@link CustomReferenceController#ENABLE_ADD_BUTTON_EXPRESSION_ID} or if this
	 * expression is not defined, enable the add button only if the reference is not
	 * many and not containment.
	 * 
	 * @return <code>true</code> whether the add button is needed,
	 *         <code>false</code> otherwise
	 */
	public boolean addButtonNeeded() {
		String addButtonNeededExpression = this.getCustomExpression(ENABLE_ADD_BUTTON_EXPRESSION_ID).orElse(String.format(DISABLE_ADD_BUTTON_DEFAULT_EXPRESSION_FORMAT, this.getReferenceName()));
		Object evaluated = this.newEval().evaluate(addButtonNeededExpression);
		if (evaluated instanceof Boolean) {
			return (Boolean) evaluated;
		}
		return true;
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
	
	@Override
	public void onClick(Object element, String onClickEventKind) {
		this.editingContextAdapter.performModelChange(() -> {
			String expression = "";
			if (EEFExpressionUtils.EEFList.DOUBLE_CLICK.equals(onClickEventKind)) {
				expression = this.getOnDoubleClickExpression();
			} else if (EEFExpressionUtils.EEFList.SINGLE_CLICK.equals(onClickEventKind)) {
				expression = this.getOnClickExpression();
			}
			
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.putAll(this.variableManager.getVariables());
			variables.put(EEFExpressionUtils.EEFList.SELECTION, element);
			variables.put(EEFExpressionUtils.EEFList.ON_CLICK_EVENT_KIND, onClickEventKind);

			EvalFactory.of(this.interpreter, variables).call(expression);
		});
		
		
		if (EEFExpressionUtils.EEFList.DOUBLE_CLICK.equals(onClickEventKind)) {
			super.onClick(element, onClickEventKind);
		}
	}

	protected String getOnDoubleClickExpression() {
		return this.getCustomExpression(ON_DOUBLE_CLICK_EXPRESSION).orElse("");
	}

	@Override
	protected String getOnClickExpression() {
		return this.getCustomExpression(ON_CLICK_EXPRESSION).orElse("");
	}
	
	/**
	 * Get the custom expression with the given id.
	 *
	 * @param customExpressionId
	 *            Identifier of the custom expression
	 * @return An optional with the custom expression or an empty optional if none could be found
	 */
	protected Optional<String> getCustomExpression(String customExpressionId) {
		Optional<String> optionalCustomExpression = this.description.getCustomExpressions().stream().filter(eefCustomExpression -> {
			return customExpressionId != null && customExpressionId.equals(eefCustomExpression.getIdentifier());
		}).map(EEFCustomExpression::getCustomExpression).findFirst();

		return optionalCustomExpression;
	}

	/**
	 * Execute a custom expression in a command.
	 *
	 * @param customExpressionId
	 *            Identifier of the custom expression to execute
	 */
	protected void executeCommandExpression(final String customExpressionId) {
		this.editingContextAdapter.performModelChange(() -> {
			this.getCustomExpression(customExpressionId).ifPresent(expression -> {
				EAttribute attr = EefPackage.Literals.EEF_CUSTOM_EXPRESSION__CUSTOM_EXPRESSION;
				CustomReferenceController.this.newEval().logIfBlank(attr).call(expression);
			});
		});
	}

}
