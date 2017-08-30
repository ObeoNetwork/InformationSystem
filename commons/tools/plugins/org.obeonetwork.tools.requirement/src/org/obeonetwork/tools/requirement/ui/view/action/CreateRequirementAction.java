/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.requirement.ui.view.action;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ui.ISharedImages;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.wizard.operation.RequirementCreationOperation;
import org.obeonetwork.tools.requirement.wizard.util.RequirementCreationPropertiesEditingContext;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
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
		EditingDomain editingDomain = TransactionUtil.getEditingDomain(linksView.getInput());
		RequirementCreationPropertiesEditingContext propertiesEditionContext = new RequirementCreationPropertiesEditingContext(
				null, null, editingDomain, linksView.getAdapterFactory(), linksView.getInput());
		RequirementCreationOperation operation = new RequirementCreationOperation(propertiesEditionContext);
		try {
			operation.execute(new NullProgressMonitor(), null);
			linksView.refresh();
		} catch (ExecutionException e) {
			EEFRuntimePlugin.getDefault().logError("An error occured during wizard editing.", e); //$NON-NLS-1$
		}
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
