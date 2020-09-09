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
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.dbevolution.AddConstraint;
import org.obeonetwork.dsl.database.dbevolution.AddForeignKey;
import org.obeonetwork.dsl.database.dbevolution.AddIndex;
import org.obeonetwork.dsl.database.dbevolution.AddSequence;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.AddView;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.SequenceChange;
import org.obeonetwork.dsl.database.dbevolution.TableChange;
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
import liquibase.change.core.RawSQLChange;
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
		CreateIndexChange cChangle = new CreateIndexChange();
		cChangle.setUnique(index.isUnique());
		safeTrimSetter(index.getName(), cChangle::setIndexName);
		safeTrimSetter(index.getOwner().getName(), cChangle::setTableName);

		List<AddColumnConfig> columnCongis = index.getElements().stream()//
				.filter(c -> c.getColumn() != null && c.getColumn().getName() != null).map(c -> {
					AddColumnConfig config = new AddColumnConfig();
					safeTrimSetter(c.getColumn().getName(), config::setName);
					return config;
				}).collect(toList());
		cChangle.setColumns(columnCongis);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Index : " + index.getName());
		changeSet.addChange(cChangle);
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
		String tableName = genService.getFullName(addTable.getTable());
		String commentPrefix = "[Add table " + tableName + "] ";
		CreateTableChange ctChange = new CreateTableChange();
		Table table = addTable.getTable();
		ctChange.setTableName(genService.safeName(table));
		remarksSetter(table, ctChange::setRemarks);

		TableContainer owner = table.getOwner();
		if (owner instanceof Schema) {
			safeTrimSetter(((Schema) owner).getName(), ctChange::setSchemaName);
		}
		for (Column column : table.getColumns()) {
			handleColumnInTable(ctChange, table, column);
		}

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(ctChange);
		changeSet.setComments(commentPrefix + "creation");
		return changeSet;
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


	private void handleColumnInTable(CreateTableChange ctChange, Table table, Column column) {
		ColumnConfig cConfig = new ColumnConfig();
		cConfig.setName(column.getName());

		Type type = column.getType();
		setColumnDefaultValue(table, column, cConfig, type);

		// Handle primary key
		ConstraintsConfig constraintConfig = new ConstraintsConfig();
		constraintConfig.setNullable(column.isNullable());
		if (column.isInPrimaryKey()) {
			constraintConfig.setPrimaryKey(column.isInPrimaryKey());
		}

		cConfig.setConstraints(constraintConfig);

		cConfig.setAutoIncrement(column.isAutoincrement() || column.isInPrimaryKey());

		remarksSetter(column, cConfig::setRemarks);

		ctChange.addColumn(cConfig);
	}

	private void setColumnDefaultValue(Table table, Column column, ColumnConfig cConfig, Type type) {
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

	private Optional<ChangeSet> buildTableChangeSet(TableChange tableChange) {
		if (tableChange instanceof AddTable) {
			return Optional.of(buildAddTableChangeSet((AddTable) tableChange));
		}

		return Optional.empty();
	}

	private List<ChangeLogChild> genChangeSetsForTables(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), TableChange.class)//
				.map(this::buildTableChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private String getNextId() {
		return timeStamp + String.valueOf(changeSetCounter++);
	}

}
