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
package fr.gouv.mindef.safran.database.ui.actions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

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
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IComparisonAndScopeChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.team.svn.core.resource.ILocalResource;
import org.eclipse.team.svn.ui.compare.ThreeWayResourceCompareInput;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.sqlgen.DatabaseGen;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import fr.gouv.mindef.safran.database.ui.Activator;

@SuppressWarnings("restriction")
/**
 * Action made available when comparing two database models to generate the SQL scripts to corresponding to the EMFCompare comparison.
 * 
 */
public class ExportAsSQLScriptsAction extends Action implements IEditorActionDelegate {
	
	private static final String ACTION_TEXT = "Generate SQL";
	
	private static final String COMPARE_EDITOR_ID = "org.eclipse.compare.CompareEditor";
	
	/**
	 * It listens the add of a "not empty" database comparison result on the compare configuration, in order to enable this action and to retrieve the comparison.
	 */
	private IPropertyChangeListener propertyChangeListener;
	
	private IAction editorPluginAction;
	
	private Object eventBusChangeRecorder;
	
	/**
	 * The database comparison result.
	 */
	private Comparison comparison;

	private IEditorPart activeEditor = null;
	
	public void exportComparison(final Comparison comparison) {
		final IResource containingFolder = getContainingFolder(comparison);
		if(containingFolder == null) {
			// No containing folder means the user aborted the export action
			return;
		}
		
		final File targetFolder = getTargetfolder(containingFolder);
		if (targetFolder == null) {
			return;
		}
		
		// Initialize a resourceset to be sure the model is contained within a resource (or Acceleo will throw a NPE)
		ResourceSet set = new ResourceSetImpl();
		Resource resource = new ResourceImpl();
		resource.getContents().add(comparison);
		set.getResources().add(resource);
		
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				try {
					DatabaseGen databaseGen = new DatabaseGen(comparison, targetFolder, Collections.emptyList());
					databaseGen.doGenerate(new BasicMonitor());
				} catch (IOException e) {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "SQL Generation", "A problem occured during the generation. See Error Log view for more details.");
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
				}
				
				// Refreshing the target folder
				try {
					containingFolder.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
					Activator.getDefault().getLog().log(status);
				}
			}
		};
		
		// Launch operation
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, false, operation);
		} catch (Exception e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "SQL Generation", "A problem occured during the generation. See Error Log view for more details.");
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}
	
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
		return new File(modelFile, "sql");
	}


	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		return ImageDescriptor.createFromImage(Activator.getDefault().getImageRegistry().get(Activator.SQL_FILE_DISABLED_IMAGE));
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.createFromImage(Activator.getDefault().getImageRegistry().get(Activator.SQL_FILE_IMAGE));
	}
	
	public String getText() {
		return ACTION_TEXT;
	}

	public String getToolTipText() {
		return ACTION_TEXT;
	}

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
		this.activeEditor = activeEditor;
		editorPluginAction = action;
		action.setEnabled(false);
		if (activeEditor != null && activeEditor.getEditorSite() != null && COMPARE_EDITOR_ID.equals(activeEditor.getEditorSite().getId())) {
			final IEditorInput editorInput = activeEditor.getEditorInput();
			if (editorInput instanceof CompareEditorInput) {
				final CompareConfiguration config = ((CompareEditorInput)editorInput).getCompareConfiguration();
				if (propertyChangeListener == null) {
					propertyChangeListener = new IPropertyChangeListener() {		
						@Override
						public void propertyChange(PropertyChangeEvent event) {
							// FIX for EMFCompare 2.2
							if (isInitEventBus(event) && eventBusChangeRecorder == null) {			
								
								eventBusChangeRecorder = new EventBusChangeRecorder();
								((EventBus)event.getNewValue()).register(eventBusChangeRecorder);
								
							}
						}
					};
					config.addPropertyChangeListener(propertyChangeListener);
				}
				if (comparison != null) {
					editorPluginAction.setEnabled(areDatabaseDifferences(comparison));
				}
			}
		}
	}

	private boolean isInitEventBus(PropertyChangeEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		return oldValue == null && newValue instanceof EventBus;
	}
	
	private class EventBusChangeRecorder {
		  @Subscribe public void recordCustomerChange(IComparisonAndScopeChange e) {
			  if (editorPluginAction != null) {
				  comparison = (Comparison) e.getNewComparison();
				  if (areDatabaseDifferences(comparison)) {
					  editorPluginAction.setEnabled(true);
				  }
			  }
		  }
	}
	
	/**
	 * Checks whether the given {@link Comparison} is between two {@link DataBase}.
	 * @param comparison
	 * @return
	 */
	private boolean areDatabaseDifferences(Comparison comparison) {
		for (Diff diff : comparison.getDifferences()) {
			Match parentMatch = diff.getMatch();
			while(ComparePackage.Literals.MATCH.isInstance(parentMatch.eContainer())){
				parentMatch = (Match) parentMatch.eContainer();
			}
			EObject left = parentMatch.getLeft(); // Should be DataBase
			EObject right = parentMatch.getRight(); // Should be DataBase
			if (left != null && left.eClass().getEPackage() == DatabasePackage.eINSTANCE
					|| right != null && right.eClass().getEPackage() == DatabasePackage.eINSTANCE) {
				return true;
			}
		}
		return false;
	}

}
