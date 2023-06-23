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
package org.obeonetwork.database.transfo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityFactory;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

import org.obeonetwork.database.Activator;
import org.obeonetwork.database.transfo.AbstractTransformation;
import org.obeonetwork.database.transfo.util.AdditionalFieldsUtils;
import org.obeonetwork.database.transfo.util.AnnotationHelper;
import org.obeonetwork.database.transfo.util.EntityUtils;
import org.obeonetwork.database.transfo.util.LabelProvider;
import org.obeonetwork.database.transfo.util.ModelUtils;

public class MLDToEntity extends AbstractTransformation {

	private static final String MODEL_ENVIRONMENT_COMMON = "org.obeonetwork.dsl.environment.common/model/obeo.environment";
	private static final URI MODEL_ENVIRONMENT_COMMON_URI = URI.createPlatformPluginURI(MODEL_ENVIRONMENT_COMMON, true);
	
	private TableContainer sourceTableContainer;
	private Map<String, EObject> commonEnvironmentMap;
	private EObject defaultTarget;
	private Resource targetResource;
	
	@Override
	protected boolean prepare(EObject sourceObject, EObject targetObject) {
		if (sourceObject instanceof TableContainer) {
			sourceTableContainer = (TableContainer) sourceObject;
			commonEnvironmentMap = ModelUtils.loadReferences(getResourceSet(), ModelUtils.loadModel(getResourceSet(), MODEL_ENVIRONMENT_COMMON_URI));
			defaultTarget = targetObject;
			targetResource = targetObject.eResource();
			return true;
		}
		return false;
	}
	
	private Map<TableContainer, Namespace> cacheTableContainerToNamespace = new HashMap<TableContainer, Namespace>();
	protected Namespace getTargetNamespace(TableContainer tableContainer) {
		if (!cacheTableContainerToNamespace.containsKey(tableContainer)) {
			Namespace targetNamespace = null;
			// First we look for a namespace with the right name
			String namespaceName = tableContainer.getName();
			// Look for a namespace with the right name
			targetNamespace = getNamespaceByName(namespaceName);
			if (targetNamespace == null) {
				if (defaultTarget instanceof Namespace) {
					if (EntityUtils.getEntitiesInNamespace((Namespace) defaultTarget).isEmpty()) {
						// We consider the namespace is contained is a newly created model
						// we can change its physical name
						targetNamespace = (Namespace) defaultTarget;
						AnnotationHelper.setPhysicalNameAnnotation(targetNamespace, namespaceName);
					}
				} else if (defaultTarget instanceof Root) {
					Root entityRoot = (Root)defaultTarget;
					if (entityRoot.getOwnedNamespaces().size() == 1 && EntityUtils.getEntitiesInNamespace(entityRoot.getOwnedNamespaces().get(0)).isEmpty()) {
						targetNamespace = entityRoot.getOwnedNamespaces().get(0);
						AnnotationHelper.setPhysicalNameAnnotation(targetNamespace, namespaceName);
					}
				}
				// We create a namespace if the target object is a entity root				
				if (targetNamespace == null) {
					targetNamespace = createNamespace(namespaceName);
				}
				// Last solution, can occur only if the default target is a non empty namespace, we then select it
				if (targetNamespace == null) {
					if (defaultTarget instanceof Namespace) {
						targetNamespace = (Namespace)defaultTarget;
					}
				}
			}
			cacheTableContainerToNamespace.put(tableContainer, targetNamespace);
		}
		Namespace namespace = cacheTableContainerToNamespace.get(tableContainer);
		// Ensure description is taken from tableContainer's comments
		namespace.setDescription(tableContainer.getComments());
		
		return namespace;
	}
	
	private Namespace createNamespace(String name) {
		if (defaultTarget instanceof Root) {
			Namespace namespace = EnvironmentFactory.eINSTANCE.createNamespace();
			namespace.setName(name);
			AnnotationHelper.setPhysicalNameAnnotation(namespace, name);
			((Root) defaultTarget).getOwnedNamespaces().add(namespace);
			return namespace;
		}
		return null;
	}
	
	private Namespace getNamespaceByName(String name) {
		for (EObject object : targetResource.getContents()) {
			Namespace namespace = null;
			if (object instanceof Root) {
				namespace = getNamespaceByName((Root)object, name);
			} else if (object instanceof Namespace) {
				namespace = getNamespaceByName((Namespace)object, name);
			}
			if (namespace != null) {
				return namespace;
			}
		}
		return null;
	}
	
	private Namespace getNamespaceByName(Root entityRoot, String name) {
		for (Namespace namespace : entityRoot.getOwnedNamespaces()) {
			Namespace foundNamespace = getNamespaceByName(namespace, name);
			if (foundNamespace != null) {
				return foundNamespace;
			}
		}
		return null;
	}
	
