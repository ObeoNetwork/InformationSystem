/**
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.dsl.database.presentation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.emf.common.CommonPlugin;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xmi.XMLResource;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.ui.actions.WorkspaceModifyOperation;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.provider.DatabaseEditPlugin;


import org.eclipse.core.runtime.Path;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DatabaseModelWizard extends Wizard implements INewWizard {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2008, 2023 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v2.0\r\nwhich accompanies this distribution, and is available at\r\nhttps://www.eclipse.org/legal/epl-2.0/\r\n\r\nContributors:\r\n    Obeo - initial API and implementation";

	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
		Collections.unmodifiableList(Arrays.asList(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
		DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabasePackage databasePackage = DatabasePackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseFactory databaseFactory = databasePackage.getDatabaseFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the initial object creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<String> initialObjectNames;

	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(DatabaseEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(DatabaseEditorPlugin.INSTANCE.getImage("full/wizban/NewDatabase")));
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : databasePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return initialObjectNames;
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObject createInitialModel() {
		EClass eClass = (EClass)databasePackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
		EObject rootObject = databaseFactory.create(eClass);
		return rootObject;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
							ResourceSet resourceSet = new ResourceSetImpl();

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

							// Create a resource for this file.
							//
							Resource resource = resourceSet.createResource(fileURI);

							// Add the initial model object to the contents.
							//
							EObject rootObject = createInitialModel();
							if (rootObject != null) {
								resource.getContents().add(rootObject);
							}

							// Save the contents of the resource to the file system.
							//
							Map<Object, Object> options = new HashMap<Object, Object>();
							options.put(XMLResource.OPTION_ENCODING, "UTF-8");
							resource.save(options);
						}
						catch (Exception exception) {
							DatabaseEditorPlugin.INSTANCE.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
					(new FileEditorInput(modelFile),
					 workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), DatabaseEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			DatabaseEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class DatabaseModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public DatabaseModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		protected boolean validatePage() {
			if (super.validatePage()) {
				String extension = new Path(getFileName()).getFileExtension();
				if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
					String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
					setErrorMessage(DatabaseEditorPlugin.INSTANCE.getString(key, new Object [] { FORMATTED_FILE_EXTENSIONS }));
					return false;
				}
				return true;
			}
			return false;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}

	/**
	 * This is the page where the type of object to create is selected.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class DatabaseModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Combo initialObjectField;

		/**
		 * @generated
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 */
		protected List<String> encodings;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Combo encodingField;

		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public DatabaseModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText(DatabaseEditorPlugin.INSTANCE.getString("_UI_ModelObject"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}

			initialObjectField = new Combo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				initialObjectField.setLayoutData(data);
			}

			for (String objectName : getInitialObjectNames()) {
				initialObjectField.add(getLabel(objectName));
			}

			if (initialObjectField.getItemCount() == 1) {
				initialObjectField.select(0);
			}
			initialObjectField.addModifyListener(validator);

			Label encodingLabel = new Label(composite, SWT.LEFT);
			{
				encodingLabel.setText(DatabaseEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				encodingLabel.setLayoutData(data);
			}
			encodingField = new Combo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				encodingField.setLayoutData(data);
			}

			for (String encoding : getEncodings()) {
				encodingField.add(encoding);
			}

			encodingField.select(0);
			encodingField.addModifyListener(validator);

			setPageComplete(validatePage());
			setControl(composite);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected ModifyListener validator =
			new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					setPageComplete(validatePage());
				}
			};

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected boolean validatePage() {
			return getInitialObjectName() != null && getEncodings().contains(encodingField.getText());
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			if (visible) {
				if (initialObjectField.getItemCount() == 1) {
					initialObjectField.clearSelection();
					encodingField.setFocus();
				}
				else {
					encodingField.clearSelection();
					initialObjectField.setFocus();
				}
			}
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getInitialObjectName() {
			String label = initialObjectField.getText();

			for (String name : getInitialObjectNames()) {
				if (getLabel(name).equals(label)) {
					return name;
				}
			}
			return null;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getEncoding() {
			return encodingField.getText();
		}

		/**
		 * Returns the label for the specified type name.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected String getLabel(String typeName) {
			try {
				return DatabaseEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			}
			catch(MissingResourceException mre) {
				DatabaseEditorPlugin.INSTANCE.log(mre);
			}
			return typeName;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Collection<String> getEncodings() {
			if (encodings == null) {
				encodings = new ArrayList<String>();
				for (StringTokenizer stringTokenizer = new StringTokenizer(DatabaseEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) {
					encodings.add(stringTokenizer.nextToken());
				}
			}
			return encodings;
		}
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
		@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new DatabaseModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseModelWizard_label"));
		newFileCreationPage.setDescription(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseModelWizard_description"));
		newFileCreationPage.setFileName(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new DatabaseModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(DatabaseEditorPlugin.INSTANCE.getString("_UI_DatabaseModelWizard_label"));
		initialObjectCreationPage.setDescription(DatabaseEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

	/**
	 * Get the file from the page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

}
