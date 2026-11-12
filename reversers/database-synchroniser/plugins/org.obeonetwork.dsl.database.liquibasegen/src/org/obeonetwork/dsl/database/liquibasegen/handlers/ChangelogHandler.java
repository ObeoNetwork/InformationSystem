/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen.handlers;

import static org.obeonetwork.dsl.database.liquibasegen.Activator.getLiquibaseVersion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.liquibasegen.ConnectionInformation;
import org.obeonetwork.dsl.database.liquibasegen.LiquibaseUpdater;
import org.obeonetwork.dsl.database.liquibasegen.ui.ConnectionInformationDialog;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

import liquibase.exception.LiquibaseException;

/**
 * Apply a changelog to a database.
 * 
 * Assuming a changelog file is selected, opens a dialog prompting database
 * connection informations and apply the changelog.
 * 
 */
public class ChangelogHandler extends AbstractHandler {
	private static final String CREDENTIALS_PROPERTIES_FILE_NAME = "credentials.properties";

	private final static String LIQUIBASE_PROPERTIES_FILE_NAME = "liquibase.properties"; //$NON-NLS-1$

	private Shell shell;

	private String URL;
	private String username;
	private String password;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		shell = HandlerUtil.getActiveShell(event);

		IFile changelogFile = EventHelper.uwrapSingleSelection(event, IFile.class);

		if (changelogFile == null) {
			return null;
		}

		IFile liquibasePropertiesFile = getLiquibasePropertiesFile(changelogFile);
		if (liquibasePropertiesFile == null) {
			MessageDialog.openError(shell, Messages.ChangelogHandler_dialog_title,
					Messages.ChangelogHandler_Error_message_properties_file_not_found);
			return null;
		}

		try {
			if (openConnectionInformationDialog(liquibasePropertiesFile)) {
				LiquibaseUpdater liquibaseUpdater = new LiquibaseUpdater(changelogFile);
				liquibaseUpdater.update(URL, username, password);
				MessageDialog.openInformation(shell, Messages.ChangelogHandler_dialog_title,
						String.format(Messages.ChangelogHandler_success_message, getLiquibaseVersion()));
			}
		} catch (IOException | CoreException | LiquibaseException e) {
			System.err.println(e.getMessage());
			MessageDialog.openError(shell, Messages.ChangelogHandler_dialog_title, e.getMessage());
		}

		return null;
	}

	/**
	 * Opens a dialog prompting for the database parameters.
	 * 
	 * @param liquibasePropertiesFile
	 * @return true if the user validated the dialog, false if the user canceled.
	 * @throws IOException if the properties cannot be read or serialized
	 * @throws CoreException if the workspace resource cannot be read or created
	 */
	private boolean openConnectionInformationDialog(IFile liquibasePropertiesFile) throws IOException, CoreException {
		Properties credentialsProperties = loadOrCreateCredentialsProperties(liquibasePropertiesFile);

		int count = 1;
		List<ConnectionInformation> connectionInformations = new ArrayList<>();
		while (credentialsProperties.getProperty("url."+count)!=null) {
			connectionInformations.add(new ConnectionInformation(credentialsProperties.getProperty("url."+count,""),
																	credentialsProperties.getProperty("username."+count,""), 
																		credentialsProperties.getProperty("password."+count,"")));
			count++;
		}
		
		ConnectionInformationDialog connectionInformationDialog = new ConnectionInformationDialog(
				shell, 
				connectionInformations);
		
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
	 * Loads the connection profiles beside the Liquibase properties file. If absent,
	 * creates the workspace resource using the Liquibase connection as the first
	 * profile and a commented example for a second profile. An existing file is
	 * loaded without changing its contents.
	 *
	 * @param liquibasePropertiesFile the source of the initial connection defaults
	 * @return the properties loaded from or written to the credentials file
	 * @throws IOException if the properties cannot be read or serialized
	 * @throws CoreException if a workspace resource cannot be refreshed, read or created
	 */
	private Properties loadOrCreateCredentialsProperties(IFile liquibasePropertiesFile) throws IOException, CoreException {
		IFile credentialsFile = liquibasePropertiesFile.getParent().getFile(new Path(CREDENTIALS_PROPERTIES_FILE_NAME));
		// Recognize a file created outside Eclipse before deciding whether to create it.
		credentialsFile.refreshLocal(IResource.DEPTH_ZERO, null);
		if (credentialsFile.exists()) {
			return loadProperties(credentialsFile);
		}

		Properties liquibaseProperties = loadProperties(liquibasePropertiesFile);
		Properties credentialsProperties = new Properties();
		credentialsProperties.setProperty("url.1", liquibaseProperties.getProperty("url", ""));
		credentialsProperties.setProperty("username.1", liquibaseProperties.getProperty("username", ""));
		credentialsProperties.setProperty("password.1", liquibaseProperties.getProperty("password", ""));

		ByteArrayOutputStream contents = new ByteArrayOutputStream();
		String comment = "Credentials for database connections" + System.lineSeparator() + System.lineSeparator()
				+ "url.2=jdbc:oracle:thin:@<hostname>:1521:<dbName>" + System.lineSeparator()
				+ "username.2=" + System.lineSeparator() + "password.2=";
		credentialsProperties.store(contents, comment);
		try (InputStream inputStream = new ByteArrayInputStream(contents.toByteArray())) {
			credentialsFile.create(inputStream, false, null);
		}
		return credentialsProperties;
	}

	/**
	 * Reads Java properties from a workspace file and closes the stream even if
	 * loading fails. Keeps the standard properties encoding used by Liquibase.
	 *
	 * @param file the properties file to read
	 * @return the loaded properties
	 * @throws IOException if the contents cannot be read
	 * @throws CoreException if the workspace file cannot be opened
	 */
	private Properties loadProperties(IFile file) throws IOException, CoreException {
		Properties properties = new Properties();
		try (InputStream inputStream = file.getContents()) {
			properties.load(inputStream);
		}
		return properties;
	}

	/**
	 * Try to find a <code>liquibase.properties</code> file in the same folder than
	 * the given change log {@link IFile}.<br>
	 * If not found there, try to find it in the parent folder.<br>
	 * If still not found returns null.<br>
	 * 
	 * @param changelogFile a {@link IFile}.
	 * 
	 * @return a {@link IFile} or null.
	 */
	private IFile getLiquibasePropertiesFile(IFile changelogFile) {
		IPath propertiesPath = new Path(LIQUIBASE_PROPERTIES_FILE_NAME);
		IContainer container = changelogFile.getParent();
		IFile liquibasePropertiesFile = null;

		if (!container.getFile(propertiesPath).exists()) {
			container = container.getParent();
		}

		if (container.getFile(propertiesPath).exists()) {
			liquibasePropertiesFile = container.getFile(propertiesPath);
		}

		return liquibasePropertiesFile;
	}

}
