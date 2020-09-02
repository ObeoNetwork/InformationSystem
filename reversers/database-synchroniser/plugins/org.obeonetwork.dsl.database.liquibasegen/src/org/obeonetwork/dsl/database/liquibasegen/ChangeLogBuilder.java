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

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.dbevolution.AddForeignKey;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.gen.common.services.StatusUtils;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher.LiquibaseDefaultType;
import org.obeonetwork.dsl.database.liquibasegen.service.GenServices;
import org.obeonetwork.dsl.typeslibrary.Type;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

import liquibase.change.ColumnConfig;
import liquibase.change.ConstraintsConfig;
import liquibase.change.core.AddForeignKeyConstraintChange;
import liquibase.change.core.CreateTableChange;
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

	private static <E> Stream<E> filterAndCast(Stream<?> stream, Class<E> type) {
		return stream.filter(e -> type.isInstance(e)).map(e -> type.cast(e));
	}

	public List<ChangeLogChild> buildContent(Comparison comparisonModel) {
		List<ChangeLogChild> result = new ArrayList<ChangeLogChild>();
		genService = new GenServices();
		timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss--"));
		try {
			List<DBDiff> diffs = genService.getOrderedChanges(comparisonModel);
			result.addAll(genChangeSetsForTables(diffs));
			result.addAll(getChangeSetsForForeignKeys(diffs));
		} finally {
			genService.dispose();
			genService = null;
		}

		return result;

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

	private List<ChangeSet> buildAddTableChangeSet(AddTable addTable) {
		List<ChangeSet> result = new ArrayList<ChangeSet>();
		String tableName = genService.getFullName(addTable.getTable());
		String commentPrefix = "[Add table " + tableName + "] ";
		ChangeSet changeSet = buildCreateTableChangeSet(addTable, commentPrefix);
		result.add(changeSet);
		return result;
	}

	private void remarksSetter(DatabaseElement dbe, Consumer<String> setter) {
		safeTrimSetter(dbe.getComments(), setter);
	}

	private void safeTrimSetter(String s, Consumer<String> setter) {
		if (s != null) {
			setter.accept(s.trim());
		}
	}

	private ChangeSet buildCreateTableChangeSet(AddTable addTable, String commentPrefix) {
		CreateTableChange ctChange = new CreateTableChange();
		Table table = addTable.getTable();
		ctChange.setTableName(genService.safeName(table));
		remarksSetter(table, ctChange::setRemarks);

		for (Column column : table.getColumns()) {
			handleColumnInTable(ctChange, table, column);
		}

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.addChange(ctChange);
		changeSet.setComments(commentPrefix + "creation");

		return changeSet;
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

		cConfig.setAutoIncrement(column.isAutoincrement());

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

	private List<ChangeLogChild> genChangeSetsForTables(List<DBDiff> diffs) {
		List<ChangeLogChild> result = new ArrayList<ChangeLogChild>();
		filterAndCast(diffs.stream(), AddTable.class).map(this::buildAddTableChangeSet).forEachOrdered(result::addAll);
		return result;

	}

	private String getNextId() {
		return timeStamp + String.valueOf(changeSetCounter++);
	}

}
