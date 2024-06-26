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
package org.obeonetwork.dsl.database.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.database.Column} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ColumnItemProvider
	extends NamedElementItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2024 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnItemProvider(AdapterFactory adapterFactory) {
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

			addNullablePropertyDescriptor(object);
			addDefaultValuePropertyDescriptor(object);
			addIndexesPropertyDescriptor(object);
			addIndexElementsPropertyDescriptor(object);
			addPrimaryKeyPropertyDescriptor(object);
			addForeignKeysPropertyDescriptor(object);
			addForeignKeyElementsPropertyDescriptor(object);
			addSequencePropertyDescriptor(object);
			addAutoincrementPropertyDescriptor(object);
			addInPrimaryKeyPropertyDescriptor(object);
			addInForeignKeyPropertyDescriptor(object);
			addUniquePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Nullable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNullablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_nullable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_nullable_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__NULLABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_defaultValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_defaultValue_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__DEFAULT_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Indexes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_indexes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_indexes_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__INDEXES,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Index Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_indexElements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_indexElements_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__INDEX_ELEMENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_primaryKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_primaryKey_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__PRIMARY_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Foreign Keys feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForeignKeysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_foreignKeys_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_foreignKeys_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__FOREIGN_KEYS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Foreign Key Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForeignKeyElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_foreignKeyElements_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_foreignKeyElements_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__FOREIGN_KEY_ELEMENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_sequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_sequence_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null) {
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					// The proposed sequences are those contained by the column's containing schema or database
					if (object instanceof Column) {
						Column column = (Column)object;
						Table table = column.getOwner();
						if (table != null) {
							TableContainer tableContainer = table.getOwner();
							if (tableContainer != null) {
								ArrayList<Sequence> sequences = new ArrayList<Sequence>(tableContainer.getSequences());
								Collections.sort(sequences, new Comparator<Sequence>() {

									public int compare(Sequence s1, Sequence s2) {
										if (s2 == null || s2.getName() == null) {
											return -1;
										} else if (s1 == null || s1.getName() == null) {
											return 1;
										} else {
											return s1.getName().compareTo(s2.getName());
										}
									}
									
								});
								return sequences;
							}
						}
					}
					return super.getChoiceOfValues(object);
				}
			});
	}

	/**
	 * This adds a property descriptor for the Autoincrement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAutoincrementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_autoincrement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_autoincrement_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__AUTOINCREMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the In Primary Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInPrimaryKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_inPrimaryKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_inPrimaryKey_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__IN_PRIMARY_KEY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the In Foreign Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInForeignKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_inForeignKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_inForeignKey_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__IN_FOREIGN_KEY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unique feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUniquePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Column_unique_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Column_unique_feature", "_UI_Column_type"),
				 DatabasePackage.Literals.COLUMN__UNIQUE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(DatabasePackage.Literals.COLUMN__TYPE);
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
	 * This returns Column.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		String imagePath = "full/obj16/Column";
		Column column = (Column)object;
		if (column.isInPrimaryKey() == true) {
			if (column.isInForeignKey() == false) {
				// Only PK
				imagePath = "full/obj16/ColumnAndPrimaryKey";
			} else {
				// PK and FK
				imagePath = "full/obj16/ColumnAndPrimaryAndForeignKey";
			}
		} else {
			if (column.isInForeignKey() == false) {
				// No PK, no FK
				imagePath = "full/obj16/Column";
			} else {
				// Only FK
				imagePath = "full/obj16/ColumnAndForeignKey";
			}
		}
		return overlayImage(object, getResourceLocator().getImage(imagePath));
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
		String label = "";
		Column column = (Column)object;
		label += column.getName();
		if (label == null || label.length() == 0) {
			label = "#NONAME#";
		}
		
		String typeLabel = "";
		if (column.getType() != null) {
			AdapterFactoryLabelProvider aflp = new AdapterFactoryLabelProvider(new TypesLibraryItemProviderAdapterFactory());
			typeLabel = aflp.getText(column.getType());
		}
		if (typeLabel != null && typeLabel.length() != 0) {
			label += " : " + typeLabel;
		}
		
		return label;
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

		switch (notification.getFeatureID(Column.class)) {
			case DatabasePackage.COLUMN__NULLABLE:
			case DatabasePackage.COLUMN__DEFAULT_VALUE:
			case DatabasePackage.COLUMN__AUTOINCREMENT:
			case DatabasePackage.COLUMN__IN_PRIMARY_KEY:
			case DatabasePackage.COLUMN__IN_FOREIGN_KEY:
			case DatabasePackage.COLUMN__UNIQUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DatabasePackage.COLUMN__TYPE:
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
				(DatabasePackage.Literals.COLUMN__TYPE,
				 TypesLibraryFactory.eINSTANCE.createTypeInstance()));

		newChildDescriptors.add
			(createChildParameter
				(DatabasePackage.Literals.COLUMN__TYPE,
				 TypesLibraryFactory.eINSTANCE.createUserDefinedTypeRef()));
	}

}
