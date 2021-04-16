package org.obeonetwork.dsl.cinematic.design.services.flows;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.obeonetwork.dsl.cinematic.design.services.flows.listeners.ViewContainerCheckStateListener;
import org.obeonetwork.dsl.cinematic.design.services.flows.listeners.ViewContainerHideBoundContainersListener;
import org.obeonetwork.dsl.cinematic.design.services.flows.providers.ViewContainerCheckStateProvider;
import org.obeonetwork.dsl.cinematic.design.services.flows.providers.ViewContainerLabelProvider;
import org.obeonetwork.dsl.cinematic.design.services.flows.providers.ViewContainerTreeContentProvider;
import org.obeonetwork.dsl.cinematic.flow.ViewState;

public class ViewContainerSelectionDialog extends Dialog {
	private Text txtFilterText;
	private ViewState viewState;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ViewContainerSelectionDialog(Shell parentShell, ViewState viewState) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM);
		this.viewState = viewState;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(container, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_composite.widthHint = 429;
		gd_composite.heightHint = 59;
		composite.setLayoutData(gd_composite);
		composite.setLayout(new GridLayout(2, false));
		
		Button btnCheckButton = new Button(composite, SWT.CHECK);

		btnCheckButton.setText("Hide View Containers bound to other View States");
		new Label(composite, SWT.NONE);
		
		txtFilterText = new Text(composite, SWT.SEARCH | SWT.ICON_CANCEL);
		GridData gd_txtFilterText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtFilterText.widthHint = 363;
		txtFilterText.setLayoutData(gd_txtFilterText);
		txtFilterText.setMessage("Filter text (? = any character, * = any String)");
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 55;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("clear");
		
		CheckboxTreeViewer checkboxTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);
		Tree tree = checkboxTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		ViewContainerTreeContentProvider containerTreeContentProvider = new ViewContainerTreeContentProvider(viewState);
		checkboxTreeViewer.setContentProvider(containerTreeContentProvider);
		btnCheckButton.addSelectionListener(new ViewContainerHideBoundContainersListener(checkboxTreeViewer, containerTreeContentProvider));
		checkboxTreeViewer.setLabelProvider(new ViewContainerLabelProvider());			
		checkboxTreeViewer.addCheckStateListener(new ViewContainerCheckStateListener(checkboxTreeViewer, viewState));		
		checkboxTreeViewer.setCheckStateProvider(new ViewContainerCheckStateProvider(viewState));
		
		checkboxTreeViewer.setInput(FlowsUtil.getCinematicRoot(this.viewState));

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 361);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("View Container selection");	
	}
}
