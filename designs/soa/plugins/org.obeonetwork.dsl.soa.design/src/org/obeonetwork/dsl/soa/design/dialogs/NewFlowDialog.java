/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.design.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.FlowType;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Scope;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.design.dialogs.supports.ScopeDescriptionEditingSupport;
import org.obeonetwork.dsl.soa.design.dialogs.supports.ScopeNameEditingSupport;

/**
 * {@link Dialog} for creating and editing {@link Flow} objects
 * 
 * IMPORTANT NOTICE: This code is not used. The dialog displayed is generated with Sirius. 
 * Although, the display of the group elements depends on the SecuritySchemeType Combo box, and cannot be changed dynamically.
 * A current workaround has been implemented, disposing and re-opening the sirius Dialog. 
 * This {@link NewFlowDialog} class is kept in case the user do not want to rely on the workaround.
 * 
 * @author Obeo
 */
public class NewFlowDialog extends Dialog {
	
	protected Shell shell;
	private Text authText;
	private Text tokenText;
	private Text refreshText;
	private Flow flow;
	private FlowType flowType;
	private Collection<Scope> scopeToAdd = new ArrayList<>();
	private Collection<Scope> scopeToRemove = new ArrayList<>();
	private Table scopeTable;
	private TableViewer scopeTableViewer;

