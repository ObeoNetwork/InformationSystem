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

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.dbevolution.AddColumnChange;
import org.obeonetwork.dsl.database.dbevolution.AddConstraint;
import org.obeonetwork.dsl.database.dbevolution.AddForeignKey;
import org.obeonetwork.dsl.database.dbevolution.AddIndex;
import org.obeonetwork.dsl.database.dbevolution.AddSequence;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.AddView;
import org.obeonetwork.dsl.database.dbevolution.AlterTable;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveTable;
import org.obeonetwork.dsl.database.dbevolution.RenameColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RenameTableChange;
import org.obeonetwork.dsl.database.dbevolution.SequenceChange;
import org.obeonetwork.dsl.database.dbevolution.TableChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange;
import org.obeonetwork.dsl.database.dbevolution.ViewChange;
import org.obeonetwork.dsl.database.gen.common.services.StatusUtils;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher.LiquibaseDefaultType;
import org.obeonetwork.dsl.database.liquibasegen.service.GenServices;
import org.obeonetwork.dsl.database.liquibasegen.service.SQLService;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

import liquibase.change.AddColumnConfig;
import liquibase.change.ColumnConfig;
import liquibase.change.ConstraintsConfig;
import liquibase.change.core.AddForeignKeyConstraintChange;
import liquibase.change.core.CreateIndexChange;
import liquibase.change.core.CreateSequenceChange;
import liquibase.change.core.CreateTableChange;
import liquibase.change.core.CreateViewChange;
import liquibase.change.core.DropColumnChange;
import liquibase.change.core.DropTableChange;
import liquibase.change.core.RawSQLChange;
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
			result.addAll(genChangeSetsForTables(diffs));
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
			return Optional.of(buildAddIndexChangeSet((AddIndex) indexChange));
		}
		return Optional.empty();

	}

	private ChangeSet buildAddIndexChangeSet(AddIndex addIndex) {
		Index index = addIndex.getIndex();
		CreateIndexChange iChange = new CreateIndexChange();
		iChange.setUnique(index.isUnique());
		safeTrimSetter(index.getName(), iChange::setIndexName);
		safeTrimSetter(index.getOwner().getName(), iChange::setTableName);

		List<AddColumnConfig> columnCongis = index.getElements().stream()//
				.filter(c -> c.getColumn() != null && c.getColumn().getName() != null).map(c -> {
					AddColumnConfig config = new AddColumnConfig();
					safeTrimSetter(c.getColumn().getName(), config::setName);
					return config;
				}).collect(toList());
		iChange.setColumns(columnCongis);
		safeSchemaSetter(index.getOwner().getOwner(), iChange::setSchemaName);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Index : " + index.getName());
		changeSet.addChange(iChange);
		return changeSet;
	}

	private Optional<ChangeSet> buildAddConstraintChangeSet(AddConstraint addConstraint) {
		Constraint constraint = addConstraint.getConstraint();
		IStatus status = sqlService.validateConstaint(constraint);
		if (status.isOK()) {
			RawSQLChange sqlChange = new RawSQLChange(sqlService.buildAddConstraintQuery(constraint));
			ChangeSet result = buildNextChangeSet();
			result.addChange(sqlChange);
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
				safeTrimSetter(target.getName(), changeDescription::setReferencedTableName);
				changeDescription.setBaseColumnNames(
						fk.getElements().stream().map(c -> c.getFkColumn().getName()).collect(joining(",")));
				changeDescription.setReferencedColumnNames(
						fk.getElements().stream().map(c -> c.getPkColumn().getName()).collect(joining(",")));

				ChangeSet result = buildNextChangeSet();
				result.setComments("Foreign Key : " + fk.getName());
				result.addChange(changeDescription);
				return Optional.of(result);
			}
		} else {
			statuses.add(StatusUtils.createWarningStatus("Invalid foreign key definition : " + fk.getName()));
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

		cConfig.setConstraints(constraintConfig);

		cConfig.setAutoIncrement(column.isAutoincrement() || column.isInPrimaryKey());

		remarksSetter(column, cConfig::setRemarks);
	}

	private void setTypeAndDefaultValue(Table table, Column column, ColumnConfig cConfig, Type type) {
		if (type instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance) type;
			String stringType = genService.getType(typeInstance);
			cConfig.setType(stringType);
			String defaultValue = column.getDefaultValue();
			if (defaultValue != null && !defaultValue.isEmpty()) {
				setColumnDefaultvalue(table, column, cConfig, typeInstance, defaultValue);
			}

		}
	}

	private void setColumnDefaultvalue(Table table, Column column, ColumnConfig cConfig, TypeInstance typeInstance,
			String defaultValue) {
		LiquibaseDefaultType liquibaseMatchingType = DefaultTypeMatcher
				.getLiquibaseDefaultType(typeInstance.getNativeType());

		if (liquibaseMatchingType == LiquibaseDefaultType.UNKWOWN) {
			statuses.add(StatusUtils.createWarningStatus(MessageFormat.format(
					"Unable to set default value for type {0}#{1}. {2} has an unknown logical type.",
					genService.getFullName(table), column.getName(), genService.getLabel(typeInstance))));
		} else if (liquibaseMatchingType == LiquibaseDefaultType.INVALID) {
			statuses.add(StatusUtils.createWarningStatus(
					MessageFormat.format("Unable to set default value for type {0}#{1}. {2} missing type information.",
							genService.getFullName(table), column.getName(), genService.getLabel(typeInstance))));
		} else {
			IStatus defaultValueValidation = DefaultTypeMatcher.validateValue(liquibaseMatchingType, defaultValue);
			String processedValue = DefaultTypeMatcher.preProcessDefaultValue(liquibaseMatchingType, defaultValue);
			if (defaultValueValidation.isOK()) {
				switch (liquibaseMatchingType) {
				case BOOLEAN:
					cConfig.setDefaultValueBoolean(processedValue);
					break;
				case DATE:
					cConfig.setDefaultValueDate(processedValue);
					break;
				case STRING:
					cConfig.setDefaultValue(processedValue);
					break;
				case NUM:
					cConfig.setDefaultValueNumeric(processedValue);
					break;
				default:
					break;
				}
			} else {
				statuses.add(StatusUtils.createMultiStatus(
						"Unable to set default value for type {0}#{1}. {2} invalid default value.",
						Collections.singletonList(defaultValueValidation)));
			}
		}
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
				}
			}
		}

		return result.stream();
	}

	private ChangeSet buildRenameColumnChangeSet(RenameColumnChange renameColumnChange) {
		liquibase.change.core.RenameColumnChange rChange = new liquibase.change.core.RenameColumnChange();
		Column column = renameColumnChange.getColumn();
		Table table = column.getOwner();
		safeSchemaSetter(table.getOwner(), rChange::setSchemaName);
		safeTrimSetter(table.getName(), rChange::setTableName);
		safeTrimSetter(column.getName(), rChange::setOldColumnName);
		safeTrimSetter(renameColumnChange.getNewColumn().getName(), rChange::setNewColumnName);

		Type type = column.getType();
		if (type instanceof TypeInstance) {
			TypeInstance typeInstance = (TypeInstance) type;
			String stringType = genService.getType(typeInstance);
			// required for MySQL and MariaDB
			// See https://docs.liquibase.com/change-types/community/rename-column.html
			rChange.setColumnDataType(stringType);
		}

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
