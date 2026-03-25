/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.ui.actions;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.jface.resource.ImageDescriptor;
import org.obeonetwork.database.ui.Activator;

/**
 * Action made available when comparing two database models to generate the SQL
 * scripts to corresponding to the EMFCompare comparison.
 * 
 */
public class ExportAsSQLScriptsAction extends AbstractExportAsAction {

	private static final String ACTION_TEXT = "Generate SQL";

	@Override
	protected IStatus doGenerateScripts(Comparison comparison, File targetFolder, boolean createSchemaIfNoneExist) throws IOException {
		DatabaseGenGeneratorEclipse databaseGen = new DatabaseGenGeneratorEclipse(comparison, targetFolder.getAbsolutePath());
		databaseGen.generate(new BasicMonitor());
		return Status.OK_STATUS;
	}		

	@Override
	public String getText() {
		return ACTION_TEXT;
	}

	@Override
	public String getToolTipText() {
		return ACTION_TEXT;
	}

	@Override
	protected String getMainFolderName() {
		return "sql";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.createFromImage(Activator.getDefault().getImageRegistry().get(Activator.SQL_FILE_IMAGE));
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		return ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(Activator.SQL_FILE_DISABLED_IMAGE));
	}

	@Override
	protected String getSuccessInformationAddendum() {
		return "";
	}

	public int getSchemaCreationRequired(boolean isOracleDatabase) {
		return 0;
	}

}
