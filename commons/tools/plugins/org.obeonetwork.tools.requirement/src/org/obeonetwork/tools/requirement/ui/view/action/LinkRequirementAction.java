/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksViewAction;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.ui.dialog.LinkRequirementsDialog;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if (linksView.getInput() != null) {
			Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
			LinkRequirementsDialog linkRequirementsDialog = new LinkRequirementsDialog(shell, linksView.getInput());
			linkRequirementsDialog.open();
			linksView.refresh();
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
