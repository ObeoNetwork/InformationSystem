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
package org.obeonetwork.project.lifecycle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionStatus;
import org.eclipse.sirius.business.api.session.ViewpointSelector;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.requirement.RequirementFactory;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.graal.GraalPackage;

import com.google.common.base.Joiner;

public class BusinessProjectImporter {
	
	private static final List<EClass> ROOT_ECLASSES = Arrays.asList(
			GraalPackage.Literals.SYSTEM, 
			RequirementPackage.Literals.REPOSITORY,
			EntityPackage.Literals.ROOT);
	
	private static final String IMPORT_FOLDER_NAME = "analysis";
	
	private ModelingProject sourceProject;
	private ModelingProject targetProject;
	
	private Session sourceSession;
	private Session targetSession;
	private ImportData importData = null;

	public BusinessProjectImporter(ModelingProject sourceProject, ModelingProject targetProject) {
		super();
		this.sourceProject = sourceProject;
		this.targetProject = targetProject;
	}
	
	protected void initializeImportData() {
		if(importData == null) {
			sourceSession = ImporterUtil.getSession(getSourceProject());
			targetSession = ImporterUtil.getSession(getTargetProject());
			
			// Initialize import data
			importData = new ImportData(sourceSession, ROOT_ECLASSES);
		}
	}
	
	private void saveAndCloseEditorsOnTargetProject(IProgressMonitor parentMonitor) throws CoreException {
		SubMonitor monitor = SubMonitor.convert(parentMonitor, 3);
		if (shouldSaveAndCloseEditorsOnTargetProject()) {
			// Save session if needed
			Session session = ImporterUtil.getSession(getTargetProject());
			if (session.getStatus().equals(SessionStatus.DIRTY)) {
				session.save(monitor.newChild(1));
			}
			
			// Close diagrams
			IEditingSession uiSession = SessionUIManager.INSTANCE.getUISession(session);
			if (uiSession != null) {
				Collection<DialectEditor> editors = uiSession.getEditors();
				if  (!editors.isEmpty()) {
					uiSession.closeEditors(true, editors);
				}
			}
		}
	}
	
	public Collection<ReferenceData> getImpactedReferences(IProgressMonitor parentMonitor) throws CoreException {
		SubMonitor monitor = SubMonitor.convert(parentMonitor, 2);
		saveAndCloseEditorsOnTargetProject(monitor.newChild(1));
		
		initializeImportData();
		
		// Compute the target existing roots that will be replaced
		Collection<EObject> existingTargetSemanticRoots = getAllImpactedTargetSemanticRoots();
		
		// Collect representations related to the existing target semantic content
		Collection<DRepresentationDescriptor> existingTargetRepresentationDescriptors = 
				ImporterUtil.getRelatedRepresentationDescriptors(
						targetSession, 
						ImporterUtil.getAllElementsWithChildren(existingTargetSemanticRoots));
		
		Collection<DRepresentation> existingTargetRepresentations = new ArrayList<DRepresentation>();
		for(DRepresentationDescriptor existingTargetRepresentationDescriptor : existingTargetRepresentationDescriptors) {
			existingTargetRepresentations.add(existingTargetRepresentationDescriptor.getRepresentation());
		}
		
		// Collect references
		Collection<ReferenceData> allReferences = ImporterUtil.getReferencingElements(existingTargetSemanticRoots, targetSession);
		
		// Filter references not impacted by the removal
		Collection<ReferenceData> filteredReferences = filterOutOfConcernReferences(allReferences, existingTargetSemanticRoots, existingTargetRepresentations);
		monitor.worked(1);
		monitor.done();
		
		return filteredReferences;
	}
	
	private Collection<ReferenceData> filterOutOfConcernReferences(Collection<ReferenceData> references, Collection<EObject> existingSemanticRoots, Collection<DRepresentation> existingRepresentations) {
		Collection<ReferenceData> filteredReferences = new ArrayList<ReferenceData>();
		// Filtered references are references for which at least one of these conditions is verified : 
		// - The referencing element is contained by one of the roots to be removed
		// - The referencing element is contained by one of the representations to be removed
		// - The reference is a DAnalysis.models reference
		for (ReferenceData reference : references) {
			EObject highLevelContainer = getHighLevelContainer(reference.getReferencingElement());
			if (!existingSemanticRoots.contains(highLevelContainer)
					&& !existingRepresentations.contains(highLevelContainer)
					&& !ViewpointPackage.Literals.DANALYSIS__MODELS.equals(reference.getReferencingFeature())) {
				filteredReferences.add(reference);
			}
		}
		return filteredReferences;
	}
	
