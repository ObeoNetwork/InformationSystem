/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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
package org.obeonetwork.tools.linker.ui.view;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.obeonetwork.tools.linker.EObjectLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class EObjectLinksViewAction extends Action implements EObjectLinksView.ViewListener {

	protected EObjectLinksView linksView;

	/**
	 * @param linksView
	 */
	public EObjectLinksViewAction(EObjectLinksView linksView) {
		this.linksView = linksView;
		this.linksView.addListener(this);
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView.ViewListener#fireInputChanged(org.eclipse.emf.ecore.EObject)
	 */
	public void fireInputChanged(EObject newInput) {
		//Note : default implementation - do nothing
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView.ViewListener#fireSelectionChanged(java.util.List)
	 */
	public void fireSelectionChanged(List<EObjectLink> newSelection) {
		//Note : default implementation - do nothing
	}

	
}