	private Namespace getNamespaceByName(Namespace namespace, String name) {
		String physicalName = AnnotationHelper.getPhysicalName(namespace);
		if (physicalName != null && physicalName.trim().length() > 0) {
			if (name.equals(physicalName)) {
				return namespace;
			}
		} else {
			
			if (name.equals(namespace.getName())) {
				return namespace;
			} else {
				for (Namespace subNamespace : namespace.getOwnedNamespaces()) {
					Namespace foundNamespace = getNamespaceByName(subNamespace, name);
					if (foundNamespace != null) {
						return foundNamespace;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	protected Resource execute() {
		createEntitiesForContainerAndChildren(sourceTableContainer);
		createFKsForContainerAndChildren(sourceTableContainer);
		createIndexesForContainerAndChildren(sourceTableContainer);
		return targetResource;
	}
	
	private void createEntitiesForContainerAndChildren(TableContainer source) {
		createEntities(source);
		// Process children
		if (source instanceof DataBase) {
			DataBase database = (DataBase) source;
			for (Schema schema : database.getSchemas()) {
				createEntities(schema);
			}
		}
	}
	
	private void createEntities(TableContainer source) {
		// Create all entities
		for (AbstractTable abstractTable : source.getTables()) {
			if (abstractTable instanceof Table) {
				Table table = (Table)abstractTable;
				if (!isJoinTable(table)) {
					createEntity(table);
				}
			}
		}
	}

	private void createFKsForContainerAndChildren(TableContainer source) {
		createFKs(source);
		// Process children
		if (source instanceof DataBase) {
			DataBase database = (DataBase) source;
			for (Schema schema : database.getSchemas()) {
				createFKs(schema);
			}
		}
	}
	
	private void createFKs(TableContainer source) {
		// Create all references
		for (AbstractTable t : source.getTables()) {
			if (t instanceof Table) {
				Table table = (Table) t;
				for (ForeignKey foreignKey : table.getForeignKeys()) {
					createReference(foreignKey);
				}
			}
		}
	}
	
	private void createIndexesForContainerAndChildren(TableContainer source) {
		createIndexes(source);
		// Process children
		if (source instanceof DataBase) {
			DataBase database = (DataBase) source;
			for (Schema schema : database.getSchemas()) {
				createIndexes(schema);
			}
		}
	}
	
	/**
	 * For each {@link Index}, a corresponding term in the "PHYSICAL_UNIQUE" annotation is created.
	 * @param source
	 */
	private void createIndexes(TableContainer source) {
		// Create indexes
		for (AbstractTable t : source.getTables()) {
			if (t instanceof Table) {
				// Clear the PHYSICAL_UNIQUE annotation first, its value will be entirely computed based on the indexes.
				Entity entity = getFromOutputTraceabilityMap(t, EntityPackage.Literals.ENTITY);
//				AnnotationHelper.setPhysicalUniqueAnnotation(entity, "");
				for (Index index : ((Table)t).getIndexes()){
					if(index.isUnique()){
						addPhysicalUnique(index);
					}
				}
			}
		}
	}
	
	private void createEntity(Table table) {
		Entity entity = getFromInputTraceabilityMap(table, EntityPackage.Literals.ENTITY);
		if (entity == null) {
			// The entity does not already exist
			// We have to create a new one
			entity = EntityFactory.eINSTANCE.createEntity();
			getTargetNamespace(table.getOwner()).getTypes().add(entity);
			entity.setName(LabelProvider.getEntityNameFromTable(table));
		} else {
			// Ensure description is taken from tableContainer's comments
			if (entity.eContainer() instanceof Namespace) {
				((Namespace)entity.eContainer()).setDescription(table.getOwner().getComments());
			}
		}
		// Add to new traceability map
		addToOutputTraceability(table, entity);
		
		// The following properties are modified even if they already existed
		AnnotationHelper.setPhysicalNameAnnotation(entity, LabelProvider.getEntityPhysicalNameFromTable(table));
		entity.setDescription(table.getComments());
		AnnotationHelper.removePhysicalUniqueAnnotations(entity);
		
		for (Column column : table.getColumns()) {
			if (!column.isInForeignKey() && !column.isInPrimaryKey() && !AdditionalFieldsUtils.isAdditionalColumn(column)) {
				createAttribute(column, entity);
			}
		}
		AnnotationHelper.removePhysicalCheckAnnotations(entity);
		List<Constraint> constraintsToCreate = new ArrayList<Constraint>();
		for (Constraint constraint : table.getConstraints()) {
			if (!AdditionalFieldsUtils.isAdditionalConstraint(constraint)) {
				constraintsToCreate.add(constraint);
			}
		}
		AnnotationHelper.setAllConstraints(entity, constraintsToCreate);
	}
	
	private boolean isJoinTable(Table table) {
		// A join table has a PK containing 2 column swhich are also in FK
		if (table.getPrimaryKey() != null) {
			PrimaryKey pk = table.getPrimaryKey();
			if (pk.getColumns().size() == 2) {
				if (pk.getColumns().get(0).isInForeignKey() && pk.getColumns().get(1).isInForeignKey()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void createAttribute(Column column, Entity entity) {
		// Try to retrieve existing attribute
		Attribute attribute = getFromInputTraceabilityMap(column, EnvironmentPackage.Literals.ATTRIBUTE);
		if (attribute != null) {
			// Ensure the attribute is in the right entity
			if (!EcoreUtil.equals(entity, attribute.getContainingType())) {
				entity.getOwnedAttributes().add(attribute);
			}
		} else {
			// The attribute does not already exist, we have to create one
			attribute = EnvironmentFactory.eINSTANCE.createAttribute();
			entity.getOwnedAttributes().add(attribute);
			attribute.setName(LabelProvider.getAttributeNameFromColumn(column));
		}
		// Add to new traceability map
		addToOutputTraceability(column, attribute);
		
		// The following properties are modified even if they already existed
		AnnotationHelper.setPhysicalNameAnnotation(attribute, LabelProvider.getAttributePhysicalNameFromColumn(column));
		attribute.setDescription(column.getComments());
		AnnotationHelper.setPhysicalDefaultAnnotation(attribute, column.getDefaultValue());
		TypeInstance typeInstance = (TypeInstance)column.getType();
		attribute.setType(resolveType(typeInstance));
		AnnotationHelper.setPhysicalSize(attribute, typeInstance);
		if (column.isNullable()) {
			attribute.setMultiplicity(MultiplicityKind.ZERO_ONE_LITERAL);
		} else {
			attribute.setMultiplicity(MultiplicityKind.ONE_LITERAL);
		}
		AnnotationHelper.removePhysicalUniqueAnnotations(attribute);
		attribute.setIsIdentifier(column.isInPrimaryKey());
	}
	
	private ForeignKey getOppositeFKOnJoinTable(ForeignKey foreignKey) {
		Table sourceTable = foreignKey.getSourceTable();
		if (isJoinTable(sourceTable)) {
			ForeignKey fk1 = sourceTable.getForeignKeys().get(0);
			ForeignKey fk2 = sourceTable.getForeignKeys().get(1);
			if (foreignKey.equals(fk1)) {
				return fk2;
			} else if (foreignKey.equals(fk2)) {
				return fk1;
			}
		}
		return null;
	}
	
	private void createReference(ForeignKey foreignKey) {
		Table sourceTable = foreignKey.getSourceTable();
		boolean isJoinTable = isJoinTable(sourceTable);
		if (isJoinTable) {
			sourceTable = getOppositeFKOnJoinTable(foreignKey).getTargetTable();
		}
		Table targetTable = foreignKey.getTargetTable();

		Entity sourceEntity = getFromOutputTraceabilityMap(targetTable, EntityPackage.Literals.ENTITY);		
		Entity targetEntity = getFromOutputTraceabilityMap(sourceTable, EntityPackage.Literals.ENTITY);
		
		if (targetEntity == null) {
			// Entity was not found in the newly created entities
			// try to retrieve it from additional resources
			String targetTableKey = LabelProvider.getEntityKeyForTable(targetTable);
			EObject sourceObject = getAdditionalResourcesMap().get(targetTableKey);
			if (sourceObject instanceof Entity) {
				targetEntity = (Entity)sourceObject;
			} else {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot resolve entity: " + targetTableKey + " for Reference!"));
				return;
			}
		}
		
		// Try to retrieve existing reference
		Reference reference= getFromInputTraceabilityMap(foreignKey, EnvironmentPackage.Literals.REFERENCE);
		if (reference != null) {
			// Ensure it is contained by the right entity
			if (!EcoreUtil.equals(reference.getContainingType(), sourceEntity)) {
				sourceEntity.getOwnedReferences().add(reference);
			}
			// Ensure it references the right entity
			if (!EcoreUtil.equals(reference.getReferencedType(), targetEntity)) {
				reference.setReferencedType(targetEntity);
			}
		} else {
			boolean nullable = !areAllColumnsNonNullable(foreignKey);			
			String referenceName = LabelProvider.getReferenceNameFromFK(foreignKey);
			Reference reference1 = EnvironmentFactory.eINSTANCE.createReference();
			sourceEntity.getOwnedReferences().add(reference1);
			reference1.setReferencedType(targetEntity);
			reference1.setName(referenceName);
			reference1.setNavigable(true);
			// Define the required multiplicity
			MultiplicityKind multiplicity = (nullable || isJoinTable) ? MultiplicityKind.ZERO_STAR_LITERAL : MultiplicityKind.ONE_STAR_LITERAL;
			reference1.setMultiplicity(multiplicity);
			
			// The reference does not already exist, we have to crate a new one
			reference = reference1;
		}
		addToOutputTraceability(foreignKey, reference);
		
		// The following properties are modified even if they already existed
		reference.setDescription("Contrainte FK avec la table " + sourceTable.getName());
		AnnotationHelper.setPhysicalNameAnnotation(reference, LabelProvider.getReferencePhysicalNameFromFK(foreignKey));
		
		// For join tables, set the oppositeOf property
		if (isJoinTable) {
			ForeignKey oppositeFK = getOppositeFKOnJoinTable(foreignKey);
			// Check if the reference corresponding to the opposite FK has already been created
			Reference oppositeReference = getFromOutputTraceabilityMap(oppositeFK, EnvironmentPackage.Literals.REFERENCE);
			if (oppositeReference != null) {
				reference.setOppositeOf(oppositeReference);
			}
		}
	}

	private boolean areAllColumnsNonNullable(ForeignKey foreignKey) {
		for (ForeignKeyElement fkElement : foreignKey.getElements()) {
			if (fkElement.getFkColumn().isNullable()) {
				return false;
			}
		}
		return true;
	}
	
	private PrimitiveType resolveType(TypeInstance typeInstance) {
		NativeType nativeType = typeInstance.getNativeType();
		if (nativeType != null && nativeType.getName() != null) {
			if (getTypeProperties().containsKey(nativeType.getName())) {
				String entityTypeName = getTypeProperties().getProperty(nativeType.getName());
				if (entityTypeName != null) {
					EObject type = commonEnvironmentMap.get(entityTypeName);
					if (type instanceof PrimitiveType) {
						return (PrimitiveType)type;
					}
				}
			} else {
				System.err.println("Cannot resolve type " + nativeType.getName() + " when scaffolding " + sourceTableContainer.eResource().getURI() );
			}
		}
		return null;
	}
	
	@Override
	protected String getTypePropertiesFileName() {
		return "LogicalTypes-to-Entity.properties";
	}

	private void addPhysicalUnique(Index index) {
		if(index.isUnique()){
			if(index.getElements().size()==1){
				//Add annotation on Attribute
				IndexElement indexElement = index.getElements().get(0);
				String annotationValue = indexElement.isAsc() ? "ASC" : "DESC";
				Attribute uniqueAttribute = getFromOutputTraceabilityMap(indexElement.getColumn(), EnvironmentPackage.Literals.ATTRIBUTE);
				if (uniqueAttribute != null) {
					AnnotationHelper.setPhysicalUniqueAnnotation(uniqueAttribute, annotationValue);
				} else {
					// No attribute was found, it probably means the corresponding column is referenced by a PK or FK
					// We can only handle the FK situation
					if (indexElement.getColumn().isInForeignKey()) {
						// Search the reference corresponding to a FK 
						for (ForeignKey fk : indexElement.getColumn().getForeignKeys()) {
							Reference reference = getFromOutputTraceabilityMap(fk, EnvironmentPackage.Literals.REFERENCE);
							if (reference != null) {
								AnnotationHelper.setPhysicalUniqueAnnotation(reference, annotationValue);
							}
						}
					}
				}
			} else {
				//Add annotation on Table
				Entity entity = getFromOutputTraceabilityMap(index.getOwner(), EntityPackage.Literals.ENTITY);
				// Retrieve the current value of the annotation.
				String annotationValue = AnnotationHelper.getPhysicalUnique(entity);
				
				// Construct the term corresponding to the index being considered.
				String annotationTerm = "";
				int i=0;
				for(IndexElement indexElement:index.getElements()){					
					if(i>0){
						annotationTerm += ",";
					}
					annotationTerm+=indexElement.getColumn().getName()+":";
					if(indexElement.isAsc()){
						annotationTerm += "ASC";
					}else{
						annotationTerm += "DESC";
					}
					i++;
				}

				if(annotationValue != null && !annotationValue.isEmpty()){
					annotationValue += " | ";
				} else if(annotationValue == null){
					annotationValue = "";
				}
				annotationValue += annotationTerm;
				AnnotationHelper.setPhysicalUniqueAnnotation(entity, annotationValue);
			}
		}
	}
}
