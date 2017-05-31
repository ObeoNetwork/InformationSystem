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
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.dbevolution.AddConstraint;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveConstraint;
import org.obeonetwork.dsl.database.dbevolution.UpdateConstraint;

public class ConstraintChangeBuilder extends ChangeBuilder {
	
	public ConstraintChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getConstraint());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return createAddConstraint((Table)change.getMatch().getRight(), (Constraint) change.getValue(), change);
	}
	
	@Override
	protected Diff handleAlterChange(Match change) {
		return createUpdateConstraint(change);
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return createRemoveConstraint((Table)change.getMatch().getLeft(), (Constraint)change.getValue(), change);
	}

	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		// Attributes changes are useless
		// SQL Generation will use the existing Constraint object
		return null;
	}

	protected AddConstraint createAddConstraint(Table table, Constraint constraint, ReferenceChange change) {
		AddConstraint addConstraint = DbevolutionFactory.eINSTANCE.createAddConstraint();
		addConstraint.setConstraint(constraint);
		
		fillDBDiff(addConstraint, change);
		
		return addConstraint;
	}
	
	protected RemoveConstraint createRemoveConstraint(Table table, Constraint constraint, ReferenceChange change) {
		RemoveConstraint removeConstraint = DbevolutionFactory.eINSTANCE.createRemoveConstraint();
		removeConstraint.setConstraint(constraint);
		
		fillDBDiff(removeConstraint, change);
		
		return removeConstraint;
	}

	protected UpdateConstraint createUpdateConstraint(Match change) {
		UpdateConstraint updateConstraint = DbevolutionFactory.eINSTANCE.createUpdateConstraint();
		Constraint constraint = (Constraint)change.getRight();
		updateConstraint.setConstraint(constraint);
		Object leftElement = change.getLeft();
		updateConstraint.setNewConstraint((Constraint)leftElement);
		
		fillDBDiff(updateConstraint, change);
		
		return updateConstraint;
	}
}
