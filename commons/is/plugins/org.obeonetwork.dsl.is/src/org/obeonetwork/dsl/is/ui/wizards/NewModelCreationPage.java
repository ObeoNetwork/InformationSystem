/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.is.ui.wizards;

import java.lang.reflect.Field;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.tools.internal.views.common.item.ProjectDependenciesItemImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.is.util.SiriusSessionUtils;
import org.obeonetwork.utils.common.ui.services.WizardHelper;

import fr.obeo.dsl.viewpoint.collab.ui.internal.views.ResourcesFolderItemImpl;
import org.eclipse.swt.layout.RowLayout;

@SuppressWarnings("restriction")
public class NewModelCreationPage extends WizardPage {
	private static final Predicate<String> VALID_FILENAME_PATTERN = Pattern.compile("^[^<>:\"/\\\\|?\\*]*$").asPredicate();
	private static final String RESOURCE_DEFAULT_NAME = "My";
	private Text textFilter;
	private StyledText textFileName;
	
	private IStructuredSelection selection;
	private ProjectsAndFoldersContentProvider contentProvider = new ProjectsAndFoldersContentProvider();
	private ProjectsAndFoldersLabelProvider labelProvider = new ProjectsAndFoldersLabelProvider();
	private TreeViewer treeViewer;
	
	private NewModelWizardData data = new NewModelWizardData();
	private String fileExtension;

	public NewModelCreationPage(String pageId, IStructuredSelection selection, String fileExtension) {
		super(pageId);
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
		this.fileExtension = fileExtension;
		
		this.selection = selection;
	}
	
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblFilterTheFolders = new Label(container, SWT.NONE);
		lblFilterTheFolders.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblFilterTheFolders.setText("Filter the folders by name:");
		
