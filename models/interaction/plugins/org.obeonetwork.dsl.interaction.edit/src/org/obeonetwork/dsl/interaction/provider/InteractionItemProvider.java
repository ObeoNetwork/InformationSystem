/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.interaction.provider;


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

import org.obeonetwork.dsl.interaction.Interaction;
import org.obeonetwork.dsl.interaction.InteractionFactory;
import org.obeonetwork.dsl.interaction.InteractionPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.interaction.Interaction} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractionItemProvider
	extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__PARTICIPANTS);
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__MESSAGES);
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__EXECUTIONS);
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__STATE_INVARIANTS);
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__INTERACTION_USES);
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__ENDS);
			childrenFeatures.add(InteractionPackage.Literals.INTERACTION__COMBINED_FRAGMENTS);
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
	 * This returns Interaction.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Interaction"));
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
		String label = ((Interaction)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Interaction_type") :
			getString("_UI_Interaction_type") + " " + label;
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

		switch (notification.getFeatureID(Interaction.class)) {
			case InteractionPackage.INTERACTION__PARTICIPANTS:
			case InteractionPackage.INTERACTION__MESSAGES:
			case InteractionPackage.INTERACTION__EXECUTIONS:
			case InteractionPackage.INTERACTION__STATE_INVARIANTS:
			case InteractionPackage.INTERACTION__INTERACTION_USES:
			case InteractionPackage.INTERACTION__ENDS:
			case InteractionPackage.INTERACTION__COMBINED_FRAGMENTS:
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
				(InteractionPackage.Literals.INTERACTION__PARTICIPANTS,
				 InteractionFactory.eINSTANCE.createParticipant()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__MESSAGES,
				 InteractionFactory.eINSTANCE.createCreateParticipantMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__MESSAGES,
				 InteractionFactory.eINSTANCE.createDestroyParticipantMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__MESSAGES,
				 InteractionFactory.eINSTANCE.createReturnMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__MESSAGES,
				 InteractionFactory.eINSTANCE.createCallMessage()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__EXECUTIONS,
				 InteractionFactory.eINSTANCE.createExecution()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__STATE_INVARIANTS,
				 InteractionFactory.eINSTANCE.createStateInvariant()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__INTERACTION_USES,
				 InteractionFactory.eINSTANCE.createInteractionUse()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__ENDS,
				 InteractionFactory.eINSTANCE.createEnd()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__ENDS,
				 InteractionFactory.eINSTANCE.createCompoundEnd()));

		newChildDescriptors.add
			(createChildParameter
				(InteractionPackage.Literals.INTERACTION__COMBINED_FRAGMENTS,
				 InteractionFactory.eINSTANCE.createCombinedFragment()));
	}

}
