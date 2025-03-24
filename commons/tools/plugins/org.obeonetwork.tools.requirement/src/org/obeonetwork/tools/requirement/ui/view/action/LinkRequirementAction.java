/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;

/**
 * @author Obeo
 *
 */
public class LinkRequirementAction extends EObjectLinksViewAction {

	/**
	 * @param linksView
	 */
	public LinkRequirementAction(EObjectLinksView linksView) {
		super(linksView);
		this.setText(RequirementLinkerPlugin.getInstance().getString("LinkRequirementAction_title")); //$NON-NLS-1$
		this.setToolTipText(RequirementLinkerPlugin.getInstance().getString("LinkRequirementAction_description")); //$NON-NLS-1$
		this.setImageDescriptor(RequirementLinkerPlugin.getInstance().getImageDescriptor(RequirementLinkerPlugin.LINK));
		this.setEnabled(false);
	}

	private static List<EObject> getRequirementTreeNodeChildren(Object parent) {
		List<EObject> children = new ArrayList<>();
		
		if(parent instanceof Resource) {
			Resource resource = (Resource) parent;
			resource.getContents().stream()
			.filter(Repository.class::isInstance).map(Repository.class::cast)
			.forEach(repo -> children.add(repo));
		} else if(parent instanceof EObject)  {
			EObject eObject = (EObject) parent;
			children.addAll(eObject.eContents());
		}
		
		return children;
		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if (linksView.getInput() == null) {
			return;
		}
		
		EObject context = linksView.getInput();
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(
				LinkRequirementAction::getRequirementTreeNodeChildren);
		
		treeRoot.getConfiguration().setSelectableCondition(Requirement.class::isInstance);
		
		for(Resource repositoryResource : RequirementService.findRequirementsRepositories(context)) {
			new ISObjectTreeItemWrapper(treeRoot, repositoryResource);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		"Link Requirements", 
        		"Select the requirements to be linked to this element.", 
        		null, 
        		treeRoot,
        		true);
        
        wizard.setLevelToExpand(2);
        
        Collection<Requirement> preSelectedRequirements = RequirementService.getLinkedRequirementsSet(context);
		wizard.setPreSelectedObjects(preSelectedRequirements);
        
		if(wizard.open() == Window.OK) {
			TransactionalEditingDomain ted = new EObjectQuery(context).getSession().getTransactionalEditingDomain();
			ted.getCommandStack().execute(new RecordingCommand(ted, "Link Requirements") {
				
				@Override
				protected void doExecute() {
					Collection<Requirement> selectedRequirements = wizard.getSelectedObjects()
							.stream().map(Requirement.class::cast).collect(toList());
					// Unlink deselected requirements
					for(Requirement preSelectedRequirement : preSelectedRequirements) {
						if(!selectedRequirements.contains(preSelectedRequirement)) {
							preSelectedRequirement.getReferencedObject().remove(context);
						}
					}
					// Link newly selected requirements
					for(Requirement selectedRequirement : selectedRequirements) {
						if(!preSelectedRequirements.contains(selectedRequirement)) {
							selectedRequirement.getReferencedObject().add(context);
						}
					}
				}
			});
			
		}
		
		linksView.refresh();
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
