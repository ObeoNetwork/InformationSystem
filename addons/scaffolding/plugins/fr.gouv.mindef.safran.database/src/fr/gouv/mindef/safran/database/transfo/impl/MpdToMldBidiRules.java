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
package fr.gouv.mindef.safran.database.transfo.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.AbstractTable;
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
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import fr.gouv.mindef.safran.database.Activator;
import fr.gouv.mindef.safran.database.transfo.AbstractTransformation;
import fr.gouv.mindef.safran.database.transfo.TransformationException;
import fr.gouv.mindef.safran.database.transfo.util.ModelUtils;

public abstract class MpdToMldBidiRules extends AbstractTransformation {
	
	private static final String SEQUENCE_INITIAL_COMMENTS = "Séquence de la PK de la table %s";
	private static final int MPD_DEFAULT_TYPE_LENGTH = 0;
	private static final int MPD_DEFAULT_TYPE_PRECISION = 0;
	
	protected TypesLibrary targetTypesLibrary;
	private TableContainer sourceTableContainer;
	private TableContainer targetTableContainer;
	
	@Override
	protected boolean prepare(EObject sourceObject, EObject targetObject) {
		if (sourceObject instanceof TableContainer && targetObject instanceof TableContainer) {
			sourceTableContainer = (TableContainer)sourceObject;
			targetTableContainer = (TableContainer)targetObject;
			targetTypesLibrary = loadTargetTypesLibrary(targetTableContainer);
			return (targetTypesLibrary != null);
		}
		return false;
	}

	@Override
	protected Resource execute() {
		doTransformation(sourceTableContainer, targetTableContainer);
		return targetTableContainer.eResource();
	}
	
	private void doTransformation(TableContainer sourceTableContainer, TableContainer targetTableContainer) {
		processTableContainer(sourceTableContainer, targetTableContainer);
		
		createForeignKeys(sourceTableContainer);

		// Process sequences
		if (doesTargetSupportSequences()) {
			Collection<Sequence> sequencesToBeKept = createOrUpdateSequences(sourceTableContainer);
			
			Collection<Sequence> sequencesToBeRemoved = collectAllSequences();
			sequencesToBeRemoved.removeAll(sequencesToBeKept);
			removeSequences(sequencesToBeRemoved);
		}
	}
	
	private void processTableContainer(TableContainer sourceTableContainer, TableContainer targetTableContainer) {
		createTables(sourceTableContainer, targetTableContainer);
		
		if (sourceTableContainer instanceof DataBase) {
			DataBase sourceDatabase = (DataBase)sourceTableContainer;
			
			for (Schema sourceSchema : sourceDatabase.getSchemas()) {
				if (targetTableContainer instanceof DataBase) {
					DataBase targetDatabase = (DataBase)targetTableContainer;
					createSchema(sourceSchema, targetDatabase);
				} else {
					createTables(sourceSchema, targetTableContainer);
				}
			}
		}
	}
	
	private Collection<Sequence> collectAllSequences() {
		// Collect all existing sequences
		Collection<Sequence> sequences = new ArrayList<Sequence>();
		for( TreeIterator<EObject> it = targetTableContainer.eResource().getAllContents(); it.hasNext(); ) {
			EObject object = it.next();
			if (object instanceof Sequence) {
				sequences.add((Sequence)object);
			}
			if (!(object instanceof TableContainer)) {
				it.prune();
			}
		}
		return sequences;
	}
	
	private void removeSequences(Collection<Sequence> sequences) {
		// Remove sequences
		for (Sequence sequence : sequences) {
			EcoreUtil.delete(sequence, true);
		}
	}
	
	private void createForeignKeys(TableContainer sourceTableContainer) {

		// create all foreignkeys
		for (AbstractTable sourceAbstractTable : sourceTableContainer.getTables()) {
			if (sourceAbstractTable instanceof Table) {
				Table sourceTable = (Table) sourceAbstractTable;
				Table targetTable = getFromOutputTraceabilityMap(sourceTable, DatabasePackage.Literals.TABLE);
				
				for (ForeignKey foreignKey : sourceTable.getForeignKeys()) {
					createFK(foreignKey, targetTable);
				}
			}
		}

		if (sourceTableContainer instanceof DataBase) {
			DataBase sourceDataBase = (DataBase)sourceTableContainer;
			for (Schema sourceSchema : sourceDataBase.getSchemas()) {
				createForeignKeys(sourceSchema);
			}
		}
	}
	
