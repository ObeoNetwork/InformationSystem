/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.wizards.IWizardDescriptor;

public class OpenISNewModelWizardHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String wizardId = event.getParameter("org.obeonetwork.dsl.is.commands.openISNewModelWizard.wizardID");
		openWizard(wizardId, HandlerUtil.getActiveShell(event));
		return null;
	}
	
	public  void openWizard(String id, Shell shell) {
		// First see if this is a "new wizard"
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(id);
		// If not check if it is an "import wizard"
		if  (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getImportWizardRegistry().findWizard(id);
		}
		// Or maybe an export wizard
		if  (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getExportWizardRegistry().findWizard(id);
		}
		try  {
			// Then if we have a wizard, open it.
			if  (descriptor != null) {
				IWizard wizard = descriptor.createWizard();
				WizardDialog wd = new  WizardDialog(shell, wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch  (CoreException e) {
			e.printStackTrace();
		}
	}
}
