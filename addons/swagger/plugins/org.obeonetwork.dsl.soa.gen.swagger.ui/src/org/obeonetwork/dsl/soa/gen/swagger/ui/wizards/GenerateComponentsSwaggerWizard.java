/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter.MapperType;
import org.obeonetwork.dsl.soa.gen.swagger.ui.handlers.Messages;
import org.obeonetwork.dsl.soa.gen.swagger.utils.ComponentGenUtil;

public class GenerateComponentsSwaggerWizard extends Wizard {

	private List<Component> components;
	
	private GenerateComponentsSwaggerWizardOptionsPage generateComponentsSwaggerWizardOptionsPage;

	public GenerateComponentsSwaggerWizard(List<Component> components) {
		super();
		this.components = components;
		
		setWindowTitle(Messages.GenerateComponentsSwaggerWizard_Title);
		
		generateComponentsSwaggerWizardOptionsPage = new GenerateComponentsSwaggerWizardOptionsPage(this);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(generateComponentsSwaggerWizardOptionsPage);
	}

	@Override
	public boolean canFinish() {
		return !components.isEmpty() && generateComponentsSwaggerWizardOptionsPage.isComplete();
	}

	@Override
	public boolean performFinish() {
		boolean exitStatus = true;
		
		MapperType mapperType = generateComponentsSwaggerWizardOptionsPage.getMapperType();
		File outputDir = new File(generateComponentsSwaggerWizardOptionsPage.getOutputDirPath());
		
		int status = IStatus.OK;
		StringBuffer message = new StringBuffer();
		String swaggerVersion = null;
		
		for(Component component : components) {
			SwaggerExporter swaggerExporter = new SwaggerExporter(component);
			swaggerExporter.setOutputFormat(mapperType);
			
			int componentExportStatus = swaggerExporter.exportInDir(outputDir);
			switch(componentExportStatus) {
			case IStatus.OK:
				message.append(String.format(Messages.GenerateComponentsSwaggerWizard_ResultDialog_Success_message, 
						ComponentGenUtil.getName(component), 
						new File(outputDir, swaggerExporter.getOutputFileName()).getPath()));
				break;
			case IStatus.WARNING:
				message.append(String.format(Messages.GenerateComponentsSwaggerWizard_ResultDialog_Warning_message, 
						ComponentGenUtil.getName(component), 
						new File(outputDir, swaggerExporter.getOutputFileName()).getPath()));
				if(status != IStatus.ERROR) {
					status = IStatus.WARNING;
				}
				break;
			case IStatus.ERROR:
				status = IStatus.ERROR;
				message.append(String.format(Messages.GenerateComponentsSwaggerWizard_ResultDialog_Failure_message, 
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
			message.append(String.format(Messages.GenerateComponentsSwaggerWizard_ResultDialog_Swagger_version, swaggerVersion));
			message.append("\n"); //$NON-NLS-1$
		}
		
		switch (status) {
		case IStatus.OK:
			MessageDialog.openInformation(getShell(), Messages.GenerateComponentsSwaggerWizard_ResultDialog_Title, message.toString());
			break;
		case IStatus.WARNING:
			message.append(Messages.GenerateComponentsSwaggerWizard_ResultDialog_see_log_message);
			MessageDialog.openWarning(getShell(), Messages.GenerateComponentsSwaggerWizard_ResultDialog_Title, message.toString());
			break;
		case IStatus.ERROR:
			message.append(Messages.GenerateComponentsSwaggerWizard_ResultDialog_see_log_message);
			MessageDialog.openError(getShell(), Messages.GenerateComponentsSwaggerWizard_ResultDialog_Title, message.toString());
			break;
		}
		
		return exitStatus;
	}

}
