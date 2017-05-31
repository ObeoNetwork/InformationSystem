/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.compare.extensions.services.DiffContentService;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.util.DatabaseSwitch;

public class UtilServices {
	
	private static List<EClass> dbDiffsOrder = null;
	private int getOrderForDiff(DBDiff diff){
		if (dbDiffsOrder == null) {
			// Initialize
			dbDiffsOrder = new ArrayList<EClass>();
			
			// Remove
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveColumnChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveIndex());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveConstraint());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemovePrimaryKey());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveForeignKey());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveSequence());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveTable());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRemoveSchema());
			
			// Add
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddColumnChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddPrimaryKey());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddTable());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddIndex());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddConstraint());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddForeignKey());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddSchema());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAddSequence());
				
			// Alter
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRenameTableChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAlterTable());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateTableCommentChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateColumnChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRenameColumnChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateColumnCommentChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdatePrimaryKey());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateConstraint());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateForeignKey());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateIndex());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAlterView());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRenameViewChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateViewQueryChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateViewCommentChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateSequence());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getRenameSchemaChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getUpdateSchemaCommentChange());
			dbDiffsOrder.add(DbevolutionPackage.eINSTANCE.getAlterSchema());
			
		}
		int index = dbDiffsOrder.indexOf(diff.eClass());
		if (index == -1) {
			System.out.println("Eclass non connue" + diff.eClass());
		}
		return index;
	}
	
	private void orderChanges(List<DBDiff> changes) {
		
		// Order changes
		Collections.sort(changes, new Comparator<DBDiff>() {
			@Override
			public int compare(DBDiff d1, DBDiff d2) {
				DatabaseElement db1 = getDatabaseElementForDiff(d1);
				AbstractTable abstractTable1 = getAbstractTableForDatabaseElement(db1);
				
				DatabaseElement db2 = getDatabaseElementForDiff(d2);
				AbstractTable abstractTable2 = getAbstractTableForDatabaseElement(db2);
				
				// First compare abstract tables
				if (abstractTable1 == null && abstractTable2 != null) {
					return -1;
				} else if (abstractTable1 != null && abstractTable2 == null) {
					return 1;
				} else if (abstractTable1 != null && abstractTable2 != null) {
					int abstractTableNameComp = abstractTable1.getName().compareTo(abstractTable2.getName());
					if (abstractTableNameComp != 0) {
						return abstractTableNameComp;
					}
				}
				
				// Compare changes type
				// Abstract tables are null or the same if we are here				
				int i1 = getOrderForDiff(d1);
				int i2 = getOrderForDiff(d2);
				int typeComparison = new Integer(i1).compareTo(new Integer(i2));
				if (typeComparison != 0) {
					return typeComparison;
				} else {
					// Compare objects themselves
					String id1 = db1.getID();
					String id2 = db2.getID();
					return id1.compareTo(id2);
				}
				
			}
		});
	}
	
	public List<DBDiff> getOrderedChanges(Comparison comparison) {
		// Collect all changes
		List<DBDiff> changes = new ArrayList<DBDiff>();
		TreeIterator<EObject> it = comparison.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof DBDiff) {
				changes.add((DBDiff)next);
			}
		}
		
		orderChanges(changes);
		
		return changes;
	}
	
	private DatabaseElement getDatabaseElementForDiff(DBDiff diff) {
		EObject target = diff.getTarget();
		if (target instanceof DatabaseElement) {
			return (DatabaseElement) target;
		}
		return null;
	}
	
	/**
	 * Return the abstract table for any kind of DatabaseElement
	 * @param element
	 * @return
	 */
	private AbstractTable getAbstractTableForDatabaseElement(DatabaseElement element) {
		return new DatabaseSwitch<AbstractTable>() {
			@Override
			public AbstractTable caseColumn(Column object) {
				return object.getOwner();
			}

			@Override
			public AbstractTable caseIndex(Index object) {
				return object.getOwner();
			}

			@Override
			public AbstractTable casePrimaryKey(PrimaryKey object) {
				return object.getOwner();
			}

			@Override
			public AbstractTable caseForeignKey(ForeignKey object) {
				return object.getOwner();
			}

			@Override
			public AbstractTable caseConstraint(Constraint object) {
				return object.getOwner();
			}

			@Override
			public AbstractTable caseSequence(Sequence object) {
				EList<Column> columns = object.getColumns();
				for (Column column : columns) {
					if (column.getOwner() != null) {
						return column.getOwner();
					}
				}
				return null;
			}
			
			@Override
			public AbstractTable caseAbstractTable(AbstractTable object) {
				return object;
			};
			
			@Override
			public AbstractTable defaultCase(EObject object) {
				return null;
			};
			
		}.doSwitch(element);
	}

	private DiffContentService diffContentService = null;
	
	public List<DBDiff> getSubDiffs(Diff diff) {
		List<Diff> subDiffs = getDiffContentService().getSubDiffs(diff);
		
		List<DBDiff> changes = new ArrayList<DBDiff>();
		for (Diff subDiff : subDiffs) {
			if (subDiff instanceof DBDiff) {
				changes.add((DBDiff)subDiff);
			}
		}
		
		orderChanges(changes);
		
		return changes;
	}
	
	public Diff getRelatedDiff(Diff diff) {
		if (!diff.getRefinedBy().isEmpty()) {
			Diff refiningDiff = diff.getRefinedBy().get(0);
			if (!refiningDiff.getRequiredBy().isEmpty()) {
				Diff otherDiff = refiningDiff.getRequiredBy().get(0);
				if (!otherDiff.getRefines().isEmpty()) {
					return otherDiff.getRefines().get(0);
				}
			}
		}
		return null;
	}
	
	private DiffContentService getDiffContentService() {
		if (diffContentService == null) {
			diffContentService = new DiffContentService();
		}
		return diffContentService;
	}
}
