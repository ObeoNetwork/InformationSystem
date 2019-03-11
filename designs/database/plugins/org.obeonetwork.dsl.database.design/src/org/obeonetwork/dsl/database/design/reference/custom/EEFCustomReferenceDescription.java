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
import org.eclipse.eef.ext.widgets.reference.eefextwidgetsreference.impl.EEFExtReferenceDescriptionImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

public class EEFCustomReferenceDescription extends EEFExtReferenceDescriptionImpl {
	
	private EEFCustomWidgetDescription customDescription;
	private CustomReferenceController controller;

	public EEFCustomReferenceDescription(EEFCustomWidgetDescription controlDescription,
			IVariableManager variableManager, IInterpreter interpreter, EditingContextAdapter editingContextAdapter) {
		this.customDescription = controlDescription;
		this.controller = new CustomReferenceController(controlDescription, variableManager, interpreter, editingContextAdapter);
	}
	
	public CustomReferenceController getController() {
		return this.controller;
	}
	
	public boolean hasBrowseButtonOperation() {
		return this.controller.hasBrowseButtonOperation();
	}
	
	public void executeBrowseButtonOperation() {
		this.controller.executeBrowseButtonOperation();
	}
	
	public boolean browseButtonNeeded() {
		return this.controller.browseButtonNeed();
	}

	public boolean removeButtonNeeded() {
		return this.controller.removeButtonNeed();
	}

	
	public boolean addButtonNeeded() {
		return this.controller.addButtonNeeded();
	}
	
	public boolean hasAddButtonOperation() {
		return this.controller.hasAddButtonOperation();
	}

	public void executeAddButtonOperation() {
		this.controller.executeAddButtonOperation();
	}
	
	@Override
	public String getReferenceOwnerExpression() {
		return this.controller.getReferenceOwnerExpression();
	}

	@Override
	public String getReferenceNameExpression() {
		return this.controller.getReferenceNameExpression();
	}
	
	@Override
	public String getLabelExpression() {
		return this.customDescription.getLabelExpression();
	}
	
	@Override
	public String getHelpExpression() {
		return this.customDescription.getHelpExpression();
	}
	
	@Override
	public String getIsEnabledExpression() {
		return this.customDescription.getIsEnabledExpression();
	}
	
	@Override
	public EObject eContainer() {
		return this.customDescription.eContainer();
	}

}
