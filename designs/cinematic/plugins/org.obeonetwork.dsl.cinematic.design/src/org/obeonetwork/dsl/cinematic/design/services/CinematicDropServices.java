/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.design.services;

import java.util.Collection;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

public class CinematicDropServices {

	public static boolean isDropAllowedForCinematicElementOn(EObject element, EObject container) {
		EList<EReference> containmentReferences = container.eClass().getEAllContainments();
		for (EReference eReference : containmentReferences) {
			if (eReference.getEType() != null) {
				if (eReference.getEType().isInstance(element)) {
					return true;
				}
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public static EObject dropOnCinematicContainer(EObject element, EObject container) {
		Session session = Session.of(element).orElse(null);
		if (session == null) {
			return null;
		}
		session.getTransactionalEditingDomain().getCommandStack()
				.execute(new RecordingCommand(session.getTransactionalEditingDomain(), "DnD") {

					@Override
					protected void doExecute() {
						// TODO Auto-generated method stub
						if (element instanceof AbstractViewElement && container instanceof ViewContainer) {
							String impacted = CinematicBindingServices.canDropAbstractViewElementIntoViewContainer(
									(AbstractViewElement) element, (ViewContainer) container);
							if (!impacted.isEmpty()) {
								MessageDialog.openWarning(null, "Drop into a ViewContainer",
										"The operation will be cancelled because the parent ViewContainers (below)"
												+ "\n of the element to be moved are involved in a binding that would no longer be valid."
												+ "\n\n" + impacted);
								throw new OperationCanceledException();
								// return element;
							}
						}
						EList<EReference> containmentReferences = container.eClass().getEAllContainments();
						for (EReference eReference : containmentReferences) {
							if (eReference.getEType() != null) {
								if (eReference.getEType().isInstance(element)) {
									// We're going to move the element into this containment feature
									Object oldValues = container.eGet(eReference, true);
									if (oldValues instanceof Collection) {
										((Collection<EObject>) oldValues).add(element);
									}
//									container.eSet(eReference, oldValues);
									// return element;
								}
							}
						}
						// return element;

					}
				});

		return element;
	}
}
