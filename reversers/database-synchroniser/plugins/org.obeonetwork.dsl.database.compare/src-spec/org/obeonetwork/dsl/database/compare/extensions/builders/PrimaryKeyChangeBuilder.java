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

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.AddPrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.UpdatePrimaryKey;

public class PrimaryKeyChangeBuilder extends ChangeBuilder {
	

	public PrimaryKeyChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getPrimaryKey());
	}
	
	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return createAddPrimaryKey((PrimaryKey) change.getValue(), change);
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return createRemovePrimaryKey((PrimaryKey) change.getValue(), change);
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		PrimaryKey oldPk = (PrimaryKey)change.getRight();
		PrimaryKey newPk = (PrimaryKey)change.getLeft();
		return createUpdatePrimaryKey(oldPk, newPk, change);
	}

	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		if (DatabasePackage.eINSTANCE.getPrimaryKey_Columns().equals(change.getReference())) {
			// This change is useless because it has no impact on SQL scripts
			return null;
		}
		return super.handleAlterChange(change);
	}

	protected AddPrimaryKey createAddPrimaryKey(PrimaryKey pk, ReferenceChange change) {
		AddPrimaryKey addPK = DbevolutionFactory.eINSTANCE.createAddPrimaryKey();
		addPK.setPrimaryKey(pk);
		
		fillDBDiff(addPK, change);
		
		return addPK;
	}
	
	protected UpdatePrimaryKey createUpdatePrimaryKey(PrimaryKey oldPk, PrimaryKey newPk, Match match) {
		UpdatePrimaryKey updatePK = DbevolutionFactory.eINSTANCE.createUpdatePrimaryKey();
		updatePK.setPrimaryKey(oldPk);
		updatePK.setNewPrimaryKey(newPk);
		
		fillDBDiff(updatePK, match);
		
		return updatePK;
	}
	
	protected RemovePrimaryKey createRemovePrimaryKey(PrimaryKey pk, ReferenceChange change) {
		RemovePrimaryKey removePK = DbevolutionFactory.eINSTANCE.createRemovePrimaryKey();
		removePK.setPrimaryKey(pk);
		
		fillDBDiff(removePK, change);
		
		return removePK;
	}
	
	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		return null;
	}
}
