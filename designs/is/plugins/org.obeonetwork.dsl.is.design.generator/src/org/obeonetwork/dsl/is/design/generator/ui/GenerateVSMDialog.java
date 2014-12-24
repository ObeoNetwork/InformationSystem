package org.obeonetwork.dsl.is.design.generator.ui;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class GenerateVSMDialog extends Dialog {
	
	private Text targetVsmPath;
	private Text configurationFilePath;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public GenerateVSMDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));
		
		Label lblTargetVsm = new Label(container, SWT.NONE);
		lblTargetVsm.setText("Target VSM :");
		
		targetVsmPath = new Text(container, SWT.BORDER);
		targetVsmPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowseVsm = new Button(container, SWT.NONE);
		btnBrowseVsm.setText("Browse...");
		btnBrowseVsm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String vsm = selectVSMFile();
				targetVsmPath.setText(vsm);
			}
		});
		
		Label lblConfigurationFile = new Label(container, SWT.NONE);
		lblConfigurationFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblConfigurationFile.setText("Configuration file :");
		
		configurationFilePath = new Text(container, SWT.BORDER);
		configurationFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowseConfigurationFile = new Button(container, SWT.NONE);
		btnBrowseConfigurationFile.setText("Browse...");
		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	private String selectVSMFile() {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
		dialog.setTitle("Tree Selection");
		dialog.setMessage("Select the elements from the tree:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.open();
		return "coucou";
	}

}
