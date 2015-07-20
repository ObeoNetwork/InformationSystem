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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.obeonetwork.graal.Activity;
import org.obeonetwork.graal.GraalFactory;
import org.obeonetwork.graal.GraalPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.graal.Activity} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityItemProvider
	extends GraalObjectItemProvider
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
	public ActivityItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(GraalPackage.Literals.ACTIVITY__NODES);
			childrenFeatures.add(GraalPackage.Literals.ACTIVITY__TRANSITIONS);
			childrenFeatures.add(GraalPackage.Literals.ACTIVITY__SUB_ACTIVITIES);
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
	 * This returns Activity.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Activity"));
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
		String label = ((Activity)object).getTechnicalid();
		return label == null || label.length() == 0 ?
			getString("_UI_Activity_type") :
			getString("_UI_Activity_type") + " " + label;
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

		switch (notification.getFeatureID(Activity.class)) {
			case GraalPackage.ACTIVITY__NODES:
			case GraalPackage.ACTIVITY__TRANSITIONS:
			case GraalPackage.ACTIVITY__SUB_ACTIVITIES:
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
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createOperator()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createTaskReference()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createUserView()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createUserAction()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createAppliEvent()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createAppliAction()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createInitialNode()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createFinalNode()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__NODES,
				 GraalFactory.eINSTANCE.createAbortNode()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__TRANSITIONS,
				 GraalFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(GraalPackage.Literals.ACTIVITY__SUB_ACTIVITIES,
				 GraalFactory.eINSTANCE.createLoop()));
	}

}
