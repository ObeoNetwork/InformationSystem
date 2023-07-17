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
package org.obeonetwork.dsl.environment.design.services;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.TypesDefinition;
import org.obeonetwork.dsl.environment.design.ui.CreateStructuredTypesFromOthersWizard;
import org.obeonetwork.dsl.environment.design.wizards.EObjectSelectionInductor;
import org.obeonetwork.dsl.environment.design.wizards.EObjectTreeItemWrapper;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizard;
import org.obeonetwork.dsl.environment.design.wizards.ISObjectSelectionWizardPage.IPageCompleteTester;
import org.obeonetwork.utils.common.EObjectUtils;

public class TypesServices {
	
	private static final String ENTITY = "Entity";
	private static final String DTO = "DTO";
	private static final String DOMAIN_CLASS = "DomainClass";
	
	private static final String ENTITY_PACKAGE_URI = "http://www.obeonetwork.org/dsl/entity/3.0.0";
	private static final String DTO_PACKAGE_URI = "http://www.obeonetwork.org/dsl/environment/3.0.0";
	private static final String DOMAIN_CLASS_PACKAGE_URI = "http://www.obeonetwork.org/dsl/graal/2.0.0";
	private static final Map<String, String> PACKAGES_URI = new HashMap<String, String>();
	static {
		PACKAGES_URI.put(ENTITY, ENTITY_PACKAGE_URI);
		PACKAGES_URI.put(DTO, DTO_PACKAGE_URI);
		PACKAGES_URI.put(DOMAIN_CLASS, DOMAIN_CLASS_PACKAGE_URI);
	}
	
	private static final String ENTITY_ROOT_INSTANCE_CLASS_NAME = "entity.Root";
	private static final String DTO_ROOT_INSTANCE_CLASS_NAME = "soa.System";
	private static final Map<String, String> ROOT_INSTANCE_CLASS_NAME =new HashMap<>();
	static {
		ROOT_INSTANCE_CLASS_NAME.put(ENTITY, ENTITY_ROOT_INSTANCE_CLASS_NAME);
		ROOT_INSTANCE_CLASS_NAME.put(DTO, DTO_ROOT_INSTANCE_CLASS_NAME);
	}
	
	
	public Collection<StructuredType> createTypesFromOtherTypes(Namespace namespace, Collection<StructuredType> types, Collection<Reference> references, String sourceTypeName, String targetTypeName) {
		String nsURI = PACKAGES_URI.get(targetTypeName);
		EFactory eFactory = Registry.INSTANCE.getEFactory(nsURI);
		EPackage ePackage = eFactory.getEPackage();
		EClass eClass = (EClass)ePackage.getEClassifier(targetTypeName);
		
		Map<StructuredType, StructuredType> typesMap = new HashMap<StructuredType, StructuredType>();
		
		Collection<StructuredType> createdStructuredTypes = new ArrayList<StructuredType>();
		// Create types
		for (StructuredType type : types) {
			StructuredType typeCopy = (StructuredType)eFactory.create(eClass);
			typeCopy.setName(type.getName());
			typeCopy.getAssociatedTypes().add(type);
			typeCopy.setDescription(type.getDescription());
			namespace.getTypes().add(typeCopy);
			typesMap.put(type, typeCopy);
			createdStructuredTypes.add(typeCopy);
		}
		
		// Ensure the opposite references are duplicated
		Set<Reference> referencesWithOpposite = new HashSet<>(references);
		for(Reference reference : references) {
			if(reference.getOppositeOf() != null) {
				referencesWithOpposite.add(reference.getOppositeOf());
			}
		}
		createReferencesFromOthers(referencesWithOpposite, typesMap);
		
		return createdStructuredTypes;
	}

