/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.ecorebinding.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.obeonetwork.dsl.ecorebinding.BPackage;
import org.obeonetwork.dsl.ecorebinding.EcorebindingFactory;
import org.obeonetwork.dsl.ecorebinding.EcorebindingPackage;
import org.obeonetwork.dsl.technicalid.provider.IdentifiableItemProvider;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.ecorebinding.BPackage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BPackageItemProvider
	extends IdentifiableItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPackageItemProvider(AdapterFactory adapterFactory) {
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

			addEcorePackagePropertyDescriptor(object);
			addBClassifiersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ecore Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEcorePackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BPackage_ecorePackage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BPackage_ecorePackage_feature", "_UI_BPackage_type"),
				 EcorebindingPackage.Literals.BPACKAGE__ECORE_PACKAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the BClassifiers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBClassifiersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BPackage_bClassifiers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BPackage_bClassifiers_feature", "_UI_BPackage_type"),
				 EcorebindingPackage.Literals.BPACKAGE__BCLASSIFIERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(EcorebindingPackage.Literals.BPACKAGE__BENUMS);
			childrenFeatures.add(EcorebindingPackage.Literals.BPACKAGE__BDATA_TYPES);
			childrenFeatures.add(EcorebindingPackage.Literals.BPACKAGE__BCLASSES);
			childrenFeatures.add(EcorebindingPackage.Literals.BPACKAGE__NESTED_BPACKAGES);
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
	 * This returns BPackage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BPackage"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public String getText(Object object) {
		if(object instanceof BPackage) {
			BPackage bPackage = (BPackage)object;
			return getString("_UI_BPackage_type").concat(" ").concat(bPackage.getEcorePackage().getName());
		}
		return getString("_UI_BPackage_type");
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

		switch (notification.getFeatureID(BPackage.class)) {
			case EcorebindingPackage.BPACKAGE__BENUMS:
			case EcorebindingPackage.BPACKAGE__BDATA_TYPES:
			case EcorebindingPackage.BPACKAGE__BCLASSES:
			case EcorebindingPackage.BPACKAGE__NESTED_BPACKAGES:
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

		newChildDescriptors.add
			(createChildParameter
				(EcorebindingPackage.Literals.BPACKAGE__BENUMS,
				 EcorebindingFactory.eINSTANCE.createBEnum()));

		newChildDescriptors.add
			(createChildParameter
				(EcorebindingPackage.Literals.BPACKAGE__BDATA_TYPES,
				 EcorebindingFactory.eINSTANCE.createBDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorebindingPackage.Literals.BPACKAGE__BDATA_TYPES,
				 EcorebindingFactory.eINSTANCE.createBEnum()));

		newChildDescriptors.add
			(createChildParameter
				(EcorebindingPackage.Literals.BPACKAGE__BCLASSES,
				 EcorebindingFactory.eINSTANCE.createBClass()));

		newChildDescriptors.add
			(createChildParameter
				(EcorebindingPackage.Literals.BPACKAGE__NESTED_BPACKAGES,
				 EcorebindingFactory.eINSTANCE.createBPackage()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EcorebindingPackage.Literals.BPACKAGE__BENUMS ||
			childFeature == EcorebindingPackage.Literals.BPACKAGE__BDATA_TYPES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EcorebindingEditPlugin.INSTANCE;
	}

}
