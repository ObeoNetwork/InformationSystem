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
package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;
import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ComponentGenUtil;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerExportUtil.MapperType;
import org.obeonetwork.utils.sirius.session.SessionUtils;

public class SwaggerExportWizard extends Wizard {

	private List<Component> components;
	private ModelingProject enclosingModelingProject = null;
	
	private SwaggerExportWizardPage swaggerExportWizardPage;

	public SwaggerExportWizard(List<Component> components) {
		super();
		this.components = components;
		
		if(components != null && !components.isEmpty()) {
			Component firstComponent = components.get(0);
			Session session = new EObjectQuery(firstComponent).getSession();
			enclosingModelingProject = SessionUtils.getModelingProjectFromSession(session);
		}
		
		setWindowTitle(Messages.SwaggerExportWizard_Title);
		
		swaggerExportWizardPage = new SwaggerExportWizardPage(this);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(swaggerExportWizardPage);
	}

	@Override
	public boolean canFinish() {
		return !components.isEmpty() && swaggerExportWizardPage.isComplete();
	}

	public String getDefaultOutputDirPath() {
		String defaultOutputDirPath = null; 
		if(enclosingModelingProject != null) {
			defaultOutputDirPath = enclosingModelingProject.getProject().getLocation().toOSString();
		} else {
			defaultOutputDirPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		}

		return defaultOutputDirPath;
	}

	@Override
	public boolean performFinish() {
		boolean exitStatus = true;
		
		MapperType mapperType = swaggerExportWizardPage.getMapperType();
		File outputDir = new File(swaggerExportWizardPage.getOutputDirPath());
		
		int status = IStatus.OK;
		StringBuffer message = new StringBuffer();
		String swaggerVersion = null;
		
		for(Component component : components) {
			SwaggerExporter swaggerExporter = new SwaggerExporter(component);
			swaggerExporter.setOutputFormat(mapperType);
			
			int componentExportStatus = swaggerExporter.exportInDir(outputDir);
			switch(componentExportStatus) {
			case IStatus.OK:
				message.append(String.format(Messages.SwaggerExportWizard_Success_message, 
						ComponentGenUtil.getName(component), 
						new File(outputDir, swaggerExporter.getOutputFileName()).getPath()));
				break;
			case IStatus.WARNING:
				message.append(String.format(Messages.SwaggerExportWizard_Warning_message, 
						ComponentGenUtil.getName(component), 
						new File(outputDir, swaggerExporter.getOutputFileName()).getPath()));
				if(status != IStatus.ERROR) {
					status = IStatus.WARNING;
				}
				break;
			case IStatus.ERROR:
				status = IStatus.ERROR;
				message.append(String.format(Messages.SwaggerExportWizard_Failure_message, 
						ComponentGenUtil.getName(component), 
						new File(outputDir, swaggerExporter.getOutputFileName()).getPath()));
				break;
			}
			
			if(swaggerExporter.getExportedSwagger() != null 
					&& swaggerExporter.getExportedSwagger().getOpenapi() != null) {
				swaggerVersion = swaggerExporter.getExportedSwagger().getOpenapi();
			}
			
			message.append("\n"); //$NON-NLS-1$
		}
		
		if(swaggerVersion != null) {
			message.append(String.format(Messages.SwaggerExportWizard_Version_message, swaggerVersion));
			message.append("\n"); //$NON-NLS-1$
		}
		
		switch (status) {
		case IStatus.OK:
			MessageDialog.openInformation(getShell(), Messages.SwaggerExportWizard_Title, message.toString());
			break;
		case IStatus.WARNING:
			message.append(Messages.SwaggerExportWizard_See_error_log_message);
			MessageDialog.openWarning(getShell(), Messages.SwaggerExportWizard_Title, message.toString());
			break;
		case IStatus.ERROR:
			message.append(Messages.SwaggerExportWizard_See_error_log_message);
			MessageDialog.openError(getShell(), Messages.SwaggerExportWizard_Title, message.toString());
			break;
		}
		
		if(status != IStatus.ERROR) {
			try {
				enclosingModelingProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// That can't be that critical
			}
		}
		
		return exitStatus;
	}

}
