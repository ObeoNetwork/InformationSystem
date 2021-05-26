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
package fr.gouv.mindef.safran.database.transfo.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.TableLayout;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DataType;
import org.obeonetwork.dsl.environment.Enumeration;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Literal;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Namespace;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import com.google.common.base.Joiner;

import fr.gouv.mindef.safran.database.Activator;
import fr.gouv.mindef.safran.database.transfo.AbstractTransformation;
import fr.gouv.mindef.safran.database.transfo.util.AdditionalFieldsUtils;
import fr.gouv.mindef.safran.database.transfo.util.AnnotationHelper;
import fr.gouv.mindef.safran.database.transfo.util.EntityUtils;
import fr.gouv.mindef.safran.database.transfo.util.LabelProvider;
import fr.gouv.mindef.safran.database.transfo.util.StringUtils;

public class EntityToMLD extends AbstractTransformation {
	
	private static final String DISABLE_ADDITIONAL_FIELDS_KEY = "DISABLE_ADDITIONAL_FIELDS_KEY";
	
	private static final String VALIDITY_COLUMN_COMMENTS = "Indicateur pour savoir si l'enregistrement est valide";
	private static final String VALIDITY_COLUMN_TYPE = "Texte";
	
	private static final String VALIDITY_COLUMN_DEFAULT = "'0'";
	private static final String VALIDITY_CONSTRAINT_COMMENTS = "Liste des valeurs possibles pour {0}";
	private static final int VALIDITY_COLUMN_TYPE_LENGTH = 1;
	
	private static final String DATE_COLUMN_COMMENT = "Date de mise à jour de la ligne";
	private static final String DATE_COLUMN_TYPE = "Date";
	
	private static final String ENUM_COLUMN_TYPE = "Texte";
	private static final String ENUM_CONSTRAINTS_COMMENTS = "Liste des valeurs possibles pour {0}";
	
	private ArrayList<Namespace> sourceNamespaces;
	private Resource targetResource;
	private EObject defaultTarget;
	private Map<String, NativeType> nativeTypesMap;
	private Map<Table, Map<String, Integer>> counters = new HashMap<Table, Map<String,Integer>>();
	
	@Override
	protected boolean prepare(EObject sourceObject, EObject targetObject) {
		if (targetObject instanceof TableContainer) {
			sourceNamespaces = new ArrayList<Namespace>();
			if (sourceObject instanceof Root) {
				Root sourceRoot = (Root) sourceObject;
				sourceNamespaces.addAll(sourceRoot.getOwnedNamespaces());
			} else if (sourceObject instanceof Namespace) {
				sourceNamespaces.add((Namespace) sourceObject);
			}
			targetResource = targetObject.eResource();
			defaultTarget = targetObject;
			ResourceSet resourceSet = null;
			if (targetResource != null) {
				resourceSet = targetResource.getResourceSet();
			}
			nativeTypesMap = loadTypesLibrary(resourceSet);
			return (!nativeTypesMap.isEmpty());
		}
		return false;
	}
	
	private Map<Namespace, TableContainer> cacheNamespaceToTableContainer = new HashMap<Namespace, TableContainer>();
	protected TableContainer getTargetTableContainer(Namespace namespace ) {
		if (!cacheNamespaceToTableContainer.containsKey(namespace)) {
			TableContainer target = null;
			// First we look for a schema with the right name
			String schemaName = getSchemaNameFromNamespace(namespace);
			// Look for a schema with the right name
			target = getSchemaByName(schemaName);
			if (target == null) {
				if (defaultTarget instanceof Schema) {
					if (((Schema) defaultTarget).getTables().isEmpty()) {
						// We consider the schema is contained is a newly created model
						// we can change its name
						target = (Schema) defaultTarget;
						target.setName(schemaName);
					}
				} else if (defaultTarget instanceof DataBase) {
					DataBase database = (DataBase)defaultTarget;
					if (database.getSchemas().size() == 1 && database.getSchemas().get(0).getTables().isEmpty()) {
						target = database.getSchemas().get(0);
						target.setName(schemaName);
					}
				}
				// We create a schema if the target object is a database				
				if (target == null) {
					target = createSchema(schemaName);
				}
				// Last solution
				if (target == null && defaultTarget instanceof TableContainer) {
					target = (TableContainer)defaultTarget;
				}
			}
			cacheNamespaceToTableContainer.put(namespace, target);
		}
		
		// Ensure schema comments are retrieved from namespace
		TableContainer tableContainer = cacheNamespaceToTableContainer.get(namespace);
		tableContainer.setComments(namespace.getDescription());
		
		return tableContainer;
	}

	private String getSchemaNameFromNamespace(Namespace namespace) {
		String schemaName = AnnotationHelper.getPhysicalName(namespace);
		if (schemaName == null) {
			schemaName = namespace.getName();
		}
		// Sanitize name
		if (schemaName != null) {
			schemaName = StringUtils.toSqlNotation(schemaName);
		}
		return schemaName;
	}
	
	private Schema createSchema(String name) {
		if (defaultTarget instanceof DataBase) {
			Schema schema = DatabaseFactory.eINSTANCE.createSchema();
			schema.setName(name);
			((DataBase) defaultTarget).getSchemas().add(schema);
			return schema;
		}
		return null;
	}
	
	private Schema getSchemaByName(String name) {
		for (EObject object : targetResource.getContents()) {
			if (object instanceof Schema) {
				Schema schema = (Schema)object;
				if (name.equals(schema.getName())) {
					return schema;
				}
			} else if (object instanceof DataBase) {
				for (Schema schema : ((DataBase) object).getSchemas()) {
					if (name.equals(schema.getName())) {
						return schema;
					}
				}
			}
		}
		return null;
	}

	@Override
	protected Resource execute() {
		processNamespaces(sourceNamespaces);
		return targetResource;
	}
	
	private void processNamespaces(List<Namespace> sourceNamespaces) {
		for (Namespace source : sourceNamespaces) {
			processNamespaceAndCreateStructures(source);
		}
		for (Namespace source : sourceNamespaces) {
			processNamespaceAndCreateRelations(source);
		}
		for (Namespace source : sourceNamespaces) {
			processNamespaceAndHandleMultipleFKs(source);
		}
		for (Namespace source : sourceNamespaces) {
			processNamespaceAndCreateIndices(source);
		}
		for (Namespace source : sourceNamespaces) {
			processNamespaceAndCreateAdditionalFields(source);
		}
	}
	
