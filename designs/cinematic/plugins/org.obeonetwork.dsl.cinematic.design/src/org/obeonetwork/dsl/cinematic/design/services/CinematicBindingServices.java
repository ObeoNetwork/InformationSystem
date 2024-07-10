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

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingReference;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.binding.design.service.BindingService;
import org.obeonetwork.dsl.environment.design.extension.StructuredTypeChildrenContribution;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.SelectMode;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectTreeItemWrapper;
import org.obeonetwork.utils.common.EObjectUtils;

/**
 * This class is used to handle bindings in the Mockup View.
 * 
 * @author Obeo
 *
 */
public class CinematicBindingServices {
	
	private static AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	
	public void openBoundableElementsSelectionWizard(AbstractViewElement contextAbstractView) {
		if (contextAbstractView instanceof ViewContainer) {
			openViewContainerBindingWizard((ViewContainer)contextAbstractView);
		} else if (contextAbstractView instanceof ViewElement) {
			openViewElementBindingWizard((ViewElement)contextAbstractView);
		}
	}
	
	private void openViewContainerBindingWizard(ViewContainer contextViewContainer) {
		
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(
				CinematicBindingServices::getViewContainerBindingWizardChildren, 
				(wrappedEObject) -> wrappedEObject instanceof StructuredType);
		
		// The tree roots are the NamespacesContainers directly contained in the
		// Sirius session semantic resources
		new EObjectQuery(contextViewContainer).getSession().getSemanticResources().stream()//
		.map(Resource::getContents).flatMap(List::stream)//
		.filter(NamespacesContainer.class::isInstance).map(NamespacesContainer.class::cast)//
		.forEach(root -> new ISObjectTreeItemWrapper(treeRoot, root));
		
		BindingRegistry bindingRegistry = getOrCreateBindingRegistry(contextViewContainer);
		
		// Elements always selected (and that cannot be unselected) are StructuredTypes bound 
		// to any of the given ViewContainer's ancestors.
		List<StructuredType> alwaysSelectedElements = EObjectUtils.getAncestors(contextViewContainer).stream()//
		.filter(ViewContainer.class::isInstance).map(ViewContainer.class::cast)//
		.flatMap(viewContainer -> BindingService.getOtherBoundElements(bindingRegistry, viewContainer).stream())//
		.distinct()//
		.filter(StructuredType.class::isInstance).map(StructuredType.class::cast)//
		.toList();
		
		String windowTitle = "Entity/DTO selection";
		
		String message = "Select Entity or DTO elements to bind.";
		if(!alwaysSelectedElements.isEmpty()) {
			message += "\n"
					+ "Elements already bound to parent view containers cannot be unselected here.";
		}

        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);
		
        wizard.setAlwaysSelectedObjects(alwaysSelectedElements);
        
        List<BoundableElement> preSelectedElements = BindingService.getOtherBoundElements(bindingRegistry, contextViewContainer);
		wizard.setPreSelectedObjects(preSelectedElements);
        
        wizard.setLevelToExpand(2);
        
		wizard.setTreeSelectMode(SelectMode.PICK_ANY);
		
