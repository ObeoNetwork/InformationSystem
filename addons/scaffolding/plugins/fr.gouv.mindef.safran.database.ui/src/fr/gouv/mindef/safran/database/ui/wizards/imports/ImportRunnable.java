/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.imports;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.database.util.DatabaseResourceImpl;

import fr.gouv.mindef.safran.database.ui.Activator;

public class ImportRunnable extends WorkspaceModifyOperation {
	private boolean result = false;
	private DataSource dataSourceInfos;
	private String modelFilename;
	private Queries queries;
	
	public ImportRunnable(	DataSource dataSourceInfos,
							String modelFilename, Queries queries) {
		this.dataSourceInfos = dataSourceInfos;
		this.modelFilename = modelFilename;
		this.queries = queries;
	}
	
	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		ProgressListener progressListener = new ProgressListener() {
			private int stepsToBeDone = 0;
			public void start(int nbSteps) {
				// +2 because there is one more step to save the file
				
				monitor.beginTask("Importing database", nbSteps + 1);
			}
			
			public void progressTo(int stepsToBeDone, String message) {
				if (this.stepsToBeDone != 0) {
					monitor.worked(this.stepsToBeDone);
				}
				monitor.subTask(message);
				this.stepsToBeDone = stepsToBeDone;
			}
			
			public void end(String message) {
				if (this.stepsToBeDone != 0) {
					monitor.worked(this.stepsToBeDone);
				}
			}
		};
		
		DataBase database = DatabaseReverser.reverse(dataSourceInfos, queries, progressListener);
		
		if (database != null) {
			// Store the model into a file
			monitor.subTask("Saving model file");
			try {
				saveIntoFile(database, modelFilename);
				result = true;
			} catch (IOException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while saving database into model file", e));
			}
			monitor.worked(1);
		} else {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while importing database : No database found."));
		}
		monitor.done();
	}

	private void saveIntoFile(DataBase database, String filename) throws IOException {
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.createResource(URI.createPlatformResourceURI(filename, true));
		((DatabaseResourceImpl)resource).setEncoding(ResourcesPlugin.getEncoding());
		resource.getContents().add(database);
		resource.save(null);
	}
	
	public boolean getResult() {
		return result;
	}
}