/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * This class is used to handle binding informations 
 * @author sthibaudeau
 *
 */
public class CinematicBindingServices {
	private static final String TYPE_NAME_PATTERN = "%1s (%2s)";
	private static final String PROPERTY_NAME_PATTERN = "%1s.%2s (%3s %4s)";
	
	private static AdapterFactoryLabelProvider aflp = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	
	public String getCinematicBindingInfoLabel(BindingInfo bindingInfo) {
		EObject element = getCinematicBoundElement(bindingInfo);
		if (element == null) {
			element = bindingInfo;
		}
		if (element instanceof StructuredType) {
			return getLabelForStructuredType((StructuredType)element);
		} else if (element instanceof Property) {
			return getLabelForStructuredTypeProperty((Property)element);
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
			StructuredType type = (StructuredType)property.eContainer();
			return String.format(propertyPattern, type.getName(), property.getName(), type.eClass().getName(), property.eClass().getName());
		} else {
			// Should never ever happen but though let's handle this case
			String typePattern = TYPE_NAME_PATTERN;
			return String.format(typePattern, property.getName(), property.eClass().getName());
		}
	}
	
	public BoundableElement getCinematicBoundElement(BindingInfo bindingInfo) {
		if (! (bindingInfo.getRight() instanceof CinematicElement)) {
			return bindingInfo.getRight(); 
		} else if (! (bindingInfo.getLeft() instanceof CinematicElement)) {
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
			BoundableElement target = (BoundableElement)boundElement;
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
		for(BindingInfo bi : getGlobalBindingRegistry(viewElement).getBindingInfos()) {
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
			return (CinematicRoot)element;
		} else {
			EObject parent = element.eContainer();
			if (parent != null && parent instanceof CinematicElement) {
				return getCinematicRoot((CinematicElement)parent);
			} else {
				return null;
			}
		}
	}
}
