/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

public class ForeignKeyElementChangeBuilder extends ChangeBuilder {
	
	public ForeignKeyElementChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getForeignKeyElement());
	}

	@Override
	protected Diff handleAlterChange(Match change) {
		// Sub-diffelements will be contained by the containing change
		return null;
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		return null;
	}
	
	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		return null;
	}
	
	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		return null;
	}
	
	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		return null;
	}
}
