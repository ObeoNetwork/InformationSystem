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
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.dbevolution.AddForeignKey;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveForeignKey;
import org.obeonetwork.dsl.database.dbevolution.UpdateForeignKey;

public class ForeignKeyChangeBuilder extends ChangeBuilder {
	
	public ForeignKeyChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getForeignKey());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return createAddForeignKey((ForeignKey) change.getValue(), change);
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return createRemoveForeignKey((ForeignKey) change.getValue(), change);
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		return createUpdateForeignKey((ForeignKey)change.getRight(), (ForeignKey)change.getLeft(), change);
	}

	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		return null;
	}

	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		return null;
	}

	protected AddForeignKey createAddForeignKey(ForeignKey fk, ReferenceChange change) {
		AddForeignKey addFK = DbevolutionFactory.eINSTANCE.createAddForeignKey();
		addFK.setForeignKey(fk);
		
		fillDBDiff(addFK, change);
		
		return addFK;
	}
	
	protected RemoveForeignKey createRemoveForeignKey(ForeignKey fk, ReferenceChange change) {
		RemoveForeignKey removeFK = DbevolutionFactory.eINSTANCE.createRemoveForeignKey();
		removeFK.setForeignKey(fk);
		
		fillDBDiff(removeFK, change);
		
		return removeFK;
	}

	protected UpdateForeignKey createUpdateForeignKey(ForeignKey fk, ForeignKey newFK, Match match) {
		UpdateForeignKey updateFK = DbevolutionFactory.eINSTANCE.createUpdateForeignKey();
		updateFK.setForeignKey(fk);
		updateFK.setNewForeignKey(newFK);
		
		fillDBDiff(updateFK, match);
		
		return updateFK;
	}
}
