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
package org.obeonetwork.dsl.database.parts.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.components.PrimaryKeyPropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TablePrimaryKeyPropertiesEditionComponent;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.providers.DatabaseMessages;


/**
 * Custom PartForm to bypass EEF Bug #404780
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 */
public class CustomPrimaryKeyPropertiesEditionPartForm extends PrimaryKeyPropertiesEditionPartForm {

	public CustomPrimaryKeyPropertiesEditionPartForm() {
		super();
	}

	public CustomPrimaryKeyPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	@Override
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		
		// STH : fix to handle multi PEC for a single Part
		boolean eefElementEditorReadOnlyState = true;
		if (propertiesEditionComponent instanceof TablePrimaryKeyPropertiesEditionComponent) {
			eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.PrimaryKey.Properties.name, ((TablePrimaryKeyPropertiesEditionComponent) propertiesEditionComponent).getPkNameSettings().getOrCreateSignificantObject());			
		} else if (propertiesEditionComponent instanceof PrimaryKeyPropertiesEditionComponent) {
			eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.PrimaryKey.Properties.name);			
		}
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(DatabaseMessages.PrimaryKey_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}
	}

	@Override
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
		// STH : fix to handle multi PEC for a single Part
		boolean eefElementEditorReadOnlyState = true;
		if (propertiesEditionComponent instanceof TablePrimaryKeyPropertiesEditionComponent) {
			eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.PrimaryKey.Properties.comments, ((TablePrimaryKeyPropertiesEditionComponent) propertiesEditionComponent).getPkCommentsSettings().getOrCreateSignificantObject());			
		} else if (propertiesEditionComponent instanceof PrimaryKeyPropertiesEditionComponent) {
			eefElementEditorReadOnlyState = isReadOnly(DatabaseViewsRepository.PrimaryKey.Properties.comments);			
		}
		if (eefElementEditorReadOnlyState && comments.isEnabled()) {
			comments.setEnabled(false);
			comments.setBackground(comments.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			comments.setToolTipText(DatabaseMessages.PrimaryKey_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !comments.isEnabled()) {
			comments.setEnabled(true);
		}
	}
	
	/**
	 * Overriden to fix bug SAFRAN-725
	 */
	@Override
	protected void addColumns() {
		// Retrieve all columns in table's owner
		if (current instanceof Table) {
			final Collection<Column> pkTableColumns = new ArrayList<Column>(((Table) current).getColumns());
			EEFEditorSettings input = new DelegatedEEFEditorSettings((EEFEditorSettings)columns.getInput()) {
				@Override
				public Object choiceOfValues(AdapterFactory adapterFactory) {
					return pkTableColumns;
				}
			};
			EMFModelViewerDialog dialog = new EMFModelViewerDialog(new AdapterFactoryLabelProvider(adapterFactory), input, columnsFilters, columnsBusinessFilters, false, true) {
				public void process(IStructuredSelection selection) {
					for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
						EObject elem = (EObject) iter.next();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomPrimaryKeyPropertiesEditionPartForm.this, DatabaseViewsRepository.PrimaryKey.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
					}
				}
			};
			dialog.open();
			columns.refresh();
		} else {
			super.addColumns();
		}
	}

}
