/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.binding.design.service.BindingService;
import org.obeonetwork.dsl.environment.design.extension.StructuredTypeChildrenContribution;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;

/**
 * This class is used to handle binding informations
 * 
 * @author Obeo
 *
 */
public class CinematicBindingServices {
	private static final String TYPE_NAME_PATTERN = "%1s (%2s)";
	private static final String PROPERTY_NAME_PATTERN = "%1s.%2s (%3s %4s)";

	private static AdapterFactoryLabelProvider aflp = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	public String getCinematicBindingInfoLabel(BindingInfo bindingInfo) {
		EObject element = getCinematicBoundElement(bindingInfo);
		if (element == null) {
			element = bindingInfo;
		}
		if (element instanceof StructuredType) {
			return getLabelForStructuredType((StructuredType) element);
		} else if (element instanceof Property) {
			return getLabelForStructuredTypeProperty((Property) element);
		} else {
			return getGenericLabel(element);
		}
	}

	private String getLabelForStructuredType(StructuredType type) {
		String typePattern = TYPE_NAME_PATTERN;
		return String.format(typePattern, type.getName(), type.eClass().getName());
	}

	private String getLabelForStructuredTypeProperty(Property property) {
		String propertyPattern = PROPERTY_NAME_PATTERN;
		if (property.eContainer() instanceof StructuredType) {
			StructuredType type = (StructuredType) property.eContainer();
			return String.format(propertyPattern, type.getName(), property.getName(), type.eClass().getName(),
					property.eClass().getName());
		} else {
			// Should never ever happen but though let's handle this case
			String typePattern = TYPE_NAME_PATTERN;
			return String.format(typePattern, property.getName(), property.eClass().getName());
		}
	}

	public BoundableElement getCinematicBoundElement(BindingInfo bindingInfo) {
		if (!(bindingInfo.getRight() instanceof CinematicElement)) {
			return bindingInfo.getRight();
		} else if (!(bindingInfo.getLeft() instanceof CinematicElement)) {
			return bindingInfo.getLeft();
		}
		return null;
	}

	public String getGenericLabel(EObject eObject) {
		if (eObject == null) {
			return "";
		}
		return aflp.getText(eObject);
	}

	public BindingInfo createCinematicBindingInfo(AbstractViewElement viewElement, EObject boundElement) {
		if (boundElement instanceof BoundableElement) {
			BoundableElement target = (BoundableElement) boundElement;
			BindingRegistry bindingRegistry = getGlobalBindingRegistry(viewElement);
			BindingInfo newBindingInfo = EnvironmentFactory.eINSTANCE.createBindingInfo();
			newBindingInfo.setLeft(viewElement);
			newBindingInfo.setRight(target);
			bindingRegistry.getBindingInfos().add(newBindingInfo);
			return newBindingInfo;
		}
		return null;
	}

	public Collection<BindingInfo> getCinematicBindingInfos(AbstractViewElement viewElement) {
		Collection<BindingInfo> bindingInfos = new ArrayList<BindingInfo>();
		for (BindingInfo bi : getGlobalBindingRegistry(viewElement).getBindingInfos()) {
			if (bi.getLeft() == viewElement || bi.getRight() == viewElement) {
				bindingInfos.add(bi);
			}
		}
		return bindingInfos;
	}

	public List<EObject> getBindingElementsAndContainers(EObject context, List<EObject> bindingElements) {
		List<EObject> bindingElementsContainersAncestors = new ArrayList<EObject>(bindingElements);
		// Add to the list, the Ancestors if they are not already
		// on the list.
		for (EObject bindingElement : bindingElements) {
			EObject objectContainer = bindingElement.eContainer();
			while (objectContainer != null) {
				if (!bindingElementsContainersAncestors.contains(objectContainer)) {
					bindingElementsContainersAncestors.add(objectContainer);
				}
				objectContainer = objectContainer.eContainer();
			}
		}
		// Removing duplicates, if duplicates are present
		Set<EObject> set = new HashSet<EObject>();
		set.addAll(bindingElementsContainersAncestors);
		return new ArrayList<EObject>(set);
	}

	private BindingRegistry getGlobalBindingRegistry(CinematicElement element) {
		CinematicRoot root = getCinematicRoot(element);
		if (root != null) {
			if (root.getBindingRegistries().isEmpty()) {
				BindingRegistry bindingRegistry = EnvironmentFactory.eINSTANCE.createBindingRegistry();
				root.getBindingRegistries().add(bindingRegistry);
				root.eResource().getContents().add(bindingRegistry);
				return bindingRegistry;
			} else {
				return root.getBindingRegistries().get(0);
			}
		}
		return null;
	}

