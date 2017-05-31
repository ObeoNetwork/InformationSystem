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
//import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
//import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.dbevolution.AddSequence;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveSequence;
import org.obeonetwork.dsl.database.dbevolution.UpdateSequence;

public class SequenceChangeBuilder extends ChangeBuilder {
	
	public SequenceChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getSequence());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return createAddSequence((TableContainer)change.getMatch().getRight(), (Sequence)change.getValue(), change);
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return createRemoveSequence((TableContainer)change.getMatch().getLeft(), (Sequence)change.getValue(), change);
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		return createUpdateSequence(change);
	}

	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		// The only possible reference change concerns the "columns" reference
		// Association between a sequence and columns is not used for SQL generation
		// thus we ignore this change
		if (DatabasePackage.eINSTANCE.getSequence_Columns().equals(change.getReference())) {
			return null;
		}
		return super.handleAlterChange(change);
	}

	protected AddSequence createAddSequence(TableContainer tableContainer, Sequence sequence, ReferenceChange change) {
		AddSequence addSequence = DbevolutionFactory.eINSTANCE.createAddSequence();
		addSequence.setSequence(sequence);
		
		fillDBDiff(addSequence, change);
		
		return addSequence;
	}
	
	protected RemoveSequence createRemoveSequence(TableContainer tableContainer, Sequence sequence, ReferenceChange change) {
		RemoveSequence removeSequence = DbevolutionFactory.eINSTANCE.createRemoveSequence();
		removeSequence.setSequence(sequence);
		
		fillDBDiff(removeSequence, change);
		
		return removeSequence;
	}
	
	protected UpdateSequence createUpdateSequence(Match change) {
		UpdateSequence updateSequence = DbevolutionFactory.eINSTANCE.createUpdateSequence();
		updateSequence.setSequence((Sequence)change.getRight());
		Object leftElement = change.getLeft();
		updateSequence.setNewSequence((Sequence)leftElement);
		
		fillDBDiff(updateSequence, change);
		
		return updateSequence;
	}
	
	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		return null;
	}
}
