/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.svn.core.resource.ILocalResource;
import org.eclipse.team.svn.ui.compare.ThreeWayResourceCompareInput;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;

import fr.gouv.mindef.safran.database.ui.Activator;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;

public abstract class AbstractExportAsAction extends Action implements IEditorActionDelegate {

	private static final String COMPARE_RESULT_PROPERTY = "org.eclipse.emf.compare.ide.ui.COMPARE_RESULT";
	
	private static final String COMPARE_EDITOR_ID = "org.eclipse.compare.CompareEditor";
	
	/**
	 * It listens the add of a "not empty" database comparison result on the compare configuration, in order to enable this action and to retrieve the comparison.
	 */
//	private IPropertyChangeListener propertyChangeListener;
	
	private IAction editorPluginAction;
	
//	private Object eventBusChangeRecorder;
	
	private CompareConfiguration compareConfig;
	
	/**
	 * The database comparison result.
	 */
	private Comparison comparison;

	private IEditorPart activeEditor = null;
	
	public void exportComparison(final Comparison comparison) {
		final IResource containingFolder = getContainingFolder(comparison);
		if(containingFolder == null) {
			// No containing folder means the user aborted the export action
			return ;
		}
		
		final File targetFolder = getTargetfolder(containingFolder);
		
		// Initialize a resourceset to be sure the model is contained within a resource (or Acceleo will throw a NPE)
		ResourceSet set = new ResourceSetImpl();
		Resource resource = new ResourceImpl();
		resource.getContents().add(comparison);
		set.getResources().add(resource);
		
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				try {
					IStatus status = doGenerateScripts(comparison, targetFolder);
					if (!status.isOK()) {
						Activator.getDefault().getLog().log(status);
						Display.getDefault().asyncExec(() -> {
							ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									"Generation result", "Some errors/warnings occured during generation", status);
						});
					} else {
						Display.getDefault().asyncExec(() -> {
							MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
									"Database Generation", 
									"Generation success. Generated files are in \n" + 
									targetFolder.toString() + "\n" +
									getSuccessInformationAddendum());
						});
					}
				} catch (IOException e) {
					
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
					Display.getDefault().asyncExec(() -> {
						MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Database Generation", "A problem occured during the generation. See Error Log view for more details.");
					});
				}
				
				// Refreshing the target folder
				try {
					containingFolder.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					IStatus status = Activator.createErrorStatus("Error during refreshing tree fodler", e);
					Activator.getDefault().getLog().log(status);
				}
			}

			
		};
		
		// Launch operation
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, false, operation);
		} catch (Exception e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "SQL Generation", "A problem occured during the generation. See Error Log view for more details.");
			Activator.getDefault().getLog().log( new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
		
	}
	
	protected abstract IStatus doGenerateScripts(final Comparison comparison, final File targetFolder) throws IOException;
	
	protected abstract String getSuccessInformationAddendum();
	
	private IResource getContainingFolder(Comparison comparison) {
		if (comparison.getMatches() != null && comparison.getMatches().isEmpty() == false) {
			Match match = comparison.getMatches().get(0);
			Resource resource = match.getLeft().eResource();
			if (resource instanceof CDOResource) {
				return getModelingProject(resource);
			} else if(resource.getURI().isPlatformResource()) {
				String uri = resource.getURI().toPlatformString(true);
				Path path = new Path(uri);
				return ResourcesPlugin.getWorkspace().getRoot().getFile(path).getParent();
			} else if(activeEditor.getEditorInput() instanceof ThreeWayResourceCompareInput) {
				// The resource is a SVN resource
				try {
					IEditorInput editorInput = activeEditor.getEditorInput();
					Field localField = editorInput.getClass().getDeclaredField("local");
					localField.setAccessible(true);
					ILocalResource local = (ILocalResource) localField.get(editorInput);
					return local.getResource().getParent();
				} catch (ReflectiveOperationException e) {
					// The fallback case below will apply
				} catch (SecurityException e) {
					// The fallback case below will apply
				} catch (IllegalArgumentException e) {
					// The fallback case below will apply
				}
			}
			
			// Fallback case
			
			ContainerSelectionDialog projectSelectionDialog = new ContainerSelectionDialog(
					activeEditor.getSite().getShell(), null, false, "Sélectionner le projet de destination :");
			
			projectSelectionDialog.setTitle("Sélection de projet");

			if(projectSelectionDialog.open() == ContainerSelectionDialog.OK && projectSelectionDialog.getResult().length == 1) {
				Path projectPath = (Path) projectSelectionDialog.getResult()[0];
				IResource selectedResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
				if(selectedResource instanceof IProject) {
					return selectedResource;
				}
			}
			
		}
		return null; 
	}
	
	private IResource getModelingProject(Resource resource) {
		Session session = SessionManager.INSTANCE.getSession(resource);
		if (session != null) {
			Resource airdResource = session.getSessionResource();
			String uri = airdResource.getURI().toPlatformString(true);
			Path path = new Path(uri);
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path).getParent();
		}
		return null;
	}
	
	private File getTargetfolder(IResource containingFolder) {
		File modelFile = containingFolder.getLocation().toFile();
		return new File(modelFile,getMainFolderName() );
	}
	
	protected abstract String getMainFolderName();


	@Override
	public void run(IAction action) {
		if (comparison != null) {
			exportComparison(comparison);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
	}
	
	@Override
	public void setActiveEditor(final IAction action, final IEditorPart activeEditor) {
		// Editor changed ?
		if (this.activeEditor != null && this.activeEditor == activeEditor) {
			return;
		}

		// Editor has changed ?
		this.activeEditor = activeEditor;
		this.editorPluginAction = action;
		this.editorPluginAction.setEnabled(false);
		if (activeEditor != null && activeEditor.getEditorSite() != null && COMPARE_EDITOR_ID.equals(activeEditor.getEditorSite().getId())) {
			
			attachListenerToCompareconfiguration();
			
			// Attach listener to know when editor is reused for another comparison
			activeEditor.addPropertyListener(new IPropertyListener() {
				
				@Override
				public void propertyChanged(Object source, int propId) {
					// Editor input changed
					if (propId == IWorkbenchPartConstants.PROP_INPUT) {
						attachListenerToCompareconfiguration();
					}
				}
			});
		}
	}
	
	private void attachListenerToCompareconfiguration() {
		final IEditorInput editorInput = activeEditor.getEditorInput();
		if (editorInput instanceof CompareEditorInput) {
			final CompareConfiguration config = ((CompareEditorInput)editorInput).getCompareConfiguration();
			if (config != this.compareConfig) {
				this.compareConfig = config;
				this.compareConfig.addPropertyChangeListener(new NewComparisonResultPropertyChangeListener());
			}
		}
	}
	
	private class NewComparisonResultPropertyChangeListener implements IPropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent event) {
			if (COMPARE_RESULT_PROPERTY.equals(event.getProperty())) {
				Object newValue = event.getNewValue();
				if (newValue instanceof Comparison) {
					comparison = (Comparison)newValue;
				} else {
					comparison = null;
				}
				editorPluginAction.setEnabled(areDatabaseDifferences(comparison));
			}
		}
	}
	
	/**
	 * Checks whether the given {@link Comparison} is between two {@link DataBase}.
	 * @param comparison
	 * @return
	 */
	private boolean areDatabaseDifferences(Comparison comparison) {
		if (comparison == null) {
			return false;
		}
		for (Diff diff : comparison.getDifferences()) {
			Match parentMatch = diff.getMatch();
			while(ComparePackage.Literals.MATCH.isInstance(parentMatch.eContainer())){
				parentMatch = (Match) parentMatch.eContainer();
			}
			EObject left = parentMatch.getLeft(); // Should be DataBase
			EObject right = parentMatch.getRight(); // Should be DataBase
			
			// Right and left should be from the database package
			if (left == null || left.eClass().getEPackage() != DatabasePackage.eINSTANCE
					|| right == null || right.eClass().getEPackage() != DatabasePackage.eINSTANCE) {
				return false;
			}
			
			// Should be disabled for Logical and not Physical types libraries
			if (ScaffoldingUtils.isValidInputForMpd(left) && ScaffoldingUtils.isValidInputForMpd(right)) {
				return true;
			}
			
		}
		return false;
	}

}

