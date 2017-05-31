/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DAnalysisSessionEObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.ui.Activator;
import fr.gouv.mindef.safran.database.ui.wizards.scaffolding.ScaffoldingOperation;

public class ScaffoldingUtils {
	
	public static ScaffoldInfo getScaffoldInfoFromSelection(Object selectedElement) {
		if (selectedElement instanceof Resource) {
			Resource emfResource = (Resource)selectedElement;
			if (emfResource != null && emfResource.getContents() != null && emfResource.getContents().isEmpty() == false) {
				EObject root = emfResource.getContents().get(0);
				if (root instanceof ScaffoldInfo) {
					return (ScaffoldInfo)root;
				}
			}
		} else if (selectedElement instanceof EObject) {
			return getScaffoldInfo((EObject)selectedElement);
		} else if (selectedElement instanceof IFile) {
			URI modelURI = URI.createPlatformResourceURI(((IFile)selectedElement).getFullPath().toString(), true);
			Resource emfResource = ScaffoldingUtils.getResourceFromSession(modelURI);
			if (emfResource != null && emfResource.getContents() != null && emfResource.getContents().isEmpty() == false) {
				EObject root = emfResource.getContents().get(0);
				if (root instanceof ScaffoldInfo) {
					return (ScaffoldInfo)root;
				}
			}
		}
		return null;
	}
	
	private static ScaffoldInfo getScaffoldInfo(EObject object) {
		if (object == null) {
			return null;
		} else if (object instanceof ScaffoldInfo) {
			return (ScaffoldInfo)object;
		} else {
			EObject parent = object.eContainer();
			return getScaffoldInfo(parent);
		}
	}
	
	public static Resource getResourceFromSession(URI semanticResourceURI) {
		for (Session session : SessionManager.INSTANCE.getSessions()) {
			for (Resource semanticResource : session.getSemanticResources()) {
				if (semanticResourceURI.equals(semanticResource.getURI())) {
					return semanticResource;
				}
			}
			if (session instanceof DAnalysisSessionEObject) {
				for (Resource controlledResource : ((DAnalysisSessionEObject) session).getControlledResources()) {
					if (semanticResourceURI.equals(controlledResource.getURI())) {
						return controlledResource;
					}	
				}
			}
		}
		return null;
	}
	
	public static void executeScaffolding(ScaffoldingOperation op, Shell shell) {
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, false, op);
		} catch (Exception e) {
			logError("An error occured during the transformation. See Error Log view for details.", e);
		}

		// If the transformation worked correctly
		if (op.isSuccess() == false) {
			logError("The scaffolding process failed. See Error Log view for details.", null);
		} else {
			URI scaffoldModelURI = op.getScaffoldInfo().eResource().getURI();
			String scaffoldModelLocation = scaffoldModelURI.toPlatformString(true);
			if (scaffoldModelLocation == null) {
				// Maybe it's a CDO URI
				scaffoldModelLocation = scaffoldModelURI.toString();
			}
			MessageDialog.openInformation(shell, "Scaffolding", "The scaffolding process has been successfully executed.\n\n"
					+ "Scaffold model located at : " + scaffoldModelLocation);
			// TODO maybe propose to open the corresponding diagram
			// or open the EMF Tree editor
			
			// open the modified file
//			String modifiedFilePath = specifyTargetPage.getModelFilePath();
//			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
//			IFile modelFile = workspaceRoot.getFile(new Path(modifiedFilePath));
//			
//			if (modelFile != null && modelFile.exists()) {
//				// Select the new file resource in the current view.
//				//
//				IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
//				IWorkbenchPage page = workbenchWindow.getActivePage();
//				final IWorkbenchPart activePart = page.getActivePart();
//				if (activePart instanceof ISetSelectionTarget) {
//					final ISelection targetSelection = new StructuredSelection(modelFile);
//					getShell().getDissplay().asyncExec
//					(new Runnable() {
//						public void run() {
//							((ISetSelectionTarget)activePart).selectReveal(targetSelection);
//						}
//					});
//				}
//				
//				// Open an editor on the new file.
//				//
//				try {
//					page.openEditor(new FileEditorInput(modelFile), workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
//				}
//				catch (PartInitException exception) {
//					MessageDialog.openError(workbenchWindow.getShell(), DatabaseEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
//					return false;
//				}
//			}
		}
	}
	
	private static void logError(String message, Exception e) {
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e);
		StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK );
	}
	
	public static boolean isValidInputForEntity(Object element) {
		return element instanceof Root || element instanceof Namespace;
	}

	public static boolean isValidInputForMpd(Object element) {
		if (element instanceof EObject) {
			EObject eltAsEObject = (EObject)element;
			DataBase database = getDatabaseFromObject(eltAsEObject);
			return usesLibraryOfKind(database, TypesLibraryKind.PHYSICAL_TYPES);
		}
		return false;
	}

	public static boolean isValidInputForMld(Object element) {
		if (element instanceof EObject) {
			EObject eltAsEObject = (EObject)element;
			DataBase database = getDatabaseFromObject(eltAsEObject);
			return usesLibraryOfKind(database, TypesLibraryKind.LOGICAL_TYPES);
		}
		return false;
	}
	
	private static DataBase getDatabaseFromObject(EObject element) {
		if (element instanceof TableContainer) {
			return getContainingDataBase((TableContainer)element);
		}
		return null;
	}
	
	private static DataBase getContainingDataBase(TableContainer tableContainer) {
		if (tableContainer instanceof DataBase) {
			return (DataBase)tableContainer;
		} else {
			EObject parent = tableContainer.eContainer();
			if (parent instanceof DataBase) {
				return (DataBase)parent;
			} else {
				return null;
			}
		}
	}

	private static boolean usesLibraryOfKind(DataBase database, TypesLibraryKind kind) {
		if (database != null) {
			for (TypesLibrary typesLibrary : database.getUsedLibraries()) {
				if (kind.equals(typesLibrary.getKind())) {
					return true;
				}
			}
		}
		return false;
	}
}
