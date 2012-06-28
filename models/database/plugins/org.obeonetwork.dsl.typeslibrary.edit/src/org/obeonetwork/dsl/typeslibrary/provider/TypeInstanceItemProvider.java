/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.typeslibrary.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.typeslibrary.TypeInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TypeInstanceItemProvider
	extends TypeItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeInstanceItemProvider(AdapterFactory adapterFactory) {
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

			addNativeTypePropertyDescriptor(object);
			addLengthPropertyDescriptor(object);
			addPrecisionPropertyDescriptor(object);
			addLiteralsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Native Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNativeTypePropertyDescriptor(Object object) {
		final Collection<NativeTypesLibrary> nativeTypesLibraries = new ArrayList<NativeTypesLibrary>();
		if (object instanceof EObject) {
			EObject eObject = (EObject)object;
			final TypesLibraryUser user = getTypesLibraryUserFromParents(eObject);
			if (user != null && user.getUsedLibraries().isEmpty() == false) {
				for (TypesLibrary library : user.getUsedLibraries()) {
					if (library instanceof NativeTypesLibrary) {
						nativeTypesLibraries.add((NativeTypesLibrary)library);
					}
				}
			}
		}
		// There is no restriction on choices, let's use an unmodified PropertyDescriptor
		if (nativeTypesLibraries.isEmpty() == false) {
			itemPropertyDescriptors.add
				(new ItemPropertyDescriptor
					(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
					 getResourceLocator(),
					 getString("_UI_TypeInstance_nativeType_feature"),
					 getString("_UI_PropertyDescriptor_description", "_UI_TypeInstance_nativeType_feature", "_UI_TypeInstance_type"),
					 TypesLibraryPackage.Literals.TYPE_INSTANCE__NATIVE_TYPE,
					 true,
					 false,
					 true,
					 null,
					 null,
					 null) {
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						// We propose the types referenced by the used libraries
						Collection<NativeType> suggestedTypes = new ArrayList<NativeType>();
						
						for (NativeTypesLibrary nativeTypesLibrary : nativeTypesLibraries) {
							suggestedTypes.addAll(nativeTypesLibrary.getNativeTypes());
						}
						return suggestedTypes;
				}
			});
		} else {
			itemPropertyDescriptors.add
				(createItemPropertyDescriptor
					(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
					 getResourceLocator(),
					 getString("_UI_TypeInstance_nativeType_feature"),
					 getString("_UI_PropertyDescriptor_description", "_UI_TypeInstance_nativeType_feature", "_UI_TypeInstance_type"),
					 TypesLibraryPackage.Literals.TYPE_INSTANCE__NATIVE_TYPE,
					 true,
					 false,
					 true,
					 null,
					 null,
					 null));
		}
	}
	
	/**
	 * @generated NOT
	 */
	private TypesLibraryUser getTypesLibraryUserFromParents(EObject object) {
		if (object.eContainer() != null) {
			if (object.eContainer() instanceof TypesLibraryUser) {
				return (TypesLibraryUser)object.eContainer();
			} else {
				return getTypesLibraryUserFromParents(object.eContainer());
			}
		}
		return null;
	}

	/**
	 * This adds a property descriptor for the Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TypeInstance_length_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TypeInstance_length_feature", "_UI_TypeInstance_type"),
				 TypesLibraryPackage.Literals.TYPE_INSTANCE__LENGTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrecisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TypeInstance_precision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TypeInstance_precision_feature", "_UI_TypeInstance_type"),
				 TypesLibraryPackage.Literals.TYPE_INSTANCE__PRECISION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Literals feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLiteralsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TypeInstance_literals_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TypeInstance_literals_feature", "_UI_TypeInstance_type"),
				 TypesLibraryPackage.Literals.TYPE_INSTANCE__LITERALS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns TypeInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TypeInstance"));
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
		TypeInstance typeInstance = (TypeInstance)object;
		NativeType nativeType = typeInstance.getNativeType();
		String label = null;
		if (nativeType != null) {
			label = nativeType.getName();
			if (label == null || label.length() == 0) {
				label = "<undefined>";
			}
			switch(nativeType.getSpec()) {
			case LENGTH :
				if (!label.contains("%n")) {
					label = label + "(%n)";
				}
				label = replacePlaceholders(label,
						new String[]{"%n"},
						new String[]{String.valueOf(typeInstance.getLength())});
				break;
			case LENGTH_AND_PRECISION :
				if (!label.contains("%n") && !label.contains("%p")) {
					label = label + "(%n, %p)";
				} else if (!label.contains("%n")) {
					label = label + "(%n)";
				} else if (!label.contains("%p")) {
					label = label + "(%p)";
				}
				label = replacePlaceholders(label,
						new String[]{"%n", "%p"},
						new String[]{String.valueOf(typeInstance.getLength()), String.valueOf(typeInstance.getPrecision())});
				break;
			case ENUM :
				label += "(";
				for (int i = 0; i < typeInstance.getLiterals().size(); i++) {
					String literal = typeInstance.getLiterals().get(i);
					if (i != 0) {
						label += ", ";
					}
					label += literal;
				}
				label += ")";
				break;
			}
		} else {
			label = "<undefined>";
		}
		
		return label;
	}
	
	private String replacePlaceholders(String target, String[] placeholders, String[] values) {
		String result = target;
		for(int i = 0; i < placeholders.length; i++) {
			String placeholder = placeholders[i];
			String value = values[i];
			int pos = result.indexOf(placeholder);
			if (pos != -1) {
				result = result.substring(0, pos) + value + result.substring(pos + placeholder.length());
			}
		}
		return result;
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

		switch (notification.getFeatureID(TypeInstance.class)) {
			case TypesLibraryPackage.TYPE_INSTANCE__LENGTH:
			case TypesLibraryPackage.TYPE_INSTANCE__PRECISION:
			case TypesLibraryPackage.TYPE_INSTANCE__LITERALS:
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