        if(wizard.open() == Window.OK) {
        	Set<StructuredType> selectedElements = wizard.getSelectedObjects().stream().map(StructuredType.class::cast).collect(toSet());
        	selectedElements.removeAll(alwaysSelectedElements);
        	
        	// Prepare to ask confirmation for suppressions
        	List<BindingInfo> toBeDeletedBindingInfos = preSelectedElements.stream()
    			.filter(preSelectedElement -> !selectedElements.contains(preSelectedElement))
    			.map(unselectedElement -> BindingService.getBindingInfo(bindingRegistry, contextViewContainer, unselectedElement))
    			.toList();
        	
        	// Perform changes only if there is no deletion or if the user confirms deletion
        	if(toBeDeletedBindingInfos.isEmpty() || openDeleteBindingInfosConfirmationDialog(toBeDeletedBindingInfos)) {
            	// Create new BindingInfos
            	selectedElements.stream()
            		.filter(selectedElement -> !preSelectedElements.contains(selectedElement))
            		.forEach(selectedElement -> {
            			BindingService.createBindingInfo(bindingRegistry, contextViewContainer, selectedElement);
            		});
            	
            	// Delete unselected BindingInfos
            	toBeDeletedBindingInfos.forEach(bindingInfo -> {
            		EcoreUtil.remove(bindingInfo);
            	});
            	
            	// Delete the BindingRegistry if it is empty
            	if(bindingRegistry.getBindingInfos().isEmpty()) {
            		EcoreUtil.remove(bindingRegistry);
            	}
        	}
        	
        }

	}

	private boolean openDeleteBindingInfosConfirmationDialog(List<BindingInfo> toBeDeletedBindingInfos) {
		
		String message = "The following bindings are going to be removed:\n" +
		toBeDeletedBindingInfos.stream()
			.map(bindingInfo -> 
				adapterFactoryLabelProvider.getText(bindingInfo.getLeft()) + 
				" -> " + 
				adapterFactoryLabelProvider.getText(bindingInfo.getRight()) +
				" (containing " + bindingInfo.getReferences().size() + " references)" )
			.collect(joining("\n", "   ", "\n")) +
		"\n" +
		"Confirm deletion?";
		
		return MessageDialog.openConfirm(
				Display.getCurrent().getActiveShell(),
				"Remove bindings",
				message);
	}

	private static List<EObject> getViewContainerBindingWizardChildren(Object parent) {
		List<EObject> children = new ArrayList<>();
		if(parent instanceof NamespacesContainer) {
			children.addAll(((NamespacesContainer)parent).getOwnedNamespaces());
		}
		if(parent instanceof Namespace) {
			children.addAll(((Namespace)parent).getTypes().stream()
					.filter(StructuredType.class::isInstance).toList());
		}
		if(parent instanceof StructuredType) {
			children.addAll(((StructuredType) parent).getAssociatedTypes());
			children.addAll(((StructuredType) parent).getReferences());
		}
		return children;
	}
	
	/**
	 * Get or create the BindingRegistry for the given ObeoDSMObject of a Cinematic model.
	 * The binding registry is supposed to be held by the CinematicRoot element. But as
	 * any ObeoDSMObject can hold binding registries, this service just looks for the highest
	 * instance of ObeoDSMObject in the given object ancestors to be the BindingRegistry
	 * holder.
	 * 
	 * @param object an ObeoDSMObject of a Cinematic model.
	 * @return The BindingRegistry for the given ObeoDSMObject.
	 */
	public static BindingRegistry getOrCreateBindingRegistry(ObeoDSMObject object) {
		BindingRegistry bindingRegistry = null;
		
		ObeoDSMObject rootContainer = EObjectUtils.getAncestors(object).stream()//
		.filter(ObeoDSMObject.class::isInstance).map(ObeoDSMObject.class::cast)//
		.findFirst().orElse(null);
		
		EList<BindingRegistry> bindingRegistries = ((ObeoDSMObject) rootContainer).getBindingRegistries();
		if(bindingRegistries.isEmpty()) {
			bindingRegistry = EnvironmentFactory.eINSTANCE.createBindingRegistry();
			bindingRegistries.add(bindingRegistry);
		} else {
			bindingRegistry = bindingRegistries.get(0);
		}
		
		return bindingRegistry;
	}
	
	private void openViewElementBindingWizard(ViewElement contextViewElement) {
		
		final StructuredTypeChildrenContribution structuredTypeChildrenContribution = new StructuredTypeChildrenContribution();
		ISObjectTreeItemWrapper treeRoot = new ISObjectTreeItemWrapper(
				parent -> structuredTypeChildrenContribution.getChildren((EObject) parent), 
				(wrappedEObject) -> wrappedEObject instanceof Property);
		
		BindingRegistry bindingRegistry = getOrCreateBindingRegistry(contextViewElement);
		
		List<BindingInfo> ancestorsBindingInfos = EObjectUtils.getAncestors(contextViewElement).stream()//
			.filter(ViewContainer.class::isInstance).map(ViewContainer.class::cast)//
			.flatMap(viewContainer -> BindingService.getBindingInfos(bindingRegistry, viewContainer).stream())
			.toList();
		
		// If no ancestors of the context ViewElement is binded, no Property can be bound.
		if(ancestorsBindingInfos.isEmpty()) {
			// Warn the user and exit.
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), 
					"Entity/DTO attributes and references binding",
					"No ViewContainer parent is bound.\n" +
					"At least one parent ViewContainer should be bound.");
			return;
		}
		
		// The tree roots are the StructuredTypes bound to ancestors of the context ViewElement 
		// of type ViewContainer and being involved in a BindingInfo
		ancestorsBindingInfos.stream()//
			.map(BindingInfo::getRight)//
			.filter(StructuredType.class::isInstance).map(StructuredType.class::cast)//
			.forEach(root -> new ISObjectTreeItemWrapper(treeRoot, root));
		
		String windowTitle = "Entity/DTO attributes and references selection";
		
		String message = "Select Attribute or Reference elements to bind.";
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		treeRoot,
        		true);

        // Preselected tree item wrappers are found by browsing the tree following the 
        // full path of the binding element.
        List<ISObjectTreeItemWrapper> preSelectedTreeItemWrappers = ancestorsBindingInfos.stream()//
	        .flatMap(bindingInfo -> bindingInfo.getReferences().stream())//
	        .filter(bindingReference -> bindingReference.getLeft().getBoundElement() == contextViewElement)//
	        .map(bindingReference -> bindingReference.getRight())//
	        .map(CinematicBindingServices::getFullPathReferences)//
	        .map(path -> getTreeItemWrapperFromPath(treeRoot, path))
	        .toList();
        wizard.setPreSelectedTreeItemWrappers(preSelectedTreeItemWrappers);
        
        wizard.setLevelToExpand(2);
        
		wizard.setTreeSelectMode(SelectMode.PICK_ANY);
		
        if(wizard.open() == Window.OK) {
        	
        	// Reverse this list to ease looking into it from bottom to top ViewContainers hierarchy
        	List<BindingInfo> ancestorsBindingInfosReversed = new ArrayList<>(ancestorsBindingInfos);
        	Collections.reverse(ancestorsBindingInfosReversed);
        	
        	// Create new BindingReferences
        	Collection<ISObjectTreeItemWrapper> selectedTreeItemWrappers = wizard.getSelectedTreeItemWrappers();
        	selectedTreeItemWrappers.stream()//
	        	.filter(selectedTreeItemWraper -> !preSelectedTreeItemWrappers.contains(selectedTreeItemWraper))//
	        	.map(CinematicBindingServices::getPathFromTreeItemWrapper)//
	        	.forEach(path -> {
	        		// Find the first BindingInfo from bottom to top ViewContainers hierarchy 
	        		// whose right bound element is the root StructuredType of the selected
	        		// attribute/reference in the dialog tree.
	        		BindingInfo bindingInfo = ancestorsBindingInfosReversed.stream()//
		        		.filter(ancestorBindingInfo -> ancestorBindingInfo.getRight() == path.get(0))
		        		.findFirst().orElse(null);
	        		// And create a BindingReference in it.
	        		createBindingReference(bindingInfo, contextViewElement, path);
	        	});
        	
        	// Delete unselected BindingReferences
        	preSelectedTreeItemWrappers.stream()//
        		.filter(preSelectedTreeItemWrapper -> !selectedTreeItemWrappers.contains(preSelectedTreeItemWrapper))
	        	.map(CinematicBindingServices::getPathFromTreeItemWrapper)//
        		.map(unselectedPath -> getBindingReferenceFromPath(ancestorsBindingInfosReversed, unselectedPath))
        		.forEach(CinematicBindingServices::removeBindingReference);
        }
        
	}
	
	private static BindingReference getBindingReferenceFromPath(List<BindingInfo> bindingInfos, List<BoundableElement> rightPath) {
		return bindingInfos.stream()//
			.filter(bindingInfo -> bindingInfo.getRight() == rightPath.get(0))//
			.map(BindingInfo::getReferences).flatMap(List::stream)//
			.filter(bindingReference -> getFullPathReferences(bindingReference.getRight()).equals(rightPath))
			.findFirst().orElse(null);
	}
	
	private static List<BoundableElement> getFullPathReferences(BindingElement bindingElement) {
		List<BoundableElement> fullPathReferences = new ArrayList<>(bindingElement.getPathReferences());
		fullPathReferences.add(bindingElement.getBoundElement());
		return fullPathReferences;
	}
	
	private static ISObjectTreeItemWrapper getTreeItemWrapperFromPath(ISObjectTreeItemWrapper rootTiw, List<BoundableElement> path) {
		ISObjectTreeItemWrapper tiw = rootTiw;
		for(BoundableElement pathElement : path) {
			tiw = tiw.getChildren().stream()//
				.filter(childTiw -> childTiw.getWrappedObject() == pathElement)
				.findFirst().orElse(null);
		}
		return tiw;
	}
	
	private static List<BoundableElement> getPathFromTreeItemWrapper(ISObjectTreeItemWrapper tiw) {
		List<BoundableElement> path = new LinkedList<>();
		while(tiw.getParent() != null) {
			path.add(0, (BoundableElement) tiw.getWrappedObject());
			tiw = tiw.getParent();
		}
		return path;
	}

	private static BindingReference createBindingReference(BindingInfo bindingInfo, BoundableElement leftBoundableElement, List<BoundableElement> rightPath) {
		BindingElement leftBindingElement = EnvironmentFactory.eINSTANCE.createBindingElement();
		leftBindingElement.getPathReferences().add(bindingInfo.getLeft());
		leftBindingElement.setBoundElement(leftBoundableElement);
		
		BindingElement rightBindingElement = EnvironmentFactory.eINSTANCE.createBindingElement();
		rightBindingElement.getPathReferences().addAll(rightPath.subList(0, rightPath.size() - 1));
		rightBindingElement.setBoundElement(rightPath.get(rightPath.size() - 1));
		
		BindingReference bindingReference = EnvironmentFactory.eINSTANCE.createBindingReference();
		bindingReference.setLeft(leftBindingElement);
		bindingReference.setRight(rightBindingElement);
		
		bindingInfo.getElements().add(leftBindingElement);
		bindingInfo.getElements().add(rightBindingElement);
		bindingInfo.getReferences().add(bindingReference);
		
		return bindingReference;
	}
	
	private static void removeBindingReference(BindingReference bindingReference) {
		EcoreUtil.remove(bindingReference.getLeft());
		EcoreUtil.remove(bindingReference.getRight());
		EcoreUtil.remove(bindingReference);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	public static String canDropAbstractViewElementIntoViewContainer(AbstractViewElement element,
			ViewContainer targetContainer) {
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
