package org.obeonetwork.dsl.environment.design.services;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;

import com.google.common.base.Predicate;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.business.api.query.EObjectQuery;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.mda.ecore.extender.business.api.accessor.ModelAccessor;

public class DeleteServices {
	
	public void deleteObeoDSMObject(NamespacesContainer namespacesContainer) {
		for (Namespace namespace : namespacesContainer.getOwnedNamespaces()) {
			deleteObeoDSMObject((NamespacesContainer)namespace);
		}
		if (namespacesContainer instanceof Namespace) {
			Namespace namespace = (Namespace)namespacesContainer;
			for (Type type : namespace.getTypes()) {
				deleteObeoDSMObject(type);
			}
		}
		delete(namespacesContainer);
	}
	
	public void deleteObeoDSMObject(StructuredType type) {
		// First we have to delete all references pointing towards this type
		Session session = getSession(type);
		ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
		Collection<Setting> inverseReferences = crossReferencer.getInverseReferences(type, true);
		for (Setting setting : inverseReferences) {
			if (EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE == setting.getEStructuralFeature()) {
				delete((ObeoDSMObject)setting.getEObject(), session);
			}
		}
		delete(type);
	}

	public void deleteObeoDSMObject(ObeoDSMObject object) {
		delete(object);
	}
	
	private void delete(EObject object, Session session, ModelAccessor modelAccessor) {
		Session vpSession = session;
		ModelAccessor vpModelAccessor = modelAccessor;
		if (vpSession == null) {
			vpSession = getSession(object);
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
	
	private void delete(EObject object, Session session) {
		delete(object, session, null);
	}

	private void delete(EObject object) {
		delete(object, null, null);
	}
	
	private Session getSession(EObject object) {
		return new EObjectQuery(object).getSession();
	}
}
