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

import java.util.Collection;

import org.eclipse.eef.EEFControlDescription;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.common.api.utils.Util;
import org.eclipse.eef.core.api.EEFExpressionUtils;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ext.widgets.reference.eefextwidgetsreference.EEFExtReferenceDescription;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManagerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.common.interpreter.api.IEvaluationResult;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

public class EEFReferenceCustomLifecycleManagerProvider implements IEEFLifecycleManagerProvider {
	
	private static final String SUPPORTED_ID = "org.obeonetwork.dsl.database.design.custom.reference";

	@Override
	public boolean canHandle(EEFControlDescription controlDescription) {
		return SUPPORTED_ID.equals(controlDescription.getIdentifier()) && controlDescription instanceof EEFCustomWidgetDescription;
	}

	@Override
	public IEEFLifecycleManager getLifecycleManager(EEFControlDescription controlDescription,
			IVariableManager variableManager, IInterpreter interpreter, EditingContextAdapter editingContextAdapter) {
		if (controlDescription instanceof EEFCustomWidgetDescription) {
			EEFCustomReferenceDescription eefCustomReferenceDescription = new EEFCustomReferenceDescription((EEFCustomWidgetDescription) controlDescription, variableManager, interpreter, editingContextAdapter);
			EObject target = this.getTarget(eefCustomReferenceDescription, interpreter, variableManager);
			String referenceName = this.getReferenceName(eefCustomReferenceDescription, interpreter, variableManager);
			EReference reference = (EReference) target.eClass().getEStructuralFeature(referenceName);
			if (reference.isMany()) {
				return new EEFMultipleReferenceCustomLifecycleManager(eefCustomReferenceDescription, target, reference, variableManager, interpreter, editingContextAdapter);
			} else {
				return new EEFSingleReferenceCustomLifecycleManager(eefCustomReferenceDescription, target, reference, variableManager, interpreter, editingContextAdapter);
			}
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Returns the target to use as the current object.
	 *
	 * @param description
	 *            The description
	 * @param interpreter
	 *            The interpreter
	 * @param variableManager
	 *            The variable manager
	 * @return The target
	 */
	private EObject getTarget(EEFExtReferenceDescription description, IInterpreter interpreter, IVariableManager variableManager) {
		EObject self = null;
		if (!Util.isBlank(description.getReferenceOwnerExpression())) {
			IEvaluationResult result = interpreter.evaluateExpression(variableManager.getVariables(), description.getReferenceOwnerExpression());
			if (result.success()) {
				Collection<EObject> eObjects = result.asEObjects();
				if (eObjects.size() > 0) {
					self = eObjects.iterator().next();
				}
			}
		} else {
			Object selfVariable = variableManager.getVariables().get(EEFExpressionUtils.SELF);
			if (selfVariable instanceof EObject) {
				self = (EObject) selfVariable;
			}
		}

		return self;
	}

	/**
	 * Returns the name of the reference to use.
	 *
	 * @param description
	 *            The description
	 * @param interpreter
	 *            The interpreter
	 * @param variableManager
	 *            The variable manager
	 * @return The name of the reference
	 */
	private String getReferenceName(EEFExtReferenceDescription description, IInterpreter interpreter, IVariableManager variableManager) {
		IEvaluationResult evaluationResult = interpreter.evaluateExpression(variableManager.getVariables(), description.getReferenceNameExpression());
		if (evaluationResult.success()) {
			return evaluationResult.asString();
		}
		return ""; //$NON-NLS-1$
	}

}
