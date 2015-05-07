package org.obeonetwork.dsl.environment.binding.design.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.tools.api.interpreter.InterpreterUtil;
import org.eclipse.sirius.ui.business.api.session.UserSession;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;

public class BindingService {
	
	private static final String BINDING_EDITOR_DESCRIPTION_NAME = "Binding Details";
	
	public EObject debugContext(EObject context) {
		IInterpreter interpreter = InterpreterUtil.getInterpreter(context);
		System.out.println(interpreter.getVariables().keySet());
		return context;
	}
	
	public Collection<EObject> allRootsForBinding(EObject any) {
		Collection<EObject> roots = new ArrayList<EObject>();

		Session session = SessionManager.INSTANCE.getSession(any);

		if (session != null) {
			for (Resource childRes : session.getSemanticResources()) {
				roots.addAll(childRes.getContents());
			}
		}

		return roots;
	}

	private Collection<Resource> getAllSemanticResourcesInSession(EObject any) {
		Session session = SessionManager.INSTANCE.getSession(any);
		if (session != null) {
			return session.getSemanticResources();
		}
		return Collections.emptyList();
	}

	public Collection<StructuredType> getAllBindableElements(DSemanticDiagram diagram, StructuredType structuredType) {
		// Collect all structured types
		Collection<StructuredType> bindableElements = new ArrayList<StructuredType>();

		// First get all structured types
		bindableElements.addAll(getAllStructuredTypes(structuredType));
		
		// Remove the target element
		bindableElements.remove(structuredType);
		
		// Remove elements already bound with the target
		for (BindingInfo bindingInfo : getAllBindingInfosOnDiagram(diagram)) {
			if (bindingInfo.getLeft() == structuredType) {
				bindableElements.remove(bindingInfo.getRight());
			}
			if (bindingInfo.getRight() == structuredType) {
				bindableElements.remove(bindingInfo.getLeft());
			}
		}
		
		return bindableElements;
	}
	
	private Collection<BindingInfo> getAllBindingInfosOnDiagram(DSemanticDiagram diagram) {
		Collection<BindingInfo> bindingInfos = new ArrayList<BindingInfo>();
		for (DNode node : diagram.getNodes()) {
			if (node.getTarget() instanceof BindingInfo) {
				bindingInfos.add((BindingInfo)node.getTarget());
			}
		}
		return bindingInfos;
	}
	
	private Collection<StructuredType> getAllStructuredTypes(EObject any) {
		// Collect all structured types
		Collection<StructuredType> structuredTypes = new ArrayList<StructuredType>();

		// First, get all semantic resources in session
		Collection<Resource> semanticResources = getAllSemanticResourcesInSession(any);

		for (Resource resource : semanticResources) {
			TreeIterator<EObject> iterator = EcoreUtil.getAllContents(resource, true);
			while (iterator.hasNext()) {
				EObject eObject = (EObject) iterator.next();
				if (eObject instanceof StructuredType) {
					structuredTypes.add((StructuredType) eObject);
				} else {
					if (!(eObject instanceof TypesDefinition
							|| eObject instanceof NamespacesContainer
							|| isOverviewRootInstance(eObject))) {
						iterator.prune();
					}
				}
			}
		}

		return structuredTypes;
	}

	private boolean isOverviewRootInstance(EObject object) {
		EClass eClass = object.eClass();
		return "Root".equals(eClass.getName())
				&& eClass.getEPackage().getNsURI()
						.startsWith("http://www.obeonetwork.org/dsl/overview/");
	}

