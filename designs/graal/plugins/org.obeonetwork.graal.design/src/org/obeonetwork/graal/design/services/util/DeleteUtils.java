package org.obeonetwork.graal.design.services.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.google.common.base.Predicate;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

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
		vpModelAccessor.eDelete(object, vpSession.getSemanticCrossReferencer(), new Predicate<EReference>() {
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
