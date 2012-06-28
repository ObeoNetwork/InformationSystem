package org.obeonetwork.dsl.is.design.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredSelection;
import org.obeonetwork.dsl.entity.Block;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.environment.BoundableElement;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;
import org.obeonetwork.dsl.soa.Category;
import org.obeonetwork.dsl.soa.DTORegistry;
import org.obeonetwork.dsl.soa.ServiceDTO;
import org.obeonetwork.dsl.soa.System;

import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.description.RepresentationDescription;
import fr.obeo.dsl.viewpoint.description.Viewpoint;
import fr.obeo.dsl.viewpoint.ui.business.api.session.UserSession;

public class BindingService {
	
	private static final String BINDING_EDITOR_DESCRIPTION_NAME = "Binding Details";

	public BindingInfo openBindingEditor(BindingInfo bindingInfo) {
		DBindingEditor editor = null;
		
		final Session session = SessionManager.INSTANCE.getSession(bindingInfo);
		
		// Find an editor to open
		Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(bindingInfo, session);
		for (DRepresentation representation : representations) {
			if (representation instanceof DBindingEditor) {
				editor = (DBindingEditor)representation;
				break;
			}
		}

		// Create an editor if needed
		if (editor == null) {
			RepresentationDescription representationDescription = getBindingEditorRepresentation(session);
			if (representationDescription != null) {
				DRepresentation representation = DialectManager.INSTANCE.createRepresentation(computeBindingEditorName(bindingInfo), bindingInfo, representationDescription, session, new NullProgressMonitor());
				if (representation != null && representation instanceof DBindingEditor) {
					editor = (DBindingEditor)representation;
				}
			}
		}
		// Open the editor
		if (editor != null) {
			UserSession.from(session).openRepresentation(new StructuredSelection(editor));
		}
		
		return bindingInfo;
	}
	
	public String computeBindingEditorName(BindingInfo bindingInfo) {
		String name = "Binding ";
		name += getBoundElementName(bindingInfo.getLeft());
		name += " - ";
		name += getBoundElementName(bindingInfo.getRight());
		return name;
	}
	
	private String getBoundElementName(EObject object) {
		if (object != null && object instanceof StructuredType) {
			return ((StructuredType)object).getName();
		}
		return null;
	}
	
	private RepresentationDescription getBindingEditorRepresentation(Session session) {
		for (Viewpoint vp : session.getSelectedViewpoints(true)) {
			for (RepresentationDescription representationDescription : vp.getOwnedRepresentations()) {
				if (representationDescription.getName().equals(BINDING_EDITOR_DESCRIPTION_NAME)) {
					return representationDescription;
				}
			}
		}
		return null;
	}
	
	public BindingInfo reconnectBindingTarget(BindingInfo bindingInfo, BoundableElement oldTarget, BoundableElement newTarget) {
		if (bindingInfo.getLeft().equals(oldTarget)) {
			bindingInfo.setLeft(newTarget);
		} else if (bindingInfo.getRight().equals(oldTarget)) {
			bindingInfo.setRight(newTarget);
		}
		
		return bindingInfo;
	}	
	
	public boolean checkIfReconnectBindingIsPossible(Category category, BindingInfo bindingInfo, EObject firstElement, EObject secondElement) {
		// Get opposite side
		EObject opposite = getBindingOpposite(bindingInfo, firstElement);
		
		Collection<StructuredType> dtos = getDTOAndChildrenDTOs(category);
		if (dtos.contains(opposite)) {
			// Reconnection is possible on any dto or entity (not yet bound)
			return !getBoundElementsWithTarget(category, opposite).contains(secondElement);
		} else {
			// Reconnection is possible only on main dtos (not yet bound)
			return dtos.contains(secondElement)
					&& !getBoundElementsWithTarget(category, opposite).contains(secondElement);
		}
	}
	