	private void createReferencesFromOthers(Collection<Reference> references, Map<StructuredType, StructuredType> structuredTypesMap) {
		
		// Create references
		Map<Reference, Reference> referencesMap = new HashMap<Reference, Reference>();
		for (Reference reference : references) {
			StructuredType sourceType = structuredTypesMap.get(reference.getContainingType());
			StructuredType targetType = structuredTypesMap.get(reference.getReferencedType());
			
			if(sourceType != null && targetType != null) {
				Reference referenceCopy = EnvironmentFactory.eINSTANCE.createReference();
				sourceType.getOwnedReferences().add(referenceCopy);
				referenceCopy.setReferencedType(targetType);
				referenceCopy.setDescription(reference.getDescription());
				referenceCopy.setIsComposite(reference.isIsComposite());
				referenceCopy.setIsIdentifier(reference.isIsIdentifier());
				referenceCopy.setMultiplicity(reference.getMultiplicity());
				referenceCopy.setName(reference.getName());
				referenceCopy.setNavigable(reference.isNavigable());
				
				referencesMap.put(reference, referenceCopy);
			}
		}
		
		// Set opposite references
		references.stream().filter(r -> r.getOppositeOf() != null && references.contains(r.getOppositeOf())).forEach(reference -> {
			Reference referenceCopy = referencesMap.get(reference);
			if (referenceCopy.getOppositeOf() == null) {
				Reference oppositeReferenceCopy = referencesMap.get(reference.getOppositeOf());
				referenceCopy.setOppositeOf(oppositeReferenceCopy);
			}
		});
		
	}
	
	private Collection<Namespace> createNamespacesFromOthers(NamespacesContainer parentContainer, Set<EObject> elementsToCopy, String targetTypeName, String sourceTypeName) {
		
		// A Structured Type supplier
		String nsURI = PACKAGES_URI.get(targetTypeName);
		EFactory eFactory = Registry.INSTANCE.getEFactory(nsURI);
		EPackage ePackage = eFactory.getEPackage();
		EClass eClass = (EClass)ePackage.getEClassifier(targetTypeName);
		Supplier<StructuredType> structuredTypeSupplier = () -> {
			return (StructuredType)eFactory.create(eClass);
		};
		
		// Start the copy from the root namespaces
    	List<Namespace> rootNamespaces = elementsToCopy.stream()
    	.filter(Namespace.class::isInstance).map(Namespace.class::cast)
    	.filter(n -> !EObjectUtils.getAncestors(n).stream().anyMatch(a -> elementsToCopy.contains(a)))
    	.collect(toList());
    	
    	Map<StructuredType, StructuredType> structuredTypesMap = new HashMap<StructuredType, StructuredType>();
    	
    	// Create the copies of each root namespace
    	List<Namespace> rootNamespacesCopy = new ArrayList<>();
    	for(Namespace rootNamespace : rootNamespaces) {
    		rootNamespacesCopy.add(createNamespaceFromOther(parentContainer, rootNamespace, elementsToCopy, structuredTypeSupplier, structuredTypesMap));
    	}
    	
    	// Create the copies of the references
    	createReferencesFromOthers(elementsToCopy.stream().filter(Reference.class::isInstance).map(Reference.class::cast).collect(toList()), structuredTypesMap);
    	
		return rootNamespacesCopy;
	}
	
