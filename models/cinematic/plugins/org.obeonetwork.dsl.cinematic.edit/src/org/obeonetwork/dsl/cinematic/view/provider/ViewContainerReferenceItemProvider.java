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
package org.obeonetwork.dsl.cinematic.view.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.obeonetwork.dsl.cinematic.view.ViewContainerReference;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.cinematic.view.ViewContainerReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewContainerReferenceItemProvider
	extends AbstractViewElementItemProvider {
	
	private ComposedAdapterFactory composedAdapterFactory;
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ViewContainerReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
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

			addViewContainerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the View Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addViewContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewContainerReference_viewContainer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewContainerReference_viewContainer_feature", "_UI_ViewContainerReference_type"),
				 ViewPackage.Literals.VIEW_CONTAINER_REFERENCE__VIEW_CONTAINER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns ViewContainerReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		ViewContainerReference viewContainerReference  = (ViewContainerReference)object;
		if (viewContainerReference.getViewContainer() != null) {
			Object viewContainerImage = getImageFromProvider(viewContainerReference.getViewContainer());
			
			// Add an overlay to indicate it's a reference to this ViewContainer
			List<Object> images = new ArrayList<Object>(2);
			images.add(viewContainerImage);
			images.add(getResourceLocator().getImage("full/ovr16/ViewContainerReferenceOverlay"));
			Object viewContainerReferenceImage = new ComposedImage(images);
			return overlayImage(object, viewContainerReferenceImage);
		} else {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/ViewContainerReference"));
		}
	}
	
	private Object getImageFromProvider(Object object) {
		IItemLabelProvider labelProvider = (IItemLabelProvider)composedAdapterFactory.adapt(object, IItemLabelProvider.class);
		if (labelProvider != null) {
			return labelProvider.getImage(object);
		}
		return null;
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
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ViewContainerReference viewContainerReference = (ViewContainerReference)object;
		String label = viewContainerReference.getName();
		if (label == null) {
			label += "";
		}
		if (viewContainerReference.getViewContainer() != null) {
			label += " : " + viewContainerReference.getViewContainer().getName(); 
		}
		return label == null || label.length() == 0 ?
			getString("_UI_ViewContainerReference_type") :
			getString("_UI_ViewContainerReference_type") + " " + label;
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

}
