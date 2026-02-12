/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IContainer;
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
 * Assuming a changelog file is selected, opens a dialog prompting database connection informations and apply the changelog.
 * 
 */
@SuppressWarnings("restriction")
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
		
		File changelogFile = EventHelper.uwrapSingleSelection(event, File.class);
		
		if(changelogFile == null) {
			return null;
		}
		
		File liquibasePropertiesFile = getLiquibasePropertiesFile(changelogFile);
		if(liquibasePropertiesFile == null) {
			MessageDialog.openError(shell, Messages.ChangelogHandler_dialog_title, Messages.ChangelogHandler_Error_message_properties_file_not_found);
			return null;
		}
		
		try {
			if (openConnectionInformationDialog(liquibasePropertiesFile)) {
				LiquibaseUpdater liquibaseUpdater = new LiquibaseUpdater(changelogFile);
				liquibaseUpdater.update(URL, username, password);
				MessageDialog.openInformation(shell, 
						Messages.ChangelogHandler_dialog_title, 
						String.format(Messages.ChangelogHandler_success_message, getLiquibaseVersion()));
			}
		} catch (IOException | LiquibaseException e) {
			MessageDialog.openError(shell, Messages.ChangelogHandler_dialog_title, e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Opens a dialog prompting for the database parameters.
	 * 
	 * @param liquibasePropertiesFile 
	 * @return true if the user validated the dialog, false if the user canceled.
	 * @throws IOException 
	 */
	private boolean openConnectionInformationDialog(File liquibasePropertiesFile) throws IOException {
		
		java.io.File credentialsPropertiesFile = Paths.get(liquibasePropertiesFile.getParent().getLocationURI()).resolve(CREDENTIALS_PROPERTIES_FILE_NAME).toFile();
		
		Properties credentialsProperties = new Properties();
		// Check if credentials file exist
		if (!credentialsPropertiesFile.exists()) {
			Properties liquibaseProperties = new Properties();
			InputStream inputStream = new FileInputStream(liquibasePropertiesFile.getLocation().toOSString());
			liquibaseProperties.load(inputStream);
			
			// initialize credentials file using default values in liquibase file
			credentialsProperties.setProperty("url.1", liquibaseProperties.getProperty("url", ""));
			credentialsProperties.setProperty("username.1", liquibaseProperties.getProperty("username", ""));
			credentialsProperties.setProperty("password.1", liquibaseProperties.getProperty("password", ""));
			
			final FileOutputStream credentialsFos = new FileOutputStream(credentialsPropertiesFile);
			credentialsProperties.store(credentialsFos, "Credentials for database connections");
			inputStream.close();
			credentialsFos.close();
		}else {
			final FileInputStream credentialsFis = new FileInputStream(credentialsPropertiesFile);
			credentialsProperties.load(credentialsFis);
			credentialsFis.close();
		}
		
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
	 * Try to find a <code>liquibase.properties</code> file in the same folder than
	 * the given change log {@link File}.<br>
	 * If not found there, try to find it in the parent folder.<br>
	 * If still not found returns null.<br>
	 * 
	 * @param changelogFile a {@link File}.
	 * 
	 * @return a {@link File} or null.
	 */
	private File getLiquibasePropertiesFile(File changelogFile) {
		IPath propertiesPath = new Path(LIQUIBASE_PROPERTIES_FILE_NAME);
		IContainer container = changelogFile.getParent();
		File liquibasePropertiesFile = null;
		
		if(!container.getFile(propertiesPath).exists()) {
			container = container.getParent();
		}
		
		if(container.getFile(propertiesPath).exists()) {
			liquibasePropertiesFile = (File) container.getFile(propertiesPath);
		}
		
		return liquibasePropertiesFile;
	}
	
}