		textFilter = new Text(container, SWT.BORDER);
		textFilter.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (treeViewer != null) {
					String filter = textFilter.getText();
					treeViewer.refresh();
					if (filter != null && !filter.isEmpty()) {
						treeViewer.expandAll();
					}
				}
			}
		});
		textFilter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Composite compositeTree = new Composite(container, SWT.NONE);
		compositeTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		compositeTree.setLayout(new TreeColumnLayout());
		
		treeViewer = new TreeViewer(compositeTree, SWT.BORDER);
		treeViewer.setComparator(new ViewerComparator());
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setFilters(new CustomViewerFilter());
		
		Composite compositeNewFolder = new Composite(container, SWT.NONE);
		compositeNewFolder.setLayout(new RowLayout(SWT.HORIZONTAL));
		compositeNewFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Button btnNewFolder = new Button(compositeNewFolder, SWT.NONE);
		btnNewFolder.setText("New folder...");
		btnNewFolder.setEnabled(false);
		btnNewFolder.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				createNewFolder();
			}
		});
		
		Label lblFileName = new Label(container, SWT.NONE);
		lblFileName.setText("File name:");
		
		textFileName = new StyledText(container, SWT.BORDER);
		textFileName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textFileName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				WizardHelper.addExtensionIfMissing(textFileName, NewModelCreationPage.this.fileExtension);
				data.setTargetResourceName(textFileName.getText());
				validatePage();
			}
		});
		
		treeViewer.setInput(ResourcesPlugin.getWorkspace());
		treeViewer.expandToLevel(1);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (treeViewer.getStructuredSelection() == null) {
					data.setTargetContainer(null);
					data.setTargetModelingProject(null);
					btnNewFolder.setEnabled(false);
				} else {
					data.setTargetContainer(treeViewer.getStructuredSelection().getFirstElement());
					data.setTargetModelingProject(contentProvider.getModelingProject(data.getTargetContainer()));
					btnNewFolder.setEnabled(true);
				}
				validatePage();
			}
		});
		
		initSelection();
		initResourceName();
		
		contentProvider.setShell(getShell());
	}
	
	public void validatePage() {
		if(data.getTargetContainer() == null || data.getTargetModelingProject() == null || data.getTargetResourceName() == null) {
			setPageComplete(false);
		}
		// Check if a resource of same name at same location does not already exist
		else if (resourceAlreadyExists(data.getTargetContainer(), data.getTargetResourceName())) {
			setErrorMessage("A resource with the same name already exists at this location");
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);
		}
	}
	
	private void createNewFolder() {
		Object container = data.getTargetContainer();
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					String dialogTitle = "New folder...";
					
					boolean loopAgain = true;
					String name = "New folder";
					while (loopAgain) {
						// Check if project should be loaded
						if (container instanceof IProject) {
							IProject project = (IProject)container;
							Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
							if (optionModelingProject.some()) {
								Session session = SiriusSessionUtils.getSession(project);								
								if (session == null) {
									// Modeling project that should be loaded
									boolean loaded = SiriusSessionUtils.loadModelingProject(project, true, getShell());
									// if project was not loaded we have to exit
									if (!loaded) {
										return;
									}
								}
							}
						}
						
						// Ask for name
						InputDialog dlg = new InputDialog(getShell(), dialogTitle, "Enter name for new folder", name, new IInputValidator() {
							
							@Override
							public String isValid(String newText) {
								// Check if name is valid
								if (!VALID_FILENAME_PATTERN.test(newText)) {
									return "Invalid name";
								}
								
							    // Check if name already exists
								if (resourceAlreadyExists(container, newText)) {
									return "A folder with this name already exists";
								}
								return null;
							}
						});
						if (dlg.open() == Window.OK) {
							name = dlg.getValue();
							
							if (container instanceof IFolder) {
								IFolder parentFolder = (IFolder)container;
								IContainer newFolder = doCreateFolder(parentFolder, name, monitor);
								loopAgain = (newFolder == null);
							} else if (container instanceof CDOResourceFolder) {
								CDOResourceFolder parentFolder = (CDOResourceFolder)container;
								CDOResourceFolder newFolder = doCreateFolder(parentFolder, name, monitor);
								loopAgain = (newFolder == null);
							} else if (container instanceof IProject) {
								IProject project = (IProject)container;
								Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
								if (optionModelingProject.some()) {
									ModelingProject modelingProject = optionModelingProject.get();
									Session session = modelingProject.getSession();
									
									boolean isShared = SiriusSessionUtils.isSharedModelingProjectSession(session);									
									if (isShared) {
										// Shared project
										CDOResourceFolder rootFolder = SiriusSessionUtils.getRemoteRootFolder(session);
										if (rootFolder != null) {
											CDOResourceFolder newFolder = doCreateFolder(modelingProject, rootFolder, name, monitor);
											loopAgain = (newFolder == null);
										}
									} else {
										IContainer newFolder = doCreateFolder(project, name, monitor);
										loopAgain = (newFolder == null);
									}
								} else {
									// Non modeling project
									IContainer newFolder = doCreateFolder(project, name, monitor);
									loopAgain = (newFolder == null);
								}
								
							}
						} else {
							loopAgain = false;
						}
					}
				}
			});
		} catch (Exception e) {
			// Do nothing special
		}
	}
	
	private IContainer doCreateFolder(IContainer parentFolder, String name, IProgressMonitor monitor) {
		String dialogTitle = "New folder...";
		IFolder folder = parentFolder.getFolder(new Path(name));
		// Check folder does not already exist
		if (folder.exists()) {
			MessageDialog.openError(getShell(), dialogTitle, "A folder with this name already exists");
		} else {
			try {
				folder.create(false, true, monitor);
				// Refresh tree
				treeViewer.refresh(parentFolder);
				setTreeSelection(folder);
				return folder;
			} catch (CoreException e) {
				MessageDialog.openError(getShell(), dialogTitle, "Folder could not be created : " + e.getMessage());
			}
		}
		return null;
	}
	
	private CDOResourceFolder doCreateFolder(CDOResourceFolder parentFolder, String name, IProgressMonitor monitor) {
		IProject project = contentProvider.getSharedModelingProject(parentFolder);
		if (project != null) {
			Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
			if (optionModelingProject.some()) {
				return doCreateFolder(optionModelingProject.get(), parentFolder, name, monitor);
			}
		}
		
		return null;
	}
	
	private CDOResourceFolder doCreateFolder(ModelingProject modelingProject, CDOResourceFolder parentFolder, String name, IProgressMonitor monitor) {
		String dialogTitle = "New folder...";
		Session session = modelingProject.getSession();
		if (session != null) {
			try {
				CDOResourceFolder folder = parentFolder.addResourceFolder(name);
				session.save(monitor);
				// Refresh tree
				treeViewer.refresh(modelingProject.getProject());
				setTreeSelection(folder);
				return folder;
			} catch (Exception e) {
				MessageDialog.openError(getShell(), dialogTitle, "Folder could not be created : " + e.getMessage());	
			}			
		}
		return null;
	}
	
	private void initSelection() {
		if (selection != null) {
			setTreeSelection(selection.getFirstElement());
		}
	}
	
	private void setTreeSelection(Object selectedElement) {
		Object target = getElementToSelect(selectedElement);
		
		if (target != null) {
			IStructuredSelection sel = new StructuredSelection(target);
			treeViewer.setSelection(sel, true);
		}
	}
	
	private Object getElementToSelect(Object element) {
		Object target = null;
		
		if (element instanceof IContainer) {
			// Project or folder, the element can be automatically selected
			target = element;
		} else if (element instanceof CDOResourceFolder) {
			target = element;
		} else if (element instanceof ResourcesFolderItemImpl) {
			// ResourcesFolderItemImpl we have to retrieve the corresponding CDOResourceFolder
			target = getFolder((ResourcesFolderItemImpl)element);
		} else if (element instanceof CDOResource) {
			target = ((CDOResource) element).getFolder();
		} else if (element instanceof IFile) {
			target = ((IFile) element).getParent();
		} else if (element instanceof ProjectDependenciesItemImpl) {
			target = ((ProjectDependenciesItemImpl)element).getProject();
		} else if (element instanceof EObject) {
			target = getElementToSelect(((EObject) element).eResource());
		} else if (element instanceof Resource) {
			// Resource but not CDO Resource
			// We have to get the corresponding IFile
			URI uri = ((Resource)element).getURI();
			if (uri.isPlatformResource()) {
				String platformString = uri.toPlatformString(true);
				IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
				if (member instanceof IFile) {
					return getElementToSelect(member);
				}
			}
		}
		return target;
	}
	
	private void initResourceName() {
		String resourceName = RESOURCE_DEFAULT_NAME + getFileExtension();
		Object container = getData().getTargetContainer();
		// Try to find an available resource name
		for (int i = 1; resourceAlreadyExists(container, resourceName) && i < 1000; i++) {
			resourceName = RESOURCE_DEFAULT_NAME + i + getFileExtension();
		}
		textFileName.setText(resourceName);
		
		int dotIndex = textFileName.getText().lastIndexOf(".");
		if(dotIndex != -1) {
			StyleRange styleRange = new StyleRange();
			styleRange.start = dotIndex;
			styleRange.length = textFileName.getText().length() - dotIndex;
			styleRange.fontStyle = SWT.ITALIC;
			styleRange.foreground = new Color(125, 125, 125);
			textFileName.setStyleRange(styleRange);
		}
	}
	
	private boolean resourceAlreadyExists(Object container, String resourceName) {
		if (resourceName == null || resourceName.isEmpty()) {
			return false;
		}
		if (container instanceof IProject) {
			// Several cases here :
			// - non modeling project => same test as for a container
			// - modeling project, non shared => same test as for a container
			// - shared modeling project => we have to check contents of the root remote folder (which is not visible in the tree)
			// We try to get a remote root folder, it we don't get any it could mean that the project is not shared
			// or that the session has not yet been loaded
			// This last case will be cover by the wizard performFinish() method
			IProject project = (IProject)container;
			Session session = SiriusSessionUtils.getSession(project);
			CDOResourceFolder remoteRootFolder = SiriusSessionUtils.getRemoteRootFolder(session);
			if (remoteRootFolder != null) {
				return remoteResourceAlreadyExistsInFolder(remoteRootFolder, resourceName);
			} else {
				return localResourceAlreadyExistsInContainer(project, resourceName);
			}
		} else if (container instanceof IContainer) {
			return localResourceAlreadyExistsInContainer((IContainer)container, resourceName);
		} else if (container instanceof CDOResourceFolder) {
			return remoteResourceAlreadyExistsInFolder((CDOResourceFolder) container, resourceName);
		}
		return false;
	}
	
	private boolean remoteResourceAlreadyExistsInFolder(CDOResourceFolder folder, String resourceName) {
		return folder.getNode(resourceName) != null;
	}
	
	private boolean localResourceAlreadyExistsInContainer(IContainer container, String resourceName) {
		IResource member = container.findMember(resourceName);
		return member != null && member.exists();
	}
	
	private CDOResourceFolder getFolder(ResourcesFolderItemImpl item) {
		try {
			Field f = item.getClass().getDeclaredField("cdoResourceFolder");
			f.setAccessible(true);
			Object value = f.get(item);
			if (value instanceof CDOResourceFolder) {
				return (CDOResourceFolder)value;
			}
		} catch (Exception e) {
			// Do nothing
		}
		return null;
	}
	
	private class CustomViewerFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (containsFilter(element)) {
				return true;
			} else {
				for (Object child : contentProvider.getChildren(element)) {
					if (select(viewer, element, child)) {
						return true;
					}
				}
				return false;
			}
		}

		private boolean containsFilter(Object element) {
			String filter = textFilter.getText();
			String label = labelProvider.getText(element);
			return label.contains(filter);
		}
	}
	
	public String getFileExtension() {
		return this.fileExtension;
	}

	public NewModelWizardData getData() {
		return data;
	}

	public void setData(NewModelWizardData data) {
		this.data = data;
	}

	public ProjectsAndFoldersContentProvider getContentProvider() {
		return contentProvider;
	}
	
}