	public Collection<BindingInfo> getRelatedBindingInfos(Namespace namespace) {
		// Use of LinkedHashSet to keep order and avoid potential lock/unlock
		// loops problems
		Set<BindingInfo> results = new LinkedHashSet<BindingInfo>();

		// BindingInfos to be displayed for a namespace are :
		// - the instances directly contained by the namespace
		// - bindings concerning a Structured Type directly from the namespace

		for (BindingRegistry bindingRegistry : namespace.getBindingRegistries()) {
			results.addAll(bindingRegistry.getBindingInfos());
		}

		for (Type containedType : namespace.getTypes()) {
			if (containedType instanceof StructuredType) {
				StructuredType containedStructuredType = (StructuredType) containedType;
				results.addAll(getRelatedBindingInfos(containedStructuredType));
			}
		}

		return results;
	}

	private Collection<BindingInfo> getRelatedBindingInfos(StructuredType structuredType) {
		EObjectQuery query = new EObjectQuery(structuredType);
		Collection<EObject> targets = new HashSet<EObject>();
		targets.addAll(query.getInverseReferences(EnvironmentPackage.Literals.BINDING_INFO__LEFT));
		targets.addAll(query.getInverseReferences(EnvironmentPackage.Literals.BINDING_INFO__RIGHT));
		Collection<BindingInfo> bindingInfos = new ArrayList<BindingInfo>();
		for (EObject target : targets) {
			if (target instanceof BindingInfo) {
				bindingInfos.add((BindingInfo) target);
			}
		}
		return bindingInfos;
	}

	public BindingRegistry getBindingRegistry(Namespace namespace) {
		if (namespace.getBindingRegistries().isEmpty()) {
			BindingRegistry bindingRegistry = EnvironmentFactory.eINSTANCE.createBindingRegistry();
			namespace.getBindingRegistries().add(bindingRegistry);
			namespace.eResource().getContents().add(bindingRegistry);
			return bindingRegistry;
		} else {
			return namespace.getBindingRegistries().get(0);
		}
	}

	public BindingInfo reconnectBindingTarget(BindingInfo bindingInfo, BoundableElement oldTarget, BoundableElement newTarget) {
		if (bindingInfo.getLeft().equals(oldTarget)) {
			bindingInfo.setLeft(newTarget);
		} else if (bindingInfo.getRight().equals(oldTarget)) {
			bindingInfo.setRight(newTarget);
		}

		return bindingInfo;
	}
	
	public String computeBindingEditorName(BindingInfo bindingInfo) {
		return String.format("Binding %1s - %2s", getBoundElementName(bindingInfo.getLeft()), getBoundElementName(bindingInfo.getRight()));
	}
 
	private String getBoundElementName(EObject object) {
		if ((object != null) && ((object instanceof StructuredType))) {
			return ((StructuredType)object).getName();
		}
		return null;
	}
	
	public BindingInfo openBindingEditor(BindingInfo bindingInfo) {
		DBindingEditor editor = null;
		
		final Session session = SessionManager.INSTANCE.getSession(bindingInfo);
		
		// Find an editor to open
		Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(bindingInfo, session);
		for (DRepresentation representation : representations) {
			if (representation instanceof DBindingEditor) {
				editor = (DBindingEditor)representation;
				break;
			}
		}

		// Create an editor if needed
		if (editor == null) {
			RepresentationDescription representationDescription = getBindingEditorRepresentation(session);
			if (representationDescription != null) {
				DRepresentation representation = DialectManager.INSTANCE.createRepresentation(computeBindingEditorName(bindingInfo), bindingInfo, representationDescription, session, new NullProgressMonitor());
				if (representation != null && representation instanceof DBindingEditor) {
					editor = (DBindingEditor)representation;
				}
			}
		}
		// Open the editor
		if (editor != null) {
			UserSession.from(session).openRepresentation(new StructuredSelection(editor));
		}
		
		return bindingInfo;
	}

	private RepresentationDescription getBindingEditorRepresentation(Session session) {
		for (Viewpoint vp : session.getSelectedViewpoints(true)) {
			for (RepresentationDescription representationDescription : vp.getOwnedRepresentations()) {
				if (representationDescription.getName().equals(BINDING_EDITOR_DESCRIPTION_NAME)) {
					return representationDescription;
				}
			}
		}
		return null;
	}
}