	/**
	 * Create needed new sequences or update existing ones
	 * @param sourceTableContainer
	 * @return list of sequences processed so that all other sequences (now useless) could be removed 
	 */
	/**
	 * @param sourceTableContainer
	 * @return
	 */
	private Collection<Sequence> createOrUpdateSequences(TableContainer sourceTableContainer) {

		Collection<Sequence> sequences = new ArrayList<Sequence>();
		
		// for each non-composite PK we create a sequence and associate it with the PK column
		for (AbstractTable sourceAbstractTable : sourceTableContainer.getTables()) {
			if (sourceAbstractTable instanceof Table) {
				Table sourceTable = (Table) sourceAbstractTable;

				// Get associated table
				Table targetTable = getFromOutputTraceabilityMap(sourceTable, DatabasePackage.Literals.TABLE);
				if (targetTable != null) {
					PrimaryKey pk = targetTable.getPrimaryKey();
					// Only for non-composite PK
					if (pk != null && pk.getColumns().size() == 1) {
						
						Column targetColumn = pk.getColumns().get(0);
						// Retrieve the potentially existing sequence
						Sequence existingSequence = targetColumn.getSequence();
						String sequenceName = targetTable.getName() + "_SEQ";
						
						if (existingSequence != null) {
							// Update name
							existingSequence.setName(sequenceName);
							
							// Ensure the sequence is in the right container
							if (!targetTable.getOwner().getSequences().contains(existingSequence)) {
								targetTable.getOwner().getSequences().add(existingSequence);
							}
							
							sequences.add(existingSequence);
						} else {
							// Create a new sequence
							Sequence newSequence = DatabaseFactory.eINSTANCE.createSequence();
							newSequence.setName(sequenceName);
							newSequence.setIncrement(new BigInteger("1"));
							newSequence.setStart(new BigInteger("1"));
							newSequence.setComments(String.format(SEQUENCE_INITIAL_COMMENTS, targetTable.getName()));
							targetTable.getOwner().getSequences().add(newSequence);
							
							// Retrieve the associated column and associate it with the sequence
							targetColumn.setSequence(newSequence);
							
							sequences.add(newSequence);
						}
					}
				}
			}
		}
		if (sourceTableContainer instanceof DataBase) {
			DataBase sourceDataBase = (DataBase)sourceTableContainer;
			for (Schema sourceSchema : sourceDataBase.getSchemas()) {
				sequences.addAll(createOrUpdateSequences(sourceSchema));
			}
		}
		
		return sequences;
	}
	
	private void createSchema(Schema sourceSchema, DataBase targetDatabase) {
		Schema targetSchema = getFromInputTraceabilityMap(sourceSchema, DatabasePackage.Literals.SCHEMA);
		if (targetSchema != null) {
			// Reuse existing schema
		} else {
			// We have to create a new schema
			targetSchema = DatabaseFactory.eINSTANCE.createSchema();
			targetDatabase.getSchemas().add(targetSchema);
		}
		addToOutputTraceability(sourceSchema, targetSchema);
		targetSchema.setName(sourceSchema.getName());		
		targetSchema.setComments(sourceSchema.getComments());
		createTables(sourceSchema, targetSchema);
		createViews(sourceSchema, targetSchema);
	}
	
	private void createTables(TableContainer sourceTableContainer, TableContainer targetTableContainer) {
		// create all tables
		for (AbstractTable sourceTable : sourceTableContainer.getTables()) {
			if (sourceTable instanceof Table) {
				createTable((Table) sourceTable, targetTableContainer);
			}
		}
	}
	
	private void createViews(TableContainer sourceTableContainer, TableContainer targetTableContainer) {
		// create all views
		for (AbstractTable sourceTable : sourceTableContainer.getTables()) {
			if (sourceTable instanceof View) {
				createView((View) sourceTable, targetTableContainer);
			}
		}
	}
	