	private EObject getHighLevelContainer(EObject element) {
		if(element instanceof DRepresentationDescriptor) {
			return getHighLevelContainer(((DRepresentationDescriptor) element).getRepresentation());
		}
		
		if (element instanceof DRepresentation || element.eContainer() == null) {
			return element;
		}
		
		return getHighLevelContainer(element.eContainer());
	}
	
	public boolean shouldSaveAndCloseEditorsOnTargetProject() {
		Session session = getTargetProject().getSession();
		if (session == null) {
			return false;
		}
		if (SessionStatus.DIRTY.equals(session.getStatus())) {
			return true;
		}
		IEditingSession uiSession = SessionUIManager.INSTANCE.getUISession(session);
		if (uiSession != null) {
			return !uiSession.getEditors().isEmpty();
		}
		return false;
	}
	
	public void importElementsIntoTargetProject(IProgressMonitor parentMonitor) throws CoreException {
		final SubMonitor monitor = SubMonitor.convert(parentMonitor, 5);
		// Ensure project is closed
		saveAndCloseEditorsOnTargetProject(monitor.newChild(1));
		
		initializeImportData();
		
		final Map<String, List<EObject>> requirementReferencesCache = cacheRequirementReferences();
		
		// Create command
		TransactionalEditingDomain editingDomain = targetSession.getTransactionalEditingDomain();
		RecordingCommand command = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				// At the end of the import, if there is no "requirement.Repository" object in the target MOE project, then create one named after the MOE project.
				// This verification is done *before* importing models from the MOA otherwise they get added onto the session.
				boolean repositoryExistsBeforeImporting = false;
				for(Resource semanticResource : SessionManager.INSTANCE.getExistingSession(targetProject.getMainRepresentationsFileURI(monitor).get()).getSemanticResources()){
					repositoryExistsBeforeImporting = repositoryExistsBeforeImporting || EcoreUtil.getObjectByType(semanticResource.getContents(), RequirementPackage.Literals.REPOSITORY) != null;
				}
				
				// Delete the content of the impacted resources and the related representations
				final Collection<EObject> existingTargetSemanticRoots = getAllImpactedTargetSemanticRoots();
				if (!existingTargetSemanticRoots.isEmpty()) {
					// Delete related representations
					final Collection<DRepresentationDescriptor> existingRepresentationDescriptors = ImporterUtil.getRelatedRepresentationDescriptors(targetSession, ImporterUtil.getAllElementsWithChildren(existingTargetSemanticRoots));
					if (!existingRepresentationDescriptors.isEmpty()) {
				        for (DRepresentationDescriptor dRepresentationDescriptor : existingRepresentationDescriptors) {
				            DialectManager.INSTANCE.deleteRepresentation(dRepresentationDescriptor, targetSession);
				        }
					}
					
					// Delete existing objects
					for (EObject semanticRoot : existingTargetSemanticRoots) {
						if(semanticRoot instanceof Repository) {
							for(Requirement req : ImporterUtil.getAllContentsOfType(semanticRoot, Requirement.class)) {
								req.getReferencedObject().clear();
								SiriusUtil.delete(req, targetSession);
							}
						}
						SiriusUtil.delete(semanticRoot, targetSession);
					}
				}
				
				// Create semantic resources and their content
				for(EObject sourceRoot : importData.getSourceRoots()) {
					EObject copyRoot = importData.getCopyEObject(sourceRoot);
					String targetPath = getTargetResourcePath(sourceRoot);
					addToSemanticResource(copyRoot, targetPath);
				}
				
				// Add representations
				for(DRepresentationDescriptor sourceRepresentationDescriptor : importData.getSourceRepresentationDescriptors()) {
					DRepresentationDescriptor copyRepresentationDescriptor = (DRepresentationDescriptor)importData.getCopyEObject(sourceRepresentationDescriptor);
					EObject copiedRepresentationAsObject = importData.getCopyEObject(sourceRepresentationDescriptor.getRepresentation());
					if (copiedRepresentationAsObject instanceof DRepresentation) {
						DRepresentation copyRepresentation = (DRepresentation)copiedRepresentationAsObject;						
						Viewpoint viewpoint = getViewpoint(copyRepresentationDescriptor);
						addRepresentationDescriptor(copyRepresentationDescriptor, copyRepresentation, viewpoint);
					}
				}
				
				// Restore the local requirement references
				restoreRequirementReferences(requirementReferencesCache);
				

//				Boolean repositoryExists = false;
//				for(Resource semanticResource : SessionManager.INSTANCE.getExistingSession(targetProject.getMainRepresentationsFileURI(monitor).get()).getSemanticResources()){
//					repositoryExists = repositoryExists || EcoreUtil.getObjectByType(semanticResource.getContents(), RequirementPackage.Literals.REPOSITORY) != null;
//				}
				if(!repositoryExistsBeforeImporting){
					Repository requirementsRepository = RequirementFactory.eINSTANCE.createRepository();
					addToSemanticResource(requirementsRepository, targetProject.getProject().getName() + "/" + targetProject.getProject().getName() + ".requirement");
				}				
			}
		};
		
		// Execute the command
		editingDomain.getCommandStack().execute(command);
		monitor.worked(3);
		
		// Save project
		targetSession.save(monitor.newChild(1));
	}
	
	private Map<String, List<EObject>> cacheRequirementReferences() {
		
		Map<String, List<EObject>> requirementReferencedObjectsCache = new HashMap<String, List<EObject>>();
		
		// Collect target project semantic roots impacted by the import
		Collection<EObject> impactedTargetSemanticRoots = getAllImpactedTargetSemanticRoots();
		
		// Collect target project requirement repositories impacted by the import
		Collection<Repository> impactedRepositories = EcoreUtil.getObjectsByType(
				impactedTargetSemanticRoots, RequirementPackage.Literals.REPOSITORY);
		
		// Cache the reference for each referenced objects in the impacted requirements
		for(Repository impactedRepository : impactedRepositories) {
			List<Requirement> localRequirements = ImporterUtil.getAllContentsOfType(impactedRepository, Requirement.class);
			for(Requirement localRequirement : localRequirements) {
				for(EObject referencedObject : localRequirement.getReferencedObject()) {
					if(!impactedTargetSemanticRoots.contains(EcoreUtil.getRootContainer(referencedObject))) {
						lazyPut(requirementReferencedObjectsCache, localRequirement.getId(), referencedObject);
					}
				}
			}
		}
		return requirementReferencedObjectsCache;
	}
	
	private <K, V> Map<K, List<V>> lazyPut(Map<K, List<V>> map, K key, V value) {
		List<V> valueList = map.get(key);
		if(valueList == null) {
			valueList = new LinkedList<V>();
			map.put(key, valueList);
		}
		valueList.add(value);
		
		return map;
	}

	private void restoreRequirementReferences(final Map<String, List<EObject>> requirementReferencedObjectsCache) {
		final Collection<Repository> copyRepositories = EcoreUtil.getObjectsByType(
				importData.getCopyEObjects(), 
				RequirementPackage.Literals.REPOSITORY);
		
		// Restore the reference for each impacted requirements
		for(Repository copyRepository : copyRepositories) {
			List<Requirement> requirements = ImporterUtil.getAllContentsOfType(copyRepository, Requirement.class);
			for(Requirement requirement : requirements) {
				List<EObject> referencedObjects = requirementReferencedObjectsCache.get(requirement.getId());
				if(referencedObjects != null) {
					requirement.getReferencedObject().addAll(referencedObjects);
				}
			}
		}
	}

	private Viewpoint getViewpoint(DRepresentationDescriptor representationDescriptor) {
		EObject eContainer = representationDescriptor.eContainer();
		if (eContainer != null && eContainer instanceof DView) {
			return ((DView) eContainer).getViewpoint();
		} else {
			// We have to use the source representation to get the viewpoint
			EObject sourceRepresentationDescriptor = importData.getSourceEObject(representationDescriptor);
			if (sourceRepresentationDescriptor instanceof DRepresentationDescriptor) {
				return getViewpoint((DRepresentationDescriptor)sourceRepresentationDescriptor);
			}
		}
		return null;
	}

	protected void addToSemanticResource(final EObject copyObject, final String targetPath) {
		final URI targetURI = URI.createPlatformResourceURI(targetPath, true);
		boolean resourceExists = existsTargetSemanticResource(targetURI);
		ResourceSet resourceSet = targetSession.getTransactionalEditingDomain().getResourceSet();
		if (!resourceExists) {
			// Create the resource if needed
			Resource resource = resourceSet.createResource(targetURI);
			try {
				Map<Object, Object> options = new HashMap<Object, Object>();
				options.put(XMLResource.OPTION_ENCODING, "UTF-8");
				resource.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Resource resource = resourceSet.getResource(targetURI, false);
		resource.getContents().add(copyObject);
		if (!resourceExists) {
			addToSemanticResources(targetSession, targetURI, new NullProgressMonitor());
		}
	}
	
	private Resource addToSemanticResources(Session session, URI uri, IProgressMonitor monitor) {
		// Add the semantic resource to the given session
        session.addSemanticResource(uri, monitor);

        // If the semantic resource addition is successful returns the added Resource
        Resource addedResource = session.getTransactionalEditingDomain().getResourceSet().getResource(uri, false);
        if (addedResource != null) {
            return addedResource;
        }
        
        return null;
	}
	
	private void addRepresentationDescriptor(final DRepresentationDescriptor representationDescriptor, final DRepresentation representation, final Viewpoint viewpoint) {
		addRepresentationDescriptor(targetSession, representationDescriptor, representation, viewpoint);
	}

	private String getTargetResourcePath(final EObject sourceObject) {
		final List<String> segments = getTargetResourcePathSegments(sourceObject);
		// Add Project name as URI first segment
		segments.add(0, getTargetProjectName());
		final String path = Joiner.on("/").join(segments);
		
		return path;
	}
	
	private List<String> getTargetResourcePathSegments(EObject sourceObject) {
		URI sourceURI = sourceObject.eResource().getURI();
		List<String> segments = new ArrayList<String>(sourceURI.segmentsList());
		if (sourceURI.isPlatform()) {
			// Remove "resource" and project's name
			segments.remove(0);
			segments.remove(0);
		} else {
			// Remove project's name
			segments.remove(0);
		}
		
		// Add destination folder to the resource path segments
		segments.add(0, IMPORT_FOLDER_NAME);
		
		return segments;
	}
	
	protected String getTargetProjectName() {
		return getTargetProject().getProject().getName();
	}

	protected boolean existsTargetSemanticResource(final URI targetURI) {
		for (Resource semanticResource : targetSession.getSemanticResources()) {
			if (targetURI.equals(semanticResource.getURI())) {
				return true;
			}
		}
		return false;
	}
	
	private void addRepresentationDescriptor(Session session, DRepresentationDescriptor representationDescriptor, DRepresentation representation, Viewpoint viewpoint) {
		if (viewpoint != null) {
			DView view = getViewForViewpoint(viewpoint, session);
			if (view != null) {
				view.getOwnedRepresentationDescriptors().add(representationDescriptor);
				view.eResource().getContents().add(representation);
				representationDescriptor.setRepresentation(representation);
				return;
			}
			
			// If we reach this point it probably means the viewpoint was not selected yet
			new ViewpointSelector(session).selectViewpoint(viewpoint, false, new NullProgressMonitor());
			view = getViewForViewpoint(viewpoint, session);
			if (view != null) {
				view.getOwnedRepresentationDescriptors().add(representationDescriptor);
				view.eResource().getContents().add(representation);
				representationDescriptor.setRepresentation(representation);
				return;
			}
		}
	}
	
	private DView getViewForViewpoint(Viewpoint vp, Session session) {
		for (DView dView : session.getOwnedViews()) {
			if (dView.getViewpoint().getName().equals(vp.getName())) {
				return dView;
			}
		}
		return null;
	}

	private Collection<EObject> getAllImpactedTargetSemanticRoots() {
		Collection<EObject> impactedTargetSemanticRoots = new ArrayList<EObject>();
		for (EObject sourceRoot : importData.getSourceRoots()) {
			// Compute the target resource path
			String targetPath = getTargetResourcePath(sourceRoot);
			
			// Compute the target existing roots that will be replaced
			impactedTargetSemanticRoots.addAll(getTargetSemanticRoots(targetPath));
		}
		
		return impactedTargetSemanticRoots;
	}
	
	private Collection<EObject> getTargetSemanticRoots(String targetResourcePath) {
		Collection<EObject> result = new ArrayList<EObject>();
		
		Resource resource = getTargetResource(targetResourcePath);
		if(resource != null) {
			for (EObject root : resource.getContents()) {
				if (ImporterUtil.isOfAnyClass(root, ROOT_ECLASSES)) {
					result.add(root);
				}
			}
		}
		return result;
	}
	
	protected Resource getTargetResource(String targetResourcePath) {
		URI targetURI = URI.createPlatformResourceURI(targetResourcePath, true);
		for (Resource semanticResource : targetSession.getSemanticResources()) {
			if (targetURI.equals(semanticResource.getURI())) {
				return semanticResource;
			}
		}
		return null;
	}

	public ModelingProject getSourceProject() {
		return sourceProject;
	}

	public ModelingProject getTargetProject() {
		return targetProject;
	}

	public Session getSourceSession() {
		return sourceSession;
	}

	public Session getTargetSession() {
		return targetSession;
	}
	
}
