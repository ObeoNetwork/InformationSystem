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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.binding.design.service.BindingService;

/**
 * @author fksimo
 *
 */
public class CinematicDropServices {
	// This code needs review and refactoring but it happen to work as it is.

	private static AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	
	public static boolean isDropAllowedForCinematicElementOn(EObject element, EObject container) {
		EList<EReference> containmentReferences = container.eClass().getEAllContainments();
		for (EReference eReference : containmentReferences) {
			if (eReference.getEType() != null) {
				if (eReference.getEType().isInstance(element)) {
					return true;
				}
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public static EObject dropOnCinematicContainer(EObject element, EObject container) {
		Session session = Session.of(element).orElse(null);
		if (session == null) {
			return null;
		}
		session.getTransactionalEditingDomain().getCommandStack()
				.execute(new RecordingCommand(session.getTransactionalEditingDomain(), "DnD") {

					@Override
					protected void doExecute() {
						// TODO Auto-generated method stub
						if (element instanceof AbstractViewElement && container instanceof ViewContainer) {
							String impacted = canDropAbstractViewElementIntoViewContainer(
									(AbstractViewElement) element, (ViewContainer) container);
							if (!impacted.isEmpty()) {
								MessageDialog.openWarning(null, "Drop into a ViewContainer",
										"The operation will be cancelled because the parent ViewContainers (below)"
												+ "\n of the element to be moved are involved in a binding that would no longer be valid."
												+ "\n\n" + impacted);
								throw new OperationCanceledException();
								// return element;
							}
						}
						EList<EReference> containmentReferences = container.eClass().getEAllContainments();
						for (EReference eReference : containmentReferences) {
							if (eReference.getEType() != null) {
								if (eReference.getEType().isInstance(element)) {
									// We're going to move the element into this containment feature
									Object oldValues = container.eGet(eReference, true);
									if (oldValues instanceof Collection) {
										((Collection<EObject>) oldValues).add(element);
									}
//									container.eSet(eReference, oldValues);
									// return element;
								}
							}
						}
						// return element;

					}
				});

		return element;
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
	 * @return a list of impacted elements, each on a line, if any; an empty string
	 *         otherwise.
	 */
	private static String canDropAbstractViewElementIntoViewContainer(AbstractViewElement element, ViewContainer targetContainer) {
		if (element instanceof ViewElement) {
			// Get ViewContainer parents of element having BindingInfo
			// Get BindingInfos whose BindingReferences involve element
			// Ensure the ViewContainers associated to these BindingInfos are
			// parents/ancestors of targetContainer (included)
			List<ViewContainer> parents = getParentViewContainers((ViewElement) element);
			if (parents.isEmpty()) {
				return "";
			}
			CinematicRoot cinematicRoot = BindingService.getRegistryContainerForViewContainerBindingInfos(parents.get(0));
			if (cinematicRoot == null) {
				return "";
			}
			Set<BindingInfo> bindingInfos = cinematicRoot.getBindingRegistries().stream()
					.map(BindingRegistry::getBindingInfos).flatMap(List::stream).collect(Collectors.toSet());
			Collection<BindingInfo> viewElementParentsBindingInfos = getViewElementParentBindingInfos(bindingInfos,
					(ViewElement) element, parents);

			Collection<ViewContainer> requiredViewContainers = viewElementParentsBindingInfos.stream()
					.map(bi -> getViewContainerBoundIfMatching(bi, (ViewElement) element)).filter(Objects::nonNull)
					.collect(Collectors.toSet());
			if (requiredViewContainers.isEmpty()) {
				return "";
			}
			List<ViewContainer> newParents = getParentViewContainers(targetContainer);
			newParents.add(targetContainer);
			requiredViewContainers.removeAll(newParents);
			if(requiredViewContainers.isEmpty()) {
				return "";
			}
			return buildImpactedElementsString(new ArrayList<>(requiredViewContainers),10);
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
			Collection<ViewContainer> requiredViewContainers = bindingInfosInvolvingViewElements.stream()
					.map(bi -> getViewContainerBoundIfMatching(bi, null)).filter(Objects::nonNull)
					.collect(Collectors.toSet());
			if (requiredViewContainers.isEmpty()) {
				return "";
			}
			List<ViewContainer> newParents = getParentViewContainers(targetContainer);
			newParents.add(targetContainer);
			requiredViewContainers.removeAll(newParents);
			if(requiredViewContainers.isEmpty()) {
				return "";
			}
			return buildImpactedElementsString(new ArrayList<>(requiredViewContainers),10);
		}
		return "";
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

	private static Collection<BindingInfo> getViewElementParentBindingInfos(Collection<BindingInfo> rootBindingInfos,
			ViewElement boundable, List<ViewContainer> viewElementViewContainerParents) {
		Set<BindingInfo> parentBindingInfos = new HashSet<>();
		for (ViewContainer parent : viewElementViewContainerParents) {
			parentBindingInfos.addAll(rootBindingInfos.stream().filter(bi -> getOtherBoundElement(bi, parent) != null)
					.collect(Collectors.toList()));
		}
		return parentBindingInfos;
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

	private static BoundableElement getOtherBoundElement(BindingReference bindingReference, BoundableElement boundable) {
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

	private static String buildImpactedElementsString(List<? extends EObject> impacted,  int limit) {
		String res = "";
		if (!impacted.isEmpty()) {
			int impactedSize = impacted.size();
			if (impactedSize > limit) {
				impacted = impacted.subList(0, limit+1);
			}
			res = impacted.stream().map(e -> adapterFactoryLabelProvider.getText(e)).collect(Collectors.joining("\n"));
			if (impactedSize > limit) {
				res += "\n...";
				res += "\n(" + impactedSize + " in total)";
			}
		}
		return res;
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
