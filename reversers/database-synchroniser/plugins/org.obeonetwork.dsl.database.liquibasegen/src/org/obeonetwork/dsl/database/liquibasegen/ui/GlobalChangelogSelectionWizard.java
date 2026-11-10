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

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.obeonetwork.dsl.database.liquibasegen.service.GlobalChangelogService;

/**
 * Wizard to select changelogs to include in a global changelog
 */
public class GlobalChangelogSelectionWizard extends Wizard {

	private SelectionTreeWizardPage selectionPage;
	/**
	 * Keep track of selection in the wizard
	 */
	private final List<String> cachedSelection = new ArrayList<>();
	/**
	 * All the available name of files that can be selected
	 */
	private List<String> nodes;
	private String rootSelectionDir;

	public GlobalChangelogSelectionWizard(List<String> nodes, String rootSelectionDir) {
		setWindowTitle("Create global changelog");
		this.nodes = nodes;
		this.rootSelectionDir = rootSelectionDir;
	}

	@Override
	public void addPages() {
		selectionPage = new SelectionTreeWizardPage("Selection page of changelogs", nodes, cachedSelection);
		addPage(selectionPage);
	}

	@Override
	public boolean performFinish() {
		selectionPage.setErrorMessage(null);
		try {
			List<Path> selectedChangelogs = selectionPage.getSelectedItems().stream().map(Path::of).toList();
			GlobalChangelogService.createGlobalChangelog(Path.of(rootSelectionDir), selectedChangelogs);
			return true;
		} catch (IOException e) {
			selectionPage.setErrorMessage(e.getMessage());
			StatusManager.getManager().handle(new Status(IStatus.ERROR,
					"org.obeonetwork.dsl.database.liquibasegen", e.getMessage(), e), StatusManager.LOG);
			return false;
		}
	}
}

/**
 * Page with CheckboxTreeViewer
 */
class SelectionTreeWizardPage extends WizardPage {

	private CheckboxTreeViewer treeViewer;
	private final List<String> cache;

	/**
	 * All the available nodes that can be selected
	 */
	private final Node[] roots;

	protected SelectionTreeWizardPage(String pageName, List<String> nodes, List<String> cache) {
		super(pageName);
		setTitle("Create global Liquibase changelog");
		setDescription("Choose which changelogs to include in the global changelog.");
		roots = nodes.stream().map(Node::new).toArray(Node[]::new);
		this.cache = cache;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		treeViewer = new CheckboxTreeViewer(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public Object[] getElements(Object input) {
				return roots;
			}

			@Override
			public Object[] getChildren(Object parent) {
				return ((Node) parent).children;
			}

			@Override
			public Object getParent(Object element) {
				return ((Node) element).parent;
			}

			@Override
			public boolean hasChildren(Object element) {
				return ((Node) element).children.length > 0;
			}
		});

		treeViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Node) element).name;
			}
		});

		treeViewer.setInput(roots);

		restoreFromCache();

		treeViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				updateCache();
				checkContinuity();
				setPageComplete(!cache.isEmpty());
			}
		});

		setControl(container);
		setPageComplete(!cache.isEmpty());
	}

	/**
	 * Check if the selection
	 */
	protected void checkContinuity() {
		setMessage(null);
		if (!cache.isEmpty()) {
			final List<String> rootsNames = Arrays.asList(roots).stream().map(Node::getName).toList();
			int startIndex = rootsNames.indexOf(cache.get(0));
			for (int i = 0; i < cache.size(); i++) {
				if (!cache.get(i).equals(rootsNames.get(startIndex + i))) {
					setMessage(
							"Some changelogs are not selected between others. This may result in an inconsistent global changelog.",
							IMessageProvider.WARNING);
				}
			}
		}

	}

	private void updateCache() {
		cache.clear();
		Object[] checked = treeViewer.getCheckedElements();
		for (Object o : checked) {
			Node n = (Node) o;
			if (n.children.length == 0) { // we keep only leaves
				cache.add(n.name);
			}
		}
	}

	private void restoreFromCache() {
		List<Node> toCheck = new ArrayList<>();
		for (Node root : roots) {
			for (Node child : root.children) {
				if (cache.contains(child.name)) {
					toCheck.add(child);
				}
			}
		}
		treeViewer.setCheckedElements(toCheck.toArray());
	}

	/**
	 * @return selected items in the tree viewer
	 */
	public List<String> getSelectedItems() {
		return Stream.of(treeViewer.getCheckedElements()).filter(Node.class::isInstance).map(Node.class::cast)
				.map(Node::getName).toList();
	}
}

/**
 * Small tree object
 */
class Node {
	final String name;
	final Node[] children;
	Node parent;

	Node(String name, Node... children) {
		this.name = name;
		this.children = children;
		for (Node c : children) {
			c.parent = this;
		}
	}

	String getName() {
		return name;
	}
}
