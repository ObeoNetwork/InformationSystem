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
package org.obeonetwork.dsl.database.compare.extensions.processor;

import java.util.Collection;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.database.compare.extensions.services.DiffContentService;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class DatabasePostProcessor implements IPostProcessor {

	@Override
	public void postMatch(Comparison comparison, Monitor monitor) {
		//PostMatchProcessor.process(comparison);
	}

	@Override
	public void postDiff(Comparison comparison, Monitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postRequirements(Comparison comparison, Monitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEquivalences(Comparison comparison, Monitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postConflicts(Comparison comparison, Monitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postComparison(final Comparison comparison, Monitor monitor) {
		// Create DBDiffs
		new DatabaseDiffExtension().visit(comparison);
		
		// Delete all empty DBDiffs
		final DiffContentService service = new DiffContentService();
		Collection<Diff> toDelete = Collections2.filter(comparison.getDifferences(), new Predicate<Diff>() {
			
			public boolean apply(Diff input) {
				return input instanceof DBDiff && service.getSubDiffs(input, comparison).isEmpty() && input.getRefinedBy().isEmpty();
			}
			
		});
		for (Diff diff : toDelete) {			
			// It could be optimized doing diff.eContainer().eContents().delete(diff) since no object references it.
			EcoreUtil.delete(diff);
		}
	}

}
