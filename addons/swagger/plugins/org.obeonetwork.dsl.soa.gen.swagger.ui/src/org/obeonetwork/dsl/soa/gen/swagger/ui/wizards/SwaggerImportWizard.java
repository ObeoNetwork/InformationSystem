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
package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerImporter;
import org.obeonetwork.utils.common.EObjectUtils;
import org.obeonetwork.utils.common.SessionUtils;
import org.obeonetwork.utils.common.transaction.RecordingCommandWithResult;

public class SwaggerImportWizard extends Wizard {
	
	private System soaSystem;
	private ModelingProject enclosingModelingProject = null;
	
	private SwaggerImportWizardPage swaggerImportWizardPage;

	public SwaggerImportWizard(System soaSystem) {
		super();
		this.soaSystem = soaSystem;
		
		Session session = new EObjectQuery(soaSystem).getSession();
		enclosingModelingProject = SessionUtils.getModelingProjectFromSession(session);
		
		setWindowTitle(Messages.SwaggerImportWizard_Title);
		
		swaggerImportWizardPage = new SwaggerImportWizardPage(this);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(swaggerImportWizardPage);
	}

	@Override
	public boolean canFinish() {
		return swaggerImportWizardPage.isComplete();
	}

	public String getDefaultInputDirPath() {
		String defaultInputDirPath = null; 
		if(enclosingModelingProject != null) {
			defaultInputDirPath = enclosingModelingProject.getProject().getLocation().toOSString();
		} else {
			defaultInputDirPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		}

		return defaultInputDirPath;
	}

	@Override
	public boolean performFinish() {
		boolean exitStatus = true;
		
		String swaggerFilePath = swaggerImportWizardPage.getSwaggerFilePath();
		String paginationExtension = swaggerImportWizardPage.getPaginationExtension();
		java.lang.System.out.println(swaggerFilePath);
		java.lang.System.out.println(paginationExtension);
		
		Environment environment = EObjectUtils.getAllResources(soaSystem).stream()
		.flatMap(resource -> resource.getContents().stream())
		.filter(Environment.class::isInstance)
		.map(Environment.class::cast)
		.findFirst().orElse(null);
		
		TransactionalEditingDomain ted = new EObjectQuery(soaSystem).getSession().getTransactionalEditingDomain();
		
		RecordingCommandWithResult<Integer> swaggerImportCommand = new RecordingCommandWithResult<Integer>(ted) {

			@Override
			protected Integer doExecuteWithResult() {
				SwaggerImporter swaggerImporter = new SwaggerImporter(soaSystem, environment);
				return swaggerImporter.importFromFile(swaggerFilePath, paginationExtension);
			}
			
		};
		
		ted.getCommandStack().execute(swaggerImportCommand);
		
		int status = swaggerImportCommand.getSingleResult();
		
		if(swaggerImportCommand.getException() != null) {
			logError(Messages.SwaggerImportWizard_Unexpected_error_message, swaggerImportCommand.getException());
			status = IStatus.ERROR;
		}
		
		switch (status) {
		case IStatus.OK:
			MessageDialog.openInformation(getShell(), Messages.SwaggerImportWizard_Title, Messages.SwaggerImportWizard_Success_message);
			break;
		case IStatus.WARNING:
			MessageDialog.openWarning(getShell(), Messages.SwaggerImportWizard_Title, Messages.SwaggerImportWizard_Warning_message);
			break;
		case IStatus.ERROR:
			MessageDialog.openError(getShell(), Messages.SwaggerImportWizard_Title, Messages.SwaggerImportWizard_Failure_message);
			break;
		}
		
		return exitStatus;
	}
	
}
