/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.internal.ide.filesystem.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.junit.Test;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.tools.projectlibrary.ui.wizard.exp.ExportProjectAsLibraryRunnable;
import org.obeonetwork.tools.projectlibrary.ui.wizard.exp.ExportProjectAsLibraryWizardModel;
import org.obeonetwork.tools.projectlibrary.util.ProjectLibraryUtils;

/**
 * Test to check that the export of a project 'as libraries' is updating referencing project.
 * 
 * @author fcoulon
 *
 */
public class ExportProjectTest {
	
	@Test
	public void exportProjectTest() throws InvocationTargetException, InterruptedException, LibraryImportException, CoreException {
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		
		// Import the two test projects
		importJavaProject("resources/ProjectDependency", "./ProjectDependency");
		importJavaProject("resources/org.obeonetwork.is.sample.ebookstore", "./org.obeonetwork.is.sample.ebookstore");
		
		
		// Run the export command
		IProject exportedProject = workspaceRoot.getProject("ProjectDependency");
		ModelingProject exportedModelingProject = ModelingProject.asModelingProject(exportedProject).get();
		ProjectLibraryUtils util = new ProjectLibraryUtils();
		Set<ModelingProject> referencingModelingProjects = util.getReferencingProjects(exportedModelingProject);
		ExportProjectAsLibraryWizardModel model = new ExportProjectAsLibraryWizardModel();
		model.setProjectId("ProjectDependency");
		model.setVersion("1.0.0");
		model.setComment("");
		model.setMarFileName("ProjectDependency-1.0.0.mar");
		model.setExportDirectory(".");
		model.setSelectedModelingProject(exportedModelingProject);
		model.setReferencingModelingProjects(referencingModelingProjects);
	    Display display = Display.getDefault();
	    Shell shell = display.getActiveShell();
	    
		ExportProjectAsLibraryRunnable exportCommand = new ExportProjectAsLibraryRunnable(model, referencingModelingProjects, shell);
		exportCommand.run(new NullProgressMonitor());

		
		// Check Referencing Modeling Projects
		assertEquals(1, referencingModelingProjects.size());
		ModelingProject referencingModelingProject = referencingModelingProjects.iterator().next();
		assertEquals("org.obeonetwork.is.sample.ebookstore", referencingModelingProject.getProject().getName());
		
		
		// Check libraries/ content
		IFolder libFolder = referencingModelingProject.getProject().getFolder(new Path("libraries/ProjectDependency-1.0.0/"));
		IFile stateMachineFile = referencingModelingProject.getProject().getFile(new Path("libraries/ProjectDependency-1.0.0/MyStatemachine.statemachine"));
		IFile soaFile = referencingModelingProject.getProject().getFile(new Path("libraries/ProjectDependency-1.0.0/My.soa"));
		IFile airdFile = referencingModelingProject.getProject().getFile(new Path("libraries/ProjectDependency-1.0.0/representations.aird"));
		assertTrue(libFolder.exists());
		assertTrue(stateMachineFile.exists());
		assertTrue(soaFile.exists());
		assertTrue(airdFile.exists());
		
		
		// Check semantic resources
		boolean hasSemanticResourceFsm = false;
		boolean hasSemanticResourceSoa = false;
		for(Resource resource : referencingModelingProject.getSession().getSemanticResources()) {
			if(resource.getURI().toString().equals("platform:/resource/org.obeonetwork.is.sample.ebookstore/libraries/ProjectDependency-1.0.0/MyStatemachine.statemachine")) {
				hasSemanticResourceFsm = true;
			}
			else if(resource.getURI().toString().equals("platform:/resource/org.obeonetwork.is.sample.ebookstore/libraries/ProjectDependency-1.0.0/My.soa")) {
				hasSemanticResourceSoa = true;
			}
		}
		assertTrue(hasSemanticResourceFsm);
		assertTrue(hasSemanticResourceSoa);
		
		
		// Check cross-references update
		IFile updatedAirdFile = referencingModelingProject.getProject().getFile(new Path("representations.aird"));
		InputStream inputStream = updatedAirdFile.getContents();
		String fileContent = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
		Pattern patternFsm = Pattern.compile("libraries/ProjectDependency-1.0.0/MyStatemachine\\.statemachine#");
		Matcher matcherFsm = patternFsm.matcher(fileContent);
		Pattern patternSoa = Pattern.compile("libraries/ProjectDependency-1.0.0/My\\.soa#");
		Matcher matcherSoa = patternSoa.matcher(fileContent);
		int fsmMatches = 0;
	    while (matcherFsm.find()) {
	    	fsmMatches++;
	    }
	    int soaMatches = 0;
	    while (matcherSoa.find()) {
	    	soaMatches++;
	    }
		assertEquals(12,fsmMatches);
		assertEquals(2,soaMatches);
	}

	private void importJavaProject(String importedProjectPath, String createdProjectPath) throws InvocationTargetException, InterruptedException {
		Path path = new Path(createdProjectPath);
		ImportOperation importOperation = new ImportOperation(path,
		        new File(importedProjectPath), new FileSystemStructureProvider(), new IOverwriteQuery() {
					@Override
					public String queryOverwrite(String pathString) {
						return IOverwriteQuery.ALL;
					}
		});
		importOperation.setCreateContainerStructure(false);
		importOperation.run(new NullProgressMonitor());
	}

}
