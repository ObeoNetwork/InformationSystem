/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.parts.impl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.swt.SWT;
import org.obeonetwork.dsl.database.components.PrimaryKeyPropertiesEditionComponent;
import org.obeonetwork.dsl.database.components.TablePrimaryKeyPropertiesEditionComponent;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.providers.DatabaseMessages;

/**
 * Custom PartForm to bypass EEF Bug #404780
 * @author Stephane Thibaudeau <stephane.thibaudeau@obeo.fr>
 */
public class CustomPrimaryKeyPropertiesEditionPartImpl extends
		PrimaryKeyPropertiesEditionPartImpl {

	public CustomPrimaryKeyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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

	
}
