/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.requirement.ui.view.action;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.wizard.page.CategorySelectionPage;
import org.obeonetwork.utils.common.ui.EEFPropertiesPageDialog;

/**
 * @author Obeo
 *
 */
public class CreateRequirementAction extends EObjectLinksViewAction {

	private static final Point INITIAL_WIZARD_SIZE = new Point(650, 800);
	
	/**
	 * @param linksView
	 */
	public CreateRequirementAction(EObjectLinksView linksView) {
		super(linksView);
		this.setText(RequirementLinkerPlugin.getInstance().getString("CreateRequirementAction_title")); //$NON-NLS-1$
		this.setToolTipText(RequirementLinkerPlugin.getInstance().getString("CreateRequirementAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(RequirementLinkerPlugin.getInstance().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		this.setEnabled(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		EObject requirementTarget = linksView.getInput();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(requirementTarget);
		
		AbstractEMFOperation operation = new AbstractEMFOperation(editingDomain, getText()) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				
				Category newContainer = getCategoryFromUser(requirementTarget);
				if (newContainer == null) {
					return Status.CANCEL_STATUS;
				}

				Requirement created = createRequirementFor(newContainer, requirementTarget);

				Dialog dialog = new EEFPropertiesPageDialog(linksView, created, true);
				if (dialog.open() != Dialog.OK) {
					return Status.CANCEL_STATUS;
				}
				
				return Status.OK_STATUS;
			}
			
		};
		
		try {
			operation.execute(new NullProgressMonitor(), null);
			linksView.refresh();
		} catch (ExecutionException e) {
			RequirementLinkerPlugin.getInstance()
				.getLog()
				.error("An error occured while creating Requirement.", e); //$NON-NLS-1$
		}
	}
	
	private Requirement createRequirementFor(Category container, EObject target) {
		Requirement result = RequirementFactory.eINSTANCE.createRequirement();
		result.getReferencedObject().add(target);
		container.getRequirements().add(result);
		return result;
	}

	private Category getCategoryFromUser(EObject requirementTarget) {
		AtomicReference<Category> newContainer = new AtomicReference<>();
		
		Wizard wizard = new Wizard() {

			private CategorySelectionPage page;
			
			@Override
			public void addPages() {
				page = new CategorySelectionPage();
				page.init(requirementTarget);
				super.addPages();
				
				addPage(page);
			}
			
			@Override
			public boolean performFinish() {
				newContainer.set(page.getSelection());
				return true;
			}
			
		};
		WizardDialog dialog = new WizardDialog(linksView.getSite().getShell(), wizard) {

			@Override
			protected Point getInitialSize() {
				Point initialSize = super.getInitialSize();
				return new Point(Math.min(INITIAL_WIZARD_SIZE.x, initialSize.x),
						Math.min(INITIAL_WIZARD_SIZE.y, initialSize.y));
			}

			@Override
			protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
				// Fake wizard as simple dialog
				String realLabel = label;
				if (id == IDialogConstants.FINISH_ID) {
					realLabel = IDialogConstants.OK_LABEL;
				}
				return super.createButton(parent, id, realLabel, defaultButton);
			}
			
		};
		
		return dialog.open() == Window.OK
				? newContainer.get()
				: null;
		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction#fireInputChanged(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void fireInputChanged(EObject newInput) {
		setEnabled(newInput != null);
	}

}