	private Namespace createNamespaceFromOther(NamespacesContainer parentContainer, Namespace namespace, Set<EObject> elementsToCopy, Supplier<StructuredType> structuredTypeSupplier, Map<StructuredType, StructuredType> structuredTypesMap) {
		
		// Copy the Namespace
		Namespace namespaceCopy = EnvironmentFactory.eINSTANCE.createNamespace();
		namespaceCopy.setName(namespace.getName());
		namespaceCopy.setDescription(namespace.getDescription());
		parentContainer.getOwnedNamespaces().add(namespaceCopy);
		
		// Copy the owned Structured Types
		namespace.getTypes().stream().filter(StructuredType.class::isInstance).map(StructuredType.class::cast)
		.filter(structuredType -> elementsToCopy.contains(structuredType))
		.forEach(structuredType -> {
			StructuredType structuredTypeCopy = structuredTypeSupplier.get();
			structuredTypeCopy.setName(structuredType.getName());
			structuredTypeCopy.setDescription(structuredType.getDescription());
			structuredTypeCopy.getAssociatedTypes().add(structuredType);
			namespaceCopy.getTypes().add(structuredTypeCopy);
			structuredTypesMap.put(structuredType, structuredTypeCopy);
		});
		
		// Copy the owned namespaces
		namespace.getOwnedNamespaces().stream()
		.filter(ns -> elementsToCopy.contains(ns)).forEach(ownedNamespace -> {
			createNamespaceFromOther(namespaceCopy, ownedNamespace, elementsToCopy, structuredTypeSupplier, structuredTypesMap);
		});
		
		return namespaceCopy;
	}

	private StructuredType getStructuredTypeFromEdgeTarget(EdgeTarget edgeTarget) {
		if (edgeTarget instanceof DSemanticDecorator) {
			EObject semanticElement = ((DSemanticDecorator) edgeTarget).getTarget();
			if (semanticElement instanceof StructuredType) {
				return (StructuredType)semanticElement;
			}
		}
		return null;
	}
	
	/**
	 * Create an inheritance relationship using the reconnect edge to retrieve the supertype. 
	 * Do nothing and displays an information dialog if the new inheritance would cause a cycle.
	 * @param newSubTypeCandidate
	 * @param edgeView Edge used to retrieve the super type (i.e.the edge's target node)
	 * @return
	 */
	public StructuredType reconnectSourceOnInheritanceEdge(final StructuredType newSubTypeCandidate, final StructuredType previousSubType, final DEdge edgeView) {
		StructuredType superTypeCandidate = getStructuredTypeFromEdgeTarget(edgeView.getTargetNode());
		
		if (previousSubType != null && superTypeCandidate != null) {
			if (isSubtype(superTypeCandidate, newSubTypeCandidate)) {
				// The new superType is already a sub-type of the subtype candidate
				// setting the new inheritance relationship would lead to a cycle
				// We warn the user that this is not possible
				new UIServices().displayInfo(newSubTypeCandidate,
												"Creation of inheritance relationship not allowed !",
												"Creation has been cancelled.\n\n" +
												newSubTypeCandidate.getName() + " is already a super-type of " + superTypeCandidate.getName() + ".\n"
												+ "The new inheritance relationship would cause a cycle which is not allowed.");
			} else {
				// Remove old inheritance
				previousSubType.setSupertype(null);
				newSubTypeCandidate.setSupertype(superTypeCandidate);
			}
		}
		return newSubTypeCandidate;
	}
	
	/**
	 * Create an inheritance relationship between 2 types.
	 * Do nothing and displays an information dialog if the new inheritance would cause a cycle.
	 * @param subTypeCandidate
	 * @param superTypeCandidate
	 * @return
	 */
	public StructuredType createInheritance(final StructuredType subTypeCandidate, final StructuredType superTypeCandidate) {
		if (isSubtype(superTypeCandidate, subTypeCandidate)) {
			// The new superType is already a sub-type of the subtype candidate
			// setting the new inheritance relationship would lead to a cycle
			// We warn the user that this is not possible
			new UIServices().displayInfo(subTypeCandidate,
											"Creation of inheritance relationship not allowed !",
											"Creation has been cancelled.\n\n" +
											subTypeCandidate.getName() + " is already a super-type of " + superTypeCandidate.getName() + ".\n"
											+ "The new inheritance relationship would cause a cycle which is not allowed.");
		} else {
			subTypeCandidate.setSupertype(superTypeCandidate);
		}
		return subTypeCandidate;
	}
	
