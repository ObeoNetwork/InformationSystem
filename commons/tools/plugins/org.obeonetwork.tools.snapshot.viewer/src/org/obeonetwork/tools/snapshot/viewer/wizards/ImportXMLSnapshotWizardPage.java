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
package org.obeonetwork.tools.snapshot.viewer.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.databinding.viewers.typed.ViewerProperties;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.tools.snapshot.viewer.Activator;
import org.obeonetwork.tools.snapshot.viewer.EmbeddedCDOServer;

/**
 * Wizard page allowing one to :
 * - choose a XML file which is loaded into a new embedded CDO server
 * - select one of the remote projects
 * - define a name for the local projet to be imported
 * 
 * @author Obeo
 *
 */
public class ImportXMLSnapshotWizardPage extends WizardPage {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	private Text txtXmlFile;
	private Text txtLocalProject;
	private Combo comboRemoteProject;
	private ComboViewer comboRemoteProjectViewer;
	
	private ImportXmlInput inputData = new ImportXmlInput();
	
	private Collection<URI> remoteProjectsURIs = new ArrayList<URI>();
	
	private EmbeddedCDOServer embeddedServer = new EmbeddedCDOServer();

	/**
	 * Create the wizard.
	 */
	public ImportXMLSnapshotWizardPage() {
		super("importXMLSnapshot");
		setTitle("Import XML snapshot");
		setDescription("This wizard creates a modeling project from an XML snapshot.");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblXmlFile = new Label(container, SWT.NONE);
		lblXmlFile.setText("XML File :");
		
		txtXmlFile = new Text(container, SWT.BORDER);
		txtXmlFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				dialog.setFilterExtensions(new String [] {"*.xml", "*.*"});
				String selectedXmlFile = dialog.open();
				if (selectedXmlFile != null) {
					txtXmlFile.setText(selectedXmlFile);
					
					// Try to start a server and load this file
					loadXmlFile();
					
					// remoteProjectsURIs have been set by previous method
					comboRemoteProjectViewer.setInput(remoteProjectsURIs);
					
					// select the first project
					if (!remoteProjectsURIs.isEmpty()) {
						comboRemoteProjectViewer.setSelection(new StructuredSelection(remoteProjectsURIs.iterator().next()), true);
					}
				}
			}
		});
		btnBrowse.setText("Load file...");
		
		Label lblRemoteProject = new Label(container, SWT.NONE);
		lblRemoteProject.setText("Remote project :");
		
		comboRemoteProjectViewer = new ComboViewer(container, SWT.NONE);
		comboRemoteProjectViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboRemoteProjectViewer.setLabelProvider(new LabelProvider());
		comboRemoteProjectViewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// update local project name field
				ISelection selection = event.getSelection();
				if (selection instanceof StructuredSelection) {
					Object firstElement = ((StructuredSelection) selection).getFirstElement();
					if (firstElement instanceof URI) {
						String projectName = getProjectNameFromURI((URI)firstElement);
						if (projectName != null) {
							txtLocalProject.setText(projectName);
						}
					}
				}
			}
		});
		comboRemoteProject = comboRemoteProjectViewer.getCombo();
		comboRemoteProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblLocalProjectName = new Label(container, SWT.NONE);
		lblLocalProjectName.setText("Local project name :");
		
		txtLocalProject = new Text(container, SWT.BORDER);
		txtLocalProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String projectName = txtLocalProject.getText();
				boolean projectExists = projectExists(projectName);
				setPageComplete(!projectExists);
				if (projectExists) {
					setErrorMessage("A local project with this name or the corresponding folder already exists.");
				} else {
					setErrorMessage(null);
				}
			}
		});
		txtLocalProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		m_bindingContext = initDataBindings();
	}
	
	public String getProjectNameFromURI(URI uri) {
		if (uri != null) {
			return uri.segment(0);
		}
		return null;
	}
	
	private boolean projectExists(String projectName) {
		if (projectName != null && !projectName.isEmpty()) {			
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project != null && project.exists()) {
				return true;
			}
			
			IPath workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			IPath fullPath = workspacePath.append(projectName);
			File file = fullPath.toFile();
			return file.exists();
		}
		return false;
	}
	
	private void loadXmlFile() {
		try {
			getContainer().run(true, false, new IRunnableWithProgress() {
				
				@Override
				public void run(IProgressMonitor parentMonitor) throws InvocationTargetException, InterruptedException {
					SubMonitor monitor = SubMonitor.convert(parentMonitor, 100);
					monitor.setTaskName("Loading XML file into embedded server");
					
					// First we have to stop the server in case it was previously used to load a file
					embeddedServer.stop();
					
					String xmlFile = inputData.getXmlFile();
					if (xmlFile != null && !xmlFile.trim().isEmpty()) {
						try {
							embeddedServer.start(new File(xmlFile), monitor.newChild(90));
							remoteProjectsURIs = embeddedServer.getRemoteProjectsURIs(monitor.newChild(10));
						} catch (Exception e) {
							getShell().getDisplay().asyncExec(new Runnable() {
								@Override
								public void run() {
									setErrorMessage("The selected file could not be loaded. See error log for more informations.");									
								}
							});
							Activator.logError("The selected file could not be loaded.", e);
							monitor.done();
						}
						
					}
				}
			});
		} catch (Exception e) {
			setErrorMessage("Error while loading XML file. See error log for more informations.");
			Activator.logError("Error while loading XML file.", e);
		}
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	public EmbeddedCDOServer getServer() {
		return embeddedServer;
	}
	
	public ImportXmlInput getInputData() {
		return inputData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtXmlFileObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtXmlFile);
		IObservableValue xmlFileInputDataObserveValue = PojoProperties.value("xmlFile").observe(inputData);
		bindingContext.bindValue(observeTextTxtXmlFileObserveWidget, xmlFileInputDataObserveValue, null, null);
		//
		IObservableValue observeTextTxtLocalProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtLocalProject);
		IObservableValue localProjectNameInputDataObserveValue = PojoProperties.value("localProjectName").observe(inputData);
		bindingContext.bindValue(observeTextTxtLocalProjectObserveWidget, localProjectNameInputDataObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionComboRemoteProjectViewer = ViewerProperties.singleSelection().observe(comboRemoteProjectViewer);
		IObservableValue remoteProjectURIInputDataObserveValue = PojoProperties.value("remoteProjectURI").observe(inputData);
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		bindingContext.bindValue(observeSingleSelectionComboRemoteProjectViewer, remoteProjectURIInputDataObserveValue, strategy_1, strategy);
		//
		return bindingContext;
	}
}
