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

import java.nio.file.Path;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Lets the user select ordered histories and warns about gaps in the selection.
 */
public final class GlobalChangelogSelectionPage extends WizardPage {

	private final List<Path> changelogs;
	private CheckboxTableViewer tableViewer;

	/**
	 * @param changelogs relative history paths in chronological order, as returned by
	 *                   changelog discovery
	 */
	public GlobalChangelogSelectionPage(List<Path> changelogs) {
		super("changelogSelection");
		this.changelogs = List.copyOf(changelogs);
		setTitle("Create global Liquibase changelog");
		setDescription("Choose which changelogs to include in the global changelog.");
		setPageComplete(false);
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		Button selectAllButton = new Button(container, SWT.PUSH);
		selectAllButton.setText("Select all");
		selectAllButton.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));
		selectAllButton.setEnabled(!changelogs.isEmpty());
		selectAllButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> {
			tableViewer.setAllChecked(true);
			updateSelectionState();
		}));

		tableViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setLabelProvider(new LabelProvider());
		tableViewer.setInput(changelogs);
		tableViewer.addCheckStateListener(event -> updateSelectionState());

		setControl(container);
		updateSelectionState();
	}

	/**
	 * Returns checked paths in the displayed chronological order. The viewer is the
	 * only source of selection state. Controls must have been created before calling
	 * this method.
	 */
	public List<Path> getSelectedChangelogs() {
		return changelogs.stream().filter(tableViewer::getChecked).toList();
	}

	/**
	 * Clears stale generation errors and enables Finish for any nonempty selection.
	 * A gap between the first and last checked rows only raises a warning: it must
	 * not prevent the user from generating a discontinuous history.
	 */
	private void updateSelectionState() {
		setErrorMessage(null);
		setMessage(null);
		List<Path> selectedChangelogs = getSelectedChangelogs();
		setPageComplete(!selectedChangelogs.isEmpty());
		if (selectedChangelogs.size() < 2) {
			return;
		}
		int firstIndex = changelogs.indexOf(selectedChangelogs.get(0));
		int lastIndex = changelogs.indexOf(selectedChangelogs.get(selectedChangelogs.size() - 1));
		if (lastIndex - firstIndex + 1 != selectedChangelogs.size()) {
			setMessage(
					"Some changelogs are not selected between others. This may result in an inconsistent global changelog.",
					IMessageProvider.WARNING);
		}
	}
}
