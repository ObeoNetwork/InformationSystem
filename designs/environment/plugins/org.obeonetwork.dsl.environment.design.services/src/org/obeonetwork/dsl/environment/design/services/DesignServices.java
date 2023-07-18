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
package org.obeonetwork.dsl.environment.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

public class DesignServices {

	private static final RGBValues UNSYNCHRONIZED_DIAGRAM_BACKGROUND = RGBValues.create(255, 239, 219);
	
	public static int getUnsynchronizableDiagramBackgroundRed(DSemanticDiagram diagram) {
		return (diagram.isSynchronized())? 255 : UNSYNCHRONIZED_DIAGRAM_BACKGROUND.getRed();
	}
	
	public static int getUnsynchronizableDiagramBackgroundGreen(DSemanticDiagram diagram) {
		return (diagram.isSynchronized())? 255 : UNSYNCHRONIZED_DIAGRAM_BACKGROUND.getGreen();
	}
	
	public static int getUnsynchronizableDiagramBackgroundBlue(DSemanticDiagram diagram) {
		return (diagram.isSynchronized())? 255 : UNSYNCHRONIZED_DIAGRAM_BACKGROUND.getBlue();
	}
	
	/**
	 * Returns all structured types displayed on a diagram
	 * @param diagram
	 * @return
	 */
	public static Set<StructuredType> getDisplayedStructuredTypes(DSemanticDiagram diagram) {
		return getDisplayedElementsByType(diagram, StructuredType.class);
	}
	
	/**
	 * Returns all namespaces displayed on a diagram
	 * @param diagram
	 * @return
	 */
	public static Set<Namespace> getDisplayedNamespaces(DSemanticDiagram diagram) {
		return getDisplayedElementsByType(diagram, Namespace.class);
	}
	
	/**
	 * Returns all elements of the specified class displayed on a diagram
	 * @param diagram
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T extends EObject> Set<T> getDisplayedElementsByType(DSemanticDiagram diagram, Class<T> clazz) {
		Set<T> result = Sets.newLinkedHashSet();
		Iterator<DSemanticDecorator> it = Iterators.filter(diagram.eAllContents(), DSemanticDecorator.class);
		while (it.hasNext()) {
			DSemanticDecorator dec = it.next();
			EObject target = dec.getTarget();
			if (target != null && clazz.isAssignableFrom(target.getClass())) {
				result.add((T) target);
			}
		}
		return result;
	}
	
	/**
	 * Returns all namespaces for which a dependency should be displayed starting from source
	 * @param source
	 * @param diagram
	 * @return
	 */
	public static Collection<Namespace> getDependenciesToNamespaces(Namespace source, DSemanticDiagram diagram) {
		Collection<Namespace> targetNamespaces = new ArrayList<Namespace>();
		
		Set<Namespace> displayedNamespaces = getDisplayedNamespaces(diagram);
		// Check all namespaces displayed on the diagram	
		for (Namespace displayedNamespace : displayedNamespaces) {
			// Check if the potential target is not :
			// - the same namespace than the source one
			// - already taken into account by a call of this same method on this potential namespace (to prevent having 2 edges between 2 namespaces)
			// - an ancestor or a descendant of the source namespace
			if (displayedNamespace != source
					&& displayedNamespace.getTechnicalid().compareTo(source.getTechnicalid()) > 0
					&& !EcoreUtil.isAncestor(displayedNamespace, source)
					&& !EcoreUtil.isAncestor(source, displayedNamespace)) {
				// Now we can check if dependencies exist between the 2 namespaces
				if (isExistingDependency(source, displayedNamespace)
					|| isExistingDependency(displayedNamespace, source)) {
					targetNamespaces.add(displayedNamespace);
				}
			}
		}
		
		return targetNamespaces;
	}
	
	/**
	 * Checks whether a dependency should be displayed between 2 namespaces
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean isExistingDependency(Namespace source, Namespace target) {
		for (Type type : source.getTypes()) {
			if (type instanceof StructuredType) {
				StructuredType structuredType = (StructuredType)type;
				
				// Check inheritance
				StructuredType supertype = structuredType.getSupertype();
				if (supertype != null && target.equals(supertype.eContainer())) {
					return true;
				}
				
				// Check references
				for (Reference reference : structuredType.getOwnedReferences()) {
					StructuredType referencedType = reference.getReferencedType();
					if (referencedType != null && target.equals(referencedType.eContainer())) {
						return true;
					}
				}
				
				// Check attributes
				for (Attribute attribute : structuredType.getOwnedAttributes()) {
					DataType datatype = attribute.getType();
					if (datatype instanceof Enumeration && target.equals(datatype.eContainer())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns the number of dependencies between 2 namespaces
	 * @param source
	 * @param target
	 * @return
	 */
	public static int getNbDependencies(Namespace source, Namespace target) {
		int count = 0;
		for (Type type : source.getTypes()) {
			if (type instanceof StructuredType) {
				StructuredType structuredType = (StructuredType)type;
				
				// Check inheritance
				StructuredType supertype = structuredType.getSupertype();
				if (supertype != null && target.equals(supertype.eContainer())) {
					count += 1;
				}
				
				// Check references
				for (Reference reference : structuredType.getOwnedReferences()) {
					StructuredType referencedType = reference.getReferencedType();
					if (referencedType != null && target.equals(referencedType.eContainer())) {
						count += 1;
					}
				}
				
				// Check attributes
				for (Attribute attribute : structuredType.getOwnedAttributes()) {
					DataType datatype = attribute.getType();
					if (datatype instanceof Enumeration && target.equals(datatype.eContainer())) {
						count += 1;
					}
				}
			}
		}
		return count;
	}
	
