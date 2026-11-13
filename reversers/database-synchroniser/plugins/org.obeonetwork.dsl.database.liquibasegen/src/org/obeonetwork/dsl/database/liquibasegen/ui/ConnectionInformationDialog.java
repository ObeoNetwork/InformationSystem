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
package org.obeonetwork.dsl.database.liquibasegen.ui;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.database.liquibasegen.ConnectionInformation;

/**
 * Lets users select or enter database connection details. The initial values are
 * replaced by the confirmed values when OK is pressed and remain available after
 * the dialog closes.
 *
 * @author Obeo
 */
public class ConnectionInformationDialog extends Dialog {

	private static final int URL_FIELD_WIDTH_IN_CHARACTERS = 70;

	private final List<ConnectionInformation> connections;

	private ConnectionInformation connection;

	private Combo urlCombo;

	private Text usernameText;

	private Text passwordText;

	/**
	 * Creates a dialog with initial values independent of the available profiles.
	 * The supplied initial connection is displayed even when no profile matches it.
	 *
	 * @param parentShell the parent shell
	 * @param connections the available connections in display order
	 * @param initialConnection the values to display when the dialog opens
	 */
	public ConnectionInformationDialog(Shell parentShell, List<ConnectionInformation> connections,
			ConnectionInformation initialConnection) {
		super(parentShell);
		this.connections = connections;
		connection = initialConnection;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout) container.getLayout();
		layout.numColumns = 2;

		Label urlLabel = new Label(container, SWT.NONE);
		urlLabel.setText("URL");
		urlCombo = new Combo(container, SWT.BORDER);
		GridData urlLayoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		urlLayoutData.widthHint = convertWidthInCharsToPixels(URL_FIELD_WIDTH_IN_CHARACTERS);
		urlCombo.setLayoutData(urlLayoutData);
		urlCombo.setItems(connections.stream().map(ConnectionInformation::url).toArray(String[]::new));

		Label usernameLabel = new Label(container, SWT.NONE);
		usernameLabel.setText("Username");
		usernameText = new Text(container, SWT.BORDER);
		usernameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label passwordLabel = new Label(container, SWT.NONE);
		passwordLabel.setText("Password");
		passwordText = new Text(container, SWT.BORDER);
		passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		int initialIndex = connections.indexOf(connection);
		if (initialIndex >= 0) {
			urlCombo.select(initialIndex);
		} else {
			urlCombo.setText(connection.url());
		}
		updateCredentials(connection);
		urlCombo.addModifyListener(event -> updateCredentialsFromUrl());
		// Refresh credentials when switching accounts with the same URL.
		urlCombo.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> updateCredentialsFromUrl()));

		return container;
	}

	/**
	 * Uses the selected profile index to distinguish accounts sharing a URL.
	 * When the URL is typed freely, uses the first matching profile or clears the
	 * credentials if the URL is unknown.
	 */
	private void updateCredentialsFromUrl() {
		int selectedIndex = urlCombo.getSelectionIndex();
		if (selectedIndex >= 0) {
			updateCredentials(connections.get(selectedIndex));
			return;
		}

		String url = urlCombo.getText();
		ConnectionInformation matchingConnection = connections.stream()
				.filter(candidate -> candidate.url().equals(url))
				.findFirst()
				.orElseGet(() -> new ConnectionInformation(url, "", ""));
		updateCredentials(matchingConnection);
	}

	/**
	 * Fills the credential controls from a profile, leaving the editable URL intact.
	 */
	private void updateCredentials(ConnectionInformation selectedConnection) {
		usernameText.setText(selectedConnection.username());
		passwordText.setText(selectedConnection.password());
	}

	/**
	 * Captures the edited values before JFace closes the dialog and disposes its
	 * controls, so the handler can read the result after {@code open()} returns.
	 */
	@Override
	protected void okPressed() {
		connection = new ConnectionInformation(urlCombo.getText(), usernameText.getText(), passwordText.getText());
		super.okPressed();
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Apply Changelog — Database Connection");
	}

	/**
	 * @return the initial URL, or the confirmed URL after validation
	 */
	public String getUrl() {
		return connection.url();
	}

	/**
	 * @return the initial username, or the confirmed username after validation
	 */
	public String getUsername() {
		return connection.username();
	}

	/**
	 * @return the initial password, or the confirmed password after validation
	 */
	public String getPassword() {
		return connection.password();
	}

}
