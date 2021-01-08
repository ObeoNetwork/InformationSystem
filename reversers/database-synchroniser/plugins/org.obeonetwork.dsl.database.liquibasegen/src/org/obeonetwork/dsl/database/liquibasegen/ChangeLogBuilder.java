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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
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
import org.obeonetwork.dsl.database.TableContainer;
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
import org.obeonetwork.dsl.database.dbevolution.AlterView;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveConstraint;
import org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey;
import org.obeonetwork.dsl.database.dbevolution.RemoveIndex;
import org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.RemoveSequence;
import org.obeonetwork.dsl.database.dbevolution.RemoveTable;
import org.obeonetwork.dsl.database.dbevolution.RemoveView;
import org.obeonetwork.dsl.database.dbevolution.RenameColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RenameTableChange;
import org.obeonetwork.dsl.database.dbevolution.SequenceChange;
import org.obeonetwork.dsl.database.dbevolution.TableChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateConstraint;
import org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey;
import org.obeonetwork.dsl.database.dbevolution.UpdateIndex;
import org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.UpdateSequence;
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
import liquibase.change.core.AlterSequenceChange;
import liquibase.change.core.CreateIndexChange;
import liquibase.change.core.CreateSequenceChange;
import liquibase.change.core.CreateTableChange;
import liquibase.change.core.CreateViewChange;
import liquibase.change.core.DropColumnChange;
import liquibase.change.core.DropForeignKeyConstraintChange;
import liquibase.change.core.DropIndexChange;
import liquibase.change.core.DropNotNullConstraintChange;
import liquibase.change.core.DropPrimaryKeyChange;
import liquibase.change.core.DropSequenceChange;
import liquibase.change.core.DropTableChange;
import liquibase.change.core.DropViewChange;
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

	/**
	 * Keeps tracks of deleted table to avoid generating conflicts with other drop
	 */
	private Set<String> deletedTables = new HashSet<String>();

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
			result.addAll(getChangeSetsForTables(diffs)); // Needs to be before handled before primary keys
			result.addAll(getChangeSetsForPrimaryKeys(diffs));
			result.addAll(getChangeSetsForConstraints(diffs));
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
		} else if (viewChange instanceof RemoveView) {
			return buildDropViewChangeSet((RemoveView) viewChange);
		} else if (viewChange instanceof AlterView) {
			return buildUpdateViewChangeSet((AlterView) viewChange);
		}
		return Optional.empty();
	}

	private Optional<ChangeSet> buildUpdateViewChangeSet(AlterView viewChange) {

		ChangeSet changeSet = buildNextChangeSet();
		View oldView = (View) viewChange.getTarget();
		View newView = viewChange.getView();
		changeSet.setComments("Updating view : " + oldView);
		changeSet.addChange(buildDropViewChange(oldView));
		changeSet.addChange(buildAddViewChange(newView));
		return Optional.of(changeSet);
	}

	private Optional<ChangeSet> buildDropViewChangeSet(RemoveView viewChange) {
		View view = viewChange.getView();
		DropViewChange dChange = buildDropViewChange(view);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Dropping view : " + view.getName());
		changeSet.addChange(dChange);
		return Optional.of(changeSet);
	}

	private DropViewChange buildDropViewChange(View view) {
		TableContainer container = view.getOwner();
		DropViewChange dChange = new DropViewChange();
		safeSchemaSetter(container, dChange::setSchemaName);
		safeTrimSetter(view.getName(), dChange::setViewName);
		return dChange;
	}

	private ChangeSet buildAddViewChangeSet(AddView viewChange) {
		View view = viewChange.getView();
		CreateViewChange vChange = buildAddViewChange(view);
		ChangeSet changeSet = buildNextChangeSet();
		// Add the view comment both in the remarks and changset comment since the
		// COMMENT ON VIEW is not supported by all DB (not supported on MySQL for
		// example)
		changeSet.setComments("View  " + view.getName() + " : " + view.getComments());
		changeSet.addChange(vChange);
		return changeSet;
	}

	private CreateViewChange buildAddViewChange(View view) {
		CreateViewChange vChange = new CreateViewChange();
		safeTrimSetter(view.getName(), vChange::setViewName);
		safeTrimSetter(genService.getViewQuery(view), vChange::setSelectQuery);
		safeTrimSetter(view.getComments(), vChange::setRemarks);
		vChange.setReplaceIfExists(true);
		safeSchemaSetter(view.getOwner(), vChange::setSchemaName);
		return vChange;
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
		} else if (sequenceChange instanceof RemoveSequence) {
			return buildDropSequenceChangeSet((RemoveSequence) sequenceChange);
		} else if (sequenceChange instanceof UpdateSequence) {
			return buildUpdateSequenceChangeSet((UpdateSequence) sequenceChange);
		}
		return Optional.empty();
	}

	private Optional<ChangeSet> buildUpdateSequenceChangeSet(UpdateSequence sequenceChange) {

		Sequence newSequence = sequenceChange.getNewSequence();
		Sequence oldSequence = sequenceChange.getSequence();
		ChangeSet changeSet = buildNextChangeSet();
		if (Objects.equals(newSequence.getName(), oldSequence.getName())) {
			AlterSequenceChange aChange = buildAlterSequenceChange(newSequence);
			changeSet.setComments("Updating existing sequence " + newSequence.getName());
			changeSet.addChange(aChange);
			return Optional.of(changeSet);

		} else {
			changeSet.setComments("Updating existing sequence (name changed)" + newSequence.getName());
			changeSet.addChange(buildDropSequenceChange(oldSequence));
			changeSet.addChange(buildAddSequenceChange(newSequence));
			return Optional.of(changeSet);

		}
	}

	private AlterSequenceChange buildAlterSequenceChange(Sequence sequence) {
		EObject owner = sequence.eContainer();
		AlterSequenceChange aChange = new AlterSequenceChange();
		safeSchemaSetter(owner, aChange::setSchemaName);
		safeTrimSetter(sequence.getName(), aChange::setSequenceName);

		safeBigIntegerSetter(sequence.getIncrement(), aChange::setIncrementBy);
		safeBigIntegerSetter(sequence.getMinValue(), aChange::setMinValue);
		safeBigIntegerSetter(sequence.getMaxValue(), aChange::setMaxValue);
		// Impossible to change start value of an existing sequence see
		// https://support.jira.obeo.fr/browse/SAFRAN-815?focusedCommentId=3540647&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-3540647
		safeBigIntegerSetter(sequence.getCacheSize(), aChange::setCacheSize);
		safeBigIntegerSetter(sequence.getCacheSize(), aChange::setCacheSize);
		safeSchemaSetter(sequence.eContainer(), aChange::setSchemaName);
		aChange.setCycle(sequence.isCycle());
		return aChange;
	}

	private Optional<ChangeSet> buildDropSequenceChangeSet(RemoveSequence sequenceChange) {

		Sequence sequence = sequenceChange.getSequence();
		DropSequenceChange dChange = buildDropSequenceChange(sequence);

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Dropping sequence :" + sequence.getName());
		changeSet.addChange(dChange);

		return Optional.of(changeSet);
	}

	private DropSequenceChange buildDropSequenceChange(Sequence sequence) {
		DropSequenceChange dChange = new DropSequenceChange();
		EObject container = sequence.eContainer();

		safeSchemaSetter(container, dChange::setSchemaName);
		safeTrimSetter(sequence.getName(), dChange::setSequenceName);

		return dChange;
	}

	private ChangeSet buildAddSequenceChangeSet(AddSequence sequenceChange) {

		Sequence sequence = sequenceChange.getSequence();

		CreateSequenceChange sChange = buildAddSequenceChange(sequence);
		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Sequence " + sequence.getName() + " : " + sequence.getComments());
		changeSet.addChange(sChange);

		return changeSet;
	}

	private CreateSequenceChange buildAddSequenceChange(Sequence sequence) {
		CreateSequenceChange sChange = new CreateSequenceChange();
		safeTrimSetter(sequence.getName(), sChange::setSequenceName);
		safeBigIntegerSetter(sequence.getIncrement(), sChange::setIncrementBy);
		safeBigIntegerSetter(sequence.getMinValue(), sChange::setMinValue);
		safeBigIntegerSetter(sequence.getMaxValue(), sChange::setMaxValue);
		safeBigIntegerSetter(sequence.getStart(), sChange::setStartValue);
		safeBigIntegerSetter(sequence.getCacheSize(), sChange::setCacheSize);
		safeBigIntegerSetter(sequence.getCacheSize(), sChange::setCacheSize);
		safeSchemaSetter(sequence.eContainer(), sChange::setSchemaName);
		sChange.setCycle(sequence.isCycle());
		return sChange;
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForIndexes(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), IndexChange.class)//
				.filter(genService::shouldGenerateIndex)//
				.map(this::buildIndexChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForConstraints(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), ConstraintChange.class)//
				.map(this::buildContraintChangeSet)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Optional<ChangeSet> buildContraintChangeSet(ConstraintChange constraintChange) {
		if (constraintChange instanceof AddConstraint) {
			return buildAddConstraintChangeSet((AddConstraint) constraintChange);
		} else if (constraintChange instanceof RemoveConstraint) {
			return buildDropConstraintChangeSet((RemoveConstraint) constraintChange);
		} else if (constraintChange instanceof UpdateConstraint) {
			return buildUpdateConstraintChangeSet((UpdateConstraint) constraintChange);
		}
		return Optional.empty();

	}

	private Optional<ChangeSet> buildUpdateConstraintChangeSet(UpdateConstraint constraintChange) {
		ChangeSet changeSet = buildNextChangeSet();
		Constraint newConstraint = constraintChange.getNewConstraint();
		Constraint oldConstraint = constraintChange.getConstraint();
		changeSet.setComments("Updating constraint : " + newConstraint.getName());
		changeSet.addChange(buildDropConstraintChange(oldConstraint));
		changeSet.addChange(buildAddConstraintChange(newConstraint));
		return Optional.of(changeSet);
	}

	private Optional<ChangeSet> buildDropConstraintChangeSet(RemoveConstraint constraintChange) {
		Constraint constraint = constraintChange.getConstraint();

		Table table = constraint.getOwner();
		String tableQN = genService.getFullName(table);
		if (deletedTables.contains(tableQN)) {
			// The index will be dropped with the table
			return Optional.empty();
		}

		RawSQLChange sqlChange = buildDropConstraintChange(constraint);
		ChangeSet result = buildNextChangeSet();
		result.addChange(sqlChange);
		result.setComments(MessageFormat.format("Dropping constraint : {0}", constraint.getName()));
		return Optional.of(result);
	}

	private RawSQLChange buildDropConstraintChange(Constraint constraint) {
		RawSQLChange sqlChange = new RawSQLChange(sqlService
				.buildDropConstraintQuery(genService.getFullName(constraint.getOwner()), constraint.getName()));
		return sqlChange;
	}

	private Optional<ChangeSet> buildIndexChangeSet(IndexChange indexChange) {
		if (indexChange instanceof AddIndex) {
			return buildAddIndexChangeSet((AddIndex) indexChange);
		} else if (indexChange instanceof RemoveIndex) {
			return buildDropIndexChangeSet((RemoveIndex) indexChange);
		} else if (indexChange instanceof UpdateIndex) {
			return buildUpdateIndexChangeSet((UpdateIndex) indexChange);
		}
		return Optional.empty();

	}

	private Optional<ChangeSet> buildUpdateIndexChangeSet(UpdateIndex indexChange) {
		Index oldIndex = indexChange.getIndex();
		Index newIndex = indexChange.getNewIndex();

		Optional<DropIndexChange> optDrop = buildDropIndexChange(oldIndex);
		Optional<CreateIndexChange> optAddIndex = buildAddIndexChange(newIndex);

		if (optDrop.isPresent() || optAddIndex.isPresent()) {
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Updating index " + oldIndex.getName());
			optDrop.ifPresent(changeSet::addChange);
			optAddIndex.ifPresent(changeSet::addChange);

			return Optional.of(changeSet);
		}

		return Optional.empty();
	}

	private Optional<ChangeSet> buildDropIndexChangeSet(RemoveIndex indexChange) {

		Index index = indexChange.getIndex();
		return buildDropIndexChange(index).map(dChange -> {
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Drop index " + index.getName());
			changeSet.addChange(dChange);
			return Optional.of(changeSet);
		}).orElse(Optional.empty());
	}

	private Optional<DropIndexChange> buildDropIndexChange(Index index) {
		Table table = index.getOwner();
		String tableQN = genService.getFullName(table);
		if (deletedTables.contains(tableQN)) {
			// The index will be dropped with the table
			return Optional.empty();
		}

		DropIndexChange dChange = new DropIndexChange();

		safeSchemaSetter(table.getOwner(), dChange::setSchemaName);
		safeTrimSetter(table.getName(), dChange::setTableName);
		safeTrimSetter(index.getName(), dChange::setIndexName);
		return Optional.of(dChange);
	}

	private Optional<ChangeSet> buildAddIndexChangeSet(AddIndex addIndex) {
		Index index = addIndex.getIndex();
		return buildAddIndexChange(index).map(iChange -> {
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Index : " + index.getName());
			changeSet.addChange(iChange);
			return Optional.of(changeSet);
		}).orElse(Optional.empty());
	}

	private Optional<CreateIndexChange> buildAddIndexChange(Index index) {
		CreateIndexChange iChange = new CreateIndexChange();
		iChange.setUnique(index.isUnique());
		safeTrimSetter(index.getName(), iChange::setIndexName);
		safeTrimSetter(index.getOwner().getName(), iChange::setTableName);

		List<AddColumnConfig> columnConfigs = index.getElements().stream()//
				.filter(c -> c.getColumn() != null && c.getColumn().getName() != null).map(c -> {
					AddColumnConfig config = new AddColumnConfig();
					safeTrimSetter(c.getColumn().getName(), config::setName);
					config.setDescending(!c.isAsc());
					return config;
				}).collect(toList());

		// Do not generate an index if there is element no in it
		// This may be removed once a matching validator is implemented
		if (columnConfigs.isEmpty()) {
			statuses.add(createWarningStatus("Index " + index.getName() + " has no column."));
			return Optional.empty();
		}
		iChange.setColumns(columnConfigs);
		safeSchemaSetter(index.getOwner().getOwner(), iChange::setSchemaName);
		return Optional.of(iChange);
	}

	private Optional<ChangeSet> buildAddConstraintChangeSet(AddConstraint addConstraint) {
		Constraint constraint = addConstraint.getConstraint();
		IStatus status = sqlService.validateConstaint(constraint);
		if (status.isOK()) {
			RawSQLChange sqlChange = buildAddConstraintChange(constraint);
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

	private RawSQLChange buildAddConstraintChange(Constraint constraint) {
		return new RawSQLChange(sqlService.buildAddConstraintQuery(genService.getFullName(constraint.getOwner()),
				constraint.getName(), constraint.getExpression()));
	}

	private Collection<? extends ChangeLogChild> getChangeSetsForForeignKeys(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), ForeignKeyChange.class)//
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
		} else if (primKeyChange instanceof RemovePrimaryKey) {
			return buildDropPrimaryKeyChangeSet((RemovePrimaryKey) primKeyChange);
		} else if (primKeyChange instanceof UpdatePrimaryKey) {
			return buildUpdatePrimaryKeyChangeSet((UpdatePrimaryKey) primKeyChange);
		}

		return Optional.empty();

	}

	private Optional<ChangeSet> buildUpdatePrimaryKeyChangeSet(UpdatePrimaryKey primKeyChange) {
		PrimaryKey pk = primKeyChange.getPrimaryKey();

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Updating primary key " + pk.getName());
		changeSet.addChange(buildDropPrimaryKeyChange(pk));
		changeSet.addChange(buildAddPrimaryChange(pk));

		return Optional.of(changeSet);
	}

	private Optional<ChangeSet> buildDropPrimaryKeyChangeSet(RemovePrimaryKey primKeyChange) {
		PrimaryKey pk = primKeyChange.getPrimaryKey();
		Table table = pk.getOwner();
		String tableQName = genService.getFullName(table);
		if (deletedTables.contains(tableQName)) {
			// Deleting table should also deletes this constraint
			return Optional.empty();
		} else {
			DropPrimaryKeyChange dChange = buildDropPrimaryKeyChange(pk);

			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Dropping primary key " + pk.getName() + " on table " + tableQName);
			changeSet.addChange(dChange);
			return Optional.of(changeSet);
		}
	}

	private DropPrimaryKeyChange buildDropPrimaryKeyChange(PrimaryKey pk) {
		Table table = pk.getOwner();
		DropPrimaryKeyChange dChange = new DropPrimaryKeyChange();
		safeTrimSetter(pk.getName(), dChange::setConstraintName);
		safeSchemaSetter(table.getOwner(), dChange::setSchemaName);
		safeTrimSetter(table.getName(), dChange::setTableName);
		return dChange;
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

			columnsQN.stream().filter(qn -> updatedColumnConfs.containsKey(qn)).forEach(qn -> {
				updatedColumnConfs.get(qn).setPrimaryKey((Boolean) null); // Don't add the primary during the creation
			});

			// Create a specific changeSet
			ChangeSet changeSet = buildNextChangeSet();
			AddPrimaryKeyChange aChange = buildAddPrimaryChange(primKey);

			String columnNames = columns.stream().map(c -> c.getName()).filter(n -> n != null).map(n -> n.trim())
					.collect(joining(","));
			changeSet.setComments("Adding primary key on " + columnNames + " in " + primKey.getOwner().getName());
			changeSet.addChange(aChange);
			return Optional.of(changeSet);
		}

	}

	private AddPrimaryKeyChange buildAddPrimaryChange(PrimaryKey primKey) {
		AddPrimaryKeyChange aChange = new AddPrimaryKeyChange();
		Table table = primKey.getOwner();
		EList<Column> columns2 = primKey.getColumns();
		safeSchemaSetter(table.getOwner(), aChange::setSchemaName);
		safeTrimSetter(table.getName(), aChange::setTableName);
		String columnNames = columns2.stream().map(c -> c.getName()).filter(n -> n != null).map(n -> n.trim())
				.collect(joining(","));
		aChange.setColumnNames(columnNames);
		safeTrimSetter(primKey.getName(), aChange::setConstraintName);
		return aChange;
	}

	private Optional<ChangeSet> buildForeignKeyChangeSet(ForeignKeyChange foreignKeyChange) {
		if (foreignKeyChange instanceof AddForeignKey) {
			return buildAddForeignKeyChangeSet((AddForeignKey) foreignKeyChange);
		} else if (foreignKeyChange instanceof RemoveForeignKey) {
			return buildDropForeignKeyChangeSet((RemoveForeignKey) foreignKeyChange);
		} else if (foreignKeyChange instanceof UpdateForeignKey) {
			return buildUpdateForeignKeyChangeSet((UpdateForeignKey) foreignKeyChange);
		}
		return Optional.empty();

	}

	private Optional<ChangeSet> buildUpdateForeignKeyChangeSet(UpdateForeignKey foreignKeyChange) {
		ForeignKey oldFK = foreignKeyChange.getForeignKey();
		ForeignKey newFK = foreignKeyChange.getNewForeignKey();

		Optional<AddForeignKeyConstraintChange> optAddFK = buildAddForeignKeyChange(newFK);
		Optional<DropForeignKeyConstraintChange> optDropFK = buildDropForeignKeyChange(oldFK);
		// Don't drop the FK if we can't create a new one
		if (optAddFK.isPresent() && optDropFK.isPresent()) {
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Updating foreign key " + oldFK.getName());
			changeSet.addChange(optDropFK.get());
			changeSet.addChange(optAddFK.get());
			return Optional.of(changeSet);
		}

		return Optional.empty();

	}

	private Optional<ChangeSet> buildDropForeignKeyChangeSet(RemoveForeignKey foreignKeyChange) {
		ForeignKey fk = foreignKeyChange.getForeignKey();

		return buildDropForeignKeyChange(fk).map(change -> {
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.setComments("Dropping foreign key " + fk.getName());
			changeSet.addChange(change);
			return Optional.of(changeSet);
		}).orElse(Optional.empty());
	}

	private Optional<DropForeignKeyConstraintChange> buildDropForeignKeyChange(ForeignKey fk) {
		Table sourceTable = fk.getSourceTable();
		String sourceTableQn = genService.getFullName(sourceTable);

		// Dropping the ownign table will also drop the FK constraint
		if (deletedTables.contains(sourceTableQn)) {
			return Optional.empty();
		} else {
			DropForeignKeyConstraintChange dChange = new DropForeignKeyConstraintChange();
			safeSchemaSetter(sourceTable.getOwner(), dChange::setBaseTableSchemaName);
			safeTrimSetter(sourceTable.getName(), dChange::setBaseTableName);
			safeTrimSetter(fk.getName(), dChange::setConstraintName);

			return Optional.of(dChange);
		}
	}

	private Optional<ChangeSet> buildAddForeignKeyChangeSet(AddForeignKey addForeign) {
		ForeignKey fk = addForeign.getForeignKey();
		return buildAddForeignKeyChange(fk).map(change -> {
			ChangeSet result = buildNextChangeSet();
			result.setComments("Foreign Key : " + fk.getName());
			result.addChange(change);
			return Optional.of(result);
		}).orElse(Optional.empty());

	}

	private Optional<AddForeignKeyConstraintChange> buildAddForeignKeyChange(ForeignKey fk) {
		if (fk.getElements().stream().allMatch(e -> e.getPkColumn() != null)) {
			Table sourceTable = fk.getOwner();
			Table target = fk.getElements().stream().map(e -> (Table) e.getPkColumn().eContainer()).findFirst()
					.orElse(null);
			if (target != null) {
				AddForeignKeyConstraintChange changeDescription = new AddForeignKeyConstraintChange();
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

				return Optional.of(changeDescription);
			}
		} else {
			statuses.add(createWarningStatus("Invalid foreign key definition : " + fk.getName()));
		}
		return Optional.empty();
	}

	private Optional<ChangeSet> buildAddTableChangeSet(AddTable addTable) {
		Table table = addTable.getTable();
		Optional<CreateTableChange> buildCreateTableChange = buildCreateTableChange(table);

		return buildCreateTableChange.map(change -> {
			ChangeSet changeSet = buildNextChangeSet();
			changeSet.addChange(change);
			changeSet.setComments("Create table " + table.getName());
			return changeSet;
		});
	}

	private Optional<CreateTableChange> buildCreateTableChange(Table table) {
		CreateTableChange ctChange = new CreateTableChange();
		safeTrimSetter(table.getName(), ctChange::setTableName);
		safeSchemaSetter(table.getOwner(), ctChange::setSchemaName);
		remarksSetter(table, ctChange::setRemarks);

		if (table.getColumns().isEmpty()) {
			statuses.add(
					createWarningStatus(table.getName() + " has no column. It will not handled by this generator."));
			return Optional.empty();
		}

		for (Column column : table.getColumns()) {
			ColumnConfig cConfig = new ColumnConfig();
			fillColumnConfig(table, column, cConfig);
			ctChange.addColumn(cConfig);
		}
		return Optional.of(ctChange);
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
			buildAddTableChangeSet((AddTable) tableChange).ifPresent(result::add);
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
	private boolean hasAttributeChangeChanged(Diff updateChange, EAttribute attribute) {

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
		if (hasAttributeChangeChanged(updateColumnChange, DatabasePackage.eINSTANCE.getColumn_Nullable())) {
			if (column.isNullable()) {
				result.add(buildDropNotNullConstraint(column));
			} else {
				result.add(buildSetNotNullConstraint(column));
			}
		}

		// Auto increment
		if (hasAttributeChangeChanged(updateColumnChange, DatabasePackage.eINSTANCE.getColumn_Autoincrement())) {
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
		if (hasAttributeChangeChanged(updateColumnChange, DatabasePackage.eINSTANCE.getColumn_DefaultValue())) {
			buildChangeDefaultValueOnColumn(column).ifPresent(result::add);
		}

		// Update comment
		if (hasAttributeChangeChanged(updateColumnChange, DatabasePackage.eINSTANCE.getDatabaseElement_Comments())) {
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

		deletedTables.add(genService.getFullName(table));

		ChangeSet changeSet = buildNextChangeSet();
		changeSet.setComments("Drop Table : " + table.getName());
		changeSet.addChange(dChange);

		return changeSet;
	}

	private List<ChangeLogChild> getChangeSetsForTables(List<DBDiff> diffs) {
		return filterAndCast(diffs.stream(), TableChange.class)//
				.flatMap(this::buildTableChangeSet)//
				.collect(toList());
	}

	private String getNextId() {
		return timeStamp + String.valueOf(changeSetCounter++);
	}

}