	/**
	 * Returns <code>true</code> if <code>childCandidate</code> is a sub type of
	 * <code>parentCandidate</code>.
	 * 
	 * @param childCandidate
	 *            a non <code>null</code> type.
	 * @param parentCandidate
	 *            a non <code>null</code> type.
	 * @return
	 */
	private boolean isSubtype(final StructuredType childCandidate, final StructuredType parentCandidate) {
		StructuredType currentChild = childCandidate;
		while (currentChild != null) {
			if (currentChild == parentCandidate) {
				return true;
			} 
			currentChild = currentChild.getSupertype(); // Iterate on super types
		}
		return false;
	}

	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestorsDomainClassesRoots(Namespace namespace, DSemanticDiagram diagram) {
		return getRootElementsFromCollection(getAllSelectableExternalStructuredTypesWithAncestorsDomainClasses(namespace, diagram));
	}
	
	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestorsDTOsRoots(Namespace namespace, DSemanticDiagram diagram) {
		return getRootElementsFromCollection(getAllSelectableExternalStructuredTypesWithAncestorsDTOs(namespace, diagram));
	}
	
	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestorsEntitiesRoots(Namespace namespace, DSemanticDiagram diagram) {
		return getRootElementsFromCollection(getAllSelectableExternalStructuredTypesWithAncestorsEntities(namespace, diagram));
	}
	
	private Collection<EObject> getRootElementsFromCollection(Collection<EObject> elements) {
		Collection<EObject> result = new ArrayList<EObject>();
		for (EObject element : elements) {
			if (element.eContainer() == null) {
				result.add(element);
			}
		}
		return result;
	}

	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestorsDTOs(Namespace namespace, DSemanticDiagram diagram) {
		return getAllSelectableExternalStructuredTypesWithAncestors(namespace, diagram, DTO);
	}
	
	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestorsEntities(Namespace namespace, DSemanticDiagram diagram) {
		return getAllSelectableExternalStructuredTypesWithAncestors(namespace, diagram, ENTITY);
	}
	
	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestorsDomainClasses(Namespace namespace, DSemanticDiagram diagram) {
		return getAllSelectableExternalStructuredTypesWithAncestors(namespace, diagram, DOMAIN_CLASS);
	}
	
	public Collection<EObject> getAllSelectableExternalStructuredTypesWithAncestors(Namespace namespace, DSemanticDiagram diagram, String typeName) {
		Collection<EObject> result = new HashSet<EObject>();
		Collection<StructuredType> selectableTypes = getAllSelectableExternalStructuredTypes(namespace, diagram, typeName);
		result.addAll(selectableTypes);
		for (StructuredType selectableType : selectableTypes) {
			result.addAll(EObjectUtils.getAncestors(selectableType));
		}
		
		return result;
	}
	
	public Collection<StructuredType> getAllSelectableExternalStructuredTypes(Namespace namespace, DSemanticDiagram diagram, String typeName) {
		Collection<StructuredType> notReferencedTypes = getAllNotReferencedStructuredTypes(namespace, diagram);
		
		// Remove already displayed types
		Set<StructuredType> types = DesignServices.getDisplayedStructuredTypes(diagram);
		notReferencedTypes.removeAll(types);
		
		Collection<StructuredType> selectableTypes = new ArrayList<StructuredType>();
		// Keep only types of the specified typeName
		for (StructuredType structuredType : notReferencedTypes) {
			if (typeName == null || typeName.isEmpty() || typeName.equals(structuredType.eClass().getName())) {
				selectableTypes.add(structuredType);
			}
		}
		
		return selectableTypes;
	}
	
	public Collection<StructuredType> getAllNotReferencedStructuredTypes(Namespace namespace, DSemanticDiagram diagram) {
		Collection<StructuredType> notReferencedTypes = getAllStructuredTypes(namespace, null);
		
		// We have to remove from this list
		// the types contained in the current namespace
		notReferencedTypes.removeAll(namespace.getTypes());
		// the referenced types
		notReferencedTypes.removeAll(getAllReferencedStructuredTypes(namespace, diagram));
		
		return notReferencedTypes;
	}
	
