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
package org.obeonetwork.dsl.database.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Table;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.database.ForeignKeyElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForeignKeyElementItemProvider
	extends DatabaseElementItemProvider
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
	public ForeignKeyElementItemProvider(AdapterFactory adapterFactory) {
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

			addFkColumnPropertyDescriptor(object);
			addPkColumnPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Fk Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFkColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKeyElement_fkColumn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKeyElement_fkColumn_feature", "_UI_ForeignKeyElement_type"),
				 DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__FK_COLUMN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null) {
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					// Suggested columns are the columns of the same table 
					Collection<Column> suggestedColumns = new ArrayList<Column>();
					ForeignKeyElement fke = (ForeignKeyElement)object;
					if (fke.eContainer() != null) {							
						ForeignKey fk = (ForeignKey)fke.eContainer();
						suggestedColumns.addAll(fk.getSourceTable().getColumns());
					}
					return suggestedColumns;
				}
			});
	}

	/**
	 * This adds a property descriptor for the Pk Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPkColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ForeignKeyElement_pkColumn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ForeignKeyElement_pkColumn_feature", "_UI_ForeignKeyElement_type"),
				 DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__PK_COLUMN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						// Suggested columns are the PK columns of the target table 
						Collection<Column> suggestedColumns = new ArrayList<Column>();
						
						ForeignKeyElement fke = (ForeignKeyElement)object;
						Table targetTable = null;
						if (fke.eContainer() != null) {							
							ForeignKey fk = (ForeignKey)fke.eContainer();
							targetTable = fk.getTargetTable();
							for (Column column : targetTable.getColumns()) {
								if (column.isInPrimaryKey() == true) {
									suggestedColumns.add(column);
								}
							}
						}
						return suggestedColumns;
					}
		});
	}

	/**
	 * This returns ForeignKeyElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForeignKeyElement"));
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
		ForeignKeyElement fkElt = (ForeignKeyElement)object;
		String label = "";
		if (fkElt.getFkColumn() != null) {
			String fkColumnName = fkElt.getFkColumn().getName();
			if (fkColumnName != null && fkColumnName.length() != 0) {
				label = fkColumnName;
			} else {
				label = getString("_UI_Column_name_undefined");
			}
		}
		label += " -> ";
		if (fkElt.getPkColumn() != null) {
			String pkColumnName = fkElt.getPkColumn().getName();
			if (pkColumnName != null && pkColumnName.length() != 0) {
				label += pkColumnName;
			} else {
				label += getString("_UI_Column_name_undefined");
			}
		}
		
		return label == null || label.length() == 0 ?
			getString("_UI_ForeignKeyElement_type") : label;
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
