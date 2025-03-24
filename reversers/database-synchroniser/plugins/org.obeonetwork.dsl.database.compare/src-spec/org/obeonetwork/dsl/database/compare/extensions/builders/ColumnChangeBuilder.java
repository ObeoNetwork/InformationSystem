/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.extensions.builders;

import java.util.HashMap;
import java.util.Map;

//import org.eclipse.emf.compare.diff.metamodel.DiffElement;
//import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
//import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
//import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
//import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
//import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.dbevolution.AddColumnChange;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveColumnChange;
import org.obeonetwork.dsl.database.dbevolution.RenameColumnChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateColumnChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateColumnCommentChange;

public class ColumnChangeBuilder extends ChangeBuilder {

	private Map<Column, UpdateColumnChange> columnsToUpdate = new HashMap<Column, UpdateColumnChange>();

	public ColumnChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getColumn());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		if (change.getReference().isContainment()) {
			Table table = (Table) change.getMatch().getRight();
			Column column = (Column) change.getValue();
			return createAddColumnChange(table, column, change);
		}
		return null;
	}

	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		if (change.getReference().isContainment()) {
			Table table = (Table) change.getMatch().getLeft();
			Column column = (Column) change.getValue();
			return createRemoveColumnChange(table, column, change);
		}
		return null;
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		Column column = (Column) change.getLeft();
//		if (!alreadyCreatedUpdateColumnChange(column)) {
			UpdateColumnChange updateColumn = DbevolutionFactory.eINSTANCE.createUpdateColumnChange();
			columnsToUpdate.put(column, updateColumn);
			updateColumn.setColumn(column);
			updateColumn.setTarget(change.getRight());
			return updateColumn;
//		} else {
//			return null;
//		}
	}

	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(change.getAttribute())) {
			return createUpdateColumnCommentChange(change);
		}
		if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(change.getAttribute())) {
			return createRenameColumnChange(change);
		}
		if (DatabasePackage.eINSTANCE.getColumn_Nullable().equals(change.getAttribute())
				|| DatabasePackage.eINSTANCE.getColumn_DefaultValue().equals(change.getAttribute())
				|| DatabasePackage.eINSTANCE.getColumn_Autoincrement().equals(change.getAttribute())) {
//			Column column = (Column) change.getMatch().getLeft();
//			if (!alreadyCreatedUpdateColumnChange(column)) {
				// When changing one of 'nullable', 'length', 'default value',
				// etc. all changes are already included in the generated
				// script. So just add one UpdateColumnChange as long as one of
				// them has changed.
				UpdateColumnChange updateColumnChange = createUpdateColumnChange(change);
//				columnsToUpdate.put(column, updateColumnChange);
				return updateColumnChange;
//			} else {
//				return null;
//			}
		}
		return null;
	}

	private boolean alreadyCreatedUpdateColumnChange(Column column) {
		return columnsToUpdate.get(column) != null;
	}

	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		if (DatabasePackage.eINSTANCE.getColumn_Sequence().equals(change.getReference())) {
			// This change is useless because it has no impact on SQL scripts
			return null;
		}
		if (DatabasePackage.eINSTANCE.getColumn_PrimaryKey().equals(change.getReference())) {
			// This change is useless because it has no impact on SQL scripts
			return null;
		}
		if (DatabasePackage.eINSTANCE.getColumn_ForeignKeyElements().equals(change.getReference())) {
			// This change is useless because it has no impact on SQL scripts
			return null;
		}
		if (DatabasePackage.eINSTANCE.getColumn_IndexElements().equals(change.getReference())) {
			// This change is useless because it has no impact on SQL scripts
			return null;
		}
		return super.handleAlterChange(change);
	}

	protected AddColumnChange createAddColumnChange(Table table, Column column, ReferenceChange change) {

		AddColumnChange addColumnChange = DbevolutionFactory.eINSTANCE.createAddColumnChange();
		addColumnChange.setColumn(column);

		fillDBDiff(addColumnChange, change);

		return addColumnChange;
	}

	protected RemoveColumnChange createRemoveColumnChange(Table table, Column column, ReferenceChange change) {

		RemoveColumnChange removeColumnChange = DbevolutionFactory.eINSTANCE.createRemoveColumnChange();
		removeColumnChange.setColumn(column);

		fillDBDiff(removeColumnChange, change);

		return removeColumnChange;
	}

	protected UpdateColumnChange createUpdateColumnChange(AttributeChange change) {
		UpdateColumnChange updateColumnChange = DbevolutionFactory.eINSTANCE.createUpdateColumnChange();
		updateColumnChange.setColumn((Column) change.getMatch().getLeft());
		updateColumnChange.setTarget(change.getMatch().getRight());
		return updateColumnChange;
	}

	protected UpdateColumnCommentChange createUpdateColumnCommentChange(AttributeChange change) {
		UpdateColumnCommentChange updateColumnCommentChange = DbevolutionFactory.eINSTANCE
				.createUpdateColumnCommentChange();
		Column column = (Column) change.getMatch().getLeft();
		updateColumnCommentChange.setColumn(column);
		updateColumnCommentChange.setTarget(change.getMatch().getRight());
		return updateColumnCommentChange;
	}

	protected RenameColumnChange createRenameColumnChange(AttributeChange change) {
		RenameColumnChange renameColumnChange = DbevolutionFactory.eINSTANCE.createRenameColumnChange();
		renameColumnChange.setColumn((Column) change.getMatch().getRight());
		renameColumnChange.setNewColumn((Column) change.getMatch().getLeft());
		renameColumnChange.setTarget(renameColumnChange.getColumn());
		return renameColumnChange;
	}

}
