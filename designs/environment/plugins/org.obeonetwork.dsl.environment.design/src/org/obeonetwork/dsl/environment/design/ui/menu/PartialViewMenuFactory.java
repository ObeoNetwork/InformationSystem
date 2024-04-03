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
package org.obeonetwork.dsl.environment.design.ui.menu;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;
import org.obeonetwork.utils.common.ui.handlers.SelectionHelper;

public class PartialViewMenuFactory extends ExtensionContributionFactory {

	public PartialViewMenuFactory() {
		super();
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {

		ISelectionService service = serviceLocator.getService(ISelectionService.class);
		ISelection selection = service.getSelection();
		EObject context = SelectionHelper.uwrapSingleSelection(selection, EObject.class);

		Session session = SessionManager.INSTANCE.getSession(context);

		Set<String> partialViewDescriptionNames = PartialViewExtension.getPartialViewDescriptionNames();
		
		DialectManager.INSTANCE.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), context).stream()
			.filter(rd -> partialViewDescriptionNames.contains(rd.getName()))
			.forEach(representationDescription -> 
				additions.addContributionItem(new ActionContributionItem(new PartialViewCreationAction(context, representationDescription)), null));

	}

}
