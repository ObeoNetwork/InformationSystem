/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.jface.resource.ImageDescriptor;
import org.obeonetwork.dsl.database.liquibasegen.LiquibaseGenerator;

import fr.gouv.mindef.safran.database.ui.Activator;

/**
 * Action made available when comparing two database models to generate the Liquibase changelog file corresponding to the EMFCompare comparison.
 * 
 */
public class ExportAsLiquibaseScriptsAction extends AbstractExportAsAction{

	
	private static final String ACTION_TEXT = "Generate Liquibase changelog";

	@Override
	protected IStatus doGenerateScripts(Comparison comparison, File targetFolder) throws IOException {
		LiquibaseGenerator gen = new LiquibaseGenerator();
		return gen.doGenerate(new BasicMonitor(),comparison,targetFolder.toPath());
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



}
