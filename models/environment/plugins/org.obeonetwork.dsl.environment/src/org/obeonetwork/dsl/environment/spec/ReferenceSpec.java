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
package org.obeonetwork.dsl.environment.spec;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.impl.ReferenceImpl;

public class ReferenceSpec extends ReferenceImpl {
	@Override
	public void setReferencedType(StructuredType newType) {
		super.setReferencedType(newType);

		// We check if the oppositeOf is still consistent
		if (getOppositeOf() != null && !newType.eIsProxy()
				&& (newType == null || getOppositeOf().getContainingType() == null || !getOppositeOf().getContainingType().isSubtypeOf(newType))) {
			setOppositeOf(null);
		}
	}

	@Override
	public void setOppositeOf(Reference newOppositeOf) {		
			Reference oldOppositeOf = getOppositeOf();
			super.setOppositeOf(newOppositeOf);

			// If an opposite was specified, we have to unset it
			if (oldOppositeOf != null && (newOppositeOf == null || !newOppositeOf.eIsProxy()) && !oldOppositeOf.equals(newOppositeOf)) {
				oldOppositeOf.setOppositeOf(null);
			}

			// If a new opposite is specified, we have to ensure consistency
			if (newOppositeOf != null && !newOppositeOf.eIsProxy()
					&& (newOppositeOf.getOppositeOf() == null || !newOppositeOf
							.getOppositeOf().equals(this))) {
				newOppositeOf.setOppositeOf(this);
			}
	}

	public void setContainingType(StructuredType newType) {
		if (newType != eInternalContainer()
				|| (eContainerFeatureID() != EnvironmentPackage.REFERENCE__CONTAINING_TYPE && newType != null)) {
			if (EcoreUtil.isAncestor(this, newType))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newType != null) {
				msgs = ((InternalEObject) newType).eInverseAdd(this, EnvironmentPackage.STRUCTURED_TYPE__OWNED_REFERENCES, StructuredType.class, msgs);
			}
			msgs = eBasicSetContainer((InternalEObject) newType, EnvironmentPackage.REFERENCE__CONTAINING_TYPE, msgs);
			if (msgs != null) {
				msgs.dispatch();
			} else {
				// We check if the oppositeOf is still consistent
				if (getOppositeOf() != null
						&& !newType.isSubtypeOf(getOppositeOf().getReferencedType())) {
					setOppositeOf(null);
				}
			}
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnvironmentPackage.REFERENCE__CONTAINING_TYPE, newType, newType));
	}

	public boolean canBeOppositeOf(Reference opposite) {
		return (opposite != null && getContainingType() != null && getReferencedType() != null
				&& opposite.getContainingType() != null && opposite.getReferencedType() != null
				&& getContainingType().isSubtypeOf(opposite.getReferencedType()) && opposite.getContainingType().isSubtypeOf(getReferencedType()));
	}
}
