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

import org.eclipse.eef.common.ui.api.IEEFFormContainer;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.EEFExtSingleReferenceLifecycleManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings({ "restriction" })
public class EEFSingleReferenceCustomLifecycleManager extends EEFExtSingleReferenceLifecycleManager
		implements IEEFLifecycleManager {

	private EEFCustomReferenceDescription customDescription;

	public EEFSingleReferenceCustomLifecycleManager(EEFCustomReferenceDescription description, EObject target,
			EReference eReference, IVariableManager variableManager, IInterpreter interpreter,
			EditingContextAdapter editingContextAdapter) {
		super(description, target, eReference, variableManager, interpreter, editingContextAdapter);
		this.customDescription = description;
	}
	
	@Override
	protected void setEnabled(boolean isEnabled) {
		super.setEnabled(isEnabled);
		
		this.addButton.setEnabled(!this.customDescription.addButtonNeeded());
		this.browseButton.setEnabled(!this.customDescription.browseButtonNeeded());
		this.removeButton.setEnabled(!this.customDescription.removeButtonNeeded());
	}
	
	@Override
	public void createControl(Composite parent, IEEFFormContainer formContainer) {
		super.createControl(parent, formContainer);
	}
	
	@Override
	protected void addButtonCallback() {
		if (this.customDescription.hasAddButtonOperation()) {
			this.customDescription.executeAddButtonOperation();
		} else {
			super.addButtonCallback();
		}
	}
	
	@Override
	protected void browseButtonCallback() {
		if (this.customDescription.hasBrowseButtonOperation()) {
			this.customDescription.executeBrowseButtonOperation();
		} else {
			IWizard wizard = new CustomEEFExtEObjectSelectionWizard(this.target, this.eReference, this.editingContextAdapter);
			WizardDialog wizardDialog = new WizardDialog(this.label.getShell(), wizard);
			wizardDialog.open();
		}
	}
}
