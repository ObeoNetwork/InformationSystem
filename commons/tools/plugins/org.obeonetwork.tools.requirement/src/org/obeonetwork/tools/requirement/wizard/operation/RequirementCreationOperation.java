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
package org.obeonetwork.tools.requirement.wizard.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.ui.UIConstants;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.requirement.wizard.RequirementEditingWizard;
import org.obeonetwork.tools.requirement.wizard.util.RequirementCreationPropertiesEditingContext;

public class RequirementCreationOperation extends AbstractEMFOperation {

	protected PropertiesEditingContext editingContext;

	/**
	 * @param domain
	 * @param label
	 */
	public RequirementCreationOperation(RequirementCreationPropertiesEditingContext editingContext) {
		super((TransactionalEditingDomain) editingContext.getEditingDomain(), "EEF Editing Operation"); //$NON-NLS-1$
		this.editingContext = editingContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		((RequirementCreationPropertiesEditingContext) this.editingContext).preProcess();
		RequirementEditingWizard wizard = new RequirementEditingWizard(editingContext,
				editingContext.getAdapterFactory(), editingContext.getEObject());
		WizardDialog wDialog = new WizardDialog(EditingUtils.getShell(), wizard) {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
			 */
			@Override
			protected Point getInitialSize() {
				Point initialSize = super.getInitialSize();
				return new Point(Math.min(UIConstants.INITIAL_WIZARD_SIZE.x, initialSize.x),
						Math.min(UIConstants.INITIAL_WIZARD_SIZE.y, initialSize.y));
			}

		};
		int open = wDialog.open();
		ChangeDescription description = editingContext.getChangeRecorder().endRecording();
		if (open == Window.OK) {
			Requirement requirement = (Requirement) editingContext.getEObject();
			requirement.eResource().getContents().remove(requirement);
			wizard.getOwningCategory().getRequirements().add(requirement);
			return Status.OK_STATUS;
		} else {
			description.applyAndReverse();
			return Status.CANCEL_STATUS;
		}
	}

}
