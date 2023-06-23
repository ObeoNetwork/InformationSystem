/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.database.scaffold.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Namespace;

import org.obeonetwork.database.scaffold.ScaffoldFactory;
import org.obeonetwork.database.scaffold.ScaffoldInfo;
import org.obeonetwork.database.scaffold.ScaffoldPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.database.scaffold.ScaffoldInfo} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaffoldInfoItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaffoldInfoItemProvider(AdapterFactory adapterFactory) {
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

			addLeftObjectPropertyDescriptor(object);
			addRightObjectPropertyDescriptor(object);
			addLeftToRightAdditionalObjectsPropertyDescriptor(object);
			addRightToLeftAdditionalObjectsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Left Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addLeftObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScaffoldInfo_leftObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScaffoldInfo_leftObject_feature", "_UI_ScaffoldInfo_type"),
				 ScaffoldPackage.Literals.SCAFFOLD_INFO__LEFT_OBJECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			{

				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					Collection<?> choiceOfValues = super.getChoiceOfValues(object);
					Collection<Object> result = new ArrayList<Object>();
					for (Object value : choiceOfValues) {
						if (value instanceof Namespace
								|| value instanceof Root
								|| value instanceof TableContainer) {
							result.add(value);
						}
					}
					return result;
				}
				
			});
	}

	/**
	 * This adds a property descriptor for the Right Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRightObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScaffoldInfo_rightObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScaffoldInfo_rightObject_feature", "_UI_ScaffoldInfo_type"),
				 ScaffoldPackage.Literals.SCAFFOLD_INFO__RIGHT_OBJECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			{

				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					Collection<?> choiceOfValues = super.getChoiceOfValues(object);
					Collection<Object> result = new ArrayList<Object>();
					for (Object value : choiceOfValues) {
						if (value instanceof Namespace
								|| value instanceof Root
								|| value instanceof TableContainer) {
							result.add(value);
						}
					}
					return result;
				}
				
			});
	}

	/**
	 * This adds a property descriptor for the Left To Right Additional Objects feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLeftToRightAdditionalObjectsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScaffoldInfo_leftToRightAdditionalObjects_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScaffoldInfo_leftToRightAdditionalObjects_feature", "_UI_ScaffoldInfo_type"),
				 ScaffoldPackage.Literals.SCAFFOLD_INFO__LEFT_TO_RIGHT_ADDITIONAL_OBJECTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Right To Left Additional Objects feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRightToLeftAdditionalObjectsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScaffoldInfo_rightToLeftAdditionalObjects_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScaffoldInfo_rightToLeftAdditionalObjects_feature", "_UI_ScaffoldInfo_type"),
				 ScaffoldPackage.Literals.SCAFFOLD_INFO__RIGHT_TO_LEFT_ADDITIONAL_OBJECTS,
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
			childrenFeatures.add(ScaffoldPackage.Literals.SCAFFOLD_INFO__TRACEABILITY_INFOS);
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
	 * This returns ScaffoldInfo.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ScaffoldInfo"));
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
		ScaffoldInfo info = (ScaffoldInfo)object;
		
		AdapterFactoryLabelProvider lp = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		String left = "<none>";
		if (info.getLeftObject() != null) {
			left = lp.getText(info.getLeftObject());
		}
		String right = "<none>";
		if (info.getRightObject() != null) {
			right = lp.getText(info.getRightObject());
		}
		
		String label = "[" + left + " <-> " + right + "]";
		
		return getString("_UI_ScaffoldInfo_type") + " " + label;
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

		switch (notification.getFeatureID(ScaffoldInfo.class)) {
			case ScaffoldPackage.SCAFFOLD_INFO__TRACEABILITY_INFOS:
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
				(ScaffoldPackage.Literals.SCAFFOLD_INFO__TRACEABILITY_INFOS,
				 ScaffoldFactory.eINSTANCE.createTraceabilityInfo()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ScaffoldEditPlugin.INSTANCE;
	}

}
