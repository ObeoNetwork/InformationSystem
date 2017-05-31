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
package org.obeonetwork.dsl.database.compare.extensions.services;

import static com.google.common.base.Predicates.alwaysFalse;
import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.base.Predicates.or;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.CONTAINMENT_REFERENCE_CHANGE;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.ofKind;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.dbevolution.AddTable;
import org.obeonetwork.dsl.database.dbevolution.AlterTable;
import org.obeonetwork.dsl.database.dbevolution.AlterView;
import org.obeonetwork.dsl.database.dbevolution.ColumnChange;
import org.obeonetwork.dsl.database.dbevolution.ConstraintChange;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.ForeignKeyChange;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange;
import org.obeonetwork.dsl.database.dbevolution.RemoveTable;
import org.obeonetwork.dsl.database.dbevolution.RemoveView;
import org.obeonetwork.dsl.database.dbevolution.SchemaChange;
import org.obeonetwork.dsl.database.dbevolution.SequenceChange;
import org.obeonetwork.dsl.database.dbevolution.TableChange;
import org.obeonetwork.dsl.database.dbevolution.ViewChange;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class DiffContentService {
	
	private Map<EClass, Predicate<? super Diff>> possibleDiffsUnderDBDiff;
	
	private static class AlterPredicate implements Predicate<Diff> {
		
		protected EClass kind = null;
		
		public AlterPredicate(EClass alterkind) {
			kind = alterkind;
		}
		
		public boolean apply(Diff input) {
			EStructuralFeature feature = getFeature(input);
			// Keep the given difference if:
			return isAboutTheImpactedObject(input)
					&& input.getRefines().isEmpty()
					&& (DatabasePackage.Literals.DATABASE_ELEMENT__COMMENTS.equals(feature) || DatabasePackage.Literals.NAMED_ELEMENT__NAME.equals(feature))
				|| 	specificCondition(input, feature);
		}
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return false;
		}
		
		protected boolean isAboutTheImpactedObject(Diff input) {
			return kind.isInstance(getValue(input.getMatch()));
		}
		
		protected EObject getValue(Match match) {
			EObject right = match.getRight();
			if (right != null) {
				return right;
			} else {
				return match.getLeft();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static final Predicate<? super Diff> ADD_SCHEMA_SUBDIFFS = or(
			instanceOf(TableChange.class), 
			instanceOf(SequenceChange.class),
			instanceOf(ViewChange.class));
	
	@SuppressWarnings("unchecked")
	private static final Predicate<? super Diff> REMOVE_SCHEMA_SUBDIFFS = or(
			instanceOf(TableChange.class), 
			instanceOf(SequenceChange.class),
			instanceOf(ViewChange.class));
	
	@SuppressWarnings("unchecked")
	private static final Predicate<? super Diff> ADD_TABLE_SUBDIFFS = or(
			instanceOf(PrimaryKeyChange.class), 
			instanceOf(ForeignKeyChange.class), 
			instanceOf(ConstraintChange.class), 
			instanceOf(IndexChange.class));
	
	private static final Predicate<? super Diff> ALTER_TABLE_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.TABLE) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return 		input instanceof ColumnChange
					||	input instanceof ForeignKeyChange
					||	input instanceof PrimaryKeyChange
					||	input instanceof IndexChange
					||	input instanceof ConstraintChange
					||	input instanceof TableChange
					||	DatabasePackage.Literals.COLUMN__NULLABLE.equals(feature);
		};
		
	};
	
	private static final Predicate<? super Diff> ALTER_VIEW_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.VIEW) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return 		input instanceof ViewChange;
		};
		
	};
	
	private static final Predicate<? super Diff> UPDATE_CONSTRAINT_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.CONSTRAINT) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return input.getKind() == DifferenceKind.CHANGE 
					&& DatabasePackage.Literals.CONSTRAINT__EXPRESSION.equals(feature);
		};
		
	};
	
	private static final Predicate<? super Diff> UPDATE_PK_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.PRIMARY_KEY) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return DatabasePackage.Literals.PRIMARY_KEY__COLUMNS.equals(feature);
		};
		
	};
	
	private static final Predicate<? super Diff> ALTER_SCHEMA_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.SCHEMA) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return input instanceof AddTable
					||	input instanceof RemoveTable
					||	input instanceof AlterTable
					||	input instanceof SequenceChange
					||	input instanceof SchemaChange
					||	input instanceof RemoveView
					||	input instanceof AlterView;
		};
	
	};
	
	private static final Predicate<? super Diff> UPDATE_SEQUENCE_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.SEQUENCE) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return input.getKind() == DifferenceKind.CHANGE && (
					DatabasePackage.Literals.SEQUENCE__START.equals(feature)
				||	DatabasePackage.Literals.SEQUENCE__CYCLE.equals(feature)
				||	DatabasePackage.Literals.SEQUENCE__INCREMENT.equals(feature)
			);
		};
		
	};
	
	private static final Predicate<? super Diff> UPDATE_FOREIGN_KEY_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.FOREIGN_KEY) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			boolean result = 
						DatabasePackage.Literals.NAMED_ELEMENT__NAME.equals(feature)
					||	DatabasePackage.Literals.FOREIGN_KEY__TARGET.equals(feature)
					||	DatabasePackage.Literals.FOREIGN_KEY__ELEMENTS.equals(feature);
			if (!isInAddOrDelete(input)) {
				result = result || DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__PK_COLUMN.equals(feature);
				result = result || DatabasePackage.Literals.FOREIGN_KEY_ELEMENT__FK_COLUMN.equals(feature);
			}
			return result;
		};
		
		protected boolean isAboutTheImpactedObject(Diff input) {
			// Comment changes on FOREIGN_ELEMENTS has to be located under the update of the related FOREIGN_KEY
			return super.isAboutTheImpactedObject(input)
					|| DatabasePackage.Literals.FOREIGN_KEY_ELEMENT.isInstance(getValue(input.getMatch()));
		};
	
	};
	
	private static final Predicate<? super Diff> UPDATE_INDEX_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.INDEX) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {	
			boolean result = 
					DatabasePackage.Literals.INDEX__UNIQUE.equals(feature)
				||	DatabasePackage.Literals.INDEX__ELEMENTS.equals(feature)
				||	DatabasePackage.Literals.INDEX_ELEMENT__ASC.equals(feature);
			if (!isInAddOrDelete(input)) {
				result = result || DatabasePackage.Literals.INDEX_ELEMENT__COLUMN.equals(feature);
			}
			return result;
		};
		
	};
	
	private static final Predicate<? super Diff> UPDATE_COLUMN_SUBDIFFS = new AlterPredicate(DatabasePackage.Literals.COLUMN) {
		
		protected boolean specificCondition(Diff input, EStructuralFeature feature) {
			return 
					TypesLibraryPackage.Literals.TYPE_INSTANCE__NATIVE_TYPE.equals(feature)
				||	TypesLibraryPackage.Literals.TYPE_INSTANCE__LENGTH.equals(feature)
				||	TypesLibraryPackage.Literals.TYPE_INSTANCE__PRECISION.equals(feature);
		};
		
	};
	
	public DiffContentService() {
		possibleDiffsUnderDBDiff = new HashMap<EClass, Predicate<? super Diff>>();
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.ADD_SCHEMA, ADD_SCHEMA_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.REMOVE_SCHEMA, REMOVE_SCHEMA_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.ALTER_SCHEMA, ALTER_SCHEMA_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.UPDATE_SEQUENCE, UPDATE_SEQUENCE_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.ADD_TABLE, ADD_TABLE_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.ALTER_TABLE, ALTER_TABLE_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.ALTER_VIEW, ALTER_VIEW_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.UPDATE_CONSTRAINT, UPDATE_CONSTRAINT_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.UPDATE_PRIMARY_KEY, UPDATE_PK_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.UPDATE_COLUMN_CHANGE, UPDATE_COLUMN_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.UPDATE_FOREIGN_KEY, UPDATE_FOREIGN_KEY_SUBDIFFS);
		possibleDiffsUnderDBDiff.put(DbevolutionPackage.Literals.UPDATE_INDEX, UPDATE_INDEX_SUBDIFFS);
	}
	
	public boolean handle(Diff diff) {
		return possibleDiffsUnderDBDiff.get(diff.eClass()) != null;
	}
	
	public List<Diff> getSubDiffs(Diff diffParent) {
		Comparison comparison = diffParent.getMatch().getComparison();
		if (comparison != null) {
			return getSubDiffs(diffParent, comparison);
		} else {
			return Collections.emptyList();
		}
	}
	
	public List<Diff> getSubDiffs(Diff diffParent, Comparison comparison) {
		EObject targetValue = getTargetValue(diffParent);
		Match matchOfValue = comparison.getMatch(targetValue);
		if (targetValue != null && matchOfValue != null) {
			return Lists.newArrayList(Iterables.filter(matchOfValue.getAllDifferences(), getSubDiffsPredicate(diffParent)));
		}
		return Collections.emptyList();
	}
	
	public static EObject getTargetValue(Diff diff) {
		if (diff instanceof DBDiff) {
			return ((DBDiff) diff).getTarget();
		} else if (diff instanceof ReferenceChange) {
			return ((ReferenceChange) diff).getValue();
		} else if (diff instanceof ReferenceChange) {
			return ((ReferenceChange) diff).getValue();
		}
		return null;
	}
	
	private Predicate<? super Diff> getSubDiffsPredicate(Diff diff) {
		Predicate<? super Diff> predicate = possibleDiffsUnderDBDiff.get(diff.eClass());
		if (predicate != null) {
			return predicate;
		}
		return alwaysFalse();
	}
	
	private static EStructuralFeature getFeature(Diff diff) {
		if (diff instanceof AttributeChange) {
			return ((AttributeChange) diff).getAttribute();
		} else if (diff instanceof ReferenceChange) {
			return ((ReferenceChange) diff).getReference();
		}
		return null;
	}
	
	/**
	 * It checks if the given difference is about an added or deleted object.<br>
	 * It enables to choose to keep involved differences under an add or delete.
	 * 
	 * @param diff
	 * @return
	 */
	private static boolean isInAddOrDelete(Diff diff) {
		Match match = diff.getMatch();
		Comparison comparison = match.getComparison();
		EObject left = match.getLeft();
		if (left != null) {
			return isInAddOrDelete(comparison, left);
		}
		EObject right = match.getRight();
		if (right != null) {
			return isInAddOrDelete(comparison, right);
		}
		return false;
	}
	
	private static boolean isInAddOrDelete(Comparison comparison, EObject element) {
		Predicate<? super Diff> ofAddOrDeleteKind = or(ofKind(DifferenceKind.ADD), ofKind(DifferenceKind.DELETE));
		return Iterables.any(comparison.getDifferences(element), and(CONTAINMENT_REFERENCE_CHANGE, ofAddOrDeleteKind));
	}
}
