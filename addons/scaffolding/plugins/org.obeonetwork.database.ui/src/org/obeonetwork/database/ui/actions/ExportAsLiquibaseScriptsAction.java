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
package org.obeonetwork.database.ui.actions;

import static org.obeonetwork.dsl.database.liquibasegen.Activator.getLiquibaseVersion;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.database.liquibasegen.LiquibaseGenerator;
import org.obeonetwork.dsl.database.liquibasegen.ui.LiquibaseGenerationOptionsDialog;
import org.obeonetwork.database.ui.Activator;

/**
 * Action made available when comparing two database models to generate the Liquibase changelog file corresponding to the EMFCompare comparison.
 * 
 */
public class ExportAsLiquibaseScriptsAction extends AbstractExportAsAction{

	
	private static final String ACTION_TEXT = "Generate Liquibase changelog";
	
	@Override
	protected  IStatus doGenerateScripts(final Comparison comparison, final File targetFolder, boolean createSchemaIfNoneExist) throws IOException {
		LiquibaseGenerator gen = new LiquibaseGenerator();
		return gen.doGenerate(new BasicMonitor(),comparison,targetFolder.toPath(), createSchemaIfNoneExist);
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
		return "liquibase";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor
				.createFromImage(Activator.getDefault().getImageRegistry().get(Activator.LIQUIBASE_FILE_IMAGE));
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		return ImageDescriptor.createFromImage(
				Activator.getDefault().getImageRegistry().get(Activator.LIQUIBASE_FILE_DISABLED_IMAGE));
	}

	@Override
	protected String getSuccessInformationAddendum() {
		return String.format("Liquibase version: %s.", getLiquibaseVersion());
	}


	public int getSchemaCreationRequired(boolean isOracleDatabase) {
		LiquibaseGenerationOptionsDialog genOptionDialog = new LiquibaseGenerationOptionsDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), true, isOracleDatabase);
		genOptionDialog.open();
		if (genOptionDialog.getReturnCode() == Window.OK) {
			if (genOptionDialog.getCreateSchemaIfNotExists()) {
				return 1;
			} else {
				return 0;
			}
		}
		return -1;
	}

}
