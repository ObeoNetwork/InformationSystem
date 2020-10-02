/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.obeonetwork.dsl.database.gen.common.services.StatusUtils.createErrorStatus;
import static org.obeonetwork.dsl.database.gen.common.services.StatusUtils.createWarningStatus;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.dbevolution.AddColumnChange;
import org.obeonetwork.dsl.database.dbevolution.AddConstraint;
import org.obeonetwork.dsl.database.dbevolution.AddForeignKey;
import org.obeonetwork.dsl.database.dbevolution.AddIndex;
import org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.AddSequence;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.AddView;
import org.obeonetwork.dsl.database.dbevolution.AlterTable;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveTable;
import org.obeonetwork.dsl.database.dbevolution.RenameColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RenameTableChange;
import org.obeonetwork.dsl.database.dbevolution.SequenceChange;
import org.obeonetwork.dsl.database.dbevolution.TableChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange;
import org.obeonetwork.dsl.database.dbevolution.ViewChange;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher.LiquibaseDefaultType;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultValueConfigDelegate;
import org.obeonetwork.dsl.database.liquibasegen.service.GenServices;
import org.obeonetwork.dsl.database.liquibasegen.service.SQLService;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

import liquibase.change.AddColumnConfig;
import liquibase.change.ColumnConfig;
import liquibase.change.ConstraintsConfig;
import liquibase.change.core.AddAutoIncrementChange;
import liquibase.change.core.AddDefaultValueChange;
import liquibase.change.core.AddForeignKeyConstraintChange;
import liquibase.change.core.AddNotNullConstraintChange;
import liquibase.change.core.AddPrimaryKeyChange;
import liquibase.change.core.CreateIndexChange;
import liquibase.change.core.CreateSequenceChange;
import liquibase.change.core.CreateTableChange;
import liquibase.change.core.CreateViewChange;
import liquibase.change.core.DropColumnChange;
import liquibase.change.core.DropNotNullConstraintChange;
import liquibase.change.core.DropTableChange;
import liquibase.change.core.ModifyDataTypeChange;
import liquibase.change.core.RawSQLChange;
import liquibase.change.core.SetColumnRemarksChange;
import liquibase.change.core.SetTableRemarksChange;
import liquibase.changelog.ChangeLogChild;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;

public class ChangeLogBuilder {
	public static final String FILE_NAME = "run.changelog.xml";
	private static final String DEFAULT_AUTHOR = "IS Designer";

	private GenServices genService;

	/*
	 * Used to generate change sets
	 */
	private DatabaseChangeLog changelog;
	private int changeSetCounter;
	private String timeStamp;

	/**
	 * List of statutes raised during generation
	 */
	private List<IStatus> statuses = new ArrayList<IStatus>();

	/**
	 * Keeps track of the constraints set on column that have been created and
	 * updated.
	 */
	private Map<String, ConstraintsConfig> updatedColumnConfs = new HashMap<String, ConstraintsConfig>();

	private SQLService sqlService;

	private static <E> Stream<E> filterAndCast(Stream<?> stream, Class<E> type) {
		return stream.filter(e -> type.isInstance(e)).map(e -> type.cast(e));
	}

	public List<ChangeLogChild> buildContent(Comparison comparisonModel, String changeLogIdPrexix) {
		List<ChangeLogChild> result = new ArrayList<ChangeLogChild>();
		genService = new GenServices();
		sqlService = new SQLService();
		timeStamp = changeLogIdPrexix;
		try {
			List<DBDiff> diffs = genService.getOrderedChanges(comparisonModel);
			result.addAll(genChangeSetsForTables(diffs)); // Needs to be before handled before primary keys
			result.addAll(getChangeSetsForPrimaryKeys(diffs));
			result.addAll(genChangeSetsForConstraints(diffs));
			result.addAll(getChangeSetsForForeignKeys(diffs));
			result.addAll(getChangeSetsForIndexes(diffs));
			result.addAll(getChangeSetsForSequences(diffs));
			result.addAll(getChangeSetsForViews(diffs));
		} finally {
			genService.dispose();
			genService = null;
		}

		return result;

	}