	/**
	 * Create the dialog.
	 * @param parent a {@link Shell}
	 * @param flow a {@link Flow}
	 */
	public NewFlowDialog(Shell parent, Flow flow) {
		super(parent);		
		this.flow = flow;
		setText(Messages.FlowDialog_Title_Label);
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.setLocation(getParent().getLocation());
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return null;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.BORDER | SWT.MIN | SWT.MAX | SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		shell.setSize(450, 332);
		shell.setText(getText());

		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.marginHeight = 0;
		gl_shell.verticalSpacing = 0;
		gl_shell.marginWidth = 0;
		shell.setLayout(gl_shell);
		
		Composite mainComposite = new Composite(shell, SWT.NONE);
		mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_mainComposite = new GridLayout(1, false);
		gl_mainComposite.verticalSpacing = 0;
		gl_mainComposite.marginWidth = 0;
		gl_mainComposite.horizontalSpacing = 0;
		gl_mainComposite.marginHeight = 0;
		mainComposite.setLayout(gl_mainComposite);
		
		Composite flowTypeComposite = new Composite(mainComposite, SWT.NONE);
		flowTypeComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		flowTypeComposite.setLayout(new GridLayout(2, false));
		
		Label lblType = new Label(flowTypeComposite, SWT.NONE);
		GridData gd_lblType = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblType.widthHint = 102;
		lblType.setLayoutData(gd_lblType);
		lblType.setBounds(0, 0, 55, 15);
		lblType.setText(Messages.SecuritySchemeDialog_Type_Label);
		
		Combo flowTypeCombo = new Combo(flowTypeComposite, SWT.READ_ONLY);
		flowTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		flowTypeCombo.setItems(FlowType.VALUES.stream().map(type -> type.getName()).toArray(String[]::new));
		flowTypeCombo.addListener(SWT.Selection, (e) -> setFlowType(FlowType.getByName(((Combo) e.widget).getText())));
		
		if (flow.getFlowType() != null) {
			flowType = flow.getFlowType();
			flowTypeCombo.setText(flow.getFlowType().getName());
		}
		
		Composite authComposite = new Composite(mainComposite, SWT.NONE);
		authComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		authComposite.setLayout(new GridLayout(2, false));
		
		Label lblAuthorizationUrl = new Label(authComposite, SWT.NONE);
		GridData gd_lblAuthorizationUrl = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblAuthorizationUrl.widthHint = 102;
		lblAuthorizationUrl.setLayoutData(gd_lblAuthorizationUrl);
		lblAuthorizationUrl.setBounds(0, 0, 55, 15);
		lblAuthorizationUrl.setText(Messages.FlowDialog_AuthorizationURL_Label);
		
		authText = new Text(authComposite, SWT.BORDER);
		authText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		if (flow.getAuthorizationURL() != null)
			authText.setText(flow.getAuthorizationURL());
		
		Composite tokenComposite = new Composite(mainComposite, SWT.NONE);
		tokenComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		tokenComposite.setLayout(new GridLayout(2, false));
		
		Label lblTokenUrl = new Label(tokenComposite, SWT.NONE);
		GridData gd_lblTokenUrl = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblTokenUrl.widthHint = 102;
		lblTokenUrl.setLayoutData(gd_lblTokenUrl);
		lblTokenUrl.setBounds(0, 0, 55, 15);
		lblTokenUrl.setText(Messages.FlowDialog_TokenURL_Label);
		
		tokenText = new Text(tokenComposite, SWT.BORDER);
		tokenText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		if (flow.getTokenURL() != null)
			tokenText.setText(flow.getTokenURL());
		
		Composite refreshComposite = new Composite(mainComposite, SWT.NONE);
		refreshComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		refreshComposite.setLayout(new GridLayout(2, false));
		
		Label lblRefreshUrl = new Label(refreshComposite, SWT.NONE);
		GridData gd_lblRefreshUrl = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblRefreshUrl.widthHint = 102;
		lblRefreshUrl.setLayoutData(gd_lblRefreshUrl);
		lblRefreshUrl.setBounds(0, 0, 55, 15);
		lblRefreshUrl.setText(Messages.FlowDialog_RefreshURL_Label);
		
		refreshText = new Text(refreshComposite, SWT.BORDER);
		refreshText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		if (flow.getRefreshURL() != null) 
			refreshText.setText(flow.getRefreshURL());
			
		Composite scopeTableComposite = new Composite(mainComposite, SWT.NONE);
		GridData gd_scopeTableComposite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_scopeTableComposite.heightHint = 159;
		scopeTableComposite.setLayoutData(gd_scopeTableComposite);
		scopeTableComposite.setLayout(new GridLayout(3, false));
		
		Label scopeLabel = new Label(scopeTableComposite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 102;
		scopeLabel.setLayoutData(gd_lblNewLabel);
		scopeLabel.setText(Messages.FlowDialog_Scopes_Label);
		
		scopeTableViewer = new TableViewer(scopeTableComposite, SWT.BORDER | SWT.FULL_SELECTION);
		scopeTable = scopeTableViewer.getTable();
		scopeTable.setLinesVisible(true);
		scopeTable.setHeaderVisible(true);
		GridData gd_scopeTable = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_scopeTable.heightHint = 184;
		scopeTable.setLayoutData(gd_scopeTable);
		
		TableViewerColumn nameTableViewerColumn = new TableViewerColumn(scopeTableViewer, SWT.LEFT);		
		TableColumn nameColumn = nameTableViewerColumn.getColumn();
		nameColumn.setText(Messages.FlowDialog_Name_Label);		
		nameColumn.setWidth(100);
		nameTableViewerColumn.setEditingSupport(new ScopeNameEditingSupport(scopeTableViewer));
		
		TableViewerColumn descriptionTableViewerColumn = new TableViewerColumn(scopeTableViewer, SWT.LEFT);		
		TableColumn descriptionColumn = descriptionTableViewerColumn.getColumn();
		descriptionColumn.setText(Messages.FlowDialog_Description_Label);
		descriptionColumn.setWidth(170);
		descriptionTableViewerColumn.setEditingSupport(new ScopeDescriptionEditingSupport(scopeTableViewer));

		scopeTableViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				Collection<Scope> scopesToDisplayInTheTable = new ArrayList<>();
				scopesToDisplayInTheTable.addAll(flow.getScopes());
				scopesToDisplayInTheTable.addAll(scopeToAdd);
				scopesToDisplayInTheTable.removeAll(scopeToRemove);
				return scopesToDisplayInTheTable.toArray(new Scope[] {});
			}
		});
		scopeTableViewer.setLabelProvider(new ColumnLabelProvider());
		
		Composite buttonComposite = new Composite(scopeTableComposite, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_buttonComposite = new GridLayout(1, false);
		gl_buttonComposite.marginHeight = 0;
		gl_buttonComposite.marginWidth = 0;
		buttonComposite.setLayout(gl_buttonComposite);
		
		Button addScope = new Button(buttonComposite, SWT.NONE);
		GridData gd_addScope = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_addScope.widthHint = 45;
		addScope.setLayoutData(gd_addScope);
		addScope.setImage(new Image(null, this.getClass().getClassLoader().getResourceAsStream(Messages.SecuritySchemeDialog_AddButton_Icon)));
		addScope.addListener(SWT.Selection, (e) -> {
			Scope toAdd = SoaFactory.eINSTANCE.createScope();
			toAdd.setName(Messages.Flow_Name_Value);
			toAdd.setSummary(Messages.Flow_Description_Value);
			scopeToAdd.add(toAdd);
			scopeTableViewer.refresh();
		});
		
		Button deleteScope = new Button(buttonComposite, SWT.NONE);
		deleteScope.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		deleteScope.setImage(new Image(null, this.getClass().getClassLoader().getResourceAsStream(Messages.SecuritySchemeDialog_DeleteButton_Icon)));
		deleteScope.addListener(SWT.Selection, (e) -> {
			Scope toRemove;
			if (scopeTableViewer.getStructuredSelection().getFirstElement()!= null) {
				toRemove = (Scope) scopeTableViewer.getStructuredSelection().getFirstElement();
				scopeToRemove.add(toRemove);
			} 
			scopeTableViewer.refresh();
		});
		
		Composite okCancelButtonsComposite = new Composite(mainComposite, SWT.NONE);
		okCancelButtonsComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1));
		okCancelButtonsComposite.setLayout(new GridLayout(2, false));
		
		Button cancelButton = new Button(okCancelButtonsComposite, SWT.NONE);
		GridData gd_cancelButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_cancelButton.widthHint = 83;
		cancelButton.setLayoutData(gd_cancelButton);
		cancelButton.setText(Messages.SecuritySchemeDialog_CancelButton_Label);
		cancelButton.addListener(SWT.Selection, (e) -> cancel());
		
		Button okButton = new Button(okCancelButtonsComposite, SWT.NONE);
		GridData gd_okButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okButton.widthHint = 83;
		okButton.setLayoutData(gd_okButton);
		okButton.setText(Messages.SecuritySchemeDialog_OKButton_Label);
		okButton.addListener(SWT.Selection, (e) -> validateCreation());
		
		scopeTableViewer.setInput(flow);
	}

	/**
	 * The cancel button is pressed.
	 * Cancels the creation of the {@link Flow}: all the scope {@link Operation} added are removed, all the scope {@link Operation} removed are added back.
	 */
	private void cancel() {
		revertChanges();
		shell.close();
	}

	private void revertChanges() {
//		flow.getScopes().removeAll(operationToAdd);
//		flow.getScopes().addAll(operationToRemove);	
	}
	
	/**
	 * The OK button is pressed.
	 * Validates all the changes entered by the user and pushes them to the {@link Flow} object.
	 */
	private void validateCreation() {
		flow.setAuthorizationURL(authText.getText());
		flow.setTokenURL(tokenText.getText());
		flow.setRefreshURL(refreshText.getText());
		flow.setFlowType(flowType);
		flow.getScopes().addAll(scopeToAdd);
		flow.getScopes().removeAll(scopeToRemove);

		shell.close();		
	}
	
	
	private void setFlowType(FlowType byName) {
		flowType = byName;
	}
		
	private class ColumnLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {			
			if (columnIndex == 0) 
				return ((Scope) element).getName();
			if (columnIndex == 1)
				return ((Scope) element).getSummary();
			
			return null;
		}
		
	}
}
