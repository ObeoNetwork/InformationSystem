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

import java.sql.Connection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.source.DataSourceException;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;

public class DatabaseImportWizard extends Wizard implements IImportWizard {
	
	DatabaseImportWizardPage mainPage;
	
	private DatabaseInfos databaseInfos;

	public DatabaseImportWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		// First, check if a connection to the database can be established
		if (databaseInfos != null) {
			Connection connection = null;
			DataSource dataSource = databaseInfos.getDataSource();
			if (dataSource != null) {
				try {
					connection = dataSource.getConnection();
				} catch (DataSourceException e) {
					// Unable to connect
					String message = "Unable to connect to database.\n\nReason : " + e.getCause().getMessage(); 
					MessageDialog.openError(getShell(), "Import database...", message);
					return false;
				} finally {
					JdbcUtils.closeConnection(connection);
				}
			}
		}
		
		
		String filename = mainPage.getTxtModelFile().getText();
		boolean result = DatabaseImportHelper.importDatabaseIntoModel(databaseInfos, filename, mainPage.getReferencedFiles());
		if (result == true) {
			MessageDialog.openInformation(getShell(), "Database imported", "The database has been imported.\nThe model file '" + filename + "' has been created.");
			IViewPart explorer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.ui.navigator.ProjectExplorer");
			if (explorer != null) {
				if (explorer instanceof ProjectExplorer) {
					ProjectExplorer projectExplorer = (ProjectExplorer)explorer;
					
					// Create a selection to point on the generated file
					final IFile generatedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filename));
					projectExplorer.selectReveal(new StructuredSelection(generatedFile));
				}
			}
		} else {
			MessageDialog.openError(getShell(), "Error while importing database", "The database could not be imported.");
		}
		return result;
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		databaseInfos = new DatabaseInfos();
		databaseInfos.computeUrl();
		mainPage = new DatabaseImportWizardPage("Database configuration", databaseInfos); //NON-NLS-1
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);
    }

	@Override
	public boolean canFinish() {
		return mainPage.checkStatus();
	}
    
	
}