	public Collection<StructuredType> getAllReferencedStructuredTypes(Namespace namespace, DSemanticDiagram diagram) {
		Set<StructuredType> types = DesignServices.getDisplayedStructuredTypes(diagram);
		types.retainAll(namespace.getTypes());
		
		Collection<StructuredType> referencedTypes = new HashSet<StructuredType>();
		
		for (StructuredType existingType : types) {
			referencedTypes.add(existingType.getSupertype());
			for (Reference reference : existingType.getOwnedReferences()) {
				referencedTypes.add(reference.getReferencedType());
			}
			referencedTypes.addAll(getAllReferencingStructuredTypes(existingType));
		}
		
		referencedTypes.removeAll(namespace.getTypes());
		
		return referencedTypes;
	}
	
	private Collection<StructuredType> getAllReferencingStructuredTypes(StructuredType referencedType) {
		Collection<StructuredType> referencingTypes = new HashSet<StructuredType>();
		
		Session session = new EObjectQuery(referencedType).getSession();
		Collection<Setting> inverseReferences = null;
		ECrossReferenceAdapter xReferencer = null;
		if (session != null) {
			xReferencer = session.getSemanticCrossReferencer();
		}
		
		if (xReferencer != null) {
			inverseReferences = xReferencer.getInverseReferences(referencedType);
		} else {
			if (referencedType.eResource() != null && referencedType.eResource().getResourceSet() != null) {
				inverseReferences = UsageCrossReferencer.find(referencedType, referencedType.eResource().getResourceSet());
			}
		}
		
		if (inverseReferences != null) {
			for (Setting setting : inverseReferences) {
				if (setting.getEObject() instanceof StructuredType && setting.getEStructuralFeature() == EnvironmentPackage.Literals.STRUCTURED_TYPE__SUPERTYPE) {
					referencingTypes.add((StructuredType)setting.getEObject());
				}else if (setting.getEObject() instanceof Reference && setting.getEStructuralFeature() == EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE) {
					referencingTypes.add(((Reference)setting.getEObject()).getContainingType());
				}
			}
		}
		
		return referencingTypes;
	}
	
	public Collection<StructuredType> openCreateEntitiesFromDTOsWizard(Namespace namespace) {
		return openCreateTypesFromOthersWizard(namespace, ENTITY, DTO);
	}
	
	public Collection<StructuredType> openCreateDTOsFromEntitiesWizard(Namespace namespace) {
		return openCreateTypesFromOthersWizard(namespace, DTO, ENTITY);
	}
	
	private Collection<StructuredType> openCreateTypesFromOthersWizard(Namespace namespace, String targetTypeName, String sourceTypeName) {
		Shell shell = Display.getDefault().getActiveShell();
		CreateStructuredTypesFromOthersWizard wizard = new CreateStructuredTypesFromOthersWizard(namespace, targetTypeName, sourceTypeName);
		WizardDialog dlg = new WizardDialog(shell, wizard);
		if (dlg.open() == Window.OK) {
			return wizard.getCreatedTypes();
		} else {
			return new ArrayList<StructuredType>();
		}
	}
	
	public Collection<Namespace> openCreateEntityNamespacesFromDTONamespacesWizard(NamespacesContainer contextNamespaceContainer) {
		return openCreateNamespacesFromOthersWizard(contextNamespaceContainer, ENTITY, DTO);
	}
	
	public Collection<Namespace> openCreateDTONamespacesFromEntityNamespacesWizard(NamespacesContainer contextNamespaceContainer) {
		return openCreateNamespacesFromOthersWizard(contextNamespaceContainer, DTO, ENTITY);
	}
	
