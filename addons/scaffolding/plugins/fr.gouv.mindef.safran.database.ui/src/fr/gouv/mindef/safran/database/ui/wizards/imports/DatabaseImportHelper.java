/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.imports;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;

import fr.gouv.mindef.safran.database.ui.Activator;

public class DatabaseImportHelper {

	public static boolean importDatabaseIntoModel(DatabaseInfos databaseInfos, String modelFilename, Collection<IFile> referencedFiles) {
		DataSource dataSource = databaseInfos.getDataSource();
		
		// Override this resolver to resolve external dependencies (i.e.: tables store in another schema)
		MultiDataBaseQueries queries = new MultiDataBaseQueries();
		for (IFile referencedFile : referencedFiles) {
			addFileToResolver(queries, referencedFile);
		}
		
		ImportRunnable runnable = new ImportRunnable(dataSource, modelFilename, queries);
		
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, false, runnable);
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while importing database", e));
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									"Error occured while importing database",
									"An error occured while importing the database. See Error Log view for more details.");
		}
		
		return runnable.getResult();
	}
	
	private static void addFileToResolver(MultiDataBaseQueries queries, IFile referencedFile) {
		URI uri = URI.createPlatformResourceURI(referencedFile.getFullPath().toString(), true);
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(uri, true);
		for (EObject root : resource.getContents()) {
			if (root instanceof DataBase) {
				queries.registerDatabase((DataBase)root);
			}
		}
	}
}
