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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.common.ui.tools.api.selection.WizardDialogClosableByWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

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
    		EObjectTreeItemWrapper treeRoot,
    		boolean many) {
        setWindowTitle(windowTitle);
        page = new ISObjectSelectionWizardPage(ISOBJECT_SELECTION_WIZARD_PAGE_NAME, wizardPageTitle, wizardPageTitleImage, treeRoot, many);
        addPage(page);
    }
    
    /**
     * Determines whether the tree should be unfolded by default.
     * Default is true.
     * 
     * @param expanded
     */
    public void setExpandedByDefault(boolean expanded) {
    	page.setExpandedByDefault(expanded);
    }

	public void setLevelToExpand(int levelToExpand) {
		page.setLevelToExpand(levelToExpand);
	}
	
	public void setSelectionInductor(ISelectionInductor selectionInductor) {
		page.setSelectionInductor(selectionInductor);
	}
    
    public void setPreSelectedEObjects(Collection<EObject> preSelectedEObjects) {
    	page.setPreSelectedEObjects(preSelectedEObjects);
    }
    
    public void setPreSelectedTreeItemWrappers(Collection<EObjectTreeItemWrapper> preSelectedTreeItemWrappers) {
    	page.setPreSelectedTreeItemWrappers(preSelectedTreeItemWrappers);
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

    public EObjectTreeItemWrapper getSelectedTreeItemWrapper() {
        return page.getSelectedTreeItemWrapper();
    }
    
    public EObject getSelectedEObject() {
        return page.getSelectedEObject();
    }

    public Collection<EObjectTreeItemWrapper> getSelectedTreeItemWrappers() {
        return page.getSelectedTreeItemWrappers();
    }
    
    public Collection<EObject> getSelectedEObjects() {
        return page.getSelectedEObjects();
    }
    
    public Collection<EObjectTreeItemWrapper> getPartiallySelectedTreeItemWrappers() {
    	return page.getPartiallySelectedTreeItemWrappers();
    }
    
    public Collection<EObject> getPartiallySelectedEObjects() {
        return page.getPartiallySelectedEObjects();
    }

	public int open() {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        final WizardDialogClosableByWizard dlg = new WizardDialogClosableByWizard(shell, this);
        dlg.setMinimumPageSize(200, 460);
        this.setDialog(dlg);
		
		return dlg.open();
	}

	public void setPageCompleteTester(IPageCompleteTester pageCompleteTester) {
		page.setPageCompleteTester(pageCompleteTester);
	}

}
