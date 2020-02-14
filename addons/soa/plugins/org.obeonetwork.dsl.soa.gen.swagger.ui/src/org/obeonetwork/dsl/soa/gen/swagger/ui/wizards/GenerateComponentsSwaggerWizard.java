package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerGenerator;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerGenerator.MapperType;

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
				SwaggerGenerator.generateInDir(component, mapperType, outputDir);
			}
		} catch (IOException e) {
			exitStatus = false;
		}
		
		return exitStatus;
	}

}
