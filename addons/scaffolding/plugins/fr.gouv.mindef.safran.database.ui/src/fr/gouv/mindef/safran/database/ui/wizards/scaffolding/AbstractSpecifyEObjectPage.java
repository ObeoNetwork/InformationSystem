/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.dialogs.FileExtensionsViewerFilter;
import fr.gouv.mindef.safran.database.ui.wizards.scaffolding.newmodel.INewModelWizard;


public abstract class AbstractSpecifyEObjectPage extends WizardPage {
	private boolean sourcePage;
	private String initialModelFilename;
	private Label lblError;
	private Text textModelFile;
	private TreeViewer treeViewer;
	private URI selectedElementURI;

	/**
	 * Create the wizard.
	 */
	public AbstractSpecifyEObjectPage(String pageName, boolean sourcePage) {
		super(pageName);
		this.sourcePage = sourcePage;
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		if (sourcePage == true) {
			container.setLayout(new GridLayout(3, false));
		} else {
			container.setLayout(new GridLayout(4, false));
		}
			
		lblError = new Label(container, SWT.NONE);
		lblError.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		if (sourcePage == true) {
			lblError.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		} else {
			lblError.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		}
		
		Label lblFile = new Label(container, SWT.NONE);
		lblFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFile.setText("File :");
		
		textModelFile = new Text(container, SWT.BORDER);
		textModelFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.setText("Browse...");
		
		if (sourcePage != true) {
			Button btnNew = new Button(container, SWT.NONE);
			btnNew.setText("New...");
			btnNew.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					INewModelWizard wizard = getNewModelWizard();
					
					IWorkbench workbench = PlatformUI.getWorkbench();
					wizard.init(workbench, new StructuredSelection());
					
					// Instantiates the wizard container with the wizard and opens it
					WizardDialog dialog = new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard);
					dialog.create();
					dialog.open();
					
					// Updates the text widget with the newly created model
					IFile createdFile = wizard.getCreatedFile();
					if (createdFile != null && createdFile.exists()) {
						textModelFile.setText(createdFile.getFullPath().toString());
					}
				}
			});
		}
		
		Label lblElement = new Label(container, SWT.NONE);
		lblElement.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblElement.setText(getTreeLabel());
		
		treeViewer = new TreeViewer(container, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		if (sourcePage == true) {
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		} else {
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		}
		
		treeViewer.setContentProvider(getTreeContentProvider());
		treeViewer.setLabelProvider(getTreeLabelProvider());
		ViewerFilter filter = getTreeViewerFilter();
		if (filter != null) {
			treeViewer.addFilter(filter);
		}
		
		// Check if the initial input can be used as a valid filename
		if (initialModelFilename != null) {
			textModelFile.setText(initialModelFilename);
			initTreeViewer(initialModelFilename);
			handleTreeElementSelection(treeViewer.getSelection());
		}
		
		textModelFile.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				selectedElementURI = null;
				initTreeViewer(textModelFile.getText());
				getWizard().getContainer().updateButtons();
			}
		});
		
		btnBrowse.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				List<ViewerFilter> viewerFilters = new ArrayList<ViewerFilter>();
				viewerFilters.add(new FileExtensionsViewerFilter(getFileExtensions()));
				IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(
											getShell(),
											"Select file", getFileSelectionMessage(),
											false, new Object[]{textModelFile.getText()}, viewerFilters);
				if (selectedFiles.length > 0) {
					textModelFile.setText(selectedFiles[0].getFullPath().toString());
				}
			}
		});
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				if(!event.getSelection().isEmpty()) {
					handleTreeElementSelection(event.getSelection());
				}
				getWizard().getContainer().updateButtons();
			}
		});
	}
	
	protected void handleTreeElementSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Object selectedElement = structuredSelection.getFirstElement();
			if (canBeSelected(selectedElement)) {
				displayError("");
				EObject selectedEObject = (EObject)selectedElement;
				selectedElementURI = selectedEObject.eResource().getURI();
				selectedElementURI = selectedElementURI.appendFragment(selectedEObject.eResource().getURIFragment(selectedEObject));
			} else {
				displayError(getInvalidSelectionMessage());
				selectedElementURI = null;
			}
		}
	}
	
	protected void initTreeViewer(String modelFilename) {
		Resource resource = loadResource(modelFilename);
		if (resource == null) {
			displayError("The file could not be loaded");
		} else {
			displayError("");
		}
		treeViewer.setInput(resource);
		
		if (selectedElementURI != null) {
			EObject firstItem = resource.getResourceSet().getEObject(selectedElementURI, true);
			treeViewer.setSelection(new StructuredSelection(firstItem));
		} else {
			// Set selection on the first item
			if (resource.getContents().size() > 0) {
				EObject firstItem = resource.getContents().get(0);
				treeViewer.setSelection(new StructuredSelection(firstItem));
			}
		}
	}
	
	public void setInitialModelFilename(String modelFilename) {
		initialModelFilename = modelFilename;
	}
	
	public void setInitialInput(IFile file, ScaffoldType scaffoldType) {
		if (file == null) return;
		// Check if the file is a ScaffoldInfo model
		if ("scaffold".equals(file.getFileExtension())) {
			Resource scaffoldResource = loadResource(file.getFullPath().toString());
			if (scaffoldResource.getContents().isEmpty() == false) {
				EObject scaffoldRoot = scaffoldResource.getContents().get(0);
				if (scaffoldRoot instanceof ScaffoldInfo) {
					ScaffoldInfo scaffoldInfo = (ScaffoldInfo) scaffoldRoot;
					EObject object = (sourcePage == true)
							? scaffoldInfo.getStartingObjectForTransformation(scaffoldType)
							: scaffoldInfo.getEndingObjectForTransformation(scaffoldType);
					setInitialModelFilename(object.eResource().getURI().toPlatformString(true));
					selectedElementURI = EcoreUtil.getURI(object);
				}
			}
		} else if (Arrays.asList(getFileExtensions()).contains(file.getFileExtension())) {
			// Check if the file extension is allowed
			setInitialModelFilename(file.getFullPath().toString());
		}
	}
	
	@Override
	public boolean isPageComplete() {
		return selectedElementURI != null && super.isPageComplete();
	}

	protected Resource loadResource(String resourcePath) {
		URI uri = URI.createPlatformResourceURI(resourcePath, true);
		ResourceSet set = new ResourceSetImpl();
		if(set.getURIConverter().exists(uri, Collections.emptyMap())) {
			Resource resource = set.getResource(uri, true);
			if (resource != null) {
				return resource;
			}
		}
		return null;
	}
	
	protected void displayError(String message) {
		lblError.setText(message);
	}
	
	protected String getFileSelectionMessage() {
		StringBuilder message = new StringBuilder("Select a file");
		String[] extensions = getFileExtensions();
		if (extensions.length > 0) {
			message.append(" (");
		}
		for (String extension : extensions) {
			message.append("*.");
			message.append(extension);
			message.append(",");
		}
		// Remove last ","
		message.deleteCharAt(message.length() - 1);
		if (extensions.length > 0) {
			message.append(")");
		}
		return message.toString();
	}
	
	protected abstract String[] getFileExtensions();

	protected abstract String getTreeLabel();
	
	protected abstract IContentProvider getTreeContentProvider();
	protected abstract IBaseLabelProvider getTreeLabelProvider();
	protected ViewerFilter getTreeViewerFilter() {
		return null;
	}
	protected boolean canBeSelected(Object element) {
		return element instanceof EObject && canBeSelectedInTree((EObject)element);
	}
	protected abstract boolean canBeSelectedInTree(EObject element);
	protected abstract INewModelWizard getNewModelWizard();
	protected abstract String getInvalidSelectionMessage();
	
	public URI getSelectedElementURI() {
		return selectedElementURI;
	}
	public String getModelFilePath() {
		return textModelFile.getText();
	}
}
