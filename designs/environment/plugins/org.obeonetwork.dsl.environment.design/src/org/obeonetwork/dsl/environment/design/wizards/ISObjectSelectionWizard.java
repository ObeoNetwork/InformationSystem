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
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.common.ui.tools.api.selection.WizardDialogClosableByWizard;

public class ISObjectSelectionWizard extends Wizard {

    private static final String ISOBJECT_SELECTION_WIZARD_PAGE_NAME = "page"; //$NON-NLS-1$

    private ISObjectSelectionWizardPage page;

    /**
     * A dialog exposing the finish method.
     */
    private WizardDialogClosableByWizard dialog;

    public ISObjectSelectionWizard(
    		String windowTitle, 
    		String wizardPageTitle, 
    		ImageDescriptor wizardPageTitleImage,
    		LazyEObjectTreeItemWrapper treeRoot,
    		boolean many,
    		List<EObject> preSelection) {
        setWindowTitle(windowTitle);
        page = new ISObjectSelectionWizardPage(ISOBJECT_SELECTION_WIZARD_PAGE_NAME, wizardPageTitle, wizardPageTitleImage, treeRoot, many, preSelection);
        addPage(page);
    }

    /**
     * @return the {@link WizardDialogClosableByWizard} containing this wizard. Null if no such element has been set.
     */
    public WizardDialogClosableByWizard getDialog() {
        return this.dialog;
    }

    /**
     * Set the {@link WizardDialogClosableByWizard} containing this wizard.
     * 
     * @param dlg
     */
    public void setDialog(WizardDialogClosableByWizard dlg) {
        this.dialog = dlg;
    }

    @Override
    public boolean performFinish() {
        return true;
    }

    public EObject getSelectedEObject() {
        return page.getSelectedEObject();
    }

    public List<EObject> getSelectedEObjects() {
    	// Sirius needs a List and not any kind of Collection (for instance it doesn't accept a Set).
        return new ArrayList<EObject>(page.getSelectedEObjects());
    }
    
    public List<EObject> getPartiallySelectedEObjects() {
        return new ArrayList<EObject>(page.getPartiallySelectedEObjects());
    }
    
}
