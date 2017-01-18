package fr.gouv.mindef.safran.project.lifecycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DRepresentation;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import fr.obeo.dsl.viewpoint.collab.api.RepositoryConnectionException;
import fr.obeo.dsl.viewpoint.collab.api.remotesession.CollaborativeSession;

public class ImporterUtil {
	
	public static boolean isOfAnyClass(EObject object, Collection<EClass> eClasses) {
		for (EClass eClass : eClasses) {
			if (eClass.isInstance(object)) {
				return true;
			}
		}
		return false;
	}
	

	public static Collection<DRepresentation> getRelatedRepresentations(Session session, Collection<EObject> semanticElements) {
		Collection<DRepresentation> representations = new ArrayList<DRepresentation>();
		
		for (EObject semanticElement : semanticElements) {
			representations.addAll(DialectManager.INSTANCE.getRepresentations(semanticElement, session));
		}
		return representations;
	}
	
	public static boolean isRemoteSession(Session session) {
		if (session instanceof CollaborativeSession) {
			try {
				return ((CollaborativeSession) session).getRepositoryManager() != null;
			} catch (RepositoryConnectionException e) {
				return false;
			}
		}
		return false;
	}
	
	public static Collection<ReferenceData> getReferencingElements(Collection<EObject> elements, Session session) {
		Collection<ReferenceData> referencesData = new ArrayList<ReferenceData>();
		
		Collection<EObject> allElements = getAllElementsWithChildren(elements);
		
		for (EObject element : allElements) {
			Collection<Setting> inverseReferences = session.getSemanticCrossReferencer().getInverseReferences(element, true);
			for (Setting setting : inverseReferences) {
				referencesData.add(new ReferenceData(element, setting));
			}		
		}
		return referencesData;
	}
	
	
	public static Collection<EObject> getAllElementsWithChildren(Collection<EObject> roots) {
		Collection<EObject> children = new ArrayList<EObject>(roots);
		// Collect all children
		for (EObject root : roots) {
			Collection<EObject> ownedChildren = Lists.newArrayList(root.eAllContents());
			children.addAll(ownedChildren);
		}
		return children;
	}
	
	public static <T extends EObject> List<T> getAllContentsOfType(EObject root, Class<T> type) {
		return Lists.newArrayList(Iterators.filter(root.eAllContents(), type));
	}
	
}
