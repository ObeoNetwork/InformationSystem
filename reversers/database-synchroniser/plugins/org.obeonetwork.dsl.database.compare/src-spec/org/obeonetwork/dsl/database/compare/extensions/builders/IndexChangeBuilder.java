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
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.dbevolution.AddIndex;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveIndex;
import org.obeonetwork.dsl.database.dbevolution.UpdateIndex;

public class IndexChangeBuilder extends ChangeBuilder {
	
	public IndexChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getIndex());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return createAddIndex((Table)change.getMatch().getRight(), (Index) change.getValue(), change);
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return createRemoveIndex((Table)change.getMatch().getLeft(), (Index) change.getValue(), change);
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		return createUpdateIndex((Index)change.getRight(), (Index)change.getLeft(), change);
	}

	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		return null;
	}

	protected AddIndex createAddIndex(Table table, Index index, ReferenceChange change) {
		AddIndex addIndex = DbevolutionFactory.eINSTANCE.createAddIndex();
		addIndex.setIndex(index);
		
		fillDBDiff(addIndex, change);
		
		return addIndex;
	}
	
	protected RemoveIndex createRemoveIndex(Table table, Index index, ReferenceChange change) {
		RemoveIndex removeIndex = DbevolutionFactory.eINSTANCE.createRemoveIndex();
		removeIndex.setIndex(index);
		
		fillDBDiff(removeIndex, change);
		
		return removeIndex;
	}
	
	protected UpdateIndex createUpdateIndex(Index index, Index newIndex, Match match) {
		UpdateIndex updateIndex = DbevolutionFactory.eINSTANCE.createUpdateIndex();
		updateIndex.setIndex(index);
		updateIndex.setNewIndex(newIndex);
		
		fillDBDiff(updateIndex, match);
		
		return updateIndex;
	}
}
