/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.obeonetwork.dsl.environment.provider.ObeoDSMObjectItemProvider;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.Wire;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.soa.Wire} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WireItemProvider
	extends ObeoDSMObjectItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2020 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSourcePropertyDescriptor(object);
			addDestPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		final System system = getContainingSystem((EObject) object);		
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Wire_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Wire_source_feature", "_UI_Wire_type"),
				 SoaPackage.Literals.WIRE__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			{
				public java.util.Collection<?>getChoiceOfValues(Object object){
					Collection<Object> choiceOfValues=new ArrayList<Object>();
					List<org.obeonetwork.dsl.soa.Service>services = getRequiredServices(system);
					choiceOfValues.addAll(services);
					return choiceOfValues;
				}
			}
		);
	}
	
	private System getContainingSystem(EObject object) {
		if (object instanceof System) {
			return (System)object;
		} else {
			EObject eContainer = object.eContainer();
			if (eContainer != null) {
				return getContainingSystem(eContainer);
			}
		}
		return null;
	}
	
	/**
	 * Return the provided services in a System.
	 * @param system
	 * @return providedServices
	 * @generated NOT
	 * @added
	 */
	private List<Service> getProvidedServices(System system) {
		List<Service> providedServices = new ArrayList<Service>();
		List<Component> ownedComponents = system.getOwnedComponents();
		for (Component component : ownedComponents) {
			providedServices.addAll(component.getProvidedServices());
		}
		return providedServices;
	}
	

	/**
	 * This adds a property descriptor for the Dest feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDestPropertyDescriptor(Object object) {
		final System system = getContainingSystem((EObject) object);
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Wire_dest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Wire_dest_feature", "_UI_Wire_type"),
				 SoaPackage.Literals.WIRE__DEST,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			{
				public java.util.Collection<?>getChoiceOfValues(Object object){
					Collection<Object> choiceOfValues=new ArrayList<Object>();
					List<org.obeonetwork.dsl.soa.Service>services = getProvidedServices(system);
					choiceOfValues.addAll(services);
					return choiceOfValues;
				}
			}
		);
	}
	/**
	 * Return the required services in a System.
	 * @param system
	 * @return requiredServices
	 * @generated NOT
	 * @added
	 */
	private List<Service> getRequiredServices(System system) {
		List<Service> requiredServices=new ArrayList<Service>();
		List<Component> ownedComponents = system.getOwnedComponents();
		for (Component component : ownedComponents) {
			requiredServices.addAll(component.getRequiredServices());
		}
		return requiredServices;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = crop(((Wire)object).getDescription());
		return label == null || label.length() == 0 ?
			getString("_UI_Wire_type") :
			getString("_UI_Wire_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SoaEditPlugin.INSTANCE;
	}

	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Wire"));
	}

}
