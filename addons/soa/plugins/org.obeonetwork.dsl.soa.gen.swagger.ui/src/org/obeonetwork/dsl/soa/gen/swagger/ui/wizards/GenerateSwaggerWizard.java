package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import java.io.File;
import java.io.IOException;

import org.eclipse.jface.wizard.Wizard;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerGenerator;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerGenerator.MapperType;

public class GenerateSwaggerWizard extends Wizard {

	private System system;
	
	private GenerateSwaggerWizardOptionsPage generateSwaggerWizardOptionsPage;

	public GenerateSwaggerWizard(System system) {
		super();
		this.system = system;
		String systemName = (system.getName() == null || system.getName().isEmpty())? "<Unnamed>" : system.getName();
		setWindowTitle("Export Swagger du Systeme " + systemName);
		generateSwaggerWizardOptionsPage = new GenerateSwaggerWizardOptionsPage(this);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(generateSwaggerWizardOptionsPage);
	}

	@Override
	public boolean canFinish() {
		return generateSwaggerWizardOptionsPage.checkStatus();
	}

	@Override
	public boolean performFinish() {
		boolean exitStatus = true;
		
		try {
			MapperType mapperType = generateSwaggerWizardOptionsPage.getMapperType();
			File outputDir = new File(generateSwaggerWizardOptionsPage.getOutputDirPath());
			
			SwaggerGenerator.generateInDir(system, mapperType, outputDir);
		} catch (IOException e) {
			exitStatus = false;
		}
		
		return exitStatus;
	}

}
