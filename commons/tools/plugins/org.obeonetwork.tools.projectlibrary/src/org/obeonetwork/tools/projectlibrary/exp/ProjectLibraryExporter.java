/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.exp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.tools.projectlibrary.extension.ManifestServices;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.tools.projectlibrary.util.ZipUtils;

/**
 * Export a modeling project as a zipped library with manifest 
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ProjectLibraryExporter {
	
	private ManifestServices manifestServices = new ManifestServices();

	/**
	 * Export a modeling project as an archive containing a manifest
	 * @param project Modeling project to export
	 * @param projectId ID of project in archive
	 * @param version Version of exported project
	 * @param comment
	 * @param targetFile
	 */
	public void export(ModelingProject project, String projectId, String version, String comment, File targetFile) throws LibraryImportException {
		// 1st step: create a new manifest
		MManifest newManifest = manifestServices.getNewManifest(projectId, version, comment);
		
		// 2nd step : add imported projects
		List<MManifest> importedProjects = manifestServices.getImportedManifests(project.getSession());
		for (MManifest importedProject : importedProjects) {			
			newManifest.getDependencies().add(EcoreUtil.copy(importedProject));
		}
		
		// 3rd step: zip project's contents into target file
		IProject iProject = project.getProject();
		File projectFolder = iProject.getLocation().toFile();
		try {
			FileOutputStream outputStream = new FileOutputStream(targetFile);
			
			// Zip folder contents
			ZipUtils.zipFolder(projectFolder, outputStream);
			
			outputStream.close();
			
			// 4th step: generate add MANIFEST.MF to file
			Manifest marManifest = manifestServices.getMarManifestFromModel(newManifest);
			// And add it to zip
			addMarManifestToArchive(marManifest, targetFile);
			
		} catch (IOException e) {
			throw new LibraryImportException("Error while exporting project", e);
		}
		
		// 5th step: save manifest into AIRD for future references
		Session session = project.getSession();
		manifestServices.addExportedManifestToSession(session, newManifest);
	}
	

	
	private void addMarManifestToArchive(Manifest manifest, File jarFile) {
		try {
			// Create a temporary file for the manifest
			File tempFile = File.createTempFile("IS_", "_MANIFEST.MF");
			FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
			manifest.write(fileOutputStream);
			fileOutputStream.close();
			tempFile.deleteOnExit();
			
			// Add the manifest to zip
			ZipUtils.addToZip(tempFile, "META-INF/MANIFEST.MF", jarFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
