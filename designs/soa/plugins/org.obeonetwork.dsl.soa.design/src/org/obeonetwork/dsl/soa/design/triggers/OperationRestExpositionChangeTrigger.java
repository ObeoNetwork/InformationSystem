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
package org.obeonetwork.dsl.soa.design.triggers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.soa.ExpositionKind;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;

public class OperationRestExpositionChangeTrigger implements ModelChangeTrigger {

	public static final NotificationFilter IS_OPERATION_REST_EXPOSITION_CHANGE = 
			NotificationFilter.createFeatureFilter(SoaPackage.Literals.OPERATION__EXPOSITION)
			.and(NotificationFilter.createEventTypeFilter(Notification.SET));
	
	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		for(Notification notification : notifications) {
			if(notification.getNotifier() instanceof Operation && notification.getNewValue() instanceof ExpositionKind) {
				Operation operation = (Operation) notification.getNotifier();
				ExpositionKind expositionKind = (ExpositionKind) notification.getNewValue();
				Optional<Session> sessionOpt = Session.of(operation);
				if(sessionOpt.isPresent()) {
					Session session = sessionOpt.get();
					final TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
					if(expositionKind == ExpositionKind.REST) {
						List<Parameter> parametersToUpdate = operation.getInput().stream().filter(p -> p.getRestData() == null).collect(Collectors.toList());
						if(!parametersToUpdate.isEmpty()) {
							final Command command = new RecordingCommand(ted) {
								@Override
								protected void doExecute() {
									parametersToUpdate.forEach(p -> p.setRestData(SoaFactory.eINSTANCE.createParameterRestData()));
								}
							};
							return Options.newSome(command);
						}
					} else {
						List<Parameter> parametersToUpdate = operation.getInput().stream().filter(p -> p.getRestData() != null).collect(Collectors.toList());
						if(!parametersToUpdate.isEmpty()) {
							final Command command = new RecordingCommand(ted) {
								@Override
								protected void doExecute() {
									parametersToUpdate.forEach(p -> p.setRestData(null));
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
