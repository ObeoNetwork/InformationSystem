/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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

public class IndexElementChangeBuilder extends ChangeBuilder {
	
	public IndexElementChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getIndexElement());
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