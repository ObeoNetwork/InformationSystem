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
package org.obeonetwork.dsl.environment.design.wizards;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.common.ui.tools.api.selection.WizardDialogClosableByWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.ICheckBoxFilter;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.IPageCompleteTester;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.ISelectionInductor;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.SelectMode;

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
    		ISObjectTreeItemWrapper treeRoot,
    		boolean many) {
        setWindowTitle(windowTitle);
        page = new ISObjectSelectionWizardPage(ISOBJECT_SELECTION_WIZARD_PAGE_NAME, wizardPageTitle, wizardPageTitleImage, treeRoot, many);
        addPage(page);
    }
    
    public ISObjectSelectionWizardPage getPage() {
		return page;
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
	
	public void setTreeSelectMode(SelectMode treeSelectMode) {
		page.setTreeSelectMode(treeSelectMode);
	}
	
	public void setCheckBoxFilter(ICheckBoxFilter checkBoxFilter) {
		page.setCheckBoxFilter(checkBoxFilter);
	}
	
	public void setSelectionInductor(ISelectionInductor selectionInductor) {
		page.setSelectionInductor(selectionInductor);
	}
    
    public void setPreSelectedObjects(Collection<? extends Object> preSelectedObjects) {
    	page.setPreSelectedObjects(preSelectedObjects);
    }
    
    public void setPreSelectedTreeItemWrappers(Collection<ISObjectTreeItemWrapper> preSelectedTreeItemWrappers) {
    	page.setPreSelectedTreeItemWrappers(preSelectedTreeItemWrappers);
    }
    
    public void setAlwaysSelectedObjects(Collection<? extends Object> alwaysSelectedObjects) {
    	page.setAlwaysSelectedObjects(alwaysSelectedObjects);
    }
    
	public void setAlwaysSelectedTreeItemWrappers(Collection<ISObjectTreeItemWrapper> alwaysSelectedTreeItemWrappers) {
		page.setAlwaysSelectedTreeItemWrappers(alwaysSelectedTreeItemWrappers);
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

    public ISObjectTreeItemWrapper getSelectedTreeItemWrapper() {
        return page.getSelectedTreeItemWrapper();
    }
    
    public Object getSelectedObject() {
        return page.getSelectedObject();
    }

    public Collection<ISObjectTreeItemWrapper> getSelectedTreeItemWrappers() {
        return page.getSelectedTreeItemWrappers();
    }
    
	public Collection<ISObjectTreeItemWrapper> getAlwaysSelectedTreeItemWrappers() {
		return page.getAlwaysSelectedTreeItemWrappers();
	}
    
    public Collection<Object> getSelectedObjects() {
        return page.getSelectedObjects();
    }
    
    public <T> Collection<T> getSelectedObjects(Class<T> type) {
        return page.getSelectedObjects().stream()
        		.filter(e -> type.isInstance(e))
        		.map(e -> type.cast(e))
        		.collect(toList());
    }
    
    public Collection<ISObjectTreeItemWrapper> getPartiallySelectedTreeItemWrappers() {
    	return page.getPartiallySelectedTreeItemWrappers();
    }
    
    public Collection<Object> getPartiallySelectedObjects() {
        return page.getPartiallySelectedObjects();
    }

    public <T> Collection<T> getPartiallySelectedObjects(Class<T> type) {
        return page.getPartiallySelectedObjects().stream()
        		.filter(e -> type.isInstance(e))
        		.map(e -> type.cast(e))
        		.collect(toList());
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
