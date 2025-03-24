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
package org.obeonetwork.dsl.soa.design.dialogs;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.soa.design.dialogs.messages"; //$NON-NLS-1$
	public static String Flow_Description_Value;
	public static String Flow_Name_Value;
	public static String FlowDialog_AuthorizationURL_Label;
	public static String FlowDialog_Description_Label;
	public static String FlowDialog_Name_Label;
	public static String FlowDialog_RefreshURL_Label;
	public static String FlowDialog_Scopes_Label;
	public static String FlowDialog_Title_Label;
	public static String FlowDialog_TokenURL_Label;
	public static String SecuritySchemeDialog_AddButton_Icon;
	public static String SecuritySchemeDialog_ApiKeyLocation_Label;
	public static String SecuritySchemeDialog_CancelButton_Label;
	public static String SecuritySchemeDialog_ConnectURL_Label;
	public static String SecuritySchemeDialog_DeleteButton_Icon;
	public static String SecuritySchemeDialog_Description_Label;
	public static String SecuritySchemeDialog_Flows_Label;
	public static String SecuritySchemeDialog_Format_Label;
	public static String SecuritySchemeDialog_HttpScheme_Label;
	public static String SecuritySchemeDialog_Name_Label;
	public static String SecuritySchemeDialog_OKButton_Label;
	public static String SecuritySchemeDialog_Title_Label;
	public static String SecuritySchemeDialog_Type_Label;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
