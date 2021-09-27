package org.obeonetwork.dsl.database.liquibasegen.handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.liquibasegen.LiquibaseUpdater;
import org.obeonetwork.dsl.database.liquibasegen.ui.ConnectionInformationDialog;

import liquibase.exception.LiquibaseException;


/**
 * This handler is activated when the user right clicks on a file and picks Liquidbase > apply changelog.
 * It opens a dialog for defining a Database connection, and updates this database with the specified changelogs.
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a>
 */
@SuppressWarnings("restriction")
public class ChangelogHandler extends AbstractHandler {
	private Shell shell = null;
	private String URL;
	private String username;
	private String password;

	private File liquibaseProperties;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		liquibaseProperties = null;
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		shell = HandlerUtil.getActiveShell(event);
		if (selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof File) {
				// Getting the changelog file.
				File changelogFile = (File) structuredSelection.getFirstElement();
				
				if (askConnectionInformation(changelogFile)) {
					LiquibaseUpdater liquibaseUpdater = new LiquibaseUpdater(changelogFile);
					try {
						liquibaseUpdater.update(URL, username, password);
					} catch (LiquibaseException e) {
						MessageDialog.openError(shell, "Liquibase Update", e.getMessage());
					}	 
				}
			} 
		}		
		return null;
	}
	
	/**
	 * Opens a dialog that lets the user define the database parameters.
	 * @param changelogProject 
	 * @return true if the user specified information, false otherwise.
	 */
	private boolean askConnectionInformation(File changelogFile) {
		Properties liquibaseProperties = getLiquibaseProperties(changelogFile);				

		ConnectionInformationDialog connectionInformationDialog = new ConnectionInformationDialog((shell), 
				liquibaseProperties.getProperty("url", ""),
				liquibaseProperties.getProperty("username", ""),
				liquibaseProperties.getProperty("password", "")); 
		
		connectionInformationDialog.open();
		
		if (connectionInformationDialog.getReturnCode() == Window.OK) {
			URL = connectionInformationDialog.getUrl();
			username = connectionInformationDialog.getUsername();
			password = connectionInformationDialog.getPassword();
			
			return true;
		} 
		
		return false;
	}
	
	/**
	 * Visits the {@link IProject} that contains the changelog {@link File} and tries to find a <code>liquibase.properties</code> file.
	 * 
	 * @implNote It returns the first <code>liquibase.properties</code> found. A better implementation could gather all <code>liquibase.properties</code> 
	 * files, and return only the closest one from the changelog file selected by the user.
	 * 
	 * @param changelogProject a {@link IProject}.
	 * @return a {@link File} if <code>liquibase.properties</code> is found, or <code>null</code>.
	 */
	private Properties getLiquibaseProperties(File changelogFile) {
		IPath propertiesPath = new Path("liquibase.properties");		
		IContainer container = changelogFile.getParent();		
		
		while (container != null && !(container instanceof WorkspaceRoot) && !container.getFile(propertiesPath).exists()) {
			container = container.getParent();
		}
		
		if (container != null && container instanceof Folder) {
			liquibaseProperties = (File) container.getFile(propertiesPath);
		} else {
			setLiquibasePropertiesInProject(changelogFile.getProject());
		}
		
		Properties properties = buildPropertiesFile(liquibaseProperties);
		return properties;
	}
	
	/**
	 * Visits an {@link IProject} to find a Liquibase properties {@link File}.
	 * @param changelogProject a {@link IProject}
	 */
	private void setLiquibasePropertiesInProject(IProject changelogProject) {
		try {
			changelogProject.accept(new IResourceVisitor() {
				
				@Override
				public boolean visit(IResource resource) throws CoreException {					
					if (liquibaseProperties != null) {
						return false;
					}
					if ("liquibase.properties".equals(resource.getName())) {
						liquibaseProperties = (File) resource;
						return false;
					}
					return true;
				}
			});
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Build a {@link Properties} out of a {@link File}.
	 * @param propertiesFile a {@link File}
	 * @return the {@link Properties}
	 */
	private Properties buildPropertiesFile(File propertiesFile) {
		Properties properties = new Properties();
		
		if (propertiesFile != null && propertiesFile.exists()) {
			try {
				InputStream inputStream = new FileInputStream(propertiesFile.getLocation().toOSString());
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return properties;
	}
}