	private Collection<Namespace> openCreateNamespacesFromOthersWizard(NamespacesContainer contextNamespaceContainer, String targetTypeName, String sourceTypeName) {
		
		IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(contextNamespaceContainer);
		
		String windowTitle = String.format("Create Namespace from %s Namespace", sourceTypeName);
		String message = "Select Namespaces, Entities and References";
		
		List<EObject> roots = contextNamespaceContainer.eResource().getResourceSet().getResources().stream()
		.flatMap(r -> r.getContents().stream())
		.filter(e -> e.eClass().getInstanceClassName().endsWith(ROOT_INSTANCE_CLASS_NAME.get(sourceTypeName)))
		.collect(toList());
		
		interpreter.setVariable("roots", roots);
		String childrenExpression = "aql:self.eContents()->select(e|"
				+ "e.oclIsKindOf(environment::Namespace) or "
				+ "e.oclIsKindOf(environment::StructuredType) or "
				+ "(e.oclIsKindOf(environment::Reference) and e.referencedType.ancestors()->intersection(roots)->notEmpty()))";
		String selectableCondition = "aql:self.oclIsTypeOf(environment::Namespace) or self.oclIsKindOf(environment::StructuredType) or self.oclIsKindOf(environment::Reference)";
		EObjectTreeItemWrapper input = new EObjectTreeItemWrapper(interpreter, childrenExpression, selectableCondition);
		
		for(EObject root : roots) {
			new EObjectTreeItemWrapper(input, root);
		}
		
        final ISObjectSelectionWizard wizard = new ISObjectSelectionWizard(
        		windowTitle, 
        		message, 
        		null, 
        		input,
        		true);
		
        wizard.setLevelToExpand(3);
        
        // When a reference is selected, select the referenced type
        EObjectSelectionInductor eObjectSelectionInductor = new EObjectSelectionInductor(input) {
			@Override
			public List<EObject> selectEObject(EObject selected) {
				List<EObject> inducedSelectedEObjects = new ArrayList<>();
				if(selected instanceof Reference) {
					inducedSelectedEObjects.add(((Reference) selected).getReferencedType());
				}
				return inducedSelectedEObjects;
			}
		};
        wizard.setSelectionInductor(eObjectSelectionInductor);
        
        IPageCompleteTester pageCompleteTester = new IPageCompleteTester() {
			@Override
			public boolean isPageComplete(Collection<EObjectTreeItemWrapper> selectedTreeItemWrapers, Collection<EObjectTreeItemWrapper> partiallySelectedTreeItemWrapers) {
				List<EObjectTreeItemWrapper> allTreeItemWrappers = new ArrayList<>();
				allTreeItemWrappers.addAll(selectedTreeItemWrapers);
				allTreeItemWrappers.addAll(partiallySelectedTreeItemWrapers);
				
				return allTreeItemWrappers.stream()
				.filter(tiw -> tiw.isSelectable())
				.map(tiw -> tiw.getWrappedEObject())
				.anyMatch(Namespace.class::isInstance);
			}
		};
		wizard.setPageCompleteTester(pageCompleteTester);
        
        Collection<Namespace> rootNamespacesCopy = Collections.emptyList();
        if(wizard.open() == Window.OK) {
        	Set<EObject> allSelectedElements = new HashSet<>();
        	allSelectedElements.addAll(wizard.getSelectedEObjects());
        	// Are also considered as selected the selectable partially selected elements
        	wizard.getPartiallySelectedTreeItemWrappers().stream()
        	.filter(tiw -> tiw.isSelectable())
        	.forEach(tiw -> {
        		allSelectedElements.add(tiw.getWrappedEObject());
        	});
        	
        	rootNamespacesCopy = createNamespacesFromOthers(contextNamespaceContainer, allSelectedElements, targetTypeName, sourceTypeName);
        }
        
        interpreter.unSetVariable("roots");
        
        return rootNamespacesCopy;
	}
	
