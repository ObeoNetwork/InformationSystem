/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.extensions.builders;

//import org.eclipse.emf.compare.diff.metamodel.DiffElement;
//import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
//import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
//import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
//import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.AlterTable;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveTable;
import org.obeonetwork.dsl.database.dbevolution.RenameTableChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateTableCommentChange;

public class TableChangeBuilder extends ChangeBuilder {
	
	public TableChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getTable());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		Comparison comparison = change.getMatch().getComparison();
		TableContainer tableContainer = (TableContainer)change.getMatch().getRight();
		Table table = (Table) change.getValue();
		return createAddTable(comparison, tableContainer, table, change);
	}

	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		Table table = (Table) change.getValue();
		return createRemoveTable(table, change);
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		// This Match of Tables has differences (or one of the contents of the Tables has) so we mark it with an AlterTable diff.
		AlterTable alterTable = DbevolutionFactory.eINSTANCE.createAlterTable();
		alterTable.setTable((Table) change.getRight());
		alterTable.setTarget(change.getRight());
		return alterTable;
	}
	
	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(change.getAttribute())) {
			return createRenameTableChange(change);
		}
		if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(change.getAttribute())) {
			return createUpdateTableCommentChange(change);
		}
		return super.handleAlterChange(change);
	}

	protected AddTable createAddTable(Comparison comparison, TableContainer tableContainer, Table table, ReferenceChange change) {
		
		AddTable addTable = DbevolutionFactory.eINSTANCE.createAddTable();
		addTable.setTable(table);
		
		fillDBDiff(addTable, change);
		
		return addTable;
	}
	
	protected RemoveTable createRemoveTable(Table table, ReferenceChange change) {		
		RemoveTable removeTable = DbevolutionFactory.eINSTANCE.createRemoveTable();
		removeTable.setTable(table);
		
		fillDBDiff(removeTable, change);
		
		return removeTable;
	}
	
	protected RenameTableChange createRenameTableChange(AttributeChange change) {
		RenameTableChange renameTableChange = DbevolutionFactory.eINSTANCE.createRenameTableChange();
		renameTableChange.setNewTable((Table)change.getMatch().getLeft());	
		renameTableChange.setTable((Table)change.getMatch().getRight());
		renameTableChange.setTarget(renameTableChange.getTable());
		return renameTableChange;
	}
	
	protected UpdateTableCommentChange createUpdateTableCommentChange(AttributeChange change) {
		UpdateTableCommentChange updateTableCommentChange = DbevolutionFactory.eINSTANCE.createUpdateTableCommentChange();	
		updateTableCommentChange.setNewTable((Table) change.getMatch().getLeft());			
		updateTableCommentChange.setTable((Table)change.getMatch().getRight());
		updateTableCommentChange.setTarget(updateTableCommentChange.getTable());
		return updateTableCommentChange;
	}
	
}
