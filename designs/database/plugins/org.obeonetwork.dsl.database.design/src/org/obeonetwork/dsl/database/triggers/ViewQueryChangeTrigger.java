/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.triggers;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.design.services.DatabaseServices;
import org.obeonetwork.utils.common.StringUtils;

/**
 * Trigger to check if a query changed in order to update 
 * tables and columns references.
 * @author fbats
 *
 */
public class ViewQueryChangeTrigger implements ModelChangeTrigger{
/*
 * This trigger is a workaround to update tables and columns using commands.
 * 
 * A first implementation done using an adapter to recompute tables and columns
 * show some troubles for diagram refresh when user use undo/redo.
 * 
 */

	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		List<Notification> queryChangeNotifications = notifications.stream().filter(IS_QUERY_CHANGE).collect(Collectors.toList());
		for(Notification notification: queryChangeNotifications) {
			final View view = (View) notification.getNotifier();
			final String query = view.getQuery();
			final Session session = SessionManager.INSTANCE.getSession(view);
			final TransactionalEditingDomain domain = session.getTransactionalEditingDomain();

			if (!StringUtils.isNullOrWhite(query)) {
				final Command command = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						DatabaseServices.updateViewContent(view);
					}
				};
				return Options.newSome(command);
			} else {
				final Command command = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						if (view.getColumns() != null){
							view.getColumns().clear();
						}
						if (view.getTables() != null) {
							view.getTables().clear();
						}
					}
				};
				return Options.newSome(command);
			}
		}
		return Options.newNone();
	}

	@Override
	public int priority() {
		return 1;
	}


	/**
	 * Filter Query modification notifications.
	 */
	public static final Predicate<Notification> IS_QUERY_CHANGE = new Predicate<Notification>() {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean test(Notification input) {
			if (input.isTouch())
				return false;
			if (input.getEventType() == Notification.ADD || input.getEventType() == Notification.ADD_MANY || input.getEventType() == Notification.SET) {
				return input.getFeature() == DatabasePackage.Literals.VIEW__QUERY;
			}
			return false;
		}
	};
}