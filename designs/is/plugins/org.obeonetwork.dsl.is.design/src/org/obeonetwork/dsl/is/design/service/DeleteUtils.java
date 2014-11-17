package org.obeonetwork.dsl.is.design.service;

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
