package fr.gouv.mindef.safran.project.lifecycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DRepresentation;

public class ImportData {
	private Session sourceSession;
	private List<EClass> rootEClasses;
	
	private Collection<EObject> sourceRoots;
	private Collection<DRepresentation> sourceRepresentations;
	
	private Map<EObject, EObject> rootsAndRepresentationsCopyToSourceMap = null;
	private Map<EObject, EObject> sourceRootToCopyRootMap = null;
	private Collection<DRepresentation> copyRepresentations = null;
	
	public ImportData(Session sourceSession, List<EClass> rootEClasses) {
		this.sourceSession = sourceSession;
		this.rootEClasses = rootEClasses;
		
		initializeData();
	}
	
	private void initializeData() {
		sourceRoots = new ArrayList<EObject>();
		for (Resource resource : sourceSession.getSemanticResources()) {
			for (EObject root : resource.getContents()) {
				if (ImporterUtil.isOfAnyClass(root, rootEClasses)) {
					sourceRoots.add(root);
				}
			}
		}
		
		Collection<EObject> sourceElements = ImporterUtil.getAllElementsWithChildren(sourceRoots);
		sourceRepresentations = ImporterUtil.getRelatedRepresentations(sourceSession, sourceElements);
	}
	
	private void initializeCopyElements() {
		rootsAndRepresentationsCopyToSourceMap = copyRootsAndRepresentations(sourceRoots, sourceRepresentations);
		
		sourceRootToCopyRootMap = new HashMap<EObject, EObject>();
		copyRepresentations = new ArrayList<DRepresentation>();
		for (Entry<EObject, EObject> entry : rootsAndRepresentationsCopyToSourceMap.entrySet()) {
			EObject copyObject = entry.getKey();
			if (copyObject instanceof DRepresentation) {
				copyRepresentations.add((DRepresentation)copyObject);
			} else {
				sourceRootToCopyRootMap.put(entry.getValue(), copyObject);
			}
		}
	}

	public Collection<EObject> getSourceRoots() {
		return sourceRoots;
	}

	public Collection<DRepresentation> getSourceRepresentations() {
		return sourceRepresentations;
	}

	public Map<EObject, EObject> getRootsAndRepresentationsCopyToSourceMap() {
		if (rootsAndRepresentationsCopyToSourceMap == null) {
			initializeCopyElements();
		}
		return rootsAndRepresentationsCopyToSourceMap;
	}

	public Map<EObject, EObject> getSourceRootToCopyRootMap() {
		if (sourceRootToCopyRootMap == null) {
			initializeCopyElements();
		}
		return sourceRootToCopyRootMap;
	}

	public Collection<DRepresentation> getCopyRepresentations() {
		if (copyRepresentations == null) {
			initializeCopyElements();
		}
		return copyRepresentations;
	}
	
	private Map<EObject, EObject> copyRootsAndRepresentations(Collection<EObject> roots, Collection<DRepresentation> representations) {
		Collection<EObject> objectsToCopy = new ArrayList<EObject>();
		objectsToCopy.addAll(roots);
		objectsToCopy.addAll(representations);
		return copyAll(objectsToCopy);
	}
	
	private Map<EObject, EObject> copyAll(Collection<EObject> eObjects) {
		Copier copier = new Copier();
	    copier.copyAll(eObjects);
	    copier.copyReferences();
	    
	    // Build the results map
	    Map<EObject, EObject> results = new HashMap<EObject, EObject>();
	    
	    for (EObject eObject : eObjects) {
	    	results.put(copier.get(eObject), eObject);
		}
	    
	    return results;
	}
}
