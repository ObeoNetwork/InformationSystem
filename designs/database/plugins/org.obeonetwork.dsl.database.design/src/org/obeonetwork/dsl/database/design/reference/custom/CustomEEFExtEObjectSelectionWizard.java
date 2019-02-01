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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.EEFExtEObjectSelectionWizard;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.EEFExtReferenceUIPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizard;

@SuppressWarnings("restriction")
public class CustomEEFExtEObjectSelectionWizard extends EEFExtEObjectSelectionWizard implements IWizard {

	private EObject target;
	private EReference eReference;
	private EditingContextAdapter editingContextAdapter;
	private CustomEEFExtEObjectSelectionPage eObjectSelectionPage;

	public CustomEEFExtEObjectSelectionWizard(EObject target, EReference eReference,
			EditingContextAdapter editingContextAdapter) {
		super(target, eReference, editingContextAdapter);
		this.target = target;
		this.eReference = eReference;
		this.editingContextAdapter = editingContextAdapter;
	}
	
	@Override
	public void addPages() {
		this.eObjectSelectionPage = new CustomEEFExtEObjectSelectionPage(this.target, this.eReference, this.editingContextAdapter);
		this.addPage(this.eObjectSelectionPage);
	}
	
	@Override
	public boolean performFinish() {
		boolean finishedProperly = true;

		IRunnableWithProgress runnableWithProgress = (monitor) -> {
			this.editingContextAdapter.performModelChange(() -> this.eObjectSelectionPage.performFinish(monitor));
		};

		try {
			this.getContainer().run(false, false, runnableWithProgress);
		} catch (InvocationTargetException | InterruptedException e) {
			finishedProperly = false;
			IStatus status = new Status(IStatus.ERROR, EEFExtReferenceUIPlugin.PLUGIN_ID, e.getMessage());
			EEFExtReferenceUIPlugin.getPlugin().getLog().log(status);
		}

		return finishedProperly;
	}
}
