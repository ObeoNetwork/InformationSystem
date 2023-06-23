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
package org.obeonetwork.dsl.environment.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.obeonetwork.dsl.environment.BindingElement;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.environment.BindingElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BindingElementItemProvider extends ObeoDSMObjectItemProvider {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0/\n\nContributors:\n    Obeo - initial API and implementation";

	private ComposedAdapterFactory composedAdapterFactory;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BindingElementItemProvider(AdapterFactory adapterFactory) {
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

			addBoundElementPropertyDescriptor(object);
			addBindingExpressionPropertyDescriptor(object);
			addReferencedByAsLeftPropertyDescriptor(object);
			addReferencedByAsRightPropertyDescriptor(object);
			addReferencedByPropertyDescriptor(object);
			addPathReferencesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Bound Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBoundElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_BindingElement_boundElement_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_BindingElement_boundElement_feature",
								"_UI_BindingElement_type"),
						EnvironmentPackage.Literals.BINDING_ELEMENT__BOUND_ELEMENT, true, false, true, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Binding Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBindingExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BindingElement_bindingExpression_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_BindingElement_bindingExpression_feature",
						"_UI_BindingElement_type"),
				EnvironmentPackage.Literals.BINDING_ELEMENT__BINDING_EXPRESSION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Referenced By As Left feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencedByAsLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BindingElement_referencedByAsLeft_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_BindingElement_referencedByAsLeft_feature",
						"_UI_BindingElement_type"),
				EnvironmentPackage.Literals.BINDING_ELEMENT__REFERENCED_BY_AS_LEFT, true, false, true, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Referenced By As Right feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencedByAsRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BindingElement_referencedByAsRight_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_BindingElement_referencedByAsRight_feature",
						"_UI_BindingElement_type"),
				EnvironmentPackage.Literals.BINDING_ELEMENT__REFERENCED_BY_AS_RIGHT, true, false, true, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Referenced By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_BindingElement_referencedBy_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_BindingElement_referencedBy_feature",
								"_UI_BindingElement_type"),
						EnvironmentPackage.Literals.BINDING_ELEMENT__REFERENCED_BY, false, false, false, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Path References feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPathReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_BindingElement_pathReferences_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_BindingElement_pathReferences_feature",
						"_UI_BindingElement_type"),
				EnvironmentPackage.Literals.BINDING_ELEMENT__PATH_REFERENCES, true, false, true, null, null, null));
	}

	/**
	 * This returns BindingElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BindingElement"));
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
		BindingElement bindingElement = (BindingElement) object;
		if (bindingElement.getBoundElement() != null) {
			label += getLabelFromProvider(bindingElement.getBoundElement());
		}

		return " ".equals(label) ? getString("_UI_BindingElement_type")
				: getString("_UI_BindingElement_type") + " " + label;
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

		switch (notification.getFeatureID(BindingElement.class)) {
		case EnvironmentPackage.BINDING_ELEMENT__BINDING_EXPRESSION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
