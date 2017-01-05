/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.StructuredType;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.environment.Attribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeItemProvider extends PropertyItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008-2009 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTypePropertyDescriptor(Object object) {
		// Filter enumerations to keep only those defined in same kind of resource
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Attribute_type_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Attribute_type_feature",
								"_UI_Attribute_type"),
						EnvironmentPackage.Literals.ATTRIBUTE__TYPE, true, false, true, null, null, null) {
					public Collection<?> getChoiceOfValues(Object object) {
						Collection<?> choiceOfValues = super.getChoiceOfValues(object);

						Collection<Object> result = new ArrayList<Object>();
						if (!choiceOfValues.isEmpty()) {
							NamespacesContainer rootContainer = null;
							if (object instanceof Attribute) {
								rootContainer = getRootNamespacesContainer((Attribute) object);
							}

							// Loop on all choices
							for (Object choice : choiceOfValues) {
								if (choice instanceof Enumeration) {
									// We have to ensure objects are in the same kind of resource
									if (rootContainer != null) {
										NamespacesContainer choiceRootContainer = getRootNamespacesContainer(
												(Enumeration) choice);
										if (choiceRootContainer != null
												&& rootContainer.eClass().equals(choiceRootContainer.eClass())) {
											result.add(choice);
										}
									}

								} else {
									result.add(choice);
								}
							}
						}
						return result;
					};
				});
	}

	private NamespacesContainer getRootNamespacesContainer(Enumeration enumeration) {
		EObject eContainer = enumeration.eContainer();
		if (eContainer instanceof NamespacesContainer) {
			return getRootNamespacesContainer((NamespacesContainer) eContainer);
		} else {
			return null;
		}
	}

	private NamespacesContainer getRootNamespacesContainer(Attribute attribute) {
		EObject eContainer = attribute.eContainer();
		if (eContainer instanceof StructuredType) {
			return getRootNamespacesContainer((StructuredType) eContainer);
		} else {
			return null;
		}
	}

	private NamespacesContainer getRootNamespacesContainer(StructuredType structuredType) {
		EObject eContainer = structuredType.eContainer();
		if (eContainer instanceof NamespacesContainer) {
			return getRootNamespacesContainer((NamespacesContainer) eContainer);
		} else {
			return null;
		}
	}

	private NamespacesContainer getRootNamespacesContainer(NamespacesContainer container) {
		EObject eContainer = container.eContainer();
		if (eContainer instanceof NamespacesContainer) {
			return getRootNamespacesContainer((NamespacesContainer) eContainer);
		} else {
			return container;
		}
	}

	/**
	 * This returns Attribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Attribute"));
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
		String label = ((Attribute) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Attribute_type")
				: getString("_UI_Attribute_type") + " " + label;
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
