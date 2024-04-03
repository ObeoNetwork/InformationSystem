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
package org.obeonetwork.dsl.cinematic.design.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.obeonetwork.dsl.cinematic.design.services.CinematicLayoutServices;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class PreviewLayoutHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IDDiagramEditPart selectedDDiagramEditPart = EventHelper.uwrapSingleSelection(event, IDDiagramEditPart.class);
		DDiagram layoutDDiagram = selectedDDiagramEditPart.resolveDDiagram().get();
		Layout layout = (Layout) new DDiagramQuery(layoutDDiagram).getRepresentationDescriptor().getTarget();
		
		Session session = new EObjectQuery(layoutDDiagram).getSession();
		if (session != null) {
			TransactionalEditingDomain ted = session.getTransactionalEditingDomain();

			ted.getCommandStack().execute(new RecordingCommand(ted) {

				@Override
				protected void doExecute() {
					CinematicLayoutServices.previewLayout(layout, layoutDDiagram);
				}
			});

		}
		
		return null;
	}

	
}
