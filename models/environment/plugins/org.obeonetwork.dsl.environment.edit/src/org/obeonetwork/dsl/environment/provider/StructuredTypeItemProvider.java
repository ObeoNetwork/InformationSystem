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
package org.obeonetwork.dsl.environment.provider;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * This is the item provider adapter for a
 * {@link org.obeonetwork.dsl.environment.StructuredType} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class StructuredTypeItemProvider extends TypeItemProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StructuredTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSupertypePropertyDescriptor(object);
			addAssociatedTypesPropertyDescriptor(object);
			addAttributesPropertyDescriptor(object);
			addReferencesPropertyDescriptor(object);
			addPropertiesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Supertype feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT avoid cyclic inheritance.
	 */
	protected void addSupertypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_StructuredType_supertype_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_StructuredType_supertype_feature",
								"_UI_StructuredType_type"),
						EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPE, true, false, true, null, null, null) {
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						final Collection<?> result = super.getChoiceOfValues(object);
						if (object instanceof StructuredType) {
							final StructuredType structuredType = (StructuredType) object;
							final Iterator<?> iterResult = result.iterator();
							while (iterResult.hasNext()) {
								final Object current = iterResult.next();
								if (current instanceof StructuredType
										&& ((StructuredType) current).isSubtypeOf(structuredType)) {
									iterResult.remove();
								}
							}
						}
						return result;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Associated Types feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAssociatedTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_StructuredType_associatedTypes_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_StructuredType_associatedTypes_feature",
						"_UI_StructuredType_type"),
				EnvironmentPackage.Literals.STRUCTURED_TYPE__ASSOCIATED_TYPES, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Attributes feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_StructuredType_attributes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_StructuredType_attributes_feature",
								"_UI_StructuredType_type"),
						EnvironmentPackage.Literals.STRUCTURED_TYPE__ATTRIBUTES, false, false, false, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the References feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_StructuredType_references_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_StructuredType_references_feature",
								"_UI_StructuredType_type"),
						EnvironmentPackage.Literals.STRUCTURED_TYPE__REFERENCES, false, false, false, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Properties feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPropertiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_StructuredType_properties_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_StructuredType_properties_feature",
								"_UI_StructuredType_type"),
						EnvironmentPackage.Literals.STRUCTURED_TYPE__PROPERTIES, false, false, false, null, null,
						null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_ATTRIBUTES);
			childrenFeatures.add(EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_REFERENCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StructuredType) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_StructuredType_type")
				: getString("_UI_StructuredType_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StructuredType.class)) {
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_ATTRIBUTES:
		case EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_ATTRIBUTES,
				EnvironmentFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add(createChildParameter(EnvironmentPackage.Literals.STRUCTURED_TYPE__OWNED_REFERENCES,
				EnvironmentFactory.eINSTANCE.createReference()));
	}

}
