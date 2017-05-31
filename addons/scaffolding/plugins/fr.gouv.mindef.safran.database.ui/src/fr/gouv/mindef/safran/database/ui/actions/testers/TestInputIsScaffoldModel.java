/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.actions.testers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.StructuredSelection;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;

public class TestInputIsScaffoldModel extends AbstractScaffoldingPropertyTester {
	
	private static final String ANY = "ANY";
	
	public TestInputIsScaffoldModel() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection)receiver;
			if (selection.size() == 1) {
				
				Object element = selection.getFirstElement();
				if (args != null && args.length >= 1) {
					String kind = (String)args[0];
					ScaffoldType scaffoldType;
					if (ANY.equals(kind)) {
						scaffoldType = null;
					} else {
						scaffoldType = getCorrespondingScaffoldType(kind);
					}
					
					if (element instanceof Resource) {
						Resource resource = (Resource)element;
						return handleScaffoldModel(resource, scaffoldType);
					} else {
						URI uri = getModelURI(element);
						return handleScaffoldModel(uri, scaffoldType);
					}
				}
			}
		}
		return false;
	}
	
	private boolean handleScaffoldModel(URI modelURI, ScaffoldType scaffoldType) {
		if (modelURI != null && SCAFFOLD_EXTENSION.equals(modelURI.fileExtension())) {
			Resource emfResource = ScaffoldingUtils.getResourceFromSession(modelURI);
			if (emfResource != null) {
				return handleScaffoldModel(emfResource, scaffoldType);
			}
		}
		return false;
	}
	
	private boolean handleScaffoldModel(Resource emfResource, ScaffoldType scaffoldType) {
		if (emfResource.getContents() != null && emfResource.getContents().isEmpty() == false) {
			EObject root = emfResource.getContents().get(0);
			if (root instanceof ScaffoldInfo) {
				ScaffoldInfo scaffoldInfo = (ScaffoldInfo)root;
				if (scaffoldType == null) {
					return true;
				} else {
					return scaffoldInfo.getLeftToRightTransformationType() == scaffoldType
						|| scaffoldInfo.getRightToLeftTransformationType() == scaffoldType;
				}
			}
		}
		return false;
	}

}
