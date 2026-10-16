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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISharedImages;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;
import org.obeonetwork.utils.common.ui.EEFPropertiesPageDialog;

/**
 * @author Obeo
 *
 */
public class CreateRequirementAction extends EObjectLinksViewAction {

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

	private static List<EObject> getRequirementTreeNodeChildren(Object parent) {
		List<EObject> children = new ArrayList<>();
		
		if(parent instanceof Resource resource) {
			resource.getContents().stream()
			.filter(Repository.class::isInstance).map(Repository.class::cast)
			.forEach(repo -> children.add(repo));
		} else if(parent instanceof Repository repository)  {
			children.addAll(repository.getMainCategories());
		}  else if(parent instanceof Category category)  {
			children.addAll(category.getSubCategories());
		}
		
		return children;
		
	}
	
	private Category getCategoryFromUser(EObject requirementTarget) {
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(CreateRequirementAction::getRequirementTreeNodeChildren);
		
		treeRoot.getConfiguration().setSelectableCondition(Category.class::isInstance);
		
		for(Resource repositoryResource : RequirementService.findRequirementsRepositories(requirementTarget)) {
			new ISObjectTreeItemWrapper(treeRoot, repositoryResource);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		"Category selection", 
        		"Choose the category to hold the requirement.", 
        		null, 
        		treeRoot,
        		false);
        
        wizard.setLevelToExpand(3);
        
        Category selectedCategory = null;
        if(wizard.open() == Window.OK) {
        	selectedCategory = (Category) wizard.getSelectedObject();
        }
        
		return selectedCategory;
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
