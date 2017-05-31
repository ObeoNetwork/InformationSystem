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

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.ui.util.ScaffoldingUtils;

public class TestMultipleInputIsValid extends AbstractScaffoldingPropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection)receiver;
			if (selection.size() == 2) {
				
				if (args != null && args.length >= 1) {
					String kind = (String)args[0];
					Iterator<?> iterator = selection.iterator();
					Object element1 = iterator.next();
					Object element2 = iterator.next();
					
					ScaffoldType scaffoldType = getCorrespondingScaffoldType(kind);
					return isSelectionValidFor(element1, element2, scaffoldType);
				}
			}
		}
		return false;
	}
	
	private boolean isSelectionValidFor(Object element1, Object element2, ScaffoldType scaffoldType) {
		if (element1 instanceof EObject && element2 instanceof EObject) {
			return internalIsSelectionValidfor((EObject)element1, (EObject)element2, scaffoldType);
		}
		return false;
	}
	
	private boolean internalIsSelectionValidfor(EObject element1, EObject element2, ScaffoldType scaffoldType) {
		// Ensure objects are loaded in the same session
		if (element1.eResource() == null
			|| element2.eResource() == null
			|| element1.eResource().getResourceSet() == null
			|| element2.eResource().getResourceSet() == null
			|| !element1.eResource().getResourceSet().equals(element2.eResource().getResourceSet())) {
			return false;
		}
		
		switch (scaffoldType) {
		case ENTITY_TO_MLD:
		case MLD_TO_ENTITY:
			return (ScaffoldingUtils.isValidInputForEntity(element1) && ScaffoldingUtils.isValidInputForMld(element2))
					|| (ScaffoldingUtils.isValidInputForEntity(element2) && ScaffoldingUtils.isValidInputForMld(element1));
		case MLD_TO_MPD:
		case MPD_TO_MLD:
			return (ScaffoldingUtils.isValidInputForMpd(element1) && ScaffoldingUtils.isValidInputForMld(element2))
					|| (ScaffoldingUtils.isValidInputForMpd(element2) && ScaffoldingUtils.isValidInputForMld(element1));
		}
		return false;
	}

}
