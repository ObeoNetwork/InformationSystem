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
package org.obeonetwork.dsl.database.triggers;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.IndexElement;

/**
 * Trigger to synchronize index when a column is deleted 
 * @author Stephane Thibaudeau
 *
 */
public class DeleteColumnChangeTrigger implements ModelChangeTrigger{

	public static final NotificationFilter IS_DELETE_COLUMN = NotificationFilter.createFeatureFilter(DatabasePackage.Literals.COLUMN__INDEX_ELEMENTS)
			.and(NotificationFilter.createEventTypeFilter(Notification.REMOVE));
	
	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		for (Notification notification : notifications) {
			Object notifier = notification.getNotifier();
			Object oldValue = notification.getOldValue();
			if (notifier instanceof Column && oldValue instanceof IndexElement) {
				// A column has been deleted and it was involved in an index
				// We have to delete the index element too
				final IndexElement indexElt = (IndexElement)oldValue;
				// We check if the index element still has a container
				// if not it means it was deleted from the model
				// thus we don't have to delete it anyway
				if (indexElt.eContainer() != null) {
					Optional<Session> sessionOpt = Session.of(indexElt);
					if (sessionOpt.isPresent()) {
						Session session = sessionOpt.get();
						final TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
						final Command result = new RecordingCommand(domain) {
							
							@Override
							protected void doExecute() {
								SiriusUtil.delete(indexElt, session);
							}
						};
						return Options.newSome(result);
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