	private void createFK(ForeignKey sourceFK, Table targetTable) {
		if (sourceFK.getTarget() == null) {
			return;
		}
		ForeignKey targetFK = getFromInputTraceabilityMap(sourceFK, DatabasePackage.Literals.FOREIGN_KEY);
		if (targetFK != null) {
			// Reuse existing FK
		} else {
			// We have to create a new FK
			targetFK = DatabaseFactory.eINSTANCE.createForeignKey();
			targetTable.getForeignKeys().add(targetFK);			
		}
		addToOutputTraceability(sourceFK, targetFK);
		
		targetFK.setName(sourceFK.getName());
		targetFK.setComments(sourceFK.getComments());
		
		// Try to retrieve the table referenced by the FK
		Table fkTargetTable = getFromOutputTraceabilityMap(sourceFK.getTargetTable(), DatabasePackage.Literals.TABLE);
		if (fkTargetTable == null) {
			// We look into the additional resources
			String fkTargetTableKey = ModelUtils.getKey(sourceFK.getTarget());
			fkTargetTable = (Table) getAdditionalResourcesMap().get(fkTargetTableKey);
		}
		if (fkTargetTable == null) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot resolve table: " + sourceFK.getTargetTable().getName() + " for ForeignKey: " + sourceFK.getName() + "!"));
		}
		targetFK.setTarget(fkTargetTable);
		
