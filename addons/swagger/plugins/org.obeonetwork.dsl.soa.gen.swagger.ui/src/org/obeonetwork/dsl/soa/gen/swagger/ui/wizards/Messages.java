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
package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.soa.gen.swagger.ui.wizards.messages"; //$NON-NLS-1$
	public static String SwaggerExportWizard_Failure_message;
	public static String SwaggerExportWizard_See_error_log_message;
	public static String SwaggerExportWizard_Success_message;
	public static String SwaggerExportWizard_Title;
	public static String SwaggerExportWizard_Version_message;
	public static String SwaggerExportWizard_Warning_message;
	public static String SwaggerExportWizardPage_Description;
	public static String SwaggerExportWizardPage_Label_export_directory;
	public static String SwaggerExportWizardPage_Label_Output_format;
	public static String SwaggerImportWizard_Failure_message;
	public static String SwaggerImportWizard_Success_message;
	public static String SwaggerImportWizard_Title;
	public static String SwaggerImportWizard_Unexpected_error_message;
	public static String SwaggerImportWizard_Warning_message;
	
	public static String SwaggerConvertWizard_Title;
	public static String SwaggerConvertWizard_Warning_message;
	public static String SwaggerConvertWizard_Failure_message;
	public static String SwaggerConvertWizard_Success_message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