	private CinematicRoot getCinematicRoot(CinematicElement element) {
		if (element instanceof CinematicRoot) {
			return (CinematicRoot) element;
		} else {
			EObject parent = element.eContainer();
			if (parent != null && parent instanceof CinematicElement) {
				return getCinematicRoot((CinematicElement) parent);
			} else {
				return null;
			}
		}
	}

	/**
	 * Opens a wizard for selecting elements to bind with element a
	 * {@link ViewElement} or {@link ViewContainer}. Then sets the selected
	 * elements.
	 * 
	 * @param element
	 */
	public void openBoundableElementsSelectionWizard(AbstractViewElement element) {
		ISObjectSelectionWizard wizard = null;
		ViewContainer context = null;
		List<ViewContainer> viewElementViewContainerParents = null;
		Collection<BindingInfo> viewElementParentsBindingInfos = null;
		if (element instanceof ViewContainer) {
			context = (ViewContainer) element;
		} else if (element instanceof ViewElement) {
			if (((ViewElement) element).eContainer() instanceof ViewContainer) {
				context = (ViewContainer) ((ViewElement) element).eContainer();
			} else {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "ViewElement binding",
						"No ViewContainer for selected ViewElement.\nAt least one parent ViewContainer should be existing and bound.");
				return;
			}
		} else {
			return;
		}
		CinematicRoot cinematicRoot = BindingService.getRegistryContainerForViewContainerBindingInfos(context);
		if (cinematicRoot == null) {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Binding",
					"No CinematicRoot found.\nBinding cannot proceed.");
			return;
		}
		Collection<BindingInfo> bindingInfos = cinematicRoot.getBindingRegistries().stream()
				.map(BindingRegistry::getBindingInfos).flatMap(List::stream).collect(Collectors.toSet());

		HashSet<EObject> alreadyBoundElements = new HashSet<>();
		if (element instanceof ViewContainer) {
			alreadyBoundElements.addAll(getViewContainerLinkedBoundableElements((ViewContainer) element, bindingInfos));
			wizard = getStructuredTypesSelectionWizard((ViewContainer) element, alreadyBoundElements);
		} else {
			// ViewElement
			viewElementViewContainerParents = getParentViewContainers((ViewElement) element);
			viewElementParentsBindingInfos = getViewElementParentBindingInfos(bindingInfos, (ViewElement) element,
					viewElementViewContainerParents);
			alreadyBoundElements.addAll(
					getViewElementLinkedBoundableElements((ViewElement) element, viewElementParentsBindingInfos));
			wizard = getStructuredTypesContentsSelectionWizard((ViewElement) element, alreadyBoundElements,
					viewElementParentsBindingInfos, viewElementViewContainerParents);
		}
		List<EObject> addedElements, removedElements;

		// Map necessary when viewElement is added from associatedTypes' attributes
		// In case the parent ViewContainer is bound on 2 StructuredTypes having a
		// non-empty intersection on their associatedTypes.
		final Map<Object, Object> selectedElementToParentMap = new HashMap<>();

		if (wizard != null && wizard.open() == Window.OK) {
			Collection<ISObjectTreeItemWrapper> selectedTreeItemWrappers = wizard.getSelectedTreeItemWrappers();

			selectedTreeItemWrappers.forEach(tiw -> {
				selectedElementToParentMap.put(tiw.getWrappedObject(),
						tiw.getParent() != null ? tiw.getParent().getWrappedObject() : null);
			});

			addedElements = selectedTreeItemWrappers.stream()
					.filter(tiw -> !alreadyBoundElements.contains(tiw.getWrappedObject()))
					.map(ISObjectTreeItemWrapper::getWrappedObject).filter(EObject.class::isInstance)
					.map(EObject.class::cast).collect(toList());

			removedElements = alreadyBoundElements.stream().filter(
					elt -> selectedTreeItemWrappers.stream().noneMatch(tiw -> elt.equals(tiw.getWrappedObject())))
					.collect(toList());
		} else {
			return;
		}
		BindingRegistry bindingRegistry = BindingService.getBindingRegistry(context);
		if (element instanceof ViewContainer) {
			processViewContainerBinding((ViewContainer) element, addedElements, removedElements, bindingRegistry);
		} else {
			processViewElementBinding((ViewElement) element, addedElements, removedElements, selectedElementToParentMap,
					viewElementViewContainerParents, viewElementParentsBindingInfos);
		}
	}

	/**
	 * Adds elements to add and removes elements to remove.
	 * 
	 * @param viewContainer
	 * @param addedElements
	 * @param removedElements
	 * @param bindingRegistry
	 */
	private static void processViewContainerBinding(ViewContainer viewContainer, List<EObject> addedElements,
			List<EObject> removedElements, BindingRegistry bindingRegistry) {
		// Remove deleted bindings
		// Bindings are expected to be found at BindingInfo level and not at
		// BindingReference level.
		for (EObject removedElement : removedElements) {
			if (removedElement instanceof BoundableElement) {
				removeBindingInfo((BoundableElement) removedElement, viewContainer);
			}
		}
		// Add new bindings, i.e., BindingInfo elements
		for (EObject addedElement : addedElements) {
			if (addedElement instanceof BoundableElement) {
				addBindingInfo(bindingRegistry, viewContainer, (BoundableElement) addedElement);
			}
		}
	}

	/**
	 * Adds elements to add and removes elements to remove.
	 * 
	 * @param viewElement
	 * @param addedElements
	 * @param removedElements
	 * @param selectedElementToParentMap
	 * @param viewElementViewContainerParents
	 * @param viewElementParentsBindingInfos
	 */
	private static void processViewElementBinding(ViewElement viewElement, List<EObject> addedElements,
			List<EObject> removedElements, Map<Object, Object> selectedElementToParentMap,
			List<ViewContainer> viewElementViewContainerParents,
			Collection<BindingInfo> viewElementParentsBindingInfos) {
		// ViewElement
		// Remove deleted bindings
		// Bindings are expected to be found at BindingReference level and not at
		// BindingInfo level.
		for (EObject removedElement : removedElements) {
			if (removedElement instanceof BoundableElement) {
				removeBindingReference((BoundableElement) removedElement, viewElement);
			}
		}
		// Add new BindingReferences
		Map<ViewContainer, List<StructuredType>> parentsBoundElements = getViewContainersBoundStructuredTypes(
				viewElementParentsBindingInfos, viewElementViewContainerParents);
		for (EObject addedElement : addedElements) {
			if (addedElement instanceof BoundableElement) {
				addBindingReference(viewElementParentsBindingInfos, (BoundableElement) addedElement, viewElement,
						viewElementViewContainerParents, parentsBoundElements, selectedElementToParentMap);
			}
		}
	}

	private static ISObjectSelectionWizard getISObjectSelectionWizard(String windowTitle, String message,
			List<EObject> roots, final Function<?, List<?>> childrenFunction,
			final Function<?, Boolean> selectableCondition, Set<EObject> preSelectedElements) {
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(childrenFunction, selectableCondition);
		for (EObject root : roots) {
			new ISObjectTreeItemWrapper(treeRoot, root);
		}
		final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(windowTitle, message, null, treeRoot, true);
		wizard.setLevelToExpand(2);
		List<ISObjectTreeItemWrapper> preSelectedTreeItemWrappers = treeRoot.getAllSelectableTreeItemWrappers().stream()
				.filter(tiw -> preSelectedElements.contains(tiw.getWrappedObject())).collect(toList());
		wizard.setPreSelectedTreeItemWrappers(preSelectedTreeItemWrappers);
		return wizard;
	}

	private ISObjectSelectionWizard getStructuredTypesContentsSelectionWizard(ViewElement viewElement,
			HashSet<EObject> alreadyBoundElements, Collection<BindingInfo> viewElementParentsBindingInfos,
			List<ViewContainer> viewElementParentsViewContainers) {
		String windowTitle = "Entity/DTO attributes and references selection";
		String message = "Select Attribute or Reference elements to bound";
		// Get as roots, all Structured types bound to all ViewContainers that are
		// parents of viewElement.
		List<EObject> roots = new ArrayList<>();
		Map<ViewContainer, List<StructuredType>> parentsBoundElements = getViewContainersBoundStructuredTypes(
				viewElementParentsBindingInfos, viewElementParentsViewContainers);
		roots.addAll(parentsBoundElements.entrySet().stream().map(entry -> entry.getValue()).flatMap(List::stream)
				.collect(Collectors.toSet()));
		if (roots.isEmpty()) {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "ViewElement binding",
					"No ViewContainer parent bound.\nAt least one parent ViewContainer should be bound.");
			return null;
		}
		StructuredTypeChildrenContribution stChildrenContribution = new StructuredTypeChildrenContribution();
		final Function<?, List<?>> childrenFunction = x -> x instanceof EObject
				? stChildrenContribution.getChildren((EObject) x)
				: Collections.emptyList();
		final Function<?, Boolean> selectableCondition = eObj -> (eObj instanceof Attribute)
				|| (eObj instanceof Reference);

		return getISObjectSelectionWizard(windowTitle, message, roots, childrenFunction, selectableCondition,
				alreadyBoundElements);
	}

	/**
	 * 
	 * @param abstractViewElement
	 * @return a list of parents of {@link ViewContainer} through the eContainer
	 *         relationship. The smaller the index of the parent in the list, the
	 *         closer it is to abstractViewElement in the containment hierarchy.
	 */
	private static List<ViewContainer> getParentViewContainers(AbstractViewElement abstractViewElement) {
		List<ViewContainer> parents = new ArrayList<>();
		EObject parent = abstractViewElement.eContainer();
		while (parent != null && parent instanceof ViewContainer) {
			parents.add((ViewContainer) parent);
			parent = parent.eContainer();
		}
		return parents;
	}

	private static Map<ViewContainer, List<StructuredType>> getViewContainersBoundStructuredTypes(
			Collection<BindingInfo> parentsBindingInfos, List<ViewContainer> parents) {
		HashMap<ViewContainer, List<StructuredType>> results = new HashMap<>();
		for (BindingInfo bi : parentsBindingInfos) {
			StructuredType toAdd = null;
			ViewContainer parent = null;
			if (bi.getLeft() != null && parents.contains(bi.getLeft())) {
				if (bi.getRight() instanceof StructuredType) {
					toAdd = (StructuredType) bi.getRight();
					parent = (ViewContainer) bi.getLeft();
				}
			} else if (bi.getRight() != null && parents.contains(bi.getRight())) {
				if (bi.getLeft() instanceof StructuredType) {
					toAdd = (StructuredType) bi.getLeft();
					parent = (ViewContainer) bi.getRight();
				}
			}
			if (toAdd != null) {
				if (results.containsKey(parent)) {
					results.get(parent).add(toAdd);
				} else {
					ArrayList<StructuredType> sts = new ArrayList<>();
					sts.add(toAdd);
					results.put(parent, sts);
				}
			}
		}
		return results;
	}

	private ISObjectSelectionWizard getStructuredTypesSelectionWizard(ViewContainer context,
			HashSet<EObject> alreadyBoundElements) {
		String windowTitle = "Entity/DTO selection";
		String message = "Select Entity or DTO elements to bound";
		Collection<StructuredType> structuredTypes = BindingService.getAllStructuredTypes(context);
		HashMap<EObject, List<EObject>> parentToChildren = new HashMap<>();
		for (EObject elt : structuredTypes) {
			if (elt.eContainer() != null) {
				EObject container = elt.eContainer();
				if (parentToChildren.containsKey(container)) {
					parentToChildren.get(container).add(elt);
				} else {
					ArrayList<EObject> sts = new ArrayList<>();
					sts.add(elt);
					parentToChildren.put(container, sts);
				}
			} else {
				parentToChildren.put(elt, Collections.emptyList());
			}
		}
		List<EObject> roots = parentToChildren.isEmpty() ? Collections.emptyList()
				: new ArrayList<EObject>(parentToChildren.keySet());
		final Function<?, List<?>> childrenFunction = parent -> parentToChildren.getOrDefault(parent,
				Collections.emptyList());
		final Function<?, Boolean> selectableCondition = eObj -> (eObj instanceof DTO) || (eObj instanceof Entity);

		return getISObjectSelectionWizard(windowTitle, message, roots, childrenFunction, selectableCondition,
				alreadyBoundElements);
	}

	private Set<BoundableElement> getViewElementLinkedBoundableElements(ViewElement boundable,
			Collection<BindingInfo> viewElementParentsBindingInfos) {
		return viewElementParentsBindingInfos.stream().map(BindingInfo::getReferences).flatMap(List::stream)
				.map(br -> getOtherBoundElement(br, boundable)).filter(Objects::nonNull).collect(Collectors.toSet());
	}

	private static Collection<BindingInfo> getViewElementParentBindingInfos(Collection<BindingInfo> rootBindingInfos,
			ViewElement boundable, List<ViewContainer> viewElementViewContainerParents) {
		Set<BindingInfo> parentBindingInfos = new HashSet<>();
		for (ViewContainer parent : viewElementViewContainerParents) {
			parentBindingInfos.addAll(rootBindingInfos.stream().filter(bi -> getOtherBoundElement(bi, parent) != null)
					.collect(Collectors.toList()));
		}
		return parentBindingInfos;
	}

	private Set<BoundableElement> getViewContainerLinkedBoundableElements(ViewContainer boundable,
			Collection<BindingInfo> rootBindingInfos) {
		return rootBindingInfos.stream().map(bi -> getOtherBoundElement(bi, boundable)).filter(Objects::nonNull)
				.collect(Collectors.toSet());
	}

	private static BoundableElement getOtherBoundElement(BindingInfo bindingInfo, BoundableElement boundable) {
		if (bindingInfo != null && boundable != null) {
			if (bindingInfo.getLeft() == boundable) {
				return bindingInfo.getRight();
			}
			if (bindingInfo.getRight() == boundable) {
				return bindingInfo.getLeft();
			}
		}
		return null;
	}

	private static BoundableElement getOtherBoundElement(BindingReference bindingReference,
			BoundableElement boundable) {
		if (bindingReference != null && boundable != null) {
			if (bindingReference.getLeft() != null && bindingReference.getLeft().getBoundElement() == boundable) {
				if (bindingReference.getRight() != null) {
					return bindingReference.getRight().getBoundElement();
				}
			}
			if (bindingReference.getRight() != null && bindingReference.getRight().getBoundElement() == boundable) {
				if (bindingReference.getLeft() != null) {
					return bindingReference.getLeft().getBoundElement();
				}
			}
		}
		return null;
	}

	/**
	 * Removes any {@link BindingInfo} whose 2 bound elements are both:
	 * otherBoundElement and element.
	 * 
	 * @param otherBoundElement
	 * @param element
	 */
	private static void removeBindingInfo(BoundableElement otherBoundElement, ViewContainer element) {
		EObjectQuery query = new EObjectQuery(otherBoundElement);
		Set<BindingInfo> bindingInfosToProcess = new HashSet<>();
		bindingInfosToProcess.addAll(query.getInverseReferences(EnvironmentPackage.Literals.BINDING_INFO__LEFT).stream()
				.filter(BindingInfo.class::isInstance).map(BindingInfo.class::cast)
				.filter(bi -> bi.getRight() == element).collect(Collectors.toSet()));
		bindingInfosToProcess.addAll(query.getInverseReferences(EnvironmentPackage.Literals.BINDING_INFO__RIGHT)
				.stream().filter(BindingInfo.class::isInstance).map(BindingInfo.class::cast)
				.filter(bi -> bi.getLeft() == element).collect(Collectors.toSet()));

		bindingInfosToProcess.stream().forEach(EcoreUtil::remove);
	}

	/**
	 * Adds in bindingRegistry a new {@link BindingInfo} with left and right bounds
	 * left and right respectively.
	 * 
	 * @param bindingRegistry
	 * @param left
	 * @param right
	 */
	private static void addBindingInfo(BindingRegistry bindingRegistry, BoundableElement left, BoundableElement right) {
		BindingInfo bindingInfo = EnvironmentFactory.eINSTANCE.createBindingInfo();
		bindingInfo.setLeft(left);
		bindingInfo.setRight(right);
		bindingRegistry.getBindingInfos().add(bindingInfo);
	}

	/**
	 * Removes any {@link BindingReference} whose 2 bound elements are both:
	 * otherElement and viewElement.
	 * 
	 * @param otherElement
	 * @param viewElement
	 */
	private static void removeBindingReference(BoundableElement otherElement, ViewElement viewElement) {
		EObjectQuery query = new EObjectQuery(otherElement);
		Set<BindingElement> bindingElementsToProcess = new HashSet<>();
		bindingElementsToProcess.addAll(query
				.getInverseReferences(EnvironmentPackage.Literals.BINDING_ELEMENT__BOUND_ELEMENT).stream()
				.filter(BindingElement.class::isInstance).map(BindingElement.class::cast).collect(Collectors.toSet()));

		Set<BindingReference> bindingReferencesToProcess = new HashSet<>();
		for (BindingElement bindingElement : bindingElementsToProcess) {
			EObjectQuery query2 = new EObjectQuery(bindingElement);
			bindingReferencesToProcess
					.addAll(query2.getInverseReferences(EnvironmentPackage.Literals.BINDING_REFERENCE__LEFT).stream()
							.filter(BindingReference.class::isInstance).map(BindingReference.class::cast)
							.filter(br -> br.getRight() != null && br.getRight().getBoundElement() == viewElement)
							.collect(Collectors.toSet()));
			bindingReferencesToProcess
					.addAll(query2.getInverseReferences(EnvironmentPackage.Literals.BINDING_REFERENCE__RIGHT).stream()
							.filter(BindingReference.class::isInstance).map(BindingReference.class::cast)
							.filter(br -> br.getLeft() != null && br.getLeft().getBoundElement() == viewElement)
							.collect(Collectors.toSet()));
		}
		bindingReferencesToProcess.stream().forEach(br -> {
			removeBindingReference(br);
		});
	}

	private static void removeBindingReference(BindingReference bindingReference) {
		if (bindingReference != null) {
			EcoreUtil.remove(bindingReference.getLeft());
			EcoreUtil.remove(bindingReference.getRight());
			EcoreUtil.remove(bindingReference);
		}
	}

	/**
	 * <p>
	 * Adds a new {@link BindingReference} with left and right
	 * {@link BoundableElement}s element and addedElement respectively.
	 * </p>
	 * <p>
	 * The BindingInfo used to add the bindingReference and its
	 * {@link BindingElement}s is typically a one whose left and right are parents
	 * of element and addedElement respectively.
	 * </p>
	 * <p>
	 * If a same {@link StructuredType} (parent of addedElement) is bound on
	 * different parents (of element), the parent which is closer to element is
	 * considered.
	 * </p>
	 * 
	 * @param viewElementParentsBindingInfos {@link BindingInfo}s of the parent
	 *                                       {@link ViewContainer}s of element
	 * @param addedElement                   the expected right bound element of the
	 *                                       {@link BindingReference} to create
	 * @param element                        the expected left bound element of the
	 *                                       {@link BindingReference} to create
	 * @param parents                        parent {@link ViewContainer}s of
	 *                                       element in ascending order of level of
	 *                                       containment; level is in the index in
	 *                                       the list.
	 * @param parentsBoundElements           map of bound {@link StructuredType}
	 *                                       given an element in parents.
	 * @param selectedElementToParentMap     map of {@link StructuredType} parent
	 *                                       given an element in the tree used to
	 *                                       select addedElement.
	 */
	private static void addBindingReference(Collection<BindingInfo> viewElementParentsBindingInfos,
			BoundableElement addedElement, ViewElement element, List<ViewContainer> parents,
			Map<ViewContainer, List<StructuredType>> parentsBoundElements,
			Map<Object, Object> selectedElementToParentMap) {
		if (addedElement.eContainer() instanceof StructuredType) {
			StructuredType st = (StructuredType) addedElement.eContainer();
			BindingInfo matchingBindingInfo = null;
			ViewContainer matchingParent = null;
			for (ViewContainer parent : parents) {
				matchingBindingInfo = getMatchingBindingInfo(addedElement, st, parent, viewElementParentsBindingInfos,
						parentsBoundElements, selectedElementToParentMap);
				if (matchingBindingInfo != null) {
					// The closer parent for BindingInfo is found.
					matchingParent = parent;
					break;
				}
			}
			if (matchingBindingInfo != null) {// Shouldn't be null
				addBindingReference(matchingBindingInfo, element, addedElement, selectedElementToParentMap);
				// Delete any other BindingReference at a level greater than the one of
				// matchingParent with bounds: element and addedElement.
				for (ViewContainer parent : parents.subList(parents.indexOf(matchingParent) + 1, parents.size())) {
					matchingBindingInfo = getMatchingBindingInfo(addedElement, st, parent,
							viewElementParentsBindingInfos, parentsBoundElements, selectedElementToParentMap);
					if (matchingBindingInfo != null) {
						for (BindingReference bindingReference : matchingBindingInfo.getReferences()) {
							if (isBindingReferenceMatching(bindingReference, element, addedElement)) {
								removeBindingReference(bindingReference);
							}
						}
					}
				}
			}
		}
	}

	private static BindingInfo getMatchingBindingInfo(BoundableElement addedElement, StructuredType st,
			ViewContainer parent, Collection<BindingInfo> viewElementParentsBindingInfos,
			Map<ViewContainer, List<StructuredType>> parentsBoundElements,
			Map<Object, Object> selectedElementToParentMap) {
		BindingInfo matchingBindingInfo = null;
		if (parentsBoundElements.getOrDefault(parent, Collections.emptyList()).contains(st)) {
			matchingBindingInfo = viewElementParentsBindingInfos.stream()
					.filter(bi -> isBindingInfoMatching(bi, parent, st)).findFirst().orElse(null);
		} else {
			// Case st is the indirect container, i.e., an element of associatedTypes of the
			// right container to consider.
			Set<StructuredType> stsPrim = getStructuredTypesFromAssociatedType(st);
			if (parentsBoundElements.getOrDefault(parent, Collections.emptyList()).stream()
					.anyMatch(stsPrim::contains)) {
				StructuredType stPrim = null;
				if (stsPrim.size() == 1) {
					stPrim = (StructuredType) stsPrim.toArray()[0];
				} else {
					// When several values, take the one that is such that stPrim was the parent of
					// addedElement
					// in the selection wizard.
					Object parentAddedElement = selectedElementToParentMap.getOrDefault(addedElement, null);
					if (parentAddedElement != null && parentsBoundElements.getOrDefault(parent, Collections.emptyList())
							.contains(parentAddedElement)) {
						stPrim = (StructuredType) parentAddedElement;
					}
				}
				final StructuredType finalStPrim = stPrim;
				matchingBindingInfo = viewElementParentsBindingInfos.stream()
						.filter(bi -> isBindingInfoMatching(bi, parent, finalStPrim)).findFirst().orElse(null);
			}
		}
		return matchingBindingInfo;
	}

	private static Set<StructuredType> getStructuredTypesFromAssociatedType(StructuredType associatedType) {
		if (associatedType == null) {
			return Collections.emptySet();
		}
		EObjectQuery query = new EObjectQuery(associatedType);
		return query.getInverseReferences(EnvironmentPackage.Literals.STRUCTURED_TYPE__ASSOCIATED_TYPES).stream()
				.filter(StructuredType.class::isInstance).map(StructuredType.class::cast).collect(Collectors.toSet());
	}

	private static void addBindingReference(BindingInfo bindingInfo, BoundableElement left, BoundableElement right,
			Map<Object, Object> selectedElementToParentMap) {
		BindingReference bindingRef = EnvironmentFactory.eINSTANCE.createBindingReference();
		BindingElement bidingEltLeft = createBindingElement(left, selectedElementToParentMap);
		BindingElement bidingEltRight = createBindingElement(right, selectedElementToParentMap);
		bindingRef.setLeft(bidingEltLeft);
		bindingRef.setRight(bidingEltRight);
		bindingInfo.getElements().add(bidingEltLeft);
		bindingInfo.getElements().add(bidingEltRight);
		bindingInfo.getReferences().add(bindingRef);
	}

	private static BindingElement createBindingElement(BoundableElement boundable,
			Map<Object, Object> selectedElementToParentMap) {
		List<BoundableElement> globalPath = getGlobalPath(boundable, selectedElementToParentMap);
		final BindingElement bindingElement = EnvironmentFactory.eINSTANCE.createBindingElement();
		bindingElement.setBoundElement(boundable);
		// globalPath.remove(globalPath.size() - 1);
		bindingElement.getPathReferences().addAll(globalPath);
		return bindingElement;
	}

	private static List<BoundableElement> getGlobalPath(BoundableElement boundable,
			Map<Object, Object> selectedElementToParentMap) {
		List<BoundableElement> globalPath = new ArrayList<BoundableElement>();
		EObject current = boundable;
		while (current != null) {
			if (current instanceof BoundableElement) {
				globalPath.add((BoundableElement) current);
			}
			EObject parent = current.eContainer();
			Object parentSelectedElement = selectedElementToParentMap.getOrDefault(current, null);
			if (parent != null && parentSelectedElement != null
					&& !((EObject) parentSelectedElement).eContents().contains(current)) {
				// check through associatedType
				if (parent instanceof StructuredType) {
					Set<StructuredType> sts = getStructuredTypesFromAssociatedType((StructuredType) parent);
					if (sts.size() == 1) {
						parent = (StructuredType) sts.toArray()[0];
					} else {
						// When several values, take the one that is such that stPrim was the parent of
						// addedElement
						// in the selection wizard.
						if (parentSelectedElement != null && sts.contains(parentSelectedElement)) {
							parent = (StructuredType) parentSelectedElement;
						}
					}

				}
			}
			current = parent;

		}
		if (!globalPath.isEmpty()) {
			// We remove the first element in path because not necessary
			globalPath.remove(0);
		}
		Collections.reverse(globalPath);
		return globalPath;
	}

	private static boolean isBindingReferenceMatching(BindingReference bindingRef, BoundableElement left,
			BoundableElement right) {
		if (bindingRef == null || left == null || right == null) {
			return false;
		}
		return (bindingRef.getLeft() != null && left.equals(bindingRef.getLeft().getBoundElement())
				&& bindingRef.getRight() != null && right.equals(bindingRef.getRight().getBoundElement()))
				|| (bindingRef.getRight() != null && left.equals(bindingRef.getRight().getBoundElement())
						&& bindingRef.getLeft() != null && right.equals(bindingRef.getLeft().getBoundElement()));
	}

	private static boolean isBindingInfoMatching(BindingInfo bindingInfo, BoundableElement left,
			BoundableElement right) {
		if (bindingInfo == null || left == null || right == null) {
			return false;
		}
		return (bindingInfo.getLeft() != null && left.equals(bindingInfo.getLeft()) && bindingInfo.getRight() != null
				&& right.equals(bindingInfo.getRight()))
				|| (bindingInfo.getRight() != null && left.equals(bindingInfo.getRight())
						&& bindingInfo.getLeft() != null && right.equals(bindingInfo.getLeft()));
	}

	/**
	 * <p>
	 * A source element ({@link ViewElement} or a {@link ViewContainer}) may be
	 * dropped into a new {@link ViewContainer} targetContainer in the following
	 * cases.
	 * </p>
	 * <p>
	 * If the source element is bound to objects whose contexts are parents or
	 * ancestors (of source) that remain with targetContainer.
	 * </p>
	 * <p>
	 * If source is a {@link ViewContainer}, its contained (regardless of their
	 * containment level) {@link ViewElement}s must preserve all their parent
	 * contexts
	 * </p>
	 * <p>
	 * If source is a {@link ViewElement}, its parent contexts must be preserved.
	 * </p>
	 * 
	 * @param element
	 * @param targetContainer
	 * @return
	 */
	public static boolean canDropAbstractViewElementIntoViewContainer(AbstractViewElement element,
			ViewContainer targetContainer) {
		if (element instanceof ViewElement) {
			// Get ViewContainer parents of element having BindingInfo
			// Get BindingInfos whose BindingReferences involve element
			// Ensure the ViewContainers associated to these BindingInfos are
			// parents/ancestors of targetContainer (included)
			List<ViewContainer> parents = getParentViewContainers((ViewElement) element);
			if (parents.isEmpty()) {
				return true;
			}
			CinematicRoot cinematicRoot = BindingService
					.getRegistryContainerForViewContainerBindingInfos(parents.get(0));
			if (cinematicRoot == null) {
				return true;
			}
			Set<BindingInfo> bindingInfos = cinematicRoot.getBindingRegistries().stream()
					.map(BindingRegistry::getBindingInfos).flatMap(List::stream).collect(Collectors.toSet());
			Collection<BindingInfo> viewElementParentsBindingInfos = getViewElementParentBindingInfos(bindingInfos,
					(ViewElement) element, parents);

			Collection<ViewContainer> requireViewContainers = viewElementParentsBindingInfos.stream()
					.map(bi -> getViewContainerBoundIfMatching(bi, (ViewElement) element)).filter(Objects::nonNull)
					.collect(Collectors.toSet());
			if (requireViewContainers.isEmpty()) {
				return true;
			}
			List<ViewContainer> newParents = getParentViewContainers(targetContainer);
			newParents.add(targetContainer);
			return newParents.containsAll(requireViewContainers);
//			Map<ViewContainer, List<StructuredType>> parentsBoundElements = getViewContainersBoundStructuredTypes(
//					viewElementParentsBindingInfos, parents);
		} else if (element instanceof ViewContainer) {
			// Get ViewContainer parents of element having BindingInfo
			// Get BindingInfos whose BindingReferences contain objects that are below
			// element
			// Ensure the ViewContainers associated to these BindingInfos are
			// parents/ancestors of targetContainer (included)
			List<ViewContainer> parents = getParentViewContainers(element);
			CinematicRoot cinematicRoot = BindingService
					.getRegistryContainerForViewContainerBindingInfos((ViewContainer) element);
			Set<BindingInfo> bindingInfosInvolvingViewElements = cinematicRoot.getBindingRegistries().stream()
					.map(BindingRegistry::getBindingInfos).flatMap(List::stream)
					.filter(bi -> isBindingInfoInvolvingViewElementWithGivenAncestorViewContainer(bi, parents))
					.collect(Collectors.toSet());
			Collection<ViewContainer> requireViewContainers = bindingInfosInvolvingViewElements.stream()
					.map(bi -> getViewContainerBoundIfMatching(bi, null)).filter(Objects::nonNull)
					.collect(Collectors.toSet());
			if (requireViewContainers.isEmpty()) {
				return true;
			}
			List<ViewContainer> newParents = getParentViewContainers(targetContainer);
			newParents.add(targetContainer);
			return newParents.containsAll(requireViewContainers);
//			Map<ViewContainer, List<StructuredType>> parentsBoundElements = getViewContainersBoundStructuredTypes(
//			bindingInfosInvolvingViewElements, parents);
		}
		return true;
	}

	private static ViewContainer getViewContainerBoundIfMatching(BindingInfo bindingInfo, ViewElement viewElement) {
		if (bindingInfo == null) {
			return null;
		}
		if (viewElement != null) {
			if (bindingInfo.getReferences().stream().noneMatch(br -> getOtherBoundElement(br, viewElement) != null)) {
				return null;
			}
		}
		if (bindingInfo.getLeft() instanceof ViewContainer) {
			return (ViewContainer) bindingInfo.getLeft();
		}
		if (bindingInfo.getRight() instanceof ViewContainer) {
			return (ViewContainer) bindingInfo.getRight();
		}
		return null;
	}

	private static boolean isBindingInfoInvolvingViewElementWithGivenAncestorViewContainer(BindingInfo bindingInfo,
			List<ViewContainer> ancestors) {
		if (bindingInfo.getElements().isEmpty()) {
			return false;
		}
		return bindingInfo.getElements().stream().map(BindingElement::getBoundElement)
				.filter(ViewElement.class::isInstance).map(ViewElement.class::cast)
				.anyMatch(ve -> !Collections.disjoint(getParentViewContainers(ve), ancestors));
	}
}
