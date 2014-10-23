/**
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.cinematic.CinematicElement;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.Reference;

/**
 * This class is used to handle binding informations 
 * @author sthibaudeau
 *
 */
public class CinematicBindingServices {
	
	private static AdapterFactoryLabelProvider aflp = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	
	public String getCinematicBindingInfoLabel(BindingInfo bindingInfo) {
		EObject element = getCinematicBoundElement(bindingInfo);
		if (element == null) {
			element = bindingInfo;
		}
		if (element instanceof DTO) {
			return ((DTO) element).getName() + " (DTO)";
		} else if (element instanceof Attribute) {
			Attribute attribute = (Attribute) element;
			return attribute.getContainingType().getName() + "." + attribute.getName() + " (DTO Attribute)";
		} else if (element instanceof Reference) {
			Reference reference = (Reference) element;
			return reference.getContainingType().getName() + "." + reference.getName() + " (DTO Reference)";
		} else if (element.eClass().getEPackage().getNsURI().startsWith("http://www.obeonetwork.org/dsl/entity/")) {
			if ("Entity".equals(element.eClass().getName())) {
				return getNameByReflection(element) + " (Entity)";
			} else if ("Attribute".equals(element.eClass().getName())) {
				return  getNameByReflection(element.eContainer()) + "." +  getNameByReflection(element) + " (Entity Attribute)";
			} else if ("Reference".equals(element.eClass().getName())) {
				return  getNameByReflection(element.eContainer()) + "." +  getNameByReflection(element) + " (Entity Reference)";
			}
			return null;
		} else {
			return getGenericLabel(element);
		}
	}
	
	private String getNameByReflection(EObject object) {
		if (object == null) {
			return null;
		}
		EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name");
		return object.eGet(nameFeature).toString();
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