	public BindingInfo changeBindingTarget(BindingInfo bindingInfo, BoundableElement firstElement, BoundableElement secondElement) {
		if (bindingInfo.getLeft().equals(firstElement)) {
			bindingInfo.setRight(secondElement);
		} else if (bindingInfo.getRight().equals(firstElement)) {
			bindingInfo.setLeft(secondElement);
		}
		
		return bindingInfo;
	}
	
	public Collection<StructuredType> getAllBindableElementsFor(Category category, EObject target) {
		if (target instanceof ServiceDTO) {
			return internalGetAllBindableElementsFor(category, (ServiceDTO)target);
		} else if (target instanceof Entity) {
			return internalGetAllBindableElementsFor(category, (Entity)target);
		}
		return Collections.emptyList();
	}
	
	public Collection<StructuredType> internalGetAllBindableElementsFor(Category category, ServiceDTO dto) {
		// Get all DTOs in category and direct sub categories
		Collection<StructuredType> dtos = getDTOAndChildrenDTOs(category);
		
		if (dtos.contains(dto)) {
			return getAllBindableElements(dto);
		} else {
			return dtos;
		}
	}
	
	public Collection<StructuredType> internalGetAllBindableElementsFor(Category category, Entity entity) {
		return getDTOAndChildrenDTOs(category);
	}
	
	public Collection<StructuredType> getAllBindableElements(ServiceDTO dto) {
		// Collect all entities and dtos
		Collection<StructuredType> bindableElements = new ArrayList<StructuredType>();
		
		// First, get all semantic resources in session
		Collection<Resource> semanticResources = EcoreService.getAllSemanticResourcesInSession(dto);
		
		for (Resource resource : semanticResources) {
			TreeIterator<EObject> iterator = EcoreUtil.getAllContents(resource, true);
			while (iterator.hasNext()) {
				EObject eObject = (EObject) iterator.next();
				if (eObject instanceof ServiceDTO || eObject instanceof Entity) {
					if (!eObject.equals(dto)) {
						bindableElements.add((StructuredType)eObject);
					}
				} else if (!(eObject instanceof Root || eObject instanceof Block || eObject instanceof org.obeonetwork.dsl.overview.Root
						|| eObject instanceof System || eObject instanceof DTORegistry || eObject instanceof Category)) {
					iterator.prune();
				}
			}
		}
		
		return bindableElements;
	}
	
	public EObject getBindingOpposite(BindingInfo bindingInfo, EObject opposite) {
		if (bindingInfo.getLeft().equals(opposite)) {
			return bindingInfo.getRight(); 
		} else if (bindingInfo.getRight().equals(opposite)) {
			return bindingInfo.getLeft(); 
		}
		return null;
	}
	
	public Collection<BindingInfo> getRelatedBindingInfos(Category category) {
		List<BindingInfo> results = new ArrayList<BindingInfo>();
		
		// Collect all DTOs in this category and its direct sub-categories
		Collection<StructuredType> dtos = getDTOAndChildrenDTOs(category);
		
		// Check every BindingInfo instance
		BindingRegistry registry = getGlobalBindingRegistry(category);
		for (BindingInfo bindingInfo : registry.getBindingInfos()) {
			if (dtos.contains(bindingInfo.getLeft()) || dtos.contains(bindingInfo.getRight())) {
				results.add(bindingInfo);
			}
		}
		
		return results;
	}
	
	public Collection<ServiceDTO> getBoundExternalDTOs(Category category) {
		List<ServiceDTO> results = new ArrayList<ServiceDTO>();
		
		// Collect all DTOs in this category and its direct sub-categories
		Collection<StructuredType> dtos = getDTOAndChildrenDTOs(category);
		
		
		for(BindingInfo bi : getGlobalBindingRegistry(category).getBindingInfos()) {
			if (dtos.contains(bi.getLeft())
					&& !dtos.contains(bi.getRight())
					&& bi.getRight() instanceof ServiceDTO) {
				results.add((ServiceDTO)bi.getRight());
			} else if (dtos.contains(bi.getRight())
					&& !dtos.contains(bi.getLeft())
					&& bi.getLeft() instanceof ServiceDTO) {
				results.add((ServiceDTO)bi.getLeft());
			}
		}
		
		return results;
	}
	
