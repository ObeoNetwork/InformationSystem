/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.business.api.query.DDiagramQuery;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.cinematic.design.services.CinematicLayoutServices;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

public class CinematicLayoutTrigger implements ModelChangeTrigger {

	private final TransactionalEditingDomain ted;
	
	public CinematicLayoutTrigger(TransactionalEditingDomain ted) {
		this.ted = ted;
	}

	public static final NotificationFilter IS_MOCKUP_DIAGRAM_LAYOUTED = new NotificationFilter.Custom() {

		@Override
		public boolean matches(Notification notification) {
			
			if(!notification.isTouch() && notification.getNotifier() instanceof Bounds) {
				DDiagram parentDiagram = getParentDiagram((Bounds) notification.getNotifier());
				return parentDiagram != null && 
						ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID.equals(parentDiagram.getDescription().getName());
			}
			
			return false;

		}
	};
	
	private static DDiagram getParentDiagram(Bounds bounds) {
		DDiagram dDiagram = null;
		
		if(bounds.eContainer() instanceof Node) {
			Node node = (Node) bounds.eContainer();
			if(node.getElement() instanceof DDiagramElement) {
				DDiagramElement dDiagramElement = (DDiagramElement) node.getElement();
				dDiagram = dDiagramElement.getParentDiagram();
			}
		}
		
		return dDiagram;
	}
	
	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		final Collection<DDiagram> mockupDiagrams = notifications.stream()
		.filter(n -> n.getNotifier() instanceof Bounds)
		.map(n -> getParentDiagram((Bounds)n.getNotifier()))
		.filter(d -> d != null)
		.filter(d -> ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID.equals(d.getDescription().getName()))
		.collect(toSet());
		
		if(!mockupDiagrams.isEmpty()) {
			Command command = new RecordingCommand(ted) {
				@Override
				protected void doExecute() {
					for(DDiagram mockupDiagram : mockupDiagrams) {
						ViewContainer viewContainer = (ViewContainer) new DDiagramQuery(mockupDiagram).getRepresentationDescriptor().getTarget();
						viewContainer.setLayout(CinematicLayoutServices.extractLayout(mockupDiagram));
					}
				}
			};
			
			return Options.newSome(command);
		}
		
		return Options.newNone();
	}

	@Override
	public int priority() {
		return 0;
	}

}
