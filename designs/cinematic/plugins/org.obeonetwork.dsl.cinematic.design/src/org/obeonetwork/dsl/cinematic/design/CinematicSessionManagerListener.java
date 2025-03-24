/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManagerListener;


public class CinematicSessionManagerListener extends SessionManagerListener.Stub {

	@Override
	public void notify(Session session, int notification) {
		if(notification == SessionListener.OPENING) {
			registerTrigger(session);
		}
	}

	private void registerTrigger(Session session) {
		
		final CinematicLayoutTrigger cinematicLayoutTrigger = new CinematicLayoutTrigger(session.getTransactionalEditingDomain());
		session.getEventBroker().addLocalTrigger(
				CinematicLayoutTrigger.IS_MOCKUP_DIAGRAM_LAYOUTED, 
				cinematicLayoutTrigger);

		session.addListener(new SessionListener() {

			@Override
			public void notify(int notification) {
				if(notification == SessionListener.CLOSING) {
					session.getEventBroker().removeLocalTrigger(cinematicLayoutTrigger);
				}
			}
		});
		
	}
	
}
