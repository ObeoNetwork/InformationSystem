/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.imp;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.obeonetwork.dsl.manifest.MManifest;

/**
 * Model class used to handle data for import library into modeling project wizard
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ImportLibraryIntoProjectWizardModel {
	
	private List<ModelingProject> modelingProjects = new ArrayList<>();
	private String filepath;
	private ModelingProject modelingProject;
	private MManifest importedProject;
	private List<MManifest> dependencies = new ArrayList<>();
	private List<MManifest> existingDependencies = new ArrayList<>();
	private List<DependencyRow> existingDependenciesRows = new ArrayList<>();
	private boolean validMarFile;
	
	public List<ModelingProject> getModelingProjects() {
		return modelingProjects;
	}

	public void setModelingProjects(List<ModelingProject> modelingProjects) {
		this.modelingProjects = modelingProjects;
	}

	public String getFilepath() {
		return filepath;
	}
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public ModelingProject getModelingProject() {
		return modelingProject;
	}
	
	public void setModelingProject(ModelingProject modelingProject) {
		this.modelingProject = modelingProject;
	}
	
	public MManifest getImportedProject() {
		return importedProject;
	}

	public void setImportedProject(MManifest importedProject) {
		this.importedProject = importedProject;
	}

	public List<MManifest> getDependencies() {
		return dependencies;
	}
	
	public void setDependencies(List<MManifest> dependencies) {
		this.dependencies = dependencies;
	}
	
	public List<MManifest> getExistingDependencies() {
		return existingDependencies;
	}

	public void setExistingDependencies(List<MManifest> existingDependencies) {
		this.existingDependencies = existingDependencies;
	}
	
	public List<DependencyRow> getExistingDependenciesRows() {
		return existingDependenciesRows;
	}

	public void setExistingDependenciesRows(List<DependencyRow> existingDependenciesRows) {
		this.existingDependenciesRows = existingDependenciesRows;
	}

	public boolean isValidMarFile() {
		return validMarFile;
	}

	public void setValidMarFile(boolean validMarFile) {
		this.validMarFile = validMarFile;
	}

	
	public static class DependencyRow {
		private String id;
		private String version;
		private String existingVersion;
		private boolean main;

		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getVersion() {
			return version;
		}
		
		public void setVersion(String version) {
			this.version = version;
		}
		
		public String getExistingVersion() {
			return existingVersion;
		}

		public void setExistingVersion(String existingVersion) {
			this.existingVersion = existingVersion;
		}

		public boolean isMain() {
			return main;
		}

		public void setMain(boolean main) {
			this.main = main;
		}
	}
}