	public Collection<EObject> getBoundElementsWithTarget(Category category, EObject target) {
		Collection<EObject> results = new HashSet<EObject>();
		for (BindingInfo bindingInfo : getRelatedBindingInfos(category)) {
			if (bindingInfo.getLeft().equals(target)) {
				results.add(bindingInfo.getRight());
			} else if (bindingInfo.getRight().equals(target)) {
				results.add(bindingInfo.getLeft());
			}
		}
		return results;
	}
	
	public Collection<Entity> getBoundEntities(Category category) {
		List<Entity> results = new ArrayList<Entity>();
		
		// Get the binding infos to consider
		Collection<BindingInfo> bindingInfos = getRelatedBindingInfos(category);
		
		for (BindingInfo bindingInfo : bindingInfos) {
			if (bindingInfo.getLeft() instanceof Entity) {
				results.add((Entity)bindingInfo.getLeft());
			}
			if (bindingInfo.getRight() instanceof Entity) {
				results.add((Entity)bindingInfo.getRight());
			}
		}
		
		return results;
	}
	
	public Collection<ServiceDTO> getBoundOwnDTOs(Category category) {
		List<ServiceDTO> results = new ArrayList<ServiceDTO>();
		
		for (ServiceDTO serviceDTO : getBoundDTO(getGlobalBindingRegistry(category))) {
			if (category.getTypes().contains(serviceDTO)) {
				results.add(serviceDTO);
			}
		}
		
		return results;
	}
	
	private Collection<ServiceDTO> getBoundDTO(BindingRegistry registry) {
		Set<ServiceDTO> dtos = new HashSet<ServiceDTO>();
		for (BindingInfo bindingInfo : registry.getBindingInfos()) {
			if (bindingInfo.getLeft() instanceof ServiceDTO) {
				dtos.add((ServiceDTO)bindingInfo.getLeft());
			}
			if (bindingInfo.getRight() instanceof ServiceDTO) {
				dtos.add((ServiceDTO)bindingInfo.getRight());
			}
		}
		return dtos;
	}
	
	public Collection<StructuredType> getDTOAndChildrenDTOs(Category category) { 
		List<StructuredType> dtos = new ArrayList<StructuredType>();
		dtos.addAll(getDTOs(category));
		for (Category subCategory : category.getOwnedCategories()) {
			dtos.addAll(getDTOs(subCategory));
		}
		return dtos;
	}
	
	private Collection<ServiceDTO> getDTOs(Category category) {
		List<ServiceDTO> dtos = new ArrayList<ServiceDTO>();
		for (Type type : category.getTypes()) {
			if (type instanceof ServiceDTO) {
				dtos.add((ServiceDTO)type);
			}
		}
		return dtos;
	}
	
	public BindingRegistry getGlobalBindingRegistry(ServiceDTO dto) {
		return getGlobalBindingRegistry((Category)dto.eContainer());
	}
	
	public BindingRegistry getGlobalBindingRegistry(Category category) {
		System system = getContainingSystem(category);
		if (system.getBindingRegistries().isEmpty()) {
			BindingRegistry bindingRegistry = EnvironmentFactory.eINSTANCE.createBindingRegistry();
			system.getBindingRegistries().add(bindingRegistry);
			system.eResource().getContents().add(bindingRegistry);
			return bindingRegistry;
		} else {
			return system.getBindingRegistries().get(0);
		}
	}
	
	private System getContainingSystem(EObject object) {
		EObject container = object.eContainer();
		if (container != null) {
			if (container instanceof System) {
				return (System)container;
			} else {
				return getContainingSystem(container);
			}
		}
		return null;
	}
}
