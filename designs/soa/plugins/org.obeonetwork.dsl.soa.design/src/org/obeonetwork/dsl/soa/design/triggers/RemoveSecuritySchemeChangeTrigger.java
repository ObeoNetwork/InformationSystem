/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SoaPackage;

public class RemoveSecuritySchemeChangeTrigger extends ResourceSetListenerImpl {

	@Override
	public boolean isPrecommitOnly() {
		return true;
	}
	
	private static final NotificationFilter IS_REMOVE_SECURITY_SCHEME = 
			NotificationFilter.createFeatureFilter(SoaPackage.Literals.COMPONENT__SECURITY_SCHEMES)
			.and(NotificationFilter.createEventTypeFilter(Notification.REMOVE)
					.or(NotificationFilter.createEventTypeFilter(Notification.REMOVE_MANY)));
	
	@Override
	public NotificationFilter getFilter() {
		return IS_REMOVE_SECURITY_SCHEME;
	}

	
	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		return localChangesAboutToCommit(event.getNotifications()).get();
	}


	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		for(Notification notification : notifications) {
			if(notification.getOldValue() instanceof SecurityScheme) {
				SecurityScheme securityScheme = (SecurityScheme) notification.getOldValue();
				Optional<Session> sessionOpt = Session.of((EObject) notification.getNotifier());
				if (sessionOpt.isPresent()) {
					Session session = sessionOpt.get();
					final TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
					final Command command = new RecordingCommand(ted) {
						
						@Override
						protected void doExecute() {
							session.getSemanticCrossReferencer().getInverseReferences(
									securityScheme, SoaPackage.eINSTANCE.getSecurityApplication_SecurityScheme(), true)
							.stream().map(setting -> setting.getEObject())
							.forEach(e -> SiriusUtil.delete(e, session));
						}
					};
					return Options.newSome(command);
				}
			}
		}
		
		return Options.newNone();
	}

}