	private void processNamespaceAndCreateStructures(Namespace namespace) {
		//create tables
		for (Entity entity : EntityUtils.getEntitiesInNamespace(namespace)) {
			createTable(entity);
		}
		// process sub-namespaces
		for (Namespace subnamespace : namespace.getOwnedNamespaces()) {
			processNamespaceAndCreateStructures(subnamespace);
		}
	}
	
	private void processNamespaceAndCreateRelations(Namespace namespace) {
		// create foreignkeys
		for (Entity entity : EntityUtils.getEntitiesInNamespace(namespace)) {
			for (Reference reference : EntityUtils.getOwnedEntitiesReferences(entity)) {
				createForeignKey(reference);
			}
		}
		// process sub-namespaces
		for (Namespace subnamespace : namespace.getOwnedNamespaces()) {
			processNamespaceAndCreateRelations(subnamespace);
		}
	}
	
	private void processNamespaceAndHandleMultipleFKs(Namespace namespace) {
		// create foreignkeys
		for (Entity entity : EntityUtils.getEntitiesInNamespace(namespace)) {
			Table table =getFromOutputTraceabilityMap(entity, DatabasePackage.Literals.TABLE);
			if (table != null) {
				handleMultipleForeignKeys(table);
			}
		}
		// process sub-namespaces
		for (Namespace subnamespace : namespace.getOwnedNamespaces()) {
			processNamespaceAndHandleMultipleFKs(subnamespace);
		}
	}
	
	private void processNamespaceAndCreateIndices(Namespace namespace) {
		//create tables
		for (Entity entity : EntityUtils.getEntitiesInNamespace(namespace)) {
			createIndices(entity);
		}
		// process sub-namespaces
		for (Namespace subnamespace : namespace.getOwnedNamespaces()) {
			processNamespaceAndCreateIndices(subnamespace);
		}
	}
	
	private void processNamespaceAndCreateAdditionalFields(Namespace namespace) {
		//create tables
		for (Entity entity : EntityUtils.getEntitiesInNamespace(namespace)) {
			// Create technical fields
			Table table = getFromOutputTraceabilityMap(entity, DatabasePackage.Literals.TABLE);
			createAdditionalFields(table);
		}
		// process sub-namespaces
		for (Namespace subnamespace : namespace.getOwnedNamespaces()) {
			processNamespaceAndCreateAdditionalFields(subnamespace);
		}
	}
	
	private void handleMultipleForeignKeys(Table table) {
		// multipleFKs contains foreign keys targetting a same table (the table is used as key)
		Map<Table, List<ForeignKey>> multipleFKs = new HashMap<Table, List<ForeignKey>>();
		for (ForeignKey fk : table.getForeignKeys()) {
			for (ForeignKey otherFK : table.getForeignKeys()) {
				Table targetTable = fk.getTargetTable();
				if (fk != otherFK && targetTable == otherFK.getTargetTable()) {
					if (multipleFKs.get(targetTable) == null) {
						multipleFKs.put(targetTable, new ArrayList<ForeignKey>());
					}
					if (!multipleFKs.get(targetTable).contains(otherFK)) {
						multipleFKs.get(targetTable).add(otherFK);
					}
				}
			}
		}
		

		// Rename columns targetted by the FKs
		for (List<ForeignKey> fks : multipleFKs.values()) {
			int counter = 0;
			
			// Sort FKs
			List<ForeignKey> sortedFks = new ArrayList<ForeignKey>(fks);
			Collections.sort(sortedFks, new Comparator<ForeignKey>() {

				@Override
				public int compare(ForeignKey fk1, ForeignKey fk2) {
					return columnIndex(fk1.getElements().get(0).getFkColumn()) - columnIndex(fk2.getElements().get(0).getFkColumn());
				}
				
				private int columnIndex(Column column) {
					return column.getOwner().getColumns().indexOf(column);
				}
				
			});
			
			for (ForeignKey fk : sortedFks) {
				counter = counter + 1;
				for (ForeignKeyElement fkElt : fk.getElements()) {
					fkElt.getFkColumn().getOwner().getColumns().indexOf(fkElt.getFkColumn());
					fkElt.getFkColumn().setName(getFKColumnName(fkElt, counter));
				}
			}
		}
	}
	
	private String getFKColumnName(ForeignKeyElement fkElement, int counter) {
		return fkElement.getPkColumn().getOwner().getName() + "_" + counter + "_ID";
	}
	
	private void createForeignKey(Reference reference) {
		// Add tests on references which should not be treated
		if (isValidForFK(reference)) {
			handleForeignKey(reference);
		} else {
			String message = "The reference " + EntityUtils.getContainingEntity(reference).getName() + "." + reference.getName() + "is not valid.";
			message += "\nIt has an opposite reference, both are navigable or non navigable and their multiplicity is either 0..1 or 1.";
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
			return;
		}
	}

	private void handleForeignKey(Reference reference) {
		Table targetTable = getFromOutputTraceabilityMap(EntityUtils.getContainingEntity(reference), DatabasePackage.Literals.TABLE);
		
		Entity targetEntity = EntityUtils.getReferencedEntity(reference);
		if (targetEntity == null) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No entity referenced by " + EntityUtils.getContainingEntity(reference).getName() + "." + reference.getName()));
			return;
		}
		Table sourceTable = getFromOutputTraceabilityMap(targetEntity, DatabasePackage.Literals.TABLE);
		if (sourceTable == null) {
			// Table was not found among the newly created tables
			// try to retrieve it from additional resources
			String targetEntityKey = LabelProvider.getTableKeyForEntity(targetEntity);
			EObject targetObject = getAdditionalResourcesMap().get(targetEntityKey);
			if (targetObject instanceof Table) {
				sourceTable = (Table)targetObject;
			} else {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot resolve table: " + targetEntityKey + " for Reference!"));
				return;
			}
		}
		
