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
package org.obeonetwork.database.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.DataBaseCompareUtil;

public abstract class AbstractGenerateScriptsFromDatabaseHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		// We have to compute an emfdiff file from a comparison with an empty database
		// ---
		TableContainer rootContainer = getFirstTableContainer(selection);
		Comparison comparison = DataBaseCompareUtil.buildFromScratchComparison(rootContainer);

		// The diff model can now be used to generate the SQL script
		if (comparison != null) {
			doGenerate(comparison);
		}

		return null;
	}

	/**
	 * Override to actually to the generation
	 * 
	 * @param comparison the input comparison (not <code>null</code>)
	 */
	protected abstract void doGenerate(Comparison comparison);

	private TableContainer getFirstTableContainer(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IResource) {
				IResource iResource = (IResource) firstElement;
				ResourceSet set = new ResourceSetImpl();
				URI uri = URI.createPlatformResourceURI(iResource.getFullPath().toString(), true);
				Resource resource = set.getResource(uri, true);
				return getFirstTableContainer(resource);
			} else if (firstElement instanceof Resource) {
				return getFirstTableContainer((Resource) firstElement);
			}
		}
		return null;
	}

	private TableContainer getFirstTableContainer(Resource resource) {
		if (resource != null && resource.getContents().isEmpty() == false) {
			for (EObject object : resource.getContents()) {
				if (object instanceof TableContainer) {
					return (TableContainer) object;
				}
			}
		}
		return null;
	}

}