		for (ForeignKeyElement sourceFkElement : sourceFK.getElements()) {
			createFKElement(sourceFkElement, targetFK);
		}
	}

	private void createFKElement(ForeignKeyElement sourceFkElement, ForeignKey targetFK) {
		if (targetFK.getTargetTable() == null) {
			return;
		} else if (targetFK.getTargetTable().getPrimaryKey() == null){
			throw new TransformationException(
						"Cannot create ForeignKeyElement in ForeignKey : " + targetFK.getName() +
						" owned by " + targetFK.getTargetTable().getName() +
						" because primary key doesn't exist in table"
					);
		} else {
			ForeignKeyElement targetFkElement = getFromInputTraceabilityMap(sourceFkElement, DatabasePackage.Literals.FOREIGN_KEY_ELEMENT);
			if (targetFkElement != null) {
				// Reuse existing fk element
				
				// Ensure the FK element is contained within the right FK
				if (!EcoreUtil.equals(targetFkElement.eContainer(), targetFK)) {
					targetFK.getElements().add(targetFkElement);
				}
			} else {
				// We have to create a new FK element
				targetFkElement = DatabaseFactory.eINSTANCE.createForeignKeyElement();
				targetFK.getElements().add(targetFkElement);
			}
			addToOutputTraceability(sourceFkElement, targetFkElement);

			Column targetFKColumn = getFromOutputTraceabilityMap(sourceFkElement.getFkColumn(), DatabasePackage.Literals.COLUMN);
			targetFkElement.setFkColumn(targetFKColumn);
			Column targetPKColumn = null;
			if (targetFK.getTargetTable().getPrimaryKey().getColumns().size() == 1) {
				targetPKColumn = targetFK.getTargetTable().getPrimaryKey().getColumns().get(0);
			} else {
				targetPKColumn = getFromOutputTraceabilityMap(sourceFkElement.getPkColumn(), DatabasePackage.Literals.COLUMN);
				if (targetPKColumn == null) {
					// Last chance, we search on the name
					for (Column column : targetFK.getTargetTable().getPrimaryKey().getColumns()) {
						if (column.getName().equals(sourceFkElement.getPkColumn().getName())) {
							targetPKColumn = column;
							break;
						}
					}
				}
			}
			targetFkElement.setPkColumn(targetPKColumn);
		}
	}
	
	private void createTable(Table sourceTable, TableContainer targetTableContainer) {
		Table targetTable = getFromInputTraceabilityMap(sourceTable, DatabasePackage.Literals.TABLE);
		if (targetTable != null) {
			// Reuse existing table
		} else {
			// Create a new table
			targetTable = DatabaseFactory.eINSTANCE.createTable();
			targetTableContainer.getTables().add(targetTable);
		}
		addToOutputTraceability(sourceTable, targetTable);
		
		targetTable.setName(sourceTable.getName());		
		targetTable.setComments(sourceTable.getComments());
		
		for (Column column : sourceTable.getColumns()) {
			createColumn(column, targetTable);
		}
		if (sourceTable.getPrimaryKey() != null) {
			createPK(sourceTable.getPrimaryKey(), targetTable);
		}
		for (Index index : sourceTable.getIndexes()) {
			createIndex(index, targetTable);
		}

		for (Constraint constraint : sourceTable.getConstraints()) {
			createConstraint(constraint, targetTable);
		}
	}
	
	private void createView(View sourceView, TableContainer targetTableContainer) {
		View targetView = getFromInputTraceabilityMap(sourceView, DatabasePackage.Literals.VIEW);
		if (targetView != null) {
			// Reuse existing view
		} else {
			// Create a new view
			targetView = DatabaseFactory.eINSTANCE.createView();
			targetTableContainer.getTables().add(targetView);
		}
		addToOutputTraceability(sourceView, targetView);
		
		targetView.setName(sourceView.getName());
		targetView.setQuery(sourceView.getQuery());
		targetView.setComments(sourceView.getComments());
		
	}
	
	private void createConstraint(Constraint sourceConstraint, Table targetTable) {
		Constraint targetConstraint = getFromInputTraceabilityMap(sourceConstraint, DatabasePackage.Literals.CONSTRAINT);
		if (targetConstraint != null) {
			// Reuse the existing constraint
			
			// ensure it is contained by the right table
			if (!EcoreUtil.equals(targetConstraint.getOwner(), targetTable)) {
				targetTable.getConstraints().add(targetConstraint);
			}
		} else {
			// We have to create a new constraint
			targetConstraint = DatabaseFactory.eINSTANCE.createConstraint();
			targetTable.getConstraints().add(targetConstraint);
		}
		addToOutputTraceability(sourceConstraint, targetConstraint);
		
		targetConstraint.setName(sourceConstraint.getName());
		targetConstraint.setExpression(sourceConstraint.getExpression());
		targetConstraint.setComments(sourceConstraint.getComments());
	}
	
	private void createIndex(Index sourceIndex, Table targetTable) {
		Index targetIndex = getFromInputTraceabilityMap(sourceIndex, DatabasePackage.Literals.INDEX);
		if (targetIndex != null) {
			// Reuse existing index
			
			// Ensure it is in the right index
			if (!EcoreUtil.equals(targetIndex.getOwner(), targetTable)) {
				targetTable.getIndexes().add(targetIndex);
			}
		} else {
			// We have to create a new index
			targetIndex = DatabaseFactory.eINSTANCE.createIndex();
			targetTable.getIndexes().add(targetIndex);
		}
		addToOutputTraceability(sourceIndex, targetIndex);
		
		targetIndex.setCardinality(sourceIndex.getCardinality());
		targetIndex.setComments(sourceIndex.getComments());
		targetIndex.setIndexType(sourceIndex.getIndexType());
		targetIndex.setName(sourceIndex.getName());
		targetIndex.setQualifier(sourceIndex.getQualifier());
		targetIndex.setUnique(sourceIndex.isUnique());

		for (IndexElement indexElt : sourceIndex.getElements()) {
			createIndexElement(indexElt, targetIndex);
		}
	}

	private void createIndexElement(IndexElement sourceElementIndex, Index targetIndex) {
		IndexElement targetIndexElement = getFromInputTraceabilityMap(sourceElementIndex, DatabasePackage.Literals.INDEX_ELEMENT);
		if (targetIndexElement != null) {
			// Reuse existing element
			
			// Ensure it is in the right index
			if (!EcoreUtil.equals(targetIndexElement.eContainer(), targetIndex)) {
				targetIndex.getElements().add(targetIndexElement);
			}
		} else {
			// We have to create a new element
			targetIndexElement = DatabaseFactory.eINSTANCE.createIndexElement();
			targetIndex.getElements().add(targetIndexElement);			
		}
		addToOutputTraceability(sourceElementIndex, targetIndexElement);

		Column targetColumn = getFromOutputTraceabilityMap(sourceElementIndex.getColumn(), DatabasePackage.Literals.COLUMN);
		targetIndexElement.setColumn(targetColumn);
		targetIndexElement.setAsc(sourceElementIndex.isAsc());
	}
	
	private void createPK(PrimaryKey sourcePk, Table targetTable) {
		PrimaryKey targetPk = getFromInputTraceabilityMap(sourcePk, DatabasePackage.Literals.PRIMARY_KEY);
		if (targetPk != null && EcoreUtil.equals(targetPk.getOwner(), targetTable)) {
			// Reuse existing PK
			
		} else {
			// Create a new PK
			targetPk = DatabaseFactory.eINSTANCE.createPrimaryKey();
			targetTable.setPrimaryKey(targetPk);
		}
		addToOutputTraceability(sourcePk, targetPk);
		
		targetPk.setName(sourcePk.getName());
		targetPk.setComments(sourcePk.getComments());
		
		for (Column sourcePkColumn : sourcePk.getColumns()) {
			Column targetPkColumn = getFromOutputTraceabilityMap(sourcePkColumn, DatabasePackage.Literals.COLUMN);
			if (!targetPk.getColumns().contains(targetPkColumn)) {
				targetPk.getColumns().add(targetPkColumn);
			}
			if (isTargetMysqlMPD() || isTargetMariaDBMPD()) {
				targetPkColumn.setAutoincrement(true);
			}
		}
	}
	
	private void createColumn(Column source, Table targetTable) {
		Column target = getFromInputTraceabilityMap(source, DatabasePackage.Literals.COLUMN);
		if (target != null) {
			// Reuse existing column
			
			// Ensure the column is in the right table
			if (!EcoreUtil.equals(target.getOwner(), targetTable)) {
				targetTable.getColumns().add(target);
			}
		} else {
			// Create a new column
			target = DatabaseFactory.eINSTANCE.createColumn();
			targetTable.getColumns().add(target);
		}
		addToOutputTraceability(source, target);
		
		target.setName(source.getName());
		target.setComments(source.getComments());
		target.setDefaultValue(source.getDefaultValue());
		target.setNullable(source.isNullable());
		
		if (source.getType() instanceof TypeInstance) {
			TypeInstance originType = (TypeInstance) source.getType();
			TypeInstance targetType = resolveType(originType);
			if (targetType != null) {
				handleDefaultLengthAndPrecision(originType, targetType);
				target.setType(targetType);
			}
		}
	}
	
	private void handleDefaultLengthAndPrecision(TypeInstance originType, TypeInstance targetType) {
		if (isTargetMPD()) {
			if (targetType.getNativeType().getSpec() == NativeTypeKind.LENGTH || targetType.getNativeType().getSpec() == NativeTypeKind.LENGTH_AND_PRECISION) {
				// Target type needs a length value
				if (originType.getLength() == null) {
					// Use the default length because no one is provided by the origin type
					targetType.setLength(MPD_DEFAULT_TYPE_LENGTH);
				}
			}
			if (targetType.getNativeType().getSpec() == NativeTypeKind.LENGTH_AND_PRECISION) {
				// Target type needs a precision value
				if (originType.getPrecision() == null) {
					// Use the default precision because no one is provided by the origin type
					targetType.setPrecision(MPD_DEFAULT_TYPE_PRECISION);
				}
			}
		}
	}
	
	protected boolean doesTargetSupportSequences() {
		return isTargetOracleMPD() || isTargetPostgresMPD() || isTargetH2MPD() || isTargetSQLServerMPD();
	}
	
	protected boolean isTargetMPD() {
		return targetTypesLibrary.getKind() == TypesLibraryKind.PHYSICAL_TYPES;
	}
	
	protected boolean isTargetOracleMPD() {
		return isTargetMPD() && TypesLibraryUtil.ORACLE_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	protected boolean isTargetMysqlMPD() {
		return isTargetMPD() && TypesLibraryUtil.MYSQL_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	protected boolean isTargetMariaDBMPD() {
		return isTargetMPD() && TypesLibraryUtil.MARIADB_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	protected boolean isTargetPostgresMPD() {
		return isTargetMPD() && TypesLibraryUtil.POSTGRES_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	protected boolean isTargetSQLServerMPD() {
		return isTargetMPD() && TypesLibraryUtil.SQLSERVER_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	protected boolean isTargetH2MPD() {
		return isTargetMPD() && TypesLibraryUtil.H2_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}

	protected abstract TypeInstance resolveType(TypeInstance typeSource);
	
	private TypesLibrary loadTargetTypesLibrary(TableContainer targetTableContainer) {
		DataBase targetDatabase = null;
		if (targetTableContainer instanceof DataBase) {
			targetDatabase = (DataBase) targetTableContainer;
		} else {
			targetDatabase = (DataBase) targetTableContainer.eContainer();
		}
		if (targetDatabase.getUsedLibraries().size() == 1) {
			TypesLibrary typesLibrary = targetDatabase.getUsedLibraries().get(0);
			return typesLibrary;
		}
		return null;
	}
}