		if (shouldCreateJoinTable(reference)) {
			createJoinTable(reference, sourceTable, targetTable);
		} else {
			boolean nullable = getNullableValueForFK(reference);
			
			if (shouldCreateFKInSource(reference)) {
				createForeignKey(reference, targetTable, sourceTable, nullable);
			} else if (shouldCreateFKInTarget(reference)) {
				createForeignKey(reference, sourceTable, targetTable, nullable);
			}
		}
		
	}
	
	private boolean isAloneReference(Reference reference) {
		return reference.getOppositeOf() == null;
	}
	
	private boolean isDoubleReference(Reference reference) {
		return reference.getOppositeOf() != null && reference.isNavigable() == reference.getOppositeOf().isNavigable();
	}
	
	private boolean isReferenceWithNonNavigableOpposite(Reference reference) {
		return reference.getOppositeOf() != null && reference.isNavigable() && !reference.getOppositeOf().isNavigable();
	}
	
	/**
	 * Invalid case when
	 * - the reference has an opposite
	 * - the reference and its opposite have a multiplicity of 0..1 or 1
	 * - the reference and its opposite have the same value for isNavigable
	 * @param reference
	 * @return
	 */
	private boolean isValidForFK(Reference reference) {
		return !(isDoubleReference(reference) && isMultiplicitySimple(reference) && isMultiplicitySimple(reference.getOppositeOf()));
	}
	
	private boolean shouldCreateFKInSource(Reference reference) {
		return	isMultiplicitySimple(reference)
				&& (
						isAloneReference(reference)
						||
						isReferenceWithNonNavigableOpposite(reference)
						||
						(isDoubleReference(reference) && isMultiplicityMany(reference.getOppositeOf()))
				);
	}
	
	private boolean shouldCreateFKInTarget(Reference reference) {
		return 	isMultiplicityMany(reference)
				&& (
					isAloneReference(reference)
					||
					(isReferenceWithNonNavigableOpposite(reference) && isMultiplicitySimple(reference.getOppositeOf()))
				);
	}
	
	private boolean shouldCreateJoinTable(Reference reference) {
		return	!isAloneReference(reference)
				&& isMultiplicityMany(reference)
				&& isMultiplicityMany(reference.getOppositeOf());
	}
	
	private boolean getNullableValueForFK(Reference reference) {
		return !(
					(reference.getMultiplicity() == MultiplicityKind.ONE_LITERAL &&(isAloneReference(reference) || isReferenceWithNonNavigableOpposite(reference) || isDoubleReference(reference)))
					||
					(isReferenceWithNonNavigableOpposite(reference) && isMultiplicityMany(reference) && reference.getOppositeOf().getMultiplicity() == MultiplicityKind.ONE_LITERAL)
				);
				
	}
	
	private void createJoinTable(Reference reference, Table sourceTable, Table targetTable) {
		if (getFromOutputTraceabilityMap(reference, DatabasePackage.Literals.TABLE) != null
				|| getFromOutputTraceabilityMap(reference.getOppositeOf(), DatabasePackage.Literals.TABLE) != null) {
			// Do nothing, already handled
			return;
		}
		
		// Try to retrieve existing join table
		Table joinTable = getFromInputTraceabilityMap(reference, DatabasePackage.Literals.TABLE);
		if (joinTable == null) {
			joinTable = getFromInputTraceabilityMap(reference.getOppositeOf(), DatabasePackage.Literals.TABLE);
		}
		if (joinTable == null) {
			// The join table does not already exist, we have to create a new one
			joinTable = DatabaseFactory.eINSTANCE.createTable();

			// SAFRAN-711
			TableContainer container = getTableContainerFor(reference, sourceTable, targetTable);
			container.getTables().add(joinTable);
	
		}
		
		// The following properties are modified even if they already existed 
		String joinTableName = LabelProvider.getJoinTableName(sourceTable, targetTable);
			
		joinTable.setName(joinTableName+"_"+(getNumberOfTablesWithSameName(joinTableName)+1));
		
		addToOutputTraceability(reference, joinTable);
		addToOutputTraceability(reference.getOppositeOf(), joinTable);
				
		joinTable.setComments("Table de jointure entre " + sourceTable.getName() + " et " + targetTable.getName());
		
		createJoinTableForeignKey(joinTable, sourceTable);
		createJoinTableForeignKey(joinTable, targetTable);

		String pkComments = "Contrainte PK pour les colonnes ";
		pkComments += joinTable.getPrimaryKey().getColumns().get(0).getName();
		pkComments += " et ";
		pkComments += joinTable.getPrimaryKey().getColumns().get(1).getName();
		joinTable.getPrimaryKey().setComments(pkComments);
		
		createAdditionalFields(joinTable);
	}
	
	/**
	 * Return the number of tables with the same name (excluding the counter prefix)
	 * @param tableName the name of a {@link Table}, as a {@link String}
	 * @return the number of tables as a {@link Long}
	 */
	private long getNumberOfTablesWithSameName(String tableName) {
		long existingTableNames = getOutputTraceabilityMap()
				.values() // all the names
				.stream()
				.filter(Table.class::isInstance) // we keep the tables 
				.map(Table.class::cast)
				.distinct() // jointables are added twice: we remove the duplicates
				.map(table -> table.getName()) // map to string				
				.filter(name -> name.matches("("+tableName+")(_[0-9]+)?"))
				.count();
		
		return existingTableNames;
	}
	
	/**
	 * Returns the {@link TableContainer} corresponding to the {@link Namespace} referenced by the {@link Entity} 
	 * @param reference a (Bi-directional) {@link Reference}
	 * @param targetTable a {@link Table}
	 * @param sourceTable  a {@link Table}
	 * @return a {@link TableContainer}
	 */
	private TableContainer getTableContainerFor(Reference reference, Table sourceTable, Table targetTable) {
		if (isPhysicalTarget(reference)) {
			return targetTable.getOwner();
		} else {
			return sourceTable.getOwner();	
		}
	}

	/**
	 * Checks the metadata of a {@link Reference}. If it contains a PHYSICAL_TARGET metadata with a "checked" body (e.g., x value) , it is a physical target. 
	 * @param reference the {@link Reference}
	 * @return <code>true</code> if physical target.
	 */
	private boolean isPhysicalTarget(Reference reference) {
		if (reference.getMetadatas() == null) 
			return false;
		
		Optional<Annotation> optional = reference.getMetadatas().getMetadatas()
			.stream()
			.filter(metadata -> metadata instanceof Annotation && "PHYSICAL_TARGET".equalsIgnoreCase(((Annotation) metadata).getTitle()))
			.map(Annotation.class::cast)
			.findAny();
		
		return (optional.isPresent() && "x".equalsIgnoreCase(optional.get().getBody()));
	}

	private void createJoinTableForeignKey(Table joinTable, Table targetTable) {
		// FK for table
		ForeignKey fk = null;
		for (ForeignKey existingFK : joinTable.getForeignKeys()) {
			if (targetTable.equals(existingFK.getTarget())) {
				fk = existingFK;
				break;
			}
		}
		if (fk == null) {
			// We have to create a FK
			fk = DatabaseFactory.eINSTANCE.createForeignKey();
			joinTable.getForeignKeys().add(fk);
			fk.setTarget(targetTable);
		}
		addToObjectsToBeKept(fk);
		createFkElements(fk, joinTable, targetTable, false, "PK,FK de la table " + joinTable.getName());
		
		// Add FK columns to the PK
		Column fkColumn = findExistingFKColumn(joinTable, targetTable, true);
		if (fkColumn == null) {
			fkColumn = DatabaseFactory.eINSTANCE.createColumn();
			fkColumn.setName(targetTable.getPrimaryKey().getColumns().get(0).getName());
			joinTable.getColumns().add(fkColumn);
			addToObjectsToBeKept(fkColumn);
		}
		
		// Add to PK when needed
		fkColumn.addToPrimaryKey();
		
		fk.setName(getFKName(fk));
		fk.setComments("Contrainte FK avec la table " + targetTable.getName());
	}
	
	private void createForeignKey(Reference reference, Table sourceTable, Table targetTable, boolean nullable) {
		// Try to retrieve existing foreign key
		ForeignKey fk = getFromInputTraceabilityMap(reference, DatabasePackage.Literals.FOREIGN_KEY);
		if (fk != null) {
			// Ensure it is contained by the right table
			if (!EcoreUtil.equals(fk.getSourceTable(), sourceTable)) {
				sourceTable.getForeignKeys().add(fk);
			}
			// Ensure it references the right table
			if (!EcoreUtil.equals(fk.getTargetTable(), targetTable)) {
				fk.setTarget(targetTable);
			}
		} else {
			// The FK does not already exist, we have to create a new one
			fk = DatabaseFactory.eINSTANCE.createForeignKey();
			sourceTable.getForeignKeys().add(fk);
			fk.setTarget(targetTable);
		}
		addToOutputTraceability(reference, fk);
		
		String referenceDescription = reference.getDescription();
		if (referenceDescription != null  && referenceDescription.trim().length() > 0) {
			fk.setComments(referenceDescription);
		} else {
			fk.setComments("Contrainte FK avec la table " + fk.getTarget().getName());
		}
		
		createFkElements(fk, sourceTable, targetTable, nullable, referenceDescription);
		
		String fkName = LabelProvider.getFKNameFromReference(reference);
		if (fkName == null) {
			fkName = getFKName(fk);
		}
		fk.setName(fkName);
	}

	private void createFkElements(ForeignKey fk, Table sourceTable, Table targetTable, boolean nullable, String fkComments) {
		// We will recreate all foreign key elements, before we have to check for already existing FK column
		// if we do that after the deletion, the column.isInForeignKey() would always return false
		Map<Column, Column> columnsMappingToBeUsed = new LinkedHashMap<Column, Column>(); 
		for (Column targetPkColumn : targetTable.getPrimaryKey().getColumns()) {
			Column sourceFkColumn = findExistingFKColumn(sourceTable, targetTable, false);
			if (sourceFkColumn == null) {
				sourceFkColumn = DatabaseFactory.eINSTANCE.createColumn();
				sourceTable.getColumns().add(sourceFkColumn);
			}
			sourceFkColumn.setName(LabelProvider.getFKNameFromSourceTableAndPK(sourceTable, targetPkColumn)); //FIXME
			
			sourceFkColumn.setType(EcoreUtil.copy(targetPkColumn.getType()));
			sourceFkColumn.setNullable(nullable);
			
			sourceFkColumn.setComments(fkComments);
			
			columnsMappingToBeUsed.put(sourceFkColumn, targetPkColumn);
		}
		
		// Delete FK elements
		List<ForeignKeyElement> fkElements = new ArrayList<ForeignKeyElement>(fk.getElements());
		for (ForeignKeyElement fkElt : fkElements) {
			EcoreUtil.delete(fkElt);
		}
		
		// Recreate FK elements
		for (Entry<Column, Column> columnsMapping : columnsMappingToBeUsed.entrySet()) {
			Column sourceFkColumn = columnsMapping.getKey();
			Column targetPkColumn = columnsMapping.getValue();
			
			if (targetPkColumn != null && sourceFkColumn != null) {
				ForeignKeyElement foreignKeyElement = DatabaseFactory.eINSTANCE.createForeignKeyElement();
				fk.getElements().add(foreignKeyElement);
				foreignKeyElement.setFkColumn(sourceFkColumn);
				foreignKeyElement.setPkColumn(targetPkColumn);
			}
			addToObjectsToBeKept(sourceFkColumn);
			addToObjectsToBeKept(targetPkColumn);
		}
	}
	
	private Column findExistingFKColumn(Table table, Table targetTable, boolean alreadyHandledAllowed) {
		for (Column column : table.getColumns()) {
			if (column.isInForeignKey()) {
				for (ForeignKey fk : column.getForeignKeys()) {
					if (EcoreUtil.equals(fk.getTargetTable(), targetTable)) {
						if (alreadyHandledAllowed || !getObjectsToBeKept().contains(column)) {
							return column;							
						}
					}
				}
			}
		}
		return null;
	}
	
	private void createTable(Entity entity) {
		// Retrieve the existing table
		Table table = getFromInputTraceabilityMap(entity, DatabasePackage.Literals.TABLE);
		Namespace namespace = EntityUtils.getContainingNamespace(entity);		

		if (table == null) {
			// The table does not already exist we have to create a new one
			table = DatabaseFactory.eINSTANCE.createTable();
			TableContainer targetTableContainer = getTargetTableContainer(namespace);
			targetTableContainer.getTables().add(table);
		} else {
			// We have to ensure the schema name is correct
			String realSchemaName = getSchemaNameFromNamespace(namespace);
			TableContainer tableContainer = table.getOwner();
			if (!realSchemaName.equals(tableContainer.getName())) {
				tableContainer.setName(realSchemaName);
			}
			// Ensure description is correct
			tableContainer.setComments(namespace.getDescription());
		}
		// Add to traceability map
		addToOutputTraceability(entity, table);
		
		// The following properties are modified even if they already existed
		table.setName(LabelProvider.getTableNameFromEntity(entity));		
		table.setComments(entity.getDescription());
		
		// Handle attributes
		boolean hasPKAttribute = false;
		
		Collection<Attribute> allAttributes = new ArrayList<Attribute>();
		// Attributes from the entity and its supertypes
		allAttributes.addAll(entity.getAttributes());
		// Attributes from associated DTOs
		for (StructuredType associatedType : entity.getAssociatedTypes()) {
			allAttributes.addAll(associatedType.getAttributes());
		}
		
		for (Attribute attribute : allAttributes) {
			createColumn(attribute, table);
			if (attribute.isIsIdentifier()) {
				hasPKAttribute = true;
			}
		}
		
		// Create an ID column if no attribute was set as "primary key"
		if (hasPKAttribute == false) {
			createDefaultIdColumn(table);
		}
		
		// Update comments on PK
		PrimaryKey primaryKey = table.getPrimaryKey();
		if (primaryKey != null) {
			primaryKey.setName(table.getName() +"_PK");
			primaryKey.setComments(getPKComments(primaryKey));
		}
		
		// Create constraints
		createConstraints(entity, table);
	}
	
	private boolean shouldCreateAdditionalFields(Table table) {
		// We want to retrieve the Entity/Reference object corresponding to the table
		// we have to use the outputTraceabilityMap for this but in reverse order
		ObeoDSMObject fromObject = null;
		for (Entry<EObject, EObject> entry : getOutputTraceabilityMap().entrySet()) {
			if (table.equals(entry.getValue())) {
				EObject key = entry.getKey();
				if (key instanceof ObeoDSMObject) {
					fromObject = (ObeoDSMObject)key;
				}
			}
		}
		
		if (fromObject != null) {
			return ! getDisableAdditionalFieldsFlag(fromObject);
		}
		return true;
	}
	
	private boolean getDisableAdditionalFieldsFlag(ObeoDSMObject object) {
		Annotation annotation = AnnotationHelper.getAnnotation(object, DISABLE_ADDITIONAL_FIELDS_KEY);
		if (annotation != null && annotation.getBody() != null && "true".equals(annotation.getBody().trim().toLowerCase())) {
			return true;
		} else {
			// Check in parents tree
			EObject container = object.eContainer();
			if (container instanceof ObeoDSMObject) {
				return getDisableAdditionalFieldsFlag((ObeoDSMObject)container);
			} else {				
				return false;
			}
		}
	}

	private void createAdditionalFields(Table table) {
		// TODO Replace this quick fix with a more general solution allowing one to customize the additional fiels 
		
		/*
		 * 1st part : Quick fix for Ministère de l'Education Nationale needs
		 * a metadata DISABLE_ADDITIONAL_FIELDS_KEY = true can be set on an entity, a namespace or entity root
		 * if it is set then the additional fields won't be created
		 */
		if (shouldCreateAdditionalFields(table)) {
		/*
		 * End of 1st part : Quick fix for Ministère de l'Education Nationale needs
		 */
					
			// Validity column
			String validityColumnName = AdditionalFieldsUtils.getValidityColumnName(table);
			Column validityColumn = createValidityColumn(table, validityColumnName);
			addToObjectsToBeKept(validityColumn);
			
			// Add constraint on this column
			Constraint validityConstraint = findOrCreateConstraint(table, AdditionalFieldsUtils.getValidityColumnConstraint(table));
			validityConstraint.setName(getConstraintName(validityConstraint));
			validityConstraint.setComments(MessageFormat.format(VALIDITY_CONSTRAINT_COMMENTS, validityColumnName));
			addToObjectsToBeKept(validityConstraint);
			
			// Date column
			Column dateColumn = createDateColumn(table, AdditionalFieldsUtils.getDateColumnName(table));
			addToObjectsToBeKept(dateColumn);
			
		
		/*
		 * 2nd part : Quick fix for Ministère de l'Education Nationale needs
		 */
		}
		/*
		 * End of 2nd part : Quick fix for Ministère de l'Education Nationale needs
		 */
	}
	
	private Column createValidityColumn(Table table, String columnName) {
		// Create XTOPSUP column
		Column column = findColumnByName(table, columnName);
		if (column == null) {
			column = DatabaseFactory.eINSTANCE.createColumn();
			column.setName(columnName);
			table.getColumns().add(column);
		}
		column.setComments(VALIDITY_COLUMN_COMMENTS);
		column.setDefaultValue(VALIDITY_COLUMN_DEFAULT);
		column.setNullable(false);
		TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		typeInstance.setNativeType(nativeTypesMap.get(VALIDITY_COLUMN_TYPE));
		typeInstance.setLength(VALIDITY_COLUMN_TYPE_LENGTH);
		column.setType(typeInstance);
		
		return column;
	}

	private Column createDateColumn(Table table, String columnName) {
		// Create XDMAJ column
		Column column = findColumnByName(table, columnName);
		if (column == null) {
			column = DatabaseFactory.eINSTANCE.createColumn();
			column.setName(columnName);
			table.getColumns().add(column);
		}
		column.setComments(DATE_COLUMN_COMMENT);
		TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		typeInstance.setNativeType(nativeTypesMap.get(DATE_COLUMN_TYPE));
		column.setType(typeInstance);
		
		return column;
	}
	
	private Constraint findOrCreateConstraint(Table table, String expression) {
		for (Constraint constraint : table.getConstraints()) {
			if (expression.equals(constraint.getExpression())) {
				return constraint;
			}
		}
		// No constraint found, let's create one
		Constraint constraint = DatabaseFactory.eINSTANCE.createConstraint();
		constraint.setExpression(expression);
		table.getConstraints().add(constraint);
		return constraint;
	}
	
	private Column findColumnByName(Table table, String name) {
		for (Column column : table.getColumns()) {
			if (name.equals(column.getName())) {
				return column;
			}
		}
		return null;
	}
	
	private void createColumn(Attribute attribute, Table table) {
		// Try to retrieve existing column
		Column column = getFromInputTraceabilityMap(attribute, DatabasePackage.Literals.COLUMN);
		if (column != null) {
			// Ensure the column is in the right table
			if (!EcoreUtil.equals(table, column.getOwner())) {
				table.getColumns().add(column);
			}
		} else {
			// The column does not already exist, we have to create a new one
			column = DatabaseFactory.eINSTANCE.createColumn();
			table.getColumns().add(column);
		}
		// Add to the new traceability map
		addToOutputTraceability(attribute, column);
		
		// The following properties are modified even if they were already valued
		column.setName(LabelProvider.getColumnNameFromAttribute(attribute));
		column.setComments(attribute.getDescription());
		column.setDefaultValue(AnnotationHelper.getPhysicalDefault(attribute));
		boolean nullable = hasZeroAsLowerMultiplicityBound(attribute);
		column.setNullable(nullable);

		// Add to PK when needed
		if (attribute.isIsIdentifier()) {
			column.addToPrimaryKey();
			if (column.getComments() == null || column.getComments().length() == 0) {
				column.setComments(getPKColumnComment(column));
			}
		}
		if (attribute.getType() instanceof Enumeration) {
			handleEnumType(column, (Enumeration)attribute.getType(), table);
		} else {
			column.setType(resolveType(attribute.getType(), AnnotationHelper.getPhysicalSize(attribute)));
		}
	}
	
	private void handleEnumType(Column column, Enumeration enumeration, Table table) {
		// For an enumeration
		// Column has type Texte
		TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		typeInstance.setNativeType(nativeTypesMap.get(ENUM_COLUMN_TYPE));
		column.setType(typeInstance);
		
		// Column size is the maximum length of the literals		
		int maxSize = 0;
		List<String> literalValues = new ArrayList<String>();
		for (Literal literal : enumeration.getLiterals()) {
			String value = literal.getName();
			if (value != null) {
				// Fix for SAFRAN-696
				literalValues.add("'" + value + "'");
				int length = value.length();
				if (maxSize < length) {
					maxSize = length;
				}
			}
		}
		if (maxSize > 0) {
			typeInstance.setLength(maxSize);
		}
		
		// A check constraint is added with all literals
		String expression = MessageFormat.format("{0} in ({1})", column.getName(), Joiner.on(",").join(literalValues));
		Constraint validityConstraint = findOrCreateConstraint(table, expression);
		validityConstraint.setName("ENUM_CONSTRAINT");
		validityConstraint.setComments(MessageFormat.format(ENUM_CONSTRAINTS_COMMENTS, column.getName()));
		addToObjectsToBeKept(validityConstraint);
		
		// A default value is added, it is the first literal
		if (!enumeration.getLiterals().isEmpty()) {
			// Fix for SAFRAN-696
			column.setDefaultValue("'" + enumeration.getLiterals().get(0).getName() + "'");
		}
	}
	
	private TypeInstance resolveType(DataType type, String physicalSize) {
		TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		if (type != null && type.getName() != null) {
			if (getTypeProperties().containsKey(type.getName())) {
				String logicalTypeName = getTypeProperties().getProperty(type.getName());
				NativeType logicalType = nativeTypesMap.get(logicalTypeName);
				if (logicalType != null) {
					typeInstance.setNativeType(logicalType);
					if (physicalSize != null && physicalSize.length() > 0) {
						if (physicalSize.contains(",")) {
							int length = Integer.parseInt(physicalSize.substring(0, physicalSize.indexOf(",")));
							int precision = Integer.parseInt(physicalSize.substring(physicalSize.indexOf(",") + 1));
							typeInstance.setLength(length);
							typeInstance.setPrecision(precision);
						} else {
							typeInstance.setLength(Integer.parseInt(physicalSize));
						}
					}
				}
			}
		}
		return typeInstance;
	}
	
	private void createDefaultIdColumn(Table table) {
		// Check if there is already an ID column
		if (table.getPrimaryKey() != null && table.getPrimaryKey().getColumns().size() == 1) {
			// We don't need to create an ID column
			// but let's ensure it's corretly named
			Column idColumn = table.getPrimaryKey().getColumns().get(0);
			idColumn.setName(table.getName() + "_ID");
			idColumn.setComments(getPKColumnComment(idColumn));
			addToObjectsToBeKept(idColumn);
			return;
		}
		
		// Let's create a default ID column
		Column idColumn = DatabaseFactory.eINSTANCE.createColumn();
		table.getColumns().add(idColumn);
		idColumn.setName(table.getName() + "_ID");
		idColumn.setComments(getPKColumnComment(idColumn));
		idColumn.addToPrimaryKey();
		TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		// SAFRAN-694 - PK column type is "entier long" with a default lengh of 19
		typeInstance.setNativeType(nativeTypesMap.get("Entier long"));
		typeInstance.setLength(19);
		idColumn.setType(typeInstance);
		
		addToObjectsToBeKept(idColumn);
	}
	
	private void createConstraints(Entity entity, Table table) {
		
		// Collection constraints to be created
		Set<String> expressions = new LinkedHashSet<String>(AnnotationHelper.getAllConstraints(entity));
		for (Attribute attribute : entity.getAttributes()) {
			expressions.addAll(AnnotationHelper.getAllConstraints(attribute));
		}

		// Add all newly created constraints
		for (EObject object : getObjectsToBeKept()) {
			if (object instanceof Constraint) {
				Constraint existingConstraint = (Constraint) object;
				if (table.equals(existingConstraint.getOwner())) {
					expressions.add(existingConstraint.getExpression());
				}
			}
		}
		
		// Reuse some of the existing constraints
		Collection<Constraint> constraintsToBeDeleted = new ArrayList<Constraint>();
		for (Constraint existingConstraint : table.getConstraints()) {
			// Check if the constraint should still exist
			if (expressions.contains(existingConstraint.getExpression())) {
				// Keep the constraint
				expressions.remove(existingConstraint.getExpression());
				existingConstraint.setName(getConstraintName(existingConstraint));
				addToObjectsToBeKept(existingConstraint);
			} else {
				// The constraint will be removed
				constraintsToBeDeleted.add(existingConstraint);
			}
		}
		
		// Delete useless constraint
		for (Constraint constraint : constraintsToBeDeleted) {
			EcoreUtil.delete(constraint, true);
		}

		// Create new constraints
		for (String expression : expressions) {
			Constraint constraint = DatabaseFactory.eINSTANCE.createConstraint();
			table.getConstraints().add(constraint);
			constraint.setName(getConstraintName(constraint));
			constraint.setExpression(expression);
			addToObjectsToBeKept(constraint);
		}
	}
	
	private boolean isIndexAsc(String order) {
		String cleanOrder = order.replaceAll(" ", "");
		return !"DESC".equalsIgnoreCase(cleanOrder);
	}
	
	/**
	 * Each term of the unicity expression separated by '|' will lead to the creation of an {@link Index}.
	 * @param tableUnicity the "PHYSICAL_UNIQUE" meta-data of an Entity.
	 * @return the list of maps (one map per index to create) mapping the column names that must be indexed with whether they should be indexed in an <i>ascending</i> or <i>descending</i> order.
	 */
	private List<Map<String, Boolean>> getInfosFromTableUnicity(String tableUnicity) {
		List<Map<String, Boolean>> infos = new ArrayList<Map<String, Boolean>>();
		String unicity = tableUnicity.replaceAll(" ", "");

		// SAFRAN-496: multiple indexes can be created, using the '|' symbol to separate the different sets of columns.
		StringTokenizer termTokenizer = new StringTokenizer(unicity, "|");
		while(termTokenizer.hasMoreTokens()){
			String term = termTokenizer.nextToken();
			Map<String, Boolean> termInfos = new LinkedHashMap<String, Boolean>();
			StringTokenizer indexSpecificationTokenizer = new StringTokenizer(term, ",");
			while(indexSpecificationTokenizer.hasMoreTokens()){
				String columnDef = indexSpecificationTokenizer.nextToken();				
				int separatorPos = columnDef.indexOf(":");
				
				String columnName = columnDef;
				String columnSort = "";
				if (separatorPos != -1) {
					columnName = columnDef.substring(0, separatorPos);
					columnSort = columnDef.substring(separatorPos+1);
				}
				boolean asc = !columnSort.equalsIgnoreCase("DESC");
				termInfos.put(columnName.toUpperCase(), asc);
			}
			infos.add(termInfos);
		}
		return infos;
	}
	
	private void createIndices(Entity entity){
		Table table = getFromOutputTraceabilityMap(entity, DatabasePackage.Literals.TABLE);
		
		// We collect unique and non unique indices, all indices will be kept unchanged
		Collection<Index> existingUniqueIndices = new ArrayList<Index>();
		Collection<Index> existingNonUniqueIndices = new ArrayList<Index>();
		for (Index index : table.getIndexes()) {
			if (index.isUnique()) {
				existingUniqueIndices.add(index);
			} else {
				existingNonUniqueIndices.add(index);
			}
		}
		
		// Handle indexes on attributes
		for (Attribute attribute : entity.getOwnedAttributes()) {
			String unicity = AnnotationHelper.getPhysicalUnique(attribute);
			if (unicity != null) {
				List<Column> columns = new ArrayList<Column>();
				Column column = getFromOutputTraceabilityMap(attribute, DatabasePackage.Literals.COLUMN);
				columns.add(column);
				Index index = findIndex(existingUniqueIndices, columns);
				if (index != null) {
					// We reuse the existing index
					index.getElements().get(0).setAsc(isIndexAsc(unicity));
				} else {
					// We have to create a new index
					index = DatabaseFactory.eINSTANCE.createIndex();
					table.getIndexes().add(index);
					existingUniqueIndices.add(index);
					index.setUnique(true);
					IndexElement indexElement = DatabaseFactory.eINSTANCE.createIndexElement();
					index.getElements().add(indexElement);		
					indexElement.setAsc(isIndexAsc(unicity));
					indexElement.setColumn(column);
				}
				index.setName(getUniqueIndexName(index));
				index.setComments(getUniqueIndexComments(index));
				addToObjectsToBeKept(index);
			}
		}
		
		// Handle indexes on entity
		String tableUnicity = AnnotationHelper.getPhysicalUnique(entity);
		if (tableUnicity != null) {
			
			List<Map<String, Boolean>> listOfIndexInfos = getInfosFromTableUnicity(tableUnicity);
			for(Map<String, Boolean> indexInfos : listOfIndexInfos){
				List<Column> columns = new ArrayList<Column>();
				for (String columnName : indexInfos.keySet()) {
					for (Column column : table.getColumns()) {
						if (column.getName().equalsIgnoreCase(columnName)) {
							columns.add(column);
							break;
						}
					}
				}
				// Check if all columns were found
				if (columns.size() != indexInfos.size()) {
					String msg = "Could not understand PHYSICAL_UNIQUE annotation for Entity: " + entity.getName()+ " - annotation: \""+ tableUnicity + "\"";
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, msg));
				}
				
				// Try to retrieve an existing index on these columns
				Index index = findIndex(existingUniqueIndices, columns);
				if (index != null) {
					// Reuse existing index
					// Update sort orders
					for (IndexElement element : index.getElements()) {
						element.setAsc(indexInfos.get(element.getColumn().getName().toUpperCase()));
					}
				} else {
					// We have to create a new index
					index = DatabaseFactory.eINSTANCE.createIndex();
					table.getIndexes().add(index);
					existingUniqueIndices.add(index);
					index.setUnique(true);
					for (Column targetColumn : columns) {
						IndexElement indexElement = DatabaseFactory.eINSTANCE.createIndexElement();
						index.getElements().add(indexElement);
						String s = targetColumn.getName();
						indexElement.setAsc(indexInfos.get(targetColumn.getName().toUpperCase()));					
						indexElement.setColumn(targetColumn);
					}
				}
				index.setName(getUniqueIndexName(index));
				index.setComments(getUniqueIndexComments(index));
				addToObjectsToBeKept(index);
			}
		}
		
		// Handle indexes on references
		for (Reference reference : getReferencesForIndexCreation(entity)) {
			boolean indexShouldBeUnique = false;
//			if (isMultiplicitySimple(reference)) {
//				indexShouldBeUnique = true;
//			} else if (isMultiplicityMany(reference)) {
//				indexShouldBeUnique = false;
//			}

			String unicity = AnnotationHelper.getPhysicalUnique(reference);
			if (unicity == null) {
				unicity = "ASC";
			} else {
				indexShouldBeUnique = true;
			}

			List<Column> columns = new ArrayList<Column>();
			ForeignKey fk = getFromOutputTraceabilityMap(reference, DatabasePackage.Literals.FOREIGN_KEY);
			// Get columns for FK
			if (fk != null) {					
				for (ForeignKeyElement fkElt : fk.getElements()) {
					columns.add(fkElt.getFkColumn());
				}
				Index index = null;
				if (indexShouldBeUnique) {
					index = findIndex(existingUniqueIndices, columns);
				} else {
					index = findIndex(existingNonUniqueIndices, columns);
				}
				if (index != null) {
					// Ensure the index is of the right kind
					index.setUnique(indexShouldBeUnique);
					// We reuse the existing index
					for (IndexElement indexElt : index.getElements()) {
						indexElt.setAsc(isIndexAsc(unicity));
					}
				} else {
					// We have to create a new index
					index = DatabaseFactory.eINSTANCE.createIndex();
					table.getIndexes().add(index);
					if (indexShouldBeUnique) {
						existingUniqueIndices.add(index);
					} else {
						existingNonUniqueIndices.add(index);
					}
					index.setUnique(indexShouldBeUnique);
					for (ForeignKeyElement fkElt : fk.getElements()) {
						IndexElement indexElement = DatabaseFactory.eINSTANCE.createIndexElement();
						index.getElements().add(indexElement);		
						indexElement.setAsc(isIndexAsc(unicity));
						indexElement.setColumn(fkElt.getFkColumn());						
					}
				}
				index.setName(fk.getName());
				index.setComments(getFKIndexComments(index));
				addToObjectsToBeKept(index);
			}
		}
	}
	
	private Collection<Reference> getReferencesForIndexCreation(Entity entity) {
		// References which must be taken into account for index creation are :
		// - 0..* and 1..* references pointing on the entity
		// - 0..1 and 1..1 references owned by the entity if they have no multiplicity many opposite references
		Collection<Reference> references = new ArrayList<Reference>();
		references.addAll(getOwnedReferencesForIndexCreation(entity));
		references.addAll(getPointingReferencesForIndexCreation(entity));
		return references;
	}
	
	private Collection<Reference> getOwnedReferencesForIndexCreation(Entity entity) {
		Collection<Reference> references = new ArrayList<Reference>();
		for (Reference ownedReference : EntityUtils.getEntitiesReferences(entity)) {
			if (shouldCreateFKInSource(ownedReference)) {
				references.add(ownedReference);
			}
		}
		return references;
	}

	private Collection<Reference> getPointingReferencesForIndexCreation(Entity entity) {
		@SuppressWarnings("serial")
		Collection<Setting> settings = new EcoreUtil.UsageCrossReferencer(entity.eResource().getResourceSet()) {
			
			@Override
			protected boolean crossReference(EObject eObject,EReference eReference, EObject crossReferencedEObject) {
				return super.crossReference(eObject, eReference, crossReferencedEObject)
						&& eReference == EnvironmentPackage.Literals.REFERENCE__REFERENCED_TYPE;
			}
			
			@Override
			protected boolean containment(EObject eObject) {
				return (eObject instanceof Reference || eObject instanceof Entity || eObject instanceof Namespace || eObject instanceof Root || eObject instanceof org.obeonetwork.dsl.overview.Root);
			}
			
			public Collection<Setting> findUsage(EObject object) {
				return super.findUsage(object);
			}
		}.findUsage(entity);
		Collection<Reference> references = new ArrayList<Reference>();
		for (Setting setting : settings) {
			if (setting.getEObject() instanceof Reference) {
				Reference reference = (Reference)setting.getEObject();
				if (shouldCreateFKInTarget(reference)) {				
					references.add(reference);
				}
			}
		}
		return references;
	}
	
	private String getPKComments(PrimaryKey pk) {
		String comments = "Contrainte PK ";
		if (pk.getColumns().size() == 1) {
			comments += "pour la colonne ";
		} else if (pk.getColumns().size() > 1) {
			comments += "pour les colonnes ";	
		}
		for (int i = 0; i < pk.getColumns().size(); i++) {
			if (i > 0) {
				comments += ", ";
			}
			Column column = pk.getColumns().get(i);
			comments += column.getName();
		}
		return comments;
	}
	
	private String getPKColumnComment(Column column) {
		return "PK de la table " + column.getOwner().getName();
	}
	
	private int getCounter(Table table, String prefix) {
		Integer count = 1;
		Map<String, Integer> tableInfos = counters.get(table);
		if (tableInfos != null) {
			if (tableInfos.containsKey(prefix)) {
				count = tableInfos.get(prefix);
				count++;
			}
		} else {
			tableInfos = new HashMap<String, Integer>();
			counters.put(table, tableInfos);
		}
		tableInfos.put(prefix, count);
		return count;
	}
	
	private String getFKName(ForeignKey fk) {
		return fk.getOwner().getName() + "_FK" + fk.getElements().size() + "_" + getCounter(fk.getOwner(), "FK");
//		return fk.getOwner().getName() + "_FK" + fk.getElements().size() + "_" + fk.getOwner().getForeignKeys().size();
	}
	
	private String getConstraintName(Constraint constraint) {
		return constraint.getOwner().getName() + "_CK1_" + getCounter(constraint.getOwner(), "CK");
//		return constraint.getOwner().getName() + "_CK1_" + constraint.getOwner().getConstraints().size();
	}
	
	private String getUniqueIndexName(Index index) {
//		int nbIndex = index.getOwner().getIndexes().size();
		return index.getOwner().getName() + "_UN" + index.getElements().size() + "_"  + getCounter(index.getOwner(), "UN");
//		return index.getOwner().getName() + "_UN" + index.getElements().size() + "_" + nbIndex;
	}
	
	private String getFKIndexComments(Index index) {
		String comments = "Index sur la FK (";
		for (int i = 0; i < index.getElements().size(); i++) {
			if (i > 0) {
				comments += ", ";
			}
			IndexElement elt = index.getElements().get(i);
			comments += elt.getColumn().getName();
		}
		comments += ") de la table " + index.getOwner().getName();
		return comments;
	}
	
	private String getUniqueIndexComments(Index index) {
		String comments = "Index d'unicité pour ";
		for (int i = 0; i < index.getElements().size(); i++) {
			if (i > 0) {
				comments += ", ";
			}
			IndexElement elt = index.getElements().get(i);
			comments += elt.getColumn().getName();
		}
		return comments;
	}
	
	/**
	 * Retrieving an existing index targetting the specified columns
	 * @param targetColumns
	 * @return
	 */
	private Index findIndex(Collection<Index> indices, List<Column> targetColumns) {
		for (Index index : indices) {
			if (index.isUnique()) {
				if (index.getElements().size() == targetColumns.size()) {
					// Check if all elements are the same and in the same order
					boolean targetColumnsAllCorrespond = true;
					for(int i = 0; i < targetColumns.size(); i++) {
						if (targetColumnsAllCorrespond && !EcoreUtil.equals(index.getElements().get(i).getColumn(), targetColumns.get(i))) {
							targetColumnsAllCorrespond = false;
						}
					}
					if (targetColumnsAllCorrespond == true) {
						return index;
					}
				}
			}
		}
		
		return null;
	}
	
	
	private boolean hasZeroAsLowerMultiplicityBound(Property property) {
		return (property.getMultiplicity() == MultiplicityKind.ZERO_STAR_LITERAL || property.getMultiplicity() == MultiplicityKind.ZERO_ONE_LITERAL);
	}
	
	private boolean isMultiplicitySimple(Reference reference) {
		return !isMultiplicityMany(reference);
	}
	
	private boolean isMultiplicityMany(Reference reference) {
		return (reference.getMultiplicity() == MultiplicityKind.ZERO_STAR_LITERAL || reference.getMultiplicity() == MultiplicityKind.ONE_STAR_LITERAL);
	}
	
	@Override
	protected String getTypePropertiesFileName() {
		return "Entity-to-LogicalTypes.properties";
	}

	private Map<String, NativeType> loadTypesLibrary(ResourceSet set) {
		Map<String, NativeType> types = new HashMap<String, NativeType>();
		ResourceSet resourceSet = set != null ? set : getResourceSet();
		TypesLibrary typesLibrary = TypesLibraryUtil.getLogicalTypesLibrary(resourceSet);
		for (Iterator<EObject> it = typesLibrary.eAllContents(); it.hasNext();) {
			EObject object = it.next();
			if (object instanceof NativeType) {
				NativeType type = (NativeType)object;
				types.put(type.getName(), type);
			}
		}
		return types;
	}
}
