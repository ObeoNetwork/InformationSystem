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
package org.obeonetwork.graal.design.services.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ext.emf.EReferencePredicate;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

public class DeleteUtils {
	public static void delete(EObject object, Session session, ModelAccessor modelAccessor) {
		Session vpSession = session;
		ModelAccessor vpModelAccessor = modelAccessor;
		if (vpSession == null) {
			vpSession = SessionManager.INSTANCE.getSession(object);
		}
		if (vpModelAccessor == null) {
			vpModelAccessor = vpSession.getModelAccessor();
		}
		vpModelAccessor.eDelete(object, vpSession.getSemanticCrossReferencer(), new EReferencePredicate() {
	        public boolean apply(EReference reference) {
	            return DSemanticDecorator.class.isAssignableFrom(reference.getContainerClass());
	        }
	    });
	}
	
	public static void delete(EObject object, Session session) {
		delete(object, session, null);
	}

	public static void delete(EObject object) {
		delete(object, null, null);
	}
}
