/*******************************************************************************
 * Copyright (c) 2006, 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.project.lifecycle.ui.wizards;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class BusinessProjectImportWizard extends Wizard implements IImportWizard {
	
	private BusinessProjectImportWizardPage mainPage;

	public BusinessProjectImportWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		boolean importSuccessful = mainPage.doBusinessImport();
		
		if (importSuccessful) {
			MessageDialog.openInformation(getShell(), BusinessProjectImportWizardPage.DIALOG_TITLE, "Import has been successful.");
		} else {
			MessageDialog.openWarning(getShell(), BusinessProjectImportWizardPage.DIALOG_TITLE, "Import has been cancelled.");
		}
		
		return importSuccessful;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Business Project Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		mainPage = new BusinessProjectImportWizardPage("Import business project",selection); //NON-NLS-1
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }

}
