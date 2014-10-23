/**
 * Copyright (c) 2010-2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.graal.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.graal.System} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemItemProvider
	extends NamedElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemItemProvider(AdapterFactory adapterFactory) {
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

			addNamespacesPropertyDescriptor(object);
			addTypesPropertyDescriptor(object);
			addOwnedTasksPropertyDescriptor(object);
			addOwnedGroupsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Namespaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamespacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DomainModelRegistry_namespaces_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DomainModelRegistry_namespaces_feature", "_UI_DomainModelRegistry_type"),
				 GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__NAMESPACES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Types feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DomainModelRegistry_types_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DomainModelRegistry_types_feature", "_UI_DomainModelRegistry_type"),
				 GraalPackage.Literals.DOMAIN_MODEL_REGISTRY__TYPES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Owned Tasks feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TasksContainer_ownedTasks_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TasksContainer_ownedTasks_feature", "_UI_TasksContainer_type"),
				 GraalPackage.Literals.TASKS_CONTAINER__OWNED_TASKS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Owned Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TasksContainer_ownedGroups_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TasksContainer_ownedGroups_feature", "_UI_TasksContainer_type"),
				 GraalPackage.Literals.TASKS_CONTAINER__OWNED_GROUPS,
				 false,
				 false,
				 false,
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
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GraalPackage.Literals.SYSTEM__SUB_SYSTEMS);
			childrenFeatures.add(GraalPackage.Literals.TASKS_CONTAINER__TASKS);
			childrenFeatures.add(GraalPackage.Literals.SYSTEM__USE_CASES);
			childrenFeatures.add(GraalPackage.Literals.SYSTEM__USER_STORIES);
			childrenFeatures.add(GraalPackage.Literals.SYSTEM__ACTORS);
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
	 * This returns System.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/System"));
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
		String label = ((org.obeonetwork.graal.System)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_System_type") :
			getString("_UI_System_type") + " " + label;
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

		switch (notification.getFeatureID(org.obeonetwork.graal.System.class)) {
			case GraalPackage.SYSTEM__TASKS:
			case GraalPackage.SYSTEM__SUB_SYSTEMS:
			case GraalPackage.SYSTEM__ACTORS:
			case GraalPackage.SYSTEM__USE_CASES:
			case GraalPackage.SYSTEM__USER_STORIES:
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
				(GraalPackage.Literals.TASKS_CONTAINER__TASKS,
				 GraalFactory.eINSTANCE.createTask()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.TASKS_CONTAINER__TASKS,
				 GraalFactory.eINSTANCE.createTasksGroup()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.SYSTEM__SUB_SYSTEMS,
				 GraalFactory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.SYSTEM__ACTORS,
				 GraalFactory.eINSTANCE.createActor()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.SYSTEM__USE_CASES,
				 GraalFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.SYSTEM__USER_STORIES,
				 GraalFactory.eINSTANCE.createUserStory()));
	}

}
