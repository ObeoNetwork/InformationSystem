package org.obeonetwork.dsl.soa.gen.swagger.ui.wizards;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.utils.sirius.session.SessionUtils;
import org.eclipse.swt.widgets.Button;

public class SwaggerImportDialog extends Dialog {

	protected Shell shlImportSwaggerFile;
	private String fileText;
	private String paginationExtensionText;
	private int returnType = SWT.CANCEL;
	private System system;
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SwaggerImportDialog(Shell parent, int style, System system) {
		super(parent, style);
		this.system = system;
		setText("SWT Dialog");
		fileText = null;
		paginationExtensionText = null;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public int open() {
		createContents();
		shlImportSwaggerFile.open();
		shlImportSwaggerFile.layout();
		Display display = getParent().getDisplay();
		while (!shlImportSwaggerFile.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return returnType;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlImportSwaggerFile = new Shell(getParent(), SWT.SHELL_TRIM | SWT.BORDER);
		shlImportSwaggerFile.setSize(450, 165);
		shlImportSwaggerFile.setText("Import swagger file");
		shlImportSwaggerFile.setLayout(new GridLayout(1, false));
		
		Composite mainComposite = new Composite(shlImportSwaggerFile, SWT.NONE);
		mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		mainComposite.setLayout(new GridLayout(1, false));
		
		Composite fileComposite = new Composite(mainComposite, SWT.NONE);
		fileComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		fileComposite.setLayout(new GridLayout(3, false));
		
		Label fileLabel = new Label(fileComposite, SWT.NONE);
		GridData gd_fileLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_fileLabel.widthHint = 114;
		fileLabel.setLayoutData(gd_fileLabel);
		fileLabel.setText("File:");
		
		Text fileTextWidget = new Text(fileComposite, SWT.BORDER);
		fileTextWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button browseButton = new Button(fileComposite, SWT.NONE);
		GridData gd_browseButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_browseButton.widthHint = 92;
		browseButton.setLayoutData(gd_browseButton);
		browseButton.setText("Browse");
		browseButton.addListener(SWT.Selection, (e) -> {
			FileDialog dialog = new FileDialog(getParent(), SWT.OPEN);
			dialog.setFilterExtensions(new String [] { "*.yaml;*.json", "*.yaml", "*.json" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			dialog.setFilterPath(getDefaultInputDirPath(system));
			fileText = dialog.open();
			fileTextWidget.setText(fileText);	
		});
		
		Composite paginationExtensionComposite = new Composite(mainComposite, SWT.NONE);
		paginationExtensionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		paginationExtensionComposite.setLayout(new GridLayout(2, false));
		
		Label paginationExtensionLabel = new Label(paginationExtensionComposite, SWT.NONE);
		GridData gd_paginationExtensionLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_paginationExtensionLabel.widthHint = 114;
		paginationExtensionLabel.setLayoutData(gd_paginationExtensionLabel);
		paginationExtensionLabel.setText("Pagination extension:");
		
		Text paginationExtensionTextWidget = new Text(paginationExtensionComposite, SWT.BORDER);
		paginationExtensionTextWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		paginationExtensionTextWidget.addListener(SWT.KeyUp, (e) -> paginationExtensionText = paginationExtensionTextWidget.getText());
		Composite buttonComposite = new Composite(mainComposite, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		buttonComposite.setLayout(new GridLayout(2, false));
		
		Button cancelButton = new Button(buttonComposite, SWT.NONE);
		GridData gd_cancelButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_cancelButton.widthHint = 92;
		cancelButton.setLayoutData(gd_cancelButton);
		cancelButton.setText("Cancel");
		cancelButton.addListener(SWT.Selection, (e) -> {
			returnType = SWT.CANCEL;
			shlImportSwaggerFile.close();
		});
		
		Button okButton = new Button(buttonComposite, SWT.NONE);
		okButton.setSelection(true);
		GridData gd_okButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okButton.widthHint = 92;
		okButton.setLayoutData(gd_okButton);
		okButton.setText("OK");
		okButton.addListener(SWT.Selection, (e) -> {
			returnType = SWT.OK;		
			shlImportSwaggerFile.close();
		});

	}

	public String getSwaggerFilePath() {
		return fileText;
	}

	public String getPaginationExtension() {
		return paginationExtensionText;
	}

	public String getDefaultInputDirPath(System system) {
		String defaultInputDirPath = null;
		if(system != null) {
			Session session = new EObjectQuery(system).getSession();
			ModelingProject modelingProject = SessionUtils.getModelingProjectFromSession(session);
			defaultInputDirPath = modelingProject.getProject().getLocation().toOSString();
		} else {
			defaultInputDirPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		}

		return defaultInputDirPath;
	}
}