	public static boolean isDependencyBeginDecorated(DEdge edge) {
		Namespace source = getNamespaceFromEdgeTarget(edge.getSourceNode());
		Namespace target = getNamespaceFromEdgeTarget(edge.getTargetNode());
		
		return source != null
				&& target != null
				&& isExistingDependency(target, source);
	}
	
	public static String getDependencyBeginLabel(DEdge edge) {
		Namespace source = getNamespaceFromEdgeTarget(edge.getSourceNode());
		Namespace target = getNamespaceFromEdgeTarget(edge.getTargetNode());
		
		return "" + getNbDependencies(target, source);
	}
	
	public static boolean isDependencyEndDecorated(DEdge edge) {
		Namespace source = getNamespaceFromEdgeTarget(edge.getSourceNode());
		Namespace target = getNamespaceFromEdgeTarget(edge.getTargetNode());
		
		return source != null
				&& target != null
				&& isExistingDependency(source, target);
	}
	
	public static String getDependencyEndLabel(DEdge edge) {
		Namespace source = getNamespaceFromEdgeTarget(edge.getSourceNode());
		Namespace target = getNamespaceFromEdgeTarget(edge.getTargetNode());
		
		return "" + getNbDependencies(source, target);
	}
	
	private static Namespace getNamespaceFromEdgeTarget(EdgeTarget edgeTarget) {
		if (edgeTarget instanceof DSemanticDecorator) {
			EObject target = ((DSemanticDecorator) edgeTarget).getTarget();
			if (target instanceof Namespace) {
				return (Namespace)target;
			}
		}
		return null;
	}

	public static int getNbDependencies(DEdge edge) {
		return 2;
	}

	public static Collection<Namespace> getExternalNamespacesRecursive(NamespacesContainer nsContainer) {
		Collection<Namespace> externalNSs = new HashSet<Namespace>();
		NamespacesContainer rootNSContainer = getRootNamespaceContainer(nsContainer);
		if (rootNSContainer != null) {
			EList<Namespace> namespaces = nsContainer.getOwnedNamespaces();
			for (Namespace namespace : namespaces) {
				externalNSs.addAll(getExternalNamespaces(namespace, rootNSContainer));
				externalNSs.addAll(getExternalNamespacesRecursive(namespace));
			}
		}
		return externalNSs;
	}

	public static Collection<Namespace> getExternalNamespaces(Namespace namespace) {
		Collection<Namespace> externalNSs = new HashSet<Namespace>();
		NamespacesContainer rootNSContainer = getRootNamespaceContainer(namespace);
		if (rootNSContainer != null) {
			externalNSs.addAll(getExternalNamespaces(namespace, rootNSContainer));
		}
		return externalNSs;
	}

	private static Collection<Namespace> getExternalNamespaces(Namespace namespace, NamespacesContainer rootNSContainer) {
		Collection<Namespace> externalNSs = new HashSet<Namespace>();
		for (Type type : namespace.getTypes()) {
			if (type instanceof StructuredType) {
				StructuredType structuredType = (StructuredType)type;
				
				// Check inheritance
				StructuredType supertype = structuredType.getSupertype();
				if (supertype != null && !rootNSContainer.equals(getRootNamespaceContainer(supertype))) {
					EObject supertypeContainer = supertype.eContainer();
					if (supertypeContainer instanceof Namespace) {
						externalNSs.add((Namespace) supertypeContainer);
					}
				}
				
				// Check references
				for (Reference reference : structuredType.getOwnedReferences()) {
					StructuredType referencedType = reference.getReferencedType();
					if (referencedType != null && !rootNSContainer.equals(getRootNamespaceContainer(referencedType))) {
						EObject referencedTypeContainer = referencedType.eContainer();
						if (referencedTypeContainer instanceof Namespace) {
							externalNSs.add((Namespace) referencedTypeContainer);
						}
					}
				}
				
				// Check attributes
				for (Attribute attribute : structuredType.getOwnedAttributes()) {
					DataType datatype = attribute.getType();
					if (datatype instanceof Enumeration && !rootNSContainer.equals(getRootNamespaceContainer(datatype))) {
						EObject datatypeContainer = datatype.eContainer();
						if (datatypeContainer instanceof Namespace) {
							externalNSs.add((Namespace) datatypeContainer);
						}
					}
				}
			}
		}
		return externalNSs;
	}

	private static NamespacesContainer getRootNamespaceContainer(EObject object) {
		if (object == null) {
			return null;
		}
		EObject eContainer = object.eContainer();
		if (eContainer instanceof NamespacesContainer) {
			NamespacesContainer nsC = getRootNamespaceContainer((NamespacesContainer) eContainer);
			if (nsC == null) {
				return (NamespacesContainer) eContainer;
			}
			return nsC;
		} else if (object instanceof NamespacesContainer) {
			return (NamespacesContainer) object;
		}
		return null;
	}
}
