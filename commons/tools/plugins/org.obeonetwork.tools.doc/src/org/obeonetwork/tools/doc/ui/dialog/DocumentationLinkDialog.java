/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.ui.dialog;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.obeonetwork.tools.doc.DocBridgeUI;
import org.obeonetwork.tools.doc.core.DocumentationLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class DocumentationLinkDialog extends Dialog {

	private String name;
	private String value;
	private Text valueText;
	private TreeViewer treeViewer;
	private Text nameText;
	private DocumentationLink initialeValue;
	private Button btnWeb;
	private Button btnWorkspace;
	
	/**
	 * @param parentShell
	 */
	public DocumentationLinkDialog(Shell parentShell) {
		super(parentShell);
	}

	public DocumentationLinkDialog(Shell shell, DocumentationLink documentationLink) {
		this(shell);
		this.initialeValue = documentationLink;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.Dialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control createContents = super.createContents(parent);
		if (initialeValue != null) {
			setValue(initialeValue);
		} else {
			btnWeb.setSelection(true);
		}
		updateButtons();
		nameText.setFocus();
		return createContents;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = initDialogContainer(parent);
		
		Group grpDocumentationSettings = new Group(container, SWT.NONE);
		grpDocumentationSettings.setLayout(new GridLayout(2, false));
		grpDocumentationSettings.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		grpDocumentationSettings.setText(DocBridgeUI.getInstance().getString("DocumentationLinkDialog_SettingsGroup_title")); //$NON-NLS-1$
		
		createNameEditor(grpDocumentationSettings);		
		createWebValueEditor(grpDocumentationSettings);
		
		createWorkspaceValueEditor(grpDocumentationSettings);
		
		return container;
	}

	private Composite initDialogContainer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_container_1 = new GridLayout(2, false);
		gl_container_1.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		gl_container_1.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		gl_container_1.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		gl_container_1.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		container.setLayout(gl_container_1);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		applyDialogFont(container);
		return container;
	}
	
	private void createNameEditor(Group grpDocumentationSettings) {
		Label nameLabel = new Label(grpDocumentationSettings, SWT.NONE);
		nameLabel.setText(DocBridgeUI.getInstance().getString("DocumentationLinkDialog_NameEditor_title")); //$NON-NLS-1$
		nameText = new Text(grpDocumentationSettings, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				name = nameText.getText();
				updateButtons();
			}
		});
	}

	private void createWebValueEditor(Group grpDocumentationSettings) {
		btnWeb = new Button(grpDocumentationSettings, SWT.RADIO);
		btnWeb.setText(DocBridgeUI.getInstance().getString("DocumentationLinkDialog_WebEditor_title")); //$NON-NLS-1$
		btnWeb.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				valueText.setEnabled(true);
				treeViewer.getControl().setEnabled(false);
			}
			
		});
		valueText = new Text(grpDocumentationSettings, SWT.BORDER);
		valueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		valueText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				value = valueText.getText();
				updateButtons();
			}
		});
	}

	private void createWorkspaceValueEditor(Group grpDocumentationSettings) {
		btnWorkspace = new Button(grpDocumentationSettings, SWT.RADIO);
		btnWorkspace.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnWorkspace.addSelectionListener(new SelectionAdapter() {
			
			/**
			 * {@inheritDoc}
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				valueText.setEnabled(false);
				treeViewer.getControl().setEnabled(true);
			}
			
		});
		btnWorkspace.setText(DocBridgeUI.getInstance().getString("DocumentationLinkDialog_WorkspaceEditor_title")); //$NON-NLS-1$
		
		treeViewer = new TreeViewer(grpDocumentationSettings, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		tree.setEnabled(false);
		
		
		treeViewer.setContentProvider(new WorkbenchContentProvider());
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) {
					Object selection = ((StructuredSelection)event.getSelection()).getFirstElement();
					if (selection instanceof IFile) {
						value = DocumentationLink.WORKSPACE_PREFIX + ((IFile)selection).getFullPath().toString();
					} else {
						value = null;
					}
					updateButtons();
				}
			}
		});
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(DocBridgeUI.getInstance().getString("DocumentationLinkDialog_title")); //$NON-NLS-1$
		newShell.setSize(450, 520);
	}

	/**
	 * 
	 */
	private void updateButtons() {
		if (dialogComplete()) {
			getButton(OK).setEnabled(true);
		} else {
			getButton(OK).setEnabled(false);
		}
	}
	
	/**
	 * @return
	 */
	private boolean dialogComplete() {
		return name != null && !name.equals("") && value != null && !value.equals(""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Initialize the dialog with a link.
	 * @param link to populate in the dialog.
	 */
	public void setValue(DocumentationLink link) {
		nameText.setText(link.getName());
		if (link.isWorkspaceDocumentation()) {
			IPath path = new Path(link.getWorkspaceRelativeValue());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			treeViewer.setSelection(new StructuredSelection(file));
			treeViewer.getControl().setEnabled(true);
			valueText.setEnabled(false);
			btnWorkspace.setSelection(true);
			
		} else {
			valueText.setText(link.getValue());
			valueText.setEnabled(true);
			treeViewer.getControl().setEnabled(false);
			btnWeb.setSelection(true);
		}
	}
	
}
