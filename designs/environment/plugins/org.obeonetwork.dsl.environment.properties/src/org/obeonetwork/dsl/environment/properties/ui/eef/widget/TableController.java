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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.EefPackage;
import org.eclipse.eef.common.api.utils.Util;
import org.eclipse.eef.core.api.EEFExpressionUtils;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.AbstractEEFCustomWidgetController;
import org.eclipse.eef.core.api.controllers.IEEFOnClickController;
import org.eclipse.eef.core.api.utils.EvalFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

/**
 * The controller of the table widget.
 * 
 * @author gcoutable
 */
public class TableController extends AbstractEEFCustomWidgetController implements IEEFOnClickController {
	
	/**
	 * The ID of the columns expression.
	 */
    private static final String COLUMNS_EXPRESSION_ID = "ColumnsExpression";
    
    /**
	 * The ID of the reference owner expression.
	 */
    private static final String REFERENCE_OWNER_EXPRESSION_ID = "referenceOwnerExpression";
    
    /**
	 * The ID of the reference name expression.
	 */
    private static final String REFERENCE_NAME_EXPRESSION_ID = "referenceNameExpression";
    
    /**
	 * The ID of the create element custom operation.
	 */
    private static final String CREATE_ELEMENT_OPERATION_ID = "CreateElementOperation";
    
    /**
	 * The ID of the edit element expression.
	 */
    private static final String EDIT_ELEMENT_OPERATION_ID = "EditElementOperation";
    
    /**
     * The result of the {@link #REFERENCE_OWNER_EXPRESSION_ID} expression evaluation.
     */
    private EObject target;
    
    /**
     * The reference with the name resulting from the {@link #REFERENCE_NAME_EXPRESSION_ID} expression evaluation.
     */
    private EReference eReference;
    
    /**
     * The list of columns name resulting from the {@link #COLUMNS_EXPRESSION_ID} expression evaluation
     */
    private List<String> columnsLabels;

    /**
     * The current selection, <code>null</code> if no selection has been done.
     */
	private EObject currentSelection;
    
	public TableController(EEFCustomWidgetDescription description, IVariableManager variableManager,
			IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		super(description, variableManager, interpreter, contextAdapter);
	}
	
	@Override
	public void onClick(Object element, String onClickEventKind) {
		// Convert the selection to EObject.
		EObject selection = null;
		if (element instanceof Collection<?>) {
			// Handle single selection only.
			selection = ((Collection<?>) element).stream().findFirst().filter(EObject.class::isInstance).map(EObject.class::cast).orElse(null);
		} else if (element instanceof EObject) {
			selection = (EObject) element;
		}
		
		// Handle the client event 
		if (selection != null && EEFExpressionUtils.EEFList.DOUBLE_CLICK.equals(onClickEventKind)) {
			handleDoubleClick(selection);
		} else if (EEFExpressionUtils.EEFList.SINGLE_CLICK.equals(onClickEventKind)) {
			// The selection can be null if something force the unselection.
			handleSingleClick(selection);
		}
	}
	
	/**
	 * Invoked when the user double clicks on an {@link EObject}.
	 * 
	 * @param selection 
	 * 			The double clicked {@link EObject}
	 */
	protected void handleDoubleClick(EObject selection) {
		this.displayEditWizard();
	}

	/**
	 * Invoked when the user clicks on an {@link EObject}.
	 * 
	 * @param selection 
	 * 			The clicked {@link EObject}
	 */
	protected void handleSingleClick(EObject selection) {
		this.currentSelection = selection;
	}

	/**
	 * Returns the list of column names.
	 * 
	 * @return the list of column names
	 */
	public List<String> getColumnsLabels() {
		if (this.columnsLabels == null) {
			this.columnsLabels = new ArrayList<>();
			this.getCustomExpression(COLUMNS_EXPRESSION_ID).ifPresent((columnsExpression) -> {
				Object evaluated = newEval().evaluate(columnsExpression);
				if (evaluated instanceof Collection<?>) {
					this.columnsLabels.addAll(((Collection<?>) evaluated).stream().filter(String.class::isInstance).map(String.class::cast).collect(Collectors.toList()));
				}
			});
		}
		return this.columnsLabels;
	}

	/**
	 * Returns the reference.
	 * 
	 * @return the reference
	 */
	public EReference getReference() {
		if (this.eReference == null) {
			this.getCustomExpression(REFERENCE_NAME_EXPRESSION_ID).ifPresent((referenceNameExpr) -> {
				Object evaluated = newEval().evaluate(referenceNameExpr);
				EObject target= this.getTarget();
				if (target != null && !Util.isBlank(evaluated.toString())) {
					EStructuralFeature eStructuralFeature = target.eClass().getEStructuralFeature(evaluated.toString());
					if (eStructuralFeature instanceof EReference) {
						this.eReference = (EReference) eStructuralFeature;
					}
				}
			});
		}
		return this.eReference;
	}

	/**
	 * Returns the reference owner.
	 * 
	 * @return the reference owner
	 */
	public EObject getTarget() {
		if (this.target == null) {
			this.getCustomExpression(REFERENCE_OWNER_EXPRESSION_ID).ifPresent((referenceOwnerExpr) -> {
				Object evaluated = newEval().evaluate(referenceOwnerExpr);
				if (evaluated instanceof EObject) {
					this.target = (EObject) evaluated;
				}
			});
		}
		return this.target;
	}

	/**
	 * Computes the ration of columns.
	 * 
	 * @param columnLabel
	 * 			The name of the column.
	 * @return The column ration
	 */
	public int getColumnWeight(String columnLabel) {
		// Hard coded, should be improved.
		if (columnsLabels.get(0).equals(columnLabel)) {
			return 1;
		} else if (columnsLabels.get(1).equals(columnLabel)) {
			return 3;
		}
		return 1;
	}

	/**
	 * Displays the wizard to add element.
	 */
	public void displayAddButtonWizard() {
		this.executeCommandExpression(CREATE_ELEMENT_OPERATION_ID);
	}

	/**
	 * Displays the wizard to edit the selected element.
	 */
	public void displayEditWizard() {
		this.editingContextAdapter.performModelChange(() -> {
			this.getCustomExpression(EDIT_ELEMENT_OPERATION_ID).ifPresent(editElementExpr -> {
				EAttribute attr = EefPackage.Literals.EEF_CUSTOM_EXPRESSION__CUSTOM_EXPRESSION;
				
				Map<String,Object> variables = new HashMap<>();
				variables.putAll(this.variableManager.getVariables());
				variables.put(EEFExpressionUtils.EEFList.SELECTION, this.currentSelection);
				
				EvalFactory.of(this.interpreter, variables).logIfBlank(attr).call(editElementExpr);
			});
		});
	}

	/**
	 * Returns the selection. The selection can be <code>null</code> if the user has not selected an object in the table.
	 * 
	 * @return the selection
	 */
	public EObject getSelection() {
		return this.currentSelection;
	}
}
