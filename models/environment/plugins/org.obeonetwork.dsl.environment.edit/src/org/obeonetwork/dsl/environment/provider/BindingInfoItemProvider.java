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
package org.obeonetwork.dsl.environment.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.environment.BindingInfo} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BindingInfoItemProvider extends ObeoDSMObjectItemProvider {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	private ComposedAdapterFactory composedAdapterFactory;
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BindingInfoItemProvider(AdapterFactory adapterFactory) {
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

			addLeftPropertyDescriptor(object);
			addRightPropertyDescriptor(object);
			addSubBindingInfosPropertyDescriptor(object);
			addTargetsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Left feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_BindingInfo_left_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_BindingInfo_left_feature",
								"_UI_BindingInfo_type"),
						EnvironmentPackage.Literals.BINDING_INFO__LEFT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Right feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_BindingInfo_right_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_BindingInfo_right_feature",
								"_UI_BindingInfo_type"),
						EnvironmentPackage.Literals.BINDING_INFO__RIGHT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Sub Binding Infos feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubBindingInfosPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_BindingInfo_subBindingInfos_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_BindingInfo_subBindingInfos_feature",
								"_UI_BindingInfo_type"),
						EnvironmentPackage.Literals.BINDING_INFO__SUB_BINDING_INFOS, true, false, true, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Targets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_BindingInfo_targets_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_BindingInfo_targets_feature",
								"_UI_BindingInfo_type"),
						EnvironmentPackage.Literals.BINDING_INFO__TARGETS, false, false, false, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EnvironmentPackage.Literals.BINDING_INFO__REFERENCES);
			childrenFeatures.add(EnvironmentPackage.Literals.BINDING_INFO__ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns BindingInfo.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BindingInfo"));
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
		String label = " ";
		BindingInfo bindingInfo = (BindingInfo) object;
		if (bindingInfo.getLeft() != null) {
			label += getLabelFromProvider(bindingInfo.getLeft());
		} else {
			label += "undefined";
		}
		label += " - ";
		if (bindingInfo.getRight() != null) {
			label += getLabelFromProvider(bindingInfo.getRight());
		} else {
			label += "undefined";
		}

		return " ".equals(label) ? getString("_UI_BindingInfo_type") : getString("_UI_BindingInfo_type") + " " + label;
	}
	
	private String getLabelFromProvider(Object object) {
		IItemLabelProvider labelProvider = (IItemLabelProvider)composedAdapterFactory.adapt(object, IItemLabelProvider.class);
		if (labelProvider != null) {
			return labelProvider.getText(object);
		}
		return null;
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

		switch (notification.getFeatureID(BindingInfo.class)) {
		case EnvironmentPackage.BINDING_INFO__REFERENCES:
		case EnvironmentPackage.BINDING_INFO__ELEMENTS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
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

		newChildDescriptors.add(createChildParameter(EnvironmentPackage.Literals.BINDING_INFO__REFERENCES,
				EnvironmentFactory.eINSTANCE.createBindingReference()));

		newChildDescriptors.add(createChildParameter(EnvironmentPackage.Literals.BINDING_INFO__ELEMENTS,
				EnvironmentFactory.eINSTANCE.createBindingElement()));
	}

}
