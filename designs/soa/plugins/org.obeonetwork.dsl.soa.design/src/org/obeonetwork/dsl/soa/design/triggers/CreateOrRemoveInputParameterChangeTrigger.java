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
package org.obeonetwork.dsl.soa.design.triggers;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;

public class CreateOrRemoveInputParameterChangeTrigger implements ModelChangeTrigger {

	public static final NotificationFilter IS_CREATE_OR_REMOVE_INPUT_PARAMETER = 
			NotificationFilter.createFeatureFilter(SoaPackage.Literals.OPERATION__INPUT)
			.and(NotificationFilter.createEventTypeFilter(Notification.ADD)
					.or(NotificationFilter.createEventTypeFilter(Notification.ADD_MANY))
					.or(NotificationFilter.createEventTypeFilter(Notification.REMOVE))
					.or(NotificationFilter.createEventTypeFilter(Notification.REMOVE_MANY)));
	
	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		for(Notification notification : notifications) {
			if(notification.getEventType() == Notification.ADD || notification.getEventType() == Notification.ADD_MANY) {
				// Input parameter creation
				if(notification.getNotifier() instanceof Operation && notification.getNewValue() instanceof Parameter) {
					Parameter inputParameter = (Parameter) notification.getNewValue();
					if(inputParameter.getRestData() == null) {
						Optional<Session> sessionOpt = Session.of(inputParameter);
						if (sessionOpt.isPresent()) {
							Session session = sessionOpt.get();
							final TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
							final Command command = new RecordingCommand(ted) {
								
								@Override
								protected void doExecute() {
									inputParameter.setRestData(SoaFactory.eINSTANCE.createParameterRestData());
								}
							};
							return Options.newSome(command);
						}
					}
				}
			} else if(notification.getEventType() == Notification.REMOVE || notification.getEventType() == Notification.REMOVE_MANY) {
				// Input parameter deletion
				if(notification.getNotifier() instanceof Operation && notification.getOldValue() instanceof Parameter) {
					Parameter parameter = (Parameter) notification.getOldValue();
					if(parameter.getRestData() != null) {
						Optional<Session> sessionOpt = Session.of(parameter);
						if (sessionOpt.isPresent()) {
							Session session = sessionOpt.get();
							final TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
							final Command command = new RecordingCommand(ted) {
								
								@Override
								protected void doExecute() {
									parameter.setRestData(null);
								}
							};
							return Options.newSome(command);
						}
					}
				}
			}
		}
		
		return Options.newNone();
	}

	@Override
	public int priority() {
		return 1;
	}

}
