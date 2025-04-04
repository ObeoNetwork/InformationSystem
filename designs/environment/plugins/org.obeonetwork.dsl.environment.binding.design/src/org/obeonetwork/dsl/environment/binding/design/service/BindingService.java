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
package org.obeonetwork.dsl.environment.binding.design.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.ui.business.api.session.UserSession;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;

public class BindingService {

	private static final String BINDING_EDITOR_DESCRIPTION_NAME = "Binding Details";

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

	private static Collection<Resource> getAllSemanticResourcesInSession(EObject any) {
		Session session = SessionManager.INSTANCE.getSession(any);
		if (session != null) {
			return session.getSemanticResources();
		}
		return Collections.emptyList();
	}

	private static Collection<BindingInfo> getAllBindingInfosOnDiagram(DSemanticDiagram diagram) {
		Collection<BindingInfo> bindingInfos = new ArrayList<BindingInfo>();
		for (DNode node : diagram.getNodes()) {
			if (node.getTarget() instanceof BindingInfo) {
				bindingInfos.add((BindingInfo) node.getTarget());
			}
		}
		return bindingInfos;
	}

	public static Collection<StructuredType> getAllStructuredTypes(EObject any) {
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
					if (!(eObject instanceof TypesDefinition || eObject instanceof NamespacesContainer
							|| isOverviewRootInstance(eObject))) {
						iterator.prune();
					}
				}
			}
		}

		return structuredTypes;
	}

	private static boolean isOverviewRootInstance(EObject object) {
		EClass eClass = object.eClass();
		return "Root".equals(eClass.getName())
				&& eClass.getEPackage().getNsURI().startsWith("http://www.obeonetwork.org/dsl/overview/");
	}

	private Collection<BindingInfo> getRelatedBindingInfos(Namespace namespace) {
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

	/**
	 * 
	 * @param structuredType
	 * @return a collection of {@link BindingInfo} applicable for Entity/DTO
	 *         bindings and not for {@link AbstractViewElement}s.
	 */
	private Collection<BindingInfo> getRelatedBindingInfos(StructuredType structuredType) {
		EObjectQuery query = new EObjectQuery(structuredType);
		Collection<BindingInfo> bindingInfos = new HashSet<BindingInfo>();

		bindingInfos.addAll(query.getInverseReferences(EnvironmentPackage.Literals.BINDING_INFO__LEFT).stream()
				.filter(BindingInfo.class::isInstance).map(BindingInfo.class::cast)
				// Ensure bindingInfo doesn't target an AbstractViewElement
				.filter(bi -> !(bi.getRight() instanceof AbstractViewElement)).collect(Collectors.toList()));

		bindingInfos.addAll(query.getInverseReferences(EnvironmentPackage.Literals.BINDING_INFO__RIGHT).stream()
				.filter(BindingInfo.class::isInstance).map(BindingInfo.class::cast)
				// Ensure bindingInfo doesn't target an AbstractViewElement.
				.filter(bi -> !(bi.getLeft() instanceof AbstractViewElement)).collect(Collectors.toList()));

		return bindingInfos;
	}

	public BindingInfo reconnectBindingTarget(BindingInfo bindingInfo, BoundableElement oldTarget,
			BoundableElement newTarget) {
		if (bindingInfo.getLeft().equals(oldTarget)) {
			bindingInfo.setLeft(newTarget);
		} else if (bindingInfo.getRight().equals(oldTarget)) {
			bindingInfo.setRight(newTarget);
		}

		return bindingInfo;
	}

	public String computeBindingEditorName(BindingInfo bindingInfo) {
		return String.format("Binding %1s - %2s", getBoundElementName(bindingInfo.getLeft()),
				getBoundElementName(bindingInfo.getRight()));
	}

	private String getBoundElementName(EObject object) {
		if ((object instanceof StructuredType)) {
			return ((StructuredType) object).getName();
		} else if (object instanceof ViewContainer) {
			return ((ViewContainer) object).getName();
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
				editor = (DBindingEditor) representation;
				break;
			}
		}

		// Create an editor if needed
		if (editor == null) {
			RepresentationDescription representationDescription = getBindingEditorRepresentation(session);
			if (representationDescription != null) {
				DRepresentation representation = DialectManager.INSTANCE.createRepresentation(
						computeBindingEditorName(bindingInfo), bindingInfo, representationDescription, session,
						new NullProgressMonitor());
				if (representation != null && representation instanceof DBindingEditor) {
					editor = (DBindingEditor) representation;
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

	/**
	 * 
	 * @param context
	 * @return whether a Binding diagram can be created from context.
	 */
	public boolean isValidContextForBindingDiagram(ObeoDSMObject context) {
		if (!(context instanceof Namespace || context instanceof ViewContainer)) {
			return false;
		}
		if (context instanceof ViewContainer) {
			if (!(context.eContainer() instanceof AbstractPackage)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param rootBindingInfos should either be environment's{@link Namespace}, or
	 *                         view's {@link ViewContainer}.
	 * 
	 * @return all {@link BindingInfo} related to rootBindingInfos. In the case of a
	 *         ViewContainer, they are found in {@link CinematicRoot} its root
	 *         container.
	 */
	public Collection<BindingInfo> getRelatedBindingInfos(ObeoDSMObject rootBindingInfos) {
		if (rootBindingInfos instanceof Namespace) {
			return getRelatedBindingInfos((Namespace) rootBindingInfos);
		}
		if (rootBindingInfos instanceof ViewContainer) {
			return getRelatedBindingInfos((ViewContainer) rootBindingInfos);
		}
		return Collections.emptySet();
	}

	private Collection<BindingInfo> getRelatedBindingInfos(ViewContainer viewContainer) {
		// Use of LinkedHashSet to keep order and avoid potential lock/unlock loops
		// problems
		Set<BindingInfo> results = new LinkedHashSet<BindingInfo>();
		CinematicRoot registryContainer = getRegistryContainerForViewContainerBindingInfos(
				(ViewContainer) viewContainer);
		if (registryContainer != null) {
			for (BindingRegistry bindingRegistry : registryContainer.getBindingRegistries()) {
				results.addAll(bindingRegistry.getBindingInfos());
			}
		}
		return results;
	}

	public Collection<StructuredType> getAllBoundableElements(DSemanticDiagram diagram, BoundableElement boundableElement) {
		// Collect all structured types
		Collection<StructuredType> bindableElements = new ArrayList<StructuredType>();

		// First get all structured types
		bindableElements.addAll(getAllStructuredTypes(boundableElement));

		// Remove the target element
		bindableElements.remove(boundableElement);

		// Remove elements already bound with the target
		for (BindingInfo bindingInfo : getAllBindingInfosOnDiagram(diagram)) {
			if (bindingInfo.getLeft() == boundableElement) {
				bindableElements.remove(bindingInfo.getRight());
			}
			if (bindingInfo.getRight() == boundableElement) {
				bindableElements.remove(bindingInfo.getLeft());
			}
		}

		return bindableElements;
	}

	/**
	 * 
	 * @param context should either be environment's{@link Namespace}, or view's
	 *                {@link ViewContainer}.
	 * @return
	 */
	public static BindingRegistry getBindingRegistry(ObeoDSMObject context) {
		if (context instanceof Namespace) {
			if (context.getBindingRegistries().isEmpty()) {
				return createBindingRegistry(context);
			} else {
				return context.getBindingRegistries().get(0);
			}
		}
		if (context instanceof ViewContainer) {
			EObject rootContainer = EcoreUtil.getRootContainer(context);
			CinematicRoot cinematicRoot = null;
			if (rootContainer instanceof CinematicRoot) {
				cinematicRoot = (CinematicRoot) rootContainer;
			}
			if (cinematicRoot != null) {
				if (cinematicRoot.getBindingRegistries().isEmpty()) {
					return createBindingRegistry(cinematicRoot);
				} else {
					return cinematicRoot.getBindingRegistries().get(0);
				}
			}
		}
		return null;
	}

	private static BindingRegistry createBindingRegistry(ObeoDSMObject container) {
		BindingRegistry bindingRegistry = EnvironmentFactory.eINSTANCE.createBindingRegistry();
		container.getBindingRegistries().add(bindingRegistry);
		return bindingRegistry;
	}

	public static CinematicRoot getRegistryContainerForViewContainerBindingInfos(ViewContainer viewContainer) {
		EObject rootContainer = EcoreUtil.getRootContainer(viewContainer);
		if (rootContainer instanceof CinematicRoot) {
			return (CinematicRoot) rootContainer;
		}
		return null;
	}
	
	public static BoundableElement getOtherBoundElement(BindingInfo bindingInfo, BoundableElement boundableElement) {
		if (bindingInfo.getLeft() == boundableElement) {
			return bindingInfo.getRight();
		}
		if (bindingInfo.getRight() == boundableElement) {
			return bindingInfo.getLeft();
		}
		return null;
	}

	public static List<BindingInfo> getBindingInfos(BindingRegistry bindingRegistry, BoundableElement boundableElement) {
		return bindingRegistry.getBindingInfos().stream()//
		.filter(bindingInfo -> bindingInfo.getLeft() == boundableElement || bindingInfo.getRight() == boundableElement)//
		.toList();
	}
	
	/**
	 * Returns the first {@link BindingInfo} with the given left and right {@link BoundableElement}s, null if none is found.
	 * 
	 * @param bindingRegistry
	 * @param left
	 * @param right
	 * @return
	 */
	public static BindingInfo getBindingInfo(BindingRegistry bindingRegistry, BoundableElement left, BoundableElement right) {
		return bindingRegistry.getBindingInfos().stream()//
		.filter(bindingInfo -> bindingInfo.getLeft() == left && bindingInfo.getRight() == right)//
		.findAny().orElse(null);
	}
	
	public static List<BoundableElement> getOtherBoundElements(BindingRegistry bindingRegistry, BoundableElement boundableElement) {
		return getBindingInfos(bindingRegistry, boundableElement).stream()//
		.map(bindingInfo -> getOtherBoundElement(bindingInfo, boundableElement))//
		.toList();
	}
	
	public static BindingInfo createBindingInfo(BindingRegistry bindingRegistry, BoundableElement left, BoundableElement right) {
		BindingInfo bindingInfo = EnvironmentFactory.eINSTANCE.createBindingInfo();
		bindingInfo.setLeft(left);
		bindingInfo.setRight(right);
		bindingRegistry.getBindingInfos().add(bindingInfo);
		return bindingInfo;
	}

}