	public Collection<StructuredType> getAllStructuredTypes(EObject context, String typeName) {
		Collection<StructuredType> types = new ArrayList<StructuredType>();
		
		Collection<Resource> resources = EObjectUtils.getAllResources(context);
		for (Resource resource : resources) {
			for (EObject object : resource.getContents()) {
				if (object instanceof ObeoDSMObject) {
					types.addAll(internalGetAllChildrenStructuredTypes((ObeoDSMObject)object, typeName));
				}
			}
		}
		return types;
	}
	
	public Collection<StructuredType> getAllStructuredTypesDTOs(EObject context) {
		return getAllStructuredTypes(context, DTO);
	}
	
	public Collection<StructuredType> getAllStructuredTypesEntities(EObject context) {
		return getAllStructuredTypes(context, ENTITY);
	}
	
	public Collection<StructuredType> getAllStructuredTypesDomainClasses(EObject context) {
		return getAllStructuredTypes(context, DOMAIN_CLASS);
	}
	
	private Collection<StructuredType> internalGetAllChildrenStructuredTypes(ObeoDSMObject parent, String typeName) {
		Collection<StructuredType> types = new ArrayList<StructuredType>();
		
		TreeIterator<EObject> eAllContents = parent.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof StructuredType) {
				// If the type is not specified we do not check on the type
				if (typeName == null || typeName.isEmpty() || typeName.equals(eObject.eClass().getName())) {
					types.add((StructuredType)eObject);
				}
			}
		}
		return types;
	}
	
	public Collection<ObeoDSMObject> getRootNamespaceContainersOrTypesDefinition(Collection<StructuredType> types) {
		Collection<ObeoDSMObject> result = new ArrayList<ObeoDSMObject>();
		Collection<ObeoDSMObject> allContainers = new ArrayList<ObeoDSMObject>();
		collectAllContainers(types, allContainers);
		
		// We have all containers of types NamespacesContainer or TypesDefinition
		// we will keep only those whoose own parent is not in the list
		for (ObeoDSMObject container : allContainers) {
			if (container.eContainer() == null || !allContainers.contains(container.eContainer())) {
				result.add(container);
			}
		}
		
		return result;
	}
	
	private void collectAllContainers(Collection<? extends EObject> elements, Collection<ObeoDSMObject> containers) {
		Collection<EObject> newContainers = new ArrayList<EObject>();
		for (EObject element : elements) {
			EObject container = element.eContainer();
			if (container instanceof NamespacesContainer || container instanceof TypesDefinition) {
				if (!containers.contains(container)) {
					containers.add((ObeoDSMObject)container);					
					newContainers.add((EObject)container);
				}
			}
		}
		if (!newContainers.isEmpty()) {
			collectAllContainers(newContainers, containers);
		}
	}

	public PrimitiveType getStringPrimitiveType(EObject object){
		PrimitiveType primitiveType = getPrimitiveType(object, "String");
		return primitiveType;
	}
	
	private PrimitiveType getPrimitiveType(EObject context, String name){		
		Collection<Resource> resources = EObjectUtils.getAllResources(context);
		for (Resource resource : resources) {
			for (EObject object : resource.getContents()) {
				if (object instanceof Environment || object instanceof TypesDefinition) {
					// Types must exist below an environment or types definition					
					TreeIterator<?> iterator = object.eAllContents();
					while(iterator.hasNext()){
						Object o = iterator.next();
						if (o instanceof PrimitiveType) {
							PrimitiveType type = (PrimitiveType)o;
							if (name.equalsIgnoreCase(type.getName())) {
								return type;
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static String getNamespaceQualifiedName(StructuredType structuredType) {
		return EObjectUtils
					.getAncestors(structuredType)
					.stream()
					.filter(Namespace.class::isInstance)
					.map(Namespace.class::cast)
					.map(Namespace::getName)
					.collect(joining("/"));
  }
	
	public static Collection<Attribute> getAssociatedTypesAttributes(StructuredType type) {
		return type .getAssociatedTypes()
					.stream()
					.map(StructuredType::getAttributes)
					.flatMap(EList::stream)
					.collect(toList());
	}
}
