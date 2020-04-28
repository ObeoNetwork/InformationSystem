/*******************************************************************************
 * Copyright (c) 2016-2017 Obeo.
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
import java.io.IOException;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter.MapperType;

public class GenerateComponentsSwaggerWizard extends Wizard {

	private List<Component> components;
	
	private GenerateComponentsSwaggerWizardOptionsPage generateComponentsSwaggerWizardOptionsPage;

	public GenerateComponentsSwaggerWizard(List<Component> components) {
		super();
		this.components = components;
		
//		String systemName = (system.getName() == null || system.getName().isEmpty())? "<Unnamed>" : system.getName();
		
		setWindowTitle("Export Swagger du Systeme " + "TODO"); // TODO
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
		
		try {
			MapperType mapperType = generateComponentsSwaggerWizardOptionsPage.getMapperType();
			File outputDir = new File(generateComponentsSwaggerWizardOptionsPage.getOutputDirPath());
			
			for(Component component : components) {
				SwaggerExporter.exportInDir(component, mapperType, outputDir);
			}
		} catch (IOException e) {
			exitStatus = false;
		}
		
		return exitStatus;
	}

}