	private Collection<? extends ChangeLogChild> getChangeSetsForViews(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), ViewChange.class)//
				.map(this::buildViewChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Optional<ChangeSet> buildViewChangeSet(ViewChange viewChange) {
		if (viewChange instanceof AddView) {
			return Optional.of(buildAddViewChangeSet((AddView) viewChange));
		}
		return Optional.empty();
	}

	private ChangeSet buildAddViewChangeSet(AddView viewChange) {
		CreateViewChange vChange = new CreateViewChange();
		View view = viewChange.getView();
		safeTrimSetter(view.getName(), vChange::setViewName);
		safeTrimSetter(genService.getViewQuery(view), vChange::setSelectQuery);
		safeTrimSetter(view.getComments(), vChange::setRemarks);
		vChange.setReplaceIfExists(true);
		safeSchemaSetter(view.getOwner(), vChange::setSchemaName);
		ChangeSet changeSet = buildNextChangeSet();
		// Add the view comment both in the remarks and changset comment since the
		// COMMENT ON VIEW is not supported by all DB (not supported on MySQL for
		// example)
		changeSet.setComments("View  " + view.getName() + " : " + view.getComments());
		changeSet.addChange(vChange);
		return changeSet;
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForSequences(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), SequenceChange.class)//
				.map(this::buildSequenceChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Optional<ChangeSet> buildSequenceChangeSet(SequenceChange sequenceChange) {
		if (sequenceChange instanceof AddSequence) {
			return Optional.of(buildAddSequenceChangeSet((AddSequence) sequenceChange));

		}
		return Optional.empty();
	}

	private ChangeSet buildAddSequenceChangeSet(AddSequence sequenceChange) {
		CreateSequenceChange sChange = new CreateSequenceChange();

		Sequence sequence = sequenceChange.getSequence();

		safeTrimSetter(sequence.getName(), sChange::setSequenceName);
		safeBigIntegerSetter(sequence.getIncrement(), sChange::setIncrementBy);
		safeBigIntegerSetter(sequence.getMinValue(), sChange::setMinValue);
		safeBigIntegerSetter(sequence.getMaxValue(), sChange::setMaxValue);
		safeBigIntegerSetter(sequence.getStart(), sChange::setStartValue);
		safeBigIntegerSetter(sequence.getCacheSize(), sChange::setCacheSize);
		safeBigIntegerSetter(sequence.getCacheSize(), sChange::setCacheSize);
		safeSchemaSetter(sequence.eContainer(), sChange::setSchemaName);
		sChange.setCycle(sequence.isCycle());

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Sequence " + sequence.getName() + " : " + sequence.getComments());
		changeSet.addChange(sChange);

		return changeSet;
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForIndexes(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), IndexChange.class)//
				.filter(genService::shouldGenerateIndex)//
				.map(this::buildIndexChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Collection<? extends ChangeLogChild> genChangeSetsForConstraints(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), ConstraintChange.class)//
				.map(this::buildContraintChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Optional<ChangeSet> buildContraintChangeSet(ConstraintChange constraintChange) {
		if (constraintChange instanceof AddConstraint) {
			return buildAddConstraintChangeSet((AddConstraint) constraintChange);
		}
		return Optional.empty();

	}

	private Optional<ChangeSet> buildIndexChangeSet(IndexChange indexChange) {
		if (indexChange instanceof AddIndex) {
			return buildAddIndexChangeSet((AddIndex) indexChange);
		}
		return Optional.empty();

	}

	private Optional<ChangeSet> buildAddIndexChangeSet(AddIndex addIndex) {
		Index index = addIndex.getIndex();
		CreateIndexChange iChange = new CreateIndexChange();
		iChange.setUnique(index.isUnique());
		safeTrimSetter(index.getName(), iChange::setIndexName);
		safeTrimSetter(index.getOwner().getName(), iChange::setTableName);

		List<AddColumnConfig> columnConfigs = index.getElements().stream()//
				.filter(c -> c.getColumn() != null && c.getColumn().getName() != null).map(c -> {
					AddColumnConfig config = new AddColumnConfig();
					safeTrimSetter(c.getColumn().getName(), config::setName);
					return config;
				}).collect(toList());

		// Do not generate an index if there is element in it
		if (columnConfigs.isEmpty()) {
			statuses.add(createWarningStatus("Index " + index.getName() + " has no column."));
			return Optional.empty();
		}
		iChange.setColumns(columnConfigs);
		safeSchemaSetter(index.getOwner().getOwner(), iChange::setSchemaName);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Index : " + index.getName());
		changeSet.addChange(iChange);
		return Optional.of(changeSet);
	}

	private Optional<ChangeSet> buildAddConstraintChangeSet(AddConstraint addConstraint) {
		Constraint constraint = addConstraint.getConstraint();
		IStatus status = sqlService.validateConstaint(constraint);
		if (status.isOK()) {
			RawSQLChange sqlChange = new RawSQLChange(sqlService.buildAddConstraintQuery(constraint));
			ChangeSet result = buildNextChangeSet();
			result.addChange(sqlChange);
			// Currently in discussion with the client because there is a problem of
			// constraint scaffolding (MLD -> MPD) and the different databases
			// result.setFailOnError(false);
			result.setComments(MessageFormat.format("Constraint : {0}", constraint.getName()));
			return Optional.of(result);
		} else {
			statuses.add(status);
			return Optional.empty();
		}
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForForeignKeys(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), AddForeignKey.class)//
				.map(this::buildForeignKeyChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForPrimaryKeys(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), PrimaryKeyChange.class)//
				.map(this::buildPrimaryKeyChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Optional<ChangeSet> buildPrimaryKeyChangeSet(PrimaryKeyChange primKeyChange) {

		if (primKeyChange instanceof AddPrimaryKey) {
			AddPrimaryKey addPrimKeyChange = (AddPrimaryKey) primKeyChange;
			return buildAddPrimaryKeyChangeSet(addPrimKeyChange);
		}

		return Optional.empty();

	}

	private Optional<ChangeSet> buildAddPrimaryKeyChangeSet(AddPrimaryKey addPrimKeyChange) {
		PrimaryKey primKey = addPrimKeyChange.getPrimaryKey();
		EList<Column> columns = primKey.getColumns();

		List<String> columnsQN = columns.stream().map(c -> genService.getFullName(c)).collect(toList());
		if (columnsQN.stream().allMatch(c -> updatedColumnConfs.containsKey(c))) {
			// The primary impact only added columns => Update existing contain
			columnsQN.forEach(qn -> {
				safeTrimSetter(primKey.getName(), name -> updatedColumnConfs.get(qn).setPrimaryKeyName(name));
			});
			return Optional.empty();
		} else {

			// The primary contains not only added column. In this case remove the primary
			// key constraint definition from the CreateTable changeset and a specific
			// change set to create the constraint
			Table table = primKey.getOwner();
			columnsQN.stream().filter(qn -> updatedColumnConfs.containsKey(qn)).forEach(qn -> {
				updatedColumnConfs.get(qn).setPrimaryKey((Boolean) null); // Don't add the primary during the creation
			});

			// Create a specific changeSet
			ChangeSet changeSet = buildNextChangeSet();
			AddPrimaryKeyChange aChange = new AddPrimaryKeyChange();

			safeSchemaSetter(table.getOwner(), aChange::setSchemaName);
			safeTrimSetter(table.getName(), aChange::setTableName);
			String columnNames = columns.stream().map(c -> c.getName()).filter(n -> n != null).map(n -> n.trim())
					.collect(joining(","));
			aChange.setColumnNames(columnNames);
			changeSet.setComments("Adding primary key on " + columnNames + " in " + table.getName());
			safeTrimSetter(primKey.getName(), aChange::setConstraintName);
			changeSet.addChange(aChange);
			return Optional.of(changeSet);
		}

	}

	private Optional<ChangeSet> buildForeignKeyChangeSet(AddForeignKey adForeign) {
		ForeignKey fk = adForeign.getForeignKey();
		AddForeignKeyConstraintChange changeDescription = new AddForeignKeyConstraintChange();

		if (fk.getElements().stream().allMatch(e -> e.getPkColumn() != null)) {
			Table sourceTable = fk.getOwner();
			Table target = fk.getElements().stream().map(e -> (Table) e.getPkColumn().eContainer()).findFirst()
					.orElse(null);
			if (target != null) {
				safeTrimSetter(fk.getName(), changeDescription::setConstraintName);
				safeTrimSetter(sourceTable.getName(), changeDescription::setBaseTableName);
				safeSchemaSetter(sourceTable.getOwner(), changeDescription::setBaseTableSchemaName);
				safeTrimSetter(target.getName(), changeDescription::setReferencedTableName);
				changeDescription.setBaseColumnNames(
						fk.getElements().stream().map(c -> c.getFkColumn().getName()).collect(joining(",")));
				changeDescription.setReferencedColumnNames(
						fk.getElements().stream().map(c -> c.getPkColumn().getName()).collect(joining(",")));

				List<Table> referencesTable = fk.getElements().stream().map(c -> c.getPkColumn().getOwner()).distinct()
						.collect(toList());
				if (referencesTable.size() > 1) {
					statuses.add(createErrorStatus(MessageFormat.format(
							"Foreign key {0} reference more than external schema. Not handled by this generator.",
							fk.getName())));
					return Optional.empty();
				} else if (!referencesTable.isEmpty()) {
					safeSchemaSetter(referencesTable.get(0).getOwner(),
							changeDescription::setReferencedTableSchemaName);
				}

				ChangeSet result = buildNextChangeSet();
				result.setComments("Foreign Key : " + fk.getName());
				result.addChange(changeDescription);
				return Optional.of(result);
			}
		} else {
			statuses.add(createWarningStatus("Invalid foreign key definition : " + fk.getName()));
		}
		return Optional.empty();

	}

	private ChangeSet buildAddTableChangeSet(AddTable addTable) {
		Table table = addTable.getTable();
		CreateTableChange ctChange = buildCreateTableChange(table);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(ctChange);
		changeSet.setComments("Create table " + table.getName());
		return changeSet;
	}

	private CreateTableChange buildCreateTableChange(Table table) {
		CreateTableChange ctChange = new CreateTableChange();
		safeTrimSetter(table.getName(), ctChange::setTableName);
		safeSchemaSetter(table.getOwner(), ctChange::setSchemaName);
		remarksSetter(table, ctChange::setRemarks);
		for (Column column : table.getColumns()) {
			ColumnConfig cConfig = new ColumnConfig();
			fillColumnConfig(table, column, cConfig);
			ctChange.addColumn(cConfig);
		}
		return ctChange;
	}

	private void safeSchemaSetter(EObject candidate, Consumer<String> consumer) {
		if (candidate instanceof Schema) {
			String name = ((Schema) candidate).getName();
			if (name != null) {
				consumer.accept(name.trim());
			}
		}
	}

	private void remarksSetter(DatabaseElement dbe, Consumer<String> setter) {
		safeTrimSetter(dbe.getComments(), setter);
	}

	private void safeTrimSetter(String s, Consumer<String> setter) {
		safeSet(s, String::trim, setter);
	}

	private void safeSet(String s, Function<String, String> preProcess, Consumer<String> setter) {
		if (s != null) {
			setter.accept(preProcess.apply(s));
		}
	}

	private void safeBigIntegerSetter(BigInteger i, Consumer<BigInteger> setter) {
		if (i != null) {
			setter.accept(i);
		}
	}

	private void fillColumnConfig(Table table, Column column, ColumnConfig cConfig) {
		cConfig.setName(column.getName());

		Type type = column.getType();
		setTypeAndDefaultValue(table, column, cConfig, type);

		// Handle primary key
		ConstraintsConfig constraintConfig = new ConstraintsConfig();
		constraintConfig.setNullable(column.isNullable());

		if (column.isInPrimaryKey()) {
			constraintConfig.setPrimaryKey(column.isInPrimaryKey());
		}

		// We need to keeps tracks on the constraint configured for this column to be
		// able to modify it afterwards.
		// For example, the name can be set when the AddPrimaryDiff is handled
		updatedColumnConfs.put(genService.getFullName(column), constraintConfig);
		cConfig.setConstraints(constraintConfig);

		if (column.isAutoincrement()) {
			cConfig.setAutoIncrement(column.isAutoincrement());
		}

		remarksSetter(column, cConfig::setRemarks);
	}

	private void setTypeAndDefaultValue(Table table, Column column, ColumnConfig cConfig, Type type) {
		if (type instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance) type;
			String stringType = genService.getType(typeInstance);
			cConfig.setType(stringType);
			String defaultValue = column.getDefaultValue();
			if (defaultValue != null && !defaultValue.isEmpty()) {
				setColumnDefaultvalue(table, column, typeInstance, defaultValue,
						new DefaultValueConfigDelegate(cConfig));
			}

		}
	}

	private void setColumnDefaultvalue(Table table, Column column, TypeInstance typeInstance, String defaultValue,
			DefaultValueConfigDelegate configurer) {
		LiquibaseDefaultType liquibaseMatchingType = DefaultTypeMatcher
				.getLiquibaseDefaultType(typeInstance.getNativeType());

		if (liquibaseMatchingType == LiquibaseDefaultType.UNKWOWN) {
			warnUnknownDefaultType(table, column, typeInstance);
		} else if (liquibaseMatchingType == LiquibaseDefaultType.INVALID) {
			warnInvalidDataType(table, column, typeInstance);
		} else {
			String processedValue = DefaultTypeMatcher.preProcessDefaultValue(liquibaseMatchingType, defaultValue);

			switch (liquibaseMatchingType) {
			case BOOLEAN:
				configurer.setDefaultValueBoolean(processedValue);
				break;
			case DATE:
				configurer.setDefaultValueDate(processedValue);
				break;
			case STRING:
				configurer.setDefaultValue(processedValue);
				break;
			case NUM:
				configurer.setDefaultValueNumeric(processedValue);
				break;
			default:
				break;
			}

		}

	}

	private void warnInvalidDataType(Table table, Column column, TypeInstance typeInstance) {
		statuses.add(createWarningStatus(
				MessageFormat.format("Unable to set default value for type {0}#{1}. {2} missing type information.",
						genService.getFullName(table), column.getName(), genService.getLabel(typeInstance))));
	}

	private void warnUnknownDefaultType(Table table, Column column, TypeInstance typeInstance) {
		statuses.add(createWarningStatus(
				MessageFormat.format("Unable to set default value for type {0}#{1}. {2} has an unknown logical type.",
						genService.getFullName(table), column.getName(), genService.getLabel(typeInstance))));
	}

	public List<IStatus> getStatuses() {
		return statuses;
	}

	private ChangeSet buildNextChangeSet() {
		return new ChangeSet(getNextId(), // Id
				DEFAULT_AUTHOR, // Author
				false, // Always run
				false, // Run on change
				FILE_NAME, // Changelog filename
				"", // Context list
				"", // dbms
				true, // run in transaction
				null, changelog);
	}

	private Stream<ChangeSet> buildTableChangeSet(TableChange tableChange) {
		final List<ChangeSet> result = new ArrayList<ChangeSet>();
		if (tableChange instanceof AddTable) {
			result.add(buildAddTableChangeSet((AddTable) tableChange));
		} else if (tableChange instanceof RemoveTable) {
			result.add((buildDropTableChangeSet((RemoveTable) tableChange)));
		} else if (tableChange instanceof AlterTable) {
			AlterTable alterTable = (AlterTable) tableChange;
			for (DBDiff dbDiff : genService.getSubDiffs(alterTable)) {
				if (dbDiff instanceof RenameTableChange) {
					RenameTableChange renameTableChange = (RenameTableChange) dbDiff;
					result.add(buildRenameTableChangeSet(renameTableChange));
				} else if (dbDiff instanceof UpdateTableCommentChange) {
					UpdateTableCommentChange updateCommentChange = (UpdateTableCommentChange) dbDiff;
					result.add(buildUpdateTableCommentChangeSet(updateCommentChange));
				} else if (dbDiff instanceof AddColumnChange) {
					AddColumnChange addColumnChange = (AddColumnChange) dbDiff;
					result.add(buildAddColumnChangeSet(addColumnChange));
				} else if (dbDiff instanceof RemoveColumnChange) {
					RemoveColumnChange removeColumnChange = (RemoveColumnChange) dbDiff;
					result.add(buildRemoveColumnChangeSet(removeColumnChange));
				} else if (dbDiff instanceof RenameColumnChange) {
					RenameColumnChange renameColumnChange = (RenameColumnChange) dbDiff;
					result.add(buildRenameColumnChangeSet(renameColumnChange));
				} else if (dbDiff instanceof UpdateColumnChange) {
					UpdateColumnChange updateColumnChange = (UpdateColumnChange) dbDiff;
					result.addAll(buildUpdateColumnChangeSet(updateColumnChange));
				}
			}
		}

		return result.stream();
	}

	/***
	 * Check if the given update change owns a {@link AttributeChange} with the
	 * given EStructual feature
	 * 
	 * @param updateChange a change
	 * @param attribute    the expected attribute
	 * @return <code>true</code> if the attributes has changed
	 */
	private boolean hasChanged(UpdateColumnChange updateChange, EAttribute attribute) {

		Match match = updateChange.getMatch();

		return match.getDifferences().stream().filter(diff -> diff instanceof AttributeChange)//
				.map(diff -> ((AttributeChange) diff))//
				.anyMatch(attChange -> attChange.getAttribute() == attribute);
	}

	/**
	 * Check if the given UpdateColumnChange requires to reset its type.
	 * 
	 * <p>
	 * The type can be modified if
	 * <ul>
	 * <li>A new type instance is set</li>
	 * <li>The length of the precision of the type instance has changed</li>
	 * </ul>
	 * 
	 * @param updateChange
	 * @return
	 */
	private boolean hasTypeChanged(UpdateColumnChange updateChange) {

		Match match = updateChange.getMatch();

		// We need to iterate on all sub difference since the change can either be on
		// the column itself (change of typeIntance) or in its TypeInstance
		for (Diff diff : match.getAllDifferences()) {
			if (diff instanceof ReferenceChange) {
				ReferenceChange refChange = (ReferenceChange) diff;
				EReference ref = refChange.getReference();
				if (ref == TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType()
						|| ref == DatabasePackage.eINSTANCE.getColumn_Type()) {
					return true;
				}
			} else if (diff instanceof AttributeChange) {
				EAttribute attr = ((AttributeChange) diff).getAttribute();
				if (attr == TypesLibraryPackage.eINSTANCE.getTypeInstance_Length()
						|| attr == TypesLibraryPackage.eINSTANCE.getTypeInstance_Precision()
						|| attr == TypesLibraryPackage.eINSTANCE.getTypeInstance_Literals()) {
					return true;
				}
			}
		}

		return false;
	}

	private List<ChangeSet> buildUpdateColumnChangeSet(UpdateColumnChange updateColumnChange) {

		List<ChangeSet> result = new ArrayList<ChangeSet>();

		Column column = updateColumnChange.getColumn();

		// Change in type
		if (hasTypeChanged(updateColumnChange)) {
			buildUpdateDataTypeChangeSet(column).ifPresent(result::add);
		}

		// Nullable
		if (hasChanged(updateColumnChange, DatabasePackage.eINSTANCE.getColumn_Nullable())) {
			if (column.isNullable()) {
				result.add(buildDropNotNullConstraint(column));
			} else {
				result.add(buildSetNotNullConstraint(column));
			}
		}

		// Auto increment
		if (hasChanged(updateColumnChange, DatabasePackage.eINSTANCE.getColumn_Autoincrement())) {
			if (column.isAutoincrement()) {
				result.add(buildAddAutoIncrementConstraint(column));
			} else {
				// At the time of writing Liquibase do not have a ChangeSet to remove
				// auto_increment from a column
				// https://liquibase.jira.com/browse/CORE-486),
				statuses.add(createWarningStatus("The Liquibase generator is not able to remove the AutoIncrement "));
			}
		}
		// Default value
		if (hasChanged(updateColumnChange, DatabasePackage.eINSTANCE.getColumn_DefaultValue())) {
			buildChangeDefaultValueOnColumn(column).ifPresent(result::add);
		}

		// Update comment
		if (hasChanged(updateColumnChange, DatabasePackage.eINSTANCE.getDatabaseElement_Comments())) {
			result.add(buildCommentOnColumn(column));
		}
		return result;
	}

	private ChangeSet buildCommentOnColumn(Column column) {
		SetColumnRemarksChange sChange = new SetColumnRemarksChange();
		Table table = column.getOwner();
		safeSchemaSetter(table.getOwner(), sChange::setSchemaName);
		safeTrimSetter(table.getName(), sChange::setTableName);
		safeTrimSetter(column.getName(), sChange::setColumnName);
		safeTrimSetter(column.getComments(), sChange::setRemarks);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Updating comment on " + genService.getFullName(column));
		changeSet.addChange(sChange);

		return changeSet;
	}

	private Optional<ChangeSet> buildChangeDefaultValueOnColumn(Column column) {
		Type type = column.getType();
		if (type instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance) type;
			String defaultValue = column.getDefaultValue();
			if (defaultValue != null && !defaultValue.isEmpty()) {
				Table table = column.getOwner();
				AddDefaultValueChange aChange = new AddDefaultValueChange();
				safeSchemaSetter(table.getOwner(), aChange::setSchemaName);
				safeTrimSetter(table.getName(), aChange::setTableName);
				safeTrimSetter(column.getName(), aChange::setColumnName);
				// Required for informix DB... might no be necessary but since we have it and
				// Liquibase does not fail on invalid type on DB that do not requires it.
				// It generates a SQL query without this information on DB that does not
				// requires it
				// https://docs.liquibase.com/change-types/community/add-default-value.html
				safeSetColumnType(column, aChange::setColumnDataType);

				setColumnDefaultvalue(table, column, typeInstance, defaultValue,
						new DefaultValueConfigDelegate(aChange));

				ChangeSet changeSet = buildNextChangeSet();
				changeSet.setComments("Set default value for column " + column.getName());
				changeSet.addChange(aChange);

				return Optional.of(changeSet);
			}

		} else {
			statuses.add(createWarningStatus(genService.getFullName(column) + " has no type"));
		}
		return Optional.empty();
	}

	private ChangeSet buildAddAutoIncrementConstraint(Column column) {
		AddAutoIncrementChange aChange = new AddAutoIncrementChange();

		safeTrimSetter(column.getOwner().getName(), aChange::setTableName);
		safeSchemaSetter(column.getOwner().getOwner(), aChange::setSchemaName);
		safeTrimSetter(column.getName(), aChange::setColumnName);

		// Required for MariaDB and MySql. See
		// https://docs.liquibase.com/change-types/community/add-not-null-constraint.html
		safeSetColumnType(column, aChange::setColumnDataType);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Add auto increment to " + column.getName());
		changeSet.addChange(aChange);
		return changeSet;
	}

	private ChangeSet buildSetNotNullConstraint(Column column) {
		Table table = column.getOwner();
		AddNotNullConstraintChange aChange = new AddNotNullConstraintChange();
		safeSchemaSetter(table.getOwner(), aChange::setSchemaName);
		safeTrimSetter(table.getName(), aChange::setTableName);
		safeTrimSetter(column.getName(), aChange::setColumnName);
		// Required for MariaDB and MySql. See
		// https://docs.liquibase.com/change-types/community/add-not-null-constraint.html
		safeSetColumnType(column, aChange::setColumnDataType);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Add NOT NULL constraint on " + table.getName() + "." + column.getName());
		changeSet.addChange(aChange);

		return changeSet;
	}

	private void safeSetColumnType(Column column, Consumer<String> typeConsumer) {
		Type type = column.getType();
		if (type instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance) type;
			String stringType = genService.getType(typeInstance);
			typeConsumer.accept(stringType);
		}

	}

	private ChangeSet buildDropNotNullConstraint(Column column) {
		Table table = column.getOwner();
		DropNotNullConstraintChange dChange = new DropNotNullConstraintChange();
		safeSchemaSetter(table.getOwner(), dChange::setSchemaName);
		safeTrimSetter(table.getName(), dChange::setTableName);
		safeTrimSetter(column.getName(), dChange::setColumnName);

		// Required for MariaDB and MySql. See
		// https://docs.liquibase.com/change-types/community/add-not-null-constraint.html
		safeSetColumnType(column, dChange::setColumnDataType);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Droping NOT NULL constraint on " + table.getName() + "." + column.getName());
		changeSet.addChange(dChange);

		return changeSet;
	}

	private Optional<ChangeSet> buildUpdateDataTypeChangeSet(Column column) {
		Type type = column.getType();
		if (type instanceof TypeInstance) {
			ModifyDataTypeChange mChange = new ModifyDataTypeChange();

			safeSchemaSetter(column.getOwner().getOwner(), mChange::setSchemaName);
			safeTrimSetter(column.getOwner().getName(), mChange::setTableName);
			safeTrimSetter(column.getName(), mChange::setColumnName);
			TypeInstance typeInstance = (TypeInstance) type;
			String stringType = genService.getType(typeInstance);
			mChange.setNewDataType(stringType);
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Update column " + column.getName() + " datatype to " + stringType);
			changeSet.addChange(mChange);
			return Optional.of(changeSet);
		} else {
			statuses.add(createWarningStatus("No type for column " + genService.getFullName(column)));
			return Optional.empty();
		}

	}

	private ChangeSet buildRenameColumnChangeSet(RenameColumnChange renameColumnChange) {
		liquibase.change.core.RenameColumnChange rChange = new liquibase.change.core.RenameColumnChange();
		Column column = renameColumnChange.getColumn();
		Table table = column.getOwner();
		safeSchemaSetter(table.getOwner(), rChange::setSchemaName);
		safeTrimSetter(table.getName(), rChange::setTableName);
		safeTrimSetter(column.getName(), rChange::setOldColumnName);
		safeTrimSetter(renameColumnChange.getNewColumn().getName(), rChange::setNewColumnName);

		// Required for MariaDB and MySql. See
		// https://docs.liquibase.com/change-types/community/rename-column.html
		safeSetColumnType(column, rChange::setColumnDataType);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(rChange);
		changeSet.setComments("Renaming column " + column.getName());
		return changeSet;
	}

	private ChangeSet buildRemoveColumnChangeSet(RemoveColumnChange removeColumnChange) {
		DropColumnChange dChange = new DropColumnChange();
		Column column = removeColumnChange.getColumn();
		Table table = column.getOwner();
		safeSchemaSetter(table.getOwner(), dChange::setSchemaName);
		safeTrimSetter(table.getName(), dChange::setTableName);
		safeTrimSetter(column.getName(), dChange::setColumnName);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(dChange);
		changeSet.setComments("Dropping column " + column.getName());
		return changeSet;
	}

	private ChangeSet buildAddColumnChangeSet(AddColumnChange addColumnChange) {
		liquibase.change.core.AddColumnChange aChange = new liquibase.change.core.AddColumnChange();
		Column column = addColumnChange.getColumn();
		Table table = column.getOwner();
		safeSchemaSetter(table.getOwner(), aChange::setSchemaName);
		safeTrimSetter(table.getName(), aChange::setTableName);

		AddColumnConfig addColumnConfig = new AddColumnConfig();
		fillColumnConfig(table, column, addColumnConfig);
		aChange.addColumn(addColumnConfig);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(aChange);
		changeSet.setComments("Adding column " + column.getName());
		return changeSet;
	}

	private ChangeSet buildUpdateTableCommentChangeSet(UpdateTableCommentChange updateCommentChange) {
		SetTableRemarksChange srChange = new SetTableRemarksChange();
		Table table = updateCommentChange.getNewTable();
		safeSchemaSetter(table.getOwner(), srChange::setSchemaName);
		safeTrimSetter(table.getName(), srChange::setTableName);
		safeTrimSetter(table.getComments(), srChange::setRemarks);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(srChange);

		return changeSet;
	}

	private ChangeSet buildRenameTableChangeSet(RenameTableChange renameTableChange) {
		liquibase.change.core.RenameTableChange rChange = new liquibase.change.core.RenameTableChange();
		Table table = renameTableChange.getTable();
		safeTrimSetter(table.getName(), rChange::setOldTableName);
		Table newTable = renameTableChange.getNewTable();
		safeTrimSetter(newTable.getName(), rChange::setNewTableName);
		safeSchemaSetter(table.getOwner(), rChange::setSchemaName);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Rename table '" + table.getName() + "' to '" + newTable.getName() + "'");
		changeSet.addChange(rChange);
		return changeSet;
	}

	private ChangeSet buildDropTableChangeSet(RemoveTable removeTable) {

		Table table = removeTable.getTable();
		DropTableChange dChange = new DropTableChange();

		safeSchemaSetter(table.getOwner(), dChange::setSchemaName);
		safeTrimSetter(table.getName(), dChange::setTableName);
		dChange.setCascadeConstraints(true);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Drop Table : " + table.getName());
		changeSet.addChange(dChange);

		return changeSet;
	}

	private List<ChangeLogChild> genChangeSetsForTables(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), TableChange.class)//
				.flatMap(this::buildTableChangeSet)//
				.collect(toList());
	}

	private String getNextId() {
		return timeStamp + String.valueOf(changeSetCounter++);
	}

}
