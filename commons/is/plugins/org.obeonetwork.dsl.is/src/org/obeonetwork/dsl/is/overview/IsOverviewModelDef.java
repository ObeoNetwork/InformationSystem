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
package org.obeonetwork.dsl.is.overview;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.obeonetwork.dsl.cinematic.CinematicFactory;
import org.obeonetwork.dsl.cinematic.provider.CinematicItemProviderAdapterFactory;
import org.obeonetwork.dsl.entity.EntityFactory;
import org.obeonetwork.dsl.entity.provider.EntityItemProviderAdapterFactory;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.provider.EnvironmentItemProviderAdapterFactory;
import org.obeonetwork.dsl.overview.OverviewModelDef;
import org.obeonetwork.dsl.overview.OverviewPackage;
import org.obeonetwork.dsl.overview.Root;
import org.obeonetwork.dsl.overview.provider.OverviewItemProviderAdapterFactory;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.provider.SoaItemProviderAdapterFactory;

public class IsOverviewModelDef implements OverviewModelDef {

	public static final String ID = "org.obeonetwork.dsl.is.ISOverviewModelDef"; 
	
	public Collection<?> getNewChildDescriptors(Root root) {		
		ArrayList<CommandParameter> childDescriptors = new ArrayList<CommandParameter>();
		// allow to create Environment Namespace
		childDescriptors.add(createChildCommand(EnvironmentFactory.eINSTANCE.createNamespace()));		
		// allow to create Entity Root
		childDescriptors.add(createChildCommand(EntityFactory.eINSTANCE.createRoot()));
		// allow to create Cinematic Root
		childDescriptors.add(createChildCommand(CinematicFactory.eINSTANCE.createCinematicRoot()));
		// allow to create SOA System (root)
		childDescriptors.add(createChildCommand(SoaFactory.eINSTANCE.createSystem()));
		
		return childDescriptors;
	}

	private CommandParameter createChildCommand(EObject child) {
		return new CommandParameter(null,
				OverviewPackage.Literals.ROOT__OWNED_ELEMENTS, child);
	}

	public AdapterFactory getAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);		
		adapterFactory.addAdapterFactory(new OverviewItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EnvironmentItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EntityItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CinematicItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SoaItemProviderAdapterFactory());			
		return adapterFactory;
	}

	public String getFileNameExtension() {
		return "ois";
	}

	// Init Semantic
	public void initModel(Root root) {		
		root.getOwnedElements().add(EntityFactory.eINSTANCE.createRoot());
		root.getOwnedElements().add(SoaFactory.eINSTANCE.createSystem());
		root.getOwnedElements().add(CinematicFactory.eINSTANCE.createCinematicRoot());
	}
	
	// Init Graphical Model
	public void openEditor(final IFile modelFile) {
		
		// Get URI of aird file
//		String airdFileName = modelFile.getFullPath().removeFileExtension().addFileExtension("aird").toOSString();		
//		URI airdFileURI = URI.createPlatformResourceURI(airdFileName, true);		
//		
//		final DefaultLocalSessionCreationOperation op = new DefaultLocalSessionCreationOperation(airdFileURI);
//		final WorkspaceModifyOperation createAird = new WorkspaceModifyOperation() {
//			@Override
//			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
//				op.execute();
//				// Retrieve the newly created Session
//				Session session = op.getCreatedSession();
//				if (session != null) {
//					// Retrieves Resourceset and the corresponding editing domain
//					ResourceSet resourceSet = session.getSessionResource().getResourceSet();
//					TransactionalEditingDomain ted = EditingDomainFactoryService.INSTANCE.getEditingDomainFactory().getEditingDomain(resourceSet);			
//
//					// Add the required semantic resources (main semmantic model and obeo.environment shared file)			
//					URI modelFileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
//					ted.getCommandStack().execute(new AddSemanticResourceCommand(session, modelFileURI));
//					URI obeoEnvironmentURI = URI.createPlatformPluginURI("org.obeonetwork.dsl.environment.common/model/obeo.environment", true);
//					ted.getCommandStack().execute(new AddSemanticResourceCommand(session, obeoEnvironmentURI));
//					
//					// And select the default viewpoints
//					selectDefaultViewpoints(session, ted);
//				}
//			}
//		};
//		try {
//			PlatformUI.getWorkbench().getProgressService().run(true, false, createAird);
//		} catch (Exception e) {
//			OverviewEditorPlugin.INSTANCE.log(e);
//		}
		
	}

//	private void selectDefaultViewpoints(final Session session, final TransactionalEditingDomain ted) {
//		ted.getCommandStack().execute(new RecordingCommand(ted) {
//			@Override
//			public String getLabel() {
//				return "Select default viewpoints";
//			}
//
//			@Override
//			protected void doExecute() {
//				Set<Viewpoint> viewpoints = ViewpointSelection.getViewpoints(ISEditor.EXTENSION);
//				for (Viewpoint viewpoint : viewpoints) {
//					viewpoint = ViewpointResourceHelper.getCorrespondingViewpoint(session, viewpoint);
//					if (session.getSelectedViewpoints().contains(viewpoint)) {
//						new ViewpointSelectionCallback().deselectViewpoint(viewpoint, session);
//					} else {
//						new ViewpointSelectionCallback().selectViewpoint(viewpoint, session);
//					}
//				}
//			}
//		});
//	}
	
	public boolean isApplicable(Root root) {
		return true;
	}

	public String getID() {	
		return "org.obeonetwork.dsl.is.ISOverviewModelDef";
	}

}
