/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.design.adapters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.design.dialogs.NewSecuritySchemeDialog;

/**
 * {@link SelectionAdapter} for changing the {@link SecuritySchemeType} of a {@link SecuritySchemeType}
 * @author Obeo
 */
public class SecuritySchemeTypeAdapter extends SelectionAdapter {

	private NewSecuritySchemeDialog securitySchemeDialog;
	
	public SecuritySchemeTypeAdapter(NewSecuritySchemeDialog securitySchemeDialog) {
		super();
		this.securitySchemeDialog = securitySchemeDialog;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Combo combo = (Combo) e.widget;
		int selectionIndex = combo.getSelectionIndex();
		String item = combo.getItem(selectionIndex);
		SecuritySchemeType type = SecuritySchemeType.getByName(item);
		securitySchemeDialog.setSecuritySchemeType(type);
		securitySchemeDialog.displayComposite();
	}

}
